package com.example.Libreria.Service.Impl;

import com.example.Libreria.Model.Libros;
import com.example.Libreria.Repository.RepositoryLibro;
import com.example.Libreria.Service.ServiceLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceLibroImpl extends CustomServiceImpl<Libros,Long> implements ServiceLibro {

    @Autowired
    RepositoryLibro repositoryLibro;

    @Override
    public JpaRepository<Libros, Long> getRepository() {
        return repositoryLibro;
    }
}
