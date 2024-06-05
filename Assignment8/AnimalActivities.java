import java.util.Random;

// Main Class File:    Assignment8
// File:               Zebra.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * The AnimalActivities class is the main engine for the game
 * It contains the logic for turn based systems
 * as well as animal reproduction
 * It has no instance methods, and therefore no accessible constructors
 * @author Brian Masse
 */
public class AnimalActivities {

    // MARK: Vars
    private final static int NUM_ANIMALS = 6;
    private final static int SPACING = 17;
    private final static String LEFT = "Left";
    private final static String RIGHT = "Right";

    private final static int MAX_AGE = 100;
    private final static double MAX_HP = 15;
    private final static int MAX_STRENGTH = 10;

    private AnimalActivities() {}

    // MARK: Fight
    public static int fight(Animal animal1, Animal animal2) {
        boolean animal1Poisoned = animal2.poisonAnimal();
        boolean animal2Poisoned = animal1.poisonAnimal();


        int round = 0;

        while ( animal1.getHealth() > 0 && animal2.getHealth() > 0 ) {
            printRound(round);
            printBothAnimals(animal1, animal2);
            printAttack(LEFT, animal1.attack(animal2));
            printAttack(RIGHT, animal1.attack(animal1));
            
            round += 1;
        }

        printFinalStats(animal1, animal2, animal1Poisoned || animal2Poisoned);

        if (animal1.getHealth() < 0 && animal2.getHealth() < 0) {
            printTieGame();
            return 0;
        }

        if (animal1.getHealth() > 0) {
            if (animal1Poisoned) {
                printTieGame();
                return 0;
            }

            eat(animal1, animal2);
            printWinner(LEFT);
            return 1;
        }

        else if (animal2.getHealth() > 0) {
            if (animal2Poisoned) {
                printTieGame();
                return 0;
            }

            eat(animal2, animal1);
            printWinner(RIGHT);
            return 2;
        }

        return 0;
    }
    
    // MARK: Reproduce
    /**
    * this function creates a baby between two animals
    * the two animals must have age>=5 and be the same species,
    * the baby has base health 100 and the half the average of its parents
    * strength
    * @param (animal1) the first parent
    * @param (animal2) the second parent
    * @return: the baby of the two parents
    */
    public static Animal reproduce(Animal animal1, Animal animal2) {

        if ( animal1.getAge() <= 5 || animal2.getAge() <= 5 ) {
            return null;
        }
        if ( !animal1.sameSpecies(animal2) ) {
            return null;
        }

        int age = 0;
        double health = 100;
        double strength = animal1.getStrength() + animal2.getStrength();
        strength = strength / 4;

        if (animal1 instanceof Wolf) {
            return new Wolf(age, health, strength); 
        } else if ( animal1 instanceof Leopard ) {
            return new Leopard(age, health, strength); 
        } else if ( animal1 instanceof Toad ) {
            return new Toad(age, health, strength); 
        } else if ( animal1 instanceof Cobra ) {
            return new Cobra(age, health, strength); 
        } else if ( animal1 instanceof Panda ) {
            return new Panda(age, health, strength); 
        } else if ( animal1 instanceof Zebra ) {
            return new Zebra(age, health, strength); 
        }

        return null;

    }

    // MARK: Convenience Functions
    /**
    * this method handle the different eating logic depending on if
    * the first animal is a carnivore or herbivore
    * @param (animal1) the animal attempting to eat
    * @param (animal2) the animal to be eaten (if the first is a carnivore)
    */
    public static void eat(Animal animal1, Animal animal2) {
        if ( animal1 instanceof Carnivore ) {
            ( (Carnivore) animal1).eatAnimal(animal2);
        } else if (animal1 instanceof Herbivore) {
            ( (Herbivore) animal1).eatPlant();
        }
    }

