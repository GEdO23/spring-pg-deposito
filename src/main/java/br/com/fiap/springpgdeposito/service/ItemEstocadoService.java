package br.com.fiap.springpgdeposito.service;

import br.com.fiap.springpgdeposito.dto.AbstractDTO;
import br.com.fiap.springpgdeposito.dto.request.ItemEstocadoRequest;
import br.com.fiap.springpgdeposito.dto.response.ItemEstocadoResponse;
import br.com.fiap.springpgdeposito.entity.Deposito;
import br.com.fiap.springpgdeposito.entity.ItemEstocado;
import br.com.fiap.springpgdeposito.entity.Produto;
import br.com.fiap.springpgdeposito.repository.ItemEstocadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ItemEstocadoService implements ServiceDTO<ItemEstocado, ItemEstocadoRequest, ItemEstocadoResponse, AbstractDTO>{

    @Autowired
    ItemEstocadoRepository repo;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    DepositoService depositoService;

    @Override
    public ItemEstocado toEntity(ItemEstocadoRequest itemEstocadoRequest) {

        var produto = produtoService.findDatabaseObject(itemEstocadoRequest.produto());
        var deposito = depositoService.findDatabaseObject(itemEstocadoRequest.deposito());

        return ItemEstocado.builder()
                .deposito(deposito)
                .produto(produto)
                .build();
    }

    @Override
    public ItemEstocadoResponse toResponse(ItemEstocado item) {
        if (Objects.isNull(item)) return null;

        var produto = produtoService.toResponse(item.getProduto());
        var deposito = depositoService.toResponse(item.getDeposito());

        return new ItemEstocadoResponse(
                item.getId(),
                item.getNumeroDeSerie(),
                item.getEntrada(),
                item.getSaida(),
                produto,
                deposito
        );
    }

    @Override
    public ItemEstocado findDatabaseObject(AbstractDTO abstractDTO) {
        return repo.findById(abstractDTO.id()).orElse(null);
    }

    @Override
    public ItemEstocado save(ItemEstocadoRequest itemEstocadoRequest) {
        if (Objects.isNull(itemEstocadoRequest)) return null;
        return repo.save(toEntity( itemEstocadoRequest ));
    }

    @Override
    public List<ItemEstocado> findAll() {
        return repo.findAll();
    }

    @Override
    public ItemEstocado findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
