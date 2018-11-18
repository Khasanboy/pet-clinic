package com.monica.petclinic.controllers;

import com.monica.petclinic.services.VetService;
import com.monica.petclinic.services.map.VetServiceMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetServiceMap vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
    public String listVets(Model model){
        model.addAttribute("vets",  vetService.findAll());
        return "vets/index";

    }

}
