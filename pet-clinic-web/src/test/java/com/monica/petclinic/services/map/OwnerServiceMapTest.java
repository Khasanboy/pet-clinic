package com.monica.petclinic.services.map;

import com.monica.petclinic.models.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;

    final Long ownerId = 1L;

    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet;
        ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());

    }

    @Test
    void findById() {

        Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(ownerId, owner.getId());

    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveWithoutId() {
        Owner owner3 = Owner.builder().build();

        Owner savedOwner2 = ownerServiceMap.save(owner3);

        assertNotNull(savedOwner2);
        assertNotNull(savedOwner2.getId());

    }

    @Test
    void delete() {

        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        assertNull(ownerServiceMap.findById(ownerId));
    }

    @Test
    void deleteById() {

        ownerServiceMap.deleteById(ownerId);

        assertEquals(0, ownerServiceMap.findAll().size());

    }

    @Test
    void findByLastName() {

        Owner owner = ownerServiceMap.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());

    }

    @Test
    void findByLastNameNotFound() {

        Owner owner = ownerServiceMap.findByLastName("NotFound");

        assertNull(owner);

    }
}