package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pet_type")
public class PetType extends BaseEntity {
/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;*/

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
