package com.pets.repository;

import com.pets.document.Pet;
import com.pets.utility.staticdata.Breed;
import com.pets.utility.staticdata.HealthStatus;
import com.pets.utility.staticdata.Species;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PetRepository extends MongoRepository<Pet,String> {
List<Pet> findBySpeciesAndAdoptedFalseAndHealthStatusNotIn(Species species, List<HealthStatus> excludedStatuses);
List<Pet> findBySpeciesAndBreedAndAdoptedFalseAndHealthStatusNotIn(Species species, Breed breed, List<HealthStatus> excludedStatuses);
List<Pet> findByHealthStatusIn(List<HealthStatus> healthStatuses);
}
