package Models;

import java.util.ArrayList;
import java.util.List;

public class Enclosure implements AnimalCollection {
    private String name;
    private List<Animal> animals;

    public Enclosure() {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    // Add animal to the enclosure
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

}
