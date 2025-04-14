package com.pets.staticdata.util;

import com.pets.staticdata.Breed;
import com.pets.staticdata.Species;

import java.util.*;

public class SpeciesBreedCombinationValidator {
    private static final Map<Species, List<Breed>> speciesSetMap = new HashMap<>();

    static {
        speciesSetMap.put(Species.DOG, Arrays.asList(
                Breed.LABRADOR,
                Breed.BEAGLE,
                Breed.GERMAN_SHEPHERD
        ));

        speciesSetMap.put(Species.CAT, Arrays.asList(
                Breed.PERSIAN,
                Breed.SIAMESE,
                Breed.MAINE_COON
        ));

        speciesSetMap.put(Species.BIRD, Arrays.asList(
                Breed.PARROT,
                Breed.SPARROW,
                Breed.CANARY
        ));

        speciesSetMap.put(Species.FISH, Arrays.asList(
                Breed.GUPPY,
                Breed.GOLD_FISH,
                Breed.BETTA
        ));

        speciesSetMap.put(Species.RABBIT, Arrays.asList(
                Breed.LIONHEAD,
                Breed.FLEMISH_GIANT,
                Breed.MINI_REX
        ));

        speciesSetMap.put(Species.HAMSTER, Arrays.asList(
                Breed.SYRIAN,
                Breed.ROBOROVSKI,
                Breed.CAMPBELL
        ));
    }

    public static boolean isValidCombination(Species species, Breed breed) {
        List<Breed> validBreeds = speciesSetMap.get(species);
        return validBreeds != null && validBreeds.contains(breed);
    }

    // Optional: get valid breeds by species
    public static List<Breed> getValidBreedsForSpecies(Species species) {
        return speciesSetMap.getOrDefault(species, Collections.emptyList());
    }
}
