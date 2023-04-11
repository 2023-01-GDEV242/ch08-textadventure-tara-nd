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
    private ArrayList<Item> items;
    private Room trapdoorRoom; // the room on the other side of the trap door
    private boolean trapdoorLocked; // whether the trap door is locked or not
    
    // constructor
    public Room() {
        trapdoorRoom = null;
        trapdoorLocked = false;
    }
    
    // sets the room on the other side of the trap door
    public void setTrapdoorRoom(Room trapdoorRoom) {
        this.trapdoorRoom = trapdoorRoom;
    }
    
    // locks the trap door
    public void lockTrapdoor() {
        trapdoorLocked = true;
    }
    
    // unlocks the trap door
    public void unlockTrapdoor() {
        trapdoorLocked = false;
    }
    
    // returns the room on the other side of the trap door
    public Room getTrapdoorRoom() {
        return trapdoorRoom;
    }
    
    // checks if the trap door is locked
    public boolean isTrapdoorLocked() {
        return trapdoorLocked;
    }

    public Room(String description) {
        this.description = description;
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String getItemsString() {
        String itemsString = "Items:";
        for (Item item : items) {
            itemsString += " " + item.getDescription();
        }
        return itemsString;
    }
}





