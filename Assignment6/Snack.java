// Main Class File:    Assignment6
// File:               Snack.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * Snack is a high-level type of Item
 * it has two subcategories (Sweet, Savory)
 * @author Brian Masse
 */
public class Snack extends Item {
    // MARK: Vars
    private int servingSize;
    private String texture;
    private static final String HIGH_LEVEL_TYPE = "Snack";
    private static final String TYPE = "Untyped Snack";

    /**
     * blank initialization
     */
    // MARK: Init
    public Snack() {
        super("Unnamed Snack", 0.0, 0);
        this.servingSize = 0;
        this.texture = "";
    }

    /**
     * initializes a snack with a name, price, calorieCount,servingSize,texture
     * invokes the super constructor (Item)
     * @param name: the name of the snack
     * @param price: the price of the snack
     * @param calories: the calories of the snack
     * @param servingSize: the servingSize of the snack
     * @param texture: the texture of the snack
     */
    public Snack(String name, double price, int calories, 
            int servingSize, String texture) {
        super( name, price, calories );
        this.servingSize = servingSize;
        this.texture = texture;
    }

    // MARK: Getter Methods
    /**
     * @return the serving size of the snack
     */
    public int getServingSize() {
        return this.servingSize;
    }

    /**
     * @return the texture of the snack
     */
    public String getTexture() {
        return this.texture;
    }

    /**
     * Gets the type of snack
     * always returns untyped
     * @return the subtype of the Snack class
     */
    @Override
    public String getType() {
        return Snack.TYPE;
    }

    /**
     * Gets the high level type of Item the Snack class represernts
     * wil alaways return Snack
     * @return the high-level type of Item
     */
    @Override
    public String getHighLevelType() {
        return Snack.HIGH_LEVEL_TYPE;
    }

    // MARK: Methods
    /**
     * checks whether a snack and an object are equal
     * the object should be of Snack type
     * checks if the name, price, calories, servingSize, texture of 
     * the items match
     * @return whether the two items equal
     */
    @Override
    public boolean equals(Object object) {
        boolean baseEquals = super.equals(object);

        Snack snack = (Snack) object;
        boolean sizeEquals = this.servingSize == snack.getServingSize();
        boolean textureEquals = this.texture.equals( snack.getTexture() );

        return ( baseEquals && sizeEquals && textureEquals );
    }

    /**
     * converts the snack into a string representing its properties
     * overrides the Object implementation
     * @return string represerntation
     */
    @Override
    public String toString() {
        return "Snack (" + getName() + ") servingSize: " + 
            getServingSize() + "; texture: " + getTexture();
    }
}