    /**
    * Use this method in fight() to display the stats of both animals together
    * @param (animal1) Animal on the left side to display stats
    * @param (animal2) Animal on the right side to display stats
    */
    public static void printBothAnimals(Animal animal1, Animal animal2) {
        int ageSpacing = calcSpacing(Integer.toString(animal1.getAge()));
        int healthSpacing = calcSpacing(String.format("%.2f",animal1.getHealth()));
        int strSpacing = calcSpacing(String.format("%.2f",animal1.getStrength()));
        int animalSpacing = calcSpacing(animal1.getName());
        String str = String.format( "(%s) %s  (%s)\n" +
                "----------" + "            " + "----------\n" +
                "A: %d %s A: %d\n" +
                "H: %.2f %s H: %.2f\n" +
                "S: %.2f %s S: %.2f\n", animal1.getName(),
                " ".repeat(animalSpacing),animal2.getName(),
                animal1.getAge()," ".repeat(ageSpacing),animal2.getAge(),
                animal1.getHealth(), " ".repeat(healthSpacing), animal2.getHealth(),
                animal1.getStrength(), " ".repeat(strSpacing), animal2.getStrength()
                );
        System.out.println(str);
    }

    /**
    * Helper method for printBothAnimals()
    * @param (str) String on the left - used to calculate spacing
    * @return An int describing how many spaces to put between strings
    */
    public static int calcSpacing(String str) {
        int totalWidth = SPACING;
        int str1Width = str.length();
        int spacing = (totalWidth - str1Width);
        if (spacing < 0) {
            return 0; 
        }
        return spacing;
    }

    /**
     * Use this method in fight() to display the current round.
    * @param (round) An int of the round (should start at 0)
    */
    public static void printRound(int round) {
        System.out.println();
        System.out.println("Round " + round + ":");
    }

    /**
     * Use this method in fight() to display the damage each round.
     *
     * @param (side) The side of the Animal that invoked the attack().
     * @param (damage) The int (damage) returned from an attack() call
     */
    public static void printAttack(String side, double damage) {
        System.out.printf("%s does %.2f damage!\n",side, damage);
    }
    
    /**
     * Use this method in fight() to display final stats and poison status.
     *
     * @param (animal1) Left animal
     * @param (animal2) Right animal
     * @param (poisoned) If either animal was poisoned
     */
    public static void printFinalStats(Animal animal1, Animal animal2,
                                    boolean poisoned) {
        System.out.println();
        printBothAnimals(animal1, animal2);
        if (poisoned) {
            System.out.println("An animal was poisoned."); 
        }
    }

    /**
     * Use this method in fight() to display a tie game.
     */
    public static void printTieGame() {
        System.out.println("-------GAME OVER-------");
        System.out.println("TIE: Both animals died!");
    }

    /**
     * Use this method in fight() to display the winner.
     * @param (side) The side of the Animal that won.
     */
    public static void printWinner(String side) {
        System.out.println("-------GAME OVER-------");
        System.out.println(side + " animal wins!");
    }


    /**
     * Use this method to create a random Animal object of a random subclass.
     * @return random new Animal (Wolf, Leopard, Panda, Zebra, Toad, Cobra)
     */
    public static Animal randomAnimal() {
            int randAge = randomAge(MAX_AGE);
            double randStrength = randomStrength(MAX_STRENGTH);
            int randClass = new Random().nextInt(NUM_ANIMALS);
            switch (randClass) {
                case 0: return (new Wolf(randAge, MAX_HP, randStrength));
                case 1: return (new Leopard(randAge, MAX_HP, randStrength));
                case 2: return (new Panda(randAge, MAX_HP, randStrength));
                case 3: return (new Zebra(randAge, MAX_HP, randStrength));
                case 4: return (new Toad(randAge, MAX_HP, randStrength));
                case 5: return (new Cobra(randAge, MAX_HP, randStrength));
                default: return null;
    } }

    /**
     * Use this method for randomAnimal()
     * @param (max) Max age acceptable
     * @return age
     */
    public static int randomAge(int max) {
        int randAge = (int)(Math.random()*(max+1));
        return randAge;
    }
    
    /**
     * Use this method for randomAnimal()
     * @param (max) Max strength acceptable
     * @return strength
     */
    public static double randomStrength(int max) {
        double randStrength = Math.random()*(max+1);
        return randStrength;
    }
}