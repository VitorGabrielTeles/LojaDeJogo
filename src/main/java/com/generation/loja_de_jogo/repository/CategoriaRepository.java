package com.generation.loja_de_jogo.repository;

import com.generation.loja_de_jogo.model.Categoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	List<Categoria> findBygeneroJogoIgnoreCase(String generoJogo);
}