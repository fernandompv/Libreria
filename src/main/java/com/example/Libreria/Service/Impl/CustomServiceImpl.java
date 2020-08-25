package com.example.Libreria.Service.Impl;

import com.example.Libreria.Service.CustomService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public abstract class CustomServiceImpl<T,ID extends Serializable> implements CustomService<T,ID> {


    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        if (getRepository().findById(id).isPresent()){
            return getRepository().findById(id);
        }else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T edit(ID id, T entity) {
        if (getRepository().findById(id).isPresent())
            return getRepository().save(entity);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @Override
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    public abstract JpaRepository<T,ID> getRepository();
}
