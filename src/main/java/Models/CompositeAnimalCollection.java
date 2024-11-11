package Models;

import java.util.ArrayList;
import java.util.List;

public class CompositeAnimalCollection implements AnimalCollection {
    private String name;
    private List<Enclosure> enclosures;
    private List<AnimalCollection> collections = new ArrayList<>();

    public CompositeAnimalCollection() {
        this.name = "";
        this.enclosures = new ArrayList<>();
    }

    // Add an enclosure to the collection
    public void addEnclosure(Enclosure enclosure) {
        if (enclosure != null) {
            enclosures.add(enclosure);
        }
    }

    // Add an enclosure to the collection
    public void addCollection(Enclosure enclosure) {
        enclosures.add(enclosure);
    }

    // Getters and Setters
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public List<Enclosure> getEnclosures() {
        return this.enclosures;
    }

    @Override
    public List<Animal> getAnimals() {
        List<Animal> allAnimals = new ArrayList<>();
        for (Enclosure enclosure : enclosures) {
            allAnimals.addAll(enclosure.getAnimals());
        }
        return allAnimals;
    }

    @Override
    public void addAnimal(Animal animal) {
        // By design, CompositeAnimalCollection does not directly hold animals,
        // so we need to decide where to add this animal.
        if (!collections.isEmpty()) {
            // Add the animal to the first collection as an example.
            collections.get(0).addAnimal(animal);
        }
    }

}
