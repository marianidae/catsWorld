package org.softuni.catssss.model.dto;



import org.softuni.catssss.model.enums.GenderEnum;

import java.math.BigDecimal;

public record OfferDetailDTO(
        String id,
        String breed,
        String model,
        int age,
        GenderEnum gender,
        BigDecimal price,
        String imageUrl

) {
    public String summary() {
        return breed + " " + model + ", " + age;
    }
}
