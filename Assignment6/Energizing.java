// Main Class File:    Assignment6
// File:               Energizing.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * Energizing is a type of Drink
 * It has no more subcategorizations
 * @author Brian Masse
 */
public class Energizing extends Drink {
    // MARK: Vars
    private int boostLevel;
    private static final String TYPE = "Energizing";

    /**
     * blank initialization
     */
    // MARK: Init
    public Energizing() {
        super("Unnamed Energizing", 0.0, 0, 0.0, "");
        this.boostLevel = 0; 
    }

    /**
     * initializes an energizing drink with a name, price, calorieCount,
     *  volume, flavor, and boost level
     * invokes the super constructors (Item, Drink)
     * @param name: the refreshing drink
     * @param price: the price of the drink
     * @param calories: the calories of the drink
     * @param volume: the volume of the drink
     * @param flavor: the flavor of the drink
     * @param boostLevel: the boostLevel of the drink
     */
    public Energizing(String name, double price, int calories, 
            double volume, String flavor, int boostLevel) {
        super( name, price, calories, volume, flavor );
        this.boostLevel = boostLevel;
    }

    // MARK: Getter Methods
    /**
     * @return the boostLevel of the drink
     */
    @Override
    public int getBoostLevel() {
        return this.boostLevel;
    }

    /**
     * Gets the type of drink
     * (will always return Energizing)
     * @return the subtype of the Drink class
     */
    @Override
    public String getType() {
        return Energizing.TYPE;
    }

    // MARK: Methods
    /**
     * checks whether an energizing drink and an object are equal
     * the object should be of Energizing type
     * checks if the name, price, calories, volume, flavor, and boost
     * of the items match
     * @return whether the two items equal
     */
    @Override
    public boolean equals(Object object) {
        boolean baseEquals = super.equals( object );

        Energizing energizing = (Energizing) object;
        boolean boostEquals = this.boostLevel == energizing.boostLevel;

        return ( boostEquals && baseEquals );
    }

    /**
     * converts the drink into a string representing its property
     * overrides the Object implementation
     * @return string represerntation
     */
    @Override
    public String toString() {
        return "Energizing (" + getName() + ") boostLevel: " + 
            getBoostLevel();
    }
}