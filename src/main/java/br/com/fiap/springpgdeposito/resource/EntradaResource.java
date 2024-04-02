package br.com.fiap.springpgdeposito.resource;

import br.com.fiap.springpgdeposito.dto.AbstractDTO;
import br.com.fiap.springpgdeposito.dto.EntradaDTO;
import br.com.fiap.springpgdeposito.dto.request.ItemEstocadoRequest;
import br.com.fiap.springpgdeposito.dto.response.ItemEstocadoResponse;
import br.com.fiap.springpgdeposito.entity.Deposito;
import br.com.fiap.springpgdeposito.entity.ItemEstocado;
import br.com.fiap.springpgdeposito.entity.Produto;
import br.com.fiap.springpgdeposito.repository.DepositoRepository;
import br.com.fiap.springpgdeposito.repository.ItemEstocadoRepository;
import br.com.fiap.springpgdeposito.repository.ProdutoRepository;
import br.com.fiap.springpgdeposito.service.DepositoService;
import br.com.fiap.springpgdeposito.service.ItemEstocadoService;
import br.com.fiap.springpgdeposito.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.Vector;

@RestController
@RequestMapping(value = "/entrada")
public class EntradaResource {

    @Autowired
    private ItemEstocadoService service;

    @Transactional
    @PostMapping(value = "/deposito/{idDeposito}/produto/{idProduto}")
    public List<ItemEstocadoResponse> entrada(
            @PathVariable Long idDeposito,
            @PathVariable Long idProduto,
            @RequestBody EntradaDTO entrada
    ) {

        if (Objects.isNull( entrada ) || entrada.quantidade() < 1) return  null;

        Long i = 0L;
        List<ItemEstocado> estocados = new Vector<>();

        while (entrada.quantidade() > i) {

            var produto = new AbstractDTO(idProduto);
            var deposito = new AbstractDTO(idDeposito);

            ItemEstocadoRequest itemEstocado = new ItemEstocadoRequest(
                    produto,
                    deposito
            );

            ItemEstocado saved = service.save(itemEstocado);
            saved.setEntrada(LocalDateTime.now());
            saved.setNumeroDeSerie( UUID.randomUUID().toString() );
            estocados.add(saved);

            i++;
        }

        return estocados.stream().map(service::toResponse).toList();
    }
}
