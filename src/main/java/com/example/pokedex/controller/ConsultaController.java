package com.example.pokedex.controller;

import com.example.pokedex.model.ConsultaPokemon;
import com.example.pokedex.repository.ConsultaPokemonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    private final ConsultaPokemonRepository consultaRepo;

    public ConsultaController(ConsultaPokemonRepository consultaRepo) {
        this.consultaRepo = consultaRepo;
    }

    @GetMapping
    public List<ConsultaPokemon> listar() {
        return consultaRepo.findAllByOrderByTimestampDesc();
    }

    @DeleteMapping
    public void eliminarTodas() {
        consultaRepo.deleteAll();
    }

    @DeleteMapping("/ultimo")
    public ResponseEntity<String> eliminarUltimo() {
        return consultaRepo.findTopByOrderByTimestampDesc()
                .map(registro -> {
                    consultaRepo.delete(registro);
                    return ResponseEntity.ok("Último registro eliminado");
                })
                .orElse(ResponseEntity.notFound().build());
    }
}