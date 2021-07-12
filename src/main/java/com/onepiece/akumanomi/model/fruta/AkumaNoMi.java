package com.onepiece.akumanomi.model.fruta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AkumaNoMi {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    private String imagemFruta;

    private String imagemUsuario;

    private Double preco;

    @ManyToOne()
	@JoinColumn(name = "categoriaId")
	private Categoria categoria;

    public AkumaNoMi() {
    }

    public AkumaNoMi(String nome, String descricao, String imagemFruta, String imagemUsuario, Double preco,
            Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagemFruta = imagemFruta;
        this.imagemUsuario = imagemUsuario;
        this.preco = preco;
        this.categoria = categoria;
    }

    public AkumaNoMi(Long id, String nome, String descricao, String imagemFruta, String imagemUsuario, Double preco,
            Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagemFruta = imagemFruta;
        this.imagemUsuario = imagemUsuario;
        this.preco = preco;
        this.categoria = categoria;
    }

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
