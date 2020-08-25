package com.example.Libreria.Controller;

import com.example.Libreria.Error.Excepcions.LibretasNotFoundException;
import com.example.Libreria.Model.Libretas;
import com.example.Libreria.Service.ServiceLibreta;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LibretasController {

    @Autowired
    ServiceLibreta service;

    @GetMapping("/Libretas")
    public ResponseEntity<?> getAllLibretas() {
        List<Libretas> result = service.findAll();
        if(!result.isEmpty())
            return ResponseEntity.ok(result);
        else
            throw new LibretasNotFoundException();
    }

    @GetMapping ("/Libreta/{id}")
    public Libretas getLibreta(@PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new LibretasNotFoundException(id));
    }


    @PostMapping("/Libreta")
    public ResponseEntity<?> postLibreta(@RequestBody Libretas libreta){
        Libretas saved = service.save(libreta);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @PutMapping("/Libreta/{id}")
    public Libretas putLibreta(@RequestBody Libretas edit, @PathVariable Long id){
        return service.findById(id).map(p -> {
            p.setColor(edit.getColor());
            p.setNombre(edit.getNombre());
            p.setPrecio(edit.getPrecio());
            p.setStock(edit.getStock());
            return service.save(p);
        }).orElseThrow(() -> new LibretasNotFoundException(id));
    }

    @DeleteMapping("/Libreta/{id}")
    public ResponseEntity<?> deleteLibreta(@PathVariable Long id){
        Libretas libreta = service.findById(id).orElseThrow(() -> new LibretasNotFoundException(id));
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
