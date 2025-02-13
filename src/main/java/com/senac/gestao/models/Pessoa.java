package com.senac.gestao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "documento_id", referencedColumnName = "id")
    private Documento documento;

    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "contato_id", referencedColumnName = "id")
    private Contato contato;

    private LocalDate dataNascimento;
    private char sexo;
}