package com.lordnerd.siteinfinitytechspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lordnerd.siteinfinitytechspring.dto.CadastroDTO;
import com.lordnerd.siteinfinitytechspring.services.CadastroService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/cadastro")
public class CadastroController {
    private final CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService){
        this.cadastroService = cadastroService;
    }

   @GetMapping
   public @ResponseBody List<CadastroDTO> list(){
        return cadastroService.list();
   }

   @GetMapping("/{id}")
   public CadastroDTO findById(@PathVariable @NotNull @Positive Long id){
      return cadastroService.findById(id);
   }

   @PostMapping
   @ResponseStatus(code = HttpStatus.CREATED)
   public CadastroDTO create(@RequestBody @Valid @NotNull CadastroDTO cadastro){
      return cadastroService.create(cadastro);
   }

}
