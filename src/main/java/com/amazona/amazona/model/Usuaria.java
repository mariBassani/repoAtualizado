package com.amazona.amazona.model;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Usuaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuaria;
    private String nome;
    private String cpf;
    private int idade;
    private boolean assinante;

    public Usuaria() {
    }

    @OneToMany(mappedBy = "usuaria")
    private List<Publicacao> idPublicacao;

    public Usuaria(Long idUsuaria, String nome, String cpf, int idade, boolean assinante) {
        this.idUsuaria = idUsuaria;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.assinante = assinante;

    }

    public Long getIdUsuaria() {
        return idUsuaria;
    }
    public void setIdUsuaria(Long idUsuaria) {
        this.idUsuaria = idUsuaria;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public boolean getAssinante() {
        return assinante;
    }
    public void setAssinante(boolean assinante) {
        this.assinante = assinante;
    }

    @Override
    public String toString() {
        return "Usuaria [idUsuaria=" + idUsuaria +
                         ", nome=" + nome + 
                         ", cpf=" + cpf + 
                         ", idade=" + idade + 
                         ", assinante=" + assinante + "]";
    } 

}
