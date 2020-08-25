package com.example.Libreria.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CustomService<T,ID extends Serializable > {

    public List<T> findAll();

    public Optional<T> findById(ID id);

    public T save(T entity);

    public T edit(ID id, T entity);

    public void deleteById(ID id);
}
