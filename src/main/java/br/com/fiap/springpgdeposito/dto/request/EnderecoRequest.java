package br.com.fiap.springpgdeposito.dto.request;

public record EnderecoRequest(
        String cep,
        String numero,
        String complemento
) {
}
