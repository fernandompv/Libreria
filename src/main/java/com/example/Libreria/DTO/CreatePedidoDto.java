package com.example.Libreria.DTO;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePedidoDto {

    private String nombre;
    private float total;
    private Set<CreateLineDto> linea;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CreateLineDto{

        private String nombre;
        private String tipo;
        private int cantidad;
        private float precio_unitario;
    }
}
