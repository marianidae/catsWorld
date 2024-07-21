package org.softuni.catssss.service.impl;

import org.softuni.catssss.model.dto.CreateOfferDTO;
import org.softuni.catssss.repository.OfferRepository;
import org.softuni.catssss.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }


    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {
        throw new UnsupportedOperationException("");
    }
}
