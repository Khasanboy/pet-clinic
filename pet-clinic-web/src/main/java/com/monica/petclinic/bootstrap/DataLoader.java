package com.monica.petclinic.bootstrap;


import com.monica.petclinic.model.Owner;
import com.monica.petclinic.model.Vet;
import com.monica.petclinic.services.OwnerService;
import com.monica.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    //private final PetService petService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glinamer");

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
