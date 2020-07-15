package com.example.demo.services;

import com.example.demo.model.Speciality;

import java.util.Set;

public interface SpecialitiesService extends CrudService<Speciality,Long> {

    @Override
    default Set<Speciality> findAll() {
        return null;
    }

    @Override
    default Speciality findById(Long aLong) {
        return null;
    }

    @Override
    default Speciality save(Speciality object) {
        return null;
    }

    @Override
    default void delete(Speciality object) {

    }

    @Override
    default void deleteById(Long aLong) {

    }
}
