package com.monica.petclinic.bootstrap;


import com.monica.petclinic.model.Owner;
import com.monica.petclinic.model.Pet;
import com.monica.petclinic.model.PetType;
import com.monica.petclinic.model.Vet;
import com.monica.petclinic.services.OwnerService;
import com.monica.petclinic.services.PetTypeService;
import com.monica.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    //private final PetService petService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType =  petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Bricket");
        owner1.setCity("New York");
        owner1.setTelephone("5664748393");

        Pet michelsPet = new Pet();
        michelsPet.setPetType(savedDogPetType);
        michelsPet.setOwner(owner1);
        michelsPet.setBirthDate(LocalDate.now());
        michelsPet.setName("Rosco");
        owner1.getPets().add(michelsPet);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glinamer");
        owner2.setAddress("345 Linu");
        owner2.setCity("London");
        owner2.setTelephone("345677");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Monica");
        owner2.getPets().add(fionasCat);


        ownerService.save(owner2);
        System.out.println("Owners are loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Ake");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Juman");
        vet2.setLastName("Torayev");

        vetService.save(vet2);

        System.out.println("Vets are loaded");

    }
}
