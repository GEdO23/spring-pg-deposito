package br.com.fiap.springpgdeposito.dto.response;

import java.time.LocalDateTime;

public record ItemEstocadoResponse(
        Long id,
        String numeroDeSerie,
        LocalDateTime entrada,
        LocalDateTime saida,
        ProdutoResponse produto,
        DepositoResponse deposito
) {
}
