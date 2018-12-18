package com.monica.petclinic.repositories;

import com.monica.petclinic.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findByLastName(String lastName);

}
