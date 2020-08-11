package com.example.demo.BootStrap;

import com.example.demo.model.*;
import com.example.demo.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader  implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
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
        PetType saveDogPetType=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Cat");
        PetType saveCatPetType=petTypeService.save(cat);

        Speciality radiology=new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology=specialityService.save(radiology);

        Speciality surgery=new Speciality();
        surgery.setDescription("Radiology");
        Speciality savedSurgery=specialityService.save(surgery);

        Speciality dentistry=new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry=specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("132 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("12345555");

        //Owner.builder().address("ASDF").build();

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPetSet().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("132 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("12347777");

        Pet fionasCat=new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(saveCatPetType);
        owner2.getPetSet().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setLocalDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        System.out.println("Load Sneezy Kitty.........");
        visitService.save(catVisit);

        System.out.println("Load Owners.........");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Alex");
        vet1.getSpecialitySet().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Gray");
        vet2.setLastName("Han");
        vet2.getSpecialitySet().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Load Vets.........");
//        PetType dog=new PetType();
//        dog.setName("Dog");
//        PetType petTypeDog=petTypeService.save(dog);
//
//        PetType cat=new PetType();
//        dog.setName("Cat");
//        PetType petTypeCat=petTypeService.save(cat);
//
//        Owner owner1=new Owner();
//        owner1.setFirstName("Mi Mi");
//        owner1.setLastName("Lwin");
//        owner1.setAddress("Yangon");
//        owner1.setCity("Mayangone");
//        owner1.setTelephone("0999999999");
//        ownerService.save(owner1);
//
//        Pet pet=new Pet();
//        pet.setPetType(petTypeDog);
//        pet.setOwner(owner1);
//        pet.setBirthDate(LocalDate.now());
//        pet.setName("Rosco");
//        owner1.getPetSet().add(pet);
//
//        Speciality radio=new Speciality();
//        radio.setDescription("RadioLogy");
//        Speciality saveSpecialityRadio=specialityService.save(radio);
//
//        Speciality sugery=new Speciality();
//        sugery.setDescription("sugery");
//        Speciality saveSpecialitySugery=specialityService.save(sugery);
//
//        Speciality rank=new Speciality();
//        rank.setDescription("rank");
//        Speciality saveSpecialityRank=specialityService.save(rank);
//
//        Owner owner2=new Owner();
//        owner2.setFirstName("Mu Mo");
//        owner2.setLastName("Lwin");
//        owner2.setAddress("Mandalay");
//        owner2.setCity("nyanung");
//        owner2.setTelephone("090000");
//        ownerService.save(owner2);
//
//
//
//        Pet pet2=new Pet();
//        pet.setPetType(petTypeCat);
//        pet.setOwner(owner2);
//        pet.setBirthDate(LocalDate.now());
//        pet.setName("Coco");
//        owner1.getPetSet().add(pet2);
//
//        Visit visit=new Visit();
//        visit.setPet(pet2);
//
//        System.out.println("Loading Owner Service Save------------");
//
//        Vet vet1=new Vet();
//        vet1.setFirstName("Nyo");
//        vet1.setLastName("Gyi");
//        vet1.getSpecialitySet().add(saveSpecialityRadio);
//        vetService.save(vet1);
//
//        Vet vet2=new Vet();
//        vet2.setFirstName("Min");
//        vet2.setLastName("No");
//        vet2.getSpecialitySet().add(saveSpecialitySugery);
//        vetService.save(vet2);
//        System.out.println("Loading Vet-----------");
    }
}
