package com.example.demo.controller;

import com.example.demo.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class vetController {
    private final VetService vetService;

    public vetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vets/index","/vets/index.html"})
    public String ListVet(Model model){
        model.addAttribute("vets",vetService.findAll());
        System.out.println("vet model"+model);
        return "vets/index";
    }
}
