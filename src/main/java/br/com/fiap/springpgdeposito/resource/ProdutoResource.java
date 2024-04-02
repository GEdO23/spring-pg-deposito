package br.com.fiap.springpgdeposito.resource;

import br.com.fiap.springpgdeposito.dto.request.ProdutoRequest;
import br.com.fiap.springpgdeposito.dto.response.ProdutoResponse;
import br.com.fiap.springpgdeposito.service.ProdutoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoResponse> findAll() {
        return service.findAll().
                stream().
                map(service::toResponse).
                toList();
    }

    // SE MANDOU COMO ENTIDADE TA ERRADO
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable(name = "id") Long id) {
        ProdutoResponse response = service.toResponse(service.findById( id ));
        if (Objects.isNull( response )) return ResponseEntity.notFound().build();
        return ResponseEntity.ok( response );
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoResponse> persist(@RequestBody ProdutoRequest request) {
        ProdutoResponse response = service.toResponse(service.save(request));
        if (Objects.isNull(response)) return ResponseEntity.badRequest().build();

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(uri).body( response );
    }
}
