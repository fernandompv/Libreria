package com.example.Libreria.Error.Excepcions;

public class PedidoNotFoundException extends RuntimeException {

    public PedidoNotFoundException() {
        super("No se han encontrado pedidos");
    }

    public PedidoNotFoundException(Long id) {
        super("No se ha encontrado ningún pedido con el ID " + id);
    }

}
