package com.example.demo.services.Map;

import com.example.demo.model.Owner;
import com.example.demo.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {
    OwnerServiceMap ownerServiceMap;
    final Long ownerId=1L;
    final String lastName="Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap=new OwnerServiceMap(new PetTypeMapService(),new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owner=ownerServiceMap.findAll();
        assertEquals(1,owner.size());
    }

    @Test
    void deleteById() {
//        Owner owner=ownerServiceMap.deleteById(ownerId);
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0,ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id=2L;
        Owner owner2=Owner.builder().id(ownerId).build();
        Owner savedOwner=ownerServiceMap.save(owner2);
        assertEquals(id,savedOwner.getId());
    }
    @Test
    void saveNoId() {

        Owner saveOwner=ownerServiceMap.save(Owner.builder().build());
        assertNotNull(saveOwner);
        assertNotNull(saveOwner.getId());

    }

    @Test
    void findById() {
        Owner owner=ownerServiceMap.findById(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void findByLastName() {
        Owner smith=ownerServiceMap.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(ownerId,smith.getId());
    }
    @Test
    void findByLastNameNotFound() {
        Owner smith=ownerServiceMap.findByLastName("foo");
        assertNull(smith);

    }
}