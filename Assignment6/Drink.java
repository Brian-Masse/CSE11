// Main Class File:    Assignment6
// File:               Drink.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * Drink is a high-level type of Item
 * it has two subcategories (Refreshing, Energizing)
 * @author Brian Masse
 */
public class Drink extends Item {
    // MARK: vars
    private double volume;
    private String flavor;
    private static final String HIGH_LEVEL_TYPE = "Drink";
    private static final String TYPE = "Untyped Drink";

    /**
     * blank initialization
     */
    public Drink() {
        super("Unnamed Drink", 0.0, 0);
        this.volume = 0;
        this.flavor = "";
    }

    /**
     * initializes a drink with a name, price, calorieCount, volume, flavor
     * invokes the super constructor (Item)
     * @param name: the drink
     * @param price: the price of the drink
     * @param calories: the calories of the drink
     * @param volume: the volume of the drink
     * @param flavor: the flavor of the drink
     */
    public Drink(String name, double price, int calories, 
            double volume, String flavor) {
        super( name, price, calories );
        this.volume = volume;
        this.flavor = flavor;
    }

    // MARK: Getter Methods
    /**
     * @return the volume of the drink
     */
    public double getVolume() {
        return this.volume;
    }

    /**
     * @return the flavor of the drink
     */
    public String getFlavor() {
        return this.flavor;
    }

    /**
     * Gets the type of drink
     * (will always return untyped)
     * @return the subtype of the Drink class
     */
    @Override
    public String getType() {
        return Drink.TYPE;
    }

    /**
     * Gets the high level type of Item the Drink class represernts
     * wil alaways return drink
     * @return the high-level type of Item
     */
    @Override
    public String getHighLevelType() {
        return Drink.HIGH_LEVEL_TYPE;
    }

    // MARK: Methods
/**
     * checks whether a drink and an object are equal
     * the object should be of Drink type
     * checks if the name, price, calories, volume, flavor of the items match
     * @return whether the two items equal
     */
    @Override
    public boolean equals(Object object) {
        boolean baseEquals = super.equals(object);

        Drink drink = (Drink) object;
        boolean volumeEquals = this.volume == drink.getVolume();
        boolean flavorEquals = this.flavor.equals(drink.getFlavor());
        return ( baseEquals && volumeEquals && flavorEquals );
    }

    /**
     * converts the drink into a string representing its property
     * overrides the Object implementation
     * @return string represerntation
     */
    @Override
    public String toString() {
        return "Drink (" + getName() + ") volume: " + 
            getVolume() + "; flavor: " + getFlavor();
    }
}


