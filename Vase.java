
import java.util.Scanner;

public class Vase extends GameItem {
    private boolean isBroken = false;

    public Vase(String name) {
        super(name);
    }

    // This method overrides the abstract use method in GameItem
    @Override
    public void use() {
        if (!GameState.chairUsed) {
            System.out.println("\nYou need to use the MiniChair first to reach the Vase.");
            return;
        }

        Scanner scanner = new Scanner(System.in); // Note: Scanner is not auto-closed

        if (isBroken) {
            System.out.println("\nThe vase is already broken.");
            return;
        }

        System.out.println("\nYou have the magical " + getName() + ". Do you want to 1. Look inside it \n2. Throw it? \nChoose an option (1 or 2):");
        int choice = safeReadInt(scanner);

        switch (choice) {
            case 1:
                lookInside();
                break;
            case 2:
                throwVase();
                break;
            default:
                System.out.println("\nThat's not a valid option. The vase remains untouched.");
                break;
        }
        // Do not close the scanner here to avoid closing System.in
    }

    private void lookInside() {
        System.out.println("\nAs you look inside the vase, a spider jumps out and bites you. You feel dizzy...");
        System.out.println("Oh no! The spider was poisonous. \nYou are dead :(..");
        System.exit(0); // Ends the game
    }

    private void throwVase() {
        System.out.println("\nYou throw the vase with all your might. It shatters into pieces.");
        isBroken = true;
    }

    // Utility method to safely read an integer from the scanner
    private int safeReadInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("\nThat's not a number. Please enter a valid number:");
            scanner.next(); // Consume the non-integer input
        }
        return scanner.nextInt();
    }
}