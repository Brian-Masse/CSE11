// Main Class File:    Assignment7
// File:               FSFile.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * FSFile is the abstract representation of all files in this system
 * it extends the FSComponent class
 * All files contain a parentDir and a name
 * @author Brian Masse
 */

public abstract class FSFile extends FSComponent  {

    private FSDirectory parentDir;

    // MARK: initialization
    /**
     * No-arg constructor.
     */
    protected FSFile() {
        super("FSFile");
    }

    /**
     * Protected constructor
     * @param name: the name of the file componen
     */
    protected FSFile(String name) {
        super(name);
    }

    // MARK: Convenience Functions
    /**
     * Checks whether the instance is a file
     * @return always returns true when called on a NSFIle
     */
    public boolean isFile() {
        return true;
    }

    /**
     * Checks whether the instance is a directory
     * @return always returns false when called on a NSFIle
     */
    public boolean isDirectory() {
        return false;
    }

    /**
     * Public getter that retrieves instance variable - parentDir
     * @return instance variable - parentDir
     */
    public FSDirectory getParentDir() {
        return this.parentDir;
    }

    /**
     * Public setter that mutates instance variable - parentDir
     * @param parentDir instance variable - parentDir
     */
    public void setParentDir(FSDirectory parentDir) {
        this.parentDir = parentDir;
    }

    /**
     * Checks whether two instances of an NSFile are equal
     * checks that they have the same type, their super classe's equal, and the
     * parent directories are the same name
     * @return whether the two files equal
     */
    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof FSFile) ) { return false; }
        if ( !super.equals(obj) ) { return false; }

        FSFile fileObj = (FSFile) obj;

        if (this.parentDir == null && fileObj.getParentDir() == null) { return true; } 
        if ( this.parentDir == null || fileObj.getParentDir() == null ) {
            return false;
        }

        return this.parentDir.equals(fileObj.getParentDir());
    }

    /**
     * Abstract definition of a method that outputs the contents of a file
     * implemented in concrete subclasses
     */
    public abstract void outputFileContents(String outputFileName)
     throws Exception;

}
