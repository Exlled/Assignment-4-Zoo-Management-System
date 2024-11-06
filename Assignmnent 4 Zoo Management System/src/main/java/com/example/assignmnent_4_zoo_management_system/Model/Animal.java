package com.example.assignmnent_4_zoo_management_system.Model;

public abstract class Animal {
    private final String aName;  // Attribute
    private final int aAge;     // Attribute
    private final int aWeight;  // Attribute (in kg)
    private final int aHeight;  // Attribute (in cm)

    public Animal(String pName, int pAge, int pWeight, int pHeight) { // Parameters
        this.aName = pName;
        this.aAge = pAge;
        this.aWeight = pWeight;
        this.aHeight = pHeight;
    }

    public String getName() {
        return aName;
    }

    public int getAge() {
        return aAge;
    }

    public int getWeight() {
        return aWeight;
    }

    public int getHeight() {
        return aHeight;
    }
}
