package com.lordnerd.siteinfinitytechspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.lordnerd.siteinfinitytechspring.dto.CardsDTO;
import com.lordnerd.siteinfinitytechspring.model.Cards;

@Component
public class CardsMapper  {
    public CardsDTO toDTO(Cards cards){
        return new CardsDTO(cards.getId(), cards.getServico(), cards.getDataCriacao(), 
        cards.getSede(), cards.getLocalidade(), cards.getDescricao(), cards.getHorarioFuncionamento());
    }

    public Cards toEntity(CardsDTO cardsDTO){

        if (cardsDTO == null){
            return null;
        }

        Cards cards = new Cards();
        if (cardsDTO.id() != null){
            cards.setId(cardsDTO.id());
        }
        cards.setServico(cardsDTO.servico());
        cards.setDataCriacao(cardsDTO.dataCriacao());
        cards.setSede(cardsDTO.sede());
        cards.setLocalidade(cardsDTO.localidade());
        cards.setDescricao(cardsDTO.descricao());
        cards.setHorarioFuncionamento(cardsDTO.horarioFuncionamento());
        return cards;
    }
}
