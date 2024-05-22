// Main Class File:    Assignment6
// File:               Assignment6.Java
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
import java.util.ArrayList;
import java.util.Arrays;

public class Assignment6 {
    // MARK: Convenience Functions
    /**
     * helper function that prints a header for tests
     * this helps visually discern sections of unit tests in a long
     * receipt of tests
     * @param methodName: the method you are testing
     */
    public static void printTestingHeader(String methodName) {
        System.out.println( "------------------------" );
        System.out.println( methodName + " TESTS" );
        System.out.println( "------------------------\n" );
    }

    /**
     * helper function to test methods that return an int
     * checks if the output matches an expected output, via ==
     * if they do not match it prints an error message and returns false
     * @param methodName: the method you are testing
     * @param testNumber: the number of this test
     * @param output: the actual output of your code
     * @param expectedOutput: the expected output of your code
     * @return returns true if the values match and false if they dont
     */
    public static Boolean testIntMethod( String methodName, int testNumber, int output, int expectedOutput ) {
        System.out.println( "  " + methodName + " " + testNumber + ": " + output + " [expected: " + expectedOutput + "]\n" );
        if (output != expectedOutput) {
            System.out.println( "FAILED: " + methodName + " " + testNumber );
            return false;
        }
        return true; 
    }

     /**
     * helper function to test methods that return a list of ints
     * checks if the output matches an expected output, via .equals
     * if they do not match it prints an error message and returns false
     * @param methodName: the method you are testing
     * @param testNumber: the number of this test
     * @param output: the actual output of your code
     * @param expectedOutput: the expected output of your code
     * @return returns true if the values match and false if they dont
     */
    public static boolean testArrayMethod( String methodName, int testNumber, Object[] output, Object[] expectedOutput) {
        System.out.println( "  " + methodName + " " + testNumber + ": \n" + Arrays.toString(output) + " [expected: \n" + Arrays.toString(expectedOutput) + "]\n" );

        if (!Arrays.equals(output, expectedOutput)) {
            System.out.println( "FAILED: " + methodName + " " + testNumber );
            return false;
        }
        return true; 
    }

