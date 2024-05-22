// Main Class File:    Assignment6
// File:               Sweet.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * Sweet is a type of Snack
 * It has no more subcategorizations
 * @author Brian Masse
 */
public class Sweet extends Snack {
    private int sweetnessLevel;
    private static final String TYPE = "Sweet";

    /**
     * blank initialization
     */
    public Sweet() {
        super("Unnamed Sweet", 0.0, 0, 0, "");
        this.sweetnessLevel = 0; 
    }

    /**
     * initializes a sweet snack with a name, price, calorieCount,
     * servingSize, texture, and sweetness level 
     * invokes the super constructors (Item, Snack)
     * @param name: the name of the snack
     * @param price: the price of the snack
     * @param calories: the calories of the snack
     * @param servingSize: the servingSize of the snack
     * @param texture: the texture of the snack
     * @param sweetnessLevel: the sweetness level of the snack
     */
    public Sweet(String name, double price, int calories, 
            int servingSize, String texture, int sweetnessLevel) {
        super( name, price, calories, servingSize, texture );
        this.sweetnessLevel = sweetnessLevel;
    }

    // MARK: Getter Methods
    /**
     * @return the sweetnessLevel of the snack
     */
    @Override
    public int getSweetnessLevel() {
        return this.sweetnessLevel;
    }

    /**
     * Gets the type of snack
     * (will always return Sweet)
     * @return the subtype of the Snack class
     */
    @Override
    public String getType() {
        return Sweet.TYPE;
    }

    // MARK: Methods
    /**
     * checks whether a sweet snack and an object are equal
     * the object should be of Sweet type
     * checks if the name, price, calories, servingSize, texture, and sweetness
     * of the items match
     * @return whether the two items equal
     */
    @Override
    public boolean equals(Object object) {
        boolean baseEquals = super.equals(object);

        Sweet sweet = (Sweet) object;
        boolean sweetnessEquals = this.sweetnessLevel == sweet.getSweetnessLevel();
        return ( baseEquals && sweetnessEquals );
    }

    /**
     * converts the snack into a string representing its properties
     * overrides the Object implementation
     * @return string represerntation
     */
    @Override
    public String toString() {
        return "Sweet (" + getName() + ") sweetnessLevel: " + 
            getSweetnessLevel();
    }
}