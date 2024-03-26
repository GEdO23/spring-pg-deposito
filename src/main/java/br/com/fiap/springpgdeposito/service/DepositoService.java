package br.com.fiap.springpgdeposito.service;

import br.com.fiap.springpgdeposito.dto.AbstractDTO;
import br.com.fiap.springpgdeposito.dto.request.DepositoRequest;
import br.com.fiap.springpgdeposito.dto.response.DepositoResponse;
import br.com.fiap.springpgdeposito.entity.Deposito;
import br.com.fiap.springpgdeposito.repository.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepositoService implements ServiceDTO<Deposito, DepositoRequest, DepositoResponse, AbstractDTO> {

    @Autowired
    EnderecoService enderecoService;

    @Autowired
    DepositoRepository repo;

    @Override
    public Deposito toEntity(DepositoRequest depositoRequest) {
        return Deposito.builder()
                .nome(depositoRequest.nome())
                .endereco(enderecoService.toEntity(depositoRequest.endereco()))
                .build();
    }

    @Override
    public DepositoResponse toResponse(Deposito deposito) {
        return new DepositoResponse(deposito.getId(), deposito.getNome(), enderecoService.toResponse(deposito.getEndereco()));
    }

    @Override
    public Deposito findDatabaseObject(AbstractDTO abstractDTO) {
        return repo.findById(abstractDTO.id()).orElse(null);
    }

    @Override
    public Deposito save(DepositoRequest depositoRequest) {
        return repo.save(toEntity(depositoRequest));
    }

    @Override
    public List<Deposito> findAll() {
        return repo.findAll();
    }

    @Override
    public Deposito findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
