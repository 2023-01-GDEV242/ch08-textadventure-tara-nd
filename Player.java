import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory;

    public Player() {
        inventory = new ArrayList<>();
    }

    public boolean addItem(Item item) {
        if (inventory.size() < 10) {
            inventory.add(item);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeItem(Item item) {
        return inventory.remove(item);
    }

    public boolean hasItem(Item item) {
        return inventory.contains(item);
    }

    public void printInventory() {
        if (inventory.size() > 0) {
            System.out.println("You are carrying:");
            for (Item item : inventory) {
                System.out.println("- " + item.getDescription());
            }
        } else {
            System.out.println("You are not carrying anything.");
        }
    }
}

