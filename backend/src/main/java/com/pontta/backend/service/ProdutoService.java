package com.pontta.backend.service;

import com.pontta.backend.model.ProdutoModel;
import com.pontta.backend.model.ProdutoModel;
import com.pontta.backend.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoModel cadastrar(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> listar() {
        return produtoRepository.findAll();
    }

    public ProdutoModel buscaPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produto){
        ProdutoModel existe=buscaPorId(id);

        existe.setDescricao(produto.getDescricao());
        existe.setPreco(produto.getPreco());
        return produtoRepository.save(existe);
    }

    public void excluir(Long id){
        produtoRepository.deleteById(id);
    }
}
