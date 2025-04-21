package com.pets.service;

import com.pets.document.Pet;
import com.pets.dto.PetDTO;
import com.pets.exception.PetMSException;
import com.pets.repository.PetRepository;
import com.pets.utility.staticdata.Breed;
import com.pets.utility.staticdata.Species;
import com.pets.utility.objectmapper.PetMapper;
import com.pets.utility.validators.SpeciesBreedCombinationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.pets.utility.staticdata.HealthStatus.getRequireMedicalCare;

@Service("PetService")
@Transactional
public class PetServiceImpl implements PetService{

    @Autowired
    private PetMapper petMapper;
    @Autowired
    private PetRepository petRepository;

    public String addPet(PetDTO petDTO) throws PetMSException {
        Pet pet=petMapper.toPetEntity(petDTO);
        if(! SpeciesBreedCombinationValidator.isValidCombination(pet.getSpecies(),pet.getBreed())){
           throw new PetMSException("PetMSService.Invalid.Species.Breed");
        }
        pet.setArrivalDate(LocalDateTime.now());
        pet.setCreatedAt(LocalDateTime.now());
        pet.setUpdatedAt(LocalDateTime.now());
        petRepository.save(pet);
        return pet.getId();
    }

    public List<Pet> getUnAdoptedPets(Species species)  throws PetMSException {
        return petRepository.findBySpeciesAndAdoptedFalseAndHealthStatusNotIn(species,getRequireMedicalCare());
    }

    public List<Pet> getUnAdoptedPets(Species species, Breed breed)  throws PetMSException {
        if(! SpeciesBreedCombinationValidator.isValidCombination(species,breed)){
            throw new PetMSException("service.invalid.species.breed");
        }
        return petRepository.findBySpeciesAndBreedAndAdoptedFalseAndHealthStatusNotIn(species,breed,getRequireMedicalCare());
    }
    public List<Pet> getPetsRequireMedicalHelp()  throws PetMSException{
        return petRepository.findByHealthStatusIn(getRequireMedicalCare());
    }
}
