package com.pets.utility.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Custom annotation to validate species
@Constraint(validatedBy = HealthStatusValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidHealthStatus {
    String message() default "Invalid Health Status";  // Default error message
    Class<?>[] groups() default {};            // Default groups for validation
    Class<? extends Payload>[] payload() default {}; // Payload, for additional metadata
}

