package com.lordnerd.siteinfinitytechspring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.lordnerd.siteinfinitytechspring.exception.RecordNotFoundException;
import com.lordnerd.siteinfinitytechspring.repository.CardsRepository;
import com.lordnerd.siteinfinitytechspring.dto.CardsDTO;
import com.lordnerd.siteinfinitytechspring.dto.mapper.CardsMapper;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Service
public class CardsService {
    private final CardsRepository cardsRepository;
    private final CardsMapper cardsMapper;

    public CardsService (CardsRepository cardsRepository, CardsMapper cardsMapper){
        this.cardsRepository = cardsRepository;
        this.cardsMapper = cardsMapper;
    }

   
   public List<CardsDTO> list(){
        return cardsRepository.findAll().stream()
        .map(cardsMapper :: toDTO)
            .collect(ArrayList :: new, ArrayList :: add, ArrayList :: addAll);
    }

   public CardsDTO findById(@PathVariable @NotNull @Positive Long id){
      return cardsRepository.findById(id).map(cardsMapper :: toDTO)
      .orElseThrow(() -> new RecordNotFoundException(id) );
   }

   public CardsDTO create(@Valid @NotNull CardsDTO cards){
      return cardsMapper.toDTO(cardsRepository.save(cardsMapper.toEntity(cards)));
   }

   public CardsDTO update(@PathVariable @NotNull @Positive Long id, @Valid @NotNull CardsDTO cards){
       return cardsRepository.findById(id)
        .map(recordFound -> {
          recordFound.setServico(cards.servico());
          recordFound.setDataCriacao(cards.dataCriacao());
          recordFound.setSede(cards.sede());
          recordFound.setLocalidade(cards.localidade());
          recordFound.setDescricao(cards.descricao());
          recordFound.setHorarioFuncionamento(cards.horarioFuncionamento());

          return cardsMapper.toDTO(cardsRepository.save(recordFound));
       }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id){
        cardsRepository.delete(cardsRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id)));
  }
}