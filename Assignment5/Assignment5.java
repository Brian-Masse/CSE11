// Main Class File:    Assignment5
// File:               Ticket.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
import java.util.Arrays;

/**
 * Assignment5 is the main class for this assignment
 * it houses the main function for the program, and runs unit tests
 * for the logical implementation of all other files
 * @author Brian Masse
 */
public class Assignment5 {

    // MARK: Convenience Functions
    /**
     * helper function to test methods that return a string
     * checks if the output matches an expected output, via .equals
     * if they do not match it prints an error message and returns false
     * @param methodName: the method you are testing
     * @param testNumber: the number of this test
     * @param output: the actual output of your code
     * @param expectedOutput: the expected output of your code
     * @return returns true if the values match and false if they dont
     */
    public static Boolean testStringMethod( String methodName, int testNumber, String output, String expectedOutput ) {
        System.out.println( "  " + methodName + " " + testNumber + ": " + output + " [expected: " + expectedOutput + "]\n" );
        if (!output.equals(expectedOutput)) {
            System.out.println( "FAILED: " + methodName + " " + testNumber );
            return false;
        }
        return true; 
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
     * function to test methods that returns an arbitrary equatable output
     * checks if the output matches an expected output, via ==
     * if they do not match it prints an error message and returns false
     * @param methodName: the method you are testing
     * @param testNumber: the number of this test
     * @param output: the actual output of your code
     * @param expectedOutput: the expected output of your code
     * @return returns true if the values match and false if they dont
     */
    public static <T> boolean testMethod( String methodName, int testNumber, T output, T expectedOutput) {
        System.out.println( "  " + methodName + " " + testNumber + ": " + output + " [expected: " + expectedOutput + "]\n" );

        if (expectedOutput != output) {
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
    public static boolean testArrayMethod( String methodName, int testNumber, int[] output, int[] expectedOutput) {
        System.out.println( "  " + methodName + " " + testNumber + ": " + Arrays.toString(output) + " [expected: " + Arrays.toString(expectedOutput) + "]\n" );

        if (!Arrays.equals(output, expectedOutput)) {
            System.out.println( "FAILED: " + methodName + " " + testNumber );
            return false;
        }
        return true; 
    }

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

    // MARK: Unit Tests
    /**
     * the unit tests for Autograder.java, Queue.java, Ticket.java
     */
    public static boolean unitTests() {

        // MARK: Ticket.java Tests
        Ticket ticket = new Ticket(); 
        String testName = "Ticket.java";
        printTestingHeader(testName);

        // Ticket test case 1 
        String ticketExpectedOutput = "Jon Snow";
        ticket.setStudentName(ticketExpectedOutput);
        if ( !testStringMethod(testName, 1, ticketExpectedOutput, ticket.getStudentName())) { return false; } 

        // Ticket test case 2 
        int[] timeStamp = {16,20,34}; 
        int[] currentTime = {18,14,55};
        ticket = new Ticket("Jon Snow", timeStamp, "B250A", 
                              "I need help debugging a problem", true); 
        if ( !testMethod(testName, 2, ticket.totalWait(currentTime), 114) ) { return false; }

        // Ticket test case 3
        int[] expectedTimeStamp = {16,20,34};
        if ( !testArrayMethod(testName, 3, expectedTimeStamp, ticket.getTimeStamp()) ) { return false; } 

        // Ticket test case 4
        // tetsing whether the references are different when setting the timeStamp
        ticket.setTimeStamp(currentTime);
        if ( currentTime == ticket.getTimeStamp() ) { return false; }

        // Ticket test case 5
        int wait = ticket.totalWait(currentTime);
        if ( !testMethod(testName, 5, wait, 0) ) { return false; } 


        // MARK: Queue.java tests
        // Queue.java test cases
        String queueTestName = "Queue.java";
        printTestingHeader(queueTestName);

        // Queue test case 1
        Queue cse11 = new Queue(5);
        Ticket st1 = new Ticket("Bob Button", new int[]{11,25,33},"Basement",
                                "How to get started", false);
        Ticket st2 = new Ticket("Sponge Bob", new int[]{13,24,46},
                                "Under the sea", "I need help debugging Gary",
                                true);
        cse11.enqueue(st1);
        cse11.enqueue(st2); 
        
        if ( !testMethod(queueTestName, 1, st1, cse11.peek()) ) { return false; }
        if ( !testMethod(queueTestName, 1, cse11.size(), 2)) { return false; }
        
        // Queue test case 2
        Queue queue2 = new Queue(3);
        Ticket st3 = new Ticket("Brian Masse", new int[]{15,06,00}, "dorm", "no description", true);

        queue2.enqueue(st1);
        queue2.enqueue(st2);
        queue2.enqueue(st3);

        if (!testMethod(queueTestName, 2, queue2.size(), 3)) { return false; }
        if (!testMethod(queueTestName, 2, queue2.isLocked(), true)) { return false; }

        queue2.dequeue();
        queue2.dequeue();
        queue2.dequeue();

        if (!testMethod(queueTestName, 2, queue2.size(), 0)) { return false; }
        if (!testMethod(queueTestName, 2, queue2.isLocked(), false)) { return false; }

        // Queue test case 3
        Queue queue3 = new Queue(5);
        currentTime = new int[]{16,0,0};

        queue3.enqueue(st1);
        queue3.enqueue(st2);
        queue3.enqueue(st3);

        int averageTime = (st1.totalWait(currentTime) + st2.totalWait(currentTime) + st3.totalWait(currentTime)) / 3;

        if ( !testIntMethod(queueTestName, 3, queue3.avgWait(currentTime), averageTime)) { return false; }

        queue3.dequeue();
        queue3.dequeue();
        queue3.dequeue();

        if ( !testIntMethod(queueTestName, 3, queue3.avgWait(currentTime), 0)) { return false; }
    
        // Queue test case 4
        Queue queue4 = new Queue( 2 );
        queue4.enqueue(st1);
        queue4.enqueue(st2);
        queue4.enqueue(st3);

        if (!testIntMethod(queueTestName, 4, queue4.size(), 2)) { return false; }

        Ticket ticket1 = queue4.dequeue();
        queue4.enqueue(st3);

        if ( !testMethod(queueTestName, 4, ticket1, st1) ) { return false; }
        if ( !testIntMethod(queueTestName, 4, queue4.size(), 2) ) { return false; }

        queue4.dequeue();
        Ticket ticket2 = queue4.dequeue();

        if( !testMethod(queueTestName, 4, ticket2, st3) ) { return false; }
        if( !testMethod(queueTestName, 4, queue4.size(), 0) ) { return false; }




        // MARK: Autograder.java tets
        String autoGraderTestName = "Autograder.java";
        printTestingHeader(autoGraderTestName);

        // // Autograder test case 1
        Autograder cse11AG = new Autograder("CSE11", 20); 
        st3 = new Ticket("Sponge Bob", new int[]{14,24,46},
                                "Under the sea", "I need help debugging Gary", 
                                true);
        cse11AG.submitTicket(st3); 

        if( !testMethod(autoGraderTestName, 1, cse11AG.isQueueLocked(), false) ) { return false; }
        if ( !testIntMethod(autoGraderTestName, 1, cse11AG.getAvgWait(new int[]{15,24,55}),60) ) { return false; }

        String output= "Student Name: Sponge Bob\n" +
                       "Submitted at: 14:24\n" +
                       "Location: Under the sea\n" +
                       "Description: I need help debugging Gary";
        if ( !testStringMethod(autoGraderTestName, 1, cse11AG.viewNextTicket(), output) ) { return false; } 

        Ticket st4 = new Ticket("Patrick Star", new int[]{13,59,02}, 
                                "Bikini Bottom",
                                "Can you help me find sponge Bob?", false);
        cse11AG.submitTicket(st4);

        if ( !testStringMethod(autoGraderTestName, 1, cse11AG.resolveNextTicket(), output) ) { return false; }

        cse11AG.getAutograderDetails(new int[]{16,17,18});

        // Autograder test case 2
        Autograder testAG = new Autograder("testClass", 4);
        testAG.submitTicket(st1);
        testAG.submitTicket(st2);
        testAG.submitTicket(st3);
        testAG.submitTicket(st4);

        if ( !testMethod(autoGraderTestName, 2, true, testAG.isQueueLocked()) ) { return false; }
        output = testAG.getTicketDetails(st1);

        if( !testStringMethod(autoGraderTestName, 2, testAG.viewNextTicket(), output) ) { return false; }
        
        testAG.resolveNextTicket();
        output = testAG.getTicketDetails(st2);

        if( !testStringMethod(autoGraderTestName, 2, testAG.viewNextTicket(), output) ) { return false; }

        testAG.resolveNextTicket();
        testAG.resolveNextTicket();
        testAG.resolveNextTicket();

        if( !testMethod(autoGraderTestName, 2, testAG.getAvgWait(currentTime), 0) );

        // Autograder test case 3
        Autograder testAG2 = new Autograder("testClass2", 0);

        output = testAG2.resolveNextTicket();
        String output2 = testAG2.viewNextTicket();
        if ( !testMethod(autoGraderTestName, 3, output, null) ) { return false; }
        if ( !testMethod(autoGraderTestName, 3, output2, null) ) { return false; }

        if( !testMethod(autoGraderTestName, 3, testAG2.isQueueLocked(), false) ) { return false; }

        testAG2.submitTicket(st1);

        if ( !testMethod(autoGraderTestName, 3, testAG2.viewNextTicket(), null) )  { return false; }

        if ( !testIntMethod(autoGraderTestName, 3, testAG2.getAvgWait(currentTime), 0)) { return false; }


        // Autograder test case 4
        Autograder testAG3 = new Autograder("testClass3", 50);
        
        for ( int i =0; i < 50; i++ ) {
            testAG3.submitTicket(st4);
        }

        output = testAG3.getTicketDetails(st4);
        int expectedAverageTime = st4.totalWait(currentTime);

        if( !testStringMethod(autoGraderTestName, 4, output, testAG3.viewNextTicket()) ) { return false; }
        if ( !testMethod(autoGraderTestName, 4, testAG3.isQueueLocked(), true) ) { return false; }
        if ( !testIntMethod(autoGraderTestName, 4, testAG3.getAvgWait(currentTime), expectedAverageTime) ) { return false; }

        testAG3.resolveNextTicket();
        testAG3.submitTicket(st3);

        output = testAG3.getTicketDetails(st3);

        for ( int i=0; i < 49; i++ ) {
            testAG3.resolveNextTicket();
        }

        if ( !testStringMethod(autoGraderTestName, 4, testAG3.viewNextTicket(), output) ) { return false; }


        return true; 
    }


    /**
     * the main function of this program
     * takes in the default args and runs the unit tests for each file
     */
    public static void main(String[] args) {



        // if (unitTests()) {
        //     System.out.println("All unit tests passed.\n");
        // } else {
        //     System.out.println("ERROR: Failed test.\n");
        //     return;
        // }

        SuperTest t1 = new SuperTest();
        SubTest t2 = new SubTest();

        t1.print();
        t2.print();
    }
}

class SuperTest {

    double length; 

    public void print() {
        System.out.println(test());
    }

    public int test() { return 1; }

}

class SubTest extends SuperTest {
    @Override
    public int test() {return 0;}
}