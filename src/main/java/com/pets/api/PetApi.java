package com.pets.api;

import com.pets.document.Pet;
import com.pets.dto.PetDTO;
import com.pets.exception.PetMSException;
import com.pets.service.PetService;

import com.pets.staticdata.util.PetMapper;
import com.pets.staticdata.util.ValidBreed;
import com.pets.staticdata.util.ValidSpecies;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@Validated
public class PetApi {

    @Autowired
    PetService petService;

    @PostMapping
    public ResponseEntity<String> addPet(@Valid @RequestBody PetDTO pet, BindingResult result)  throws PetMSException {
        String petId = petService.addPet(pet);
        System.out.println(pet.getName());
        return new ResponseEntity<>(petId, HttpStatus.CREATED);
    }

    @GetMapping("/species/{species}/un-adopted")
    public ResponseEntity<List<Pet>> getUnAdoptedPets (@PathVariable  @NotNull(message = "{species.notNull}") @ValidSpecies(message = "{species.invalid}") String species)  throws PetMSException{
        List<Pet> pets = petService.getUnAdoptedPets(PetMapper.stringToSpecies(species));
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/species/{species}/breed/{breed}/un-adopted")
    public ResponseEntity<List<Pet>> getUnAdoptedPets(@PathVariable  @NotNull(message = "{species.notNull}") @ValidSpecies(message = "{species.invalid}") String species,@PathVariable  @NotNull(message = "{breed.notNull}") @ValidBreed(message = "{breed.invalid}") String breed)  throws PetMSException{
        List<Pet> pets = petService.getUnAdoptedPets(PetMapper.stringToSpecies(species),PetMapper.stringToBreed(breed));
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/medical-care")
    public ResponseEntity<List<Pet>> medicalCare()  throws PetMSException{
        List<Pet> pets = petService.getPetsRequireMedicalHelp();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

}
