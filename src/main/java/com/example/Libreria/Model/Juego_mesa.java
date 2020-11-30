package com.example.Libreria.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "juegos_mesa")
public class Juego_mesa {
    @Id
    private Long id_juego_mesa;

    private String nombre;

    private String marca;

    private String genero;

    private float precio;

    private String stock;
}
