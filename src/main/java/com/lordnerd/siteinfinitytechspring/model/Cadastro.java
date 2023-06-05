package com.lordnerd.siteinfinitytechspring.model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Cadastro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Length(max = 18)
    @Column(length = 18, nullable = false)
    private String cnpj; 	// CNPJ do usuário, nao pode estar vazio.

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String nomeFantasia; 

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String nomeResponsavel;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String nomeOng;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String email;

    @NotBlank
    @NotNull
    @Length(max = 16)
    @Column(length = 16, nullable = false)
    private String telefone;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String endereco;

    @NotBlank
    @NotNull
    @Length(min = 6, max = 20)
    @Column(length = 20, nullable = false)
    private String senha;

    @NotBlank
    @NotNull
    @Length(min = 6, max = 20)
    @Column(length = 20, nullable = false)
    private String confirmaSenha;
}
