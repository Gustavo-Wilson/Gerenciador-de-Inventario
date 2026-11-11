package com.projeto.gerenciadorDeInventario.produto.repositorio;

import com.projeto.gerenciadorDeInventario.produto.entidade.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    boolean existsByName(String nome);

}
