import java.util.Random;

// Main Class File:    Assignment8
// File:               Cobra.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * The Cobra is a type of Aniaml
 * It extends Animal and implements the Carnivore class
 * It is poisonous
 * @author Brian Masse
 */
public class Cobra extends Animal implements Carnivore {

    private static final String NAME="Cobra";

    // MARK: Init
    /**
     * Empty initialization
     * Sets the age, health, and strength of its super class to 0.
     */
    public Cobra() {
        super();
    }

    /**
     * Public initialization
     * Sets the age, health, and strength of its super class
     * @param age: the Age of the animal
     * @param health: The starting health of the animal
     * @param strength: The starting strength of the animal
     */
    public Cobra(int age, double health, double strength) {
        super( age, health, strength);
    }

    // MARK: Accessor Methods
    /**
     * Overrides the standard implementation of getName from Animal
     * @return: returns the static NAME property of this animal
     */
    @Override
    public String getName() {
        return Cobra.NAME;
    }

    /**
     * Overrides the standard implementation of isPoisnous from Animal
     * @return: whether the given animal is poisnous or not
     */
    @Override
    public boolean isPoisonous() {
        return true;
    }

    /**
     * implements the abstract method sameSpecies in Animal
     * checks whether two animals are the same species using the NAME prop
     * @param animal: the animal to compare to 
     * @return: whether the two animals are the same species
     */
    @Override
    public boolean sameSpecies(Animal animal) {
        return this.getName().equals(animal.getName());
    }

    // MARK: Class Methods
    /**
     * implements the abstract method sleep in Animal
     * increases the strength of the animal by a set amount
     * 1.7
     */
    @Override
    public void sleep() {
        double newStrength = 1.7 * this.getStrength();
        setStrength(newStrength);
    }

    /**
     * implements the eatAnimal function from the Carnivore interface
     * increases the animals strength by absorbing part of the strength of the 
     * other animal. The absorbtion rate is specic to each animal
     * 90%
     * @param animal: the animal to eat
     */
    public void eatAnimal(Animal animal) {
        double absorbedStrength = 0.9 * animal.getStrength();
        double newStrength = this.getStrength() + absorbedStrength;
        setStrength(newStrength);
    }

    /**
     * overrides the poisonAnimal method in Animal
     * there is a 80% chance the animal will poison the other
     * this is determined at the start of a fight
     * @return: whether the other animal has been poisoned
     */
    @Override
    public boolean poisonAnimal() {
        Random r = new Random();
        double chance = r.nextDouble();

        return (chance <= 0.8) ? true : false;
    }
    
    /**
     * represents the animal, and their attributes into a stirng to debug
     * @return: the string representation of the animal
     */
    @Override
    public String toString() {
        return super.toString() + "; species: Cobra";
    }
}