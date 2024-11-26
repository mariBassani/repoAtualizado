package com.amazona.amazona.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String desc;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuariaFk")
    private Usuaria usuaria;


    public Publicacao(Long idPublicacao, String data, String url, String desc) {
        this.idPublicacao = idPublicacao;
        this.data = data;
        this.url = url;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    
}
