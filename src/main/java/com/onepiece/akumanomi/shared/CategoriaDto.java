package com.onepiece.akumanomi.shared;

public class CategoriaDto {

    private Long id;

    private String tipo;

    private String descricao;

    public CategoriaDto(){

    }

    public CategoriaDto(String tipo, String descricao){

        this.tipo = tipo;
        this.descricao = descricao;
    }

    public CategoriaDto(Long id, String tipo, String descricao){

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
