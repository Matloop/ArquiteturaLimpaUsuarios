package com.senac.gestao.models;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Pessoa {
    private LocalDate dataRegistro;
    private String status;
}