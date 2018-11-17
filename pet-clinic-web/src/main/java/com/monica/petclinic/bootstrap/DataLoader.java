package com.monica.petclinic.bootstrap;


import com.monica.petclinic.model.Owner;
import com.monica.petclinic.model.Vet;
import com.monica.petclinic.services.OwnerService;
import com.monica.petclinic.services.VetService;
import com.monica.petclinic.services.map.OwnerServiceMap;
import com.monica.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    //private final PetService petService;


    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
        //this.petService = petService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2l);
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glinamer");

        ownerService.save(owner2);
        System.out.println("Owners are loaded");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Ake");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Juman");
        vet2.setLastName("Torayev");

        vetService.save(vet2);

        System.out.println("Vets are loaded");

    }
}