package com.example.Libreria.Controller;

import com.example.Libreria.DTO.Convert.ConvertPedidosDto;
import com.example.Libreria.DTO.CreatePedidoDto;
import com.example.Libreria.DTO.GetPedidosDto;
import com.example.Libreria.Error.Excepcions.LibroNotFoundException;
import com.example.Libreria.Error.Excepcions.LineaNotFoundException;
import com.example.Libreria.Error.Excepcions.PedidoNotFoundException;
import com.example.Libreria.Model.Pedidos;
import com.example.Libreria.Service.ServicePedido;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class PedidosController {

    @Autowired
    ServicePedido service;

    private final ConvertPedidosDto convertPedidosDto;

    @GetMapping("/Pedidos")
    public ResponseEntity<?> getAllPedidos() {
        List<Pedidos> result = service.findAll();
        if(!result.isEmpty()) {
            List<GetPedidosDto> dtoList = result.stream()
                    .map(convertPedidosDto::convertPedidosToGetPedidosDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
            //return ResponseEntity.ok(result);
        } else
            throw new LibroNotFoundException();
    }

    @GetMapping("/Pedido/{id}")
    public Pedidos getPedido(@PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new LineaNotFoundException(id));
    }


    @PostMapping("/Pedido")
    public ResponseEntity<?> postPedido(@RequestBody CreatePedidoDto pedidoDto){
        Pedidos saved = service.constructPedido(pedidoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(saved));
    }


    @PutMapping("/Pedido/{id}")
    public Pedidos putPedido(@RequestBody CreatePedidoDto edit, @PathVariable Long id){
        if(service.findById(id).isPresent()) {
            return service.save(service.constructPedido(edit));
        }
        else
            throw new PedidoNotFoundException(id);
    }

    @DeleteMapping("/Pedido/{id}")
    public ResponseEntity<?> deletePedido(@PathVariable Long id){
        Pedidos pedido = service.findById(id).orElseThrow(() -> new PedidoNotFoundException(id));
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
