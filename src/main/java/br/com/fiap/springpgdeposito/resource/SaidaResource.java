package br.com.fiap.springpgdeposito.resource;

import br.com.fiap.springpgdeposito.dto.AbstractDTO;
import br.com.fiap.springpgdeposito.dto.SaidaDTO;
import br.com.fiap.springpgdeposito.dto.response.ItemEstocadoResponse;
import br.com.fiap.springpgdeposito.entity.ItemEstocado;
import br.com.fiap.springpgdeposito.repository.ItemEstocadoRepository;
import br.com.fiap.springpgdeposito.service.DepositoService;
import br.com.fiap.springpgdeposito.service.ItemEstocadoService;
import br.com.fiap.springpgdeposito.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping(value = "/saida")
public class SaidaResource {

    @Autowired
    private ItemEstocadoService service;

    @Autowired
    private DepositoService depositoService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemEstocadoRepository repo;

    @Transactional
    @PostMapping(value = "/deposito/{idDeposito}/produto/{idProduto}")
    public  List<ItemEstocadoResponse> entrada(
            @PathVariable Long idDeposito,
            @PathVariable Long idProduto,
            @RequestBody SaidaDTO saida
    ) {

        if (Objects.isNull( saida ) || saida.quantidade() < 1 ) return null;
        Integer i = 0;

        var produto = new AbstractDTO(idProduto);
        var deposito = new AbstractDTO(idDeposito);

        List<ItemEstocado> estocados = repo.findByProdutoAndDepositoAndSaidaIsNull(
                produtoService.findDatabaseObject(produto),
                depositoService.findDatabaseObject(deposito)
        );

        List<ItemEstocado> saiu = new ArrayList<>();

        if (estocados.size() < saida.quantidade()) return null;

        while (saida.quantidade() > i) {
            estocados.get(i).setSaida(LocalDateTime.now());
            saiu.add(estocados.get(i));
            i++;
        }

        return saiu.stream().map(service::toResponse).toList();
    }
}
