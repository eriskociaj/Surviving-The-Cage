import java.util.Scanner;

// CurrentItem class extending GameItem to inherit its properties and methods
public class CurrentItem extends GameItem {
    // Constructor that calls the superclass constructor
    public CurrentItem(String name) {
        super(name); // Pass the name to the GameItem constructor
    }

    // Implement the use method from the GameItem class
    @Override
    public void use() {
        // Example use case for the current item
        System.out.println("Using " + getName() + "...");
    }

    // Static method to safely read an integer from the user input
    public static int safeReadInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt(); // Attempt to read an integer
            } catch (java.util.InputMismatchException e) {
                scanner.next(); // Consume the invalid input
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public void interact(Scanner scanner) {
        System.out.println("You have selected " + getName() + ".");
        System.out.println("1. Use this item\n2. Ignore");
        System.out.print("Enter your choice: ");
        int choice = safeReadInt(scanner); // Use the safeReadInt method to read the user's choice

        switch (choice) {
            case 1:
                use(); // Use the item
                break;
            case 2:
                System.out.println(getName() + " is ignored... Move on.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                interact(scanner); // Recursively call interact to handle the choice again
                break;
        }
    }
}