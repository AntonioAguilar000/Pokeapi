package com.example.pokedex.model;

import java.util.List;
import lombok.Data;

@Data
public class Pokemon {
    private String nombre;
    private String generacion;
    private List<String> tipos;
    private List<String> habilidades;
    private Estadisticas estadisticas;
    private List<String> evoluciones;
    private double altura;
    private double peso;


    @Data
    public static class Estadisticas {
        private int hp;
        private int ataque;
        private int defensa;
        private int velocidad;

    }
}
