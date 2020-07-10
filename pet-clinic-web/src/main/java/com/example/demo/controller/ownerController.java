package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/owners")
@Controller
public class ownerController {
    @RequestMapping({"","/index","/index.html"})
    public String ListOwner(){
        return "owners/index";
    }
}
