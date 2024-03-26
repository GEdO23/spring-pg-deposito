package br.com.fiap.springpgdeposito.dto.response;

import br.com.fiap.springpgdeposito.dto.request.EnderecoRequest;

public record DepositoResponse(
        Long id,
        String nome,
        EnderecoResponse endereco
) {
}
