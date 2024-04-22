import java.util.InputMismatchException;
import java.util.Scanner;

// Assuming Book is intended to be a usable game item
public class Book extends GameItem {
    public Book(String name) {
        super(name); // Call to the superclass (GameItem) constructor
    }

    // Method to handle the interaction when the book is selected in the inventory
    public void interactWithBook(Scanner scanner, Inventory inventory) {
        System.out.println(
                "Oh darn it, look the book is up on the shelf, You must choose another item to reach up there, What are you choosing?");
        inventory.showItems();
        int choice = safeNextInt(scanner) - 1;
        if (choice >= 0 && choice < inventory.size()) {
            Object item = inventory.getItem(choice);
            if (item instanceof MiniChair) {
                CurrentItem currentItem = new CurrentItem("Book");
                currentItem.interact(scanner); // Delegate interaction to CurrentItem
            } else {
                System.out.println("That item won't help you reach the book. Try again.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Utility method to safely read an integer from the scanner
    private static int safeNextInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next(); // Consume the invalid input
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    @Override
    public void use() {
        // Implementation of the use method specific to Book
        System.out.println("'Once upon a time..' OMG A KEY. YOU CAN FINALLY ESCAPE NOW!");
        KeyDiscoveryListener listener = new GameEventHandler();
        listener.onKeyDiscovered(); // This will print the message and end the game
    }

    @Override
    public String toString() {
        return name;
    }
}