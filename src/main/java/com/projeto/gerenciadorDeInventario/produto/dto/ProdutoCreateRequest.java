package com.projeto.gerenciadorDeInventario.produto.dto;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProdutoCreateRequest(
        @NotNull String nome,
        @NotNull @PositiveOrZero BigDecimal preco,
        @NotNull @PositiveOrZero int quantidade
) {}
