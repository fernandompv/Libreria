package com.example.Libreria.Controller;

import com.example.Libreria.Error.Excepcions.PuzzleNotFoundException;
import com.example.Libreria.Model.Puzzles;
import com.example.Libreria.Service.ServicePuzzle;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PuzzleController {

    @Autowired
    ServicePuzzle service;

    @GetMapping("/Puzzles")
    public ResponseEntity<?> getAllPuzzles() {
        List<Puzzles> result = service.findAll();
        if(!result.isEmpty())
            return ResponseEntity.ok(result);
        else
            throw new PuzzleNotFoundException();
    }

    @GetMapping ("/Puzzle/{id}")
    public Puzzles getPuzzle(@PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new PuzzleNotFoundException(id));
    }


    @PostMapping("/Puzzle")
    public ResponseEntity<?> postPuzzle(@RequestBody Puzzles puzzles){

        Puzzles saved = service.save(puzzles);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @PutMapping("/Puzzle/{id}")
    public Puzzles putPuzzle(@RequestBody Puzzles edit, @PathVariable Long id){
        return service.findById(id).map(p -> {
            p.setNombre(edit.getNombre());
            p.setPiezas(edit.getPiezas());
            p.setPrecio(edit.getPrecio());
            p.setStock(edit.getStock());
            return service.save(p);
        }).orElseThrow(() -> new PuzzleNotFoundException(id));
    }

    @DeleteMapping("/Puzzle/{id}")
    public ResponseEntity<?> deletePuzzle(@PathVariable Long id){
        Puzzles puzzles = service.findById(id).orElseThrow(() -> new PuzzleNotFoundException(id));
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}