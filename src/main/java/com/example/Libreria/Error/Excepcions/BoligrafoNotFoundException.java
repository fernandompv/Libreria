package com.example.Libreria.Error.Excepcions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BoligrafoNotFoundException extends RuntimeException{

    public BoligrafoNotFoundException() {
        super("No se han encontrado boligrafos");
    }

    public BoligrafoNotFoundException(Long id) {
        super("No se ha encontrado ningún boligrafo con el ID " + id);
    }
}
