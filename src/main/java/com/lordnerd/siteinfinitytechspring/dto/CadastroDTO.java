package com.lordnerd.siteinfinitytechspring.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroDTO(
Long id, 
@NotBlank @NotNull @Length(max = 18) String cnpj,
@NotBlank @NotNull @Length(min = 5, max = 100) String nomeFantasia, 	
@NotBlank @NotNull @Length(min = 5, max = 100) String nomeResponsavel,
@NotBlank @NotNull @Length(min = 5, max = 100) String nomeOng,
@NotBlank @NotNull @Length(min = 5, max = 100) String email,
@NotBlank @NotNull @Length(max = 16) String telefone,	
@NotBlank @NotNull @Length(min = 5, max = 100) String endereco,
@NotBlank @NotNull @Length(min = 6, max = 20) String senha,	
@NotBlank @NotNull @Length(min = 6, max = 20) String confirmaSenha//id do cadastro, pode ser nulo e informado quando for feito o cadastro
) {

}
