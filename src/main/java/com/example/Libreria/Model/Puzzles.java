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

    @SequenceGenerator(name = "seq",sequenceName = "id_puzzle",allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id_puzzle;

    private String nombre;

    private String piezas;

    private float precio;

    private String stock;
}
