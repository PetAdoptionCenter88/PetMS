package com.pets.staticdata.util;

import com.pets.staticdata.Breed;
import com.pets.staticdata.HealthStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class HealthStatusValidator implements ConstraintValidator<ValidHealthStatus, List<String>> {

    @Override
    public void initialize(ValidHealthStatus constraintAnnotation) {
        // You can add any initialization code here if necessary
    }

    @Override
    public boolean isValid(List<String> healthStatusList, ConstraintValidatorContext context) {
        if (healthStatusList == null || healthStatusList.isEmpty() ) {
            return true; // @NotNull annotation already handles null cases.
        }

        try {
            // Check if the Health Status is a valid enum value
            return !PetMapper.stringListToHealthStatusList(healthStatusList).contains(HealthStatus.ILLEGAL_HEALTH_STATUS);
        } catch (IllegalArgumentException e) {
            return false; // Invalid Health Status
        }
    }
}
