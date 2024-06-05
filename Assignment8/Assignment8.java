// Main Class File:    Assignment7
// File:               Assignment7.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
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

    // MARK: Test 1
    /**
     * Test 1
     * Tests the basic fight methods
     * @return whether the test passed
     */
    private static boolean testOne() {
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

        return true;
    }

    // MARK: Test 2
    /**
     * Test2
     * tests the outputFileContents method on file
     * @return whether the test passed
     */
    private static boolean testTwo() {
        return false;
    }

    // MARK: Test 3
    /**
     * Test3
     * Tests the initialization + output method for archived Files
     * @return whether the test passed
     */
    private static boolean testThree() {
        return false;
    }

    // MARK: Test 4
    /**
     * Test4
     * Tests empty initializations for all classes + raising an
     * exception when exporting empty content to a file
     * @return whether the test passed
     */
    private static boolean testFour() {
        return false;
    }

    // MARK: Test 5
    /**
     * Test5
     * Tests adding files + directories of the same name to the same sub folder
     * @return whether the test passed
     */
    private static boolean testFive() {
        return false;
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
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("Failed test.\n");
        }
    }
}
