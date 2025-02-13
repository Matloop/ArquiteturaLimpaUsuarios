package com.senac.gestao.models;

import com.senac.gestao.models.enums.Departamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED) // Escolha a estratégia correta
public class Funcionario extends Pessoa {
    private Double salario;
    private String cargo;

    @Enumerated(EnumType.STRING)
    private Departamento departamento;
}
