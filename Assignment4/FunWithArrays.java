// Title:              Assignment4
// Files:              FunWithArrays.java, RecursiveHourglass.java
// Quarter:            CSE11 Spring 2024
//
// Author:             Brian Masse
// Email:              bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
import java.util.Arrays;

// Main Class File:    FunWithArrays
// File:               FunWithArrays.java
// Quarter:            CSE11 Spring 2024
//
// Author:             Brian Masse
// Instructor's Name:  Ben Ochoa
public class FunWithArrays {


    // MARK: Methods
    // finds the index of the longest String element in an array
    // if there are multiple, it returns the last
    public static int findPosition(String[] array) {
        if ( array == null || array.length == 0 ) { return 0; }

        int longestString = 0;
        int longestStringIndex = 0;
        for ( int i = 0; i < array.length; i++ ) {
            if (array[i].length() >= longestString) { 
                longestString = array[i].length();
                longestStringIndex = i; 
            }
        }
        return longestStringIndex;
    }


    // finds the average of an array of integers, and returns it as a double
    public static double findAvg(int[] array) {
        if ( array == null || array.length == 0 ) { return 0; }

        double sum = 0;
        for ( int num : array ) { sum+=num; }

        return sum / array.length;
    }

    // create and return a deep copy of the passed array
    // the references to the original array and to the generated deep copy should be different
    public static int[] arrayCopy(int[] array) {
        if (array == null) { return null; }

        int[] deepCopy = new int[array.length];
        for (int i =0; i < array.length; i++) {
            deepCopy[i] = array[i];
        }

        return deepCopy;
    }

    // checks if there is a subArray in the passed Array that contains consequitive, accending digits
    // the minimum length for the subArray is 2
    public static boolean containsIntegerSequence(int[] array) {
        if ( array == null || array.length == 0) { return false; }

        int previousValue = array[0];
        for (int num : array) {
            if (num - previousValue == 1) { return true; }
            previousValue = num;
        }
        return false;
    }

    // reversed the given array in place
    // the reference to the reversed array is the same as the original
    public static void reverseArray(String[] array) {
        int iterations = (int) Math.floor((array.length / 2));

        for (int i=0; i < iterations; i++) {
            String replacing = array[ i ];
            int endIndex = array.length - 1 - i;

            array[ i ] = array[ endIndex ];
            array[ endIndex ] = replacing;
        }
    }

    // finds the difference between the biggest and smallest int in the passed array
    // the array is a 2D array, layed out (row, col)
    public static int findRange(int[][] array) {
        if (array == null || array.length == 0) { return 0; }

        int max = array[0][0];
        int min = array[0][0];

        for (int row=0; row < array.length; row++) {
            for (int col=0; col < array[row].length; col++) {
                max = Math.max( max, array[row][col] );
                min = Math.min( min, array[row][col] );
            }
        }

        return max - min;
    }

    // create a new 2D integer array, where each element is the average of the elemtn in that
    // location on arr1 and arr2
    public static float[][] arrayAverage(int[][] arr1, int[][] arr2) {
        if ( arr1 == null || arr2 == null) { return null; } 
        
        // this assumes the matricies are in fact matricies, and not uneven
        int rows1 = arr1.length;
        int cols1 = arr1[0].length; 
        int rows2 = arr2.length;
        int cols2 = arr2[0].length;

        if ( rows1 != rows2 || cols1 != cols2 ) { return null; }

        float[][] averageArray = new float[rows1][cols1];

        for ( int row=0; row < rows1; row++ ) {
            for ( int col=0; col<cols1; col++ ) {
                float sum = (arr1[row][col] + arr2[row][col]);
                float average = sum / 2;
                averageArray[row][col] = average;
            }
        }
        return averageArray;
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

        System.out.println( "  " + methodName + " " + testNumber + ": " + output + " [expected: " + expectedOutput + "]\n" );

        if (roundedExpectedOutput != roundedOutput) {
            System.out.println( "FAILED: " + methodName + " " + testNumber );
            return false;
        }
        return true; 
    }

    // similar to the testDoubleMethod, this tests whether an actual string matches an expected output, and returns it as a boolean
    public static Boolean testStringMethod( String methodName, int testNumber, String output, String expectedOutput ) {
        System.out.println( "  " + methodName + " " + testNumber + ": " + output + " [expected: " + expectedOutput + "]\n" );
        if (!output.equals(expectedOutput)) {
            System.out.println( "FAILED: " + methodName + " " + testNumber );
            return false;
        }
        return true; 
    }

