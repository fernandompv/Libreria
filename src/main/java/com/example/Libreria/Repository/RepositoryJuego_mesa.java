package com.example.Libreria.Repository;

import com.example.Libreria.Model.Juego_mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryJuego_mesa extends JpaRepository<Juego_mesa, Long> {
}
