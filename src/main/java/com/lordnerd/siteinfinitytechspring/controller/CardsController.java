package com.lordnerd.siteinfinitytechspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lordnerd.siteinfinitytechspring.model.Cards;
import com.lordnerd.siteinfinitytechspring.repository.CardsRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;


@Validated
@RestController
@RequestMapping("/api/cards")
@AllArgsConstructor
public class CardsController {
   
   private final CardsRepository cardsRepository;

   @GetMapping
   public @ResponseBody List<Cards> list(){
        return cardsRepository.findAll();
   }

   @GetMapping("/{id}")
   public ResponseEntity<Cards> findById(@PathVariable @NotNull @Positive Long id){
      return cardsRepository.findById(id)
         .map(recordFound -> ResponseEntity.ok().body(recordFound))
         .orElse(ResponseEntity.notFound().build());
   }

   @PostMapping
   @ResponseStatus(code = HttpStatus.CREATED)
   public Cards create(@RequestBody @Valid Cards cards){
      return cardsRepository.save(cards);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Cards> update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Cards cards){
      return cardsRepository.findById(id)
         .map(recordFound -> {
            recordFound.setServico(cards.getServico());
            recordFound.setDataCriacao(cards.getDataCriacao());
            recordFound.setSede(cards.getSede());
            recordFound.setLocalidade(cards.getLocalidade());
            recordFound.setDescricao(cards.getDescricao());
            recordFound.setHorarioFuncionamento(cards.getHorarioFuncionamento());

            Cards updated = cardsRepository.save(recordFound);
            return ResponseEntity.ok().body(updated);
         })
         .orElse(ResponseEntity.notFound().build());
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id){
      return cardsRepository.findById(id)
         .map(recordFound -> {
            cardsRepository.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
   })
   .orElse(ResponseEntity.notFound().build());
   }
}
