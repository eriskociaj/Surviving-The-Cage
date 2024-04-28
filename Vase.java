// Vase.java

import java.util.Scanner;

public class Vase extends GameItem {
    private boolean isBroken = false;

    public Vase(String name) {
        super(name);
    }

    // This method overrides the abstract use method in GameItem
    @Override
    public void use() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (isBroken) {
                System.out.println("The vase is already broken.");
                return;
            }

            System.out.println("You have the " + getName() + ". Do you want to 1. Look inside it or 2. Throw it?");
            int choice = safeReadInt(scanner);

            switch (choice) {
                case 1:
                    lookInside();
                    break;
                case 2:
                    throwVase();
                    break;
                default:
                    System.out.println("That's not a valid option. The vase remains untouched.");
                    break;
            }
        }
    }

    private void lookInside() {
        System.out.println("As you look inside the vase, a spider jumps out and bites you. You feel dizzy...");
        System.out.println("Oh no! The spider was poisonous. You have died.");
        System.exit(0); // Ends the game
    }

    private void throwVase() {
        System.out.println("You throw the vase with all your might. It shatters into pieces.");
        isBroken = true;
    }

    // Utility method to safely read an integer from the scanner
    private int safeReadInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a number. Please enter a valid number:");
            scanner.next(); // Consume the non-integer input
        }
        return scanner.nextInt();
    }
}