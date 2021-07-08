package com.onepiece.akumanomi.model.fruta;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//TODO: ver pq ta dando ruim

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue
    private Long id;

    private String tipo;

    private String descricao;

    @OneToMany(mappedBy = "categoria")
	private List<AkumaNoMi> frutas;

    public Categoria(){

    }

    public Categoria(String tipo, String descricao){

        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Categoria(Long id, String tipo, String descricao){

        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
