package com.lordnerd.siteinfinitytechspring.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CardsDTO(
Long id, 
@NotBlank @NotNull @Length(min = 5, max = 100) String servico,
@NotBlank @NotNull @Length(max = 30) String dataCriacao,
@NotBlank @NotNull @Length(min = 5, max = 100) String sede,
@NotBlank @NotNull @Length(min = 5, max = 150) String localidade,
@NotBlank @NotNull @Length(min = 5, max = 200) String descricao,
@NotBlank @NotNull @Length(min = 5, max = 100) String horarioFuncionamento) {
    
}
