package com.example.Libreria.Repository;

import com.example.Libreria.Model.Carpetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCarpeta extends JpaRepository<Carpetas, Long> {
}
