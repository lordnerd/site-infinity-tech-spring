package com.lordnerd.siteinfinitytechspring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lordnerd.siteinfinitytechspring.model.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> {
    
}
