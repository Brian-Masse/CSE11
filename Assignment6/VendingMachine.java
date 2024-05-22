// Main Class File:    Assignment6
// File:               VendingMachine.Java
// Quarter:            CSE11 SPR 2024
//
// Author:             Brian Masse: bmasse@ucsd.edu
// Instructor's Name:  Ben Ochoa
/**
 * 
 * Vending Machine holds a collection of Items
 * the Items can be of any type
 * it has several helpful methods to compare, access, and modify this list
 * of items
 * @author Brian Masse
 */
import java.util.ArrayList;

public class VendingMachine {
    // MARK: Init
    private ArrayList<Item> itemList;

    /**
     * blank initialization
     * creates an empty array of items
     */
    public VendingMachine() {
        this.itemList = new ArrayList<Item>();
    }

    // MARK: Modifying Methods
    /**
     * adds an individual item to the list of items
     * @param item the item to add the list of items
     */
    public void addToItemList(Item item) {
        this.itemList.add( item );
    }

    /**
     * adds a set of items to the active list of items
     * @param items an array of items to add to the list of items
     */
    public void addToItemList(Item[] items) {
        for ( Item item: items ) {
            this.addToItemList(item);
        }
    }

    /**
     * checks if the active list of items has a speicifc item
     * identified by its name
     * @param itemName the name of the item
     * @return whether the list contains the item
     */
    public boolean hasItem(String itemName) {
        for (Item item: itemList) {
            if ( item.getName().equals(itemName) ) { 
                return true; 
            }
        }
        return false;
    }

    /**
     * retreives an item identified by its name
     * if there are multiple items with the same name
     * the first one is returned
     * if it is not in the array, it reurns null
     * @param itemName the name of the item
     * @return the item from the list
     */
    public Item getItem(String itemName) {
        for ( int i = 0; i < itemList.size(); i++ ) {
            Item item = this.itemList.get(i);
            if ( item.getName().equals(itemName) ) {
                this.itemList.remove(i);
                return item;
            }
        }
        return null;
    }

    // MARK: Size
    /**
     * A helper method to determine the ounces in a given item
     * for drinks this is just the volume, 
     * for snacks it is the servingSize * 12
     * @param item the item to find ounces of
     * @return the number of ounces in the item
     */
    private static double computeSize(Item item) {
        String type = item.getHighLevelType();
        return type.equals("Drink") ? 
                            ((Drink) item).getVolume() :
                            ((Snack) item).getServingSize() * 12;
    }

    /**
     * compares the sizes of two items using the computeSize method
     * returns -1 if the first item is smaller
     * returns 0 if the items are equal in size
     * returns 1 if the second item is larger
     * @param item1 the first item
     * @param item12 the second item
     * @return the encoded representation of comparison
     */
    public static int compareSize(Item item1, Item item2) {
        double ounces1 = computeSize(item1);
        double ounces2 = computeSize(item2);

        if ( ounces1 < ounces2 ) { return - 1; }
        else if ( ounces1 == ounces2 ) { return 0; }
        return 1;
    }

    // MAKR: applyPriceSurge
    /**
     * applys a price surge to a random element in the list
     * does not apply the surge if the value is < 1
     * @param increaseRate the multiplier to surge the item
     * @return the index of the modified item
     */    
    public int applyPriceSurge(double increaseRate) {
        double random = Math.random() * itemList.size();
        int randomIndex = (int) Math.floor(random);

        if (increaseRate < 1) { return randomIndex; }

        Item item = itemList.get(randomIndex);
        double newPrice = item.getPrice() * increaseRate;
        item.setPrice(newPrice);

        return randomIndex;
    }

    // MARK: GetItemsByType
    /**
     * gets all the items in the arary of a specific type
     * uses the subType, not the high_level_type
     * @param type the type to filter the items by
     * @return a filtered array of items
     */
    public Item[] getItemsByType(String type) {
        Item[] filteredItems = new Item[itemList.size()];

        int currentInsertionIndex = 0;

        for (Item item: itemList) {
            if ( item.getType().equals(type) ) {
                filteredItems[currentInsertionIndex] = item;
                currentInsertionIndex++;
            }
        } 

        return filteredItems;
    } 

    /**
     * convenience function to get the itemLists
     * @return the itemList
     */
    public ArrayList<Item> getItemList() {
        return this.itemList;
    }
}