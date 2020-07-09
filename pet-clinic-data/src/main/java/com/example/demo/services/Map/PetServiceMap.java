package com.example.demo.services.Map;

import com.example.demo.model.Pet;
import com.example.demo.services.CrudService;
import com.sun.xml.bind.v2.model.core.ID;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(ID id) {
        return null;
    }

    @Override
    public Pet save(Object object) {
        return null;
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }


    public Pet save(Pet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(ID id) {

    }
}
