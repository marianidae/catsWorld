package org.softuni.catssss.service.impl;

import org.softuni.catssss.model.dto.BreedDTO;
import org.softuni.catssss.model.dto.ModelDTO;
import org.softuni.catssss.repository.BreedRepository;
import org.softuni.catssss.service.BreedsService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BreedServiceImpl implements BreedsService {

    private final BreedRepository breedRepository;

    public BreedServiceImpl(BreedRepository breedRepository) {
        this.breedRepository = breedRepository;
    }

    @Override
    public List<BreedDTO> getAllBreeds() {

        return breedRepository.getAllBreeds().stream()
                .map(breed -> new BreedDTO(
                        breed.getName(),
                        breed.getModels().stream()
                                .map(model -> new ModelDTO(model.getId(), model.getName()))
                                .sorted(Comparator.comparing(ModelDTO::name))
                                .collect(Collectors.toList())
                ))
                .sorted(Comparator.comparing(BreedDTO::name))
                .collect(Collectors.toList());
    }
}
