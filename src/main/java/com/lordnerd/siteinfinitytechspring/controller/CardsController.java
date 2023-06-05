package com.lordnerd.siteinfinitytechspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import com.lordnerd.siteinfinitytechspring.dto.CardsDTO;
import com.lordnerd.siteinfinitytechspring.services.CardsService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/api/cards")
public class CardsController {
   
   private final CardsService cardsService;
   
   public CardsController (CardsService cardsService){
      this.cardsService = cardsService;
  }

   @GetMapping
   public @ResponseBody List<CardsDTO> list(){
        return cardsService.list();
   }

   @GetMapping("/{id}")
   public CardsDTO findById(@PathVariable @NotNull @Positive Long id){
      return cardsService.findById(id);
   }

   @PostMapping
   @ResponseStatus(code = HttpStatus.CREATED)
   public CardsDTO create(@RequestBody @Valid @NotNull CardsDTO cards){
      return cardsService.create(cards);
   }

   @PutMapping("/{id}")
   public CardsDTO update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid @NotNull CardsDTO cards){
      return cardsService.update(id, cards);
   }

   @DeleteMapping("/{id}")
   @ResponseStatus(code = HttpStatus.NO_CONTENT)
   public void delete(@PathVariable @NotNull @Positive Long id){
      cardsService.delete(id);
   }
}
