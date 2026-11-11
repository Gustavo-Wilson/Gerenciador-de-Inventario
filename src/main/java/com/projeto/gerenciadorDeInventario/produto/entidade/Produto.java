package com.projeto.gerenciadorDeInventario.produto.entidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "nome" ,nullable = false, length = 100)
    String nome;

    @Column(name = "preco", nullable = false, scale = 2)
    BigDecimal preco;

    @Column(name = "quantidade", nullable = false)
    int quantidade;

}
