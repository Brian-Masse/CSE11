import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

// Main Class File:    Assignment7
// File:               HumanReadableFile.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * HumanReadableFile is a type of file that stores a string
 * it has methods to save and import computer files into this type
 * implements FSFile
 * @author Brian Masse
 */
public class HumanReadableFile extends FSFile {
    
    // MARK: Initailization
    private String contents;

    /**
     * No-arg constructor.
     */
    public HumanReadableFile() {        
        super();
    }

    /**
     * public constructor
     * @param name: the name of the file
     * @param contents: the contents of the file
     */
    public HumanReadableFile(String name, String contents) {
        super(name);
        this.contents = contents;
    }

    // MARK: Convenience Functions
    /**
     * Public getter that retrieves instance variable - contents
     * @return instance variable - contents
     */
    public String getContents() {
        return this.contents;
    }

    /**
     * Public setter that sets the varaiable contents
     * @param contents contents
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * prints the name of the file + type
     * @return String instance of the class
     */
    @Override
    public String toString() {
        return "Human readable file: " + getName();
    }

    // MARK: Class Methods
    /**
     * converst the contents of the instance class into an OS File
     * with the same contents
     * if no file exists for the given name, a new one is created
     * @param outputFileName the name of the file to put the contents in
     */
    @Override
    public void outputFileContents(String outputFileName) throws Exception {
        if (contents == null || contents.isEmpty()) { 
            throw new Exception("Empty file contents!");
        }

        try {
            File file = new File( outputFileName );
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("an error occoured while creating the file " +
             outputFileName + " " + e.getMessage());
             throw e;
        }

        try (PrintWriter out = new PrintWriter(outputFileName)) {
            out.flush();
            out.println(this.contents);
        out.close();
        } catch (FileNotFoundException error) { 
            System.out.println( "an error occoured when accessing the file " + 
             outputFileName + " " + error.getMessage() );
             throw error;
        };
    }

    /**
     * imports the contents of a file into the instance
     * if no file exists for the given name, an error is throw
     * @param inputFileName the name of the file to import the contents from
     */
    public void inputFileContents(String inputFileName) throws Exception {
        StringBuilder stringBuilder = new StringBuilder(512);
        FileInputStream inputStream = new FileInputStream(inputFileName);

        try {
            Reader r = new InputStreamReader(inputStream, "UTF-8");
            int c = 0;
            while ((c = r.read()) != -1) {
                stringBuilder.append((char) c);
            }

            r.close();

        } catch (IOException e) {
            System.out.println( e.getLocalizedMessage() );
        }

        this.contents = stringBuilder.toString();
    }

    /**
     * checks if two HumanReadableFiles are equal
     * they must be the same type, have true super.equal calls, and equal conte
     * @param obj the object to check equality
     * @return whether the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {

        if ( !(obj instanceof HumanReadableFile) ) { return false; }
        if ( !super.equals(obj) ) { return false; }

        HumanReadableFile humanReadableFile = (HumanReadableFile) obj;

        if (this.contents == null && humanReadableFile.getContents() == null) { 
            return true; 
        } 
        if ( this.contents == null || humanReadableFile.getContents() == null ) 
        {
            return false;
        }

        return this.contents.equals(humanReadableFile.getContents());
    }
}
