package com.example.Libreria.Service.Impl;

import com.example.Libreria.Model.Linea_pedido;
import com.example.Libreria.Repository.RepositoryLinea_pedido;
import com.example.Libreria.Service.ServiceLinea_pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceLinea_pedidoImpl extends CustomServiceImpl<Linea_pedido,Long> implements ServiceLinea_pedido {

    @Autowired
    RepositoryLinea_pedido repositoryLinea_pedido;

    @Override
    public JpaRepository<Linea_pedido, Long> getRepository() {
        return repositoryLinea_pedido;
    }
}
