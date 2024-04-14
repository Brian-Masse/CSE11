// Title:              Assignment2
// Files:              Assignment 2
// Quarter:            CSE11 Spring 2024
//
// Author:             Brian Masse
// Email:              bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa

import java.util.Scanner; // Import the Scanner class
import java.io.Console;
import java.lang.Math; // Import the Math class

// Main Class File:    Assignment2
// File:               Assignment2.java
// Quarter:            (course) (quarter) (year)
//
// Author:             Brian Masse
// Instructor's Name:  Ben Ochoa
public class Assignment2 {

    private final static String PROMPT_MSG_NAME =
            "Please enter your name.";

     
    // this rounds off a double to the desired number of digits
    public static double truncateDouble( double value, int digits ) {
        return Math.round(value * Math.pow( 10, digits )) / Math.pow(10, digits);
    }

    // calculates the volume of 3D sphere; V=(4/3) * pi * r^3
    public static double sphereVolume(double radius) {
        double volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3);

        return volume; 
    }

    
    // calculates the difference between 2 points in cartesian coordinates, given by (x1, y1), (x2, y2)
    public static double euclideanDistance(double x1, double x2, 
        double y1, double y2) {

        double deltaX = x2 - x1;
        double deltaY = y2 - y1;

        double distance = Math.sqrt( Math.pow( deltaX, 2 ) + Math.pow( deltaY, 2 ) );

        return distance; 
    }

    // computes the absolute difference between the expressions (a/b) and (c/d)
    public static double divisionDifference(int a, int b, int c, int d) {

        double division1 = (double) a / (double) b;
        double division2 = (double) c / (double) d;

        // this is a bad variable name; should be difference—memory is not limited for variable names
        double diff = Math.abs( division1 - division2 );

        return diff;
    }

    // computes the absolute difference between
    // 1. the integer representation of the String num
    // 2. the integer representation of the String ( num + the subString of num from a to b )
    public static int concatSubIntegers(String num, int a, int b) {
        String subString = num.substring(a, b);

        String fullString = num + subString;
        int fullInt = Integer.parseInt( fullString );
        int ogInt = Integer.parseInt(num);

        int ans = Math.abs( fullInt - ogInt );

        return ans;
    }
 
    // returns a the combination of word1 and word2 with characters at i and len - i uppercased
    public static String concatAndModify(String word1, String word2, String i) {

        String fullString = word1 + word2;
        int len = fullString.length();

        int index = Integer.parseInt(i);

        int firstIndex = Math.min( index, len - index );
        int secondIndex = Math.max( index, len - index );

        char modifiedChar1 = fullString.charAt(firstIndex);
        char modifiedChar2 = fullString.charAt(secondIndex);

        String result = fullString.substring(0, firstIndex)
                    + Character.toUpperCase(modifiedChar1)
                    + fullString.substring(firstIndex + 1, secondIndex)
                    + Character.toUpperCase(modifiedChar2)
                    + fullString.substring(secondIndex + 1, len);
        
        return result; 
    }

    // Replaces the first occurrence of b in a with c
    public static String replaceSubstring(String a, String b, String c) {

        int index = a.indexOf(b);
        if (index != -1) {

            int lena = a.length();
            int lenb = b.length();
        
            String answer = a.substring(0, index) + c + a.substring(index + lenb , lena); 

            return answer; 

        }
        return "";
    }

    // create a diamond shape out of * and " "
    public static String createDiamond() {
        int rows = 7;
        int starCount = 1;


        String res = "";

        for ( int i = 1; i <= rows; i++ ) {
        
            int spaceCount = (rows - starCount) / 2;

            for ( int j = 1; j <= spaceCount + starCount; j++ ) {
                if (j <= spaceCount) { res += " "; } 
                else { res += "*"; }
            }

            res += "\n";

            starCount += (i <= rows / 2) ? 2 : -2;
        }

        System.out.println(res);

        return res; 
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

    public static Boolean testStringMethod( String methodName, int testNumber, String output, String expectedOutput ) {
        System.out.println( "  " + methodName + " " + testNumber + ": " + output + "\n" );
        if (!output.equals(expectedOutput)) {
            System.out.println( "FAILED: " + methodName + " " + testNumber );
            return false;
        }
        return true; 
    }

    public static boolean unitTests() {
        System.out.println(); 

        System.out.println("sphereVolume tests \n");
        // SPHERE VOLUME TESTS
        // case 1
        double radius = 3.0; 
        double expectedVol = 113.10; 
        double actualVol = sphereVolume(radius);
        if (!testDoubleMethod("sphereVolume", 1, actualVol, expectedVol)) { return false; }
    
        // case 2
        radius = 0.0; 
        expectedVol = 0; 
        actualVol = sphereVolume(radius);
        if (!testDoubleMethod("sphereVolume", 2, actualVol, expectedVol)) { return false; }

        // case 3
        radius = 1.1; 
        expectedVol = 5.57527505; 
        actualVol = sphereVolume(radius);
        if (!testDoubleMethod("sphereVolume", 3, actualVol, expectedVol)) { return false; }



        System.out.println("euclideanDistance tests \n");
        // EuclideanDistance TESTS
        // case 1
        double x1 = 2.5;
        double x2 = 5.2;
        double y1 = 3.7;
        double y2 = 7.8;
        double expectedDistance = 4.91; 
        double actualDistance = euclideanDistance(x1, x2, y1, y2);
        if (!testDoubleMethod("euclideanDistance", 1, actualDistance, expectedDistance)) { return false; }
        // case 2
        x1 = -2.5;
        x2 = -5.2;
        y1 = -3.7;
        y2 = -7.8;
        actualDistance = euclideanDistance(x1, x2, y1, y2);
        if (!testDoubleMethod("euclideanDistance", 2, actualDistance, expectedDistance)) { return false; }
        // case 3
        expectedDistance = 0; 
        actualDistance = euclideanDistance(x1, x1, y1, y1);
        if (!testDoubleMethod("euclideanDistance", 3, actualDistance, expectedDistance)) { return false; }



        System.out.println("divisionDifference tests \n");
        // divisionDifference tests
        // case 1
        double expectedDifference = 0.76; 
        double actualDifference = divisionDifference(10, 7, 2, 3);
        if (!testDoubleMethod("divisionDifference", 1, actualDifference, expectedDifference)) { return false; }
        // case2
        expectedDifference = 0; 
        actualDifference = divisionDifference(0, 7, 0, 3);
        if (!testDoubleMethod("divisionDifference", 2, actualDifference, expectedDifference)) { return false; }
        // case3
        expectedDifference = 0.76; 
        actualDifference = divisionDifference(-10, 7, -2, 3);
        if (!testDoubleMethod("divisionDifference", 3, actualDifference, expectedDifference)) { return false; }

        

        System.out.println("concatSubIntegers tests \n");
        // concatSubIntegers tests
        // case1
        int expectedOutput = 5634146;
        int actualOutput = concatSubIntegers("56910", 0, 2); 
        if (!testDoubleMethod("concatSubIntegers", 1, actualOutput, expectedOutput)) { return false; }
        // case2
        expectedOutput = 0;
        actualOutput = concatSubIntegers("00", 0, 1); 
        if (!testDoubleMethod("concatSubIntegers", 2, actualOutput, expectedOutput)) { return false; }
        // case3
        actualOutput = concatSubIntegers("56910", 0, 0); 
        if (!testDoubleMethod("concatSubIntegers", 3, actualOutput, expectedOutput)) { return false; }
        


        System.out.println("concatAndModify tests \n");
        // concatAndModify tests
        // case1
        String expectedCombined = "helLowoRld"; 
        String concatAndModifyOutput = concatAndModify("hello", "world", "3");
        if (!testStringMethod("concatAndModify", 1, concatAndModifyOutput, expectedCombined)) { return false; }

        expectedCombined = "hEllO"; 
        concatAndModifyOutput = concatAndModify("he", "llo", "4");
        if (!testStringMethod("concatAndModify", 2, concatAndModifyOutput, expectedCombined)) { return false; }

        expectedCombined = "HELLOWORLD"; 
        concatAndModifyOutput = concatAndModify("HELLO", "WORLD", "1");
        if (!testStringMethod("concatAndModify", 3, concatAndModifyOutput, expectedCombined)) { return false; }



        System.out.println("replaceSubstring tests \n");
        /// replaceSubstring test
        // case 1
        expectedCombined = "helloSara"; 
        String replaceSubstringOutput = replaceSubstring("helloworld", "world", "Sara");
        if (!testStringMethod("replaceSubstring", 1, replaceSubstringOutput, expectedCombined)) { return false; }
        // case 2
        expectedCombined = "hellMuchLongerText"; 
        replaceSubstringOutput = replaceSubstring("hello", "o", "MuchLongerText");
        if (!testStringMethod("replaceSubstring", 2, replaceSubstringOutput, expectedCombined)) { return false; }

        expectedCombined = ""; 
        replaceSubstringOutput = replaceSubstring("helloWorld", "helloWorld", "");
        if (!testStringMethod("replaceSubstring", 2, replaceSubstringOutput, expectedCombined)) { return false; }

        // All test cases passed
        return true;
    }

    // TODO: Complete the method header and the method body
    public static void main(String[] args) {

        createDiamond();

        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("ERROR: Failed test.\n");
            return;
        }

        Scanner scanner = new Scanner(System.in); 
        System.out.println(PROMPT_MSG_NAME);

        String name = scanner.nextLine();
        System.out.println( "Hello " + name + "! Nice to meet you and welcome to CSE11." );

        scanner.close();
    }
}