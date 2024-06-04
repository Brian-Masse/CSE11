import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Main Class File:    Assignment7
// File:               Assignment7.Java
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
public class Assignment7 {

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

    /**
     * helper function that reads a file and returns the output
     * throws an error if the file does not exist
     * @param fileName: the name of the file
     * @return the contents of the file
     */
    private static String readFile(String fileName) throws Exception {
        String importedContent = "";

        try {
            File file = new File( fileName );
            Scanner scanner = new Scanner(file);

            while ( scanner.hasNextLine() ) {
                String data = scanner.nextLine();
                importedContent += data + "\n";
            }

            scanner.close();
        } catch ( FileNotFoundException e ) {
            System.out.println( "an error occoured when accessing the file " + 
            fileName + " " + e.getMessage() );
            throw e;
        }

        return importedContent;
    }

    // MARK: Test 1
    /**
     * Test 1
     * Tests the equals function on files and directories
     * @return whether the test passed
     */
    private static boolean testOne() {
        printTestingHeader("Test 1",
         "Tests the equals function on files and directories");

        RootDirectory root = new RootDirectory("Home");
        HumanReadableFile pic = new HumanReadableFile("cat.png",
                                                      "contents of picture");
        HumanReadableFile rice = new HumanReadableFile("rice.mp3",
                                                      "contents of mp3 file");
        SubDirectory music = new SubDirectory("music");
        root.addComponent(pic);
        root.addComponent(rice);
        root.addComponent(music);

        if (!root.getName().equals("Home")) return false;
        if (!pic.getName().equals("cat.png")) return false;
        if (!rice.getName().equals("rice.mp3")) return false;
        if (!music.getName().equals("music")) return false;

        System.out.println();
        return true;
    }

    // MARK: Test 2
    /**
     * Test2
     * tests the outputFileContents method on file
     * @return whether the test passed
     */
    private static boolean testTwo() {
        printTestingHeader("Test 2", 
        "tests the outputFileContents method on file");

        RootDirectory root = new RootDirectory( "./Users" );

        String expectedOutput = "this is a great picture";
        String expectedOutput2 = "this is an even better picture";
        HumanReadableFile pic1 = new HumanReadableFile("picture1",
                                                        expectedOutput);
        HumanReadableFile pic2 = new HumanReadableFile("picture2", 
                                                        expectedOutput2);

        root.addComponent(pic1);
        root.addComponent(pic2);

        try { pic1.outputFileContents("pic1"); }
        catch (Exception error) {  System.out.println(error.getMessage()); }

        String output = "";
        try { output = readFile("pic1"); }
        catch (Exception error) { System.out.println( error.getMessage()); }

        return output.equals(expectedOutput + "\n");
    }

    // MARK: Test 3
    /**
     * Test3
     * Tests the initialization + output method for archived Files
     * @return whether the test passed
     */
    private static boolean testThree() {
        printTestingHeader("Test 3",
        "Tests the initialization + output method for archived Files");

        RootDirectory root = new RootDirectory( "./Users" );

        String file1 = "this is a great picture";
        String file2 = "this is an even better picture";
        HumanReadableFile pic1 = new HumanReadableFile("picture1", file1);
        HumanReadableFile pic2 = new HumanReadableFile("picture2", file2);
        SubDirectory dir1 = new SubDirectory("dir1");

        root.addComponent(pic1);
        root.addComponent(pic2);
        root.addComponent(dir1);

        FSComponent[] comps = new FSComponent[3];
        ArrayList<FSComponent> listComps = root.getComponentList();
        for ( int i =0; i < 3; i++ ) {
            comps[i] = listComps.get(i);
        }

        ArchiveFile archiveFile = new ArchiveFile("archive", comps);

        try { archiveFile.outputFileContents("archive"); }
        catch (Exception error) {  System.out.println(error.getMessage()); }

        String output = "";
        try { output = readFile("archive"); }
        catch (Exception error) { System.out.println( error.getMessage()); }
        
        return output.equals( "picture1\npicture2\ndir1\n" );
    }

