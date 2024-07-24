package org.softuni.catssss.web;

import org.softuni.catssss.model.dto.CreateOfferDTO;
import org.softuni.catssss.model.enums.GenderEnum;
import org.softuni.catssss.model.enums.TypeBreedEnum;
import org.softuni.catssss.service.BreedsService;
import org.softuni.catssss.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final BreedsService breedsService;

    public OfferController(OfferService offerService, BreedsService breedsService) {
        this.offerService = offerService;
        this.breedsService = breedsService;
    }

    @ModelAttribute("models")
    public TypeBreedEnum[] models() {
        return TypeBreedEnum.values();
    }

    @ModelAttribute("genders")
    public GenderEnum[] genders() {
        return GenderEnum.values();
    }
    @GetMapping("/all")
    public String all() {
        return "offers";
    }

    @GetMapping("/add")
    public String add(Model model) {

        model.addAttribute("breeds", breedsService.getAllBreeds());

        return "offer-add";
    }

    @PostMapping("/add")
    public String add(CreateOfferDTO createOfferDTO) {
        offerService.createOffer(createOfferDTO);
        return "index";
    }

    @GetMapping("/{uuid}/details")
    public String details(@PathVariable("uuid") UUID uuid) {
        return "details";
    }
}
