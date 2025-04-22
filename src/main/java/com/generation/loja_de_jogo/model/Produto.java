package com.generation.loja_de_jogo.model;
import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
public class Produto {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nomeJogo;
	    private BigDecimal preco;

	    @ManyToOne
	   // @OneToMany(mappedBy = "categoria")
	    @JoinColumn(name = "categoria")
	    private Categoria categoria;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNomeJogo() {
			return nomeJogo;
		}

		public void setNomeJogo(String nomeJogo) {
			this.nomeJogo = nomeJogo;
		}

		public BigDecimal getPreco() {
			return preco;
		}

		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}
	    
	    

}
