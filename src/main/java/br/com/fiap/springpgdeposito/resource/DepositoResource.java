package br.com.fiap.springpgdeposito.resource;

import br.com.fiap.springpgdeposito.entity.Deposito;
import br.com.fiap.springpgdeposito.repository.DepositoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/deposito")
public class DepositoResource {

    @Autowired
    private DepositoRepository repository;

    @GetMapping
    public List<Deposito> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Deposito> findById(@PathVariable(name = "id") Long id) {

        Deposito deposito = repository.findById( id ).orElse( null );

        if (Objects.isNull( deposito )) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok( deposito );

    }


    @PostMapping
    @Transactional
    public ResponseEntity<Deposito> persist(@RequestBody Deposito deposito) {
        Deposito saved = repository.save( deposito );
        return ResponseEntity.ok( saved );
    }
}
