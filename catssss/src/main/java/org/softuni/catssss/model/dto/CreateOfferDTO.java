package org.softuni.catssss.model.dto;

import org.softuni.catssss.model.enums.GenderEnum;
import org.softuni.catssss.model.enums.ModelCategoryEnum;

public record CreateOfferDTO(String description,
                             ModelCategoryEnum model,
                             Long modelId,
                             GenderEnum gender,
                             String imageUrl,
                             Integer price,
                             Integer year) {
}
