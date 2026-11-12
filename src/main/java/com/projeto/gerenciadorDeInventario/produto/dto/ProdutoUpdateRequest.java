package com.projeto.gerenciadorDeInventario.produto.dto;

import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProdutoUpdateRequest(
        String nome,
        @PositiveOrZero BigDecimal preco
) {}
