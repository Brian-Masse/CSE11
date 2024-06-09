// Main Class File:    Assignment7
// File:               Assignment7.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
     * Tests the equals function on files and directories
     * @return whether the test passed
     */
    private static boolean testOne() {
        Animal animal1 = AnimalActivities.randomAnimal();
        Animal animal2 = AnimalActivities.randomAnimal();

        AnimalActivities.fight(animal1, animal2);

        return false;
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

    // MARK: 6
    /**
     * Test6
     * Tests imputing contents from a pre-existing file,
     * then reoutputting it and reading it
     * @return whether the test passed
     */
    private static boolean testSix() {
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

        if (!testSix()) { return false; }

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
