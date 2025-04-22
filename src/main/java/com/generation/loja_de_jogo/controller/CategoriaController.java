package com.generation.loja_de_jogo.controller;

import com.generation.loja_de_jogo.model.Categoria;
import com.generation.loja_de_jogo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id) {
        return categoriaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaRepository.findById(id)
                .map(c -> {
                    c.setGeneroJogo(categoria.getGeneroJogo());
                    c.setClassificacaoIdade(categoria.getClassificacaoIdade());
                    c.setPlataforma(categoria.getPlataforma());
                    return ResponseEntity.ok(categoriaRepository.save(c));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return categoriaRepository.findById(id).map(c -> {
            categoriaRepository.delete(c);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/categoria/genero/{genero}")
    public List<Categoria> getByGenero(@PathVariable String generoJogo) {
        return categoriaRepository.findBygeneroJogoIgnoreCase(generoJogo);
    }

}