    // generic test method. Similar to the string and bool methods, it tests whether an actual output is the same as an expected output
    // and formats the results of the test in a readable output
    // testDoubleMethod and testStringMethod should still be used when they can, since they have special modifiers to make them particularly
    // effective ast testing those kinds of output
    public static <T> boolean testMethod( String methodName, int testNumber, T output, T expectedOutput) {
        System.out.println( "  " + methodName + " " + testNumber + ": " + output + " [expected: " + expectedOutput + "]\n" );

        if (expectedOutput != output) {
            System.out.println( "FAILED: " + methodName + " " + testNumber );
            return false;
        }
        return true; 
    }

    public static <T> boolean testArrayMethod( String methodName, int testNumber, T[] output, T[] expectedOutput) {
        System.out.println( "  " + methodName + " " + testNumber + ": " + Arrays.deepToString(output) + " [expected: " + Arrays.deepToString(expectedOutput) + "]\n" );

        if (!Arrays.deepEquals (output, expectedOutput)) {
            System.out.println( "FAILED: " + methodName + " " + testNumber );
            return false;
        }
        return true; 
    }

    // tests and formats the arrayCopyMethod
    public static boolean testArrayCopyMethod( String methodName, int testNumber, int[] array ) {
        int[] copy = arrayCopy(array);

        System.out.println( "  " + methodName + " " + testNumber + ": " + Arrays.toString(copy) + " [expected: " + Arrays.toString(array) + "]\n" );

        if (copy != null) {
            if (copy.length != array.length) {
                System.out.println( "FAILED: " + methodName + " " + testNumber );
                return false; 
            }
            for (int i = 0; i < copy.length; i++) {
                if (copy[i] != array[i]) {
                    System.out.println( "FAILED: " + methodName + " " + testNumber );
                    return false; 
                }
            }
            if (copy == array) {
                System.out.println( "FAILED: " + methodName + " " + testNumber );
                return false; 
            }
        }
        return true;
    }

