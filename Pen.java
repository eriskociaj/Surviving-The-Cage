import java.util.Scanner;

public class Pen extends GameItem {

    private Scanner scanner; // Scanner object for reading user input

    // Constructor initializes the Pen with a name and a new Scanner instance
    public Pen(String name) {
        super(name); // Calls the constructor of the superclass (GameItem) to set the name of the Pen
        this.scanner = new Scanner(System.in); // Initializes the scanner for input
    }

    // Override the use method to provide specific functionality when the Pen is used
    @Override
    public void use() {
        // Check if the player has used the Wooden Mini Chair before using the Pen
        if (!GameState.chairUsed) {
            System.out.println("\nYou need to use the Wooden Mini Chair to reach the shelf items first.");
            return; // Exit the method if the condition is not met
        }

        // Interaction options with the Pen
        System.out.println("\nYou have picked up a Pen. It feels light and might be useful.");
        System.out.println("You hold the Pen in your hand. What do you want to do with it?");
        System.out.println("1. Write a letter");
        System.out.println("2. Throw it away");
        System.out.print("Choose an option (1 or 2): ");

        int choice = safeReadInt(scanner); // Safely read the player's choice

        // Execute actions based on the player's choice
        switch (choice) {
            case 1: // Option to write a letter
                writeLetter();
                break;
            case 2: // Option to throw the Pen away
                throwPen();
                break;
            default: // Handle invalid choices
                System.out.println("\nThat's not a valid option. Let's try this again.");
                use(); // Recursively call use to prompt the player again
                break;
        }
    }

    // Method to simulate writing a letter with the Pen
    private void writeLetter() {
        System.out.println("\nYou start to write a letter, but then realize you don't know who to write to.");
    }

    // Method to simulate throwing the Pen away
    private void throwPen() {
        System.out.println("\nYou throw the Pen, but it doesn't achieve much. You pick it back up.");
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