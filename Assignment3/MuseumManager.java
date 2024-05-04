// Title:              Assignment3
// Files:              MuseumManager.java, Selections.java
// Quarter:            CSE11 Spring 2024
//
// Author:             Brian Masse
// Email:              bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa

// Main Class File:    MuseumManager
// File:               MuseumManager.java
// Quarter:            CSE11 Spring 2024
//
// Author:             Brian Masse
// Instructor's Name:  Ben Ochoa
public class MuseumManager {
    // MARK: Vars
    // Define exhibit types
    private final static String PAINTINGS = "paintings";
    private final static String SCULPTURES = "sculptures";
    private final static String PHOTOGRAPHS = "photographs";
    private final static String ARTIFACTS = "artifacts";
    private final static String REN_ART = "Renaissance art";
    private final static String MOD_INST = "modern installations";
    private final static String INVALID_WEEK = "Invalid day of the week";
    private final static String CLOSED = "Museum is closed due to holiday";
    private final static String TODAYS_EXHIBITS = "Today's exhibits:";

    /* Variables used for guideTour */
    private final static String INVALID_INPUT = "Invalid input provided";
    private final static String NO_TOURS = "No tours scheduled at this time";

    /* Variables used for calcAdmissionFee */
    private final static double BASE_FEE_10 = 10.0;
    private final static double BASE_FEE_25 = 25.0;
    private final static double BASE_FEE_15 = 15.0;

    // MARK: Methods
    // convenience function to check the day of the week
    public static boolean checkDayOfWeek( int dayOfWeek ) {
        boolean isValid = !( dayOfWeek < 0 || dayOfWeek > 6 );
        if (!isValid) { System.out.println( INVALID_WEEK ); }
        return isValid;
    }

    // returns a string representing the available displays depending on the day of the week, if its a holiday, 
    // and if the person is a member
    public static void museumSchedule( int dayOfWeek, boolean isMember, boolean isHoliday ) {
        if (!checkDayOfWeek(dayOfWeek)) { return; }
        if (isHoliday) { 
            System.out.println(CLOSED);
            return;
         }

        if ( dayOfWeek % 2 == 0 ) {
            System.out.println( TODAYS_EXHIBITS + "\n" + PAINTINGS + "\n" + SCULPTURES );
            if (isMember) { System.out.println( REN_ART ); }
        }
        else if ( dayOfWeek % 2 != 0 ) {
            System.out.println( TODAYS_EXHIBITS + "\n" + PHOTOGRAPHS + "\n" + ARTIFACTS );
            if (isMember) { System.out.println( MOD_INST ); }
        }
    }

    // returns a message describing what tours are running at the current time
    public static String guideTour(int dayOfWeek, int hourOfDay) {
        if ( hourOfDay < 0 || hourOfDay > 23 || dayOfWeek < 0 || dayOfWeek > 6 ) { return INVALID_INPUT; }

        if      ( hourOfDay >= 10 && hourOfDay <= 12 ) { return "Guiding the tour of " + PAINTINGS + " and " + SCULPTURES; }
        else if ( hourOfDay >= 14 && hourOfDay <= 16 ) { return "Guiding the tour of " + PHOTOGRAPHS + " and " + ARTIFACTS; }
        else { return NO_TOURS;  }
    }

