package org.softuni.catssss.web;

import org.softuni.catssss.model.dto.CreateOfferDTO;
import org.softuni.catssss.model.enums.GenderEnum;
import org.softuni.catssss.model.enums.ModelCategoryEnum;
import org.softuni.catssss.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @ModelAttribute("models")
    public ModelCategoryEnum[] models() {
        return ModelCategoryEnum.values();
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
