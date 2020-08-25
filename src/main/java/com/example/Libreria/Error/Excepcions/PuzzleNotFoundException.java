package com.example.Libreria.Error.Excepcions;

public class PuzzleNotFoundException extends RuntimeException{

    public PuzzleNotFoundException() {
        super("No se han encontrado puzzles");
    }

    public PuzzleNotFoundException(Long id) {
        super("No se ha encontrado ningún puzzle con el ID " + id);
    }
}
