package com.example.pokedex.controller;

import com.example.pokedex.model.Pokemon;
import com.example.pokedex.service.PokemonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pokemon> getAll() {
        return service.getAllPokemons();
    }

    @GetMapping("/{nombre}")
    public Pokemon getByName(@PathVariable String nombre) {
        return service.getPokemonByName(nombre);
    }
}
