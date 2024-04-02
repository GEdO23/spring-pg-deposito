package br.com.fiap.springpgdeposito.resource;

import br.com.fiap.springpgdeposito.dto.request.DepositoRequest;
import br.com.fiap.springpgdeposito.dto.response.DepositoResponse;
import br.com.fiap.springpgdeposito.entity.Deposito;
import br.com.fiap.springpgdeposito.service.DepositoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/deposito")
public class DepositoResource {

    @Autowired
    private DepositoService service;

    @GetMapping
    public List<DepositoResponse> findAll() {
        return service.findAll().
                stream().
                map(service::toResponse).
                toList();
    }

    @GetMapping(value = "/{id}")
    public DepositoResponse findById(@PathVariable(name = "id") Long id) {
        return service.toResponse(service.findById( id ));
    }

//    @PostMapping
//    @Transactional
//    public DepositoResponse persist(@RequestBody DepositoRequest request) {
//
//    }
}
