// Title:              Assignment4
// Files:              FunWithArrays.java, RecursiveHourglass.java
// Quarter:            CSE11 Spring 2024
//
// Author:             Brian Masse
// Email:              bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa


// Main Class File:    RecursiveHourglass
// File:               RecursiveHourglass.java
// Quarter:            CSE11 Spring 2024
//
// Author:             Brian Masse
// Instructor's Name:  Ben Ochoa
public class RecursiveHourglass {

    // MARK: Vars
    public static int recursionCallCount = 0; 

    // MARK: Methods
    private static String getline(char c, int n, int numSpaces) {
        String line = ""; 
        for (int i = 0; i < numSpaces; i++) {
            line += ' '; 
        }
        for (int i = 0; i < n; i++) {
            line += c; 
        }
        for (int i = 0; i < numSpaces; i++) {
            line += ' '; 
        }
        line += '\n'; 
        return line; 
    }

    public static String recursiveHourglass (char c, int height,  int numSpaces) {
        recursionCallCount++;

        if (height <= 0 || height % 2 == 0) { return ""; }

        String str = getline(c, height, numSpaces);

        if (height == 1) { return str; }

        return str + recursiveHourglass(c, height - 2, numSpaces + 1) + str;
    }

    // MARK: Convenience Functions
    // similar to the testDoubleMethod, this tests whether an actual string matches an expected output, and returns it as a boolean
    public static Boolean testStringMethod( String methodName, int testNumber, String output, String expectedOutput ) {
        System.out.println( "  " + methodName + " " + testNumber + ":\n" + output + " \nexpected:\n" + expectedOutput + "]\n" );
        if (!output.equals(expectedOutput)) {
            System.out.println( "FAILED: " + methodName + " " + testNumber );
            return false;
        }
        return true; 
    }

    // MARK: UnitTests
    public static boolean unitTests() {
        // caseI
        String expected = "***\n * \n***\n"; 
        String output = recursiveHourglass('*', 3, 0);        
        if (!testStringMethod("recursiveHourglass", 1, expected, output)) { return false; }

        // caseII
        expected = " 00000 \n  000  \n   0   \n  000  \n 00000 \n"; 
        output = recursiveHourglass('0', 5, 1);
        if (!testStringMethod("recursiveHourglass", 2, expected, output)) { return false; }

        // caseII
        expected = ""; 
        output = recursiveHourglass('u', 10, 0);
        if (!testStringMethod("recursiveHourglass", 3, expected, output)) { return false; }

        System.out.println( recursiveHourglass('/', 101, 0) );

        return true; 
    }

    // MARK: Main
    // the main starting point of this file + host of the unit tests
    public static void main(String[] args) {
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("ERROR: Failed test.\n");
            return;
        }
    }
}
