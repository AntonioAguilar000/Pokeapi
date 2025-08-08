package com.example.pokedex.service;

import com.example.pokedex.model.Pokemon;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.InputStream;
import java.util.List;

@Service
public class PokemonService {

    private List<Pokemon> pokemons;

    @PostConstruct
    public void init() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getClassLoader().getResourceAsStream("pokemons.json");
            pokemons = mapper.readValue(is, new TypeReference<List<Pokemon>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error al leer pokemons.json", e);
        }
    }

    public List<Pokemon> getAllPokemons() {
        return pokemons;
    }

    public Pokemon getPokemonByName(String nombre) {
        return pokemons.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public Pokemon actualizarPorNombre(String nombre, Pokemon actualizado) {
        Pokemon existente = getPokemonByName(nombre);
        if (existente == null) {
            throw new RuntimeException("Pokémon no encontrado con nombre: " + nombre);
        }

        // Actualizar campos
        existente.setGeneracion(actualizado.getGeneracion());
        existente.setTipos(actualizado.getTipos());
        existente.setHabilidades(actualizado.getHabilidades());
        existente.setEstadisticas(actualizado.getEstadisticas());
        existente.setEvoluciones(actualizado.getEvoluciones());
        existente.setAltura(actualizado.getAltura());
        existente.setPeso(actualizado.getPeso());

        return existente;
    }
}
