package com.example.Libreria.Service.Impl;

import com.example.Libreria.Model.Boligrafos;
import com.example.Libreria.Repository.RepositoryBoligrafo;
import com.example.Libreria.Service.ServiceBoligrafo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBoligrafoImpl extends CustomServiceImpl<Boligrafos, Long> implements ServiceBoligrafo {

    @Autowired
    RepositoryBoligrafo repository;

    @Override
    public JpaRepository<Boligrafos, Long> getRepository() {
        return repository;
    }

    @Override
    public Boligrafos findByNombre(String boligrafo) {

        List<Boligrafos> boligrafos =  repository.findAll();

        for(Boligrafos u : boligrafos){
            if (u.getNombre().equals(boligrafo))
                return u;
        }
        return null;
    }

}
