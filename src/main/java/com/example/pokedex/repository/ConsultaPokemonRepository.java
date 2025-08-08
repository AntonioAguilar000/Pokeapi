package com.example.pokedex.repository;

import com.example.pokedex.model.ConsultaPokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface ConsultaPokemonRepository extends JpaRepository<ConsultaPokemon, Long> {
    Optional<ConsultaPokemon> findTopByOrderByTimestampDesc();
    List<ConsultaPokemon> findAllByOrderByTimestampDesc();
}