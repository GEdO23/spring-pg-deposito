package br.com.fiap.springpgdeposito.resource;

import br.com.fiap.springpgdeposito.dto.EntradaDTO;
import br.com.fiap.springpgdeposito.dto.SaidaDTO;
import br.com.fiap.springpgdeposito.entity.Deposito;
import br.com.fiap.springpgdeposito.entity.ItemEstocado;
import br.com.fiap.springpgdeposito.entity.Produto;
import br.com.fiap.springpgdeposito.repository.DepositoRepository;
import br.com.fiap.springpgdeposito.repository.ItemEstocadoRepository;
import br.com.fiap.springpgdeposito.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping(value = "/saida")
public class SaidaResource {

    @Autowired
    private DepositoRepository depositoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemEstocadoRepository itemEstocadoRepository;

    @Transactional
    @PostMapping(value = "/deposito/{idDeposito}/produto/{idProduto}")
    public List<ItemEstocado> entrada(@PathVariable Long idDeposito, @PathVariable long idProduto, @RequestBody SaidaDTO saida) {

        Deposito deposito = depositoRepository.findById(idDeposito).orElseThrow();

        Produto produto = produtoRepository.findById(idProduto).orElseThrow();

        if (Objects.isNull( saida ) || saida.quantidade() < 1) return null;

        Integer i = 0;

        List<ItemEstocado> estocados = itemEstocadoRepository.findByProdutoAndDepositoAndSaidaIsNull( produto, deposito );

        List<ItemEstocado> saiu = new ArrayList<>();

        while (saida.quantidade() > i) {
            estocados.get( i ).setSaida( LocalDateTime.now() );
            saiu.add( estocados.get( i ) );
            i++;
        }

        return saiu;
    }
}
