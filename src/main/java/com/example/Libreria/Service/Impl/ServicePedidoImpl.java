package com.example.Libreria.Service.Impl;

import com.example.Libreria.DTO.CreatePedidoDto;
import com.example.Libreria.Model.Linea_pedido;
import com.example.Libreria.Model.Pedidos;
import com.example.Libreria.Model.Tipo_producto;
import com.example.Libreria.Repository.RepositoryPedido;
import com.example.Libreria.Service.ServiceBoligrafo;
import com.example.Libreria.Service.ServicePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServicePedidoImpl extends CustomServiceImpl<Pedidos,Long> implements ServicePedido {

    @Autowired
    RepositoryPedido repositoryPedido;

    @Autowired
    ServiceBoligrafo serviceBoligrafo;

    @Autowired
    ServiceUsuarioImpl serviceUsuarios;

    @Override
    public JpaRepository<Pedidos, Long> getRepository() {
        return repositoryPedido;
    }


    public Pedidos constructPedido(CreatePedidoDto nuevo) {
        Pedidos pedido = Pedidos.builder()
                .usuario(serviceUsuarios.findUserByName(nuevo.getNombre()))
                .date(LocalDateTime.now())
                .linea(nuevo.getLinea().stream().map(p -> {
                    return Linea_pedido.builder()
                            .cantidad(p.getCantidad())
                            .nombre(p.getNombre())
                            .tipo(toSet(p.getTipo().toUpperCase()))
                            .precioUnidad(p.getPrecio_unitario())
                            .subtotal(p.getCantidad() * p.getPrecio_unitario())
                            .build();
                }).filter(Objects::nonNull)
                        .collect(Collectors.toSet()))
                .total(nuevo.getTotal())
                .build();

        if (errorFloat(pedido))
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"El precio total del pedido no coincide con la suma de las lineas");

        return pedido;
    }

    public boolean errorFloat(Pedidos pedido){
        float c = 0;
        for (Linea_pedido linea_pedido : pedido.getLinea()) {
            c = c + linea_pedido.getSubtotal();
        }
        if(c != pedido.getTotal())
            return true;

        return false;
    }

    public Set<Tipo_producto> toSet(String name){
        Set<Tipo_producto> set = new HashSet<>();
        set.add(Tipo_producto.valueOf(name));
        return set;
    }
}
