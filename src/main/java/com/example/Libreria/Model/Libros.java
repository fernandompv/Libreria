package com.example.Libreria.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "libros")
public class Libros {

    @SequenceGenerator(name = "seq",sequenceName = "id_libro",allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id_libro;

    private String nombre;

    private String stock;

    private float precio;

    private String genero;

}
