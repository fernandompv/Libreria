package com.example.Libreria.Error.Excepcions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LibretasNotFoundException extends RuntimeException{

    public LibretasNotFoundException() { super("No se han encontrado libretas"); }

    public LibretasNotFoundException(Long id) {
        super("No se ha encontrado ningún libreta con el ID " + id);
    }
}
