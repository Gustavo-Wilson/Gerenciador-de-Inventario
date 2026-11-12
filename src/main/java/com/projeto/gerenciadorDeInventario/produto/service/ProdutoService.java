package com.projeto.gerenciadorDeInventario.produto.service;

import com.projeto.gerenciadorDeInventario.produto.dto.ProdutoCreateRequest;
import com.projeto.gerenciadorDeInventario.produto.dto.ProdutoResponse;
import com.projeto.gerenciadorDeInventario.produto.dto.ProdutoUpdateRequest;
import com.projeto.gerenciadorDeInventario.produto.entidade.Produto;
import com.projeto.gerenciadorDeInventario.produto.repositorio.ProdutoRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // TODO: Add an extension that map the code in compile time ( as mapstruct )
    public ProdutoResponse create(ProdutoCreateRequest request) {

        if (produtoRepository.existsByName(request.nome())){
            throw new EntityExistsException("Product already created");
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

    // TODO: Add an extension that map the code in compile time ( as mapstruct )
    public ProdutoResponse update(Integer id, ProdutoUpdateRequest request) {
        Produto produto = produtoRepository.findById(id).
                orElseThrow(
                        () -> new EntityNotFoundException("product not found")
                );

        if (request.nome() != null){
            if (request.nome().isEmpty()){
                throw new IllegalArgumentException("The name of the product cannot be empty");
            }
            produto.setNome(request.nome());
        }

        if (request.preco() != null){
            produto.setPreco(request.preco());
        }

        ProdutoResponse response = new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getQuantidade());

        return response;

    }

}
