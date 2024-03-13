package br.com.fiap.springpgdeposito.resource;

import br.com.fiap.springpgdeposito.entity.Endereco;
import br.com.fiap.springpgdeposito.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoRepository repository;

    @GetMapping
    public List<Endereco> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable(name = "id") Long id) {

        Endereco endereco = repository.findById( id ).orElse( null );

        if (Objects.isNull( endereco )) return ResponseEntity.notFound().build();

        return ResponseEntity.ok( endereco );

    }


    @PostMapping
    @Transactional
    public ResponseEntity<Endereco> persist(@RequestBody Endereco endereco) {
        Endereco saved = repository.save( endereco );
        return ResponseEntity.ok( saved );
    }
}
