package org.softuni.catssss.service.impl;

import jakarta.transaction.Transactional;
import org.softuni.catssss.model.dto.CreateOfferDTO;
import org.softuni.catssss.model.dto.OfferDetailDTO;
import org.softuni.catssss.model.dto.OfferSummaryDTO;
import org.softuni.catssss.model.entity.ModelEntity;
import org.softuni.catssss.model.entity.OfferEntity;
import org.softuni.catssss.repository.ModelRepository;
import org.softuni.catssss.repository.OfferRepository;
import org.softuni.catssss.service.OfferService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
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

    @Override
    public Page<OfferSummaryDTO> getAllOffers(Pageable pageable) {
        return offerRepository
                .findAll(pageable)
                .map(OfferServiceImpl::mapAsSummary);
    }

    @Override
    public Optional<OfferDetailDTO> getOfferDetail(UUID offerUUID) {
        return offerRepository
                .findByUuid(offerUUID)
                .map(OfferServiceImpl::mapAsDetails);
    }

    @Override
    @Transactional
    public void deleteOffer(UUID offerUUID) {
        offerRepository.deleteByUuid(offerUUID);
    }


    private static OfferDetailDTO mapAsDetails(OfferEntity offerEntity) {
        return new OfferDetailDTO(
                offerEntity.getUuid().toString(),
                offerEntity.getModel().getBreed().getName(),
                offerEntity.getModel().getName(),
                offerEntity.getAge(),
                offerEntity.getGender(),
                offerEntity.getPrice(),
                offerEntity.getImageUrl());
    }

    private static OfferSummaryDTO mapAsSummary(OfferEntity offerEntity) {
        return new OfferSummaryDTO(
                offerEntity.getUuid().toString(),
                offerEntity.getModel().getBreed().getName(),
                offerEntity.getModel().getName(),
                offerEntity.getAge(),
                offerEntity.getGender(),
                offerEntity.getPrice(),
                offerEntity.getImageUrl());
    }

    private static OfferEntity map(CreateOfferDTO createOfferDTO) {
        return new OfferEntity()
                .setUuid(UUID.randomUUID())
                .setDescription(createOfferDTO.description())
                .setImageUrl(createOfferDTO.imageUrl())
                .setPrice(BigDecimal.valueOf(createOfferDTO.price()))
                .setAge(createOfferDTO.age());
    }
}
