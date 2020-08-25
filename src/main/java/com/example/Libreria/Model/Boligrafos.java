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
@Table(name = "boligrafos")
public class Boligrafos {

    @ApiModelProperty(value="ID del boligrafo", dataType="long",  example="1", position=1)
    @SequenceGenerator(name = "seq",sequenceName = "id_boligrafo",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @Id
    private Long id_boligrafo;

    @ApiModelProperty(value="Nombre del boligrafo o marca", dataType="String", example="Pilot", position=2)
    @Column
    private String nombre;

    @ApiModelProperty(value="Color del boligrafo", dataType="String", example="Rojo", position=3)
    @Column
    private String color;

    @ApiModelProperty(value="Precio del boligrafo", dataType="Float", example="1.50", position=4)
    @Column
    private float precio;

    @ApiModelProperty(value="Stock que queda del boligrafo", dataType="String", example="50", position=5)
    @Column
    private String stock;
}
