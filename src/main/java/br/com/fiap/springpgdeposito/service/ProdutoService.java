package br.com.fiap.springpgdeposito.service;

import br.com.fiap.springpgdeposito.dto.request.ProdutoRequest;
import br.com.fiap.springpgdeposito.dto.response.ProdutoResponse;
import br.com.fiap.springpgdeposito.entity.Produto;
import br.com.fiap.springpgdeposito.dto.AbstractDTO;
import br.com.fiap.springpgdeposito.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProdutoService implements ServiceDTO<Produto, ProdutoRequest, ProdutoResponse, AbstractDTO>  {

    @Autowired
    ProdutoRepository repo;

    @Override
    public Produto toEntity(ProdutoRequest produtoRequest) {
        return Produto.builder()
                .nome(produtoRequest.nome())
                .descricao(produtoRequest.descricao())
                .valor(produtoRequest.valor())
                .build();
    }

    @Override
    public ProdutoResponse toResponse(Produto produto) {
        if(Objects.isNull( produto )) return null;
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getValor()
        );
    }

    @Override
    public Produto findDatabaseObject(AbstractDTO abstractDTO) {
        if (Objects.isNull(abstractDTO)) return null;
        return repo.findById(abstractDTO.id()).orElse(null);
    }

    @Override
    public Produto save(ProdutoRequest produtoRequest) {
        if (Objects.isNull(produtoRequest)) return null;
        return repo.save( toEntity(produtoRequest) );
    }

    @Override
    public List<Produto> findAll() {
        return repo.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
