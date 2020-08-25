package com.example.Libreria.Repository;

import com.example.Libreria.Model.Libretas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLibreta extends JpaRepository<Libretas, Long> {
}