    // MARK: Unit Test Setup
    /**
     * the unit tests for Autograder.java, Queue.java, Ticket.java
     */
    public static boolean unitTests() {
        VendingMachine vm = new VendingMachine();

        // items
        Refreshing lemonade = new Refreshing("Lemonade", 10.0, 
            100, 12.0, "Sour", 5);

        Energizing coffee = new Energizing("Coffee", 8.0, 250, 6.0,
                                                                 "Sugary", 10);
        Sweet twix = new Sweet("Twix", 3.0, 210, 1,
                                                            "Chewy", 6);
        Savory pretzels = new Savory("Pretzels", 4.0, 130,
                                             2, "Crunchy", 4);


        // filling vending machine
        vm.addToItemList(lemonade); 
        Item[] itemsToAdd = { 
            coffee,
            twix,
            pretzels
        };
        vm.addToItemList(itemsToAdd);

        
        // MARK: Unit Tests
        // TEST CASE 1
        String methodName = "applyPriceSurge";
        printTestingHeader(methodName);

        // We provide a test case for applyPriceSurge
        // Save all the original prices of the items
        double[] originalPrices = new double[vm.getItemList().size()];
        for (int i = 0; i < vm.getItemList().size(); i++) {
            originalPrices[i] = vm.getItemList().get(i).getPrice();
        }
        
        // Apply price increase
        double increaseRate = 1.5;
        int increaseIndex = vm.applyPriceSurge(increaseRate);
        
        // Check itemList prices
        for (int i = 0; i < vm.getItemList().size(); i++) {
            Item item = vm.getItemList().get(i);
            if (i != increaseIndex || increaseRate < 1) {
                // Check that the Item as this index is still the same
                if (item.getPrice() != originalPrices[i]) {
                    // Item has changed unexpectedly
                    System.out.println("applyPriceSurge 1" +
                        " - Item unexpectedly changed " +
                        "at index: " + i);
                    System.out.println(vm.getItemList());
                    return false;
                }
            } else {
                // Check that the Item has the expected discount price
                double actualPrice = originalPrices[i] * increaseRate;
                if (item.getPrice() != actualPrice) {
                    System.out.println("applyPriceSurge 1" +
                        " - Item does not have expected increased price");
                    System.out.println(item.getPrice());
                    System.out.println(actualPrice);
                    System.out.println(vm.getItemList());
                    return false;
                }
            }
        }

        // TEST CASE 2
        // checking whether a increaseRate <= 1 keeps the list the same
        // get the expected, unchanged array
        ArrayList<Item> capturedList = new ArrayList<>(vm.getItemList());

        increaseRate = 0.6;
        increaseIndex = vm.applyPriceSurge(increaseRate);

        if ( !testArrayMethod(methodName, 1, capturedList.toArray(), vm.getItemList().toArray() ) ) { return false; }

        increaseRate = 1;
        increaseIndex = vm.applyPriceSurge(increaseRate);

        if ( !testArrayMethod(methodName, 2, capturedList.toArray(), vm.getItemList().toArray() ) ) { return false; }


        // TEST CASE 3
        methodName = "compareSize";
        printTestingHeader(methodName);

        Refreshing lemonade1 = new Refreshing("Lemonade", 10.0, 
            100, 24.0, "Sour", 5);
        Sweet milkyway = new Sweet("milkyway", 2.50, 30,
             2, "smooth", 6);
        Refreshing lemonade2 = new Refreshing("Lemonade2", 10.0, 
            100, 12.0, "Sour", 5);

        VendingMachine vm2 = new VendingMachine();

        Item[] items = { lemonade1, lemonade2, milkyway };
        vm2.addToItemList( items );

        Item retreivedLemonade1 = vm2.getItem("Lemonade");
        Item retreivedLemonade2 = vm2.getItem("Lemonade2");
        Item retreivedMilkyWay  = vm2.getItem("milkyway");

        int result1 = VendingMachine.compareSize(retreivedLemonade1, retreivedLemonade2);
        int expectedResult1 = 1;

        int result2 = VendingMachine.compareSize(retreivedLemonade2, retreivedLemonade1);
        int expectedResult2 = -1;

        int result3 = VendingMachine.compareSize(retreivedLemonade1, retreivedMilkyWay);
        int expectedResult3 = 0;

        if( !testIntMethod(methodName, 1, result1, expectedResult1) ) { return false; }
        if( !testIntMethod(methodName, 2, result2, expectedResult2) ) { return false; }
        if( !testIntMethod(methodName, 3, result3, expectedResult3) ) { return false; }


        // TEST CASE 4
        methodName = "retrieveItems";
        printTestingHeader(methodName);

        Drink drink = new Drink();
        Refreshing refreshing = new Refreshing("tea", 5, 20, 100, "herbal", 1);
        Snack snack = new Snack();
        Refreshing refreshing2 = new Refreshing("Matcha", 5, 20, 100, "herbal", 1);
        Sweet sweet = new Sweet();
        Item item = new Item();

        VendingMachine vm3 = new VendingMachine();
        items = new Item[]{ drink, refreshing, snack, refreshing2, sweet, item };
        vm3.addToItemList(items);

        Item[] expectedItems = { refreshing, refreshing2, null, null, null, null };
        Item[] filteredItems = vm3.getItemsByType("Refreshing");

        if (!testArrayMethod(methodName, 1, filteredItems, expectedItems)) { return false; }

        Item[] expectedItems2 = { drink, null, null, null, null, null };
        Item[] filteredItems2 = vm3.getItemsByType("Untyped Drink");

        if (!testArrayMethod(methodName, 2, filteredItems2, expectedItems2)) { return false; }

        Item[] expectedItems3 = { null, null, null, null, null, null };
        Item[] filteredItems3 = vm3.getItemsByType("Drink");

        if (!testArrayMethod(methodName, 2, filteredItems3, expectedItems3)) { return false; }


        return true;
    }

    // MARK: Main
    /**
     * the main function of this program
     * takes in the default args and runs the unit tests for each file
     */
    public static void main(String[] args) {
        if(unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("Failed test.\n");
            return;
        }
    }
}
