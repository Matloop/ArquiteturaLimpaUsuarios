package com.senac.gestao.domain.models.enums;

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