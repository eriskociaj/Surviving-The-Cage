import java.util.InputMismatchException;
import java.util.Scanner;

public class Book extends GameItem {
    public Book(String name) {
        super(name); // Call to the superclass (GameItem) constructor
    }

    @Override
    public void use() {
        if (!GameState.chairUsed) {
            System.out.println("\nYou need to use the Wooden Mini Chair first to reach the Book.");
            return;
        }
        System.out.println("\n'Once upon a time..' OMG A KEY. YOU CAN FINALLY ESCAPE NOW!");
        KeyDiscoveryListener listener = new GameEventHandler();
        listener.onKeyDiscovered(); // This will print the message and end the game
    }

    // Utility method to safely read an integer from the scanner
    public static int safeNextInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next(); // Consume the invalid input
                System.out.println("\nPlease enter a valid integer.");
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}