package com.example.Libreria.DTO.Convert;

import com.example.Libreria.DTO.GetPedidosDto;
import com.example.Libreria.Model.Linea_pedido;
import com.example.Libreria.Model.Pedidos;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConvertPedidosDto {


    public GetPedidosDto convertPedidosToGetPedidosDto(Pedidos pedidos){

        return GetPedidosDto.builder()
                .nombre(pedidos.getUsuario().getNombre())
                .email(pedidos.getUsuario().getEmail())
                .date(pedidos.getDate())
                .total(pedidos.getTotal())
                .linea(pedidos.getLinea().stream()
                        .map(this::convertLineaToGetLineaDto)
                        .collect(Collectors.toSet()))
                .build();
    }


    public GetPedidosDto.GetLineaDto convertLineaToGetLineaDto(Linea_pedido linea_pedido){

        return GetPedidosDto.GetLineaDto.builder()
                .nombre(linea_pedido.getNombre())
                .precio_unitario(linea_pedido.getPrecioUnidad())
                .cantidad(linea_pedido.getCantidad())
                .subtotal(linea_pedido.getSubtotal())
                .build();
    }
}
