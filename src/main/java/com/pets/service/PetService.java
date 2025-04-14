package com.pets.service;

import com.pets.document.Pet;
import com.pets.dto.PetDTO;
import com.pets.exception.PetMSException;
import com.pets.staticdata.Breed;
import com.pets.staticdata.Species;

import java.util.List;

public interface PetService {
    public String addPet(PetDTO pet)  throws PetMSException;
    public List<Pet> getUnAdoptedPets(Species species)  throws PetMSException;
    public List<Pet> getUnAdoptedPets(Species species, Breed breed)  throws PetMSException;
    public List<Pet> getPetsRequireMedicalHelp()  throws PetMSException;

}
