// Main Class File:    Assignment6
// File:               Savory.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * Savory is a type of Snack
 * It has no more subcategorizations
 * @author Brian Masse
 */
public class Savory extends Snack {
    private int savorinessLevel;
    private static final String TYPE = "Savory";

    /**
     * blank initialization
     */
    public Savory() {
        super("Unnamed Savory", 0.0, 0, 0, "");
        this.savorinessLevel = 0; 
    }

    /**
     * initializes a savory snack with a name, price, calorieCount,
     * servingSize, texture, and savoriness level 
     * invokes the super constructors (Item, Snack)
     * @param name: the name of the snack
     * @param price: the price of the snack
     * @param calories: the calories of the snack
     * @param servingSize: the servingSize of the snack
     * @param texture: the texture of the snack
     * @param savorinessLevel: the savoriness level of the snack
     */
    public Savory(String name, double price, int calories, 
            int servingSize, String texture, int savorinessLevel) {
        super( name, price, calories, servingSize, texture );
        this.savorinessLevel = savorinessLevel;
    }

    // MARK: Getter Methods
    /**
     * @return the savorinessLevel of the snack
     */
    @Override
    public int getSavorinessLevel() {
        return this.savorinessLevel;
    }

    /**
     * Gets the type of snack
     * (will always return Savory)
     * @return the subtype of the Snack class
     */
    @Override
    public String getType() {
        return Savory.TYPE;
    }

    // MARK: Methods
    /**
     * checks whether a savory snack and an object are equal
     * the object should be of Savory type
     * checks if the name, price, calories, servingSize, texture, and savorines
     * of the items match
     * @return whether the two items equal
     */
    @Override
    public boolean equals(Object object) {
        boolean baseEquals = super.equals(object);

        Savory savory = (Savory) object;
        boolean savoryEquals = this.savorinessLevel == savory.getSavorinessLevel();

        return( baseEquals && savoryEquals );
    }

    /**
     * converts the snack into a string representing its properties
     * overrides the Object implementation
     * @return string represerntation
     */
    @Override
    public String toString() {
        return "Savory (" + getName() + ") savorinessLevel: " + 
        getSavorinessLevel();
    }
}