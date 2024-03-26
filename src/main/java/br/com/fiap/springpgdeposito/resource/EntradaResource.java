package br.com.fiap.springpgdeposito.resource;

import br.com.fiap.springpgdeposito.dto.EntradaDTO;
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
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.Vector;

@RestController
@RequestMapping(value = "/entrada")
public class EntradaResource {

    @Autowired
    private DepositoRepository depositoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemEstocadoRepository itemEstocadoRepository;

    @Transactional
    @PostMapping(value = "/deposito/{idDeposito}/produto/{idProduto}")
    public List<ItemEstocado> entrada(@PathVariable Long idDeposito, @PathVariable long idProduto, @RequestBody EntradaDTO entrada) {

        Deposito deposito = depositoRepository.findById( idDeposito ).orElseThrow();

        Produto produto = produtoRepository.findById( idProduto ).orElseThrow();

        if (Objects.isNull( entrada ) || entrada.quantidade() < 1) return  null;

        Long i = 0L;
        List<ItemEstocado> estocados = new Vector<>();

        while (entrada.quantidade() > i) {

            ItemEstocado itemEstocado = ItemEstocado.builder()
                    .entrada( LocalDateTime.now() )
                    .numeroDeSerie( UUID.randomUUID().toString() )
                    .deposito( deposito )
                    .produto( produto )
                    .build();

            estocados.add( itemEstocadoRepository.save( itemEstocado ) );

            i++;
        }

        return estocados;
    }
}
