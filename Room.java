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

import java.util.ArrayList;

public class Room {
    private String description;
    private ArrayList<Item> items;
    private Room[] exits;

    public Room(String description) {
        this.description = description;
        this.items = new ArrayList<Item>();
        this.exits = new Room[6];
    }

    public void setExit(String direction, Room neighbor) {
        int index = directionToIndex(direction);
        exits[index] = neighbor;
    }

    public String getDescription() {
        String itemString = "";
        if (items.size() > 0) {
            itemString = " Items in the room:";
            for (Item item : items) {
                itemString += " " + item.getDescription();
            }
        }
        return description + itemString;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Room getExit(String direction) {
        int index = directionToIndex(direction);
        return exits[index];
    }

    private int directionToIndex(String direction) {
        switch (direction.toLowerCase()) {
            case "north":
                return 0;
            case "east":
                return 1;
            case "south":
                return 2;
            case "west":
                return 3;
            case "up":
                return 4;
            case "down":
                return 5;
            default:
                return -1;
        }
    }
}



