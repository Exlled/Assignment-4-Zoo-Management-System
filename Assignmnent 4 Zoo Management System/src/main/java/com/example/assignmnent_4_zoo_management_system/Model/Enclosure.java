package com.example.assignmnent_4_zoo_management_system.Model;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {

        private String name;
        private List<Animal> animals;

        // Constructor
        public Enclosure(String name) {
            this.name = name;
            this.animals = new ArrayList<>();
        }

    public Enclosure() {

    }

    // Setter for the name
        public void setName(String name) {
            this.name = name;
        }

        // Method to add an animal
        public void addAnimal(Animal animal) {
            animals.add(animal);
        }

        // Method to get all animals in the enclosure
        public List<Animal> getAnimals() {
            return animals;
        }
}

