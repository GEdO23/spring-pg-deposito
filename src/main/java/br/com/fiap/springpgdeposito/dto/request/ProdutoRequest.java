package br.com.fiap.springpgdeposito.dto.request;

import java.math.BigDecimal;

public record ProdutoRequest(
        String nome,
        String descricao,
        BigDecimal valor
) {
}