    // calculates the final admission fee depending on a guests age, memberstatus, and weekday
    public static double calcAdmissionFee( int dayOfWeek, int age, boolean isMember ) {
        if ( !checkDayOfWeek(dayOfWeek) ) { return 0; }
        if ( age <= 4 ) { return 0; }

        double discount = isMember ? 0.80 : 1;
        double surcharge = (dayOfWeek == 0 || dayOfWeek == 6) ? 4 : 0;

        if ( age >= 5 && age <= 16 )    { return BASE_FEE_10 * discount + surcharge; }
        if ( age >= 17 && age <= 60 )   { return BASE_FEE_25 * discount + surcharge; }
        if ( age > 60 )                 { return BASE_FEE_15 * discount + surcharge; }

        return 0;
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

    // similar to the testStringMethod, this simply prints out the expected result, propertly formated, to compare it to an actual printed value
    public static void testVoidMethod( String methodName, int testNumber, String expectedOutput) {
        System.out.println("\n  Expected " + methodName + " " + testNumber +":\n\n" + expectedOutput);
        System.out.println("  ---------------------\n");
        System.out.println( "  " + methodName + " Output " + testNumber + ":\n");
    }


    // MARK: UnitTests
    public static boolean unitTests() {
        System.out.println(); 

        // Test(s) for museumSchedule
        // test case 1
        int museumSchedDay = 3;
        boolean museumSchedMember = true;
        boolean museumSchedHoliday = false;
        String expectedSchedule = "Today's exhibits:\nphotographs\n" + 
            "artifacts\nmodern installations"; 

        testVoidMethod("museumSchedule", 1, expectedSchedule);
        museumSchedule(museumSchedDay, museumSchedMember, museumSchedHoliday);

        // Test case 2
        museumSchedDay = 4;
        museumSchedMember = false;
        museumSchedHoliday = false;
        expectedSchedule = "Today's exhibits:\npaintings\n" + 
            "sculptures"; 

        testVoidMethod("museumSchedule", 2, expectedSchedule);
        museumSchedule(museumSchedDay, museumSchedMember, museumSchedHoliday);

        // Test case 3
        museumSchedHoliday = true;
        expectedSchedule = "Museum is closed due to holiday"; 

        testVoidMethod("museumSchedule", 3, expectedSchedule);
        museumSchedule(museumSchedDay, museumSchedMember, museumSchedHoliday);

        System.out.println( "\n" );


        // Test(s) for guideTour
        // test case 1
        int dayOfWeek = 5;
        int hourOfDay = 11;
        String expectedString = "Guiding the tour of paintings and sculptures";
        String actualTour = guideTour(dayOfWeek, hourOfDay);

        if (!testStringMethod("guideTour", 1, expectedString, actualTour)) { return false; }

        // test case 2
        dayOfWeek = 2;
        hourOfDay = 15;
        expectedString = "Guiding the tour of photographs and artifacts";
        actualTour = guideTour(dayOfWeek, hourOfDay);

        if (!testStringMethod("guideTour", 2, expectedString, actualTour)) { return false; }

        // test case 3
        dayOfWeek = 4;
        hourOfDay = 9;
        expectedString = NO_TOURS;
        actualTour = guideTour(dayOfWeek, hourOfDay);

        if (!testStringMethod("guideTour", 3, expectedString, actualTour)) { return false; }



        // Test(s) for calcAdmissionFee
        // Test case 1
        dayOfWeek = 6;
        int age = 45;
        boolean isMember = true;
        double expectedFee = 24;
        double actualFee = calcAdmissionFee(dayOfWeek, age, isMember);

        if ( !testDoubleMethod("calcAdmissionFee", 1, actualFee, expectedFee) ) { return false; }

        // Test case 2
        dayOfWeek = 0;
        age = 4;
        expectedFee = 0;
        actualFee = calcAdmissionFee(dayOfWeek, age, isMember);

        if ( !testDoubleMethod("calcAdmissionFee", 2, actualFee, expectedFee) ) { return false; }

        // Test case 3
        dayOfWeek = 4;
        age = 61;
        isMember = false;
        expectedFee = BASE_FEE_15;
        actualFee = calcAdmissionFee(dayOfWeek, age, isMember);

        if ( !testDoubleMethod("calcAdmissionFee", 3, actualFee, expectedFee) ) { return false; }

        // All test cases passed
        return true;
    }

    // MARK: Main
    // main method for MuseumManager.java
    // what a comment, its almost as if the main method is called the main method, and is 100% self-explainitory
    static int i = 0;
    static int j = 0;

    public MuseumManager(double i) {

    }

    public MuseumManager() {
        this(1);
    }

    public static void main(String[] args) {

        int i = 2;

        {
            int j = 3; 
            System.out.println( j + i );
        }

        // if (unitTests()) {
        //     System.out.println("All unit tests passed.\n");
        // } else {
        //     System.out.println("ERROR: Failed test.\n");
        //     return;
        // }
    }
}

class Test {

    private double i;

    public Test(double i) {
        t();
        i = i;
    }

    public Test() {
        this(1);
        System.out.println("Default Constructor");
    }

    public void t() {
        System.out.println("Invokign t");
    }

}