package com.monica.petclinic.bootstrap;


import com.monica.petclinic.models.*;
import com.monica.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    //private final PetService petService;
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

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Bricket");
        owner1.setCity("New York");
        owner1.setTelephone("5664748393");

        //owner1.builder().id(2L).address("AVaa");

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
        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");

        visitService.save(catVisit);

        System.out.println("Owners are loaded");

        Speciality radiolody = new Speciality();
        radiolody.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiolody);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dendestry = new Speciality();
        dendestry.setDescription("Dentestry");
        Speciality savedDentestry = specialityService.save(dendestry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Ake");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Juman");
        vet2.setLastName("Torayev");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vets are loaded");
    }
}
