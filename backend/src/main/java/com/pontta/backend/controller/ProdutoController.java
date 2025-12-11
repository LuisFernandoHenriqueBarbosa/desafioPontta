package com.pontta.backend.controller;

import com.pontta.backend.model.ProdutoModel;
import com.pontta.backend.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private ProdutoService produtoService;

    public  ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoModel cadastrar(@Valid @RequestBody ProdutoModel produto){
        return produtoService.cadastrar(produto);
    }

    @GetMapping
    public List<ProdutoModel> listar(){
        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public ProdutoModel buscaPorId(@PathVariable Long id){
        return produtoService.buscaPorId(id);
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizar(@Valid @PathVariable Long id, @Valid @RequestBody ProdutoModel produto){
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        produtoService.excluir(id);
    }
}
