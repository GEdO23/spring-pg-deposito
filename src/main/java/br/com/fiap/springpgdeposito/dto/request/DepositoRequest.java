package br.com.fiap.springpgdeposito.dto.request;

public record DepositoRequest(
        String nome,
        EnderecoRequest endereco
) {
}
