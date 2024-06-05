import java.util.Random;

// Main Class File:    Assignment8
// File:               Zebra.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * The Zebra is a type of Aniaml
 * It extends Animal and implements the Herbivore class
 * It is not poisonous
 * @author Brian Masse
 */
public class Zebra extends Animal implements Herbivore {
    
    private static final String NAME = "Zebra";

    // MARK: Init
    /**
     * Empty initialization
     * Sets the age, health, and strength of its super class to 0.
     */
    public Zebra() {
        super();
    }

    /**
     * Public initialization
     * Sets the age, health, and strength of its super class
     * @param age: the Age of the animal
     * @param health: The starting health of the animal
     * @param strength: The starting strength of the animal
     */
    public Zebra(int age, double health, double strength) {
        super(age, health, strength);
    }

    // MARK: Accessor Methods
    /**
     * Overrides the standard implementation of getName from Animal
     * @return: returns the static NAME property of this animal
     */
    @Override
    public String getName() {
        return Zebra.NAME;
    }

    /**
     * Overrides the standard implementation of isPoisnous from Animal
     * @return: whether the given animal is poisnous or not
     */
    @Override
    public boolean isPoisonous() {
        return false;
    }

    /**
     * implements the abstract method sameSpecies in Animal
     * checks whether two animals are the same species using the NAME prop
     * @param animal: the animal to compare to 
     * @return: whether the two animals are the same species
     */
    @Override
    public boolean sameSpecies( Animal animal ) {
        return this.getName().equals(animal.getName());
    }

    // MARK: Class Methods
    /**
     * implements the abstract method sleep in Animal
     * increases the strength of the animal by a set amount
     * 1.3
     */
    @Override
    public void sleep() {
        double newStrength = 1.3 * this.getStrength();
        setStrength(newStrength);
    }


    /**
     * implements the eatPlant function from the Herbivore interface
     * increases the animals strength by eating a random number of plants
     * can increase strength by 0 to 40
     */
    public void eatPlant() {
        Random r = new Random();
        double absorbedStrength = r.nextInt(40);
        double newStrength = this.getStrength() + absorbedStrength;
        setStrength(newStrength);
    }

    /**
     * represents the animal, and their attributes into a stirng to debug
     * @return: the string representation of the animal
     */
    @Override
    public String toString() {
        return super.toString() + "; species: Zebra";
    }
}