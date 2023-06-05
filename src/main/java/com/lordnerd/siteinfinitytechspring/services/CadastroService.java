package com.lordnerd.siteinfinitytechspring.services;

import java.util.ArrayList;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.lordnerd.siteinfinitytechspring.dto.mapper.CadastroMapper;
import com.lordnerd.siteinfinitytechspring.repository.CadastroRepository;
import com.lordnerd.siteinfinitytechspring.exception.RecordNotFoundException;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import com.lordnerd.siteinfinitytechspring.dto.CadastroDTO;

@Service
public class CadastroService {
    private final CadastroRepository cadastroRepository;
    private final CadastroMapper cadastroMapper;

    public CadastroService(CadastroRepository cadastroRepository, CadastroMapper cadastroMapper){
        this.cadastroRepository = cadastroRepository;
        this.cadastroMapper = cadastroMapper;
    }

    public List<CadastroDTO> list(){
        return cadastroRepository.findAll().stream()
            .map(cadastroMapper :: toDTO)
                .collect(ArrayList :: new, ArrayList :: add, ArrayList :: addAll);
    }

    public CadastroDTO findById(@PathVariable @NotNull @NotBlank Long id){
        return cadastroRepository.findById(id).map(cadastroMapper :: toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id) );
     }
  
     public CadastroDTO create(@Valid @NotNull CadastroDTO cadastro){
        return cadastroMapper.toDTO(cadastroRepository.save(cadastroMapper.toEntity(cadastro)));
     }
  
}
