package com.monica.petclinic.services;

import com.monica.petclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);


}
