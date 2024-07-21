package org.softuni.catssss.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BreedsController {

    @GetMapping("/breeds")
    public String allBreeds(){
    return "breeds";
    }
}
