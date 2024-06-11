// Main Class File:    Assignment7
// File:               Assignment7.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa

<<<<<<< HEAD
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

=======
>>>>>>> 9908f173f735ba3a804bb801d8d3b8b1e2791099
/**
 * 
 * Assignment5 is the main class for this assignment
 * it houses the main function for the program, and runs unit tests
 * for the logical implementation of all other files
 * @author Brian Masse
 */
public class Assignment8 {

    // MARK: Convenience Functions
    /**
     * helper function that prints a header for tests
     * this helps visually discern sections of unit tests in a long
     * receipt of tests
     * @param methodName: the method you are testing
     * @param function: the purpose of this test
     */
    public static void printTestingHeader(String methodName, String function) {
        System.out.println( "------------------------" );
        System.out.println( methodName + "" );
        System.out.println( function + "" );
        System.out.println( "------------------------\n" );
    }

    /**
     * helper function that prints that a test was successful
     * @param methodName: the method you are testing
     */
    public static void printTestSucceeded(String methodName) {
        System.out.println( methodName + " Succeeded!\n" );
    }

    // MARK: Test 1
    /**
     * Test 1
     * Tests the basic fight methods
     * @return whether the test passed
     */
    private static boolean testOne() {
        String methodName = "unit Test 1";
        printTestingHeader(methodName, "Testing the attack / fight methods");

        Animal animal1 = new Wolf(10, 100, 20);
        Animal animal2 = new Leopard(10, 100, 50);

        // checks to make sure every attack is within the allowed range
        for (int i = 0; i < 100; i++) {
            double attackStrength = animal1.attack(animal2);
            if (attackStrength < 1 || attackStrength > 20) { return false; }

            double attackStrength2 = animal2.attack(animal1);
            if ( attackStrength2 < 1 || attackStrength2 > 50) { return false; }
        }

        if (animal1.getHealth() > 0 || animal2.getHealth() > 0) { return false; }

        printTestSucceeded(methodName);
        return true;
    }

    // MARK: Test 2
    /**
     * Test2
     * tests all the sleep functions inrease the strength the same
     * @return whether the test passed
     */
    private static boolean testTwo() {
        String methodName = "unit Test 2";
        printTestingHeader(methodName, "testing the sleep funtions correctly increment the strength of each different animal");

        Animal wolf     = new Wolf(10, 100, 10);
        Animal leopard  = new Leopard(10, 100, 10);
        Animal cobra    = new Cobra(10, 100, 10);
        Animal toad     = new Toad(10, 100, 10);
        Animal panda    = new Panda(10, 100, 10);
        Animal zebra    = new Zebra(10, 100, 10);

        wolf.sleep();
        leopard.sleep();
        cobra.sleep();
        toad.sleep();
        panda.sleep();
        zebra.sleep();
            
        if ( wolf.getStrength() != 16 ) { return false; };
        if ( leopard.getStrength() != 15 ) { return false; };
        if ( cobra.getStrength() != 17 ) { return false; };
        if ( toad.getStrength() != 12 ) { return false; };
        if ( zebra.getStrength() != 13 ) { return false; };
        if ( panda.getStrength() != 14 ) { return false; };

        printTestSucceeded(methodName);
        return true;
    }

    // MARK: Test 3
    /**
     * Test3
     * Tests the validity of the reproduce method
     * @return whether the test passed
     */
    private static boolean testThree() {
        String methodName = "unit Test 3";
        printTestingHeader(methodName, "Tests the edge cases of the reproduce"+
            " function, and checks when a baby is returned, it has the" + 
            " correct instance props");

        Wolf wolf = new Wolf(10, 10, 10);
        Wolf wolf2 = new Wolf(10, 10, 100);
        Wolf wolf3 = new Wolf(3, 10, 10);
        Panda panda = new Panda(10, 10, 10);

        Animal baby1 = AnimalActivities.reproduce(wolf, wolf3);
        Animal baby2 = AnimalActivities.reproduce(wolf, wolf2);
        Animal baby3 = AnimalActivities.reproduce(wolf, panda);

        if ( baby1 != null ) { return false; }
        if ( baby3 != null ) { return false; }

        if ( baby2.getStrength() != 27.5 || baby2.getHealth() != 100 || baby2.getAge() != 0 ) { return false; }

        printTestSucceeded(methodName);
        return true;
    }

    // MARK: Test 4
    /**
     * Helper function to check the poison rate
     * simulates 1000 poison attemp and determines how many were successful
     * to generate an empirical estimate at the poison rate
     * @param animal the poisonous animal
     * @return the poison rate %
     */
    private static double testPoisonRate(Animal animal) {
        int timesPoisoined = 0;

        for ( int i = 0; i < 1000; i++ ) {
            if (animal.poisonAnimal()) {
                timesPoisoined++;
            }
        }

        return timesPoisoined / 10;
    }
    
    /**
     * Test4
     * Tests the poison ability
     * and that the poison chance is within a certain range
     * @return whether the test passed
     */
    private static boolean testFour() {
        String methodName = "unit Test 4";
        printTestingHeader(methodName, "tests that the chance of poisoning" +
                                        " are within a certain range");

        Toad toad = new Toad(10, 10, 10);
        Cobra cobra = new Cobra(10, 10, 10);

        // check that the poison rates are close to what they should be
        System.out.println( "Poison Rate of Toad: [30%] " + testPoisonRate(toad) + "%" );
        System.out.println( "Poison Rate of Cobra: [80%] " + testPoisonRate(cobra) + "%" );

        return true;
    }

    // MARK: Test 5
    /**
     * Test5
     * Tests the eat method for all the animals
     * @return whether the test passed
     */
    private static boolean testFive() {
        String methodName = "unit Test 5";
        printTestingHeader(methodName, "tests the eat method for all animals");

        Wolf wolf = new Wolf(10, 10, 100);

        Leopard leopard  = new Leopard(10, 100, 10);
        Cobra cobra    = new Cobra(10, 100, 10);
        Toad toad     = new Toad(10, 100, 10);
        Panda panda    = new Panda(10, 100, 10);
        Zebra zebra    = new Zebra(10, 100, 10);

        leopard.eatAnimal(wolf);
        cobra.eatAnimal(wolf);
        toad.eatAnimal(wolf);
        wolf.eatAnimal(wolf);
        panda.eatPlant();
        zebra.eatPlant();

        System.out.println(wolf.getStrength());
        System.out.println(leopard.getStrength());
        System.out.println(cobra.getStrength());

        double toadStrength = toad.getStrength();
        double pandaStrength = panda.getStrength();
        double zebraStrength = zebra.getStrength();

        if ( 10 > toadStrength || toadStrength > 310 ) { return false; }
        if ( 10 > pandaStrength || pandaStrength > 60 ) { return false; }
        if ( 10 > zebraStrength || zebraStrength > 50 ) { return false; }


        printTestSucceeded(methodName);
        return true;

    }

    /**
     * All unit tests. This method should be executed to ensure that all
     * methods are correctly implemented.
     * @return true if all unit tests passed, false otherwise.
     */
    public static boolean unitTests() {
        if (!testOne()) { return false; }

        if (!testTwo()) { return false; }
        
        if (!testThree()) { return false; }

        if (!testFour()) { return false; }

        if (!testFive()) { return false; }

        return true;
    }

    /**
     * The main method, where program execution begins.
     * @param args Any command-line arguments.
     */
    public static void main(String[] args) {
        // if (unitTests()) {
        //     System.out.println("All unit tests passed.\n");
        // } else {
        //     System.out.println("Failed test.\n");
        // }

        DataInputStream d = new FileInput
    }
}
