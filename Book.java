import java.util.InputMismatchException;
import java.util.Scanner;

public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    // Method to handle the interaction when the book is selected in the inventory
    public void interactWithBook(Scanner scanner, Inventory inventory) {
        System.out.println(
                "Oh darn it, look the book is up on the shelf, You must choose another item to reach up there, What are you choosing?");
        inventory.showItems(); // Assuming Inventory class has a method to display items
        int choice = safeNextInt(scanner) - 1; // Assuming safeNextInt is a static method available in the context
        if (choice >= 0 && choice < inventory.size()) {
            Object item = inventory.getItem(choice); // Assuming Inventory class has a method to get an item by index
            if (item instanceof MiniChair) {
                System.out.println("You chose the book, what do you wanna do now with the book?");
                System.out.println("1. Ignore");
                System.out.println("2. Read");
                int action = safeNextInt(scanner);
                if (action == 2) {
                    System.out.println("'Once upon a time..' OMG A KEY. YOU CAN FINALLY ESCAPE NOW!");
                    // Additional logic for handling the discovery of the key
                } else {
                    System.out.println("You ignored the book.");
                }
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
    public String toString() {
        return title;
    }
}