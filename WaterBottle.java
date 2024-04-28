import java.util.InputMismatchException;
import java.util.Scanner;

public class WaterBottle extends GameItem {
    // Constructor that uses the superclass constructor to set the name of the WaterBottle
    public WaterBottle(String name) {
        super(name);
    }

    // Override the use method from GameItem to provide specific functionality for WaterBottle
    @Override
    public void use() {
        Scanner scanner = new Scanner(System.in); // Create a new Scanner object for local use
        System.out.println("You have " + getName() + ".");
        System.out.println("1. Drink it\n2. Throw it away");
        System.out.print("What will you do? ");
        int choice = safeReadInt(scanner); // Use a method to safely read the user's choice

        switch (choice) {
            case 1:
                drink(scanner);
                break;
            case 2:
                throwAway();
                break;
            default:
                System.out.println("That's not a valid option. Let's try this again.");
                use(); // Recursively call use to handle the choice again
                break;
        }
    }

    // Method to handle the drinking action
    private void drink(Scanner scanner) {
        System.out.println("You decide to drink the water from " + getName() + ".");
        System.out.println("Oh no! The water was poisoned. You die.");
        System.exit(0); // Ends the game
    }

    // Method to handle the action of throwing the water bottle away
    private void throwAway() {
        System.out.println("You throw the " + getName() + " away. It's gone forever now.");
    }

    // Static method to safely read an integer from the user input
    public static int safeReadInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That's not a valid number. Please enter a number.");
                scanner.next(); // Clear the invalid input before trying again
            }
        }
    }
}