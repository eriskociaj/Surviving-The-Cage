
import java.util.Scanner;

public class Vase extends GameItem {

    // Initialize a boolean variable to track if the vase is broken or not
    private boolean isBroken = false;

   // Constructor to initialize the Vase with a name
public Vase(String name) {
    super(name); // Calls the constructor of the superclass (GameItem) to set the name of the Vase
}

// Overrides the use method from GameItem to provide specific functionality when the Vase is used
@Override
public void use() {
    // Check if the player has used the Wooden Mini Chair before interacting with the Vase
    if (!GameState.chairUsed) {
        System.out.println("\nYou need to use the Wooden Mini Chair first to reach the Vase.");
        return; // Exit the method if the condition is not met
    }

    Scanner scanner = new Scanner(System.in); // Creates a new Scanner object for reading user input

    // Check if the vase is already broken
    if (isBroken) {
        System.out.println("\nThe vase is already broken.");
        return; // Exit the method to prevent further interaction with a broken vase
    }

    // Interaction options with the Vase
    System.out.println("\nYou have the magical " + getName() + ". \nDo you want to 1. Look inside it \n2. Throw it? \nChoose an option (1 or 2):");
    int choice = safeReadInt(scanner); // Safely read the player's choice

    // Execute actions based on the player's choice
    switch (choice) {
        case 1: // Option to look inside the Vase
            lookInside();
            break;
        case 2: // Option to throw the Vase
            throwVase();
            break;
        default: // Handle invalid choices
            System.out.println("\nThat's not a valid option. The vase remains untouched.");
            break;
    }
    // Note: The scanner is not closed here to avoid closing System.in
}

// Method to simulate looking inside the Vase
private void lookInside() {
    System.out.println("\nAs you look inside the vase, a spider jumps out and bites you. You feel dizzy...");
    System.out.println("Oh no! The spider was poisonous. \nYou are dead :(..");
    System.exit(0); // Ends the game
}

// Method to simulate throwing the Vase
private void throwVase() {
    System.out.println("\nYou throw the vase with all your might. It shatters into pieces.");
    isBroken = true; // Update the state to indicate the vase is now broken
}

// Utility method to safely read an integer from the scanner, ensuring valid input
private int safeReadInt(Scanner scanner) {
    while (!scanner.hasNextInt()) {
        System.out.println("\nThat's not a number. Please enter a valid number:");
        scanner.next(); // Consume the non-integer input to clear the scanner
    }
    return scanner.nextInt(); // Return the valid integer input
}
}