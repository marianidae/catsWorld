package org.softuni.catssss.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.softuni.catssss.model.enums.GenderEnum;
import org.softuni.catssss.model.enums.TypeBreedEnum;

public record CreateOfferDTO(
                            @NotEmpty
                            @Size(min = 5, max = 512)
                            String description,
                             @NotNull
                             TypeBreedEnum typeBreed,
                             @Positive
                             @NotNull
                             Long modelId,
                             @NotNull
                             GenderEnum gender,
                             @NotEmpty
                             String imageUrl,
                             @Positive
                             @NotNull
                             Integer price,
                             @Positive
                             @NotNull
                             Integer year) {

 public static CreateOfferDTO empty()  {
    return new CreateOfferDTO(null,null,null,null,null,null,null);
 }
}
