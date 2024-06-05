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

    protected Animal() {
        this.age = 0;
        this.health = 0;
        this.strength = 0;
    }

    protected Animal( int age, double health, double strength ) {
        this.age = age;
        this.health = health;
        this.strength = strength;
    }

    public int getAge() {
        return this.age;
    }

    public double getHealth() {
        return this.health;
    }

    public double getStrength() {
        return this.strength;
    }

    public String getName() {
        return Animal.NAME;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
    
    public double attack(Animal animal) {
        double min = 1;
        double max = this.getStrength();

        Random r = new Random();
        double attackPower = min + (max - min) * r.nextDouble();

        animal.setHealth( animal.getHealth() - attackPower );

        return attackPower;
    }

    public abstract boolean sameSpecies(Animal animal);
    public abstract void sleep();
    public abstract boolean isPoisonous();

    public boolean poisonAnimal() {
        return false;
    }

    @Override
    public String toString() {
        return "(Animal)" + " age: " + getAge() +
        "; health: " + getHealth() + "; strength: " + getStrength();
    }
}