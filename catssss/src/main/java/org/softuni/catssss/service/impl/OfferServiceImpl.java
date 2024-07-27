package org.softuni.catssss.service.impl;

import org.softuni.catssss.model.dto.CreateOfferDTO;
import org.softuni.catssss.model.entity.ModelEntity;
import org.softuni.catssss.model.entity.OfferEntity;
import org.softuni.catssss.repository.ModelRepository;
import org.softuni.catssss.repository.OfferRepository;
import org.softuni.catssss.service.OfferService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository,
                            ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
    }


    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {

        OfferEntity newOffer = map(createOfferDTO);
        ModelEntity modelEntity = modelRepository.findById(createOfferDTO.modelId()).orElseThrow(() ->
                new IllegalArgumentException("Model with id " + createOfferDTO.modelId() + " not found!"));

        newOffer.setModel(modelEntity);

        newOffer = offerRepository.save(newOffer);
        return newOffer.getUuid();
    }

    private static OfferEntity map(CreateOfferDTO createOfferDTO) {
        return new OfferEntity()
                .setUuid(UUID.randomUUID())
                .setDescription(createOfferDTO.description())
                .setImageUrl(createOfferDTO.imageUrl())
                .setPrice(BigDecimal.valueOf(createOfferDTO.price()))
                .setYear(createOfferDTO.age());
    }
}
