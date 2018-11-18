package com.monica.petclinic.controllers;

import com.monica.petclinic.services.map.PetServiceMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetController {

    private final PetServiceMap petServiceMap;

    @Autowired
    public PetController(PetServiceMap petServiceMap) {
        this.petServiceMap = petServiceMap;
    }

    @RequestMapping({"/pets", "/pets/index", "/pets/index.html"})
    public String listPets(Model model){
        model.addAttribute("pets", petServiceMap.findAll());

        return "pets/index";
    }

}
