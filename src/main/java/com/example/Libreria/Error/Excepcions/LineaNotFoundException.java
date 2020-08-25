package com.example.Libreria.Error.Excepcions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LineaNotFoundException extends RuntimeException {

    public LineaNotFoundException() {
        super("No se han encontrado ningunas Lineas");
    }

    public LineaNotFoundException(Long id) {
        super("No se ha encontrado ningúna linea con el ID " + id);
    }
}
