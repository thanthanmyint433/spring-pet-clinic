package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class vetController {
    @RequestMapping({"/vets","/vets/index","/vets/index.html"})
    public String ListVet(){
        return "vets/index";
    }
}
