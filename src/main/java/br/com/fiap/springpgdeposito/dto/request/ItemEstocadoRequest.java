package br.com.fiap.springpgdeposito.dto.request;

import br.com.fiap.springpgdeposito.dto.AbstractDTO;

public record ItemEstocadoRequest(
        AbstractDTO produto,
        AbstractDTO deposito
) {
}
