package com.pets.dto;

import com.pets.staticdata.util.ValidBreed;
import com.pets.staticdata.util.ValidHealthStatus;
import com.pets.staticdata.util.ValidSpecies;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class PetDTO {
    @NotNull(message = "{name.notnull}")
    private String name;

    @NotNull(message = "{species.notnull}")
    @ValidSpecies(message = "{species.invalid}")
    private String species;

    @NotNull(message = "{breed.notnull}")
    @ValidBreed(message = "{breed.invalid}")
    private String breed;

    @NotNull(message = "{age.notnull}")
    @PositiveOrZero(message = "{age.positiveOrZero}")
    private Integer age;

    @NotNull(message = "{gender.notnull}")
    private Character gender;

    @NotNull(message = "{color.notnull}")
    private String color;

    @NotNull(message = "{weightKg.notnull}")
    @PositiveOrZero(message = "{weightKg.positiveOrZero}")
    private Double weightKg;

    @NotNull(message = "{healthStatus.notnull}")
    @Size(max = 5, message = "{healthStatus.size}")
    @ValidHealthStatus(message = "{healthStatus.invalid}")
    private List<String> healthStatus;

    @NotNull(message = "{adopted.notnull}")
    @AssertFalse(message = "{adopted.assertFalse}")
    private Boolean adopted;

    private String description;

    private List<String> photoUrls;

    private ShelterLocation shelterLocation;

    @Data
    public static class ShelterLocation {

        private String name;

        private String address;
    }
}
