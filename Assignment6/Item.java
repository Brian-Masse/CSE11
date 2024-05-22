// Main Class File:    Assignment6
// File:               Item.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * Item is the parent class of all types of snacks and drinks offered 
 * by the vending machine
 * @author Brian Masse
 */
public class Item {
    // MARK: Vars
    private String name;
    private double price;
    private int calories;
    private static final String HIGH_LEVEL_TYPE = "Untyped High Level Item";
    private static final String TYPE = "Untyped Item";

    /**
     * blank initialization
     */
    public Item() {
        this.name = "Unnamed Item";
        this.price = 0.0;
        this.calories = 0;
    }

    /**
     * initializes an Item with the given name, price, and calories
     * @param name: the name
     * @param price: the price of the itme
     * @param calories: the calories of the item
     */
    public Item(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    // MARK: Getters
    /**
     * @return the name of the item
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the price of the item
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * @return the calories of the item
     */
    public int getCalories() {
        return this.calories;
    }

    /**
     * @return the static TYPE of the Item class
     */
    public String getType() {
        return Item.TYPE;
    }

    /**
     * @return the static HIGH_LEVEL_TYPE of the Item class
     */
    public String getHighLevelType() {
        return Item.HIGH_LEVEL_TYPE;
    }

    // MARK: Setters
    /**
     * sets the price of the item
     * @param name: the new price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * checks whether an item and an object are equal
     * the object should be of Item type
     * checks if the name, price, and calories of the items are the same
     * @return whether the two items equal
     */
    public boolean equals(Object object) {
        Item item = (Item) object;
        boolean namesMatch = this.name.equals(item.getName());
        boolean caloriesmatch = this.calories == item.getCalories();
        boolean priceMatch = this.price == item.getPrice();

        return ( namesMatch && caloriesmatch && priceMatch );
    }


    // MARK: Additional Getters
    /**
     * @return the volume of the item
     */
    public double getVolume() {
        return 0;
    }

    /**
     * @return the flavor of the item
     */
    public String getFlavor() {
        return "";
    }

    /**
     * @return the serving size of the item
     */
    public int getServingSize() {
        return 0;
    }

    /**
     * @return the texture of the item
     */
    public String getTexture() {
        return "";
    }

    /**
     * @return the coolness of the item
     */
    public int getCoolnessLevel() {
        return 0;
    }

    /**
     * @return the boost level of the item
     */
    public int getBoostLevel() {
        return 0;
    }

    /**
     * @return the sweetness level of the item
     */
    public int getSweetnessLevel() {
        return 0;
    }

    /**
     * @return the savoriness of the item 
     */
    public int getSavorinessLevel() {
        return 0;
    }

    /**
     * converts the item into a string representing its property
     * overrides the Object implementation
     * @return string represerntation
     */
    @Override
    public String toString() {
        return "Item (" + getName() + ") type: " + 
            getType() + "; price: " + getPrice() + 
            "; calories: " + getCalories();
    }
}