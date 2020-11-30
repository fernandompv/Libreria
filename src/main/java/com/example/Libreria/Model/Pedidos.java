package com.example.Libreria.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
@Builder
public class Pedidos {

    @Id
    private Long id_pedido;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    @EqualsAndHashCode.Exclude @ToString.Exclude
    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    @Builder.Default
    private Set<Linea_pedido> linea = new HashSet<>();

    @CreatedDate
    private LocalDateTime date;

    private float total;

}
