package org.softuni.catssss.model.dto;



import java.math.BigDecimal;

public record OfferDetailDTO(
        String id,
        String breed,
        String model,
        int age,
        BigDecimal price,
        String imageUrl

) {
    public String summary() {
        return breed + " " + model + ", " + age;
    }
}
