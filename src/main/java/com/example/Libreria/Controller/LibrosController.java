package com.example.Libreria.Controller;

import com.example.Libreria.DTO.Convert.ConvertLibrosDto;
import com.example.Libreria.DTO.GetLibrosDto;
import com.example.Libreria.Error.Excepcions.LibroNotFoundException;
import com.example.Libreria.Model.Libros;
import com.example.Libreria.Service.ServiceLibro;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class LibrosController {

    @Autowired
    ServiceLibro service;

    private final ConvertLibrosDto convertLibrosDto;

    @GetMapping("/Libros")
    public ResponseEntity<?> getAllLibros() {
        List<Libros> result = service.findAll();
        if(!result.isEmpty()) {
            List<GetLibrosDto> dtoList = result.stream()
                    .map(convertLibrosDto::convertLibrosToGetLibrosDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
            //return ResponseEntity.ok(result);
        } else
            throw new LibroNotFoundException();
    }

    @GetMapping ("/Libro/{id}")
    public ResponseEntity<?> getLibro(@PathVariable Long id) {
        Libros libro =  service.findById(id).orElseThrow(() -> new LibroNotFoundException(id));
        return ResponseEntity.status(HttpStatus.OK).body(convertLibrosDto.convertLibrosToGetLibrosDto(libro));
    }


    @PostMapping("/Libro")
    public ResponseEntity<?> postLibro(@RequestBody Libros libro){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(libro));
    }


    @PutMapping("/Libro/{id}")
    public Libros putLibro(@RequestBody Libros edit, @PathVariable Long id){
        return service.findById(id).map(p -> {
            p.setNombre(edit.getNombre());
            p.setPrecio(edit.getPrecio());
            p.setStock(edit.getStock());
            return service.save(p);
        }).orElseThrow(() -> new LibroNotFoundException(id));
    }

    @DeleteMapping("/Libro/{id}")
    public ResponseEntity<?> deleteLibro(@PathVariable Long id){
        Libros libreta = service.findById(id).orElseThrow(() -> new LibroNotFoundException(id));
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
