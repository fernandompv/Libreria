package com.example.Libreria.Repository;

import com.example.Libreria.Model.Linea_pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLinea_pedido extends JpaRepository<Linea_pedido,Long> {
}
