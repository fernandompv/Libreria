package com.example.Libreria.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "linea_pedido")
@Builder
public class Linea_pedido{
    @Id
    private Long id_linea;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<Tipo_producto> tipo;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_pedido")
    private Pedidos pedido;

    private String nombre;

    private float precioUnidad;

    private int cantidad;

    private float subtotal;
}
