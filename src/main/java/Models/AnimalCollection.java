package Models;

import java.util.List;

public interface AnimalCollection {
    // Method to get the name of the collection or enclosure
    String getName();

    // Method to set the name of the collection or enclosure
    void setName(String name);

    // Method to get the list of animals (if applicable)
    List<Animal> getAnimals();

    // Method to add an animal (for Enclosure types)
    void addAnimal(Animal animal);
}
