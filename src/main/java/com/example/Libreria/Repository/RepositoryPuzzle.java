package com.example.Libreria.Repository;

import com.example.Libreria.Model.Puzzles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPuzzle extends JpaRepository<Puzzles, Long> {
}
