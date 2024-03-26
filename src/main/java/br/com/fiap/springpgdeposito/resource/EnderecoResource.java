package br.com.fiap.springpgdeposito.resource;


import br.com.fiap.springpgdeposito.dto.request.EnderecoRequest;
import br.com.fiap.springpgdeposito.dto.response.EnderecoResponse;
import br.com.fiap.springpgdeposito.entity.Endereco;
import br.com.fiap.springpgdeposito.service.EnderecoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public List<EnderecoResponse> findAll() {
        return service.findAll().stream().map(service::toResponse).toList();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoResponse> findById(@PathVariable(name = "id") Long id) {
        EnderecoResponse response = service.toResponse(service.findById( id ));
        if (Objects.isNull( response )) return ResponseEntity.notFound().build();
        return ResponseEntity.ok( response );
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EnderecoResponse> save(@RequestBody EnderecoRequest e) {
        EnderecoResponse response = service.toResponse(service.save(e));
        if (Objects.isNull(response)) return ResponseEntity.badRequest().build();

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created( uri ).body( response );
    }
}
