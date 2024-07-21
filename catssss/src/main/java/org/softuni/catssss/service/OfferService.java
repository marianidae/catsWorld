package org.softuni.catssss.service;

import org.softuni.catssss.model.dto.CreateOfferDTO;

import java.util.UUID;

public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO);

}
