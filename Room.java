import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
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
    private HashMap<String, Room> exits;
    private Item item;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getDescription() {
        String itemDescription = "";
        if (item != null) {
            itemDescription = "\nThere is a " + item.getDescription() + " here.";
        }
        return description + itemDescription;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}




