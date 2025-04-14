package com.pets.staticdata.util;

import com.pets.document.Pet;
import com.pets.dto.PetDTO;
import com.pets.staticdata.*;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PetMapper {

    @Mapping(source = "species", target = "species", qualifiedByName = "stringToSpecies")
    @Mapping(source = "breed", target = "breed", qualifiedByName = "stringToBreed")
    @Mapping(source = "healthStatus", target = "healthStatus", qualifiedByName = "stringListToHealthStatusList")
    Pet toEntity(PetDTO dto);

    @Mapping(source = "breed", target = "breed", qualifiedByName = "breedToString")
    @Mapping(source = "species", target = "species", qualifiedByName = "speciesToString")
    @Mapping(source = "healthStatus", target = "healthStatus", qualifiedByName = "healthStatusListToStringList")
    PetDTO toDto(Pet pet);

    @Named("stringToBreed")
    static Breed stringToBreed(String breed) {
        for (Breed b : Breed.values()) {
            if (b.getBreedName().equalsIgnoreCase(breed)) {
                return b;
            }
        }
        return Breed.ILLEGAL_BREED;
    }

    @Named("breedToString")
    static String breedToString(Breed breed) {
        return breed.getBreedName();
    }

    @Named("stringToSpecies")
    static Species stringToSpecies(String species) {
        for (Species s : Species.values()) {
            if (s.getSpeciesName().equalsIgnoreCase(species)) {
                return s;
            }
        };
        return Species.ILLEGAL_SPECIES;
    }

    @Named("speciesToString")
    static String speciesToString(Species s) {
        return s.getSpeciesName();
    }

    @Named("stringListToHealthStatusList")
    static List<HealthStatus> stringListToHealthStatusList(List<String> list) {
        return list.stream().map(PetMapper::stringToHealthStatus).toList();
    }

    static HealthStatus stringToHealthStatus(String healthStatus) {
        for (HealthStatus hs : HealthStatus.values()) {
            if (hs.getDisplayName().equalsIgnoreCase(healthStatus)) {
                return hs;
            }
        };
        return HealthStatus.ILLEGAL_HEALTH_STATUS;
    }

    @Named("healthStatusListToStringList")
    static List<String> healthStatusListToStringList(List<HealthStatus> list) {
        return list.stream().map(HealthStatus::getDisplayName).toList();
    }
}
