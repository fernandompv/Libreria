package com.example.Libreria.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "libretas")
public class Libretas {

    @SequenceGenerator(name = "seq",sequenceName = "id_libreta",allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id_libreta;

    private String nombre;

    private String color;

    private float precio;

    private String stock;
}
