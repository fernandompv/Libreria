package com.example.Libreria.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetLibrosDto {

    private String nombre;
    private String stock;
    private float precio;
}
