package com.lordnerd.siteinfinitytechspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lordnerd.siteinfinitytechspring.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
    
}
