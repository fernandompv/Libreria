package com.example.Libreria.DTO.Convert;

import com.example.Libreria.DTO.GetLibrosDto;
import com.example.Libreria.Model.Libros;
import org.springframework.stereotype.Component;

@Component
public class ConvertLibrosDto {

    public GetLibrosDto convertLibrosToGetLibrosDto(Libros libros){
        return GetLibrosDto.builder()
                .nombre(libros.getNombre())
                .precio(libros.getPrecio())
                .stock(libros.getStock())
                .build();
    }
}
