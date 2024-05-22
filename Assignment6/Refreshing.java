// Main Class File:    Assignment6
// File:               Refreshing.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * Refreshing is a type of Drink
 * It has no more subcategorizations
 * @author Brian Masse
 */
public class Refreshing extends Drink {
    // MARK: Vars
    private int coolnessLevel;
    private static final String TYPE = "Refreshing";

    /**
     * blank initialization
     */
    // MARK: Init
    public Refreshing() {
        super("Unnamed Refreshing", 0.0, 0, 0.0, "");
        this.coolnessLevel = 0; 
    }

    /**
     * initializes a refreshing drink with a name, price, calorieCount,
     *  volume, flavor, and coolness level
     * invokes the super constructors (Item, Drink)
     * @param name: the refreshing drink
     * @param price: the price of the drink
     * @param calories: the calories of the drink
     * @param volume: the volume of the drink
     * @param flavor: the flavor of the drink
     * @param coolnessLevel: the coolnessLevel of the drink
     */
    public Refreshing(String name, double price, int calories, 
            double volume, String flavor, int coolnessLevel) {
        super( name, price, calories, volume, flavor );
        this.coolnessLevel = coolnessLevel;
    }

    // MARK: Getter Methods
    /**
     * @return the coolness level of the drink
     */
    @Override
    public int getCoolnessLevel() {
        return this.coolnessLevel;
    }

    /**
     * Gets the type of drink
     * (will always return Refreshing)
     * @return the subtype of the Drink class
     */
    @Override
    public String getType() {
        return Refreshing.TYPE;
    }

    // MARK: Methods
    /**
     * checks whether a refreshing drink and an object are equal
     * the object should be of Refreshing type
     * checks if the name, price, calories, volume, flavor, and coolness
     * of the items match
     * @return whether the two items equal
     */
    @Override
    public boolean equals(Object object) {
        boolean baseEquals = super.equals(object);

        Refreshing refreshing = (Refreshing) object;
        boolean coolnessEquals = refreshing.getCoolnessLevel() == this.coolnessLevel;
        return ( baseEquals && coolnessEquals );
    }

    /**
     * converts the drink into a string representing its property
     * overrides the Object implementation
     * @return string represerntation
     */
    @Override
    public String toString() {
        return "Refreshing (" + getName() + ") coolnessLevel: " + 
        getCoolnessLevel();
    }
}