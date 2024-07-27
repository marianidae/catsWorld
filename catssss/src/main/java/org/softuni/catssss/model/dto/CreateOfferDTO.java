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
                             @NotNull(message = "Breed must be provided")
                             TypeBreedEnum typeBreed,
                             @Positive
                             @NotNull(message = "Model must be provided")
                             Long modelId,
                             @NotNull(message = "Gender must be provided")
                             GenderEnum gender,
                             @NotEmpty(message = "Image must be provided")
                             String imageUrl,
                             @Positive
                             @NotNull(message = "Price must be provided")
                             Integer price,
                             @Positive
                             @NotNull(message = "Age must be provided")
                             Integer age) {

 public static CreateOfferDTO empty()  {
    return new CreateOfferDTO(null,null,null,null,null,null,null);
 }
}