    // MARK: Test 4
    /**
     * Test4
     * Tests empty initializations for all classes + raising an
     * exception when exporting empty content to a file
     * @return whether the test passed
     */
    private static boolean testFour() {
        printTestingHeader("Test 4",
        "Tests empty initializations for all classes + raising an exception when exporting empty content to a file");

        HumanReadableFile humanReadableFile = new HumanReadableFile();
        ArchiveFile archiveFile = new ArchiveFile();
        SubDirectory subDirectory = new SubDirectory();
        RootDirectory rootDirectory = new RootDirectory();

        boolean caughtEmptyHRFName = false;
        boolean caughtEmptyAFName = false;
        boolean caughtEmptySDName = false;
        boolean caughtEmptyRDName = false;

        try { humanReadableFile.outputFileContents("empty");
        } catch (Exception e) { caughtEmptyHRFName = true; }
        
        try { archiveFile.outputFileContents("empty");
        } catch (Exception e) { caughtEmptyAFName = true; }

        try { subDirectory.outputComponentNames("empty");
        } catch (Exception e) { caughtEmptySDName = true; }

        try { rootDirectory.outputComponentNames("empty");
        } catch (Exception e) { caughtEmptyRDName = true; }

        return caughtEmptyHRFName && 
                caughtEmptyAFName &&
                caughtEmptySDName &&
                caughtEmptyRDName;
    }

    // MARK: Test 5
    /**
     * Test5
     * Tests adding files + directories of the same name to the same sub folder
     * @return whether the test passed
     */
    private static boolean testFive() {
        printTestingHeader("Test 5",
        "Tests adding files + directories of the same name to the same sub folder");

        String file1Name = "file1.zip";
        String file2Name = "name2";

        String dir1Name = "dir1Name";
        String dir2Name = "name2";

        RootDirectory root = new RootDirectory("root");

        HumanReadableFile file1 = new HumanReadableFile( file1Name, "content" );
        ArchiveFile file2 = new ArchiveFile(file1Name, new FSComponent[0]);
        ArchiveFile file3 = new ArchiveFile(file2Name, new FSComponent[0]);

        SubDirectory directory1 = new SubDirectory( dir1Name );
        SubDirectory directory2 = new SubDirectory( dir1Name );
        SubDirectory directory3 = new SubDirectory( dir2Name );

        root.addComponent(file1);
        root.addComponent(directory1);

        if (root.getComponentList().size() != 2) { return false; }

        if ( root.addComponent(file2) != false ) { return false; }
        if ( root.addComponent(directory2) != false ) { return false; }
        if (root.getComponentList().size() != 2) { return false; }

        if ( root.addComponent(file3) != true ) { return false; }
        if ( root.addComponent(directory3) != true ) { return false; }
        if (root.getComponentList().size() != 4) { return false; }

        return true;
    }

    // MARK: 6
    /**
     * Test6
     * Tests imputing contents from a pre-existing file,
     * then reoutputting it and reading it
     * @return whether the test passed
     */
    private static boolean testSix() {
        printTestingHeader("Test 6",
        "Tests imputing contents from a pre-existing file, then reoutputting it and reading it");

        String expectedOutput = "picture1picture2dir1";
        
        HumanReadableFile file = new HumanReadableFile("fileName", "null");

        try { file.inputFileContents("archive"); }
        catch (Exception e) { System.out.println(e.getMessage()); }

        if ( !file.getContents().equals(expectedOutput) ) { return false; }

        try { file.outputFileContents("fileNameOutput"); }
        catch (Exception e) { System.out.println( e.getMessage() ); }

        String output = "";
        try { output = readFile("fileNameOutput"); }
        catch (Exception e) { System.out.println( e.getMessage()); }

        return output.equals(expectedOutput + "\n");
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
        if (unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("Failed test.\n");
        }
    }
}
