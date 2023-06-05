package com.lordnerd.siteinfinitytechspring.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@SQLDelete(sql = "UPDATE Cards SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status='Ativo'")
public class Cards {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String servico;
    
    @NotNull
    @NotBlank
    @Length(max = 30)
    @Column(length = 30, nullable = false)
    private String dataCriacao;
    
    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String sede;
    
    @NotNull
    @NotBlank
    @Length(min = 5, max = 150)
    @Column(length = 150, nullable = false)
    private String localidade;
    
    @NotNull
    @NotBlank
    @Length(min = 5, max = 200)
    @Column(length = 200, nullable = false)
    private String descricao;
    
    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String horarioFuncionamento;

    @NotNull
    @NotBlank
    @Length(max = 10)
    @Pattern(regexp = "Ativo|Inativo")
    @Column(length = 10, nullable = false)
    private String status = "Ativo";


}
