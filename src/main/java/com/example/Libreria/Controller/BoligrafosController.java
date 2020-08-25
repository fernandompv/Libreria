package com.example.Libreria.Controller;

import com.example.Libreria.Error.Excepcions.BoligrafoNotFoundException;
import com.example.Libreria.Model.Boligrafos;
import com.example.Libreria.Service.ServiceBoligrafo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoligrafosController {

    @Autowired
    ServiceBoligrafo service;

    @ApiOperation(value="Recupera todos los registros de la tabla boligrafos", notes="Provee la operación para devolver todos los boligrafos de la base de datos")
    @GetMapping("/Boligrafos")
    public ResponseEntity<?> getAllBoligrafos() {
        List<Boligrafos> result = service.findAll();
        if(!result.isEmpty())
            return ResponseEntity.ok(result);
        else
            throw new BoligrafoNotFoundException();
    }

    @ApiOperation(value="Recupera un registro de la tabla boligrafos mediante la ID", notes="Provee la operación para devolver un boligrafo mediante la id, la cual recupera desde la url")
    @GetMapping ("/Boligrafo/{id}")
    public Boligrafos getBoligrafo(
            @ApiParam(value = "ID para buscar el registro")
            @PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new BoligrafoNotFoundException(id));
    }

    @ApiOperation(value="Crear un nuevo registro en la tabla boligrafos", notes="Provee la operación para crear un nuevo boligrafo a partir de un objeto Boligrafo pasado desde la petición Json")
    @PostMapping("/Boligrafo")
    public ResponseEntity<?> postBoligrafo(
            @ApiParam(value = "Datos del nuevo boligrafo")
            @RequestBody Boligrafos boligrafo){
        Boligrafos saved = service.save(boligrafo);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @ApiOperation(value="Modifica un registro de la tabla boligrafos", notes="Provee la operación para actualizar un boligrafo a partir de un objeto Boligrafo y una ID pasados desde la petición Json")
    @PutMapping("/Boligrafo/{id}")
    public Boligrafos putBoligrafo(
            @ApiParam(value = "Datos del nuevo boligrafo")
            @RequestBody Boligrafos edit,
            @ApiParam(value = "ID para buscar el registro")
            @PathVariable Long id){
        return service.findById(id).map(p -> {
            p.setColor(edit.getColor());
            p.setNombre(edit.getNombre());
            p.setStock(edit.getStock());
            p.setPrecio(edit.getPrecio());
            return service.save(p);
        }).orElseThrow(() -> new BoligrafoNotFoundException(id));
    }

    @ApiOperation(value="Elimina un registro de la tabla boligrafos", notes="Provee la operación para eliminar un boligrafo a partir de una ID que se indica en la url de la petición")
    @DeleteMapping("/Boligrafo/{id}")
    public ResponseEntity<?> deleteBoligrafo(
            @ApiParam(value = "ID para buscar el registro")
            @PathVariable Long id){
        Boligrafos product = service.findById(id).orElseThrow(() -> new BoligrafoNotFoundException(id));
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
