package com.example.demo.services;

import com.sun.xml.bind.v2.model.core.ID;

import java.util.Set;

public interface CrudService<T,Id> {
    Set<T> findAll();
    T findById(ID id);
    T save(Object object);
    void delete(T object);
    void deleteById(ID id);
}
