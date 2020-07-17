package com.example.demo.BootStrap;

import com.example.demo.model.*;
import com.example.demo.services.OwnerService;
import com.example.demo.services.PetTypeService;
import com.example.demo.services.SpecialityService;
import com.example.demo.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count=petTypeService.findAll().size();
        if (count==0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog=new PetType();
        dog.setName("Dog");
        PetType petTypeDog=petTypeService.save(dog);

        PetType cat=new PetType();
        dog.setName("Cat");
        PetType petTypeCat=petTypeService.save(cat);

        Owner owner1=new Owner();
        owner1.setFirstName("Mi Mi");
        owner1.setLastName("Lwin");
        owner1.setAddress("Yangon");
        owner1.setCity("Mayangone");
        owner1.setTelephone("0999999999");
        ownerService.save(owner1);

        Pet pet=new Pet();
        pet.setPetType(petTypeDog);
        pet.setOwner(owner1);
        pet.setBirthDate(LocalDate.now());
        pet.setName("Rosco");
        owner1.getPetSet().add(pet);

        Speciality radio=new Speciality();
        radio.setDescription("RadioLogy");
        Speciality saveSpecialityRadio=specialityService.save(radio);

        Speciality sugery=new Speciality();
        sugery.setDescription("sugery");
        Speciality saveSpecialitySugery=specialityService.save(sugery);

        Speciality rank=new Speciality();
        rank.setDescription("rank");
        Speciality saveSpecialityRank=specialityService.save(rank);

        Owner owner2=new Owner();
        owner2.setFirstName("Mu Mo");
        owner2.setLastName("Lwin");
        owner2.setAddress("Mandalay");
        owner2.setCity("nyanung");
        owner2.setTelephone("090000");
        ownerService.save(owner2);

        Pet pet2=new Pet();
        pet.setPetType(petTypeCat);
        pet.setOwner(owner2);
        pet.setBirthDate(LocalDate.now());
        pet.setName("Coco");
        owner1.getPetSet().add(pet2);

        System.out.println("Loading Owner Service Save------------");

        Vet vet1=new Vet();
        vet1.setFirstName("Nyo");
        vet1.setLastName("Gyi");
        vet1.getSpecialitySet().add(saveSpecialityRadio);
        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setFirstName("Min");
        vet2.setLastName("No");
        vet2.getSpecialitySet().add(saveSpecialitySugery);
        vetService.save(vet2);
        System.out.println("Loading Vet-----------");
    }
}
