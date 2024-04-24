/*
 * This is the starter code for Assignment 3 - MuseumManager (CSE 11 SP24)
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

public class MuseumManager {

    // Feel free to create extra variables if necessary.

    /* Variables used for museumSchedule */
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

    // TODO: add methods below

    // TODO: Add more unit tests to ensure correctness of methods.
    public static boolean unitTests() {
        System.out.println(); 

        // Test(s) for museumSchedule
        // Test case 1: dayOfWeek = 3, isMember = true, isHoliday = false
        int museumSchedDay1 = 3;
        boolean museumSchedMember1 = true;
        boolean museumSchedHoliday1 = false;
        String expectedSchedule1 = "Today's exhibits:\nphotographs\n" + 
            "artifacts\nmodern installations\n"; 
        System.out.println("Expected museumSchedule Output 1:\n");
        System.out.println(expectedSchedule1);
        System.out.println("-----------------");
        System.out.println("museumSchedule Output 1:\n");
        museumSchedule(museumSchedDay1, museumSchedMember1, 
            museumSchedHoliday1);
        System.out.println();

        // Test case 2: ...
        // ...


        // Test(s) for guideTour
        // Test case 1: dayOfWeek = 5, hourOfDay = 11
        String actualTour1 = guideTour(5, 11);
        System.out.println("guideTour Output 1: " + actualTour1);
        if (!actualTour1.equals(
                "Guiding the tour of paintings and sculptures")) {
            System.out.println("FAILED: guideTour 1");
            return false;
        }

        // Test case 2: ...
        // ...


        // Test(s) for calcAdmissionFee
        // Test case 1: dayOfWeek = 6, age = 45, isMember = true
        double actualFee1 = calcAdmissionFee(6, 45, true);
        System.out.println("calcAdmissionFee Output 1: " + actualFee1);

        if (actualFee1 != 24.0) {
            System.out.println("FAILED: calcAdmissionFee 1");
            return false;
        }

        // Test case 2: ...
        // ...

        // All test cases passed
        return true;
    }

    // TODO: Complete the method header
    // MARK: Main
    public static void main(String[] args) {

        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("ERROR: Failed test.\n");
            return;
        }
    }
}