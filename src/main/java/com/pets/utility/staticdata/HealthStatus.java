package com.pets.utility.staticdata;

import java.util.List;

public enum HealthStatus {
    HEALTHY("Healthy"),
    VACCINATED("Vaccinated"),
    NEUTERED("Neutered"),
    DEWORMED("Dewormed"),
    NEEDS_MEDICAL_CARE("Needs_Medical_Care"),
    UNDER_TREATMENT("Under_Treatment"),
    RECOVERING("Recovering"),
    UNKNOWN("Unknown"),
    ILLEGAL_HEALTH_STATUS("Illegal_Health_Status");;

    private final String displayName;

    HealthStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    public static List<HealthStatus> getRequireMedicalCare(){
        return List.of(HealthStatus.NEEDS_MEDICAL_CARE,HealthStatus.UNDER_TREATMENT);
    }


}