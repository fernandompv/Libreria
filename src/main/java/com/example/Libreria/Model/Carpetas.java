package com.example.Libreria.Model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carpetas")
public class Carpetas {

    @ApiModelProperty(value="ID de la carpeta", dataType="long",  example="1", position=1)
    @SequenceGenerator(name = "seq",sequenceName = "id_carpetas",allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id_carpetas;

    @ApiModelProperty(value="Nombre de la carpeta o  marca", dataType="String", example="Dellivery", position=2)
    private String nombre;

    @ApiModelProperty(value="Color de la carpeta", dataType="String", example="Rojo", position=3)
    private String color;

    @ApiModelProperty(value="Precio de la carpeta", dataType="Float", example="1.50", position=4)
    private float precio;

    @ApiModelProperty(value="Stock que queda de la carpeta", dataType="String", example="20", position=5)
    private String stock;
}
