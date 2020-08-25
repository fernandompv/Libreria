package com.example.Libreria.Repository;

import com.example.Libreria.Model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByUsername(String username);
}
