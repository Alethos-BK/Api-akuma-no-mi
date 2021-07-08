package com.onepiece.akumanomi.shared;

import com.onepiece.akumanomi.model.fruta.Categoria;

public class AkumaNoMiDto {
    
    private Long id;

    private String nome;

    private String descricao;

    private String imagemFruta;

    private String imagemUsuario;

    private Double preco;

	private Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoriaId(Categoria categoria) {

		this.categoria = categoria;
	}


    public String getImagemFruta() {
        return imagemFruta;
    }

    public void setImagemFruta(String imagemFruta) {
        this.imagemFruta = imagemFruta;
    }

    public String getImagemUsuario() {
        return imagemUsuario;
    }

    public void setImagemUsuario(String imagemUsuario) {
        this.imagemUsuario = imagemUsuario;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

}
