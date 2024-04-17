import java.util.ArrayList;
import java.util.List;

class Inventory {
    private List<Object> items = new ArrayList<>();

    public Inventory() {
        // Pre-populate the inventory with all items in the cage
        items.add(new Book("A Tale of Two Cities"));
        items.add(new WaterBottle("Plastic Water Bottle"));
        items.add(new Pen("Blue Pen"));
        items.add(new Vase("Ancient Vase"));
        items.add(new MiniChair("Wooden Mini Chair"));
        items.add(new CoffeeCup("Cup of Coffee"));
    }

    // Show all items in the inventory
    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("The inventory is empty.");
        } else {
            System.out.println("Inventory contains:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i).getClass().getSimpleName());
            }
        }
    }

    // Get an item by index
    public Object getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null; // Return null if the index is out of bounds
    }

    // Get the size of the inventory
    public int size() {
        return items.size();
    }
}