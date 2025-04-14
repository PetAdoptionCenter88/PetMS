package com.pets.staticdata;

public enum Breed {
        // Dogs
        LABRADOR("Labrador"),
        BEAGLE("Beagle"),
        GERMAN_SHEPHERD("German_Shepherd"),

        // Cats
        PERSIAN("Persian"),
        SIAMESE("Siamese"),
        MAINE_COON("Maine_Coon"),

        // Birds
        PARROT("Parrot"),
        SPARROW("Sparrow"),
        CANARY("Canary"),

        // Fish
        GUPPY("Guppy"),
        GOLD_FISH("Gold_Fish"),
        BETTA("Betta"),

        // Rabbits
        LIONHEAD("Lionhead"),
        FLEMISH_GIANT("Flemish_Giant"),
        MINI_REX("Mini_Rex"),

        // Hamsters
        SYRIAN("Syrian"),
        ROBOROVSKI("Roborovski"),
        CAMPBELL("Campbell"),

        ILLEGAL_BREED("Illegal_Breed");

        private final String breedName;

        Breed(String breedName) {
            this.breedName = breedName;
        }

        public String getBreedName() {
            return breedName;
        }


}
