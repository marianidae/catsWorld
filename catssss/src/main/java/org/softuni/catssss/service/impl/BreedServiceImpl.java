package org.softuni.catssss.service.impl;

import org.softuni.catssss.model.dto.BreedDTO;
import org.softuni.catssss.model.dto.ModelDTO;
import org.softuni.catssss.model.entity.ModelEntity;
import org.softuni.catssss.repository.ModelRepository;
import org.softuni.catssss.service.BreedsService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BreedServiceImpl implements BreedsService {

    private final ModelRepository modelRepository;

    public BreedServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<BreedDTO> getAllBreeds() {

        Map<String, BreedDTO> breeds = new TreeMap<>();
        for (ModelEntity model : modelRepository.findAll()) {
            if (!breeds.containsKey(model.getBreed().getName())) {
                breeds.put(model.getBreed().getName(),
                        new BreedDTO(model.getBreed().getName(),
                                new ArrayList<>()));
            }

            breeds.get(model.getBreed().getName()).models().add(new ModelDTO(model.getId(), model.getName()));
        }
        return breeds.values().stream().toList();
    }
}
