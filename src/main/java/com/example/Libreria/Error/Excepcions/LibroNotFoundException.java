package com.example.Libreria.Error.Excepcions;

public class LibroNotFoundException extends RuntimeException{

    public LibroNotFoundException() {
        super("No se han encontrado pedidos");
    }

    public LibroNotFoundException(Long id) {
        super("No se ha encontrado ningún pedido con el ID " + id);
    }
}
