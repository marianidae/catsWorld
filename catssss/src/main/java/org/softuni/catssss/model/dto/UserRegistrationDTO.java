package org.softuni.catssss.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.softuni.catssss.model.validations.FieldMatch;
import org.softuni.catssss.model.validations.UniqueUserEmail;
@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords should match."
)
public record UserRegistrationDTO(
        @NotEmpty
        String firstName,
        @NotEmpty
        String lastName,
        @NotNull @Email @UniqueUserEmail
        String email,
        String password,
        String confirmPassword) {

    public String fullName() {
        return firstName + " " + lastName;
    }
}
