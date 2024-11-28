package com.amazona.amazona.model;
import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.*;


@Entity
public class Publicacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPublicacao;
    private String data;

    @Column(nullable = false)
    private String url;
    private String descricao;

    public Publicacao(){
    }

    // @ManyToOne
    // //@JsonIgnore
    // @JoinColumn(name = "usuaria_id")
    // private Usuaria usuaria;


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

    @Override
    public String toString() {
        return "data=" + data + ", url=" + url + ", descricao=" + descricao + "]";
    }

    
}
