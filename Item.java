
/**
 * Represents item in a room
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Item {
    private String description; // description of the item
    private double weight; // weight of the item

    /**
     * Creates a new item with the specified description and weight.
     * 
     * @param description the description of the item
     * @param weight      the weight of the item
     */
    public Item(String description, double weight) {
        this.description = description;
        this.weight = weight;
    }

    /**
     * Gets the description of the item.
     * 
     * @return the description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the weight of the item.
     * 
     * @return the weight of the item
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the description of the item.
     * 
     * @param description the new description of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the weight of the item.
     * 
     * @param weight the new weight of the item
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Returns a string representation of the item (just the description).
     * 
     * @return a string representation of the item
     */
    public String toString() {
        return description;
    }
}

