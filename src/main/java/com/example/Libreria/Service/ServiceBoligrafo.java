package com.example.Libreria.Service;

import com.example.Libreria.Model.Boligrafos;

public interface ServiceBoligrafo extends CustomService<Boligrafos,Long> {
    public Boligrafos findByNombre(String boligrafo);
}
