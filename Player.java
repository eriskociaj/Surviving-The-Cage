import java.util.ArrayList;
import java.util.List;



// Interface for items that can be used by the player
interface Usable {
    void use();
}

// Abstract class representing a generic game item
abstract class GameItem implements Usable {
    protected String name;

    public GameItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method to be implemented by all items
    @Override
    public abstract void use();
}

// Player class encapsulating player attributes and behaviors
public class Player {
    private String name;
    private List<GameItem> inventory; // Using polymorphism for inventory items

    public Player(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

// Method to add an item to the inventory
public void addToInventory(GameItem item) {
    inventory.add(item);
}
    // Show the items in the player's inventory
    public void showInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i).getName());
        }
    }

    // Use an item from the inventory based on the player's choice
    public void useItem(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= inventory.size()) {
            System.out.println("Invalid item choice.");
            return;
        }
        GameItem item = inventory.get(itemIndex);
        item.use(); // Polymorphic call to use the item
    }

    // Method to safely remove an item from the inventory (demonstrates stability)
    public boolean removeFromInventory(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= inventory.size()) {
            System.out.println("Invalid item index. No item removed.");
            return false;
        }
        GameItem removedItem = inventory.remove(itemIndex);
        System.out.println(removedItem.getName() + " has been removed from your inventory.");
        return true;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Inventory size method for external checks
    public int inventorySize() {
        return inventory.size();
    }
}