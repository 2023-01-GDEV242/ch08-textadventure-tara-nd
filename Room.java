import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  For each existing exit, the room
 * stores a reference to the neighboring room.
 *
 * A "Room" can also contain an item, which can be picked up by the player.
 * An item has a description and a weight.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room {
    private String description;
    private HashMap<String, Room> exits; // stores exits of this room.
    private Item item;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        item = null;
    }

    /**
     * Define an exit from this room.
     *
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * Set an item in this room.
     *
     * @param item The item to be set in the room.
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Get the item in this room.
     *
     * @return The item in the room, or null if there is no item.
     */
    public Item getItem() {
        return item;
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Return a description of the room in the form:
     * You are in the kitchen.
     * Exits: north west
     * Item: a table
     *
     * @return A long description of this room
     */
    public String getLongDescription() {
        String longDescription = "You are " + description + ".\n" + getExitString();

        if (item != null) {
            longDescription += "\nItem: " + item.getDescription();
        }

        return longDescription;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     *
     * @return Details of the room's exits.
     */
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     *
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }
}


