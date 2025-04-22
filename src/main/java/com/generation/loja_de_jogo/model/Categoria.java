package com.generation.loja_de_jogo.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Categoria {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String generoJogo;
    private String classificacaoIdade;
    private String plataforma;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Produto> produtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGeneroJogo() {
		return generoJogo;
	}

	public void setGeneroJogo(String generoJogo) {
		this.generoJogo = generoJogo;
	}

	public String getClassificacaoIdade() {
		return classificacaoIdade;
	}

	public void setClassificacaoIdade(String classificacaoIdade) {
		this.classificacaoIdade = classificacaoIdade;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
    
    


}
