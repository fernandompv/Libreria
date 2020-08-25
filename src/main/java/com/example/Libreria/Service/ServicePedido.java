package com.example.Libreria.Service;

import com.example.Libreria.DTO.CreatePedidoDto;
import com.example.Libreria.Model.Pedidos;

public interface ServicePedido extends CustomService<Pedidos,Long>{
    public Pedidos constructPedido(CreatePedidoDto dto);
}
