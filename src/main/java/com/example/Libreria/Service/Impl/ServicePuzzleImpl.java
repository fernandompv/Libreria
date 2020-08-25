package com.example.Libreria.Service.Impl;

import com.example.Libreria.Model.Puzzles;
import com.example.Libreria.Repository.RepositoryPuzzle;
import com.example.Libreria.Service.ServicePuzzle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ServicePuzzleImpl extends CustomServiceImpl<Puzzles,Long> implements ServicePuzzle {

    @Autowired
    RepositoryPuzzle repositoryPuzzle;

    @Override
    public JpaRepository<Puzzles, Long> getRepository() {
        return repositoryPuzzle;
    }
}
