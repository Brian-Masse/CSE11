import java.util.Random;

// Main Class File:    Assignment8
// File:               Toad.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * The Toad is a type of Aniaml
 * It extends Animal and implements the Carnivore class
 * It is poisonous
 * @author Brian Masse
 */
public class Toad extends Animal implements Carnivore {

    private static final String NAME = "Toad";

    // MARK: Init
    /**
     * Empty initialization
     * Sets the age, health, and strength of its super class to 0.
     */
    public Toad() {
        super();
    }

    /**
     * Public initialization
     * Sets the age, health, and strength of its super class
     * @param age: the Age of the animal
     * @param health: The starting health of the animal
     * @param strength: The starting strength of the animal
     */
    public Toad( int age, double health, double strength ) {
        super(age, health, strength);
    }

    // MARK: Accessor Methods
    /**
     * Overrides the standard implementation of getName from Animal
     * @return: returns the static NAME property of this animal
     */
    @Override
    public String getName() {
        return Toad.NAME;
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
     * 1.2
     */
    @Override
    public void sleep() {
        double newStrength = 1.2 * this.getStrength();
        setStrength(newStrength);
    }

    /**
     * implements the eatAnimal function from the Carnivore interface
     * increases the animals strength by absorbing part of the strength of the 
     * flies on the other animal.
     * The number of flies eaten is a randomly generated number from 0...10
     * The toad absorbs 30% of the strenght of the animal for each fly
     * @param animal: the animal to eat
     */
    public void eatAnimal(Animal animal) {
        int min = 0;
        int max = 11;

        Random r = new Random();
        int bugsEaten = min + r.nextInt(max);
        
        double absorbedStrength = bugsEaten * 0.3 * animal.getStrength();
        double newStrength = absorbedStrength + this.getStrength();

        setStrength(newStrength);
    }

    /**
     * overrides the poisonAnimal method in Animal
     * there is a 30% chance the animal will poison the other
     * this is determined at the start of a fight
     * @return: whether the other animal has been poisoned
     */
    @Override
    public boolean poisonAnimal() {
        Random r = new Random();
        double chance = r.nextDouble();

        return (chance <= 0.3) ? true : false;
    }

    /**
     * represents the animal, and their attributes into a stirng to debug
     * @return: the string representation of the animal
     */
    @Override
    public String toString() {
        return super.toString() + "; species: Toad";
    }

}