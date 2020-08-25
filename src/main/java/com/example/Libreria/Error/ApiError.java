package com.example.Libreria.Error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {

    @NonNull
    private HttpStatus estado;

    @Builder.Default
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy hh:mm:ss")
    private LocalDateTime dateTime = LocalDateTime.now();

    @NonNull
    private String menssage;
}
