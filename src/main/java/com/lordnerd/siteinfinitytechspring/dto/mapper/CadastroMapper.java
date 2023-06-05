package com.lordnerd.siteinfinitytechspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.lordnerd.siteinfinitytechspring.dto.CadastroDTO;
import com.lordnerd.siteinfinitytechspring.model.Cadastro;

@Component
public class CadastroMapper {
    public CadastroDTO toDTO(Cadastro cadastro){
        return new CadastroDTO(cadastro.getId(), cadastro.getCnpj(), cadastro.getNomeFantasia(), 
        cadastro.getNomeResponsavel(), cadastro.getNomeOng(), cadastro.getEmail(), cadastro.getTelefone(), 
        cadastro.getEndereco(), cadastro.getSenha(), cadastro.getConfirmaSenha());
    }

    public Cadastro toEntity(CadastroDTO cadastroDTO){
        if(cadastroDTO == null){
            return null;
        }

        Cadastro cadastro = new Cadastro();
        if(cadastroDTO.id() != null){
            cadastro.setId(cadastroDTO.id());
        }
        cadastro.setCnpj(cadastroDTO.cnpj());
        cadastro.setNomeFantasia(cadastroDTO.nomeFantasia());
        cadastro.setNomeResponsavel(cadastroDTO.nomeResponsavel());
        cadastro.setNomeOng(cadastroDTO.nomeOng());
        cadastro.setEmail(cadastroDTO.email()); 			//Email nao permite espaço no
        cadastro.setTelefone(cadastroDTO.telefone());
        cadastro.setEndereco(cadastroDTO.endereco());
        cadastro.setSenha(cadastroDTO.senha());
        cadastro.setConfirmaSenha(cadastroDTO.confirmaSenha());
        return cadastro;
    }
}
