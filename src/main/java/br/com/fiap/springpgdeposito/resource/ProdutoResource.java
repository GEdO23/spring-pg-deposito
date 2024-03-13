package br.com.fiap.springpgdeposito.resource;

import br.com.fiap.springpgdeposito.entity.Produto;
import br.com.fiap.springpgdeposito.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable(name = "id") Long id) {

        Produto produto = repository.findById( id ).orElse( null );

        if (Objects.isNull( produto )) return ResponseEntity.notFound().build();

        return ResponseEntity.ok( produto );
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Produto> persist(@RequestBody Produto produto) {
        Produto saved = repository.save( produto );
        return ResponseEntity.ok( saved );
    }
}
