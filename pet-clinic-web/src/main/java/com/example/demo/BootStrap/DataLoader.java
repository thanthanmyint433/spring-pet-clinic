package com.example.demo.BootStrap;

import com.example.demo.model.Owner;
import com.example.demo.model.PetType;
import com.example.demo.model.Vet;
import com.example.demo.services.OwnerService;
import com.example.demo.services.PetTypeService;
import com.example.demo.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog=new PetType();
        dog.setName("Dog");
        PetType petTypeDog=petTypeService.save(dog);

        PetType cat=new PetType();
        dog.setName("Cat");
        PetType petTypeCat=petTypeService.save(cat);

        Owner owner1=new Owner();
        owner1.setFirstName("Mi Mi");
        owner1.setLastName("Lwin");
        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setFirstName("Mu Mo");
        owner2.setLastName("Lwin");
        ownerService.save(owner2);

        System.out.println("Loading Owner Service Save------------");

        Vet vet1=new Vet();
        vet1.setFirstName("Nyo");
        vet1.setLastName("Gyi");
        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setFirstName("Min");
        vet2.setLastName("No");
        vetService.save(vet2);
        System.out.println("Loading Vet-----------");


    }
}
