package com.senac.gestao.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

@Entity
@Inheritance
public class Gerente extends Funcionario {
    private Integer nivelAutorizacao;

    public Gerente() {
    }

    // Getters e Setters
    public Integer getNivelAutorizacao() {
        return nivelAutorizacao;
    }

    public void setNivelAutorizacao(Integer nivelAutorizacao) {
        this.nivelAutorizacao = nivelAutorizacao;
    }
}