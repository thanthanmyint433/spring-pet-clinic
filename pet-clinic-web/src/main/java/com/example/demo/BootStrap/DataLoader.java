package com.example.demo.BootStrap;

import com.example.demo.model.Owner;
import com.example.demo.model.Vet;
import com.example.demo.services.OwnerService;
import com.example.demo.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1=new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Mi Mi");
        owner1.setLastName("Lwin");
        ownerService.save(owner1);

        Owner owner2=new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Mu Mo");
        owner2.setLastName("Lwin");
        ownerService.save(owner2);

        System.out.println("Loading Owner Service Save------------");

        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Nyo");
        vet1.setLastName("Gyi");
        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Min");
        vet2.setLastName("No");
        vetService.save(vet2);
        System.out.println("Loading Vet-----------");


    }
}
