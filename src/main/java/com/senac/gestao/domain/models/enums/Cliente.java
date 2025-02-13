package com.senac.gestao.domain.models.enums;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Cliente extends Pessoa {
    private LocalDate dataRegistro;
    private String status;

    public Cliente() {
    }

    // Getters e Setters
    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}