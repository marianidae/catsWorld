package org.softuni.catssss.model.dto;

import org.softuni.catssss.model.enums.ModelCategoryEnum;

public record CreateOfferDTO(String description,
                             ModelCategoryEnum model,
                             Long modelId,
                             String imageUrl,
                             Integer price,
                             Integer year) {
}
