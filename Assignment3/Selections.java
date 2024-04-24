// Title:              Assignment3
// Files:              MuseumManager.java, Selections.java
// Quarter:            CSE11 Spring 2024
//
// Author:             Brian Masse
// Email:              bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa


// Main Class File:    Selections
// File:               Selections.java
// Quarter:            CSE11 Spring 2024
//
// Author:             Brian Masse
// Instructor's Name:  Ben Ochoa
public class Selections {
    // MARK: vars
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

    // MARK: Methods
    // returns the monthly cost of an appartment, in $, depending on the number of rooms, and whether it has a padio and garage
    public static double apartmentCostCalc(double baseRent, int numBedrooms, 
        boolean hasGarage, boolean hasPatio) {
            
            if ( baseRent < BASE_RENT_ERROR || numBedrooms < MIN_BEDROOMS) { return 0d; }

            double costPerBedroom = 100;
            double costForGarage = 75;
            double costForPatio = 50;
                
            double bedroomCost = (numBedrooms - 1) * costPerBedroom;
            double garageCost = hasGarage ? costForGarage : 0;
            double patioCost = hasPatio ? costForPatio : 0;

            double cost = baseRent + bedroomCost + garageCost + patioCost;
            return cost;
    }

    // returns a string indiciating whether a guest was able to make a reservation for a given number of nights
    // the name must be long enough, and the number of nights between 1 and 14
    public static String reservationSystem(String guestName, 
        int numberOfNights) {

            int minNameChars = 5; 

            if ( guestName.length() < minNameChars ) { return RESERVATION_ERR; }
            if ( numberOfNights < MIN_NIGHTS || numberOfNights > MAX_NIGHTS ) { return RESERVATION_ERR; }

            String successMessage = "Reservation confirmed for " + guestName + " for " + numberOfNights + " nights";
            return successMessage;
    }

    // returns the discounted price ($), depending on the customer status and the amount spent
    public static double calculateDiscount(double amount, String customer) {

        double discountAmount = 0;

        if (customer == "Regular") {
            if ( amount >= 100 && amount <= 200 ) { discountAmount = REGULAR_DISCOUNT_1; }
            else if ( amount > 200 ) { discountAmount = REGULAR_DISCOUNT_2; }
        } else {
            discountAmount = PREMIUM_DISCOUNT;
        }

        return amount - ( amount * discountAmount );
    }

    // MARK: Convenience Methods
    // this rounds off a double to the desired number of digits
    public static double truncateDouble( double value, int digits ) {
        return Math.round(value * Math.pow( 10, digits )) / Math.pow(10, digits);
    }

    // this makes testing a method that returns a double more consistent and easier to code
    //  it is purely for convenience, it does not do anything different than standard implementation
    public static Boolean testDoubleMethod( String methodName, int testNumber, double output, double expectedOutput ) {
        double roundedOutput = truncateDouble(output, 2);
        double roundedExpectedOutput = truncateDouble(expectedOutput, 2);

        System.out.println( "  " + methodName + " " + testNumber + ": " + output + "\n" );

        if (roundedExpectedOutput != roundedOutput) {
            System.out.println( "FAILED: " + methodName + " " + testNumber );
            return false;
        }
        return true; 
    }

    // similar to the testDoubleMethod, this tests whether an actual string matches an expected output, and returns it as a boolean
    public static Boolean testStringMethod( String methodName, int testNumber, String output, String expectedOutput ) {
        System.out.println( "  " + methodName + " " + testNumber + ": " + output + "\n" );
        if (!output.equals(expectedOutput)) {
            System.out.println( "FAILED: " + methodName + " " + testNumber );
            return false;
        }
        return true; 
    }

    // MARK: Unit Tests
    public static boolean unitTests() {
        System.out.println(); 

        // Test(s) for apartmentCostCalc

        // test case1
        double baseRentTest = 1200;
        int numBedroomsTest = 2;
        boolean hasGarageTest = true;
        boolean hasPatioTest = false;
        double expectedCost = 1375.0;
        double actualCost = apartmentCostCalc(baseRentTest, numBedroomsTest, hasGarageTest, hasPatioTest);

        if (!testDoubleMethod("apartmentCostCalc", 1, actualCost, expectedCost)) { return false; }
        
        // test case2
        baseRentTest = -10;
        numBedroomsTest = 3;
        hasGarageTest = false;
        hasPatioTest = false;
        expectedCost = 0.0;
        actualCost = apartmentCostCalc(baseRentTest, numBedroomsTest, hasGarageTest, hasPatioTest);

        if (!testDoubleMethod("apartmentCostCalc", 2, actualCost, expectedCost)) { return false; }

        // test case3
        baseRentTest = 1200;
        numBedroomsTest = 0;
        hasGarageTest = false;
        hasPatioTest = false;
        expectedCost = 0.0;
        actualCost = apartmentCostCalc(baseRentTest, numBedroomsTest, hasGarageTest, hasPatioTest);

        if (!testDoubleMethod("apartmentCostCalc", 3, actualCost, expectedCost)) { return false; }



        // Test(s) for reservationSystem
        // test case1
        String guestNameTest = "Tony Stark";
        int numberOfNightsTest = 7;
        String expected = "Reservation confirmed for Tony Stark for 7 nights";
        String actual = reservationSystem(guestNameTest, numberOfNightsTest);

        if ( !testStringMethod("reservationSystem", 1, actual, expected) ) { return false; }

        // test case2
        guestNameTest = "Bri";
        expected = RESERVATION_ERR;
        actual = reservationSystem(guestNameTest, numberOfNightsTest);

        if ( !testStringMethod("reservationSystem", 2, actual, expected) ) { return false; }

        // test case3
        guestNameTest = "Brian Masse";
        numberOfNightsTest = 15;
        expected = RESERVATION_ERR;
        actual = reservationSystem(guestNameTest, numberOfNightsTest);

        if ( !testStringMethod("reservationSystem", 3, actual, expected) ) { return false; }


        // Test(s) for calculateDiscount
        // Test case 1
        double amountTest = 150.0;
        String customerTest = "Regular";
        double expectedDiscount = 135.0;
        double actualDiscount = calculateDiscount(amountTest, customerTest);

        if (!testDoubleMethod("calculateDiscount", 1, actualDiscount, expectedDiscount)) { return false; }

        // Test case 2
        amountTest = 99;
        customerTest = "Regular";
        expectedDiscount = 99;
        actualDiscount = calculateDiscount(amountTest, customerTest);

        if (!testDoubleMethod("calculateDiscount", 2, actualDiscount, expectedDiscount)) { return false; }

        // Test case 3
        amountTest = 10;
        customerTest = "Premium";
        expectedDiscount = 8;
        actualDiscount = calculateDiscount(amountTest, customerTest);

        if (!testDoubleMethod("calculateDiscount", 3, actualDiscount, expectedDiscount)) { return false; }

        // All test cases passed
        return true;
    }

    // MARK: Main
    // main method for Selections.java
    public static void main(String[] args) {
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("ERROR: Failed test.\n");
            return;
        }
    }
}