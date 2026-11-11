package com.projeto.gerenciadorDeInventario.produto.service;

import com.projeto.gerenciadorDeInventario.produto.dto.ProdutoCreateRequest;
import com.projeto.gerenciadorDeInventario.produto.dto.ProdutoResponse;
import com.projeto.gerenciadorDeInventario.produto.entidade.Produto;
import com.projeto.gerenciadorDeInventario.produto.repositorio.ProdutoRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //  TODO: Adicionar uma extenção que mapeia código em tempo de execução ( como o mapstruct )
    public ProdutoResponse create(ProdutoCreateRequest request) {

        if (produtoRepository.existsByName(request.nome())){
            throw new EntityExistsException("Produto ja criado");
        }

        // ProdutoCreateRequest to Produto
        Produto produto = new Produto();

        produto.setNome(request.nome());
        produto.setPreco(request.preco());
        produto.setQuantidade(request.quantidade());

        Produto saved = produtoRepository.save(produto);

        // Produto to ProdutoResponse
        ProdutoResponse response = new ProdutoResponse(
                saved.getId(),
                saved.getNome(),
                saved.getPreco(),
                saved.getQuantidade()
        );

        return response;

    }

}
