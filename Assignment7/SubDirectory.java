// Main Class File:    Assignment7
// File:               SubDirectory.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * SubDirectory is a type of FSDirectory
 * it stores those archives in a componentArray
 * these archived directories and files cannot be mutated
 * it also has a parent directory
 * @author Brian Masse
 */
public class SubDirectory extends FSDirectory {
    // MARK: Initialization
    private FSDirectory parentDir;

    /**
     * No-arg constructor.
     */
    public SubDirectory() {
        super();
    }

    /**
     * public constructor
     * @param name: the name of the directory
     */
    public SubDirectory(String name) {
        super(name);
    }

    // MARK: Convenience Functions
    /**
     * Public setter that sets the instance variable - parentDir
     * @param parentDir new parentDir
     */
    @Override
    public void setParentDir( FSDirectory parentDir ) {
        this.parentDir = parentDir;
    }

    /**
     * Public getter that retrieves instance variable - parentDir
     * @return instance variable - parentDir
     */
    public FSDirectory getParentDir() {
        return this.parentDir;
    }

    /**
     * prints the name of the file + type
     * @return String instance of the class
     */
    @Override
    public String toString() {
        return "Sub directory: " + getName();
    }

    /**
     * checks if two subDirectories are equal
     * they must be the same type, have true super.equal calls
     * and their components must deeply be equal
     * @param obj the object to check equality
     * @return whether the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof SubDirectory) ) { return false; }
        if ( !super.equals(obj) ) { return false; }

        SubDirectory subDirectory = (SubDirectory) obj;

        if (this.parentDir == null && subDirectory.getParentDir() == null) { 
            return true; 
        } 
        if ( this.parentDir == null || subDirectory.getParentDir() == null ) {
            return false;
        }

        return this.parentDir.equals(subDirectory.getParentDir());
    }
}
