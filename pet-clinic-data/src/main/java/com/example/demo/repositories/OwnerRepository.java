package com.example.demo.repositories;

import com.example.demo.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
   Owner findByLastName(String lastName);

}
