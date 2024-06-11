import java.util.Random;

// Main Class File:    Assignment8
// File:               Animal.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * Animal is the main representatino of all animals in the game
 * all animals will inheret its methods and variables
 * all animals have an age, health, and strength
 * @author Brian Masse
 */
public abstract class Animal {
    private int age;
    private double health;
    private double strength;
    private static final String NAME = "Animal";

    // MARK: Initialization
    /**
     * Empty initialization
     * Sets the age, health, and strength of its super class to 0.
     */
    protected Animal() {
        this.age = 0;
        this.health = 0;
        this.strength = 0;
    }

    /**
     * Public initialization
     * Sets the age, health, and strength of its super class
     * @param age: the Age of the animal
     * @param health: The starting health of the animal
     * @param strength: The starting strength of the animal
     */
    protected Animal( int age, double health, double strength ) {
        this.age = age;
        this.health = health;
        this.strength = strength;
    }

    // MARK: Accessors
    /**
     * Gets the age of the animal
     * @return: age of the animal
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Gets the current health of the animal
     * @return: health of the animal
     */
    public double getHealth() {
        return this.health;
    }

    /**
     * Gets the current strength of the animal
     * @return: strength of the animal
     */
    public double getStrength() {
        return this.strength;
    }

    /**
     * Gets the name of the animal, will be overriden in all implementations
     * of the animal class
     * @return: name of the animal
     */
    public String getName() {
        return Animal.NAME;
    }

    /**
     * sets the health of the animal
     * @param health the new health of the animal
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     * sets the strength of the animal
     * @param health the new strength of the animal
     */
    public void setStrength(double strength) {
        this.strength = strength;
    }
    
    
    /**
     * generates a random number between 1...strength, and uses it
     * to decrease the health of the animal
     * @param animal the animal being attacked
     * @return the amount of damage done to the other animal
     */
    public double attack(Animal animal) {
        if (this.getStrength() == 0) { return 0; }

        double min = 1;
        double max = this.getStrength();

        Random r = new Random();
        double attackPower = min + (max - min) * r.nextDouble();

        animal.setHealth( animal.getHealth() - attackPower );

        return attackPower;
    }

    // MARK: Abstract Methods
    /**
     * checks whether two animals are the same species
     * to be implemented in implementations of this class
     * @param animal the animal to compare to
     * @return whether the two animals are the same species
     */
    public abstract boolean sameSpecies(Animal animal);

    /**
     * increases the strenght of the animal by a specific ammount
     */
    public abstract void sleep();

    /**
     * checks whether an animal is poisonous
     * @return whether an animal is poisonous
     */
    public abstract boolean isPoisonous();

    /**
     * Randomly attempts to poison another animal, based on a specific value
     * To be implemented by all poisnous animals
     * @return whether the animal was poisoned
     */
    public boolean poisonAnimal() {
        return false;
    }

    /**
     * creates a text description of the animal for debugging
     * @return the string representing the animal
     */
    @Override
    public String toString() {
        return "(Animal)" + " age: " + getAge() +
        "; health: " + getHealth() + "; strength: " + getStrength();
    }
}