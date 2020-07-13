package com.example.demo.services.Map;

import com.example.demo.model.Vet;
import com.example.demo.services.VetService;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(ID id) {
        return null;
    }

    @Override
    public Vet save(Object object) {
        return null;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }


    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(ID id) {

    }

}
