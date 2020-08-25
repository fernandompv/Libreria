package com.example.Libreria.Error.Excepcions;

public class Tipo_productoNotFoundException extends RuntimeException{

    public Tipo_productoNotFoundException() {
        super("No se han encontrado puzzles");
    }

    public Tipo_productoNotFoundException(Long id) {
        super("No se ha encontrado ningún puzzle con el ID " + id);
    }
}
