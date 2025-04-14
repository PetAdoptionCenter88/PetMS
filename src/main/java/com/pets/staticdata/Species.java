package com.pets.staticdata;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum Species {
    DOG("Dog"),
    CAT("Cat"),
    BIRD("Bird"),
    FISH("Fish"),
    RABBIT("Rabbit"),
    HAMSTER("Hamster"),
    ILLEGAL_SPECIES("Illegal Species");

    private final String speciesName;

    Species(String speciesName) {
        this.speciesName = speciesName;
    }

    // Method to get the Breed enum for each species
    public String getSpeciesName() {
        return speciesName;
    }

}

