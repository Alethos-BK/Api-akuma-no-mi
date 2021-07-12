package com.onepiece.akumanomi.model;

import java.text.DecimalFormat;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.onepiece.akumanomi.model.fruta.AkumaNoMi;

@Entity
public class Carrinho {
    
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private Double valorTotalDopedido;
    
    @ManyToMany
    @JoinTable(name = "carrinho_akuma", joinColumns = @JoinColumn(name = "carrinhoId"), inverseJoinColumns = @JoinColumn(name= "frutaId"))
    private List<AkumaNoMi> listaFrutas;

    public Carrinho() {
    }

    public Carrinho(String email, Double valorTotalDopedido, List<AkumaNoMi> listaFrutas) {
        this.email = email;
        this.valorTotalDopedido = valorTotalDopedido;
        this.listaFrutas = listaFrutas;
    }

    public Carrinho(Long id, String email, Double valorTotalDopedido, List<AkumaNoMi> listaFrutas) {
        this.id = id;
        this.email = email;
        this.valorTotalDopedido = valorTotalDopedido;
        this.listaFrutas = listaFrutas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getValorTotalDopedido() {
        return valorTotalDopedido;
    }

    public void setValorTotalDopedido(Double valorTotalDopedido) {
        this.valorTotalDopedido = valorTotalDopedido;
    }

    public List<AkumaNoMi> getListaFrutas() {
        return listaFrutas;
    }

    public void setListaFrutas(List<AkumaNoMi> listaFrutas) {
        this.listaFrutas = listaFrutas;
    }

    public Double calcularValorTotal(){

        for (AkumaNoMi akumaNoMi : listaFrutas) {
            this.valorTotalDopedido += akumaNoMi.getPreco();
        }

		new DecimalFormat("#, ##0.00").format(this.valorTotalDopedido);
        
        return this.valorTotalDopedido;
        
    }

}
