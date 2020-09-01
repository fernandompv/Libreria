package com.example.Libreria.Security.Jwt.Model;

import com.example.Libreria.DTO.GetUsuarioDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class JwtUserResponse extends GetUsuarioDto {

    private String token;

    @Builder(builderMethodName="jwtUserResponseBuilder")
    public JwtUserResponse(String username, Set<String> roles, String token) {
        super(username + "123456789", roles);
        this.token = token;
    }

}
