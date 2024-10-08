package org.softuni.catssss.web;

import jakarta.validation.Valid;
import org.softuni.catssss.model.dto.CreateOfferDTO;
import org.softuni.catssss.model.dto.OfferDetailDTO;
import org.softuni.catssss.model.enums.GenderEnum;
import org.softuni.catssss.model.enums.TypeBreedEnum;
import org.softuni.catssss.service.BreedsService;
import org.softuni.catssss.service.OfferService;
import org.softuni.catssss.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;
    private final BreedsService breedsService;

    public OfferController(OfferService offerService, BreedsService breedsService) {
        this.offerService = offerService;
        this.breedsService = breedsService;
    }

    @ModelAttribute("typeBreed")
    public TypeBreedEnum[] typeBreed() {
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

        if (!model.containsAttribute("createOfferDTO")){
            model.addAttribute("createOfferDTO", CreateOfferDTO.empty());
        }

        model.addAttribute("breeds", breedsService.getAllBreeds());

        return "offer-add";
    }

    @PostMapping("/add")
    public String add(@Valid CreateOfferDTO createOfferDTO,
                      BindingResult bindingResult,
                      RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("createOfferDTO", createOfferDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.createOfferDTO", bindingResult);
            return "redirect:/offer/add";
        }

        UUID newOfferUUID = offerService.createOffer(createOfferDTO);
        return "redirect:/offer/" + newOfferUUID;
    }

    @GetMapping("/{uuid}")
    public String details(@PathVariable("uuid") UUID uuid, Model model) {

        OfferDetailDTO offerDetailDTO = offerService
                .getOfferDetail(uuid)
                .orElseThrow(() -> new ObjectNotFoundException("Offer with uuid " + uuid + " not found!"));

        model.addAttribute("offer", offerDetailDTO);

        return "details";
    }

    @DeleteMapping("/{uuid}")
    public String delete(@PathVariable("uuid") UUID uuid) {

        offerService.deleteOffer(uuid);

        return "redirect:/offers/all";
    }

}
