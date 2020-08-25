package com.example.Libreria.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetPedidosDto {

    private String nombre;
    private String email;
    private LocalDateTime date;
    private float total;
    private Set<GetLineaDto> linea;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class GetLineaDto{

        private String nombre;
        private float precio_unitario;
        private int cantidad;
        private float subtotal;
    }
}
