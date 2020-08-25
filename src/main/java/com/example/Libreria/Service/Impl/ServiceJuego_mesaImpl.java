package com.example.Libreria.Service.Impl;

import com.example.Libreria.Model.Juego_mesa;
import com.example.Libreria.Repository.RepositoryJuego_mesa;
import com.example.Libreria.Service.ServiceJuego_mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceJuego_mesaImpl extends CustomServiceImpl<Juego_mesa,Long> implements ServiceJuego_mesa {

    @Autowired
    RepositoryJuego_mesa repositoryJuego_mesa;

    @Override
    public JpaRepository<Juego_mesa, Long> getRepository() {
        return repositoryJuego_mesa;
    }
}
