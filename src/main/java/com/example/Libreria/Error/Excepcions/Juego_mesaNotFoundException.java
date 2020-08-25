package com.example.Libreria.Error.Excepcions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Juego_mesaNotFoundException extends RuntimeException{

    public Juego_mesaNotFoundException() {
        super("No se han encontrado boligrafos");
    }

    public Juego_mesaNotFoundException(Long id) {
        super("No se ha encontrado ningún boligrafo con el ID " + id);
    }
}
