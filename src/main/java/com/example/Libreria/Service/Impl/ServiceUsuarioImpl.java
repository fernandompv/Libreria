package com.example.Libreria.Service.Impl;

import com.example.Libreria.Model.Usuarios;
import com.example.Libreria.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsuarioImpl extends CustomServiceImpl<Usuarios,Long> {

    @Autowired
    RepositoryUsuario repositoryUsuario;

    @Override
    public JpaRepository<Usuarios, Long> getRepository() {
        return repositoryUsuario;
    }

    public Usuarios findUserByName(String usuario) {

        List<Usuarios> usuarios =  repositoryUsuario.findAll();

        for(Usuarios u : usuarios){
            if (u.getNombre().equals(usuario))
                return u;
        }
        return null;
    }

    public Optional<Usuarios> findUserByUsername(String username) {
        return this.repositoryUsuario.findByUsername(username);
    }
}
