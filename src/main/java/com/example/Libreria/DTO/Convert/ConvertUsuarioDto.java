package com.example.Libreria.DTO.Convert;

import com.example.Libreria.DTO.GetUsuarioDto;
import com.example.Libreria.Model.RolesUsuario;
import com.example.Libreria.Model.Usuarios;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConvertUsuarioDto {

    public GetUsuarioDto convertUserEntityToGetUserDto(Usuarios user){
        return GetUsuarioDto.builder()
                .username(user.getUsername())
                .roles(user.getRoles().stream()
                        .map(RolesUsuario::name)
                        .collect(Collectors.toSet()))
                .build();
    }
}
