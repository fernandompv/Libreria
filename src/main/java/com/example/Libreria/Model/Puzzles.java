package com.example.Libreria.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "puzzles")
public class Puzzles {

    @Id
    private Long id_puzzle;

    private String nombre;

    private String piezas;

    private float precio;

    private String stock;
}
