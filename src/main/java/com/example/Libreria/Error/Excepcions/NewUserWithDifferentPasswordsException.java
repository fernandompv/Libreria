package com.example.Libreria.Error.Excepcions;

public class NewUserWithDifferentPasswordsException extends RuntimeException {

    public NewUserWithDifferentPasswordsException() {
        super("Las contraseñas no coinciden");
    }

}
