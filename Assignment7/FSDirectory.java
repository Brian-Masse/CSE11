import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

// Main Class File:    Assignment7
// File:               FSDirector.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * FSDirector represents a directory
 * it stores a collection of FSCompnents
 * represnting the other directories / files in the dir
 * @author Brian Masse
 */
public abstract class FSDirectory extends FSComponent {

    // MARK: Initialization
    private ArrayList<FSComponent> componentList;

    /**
     * No-arg constructor.
     */
    protected FSDirectory() {
        super("FSDirectory");
    }

    /**
     * public constructor
     * @param name: the name of the directory
     * @param componentArray: the components stored in the directory
     */
    protected FSDirectory(String name) {
        super(name);
        this.componentList = new ArrayList<FSComponent>();
    }

    // MARK: Convenience Functions
    /**
     * Checks whether the instance is a file
     * @return always returns false when called on a FSDirectory
     */
    public boolean isFile() {
        return false;
    }

    /**
     * Checks whether the instance is a directory
     * @return always returns true when called on a FSDirectory
     */
    public boolean isDirectory() {
        return true;
    }

    /**
     * Public getter that retrieves instance variable - componentList.
     * @return the componentList instance variable
     */
    public ArrayList<FSComponent> getComponentList() {
        return this.componentList;
    }

    /**
     * Public setter that mutate instance variable - componentList.
     * @param componentList the new componentList variable to be assigned
     */
    public void setComponentList(ArrayList<FSComponent> componentList) {
        this.componentList = componentList;
    }

    // MARK: Class Methods
    /**
     * Add a component to the end of the componentList.
     * @param newComp the new component to be appended
     */
    public void appendComponent(FSComponent newComp) {
        this.componentList.add(newComp);
        newComp.setParentDir(this);
    }

    /**
     * Add a component to the directory
     * if it is a file, the name must be unique among other files
     * if it is a directory, the name must be unique among other directories
     * @param newComp the new component to be appended
     */
    public boolean addComponent(FSComponent newComp) {
        if (newComp.isFile()) {
            for ( FSComponent comp: this.componentList ) {
                if (comp.isFile()) {
                    if (comp.getName().equals(newComp.getName())) {
                        return false;
                    }
                }
            }
        } else if ( newComp.isDirectory() ) {
            for ( FSComponent comp: this.componentList ) {
                if (comp.isDirectory()) {
                    if ( comp.getName().equals(newComp.getName()) ) {
                        return false;
                    }
                }
            }
        }

        this.appendComponent(newComp);
        return true;
    }

    /**
     * converst the contents of the instance class into an OS File
     * with a list of all the directories + files in this dir
     * if no file exists for the given name, a new one is created
     * if a file alread exists, its contents are overriden
     * @param outputFileName the name of the file to put the contents in
     */
    public void outputComponentNames(String outputFileName) throws Exception {
        if (componentList == null || componentList.size() == 0) { throw new Exception("Empty file contents!");}

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
            for ( FSComponent comp: componentList ) {
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
     * checks if two directories are equal
     * they must be the same type, have true super.equal calls
     * and their components must deeply be equal
     * @param obj the object to check equality
     * @return whether the two objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof FSDirectory) ) { return false; }
        if ( !super.equals(obj) ) { return false; }

        FSDirectory directory = (FSDirectory) obj;
        if ( !Arrays.deepEquals(this.componentList.toArray(), directory.componentList.toArray()) ) { return false; }
        return true;
    }
}
