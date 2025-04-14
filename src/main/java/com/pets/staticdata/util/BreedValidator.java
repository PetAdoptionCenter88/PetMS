package com.pets.staticdata.util;

import com.pets.staticdata.Breed;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BreedValidator implements ConstraintValidator<ValidBreed, String> {

    @Override
    public void initialize(ValidBreed constraintAnnotation) {
        // You can add any initialization code here if necessary
    }

    @Override
    public boolean isValid(String breed, ConstraintValidatorContext context) {
        if (breed == null) {
            return true; // @NotNull annotation already handles null cases.
        }

        try {
            // Check if the Breed is a valid enum value
            return !PetMapper.stringToBreed(breed).equals(Breed.ILLEGAL_BREED);
        } catch (IllegalArgumentException e) {
            return false; // Invalid Breed
        }
    }
}
