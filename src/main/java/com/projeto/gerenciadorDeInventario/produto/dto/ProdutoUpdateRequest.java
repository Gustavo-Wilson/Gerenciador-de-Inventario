package com.projeto.gerenciadorDeInventario.produto.dto;

import java.math.BigDecimal;

public record ProdutoUpdateRequest(
        String nome,
        BigDecimal preco
) {}
