package br.com.fiap.springpgdeposito.dto.response;

import java.math.BigDecimal;

public record ProdutoResponse(
        Long id,
        String nome,
        String descricao,
        BigDecimal valor
) {
}
