package com.amazona.amazona.model;

//import java.util.List;

//import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Publicacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPublicacao;
    private String data;

    @Column(nullable = false)
    private String url;
    private String desc;

    public Publicacao(){
        
    }

    @ManyToOne
    //@JsonIgnore
    @JoinColumn(name = "usuariaFk")
    private Usuaria usuaria;


    public Publicacao(Long idPublicacao, String data, String url, String desc) {
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

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Publicacao [idPublicacao=" + idPublicacao + ", data=" + data + ", url=" + url + ", desc=" + desc
                + ", usuaria=" + usuaria + "]";
    }
}
