package com.pets.document;

import com.pets.staticdata.Breed;
import com.pets.staticdata.HealthStatus;
import com.pets.staticdata.Species;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document(collection = "pets")
public class Pet {

    @Id
    private String id;
    private String name;
    private Species species;
    private Breed breed;
    private int age;
    private Character gender;
    private String color;
    private double weightKg;
    private LocalDateTime arrivalDate;
    private List<HealthStatus> healthStatus;
    private boolean adopted;
    private String description;
    private List<String> photoUrls;
    private ShelterLocation shelterLocation;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class ShelterLocation {
        private String name;
        private String address;
    }
}
