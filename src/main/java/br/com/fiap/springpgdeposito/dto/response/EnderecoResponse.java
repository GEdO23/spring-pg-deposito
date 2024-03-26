package br.com.fiap.springpgdeposito.dto.response;

public record EnderecoResponse(
        Long id,
        String cep,
        String numero,
        String complemento
) {
}
