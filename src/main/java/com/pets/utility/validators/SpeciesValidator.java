package com.pets.utility.validators;

import com.pets.utility.staticdata.Species;
import com.pets.utility.objectmapper.PetMapper;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SpeciesValidator implements ConstraintValidator<ValidSpecies, String> {

    @Override
    public void initialize(ValidSpecies constraintAnnotation) {
        // You can add any initialization code here if necessary
    }

    @Override
    public boolean isValid(String species, ConstraintValidatorContext context) {
        if (species == null) {
            return true; // @NotNull annotation already handles null cases.
        }

        try {
            // Check if the species is a valid enum value
            return !PetMapper.stringToSpecies(species).equals(Species.ILLEGAL_SPECIES);
        } catch (IllegalArgumentException e) {
            return false; // Invalid species
        }
    }
}
