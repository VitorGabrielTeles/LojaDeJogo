package com.generation.loja_de_jogo.controller;

import com.generation.loja_de_jogo.model.Produto;
import com.generation.loja_de_jogo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoRepository.findById(id)
                .map(p -> {
                    p.setNomeJogo(produto.getNomeJogo());
                    p.setPreco(produto.getPreco());
                    p.setCategoria(produto.getCategoria());
                    return ResponseEntity.ok(produtoRepository.save(p));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return produtoRepository.findById(id).map(p -> {
            produtoRepository.delete(p);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/nome/{nomeJogo}")
    public ResponseEntity<List<Produto>> getByNomeJogo(@PathVariable String nomeJogo) {
        return ResponseEntity.ok(produtoRepository.findBynomeJogoContainingIgnoreCase(nomeJogo));
    }
}