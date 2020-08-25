package com.example.Libreria.Controller;

import com.example.Libreria.Error.Excepcions.Juego_mesaNotFoundException;
import com.example.Libreria.Model.Juego_mesa;
import com.example.Libreria.Service.ServiceJuego_mesa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class Juego_mesaController {

    @Autowired
    ServiceJuego_mesa service;

    @GetMapping("/Juegos_mesa")
    public ResponseEntity<?> getAllJuegos_mesa() {
        List<Juego_mesa> result = service.findAll();
        if(!result.isEmpty())
            return ResponseEntity.ok(result);
        else
            throw new Juego_mesaNotFoundException();
    }

    @GetMapping ("/Juego_mesa/{id}")
    public Juego_mesa getJuego_mesa(@PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new Juego_mesaNotFoundException(id));
    }


    @PostMapping("/Juego_mesa")
    public ResponseEntity<?> postJuego_mesa(@RequestBody Juego_mesa juego_mesa){

        Juego_mesa saved = service.save(juego_mesa);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @PutMapping("/Juego_mesa/{id}")
    public Juego_mesa putJuego_mesa(@RequestBody Juego_mesa edit, @PathVariable Long id){
        return service.findById(id).map(p -> {
            p.setGenero(edit.getGenero());
            p.setMarca(edit.getMarca());
            p.setNombre(edit.getNombre());
            p.setPrecio(edit.getPrecio());
            p.setStock(edit.getStock());
            return service.save(p);
        }).orElseThrow(() -> new Juego_mesaNotFoundException(id));
    }

    @DeleteMapping("/Juego_mesa/{id}")
    public ResponseEntity<?> deleteJuego_mesa(@PathVariable Long id){
        Juego_mesa juego_mesa = service.findById(id).orElseThrow(() -> new Juego_mesaNotFoundException(id));
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
