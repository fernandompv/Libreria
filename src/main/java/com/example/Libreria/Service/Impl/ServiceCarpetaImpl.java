package com.example.Libreria.Service.Impl;

import com.example.Libreria.Model.Carpetas;
import com.example.Libreria.Repository.RepositoryCarpeta;
import com.example.Libreria.Service.ServiceCarpeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceCarpetaImpl extends CustomServiceImpl<Carpetas,Long> implements ServiceCarpeta {

    @Autowired
    RepositoryCarpeta repositoryCarpeta;

    @Override
    public JpaRepository<Carpetas, Long> getRepository() {
        return repositoryCarpeta;
    }
}
