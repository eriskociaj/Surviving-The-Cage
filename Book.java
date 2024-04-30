import java.util.InputMismatchException;
import java.util.Scanner;

// This line defines a class named Book that inherits from GameItem, making Book a specialized version of GameItem.
public class Book extends GameItem {
    // Constructor that takes a book name and passes it to the GameItem superclass
    public Book(String name) {
        super(name); // Call to the superclass (GameItem) constructor to set the item's name
    }

    // Override the use method to define how the Book item is used within the game
    @Override
    public void use() {
        // Check if the Wooden Mini Chair has been used before allowing the book to be used
        if (!GameState.chairUsed) {
            System.out.println("\nYou need to use the Wooden Mini Chair first to reach the Book.");
            return; // Exit the method if the chair hasn't been used
        }
        // If the chair has been used, reveal a key discovery event
        System.out.println("\n'Once upon a time..' OMG A KEY. YOU CAN FINALLY ESCAPE NOW!");
        KeyDiscoveryListener listener = new GameEventHandler(); // Create an event handler for key discovery
        listener.onKeyDiscovered(); // Trigger the key discovery event which ends the game
    }

    // Utility method to safely read an integer from the scanner, handling InputMismatchException
    public static int safeNextInt(Scanner scanner) {
        while (true) { // Infinite loop to keep trying until a valid integer is entered
            try {
                return scanner.nextInt(); // Attempt to read an integer from the scanner
            } catch (InputMismatchException e) {
                scanner.next(); // Consume the invalid input to clear the scanner
                System.out.println("\nPlease enter a valid integer."); // Prompt the user to enter a valid integer
            }
        }
    }

    // Override the toString method to return the name of the book
    @Override
    public String toString() {
        return name; // Return the name of the book
    }
}