import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

// Main Class File:    Assignment7
// File:               ArchiveFile.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * ArchiveFile is a file representing an archive directory
 * it stores those archives in a componentArray
 * these archived directories and files cannot be mutated
 * implements FSFile
 * @author Brian Masse
 */
public class ArchiveFile extends FSFile {
    // MARK: Initializers
    private FSComponent[] componentArray;

    /**
     * No-arg constructor.
     */
    public ArchiveFile() {
        super();
    }

    /**
     * public constructor
     * @param name: the name of the file
     * @param componentArray: the archived components stored in this file
     */
    public ArchiveFile(String name, FSComponent[] componentArray) {
        super();

        String extension = ".zip";
        String completeName = name.endsWith(extension) ? name : name + 
        extension;

        this.setName(completeName);
        this.componentArray = componentArray.clone();
    }

    // MARK: Convenience Function
    /**
     * Public getter that retrieves instance variable - componentArray
     * @return instance variable - componentArray
     */
    public FSComponent[] getComponents() {
        return this.componentArray;
    }

    /**
     * prints the name of the file + type
     * @return String instance of the class
     */
    @Override
    public String toString() {
        return "Archive file: " + getName();
    }

    // MARK: Class Methods
    /**
     * converst the contents of the instance class into an OS File
     * with a list of all the archived directories + files
     * if no file exists for the given name, a new one is created
     * if a file alread exists, its contents are overriden
     * @param outputFileName the name of the file to put the contents in
     */
    @Override
    public void outputFileContents(String outputFileName) throws Exception {
        if (componentArray == null || componentArray.length == 0) { 
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
            for (FSComponent comp: this.componentArray) {
                out.println(comp.getName());
            }
        out.close();
        } catch (FileNotFoundException error) { 
            System.out.println( "an error occoured when accessing the file " + 
             outputFileName + " " + error.getMessage() );
             throw error;
        };
    }

    /**
     * checks if two ArchiveFiles are equal
     * they must be the same type, have true super.equal calls
     * and their components must deeply be equal
     * @param obj the object to check equality
     * @return whether the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) { return false; }
        if ( !( obj instanceof ArchiveFile ) ) { return false; }

        ArchiveFile archiveFile = (ArchiveFile) obj;

        if ( (this.componentArray == null &&
            archiveFile.getComponents() == null) ) { return true; } 

        if ( (this.componentArray == null || 
             archiveFile.getComponents() == null) ) { return false; }

        if ( (this.componentArray.length != 
                archiveFile.getComponents().length ) ) {return false;}

        for ( int i = 0; i < this.componentArray.length; i++ ) {
            String name1 = componentArray[i].getName();
            String name2 = archiveFile.componentArray[i].getName();
            if (!name1.equals(name2)) { return false; }
        }
        return true;
    }
}
