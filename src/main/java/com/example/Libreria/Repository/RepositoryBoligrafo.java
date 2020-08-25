package com.example.Libreria.Repository;

import com.example.Libreria.Model.Boligrafos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBoligrafo extends JpaRepository<Boligrafos, Long> {
}
