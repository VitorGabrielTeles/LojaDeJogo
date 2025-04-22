package com.generation.loja_de_jogo.repository;
import com.generation.loja_de_jogo.model.Produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findBynomeJogoContainingIgnoreCase(String nomeJogo);
}