    // tests and formats the reverseArrayMethod
    public static boolean testReverseArrayMethod( String methodName, int testNumber, String[] array, String[] expectedArray) {
        reverseArray(array);

        System.out.println( "  " + methodName + " " + testNumber + ": " + Arrays.toString(array) + " [expected: " + Arrays.toString(expectedArray) + "]\n" );

        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != expectedArray[i]) {
                    System.out.println( "FAILED: " + methodName + " " + testNumber );
                    return false; 
                }
            }
        }
        return true;
    }

    public static void printTestingHeader(String methodName) {
        System.out.println( "------------------------" );
        System.out.println( methodName + " TESTS" );
        System.out.println( "------------------------\n" );
    }


    // MARK: Unit Tests
    public static boolean unitTests() {
        // findPosition tests
        String methodName = "findArrayposition";

        printTestingHeader(methodName);

        // caseI
        String[] findArrayPositionArr = {"cat", "mouse", "bear", "horse", "dog"}; 
        int findArrayPositionOutput = findPosition(findArrayPositionArr);
        if (!testMethod(methodName, 1, findArrayPositionOutput, 3)) { return false; };

        // caseII
        findArrayPositionArr = null;
        findArrayPositionOutput = findPosition(findArrayPositionArr);
        if (!testMethod(methodName, 2, findArrayPositionOutput, 0)) { return false; }

        // caseIII
        String[] findArrayPositionArr2 = { "cat", "cat", "cat", "cat", "cat" };
        findArrayPositionOutput = findPosition(findArrayPositionArr2);
        if (!testMethod(methodName, 3, findArrayPositionOutput, 4)) { return false; }



        // findAvg tests
        methodName = "findAvg";
        printTestingHeader(methodName);

        // caseI
        int[] findAvgArray = {1, 2, 3, 4, 5}; 
        double output = findAvg(findAvgArray);
        if ( !testDoubleMethod(methodName, 1, output, 3) ) { return false; }

        // caseII
        int[] findAvgArray2 = { 1, 2, 3, 4, 5, 6 };
        output = findAvg(findAvgArray2);
        if (!testDoubleMethod(methodName, 2, output, 3.5)) { return false; }

        findAvgArray2 = null;
        output = findAvg(findAvgArray2);
        if (!testDoubleMethod(methodName, 2, output, 0)) { return false; }


        // arrayCopy tests
        methodName = "arrayCopy";
        printTestingHeader(methodName);

        // caseI
        int[] arrayCopyArray = {1, 2, 3, 4, 5}; 
        if (!testArrayCopyMethod(methodName, 1, arrayCopyArray)) { return false; }

        // caseII
        int[] arrayCopyArray2 = {}; 
        if (!testArrayCopyMethod(methodName, 1, arrayCopyArray2)) { return false; }

        // caseIII
        int[] arrayCopyArray3 = null; 
        if (!testArrayCopyMethod(methodName, 1, arrayCopyArray3)) { return false; }


        // containsIntegerSequence tests 
        methodName = "containsIntegerSequence";
        printTestingHeader(methodName);
        
        // caseI
        int[] containsIntegerSequenceArray = {0, 3, 1}; 
        boolean containsSequenceOutput = containsIntegerSequence(containsIntegerSequenceArray);
        if (!testMethod(methodName, 1, containsSequenceOutput, false) ) { return false; }

        // caseII
        int[] containsIntegerSequenceArray2 = {0, 3, 4, 1, 5}; 
        containsSequenceOutput = containsIntegerSequence(containsIntegerSequenceArray2);
        if (!testMethod(methodName, 1, containsSequenceOutput, true) ) { return false; }

        // caseII
        int[] containsIntegerSequenceArray3 = {0}; 
        containsSequenceOutput = containsIntegerSequence(containsIntegerSequenceArray3);
        if (!testMethod(methodName, 1, containsSequenceOutput, false) ) { return false; }



        // reverseArray tests
        methodName = "reverseArray";
        printTestingHeader(methodName);

        // caseI
        String[] arr = {"red", "green", "blue", "purple"}; 
        String[] reversed = {"purple", "blue", "green", "red"}; 
        if (!testReverseArrayMethod(methodName, 1, arr, reversed)) { return false; }

        // caseII
        String[] arr2 = {}; 
        String[] reveresed2 = {}; 
        if (!testReverseArrayMethod(methodName, 2, arr2, reveresed2)) { return false; }

        // caseIII
        String[] arr3 = { "red", "green", "blue", "purple", "odd element" }; 
        String[] reveresed3 = { "odd element", "purple", "blue", "green", "red" }; 
        if (!testReverseArrayMethod(methodName, 3, arr3, reveresed3)) { return false; }


        // findRange tests
        methodName = "findRange";
        printTestingHeader(methodName);

        // caseI
        int[][] findArrayRange = {{1, 0, 1}, {2, 4, 1}, {3, 2, 1}}; 
        int range = findRange(findArrayRange);
        if (!testMethod(methodName, 1, range, 4)) { return false; }

        // caseII
        int[][] findArrayRange2 = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -5}}; 
        range = findRange(findArrayRange2);
        if (!testMethod(methodName, 2, range, 4)) { return false; }

        // caseIII
        int[][] findArrayRange3 = {}; 
        range = findRange(findArrayRange3);
        if (!testMethod(methodName, 3, range, 0)) { return false; }


        // arrayAverage tests
        methodName = "arrayAverage";
        printTestingHeader(methodName);

        // caseI
        int[][] arrayAverageInput1 = {{1, 0, 1},
                                      {2, 4, 1},
                                      {3, 2, 1}}; 
        int[][] arrayAverageInput2 = {{1, 2, 5},
                                      {6, 3, 1},
                                      {1, 1, 8}}; 
        float[][] arrayAverageAnswer = {{1, 1, 3},
                                        {4, 3.5f, 1},
                                        {2, 1.5f, 4.5f}};
        float[][] arrayAverageResult = arrayAverage(arrayAverageInput1, 
                                       arrayAverageInput2);
        if (!testArrayMethod(methodName, 1, arrayAverageResult, arrayAverageAnswer )){ return false; }

        // caseII
        int[][] arrayAverageInput3 = {{0, 0, 0},
                                      {0, 0, 0},
                                      {0, 0, 0}}; 
        float[][] arrayAverageAnswer2 = {{0, 0, 0},
                                      {0, 0, 0},
                                      {0, 0, 0}}; 
        float[][] arrayAverageResult2 = arrayAverage(arrayAverageInput3, 
                                       arrayAverageInput3);
        if (!testArrayMethod(methodName, 2, arrayAverageResult2, arrayAverageAnswer2 )){ return false; }

        // caseIII
        int[][] arrayAverageInput4 = {{0, 0, 0},
                                      {0, 0, 0}}; 
        float[][] arrayAverageResult3 = arrayAverage(arrayAverageInput4, 
                                       arrayAverageInput3);
        if (!testArrayMethod(methodName, 2, arrayAverageResult3, null )){ return false; }

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
