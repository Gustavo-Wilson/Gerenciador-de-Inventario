package com.projeto.gerenciadorDeInventario.produto.controller;

import com.projeto.gerenciadorDeInventario.produto.dto.ProdutoCreateRequest;
import com.projeto.gerenciadorDeInventario.produto.dto.ProdutoResponse;
import com.projeto.gerenciadorDeInventario.produto.dto.ProdutoUpdateRequest;
import com.projeto.gerenciadorDeInventario.produto.entidade.Produto;
import com.projeto.gerenciadorDeInventario.produto.repositorio.ProdutoRepository;
import com.projeto.gerenciadorDeInventario.produto.service.ProdutoService;
import jakarta.persistence.EntityExistsException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody ProdutoCreateRequest request){
        try {
            ProdutoResponse response = produtoService.create(request);
            URI uri =  ServletUriComponentsBuilder.
                    fromCurrentRequest().
                    path("/{id}").
                    buildAndExpand(response.id()).
                    toUri();
            return ResponseEntity.created(uri).body(response);
        } catch(EntityExistsException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, ProdutoUpdateRequest request){
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable Integer id){
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll(){
        return ResponseEntity.ok().build();
    }


}
