package com.projeto.gerenciadorDeInventario.produto.dto;

import java.math.BigDecimal;

public record ProdutoResponse(
        Integer id,
        String nome,
        BigDecimal preco,
        int quantidade
) {}
