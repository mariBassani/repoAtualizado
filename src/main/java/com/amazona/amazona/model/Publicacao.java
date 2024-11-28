package com.amazona.amazona.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Publicacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPublicacao;
    private String data;
    private String url;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuariaFk")
    @JsonBackReference
    private Usuaria usuaria;



    // Construtores, getters e setters

    public Publicacao() {}

    public Publicacao(Long idPublicacao, String data, String url, String descricao) {
        this.idPublicacao = idPublicacao;
        this.data = data;
        this.url = url;
        this.descricao = descricao;
    }

    public Long getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(Long idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuaria getUsuaria() {
        return usuaria;
    }

    public void setUsuaria(Usuaria usuaria) {
        this.usuaria = usuaria;
    }

    @Override
    public String toString() {
        return "Publicacao [idPublicacao=" + idPublicacao + ", data=" + data + ", url=" + url + ", descricao=" + descricao
                + ", usuaria=" + usuaria + "]";
    }
}
