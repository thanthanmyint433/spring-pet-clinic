package com.example.demo.services.Map;

import com.example.demo.model.Owner;
import com.example.demo.services.OwnerService;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(ID id) {
        return null;
    }

    @Override
    public Owner save(Object object) {
        return null;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void delete(Owner object) {
         super.delete(object);
    }

    @Override
    public void deleteById(ID id) {

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
