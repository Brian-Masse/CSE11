// Main Class File:    Assignment7
// File:               FSComponent.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * FSComponent is the abstract representation of all file components
 * both the director and file calsses inheret from it
 * @author Brian Masse
 */
public abstract class FSComponent {
    private String name;

    // MARK: Initializers
    /**
     * No-arg constructor.
     */
    protected FSComponent() {}

    /**
     * Public constructor that takes in a String.
     * @param name the name of the FSComponent
     */
    protected FSComponent(String name) {
        this.name = name;
    }

    /**
     * Public getter that retrieves instance variable - name
     * @return instance variable - name
     */
    public String getName() {
        return name;
    }

    // MARK: Convenience Functions
    /**
     * Public setter that mutates instance variable - name
     * DO NOT CHANGE!
     * @param name instance variable - name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FSComponent) {
            return ((FSComponent) obj).getName().equals(this.getName());
        }
        return false;
    }

    /* The following four abstract methods need
     * to be implemented by its subclasses. */
    public abstract void setParentDir(FSDirectory dir);
    public abstract boolean isFile();
    public abstract boolean isDirectory();
}
