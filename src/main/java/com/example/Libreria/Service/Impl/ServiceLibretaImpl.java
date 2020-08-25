package com.example.Libreria.Service.Impl;

import com.example.Libreria.Model.Libretas;
import com.example.Libreria.Repository.RepositoryLibreta;
import com.example.Libreria.Service.ServiceLibreta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceLibretaImpl extends CustomServiceImpl<Libretas,Long> implements ServiceLibreta {

    @Autowired
    RepositoryLibreta repositoryLibreta;

    @Override
    public JpaRepository<Libretas, Long> getRepository() {
        return repositoryLibreta;
    }
}
