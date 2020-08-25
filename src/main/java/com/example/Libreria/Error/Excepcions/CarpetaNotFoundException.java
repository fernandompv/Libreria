package com.example.Libreria.Error.Excepcions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarpetaNotFoundException extends RuntimeException{

        public CarpetaNotFoundException() { super("No se han encontrado carpetas"); }

        public CarpetaNotFoundException(Long id) {
            super("No se ha encontrado ningún carpeta con el ID " + id);
        }
}
