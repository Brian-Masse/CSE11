/*
 * This is the starter code for Assignment 3 - Selections (CSE 11 SP24)
 * TODO: Remove the comment above, and complete main file header
 */

/**
 * NOTE: YOU SHOULD NOT HAVE TO IMPORT ANY PACKAGES TO COMPLETE THIS
 * ASSIGNMENT. 
 * 
 * If you add extraneous packages (intentionally or not), then your
 * code might fail Gradescope compilation.
 */

// TODO: Complete class header

public class Selections {

    // Feel free to create extra variables if necessary.

    /* Variables used for apartmentCostCalc */
    private final static double BASE_RENT_ERROR = 0.0;
    private final static int MIN_BEDROOMS = 1;

    /* Variables used for reservationSystem */
    private final static int MIN_NIGHTS = 1;
    private final static int MAX_NIGHTS = 14;
    private final static String RESERVATION_ERR = "Reservation cannot be made";

    /* Variables used for reservationSystem */
    private final static double REGULAR_DISCOUNT_1 = 0.10;
    private final static double REGULAR_DISCOUNT_2 = 0.15;
    private final static double PREMIUM_DISCOUNT = 0.20;

    // TODO: complete method header and method body
    public static double apartmentCostCalc(double baseRent, int numBedrooms, 
        boolean hasGarage, boolean hasPatio) {
        double cost = baseRent;
        return cost;
    }

    // TODO: complete method header and method body
    public static String reservationSystem(String guestName, 
        int numberOfNights) {
        return "";
    }

    // Reminder: you do not need to keep starter code provided,
    //           it is just a guide for you in case you would like to use it.
    // TODO: complete method header and method body
    public static double calculateDiscount(double amount, String customer) {
        return amount;
    }

    // TODO: Add more unit tests to ensure correctness of methods.
    public static boolean unitTests() {
        System.out.println(); 

        // Test(s) for apartmentCostCalc
        // Test case 1: baseRent = 1200, numBedrooms = 2, 
        // hasGarage = true, hasPatio = false
        double baseRentTest1 = 1200;
        int numBedroomsTest1 = 2;
        boolean hasGarageTest1 = true;
        boolean hasPatioTest1 = false;
        double expectedCost1 = 1375.0;
        double actualCost1 = apartmentCostCalc(baseRentTest1, numBedroomsTest1,
            hasGarageTest1, hasPatioTest1);

        System.out.println("apartmentCostCalc Output 1: " + actualCost1);
        System.out.println();

        if (actualCost1 != expectedCost1) {
            System.out.println("FAILED: apartmentCostCalc 1");
            return false;
        }
        // Test case 2: ...
        // ...


        // Test(s) for reservationSystem
        // Test case 1: guestName = "Tony Stark", numberOfNights = 7
        String guestNameTest1 = "Tony Stark";
        int numberOfNightsTest1 = 7;
        String expected = "Reservation confirmed for Tony Stark for 7 nights";
        String actual = reservationSystem(guestNameTest1, numberOfNightsTest1);

        System.out.println("reservationSystem Output 1: " + actual);
        System.out.println();

        if (!actual.equals(expected)) {
            System.out.println("FAILED: reservationSystem 1");
            return false;
        }
        // Test case 2: ...
        // ...

        // Test(s) for calculateDiscount
        // Test case 1: amount = 150.0, customer = "Regular"
        double amountTest1 = 150.0;
        String customerTest1 = "Regular";
        double expectedDiscount1 = 135.0;
        double actualDiscount1 = calculateDiscount(amountTest1, customerTest1);

        System.out.println("calculateDiscount Output 1: " + actualDiscount1);
        System.out.println();

        if (actualDiscount1 != expectedDiscount1) {
            System.out.println("FAILED: calculateDiscount 1");
            return false;
        }
        // Test case 2: ...
        // ...

        // All test cases passed
        return true;
    }

    // TODO: Complete the method header and the method body
    public static void main(String[] args) {
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("ERROR: Failed test.\n");
            return;
        }
    }
}