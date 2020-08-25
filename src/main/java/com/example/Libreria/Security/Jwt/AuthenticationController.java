package com.example.Libreria.Security.Jwt;

import com.example.Libreria.DTO.Convert.ConvertUsuarioDto;
import com.example.Libreria.DTO.GetUsuarioDto;
import com.example.Libreria.Model.RolesUsuario;
import com.example.Libreria.Model.Usuarios;
import com.example.Libreria.Security.Jwt.Model.JwtUserResponse;
import com.example.Libreria.Security.Jwt.Model.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final ConvertUsuarioDto converter;

    @PostMapping("/auth/login")
    public JwtUserResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Usuarios user = (Usuarios) authentication.getPrincipal();
        String jwtToken = tokenProvider.generateToken(authentication);

        return convertUserEntityAndTokenToJwtUserResponse(user, jwtToken);

    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/user/me")
    public GetUsuarioDto me(@AuthenticationPrincipal Usuarios user) {
        return converter.convertUserEntityToGetUserDto(user);
    }


    private JwtUserResponse convertUserEntityAndTokenToJwtUserResponse(Usuarios user, String jwtToken) {
        return JwtUserResponse
                .jwtUserResponseBuilder()
                .username(user.getUsername())
                .roles(user.getRoles().stream().map(RolesUsuario::name).collect(Collectors.toSet()))
                .token(jwtToken)
                .build();

    }

}
