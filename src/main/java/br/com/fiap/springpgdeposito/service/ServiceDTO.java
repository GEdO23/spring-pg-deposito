package br.com.fiap.springpgdeposito.service;

import br.com.fiap.springpgdeposito.dto.AbstractDTO;
import br.com.fiap.springpgdeposito.entity.Endereco;

import java.util.List;

/**
 *
 * @param <Entity> Classe que contem a anotação @Entity
 * @param <Request> Um DTO de Request
 * @param <Response> Um DTO de Response
 * @param <AbstractDTO> Um DTO que tenha o ID
 */

public interface ServiceDTO<Entity, Request, Response, AbstractDTO> {
    Entity toEntity(Request request);

    Response toResponse(Entity entity);

    Entity findDatabaseObject(AbstractDTO abstractDTO);

    Entity findDatabaseObject(br.com.fiap.springpgdeposito.dto.AbstractDTO abstractDTO);

    Entity save(Request request);

    List<Entity> findAll();

    Entity findById(Long id);
}
