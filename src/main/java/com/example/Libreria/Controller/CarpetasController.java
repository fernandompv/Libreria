package com.example.Libreria.Controller;

import com.example.Libreria.Error.Excepcions.CarpetaNotFoundException;
import com.example.Libreria.Model.Carpetas;
import com.example.Libreria.Service.ServiceCarpeta;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarpetasController {

    @Autowired
    ServiceCarpeta service;

    @GetMapping("/Carpetas")
    public ResponseEntity<?> getAllCarpetas() {
        List<Carpetas> result = service.findAll();
        if(!result.isEmpty())
            return ResponseEntity.ok(result);
        else
            throw new CarpetaNotFoundException();
    }

    @GetMapping ("/Carpeta/{id}")
    public Carpetas getCarpeta(@PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new CarpetaNotFoundException(id));
    }


    @PostMapping("/Carpeta")
    public ResponseEntity<?> postCarpeta(@RequestBody Carpetas carpeta){
        Carpetas saved = service.save(carpeta);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @PutMapping("/Carpeta/{id}")
    public Carpetas putCarpeta(@RequestBody Carpetas edit, @PathVariable Long id){
        return service.findById(id).map(p -> {
            p.setColor(edit.getColor());
            p.setNombre(edit.getNombre());
            p.setPrecio(edit.getPrecio());
            p.setStock(edit.getStock());
            return service.save(p);
        }).orElseThrow(() -> new CarpetaNotFoundException(id));
    }

    @DeleteMapping("/Carpeta/{id}")
    public ResponseEntity<?> deleteCarpeta(@PathVariable Long id){
        Carpetas carpeta = service.findById(id).orElseThrow(() -> new CarpetaNotFoundException(id));
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
