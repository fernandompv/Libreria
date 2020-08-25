package com.example.Libreria.Controller;

import com.example.Libreria.DTO.Convert.ConvertUsuarioDto;
import com.example.Libreria.DTO.GetUsuarioDto;
import com.example.Libreria.Model.Usuarios;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UsuarioController {

    private final ConvertUsuarioDto convertUserDto;

    @GetMapping("/me")
    public GetUsuarioDto me(@AuthenticationPrincipal Usuarios user) {
        return convertUserDto.convertUserEntityToGetUserDto(user);
    }
}
