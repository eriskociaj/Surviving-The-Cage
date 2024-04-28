import java.util.InputMismatchException;
import java.util.Scanner;

// CoffeeCup class extending GameItem to inherit its properties and implementing Usable for polymorphism
public class CoffeeCup extends GameItem {
    private boolean isBroken = false;
    // Static Scanner instance for the entire class
    private static final Scanner scanner = new Scanner(System.in);

    // Constructor
    public CoffeeCup(String name) {
        super(name);
    }

    // Implement the use method from the Usable interface
    @Override
    public void use() {

        if (isBroken) {
            System.out.println("\nThe cup is already broken.");
            return;
        }

        System.out.println("\nYou pick up the warm " + getName() + ".");
        System.out.println("Do you want to \n1. Drink the coffee. \n2. Throw it? \nChoose an option (1 or 2):");

        int choice = safeReadInt(); // Call a method to safely read the player's choice

        if (choice == 1) {
            // Drinking the coffee
            System.out.println("Oh no, you started choking!! Wait, is that a nut flavour? You are allergic to them!!");
            System.out.println("You are dead :(..");
            System.exit(0); // Ends the game
        } else if (choice == 2) {
            // Throwing the cup
            System.out.println("\nYou throw the cup across the room. It doesn't achieve much, it shattered into pieces.");
            isBroken = true;
        } else {
            System.out.println("\nInvalid choice. The moment passes, and you put the cup back down.");
        }
    }

    // Static method to safely read an integer from the user input
    private static int safeReadInt() {

        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That's not a valid number. Please enter a number.");
                scanner.next();
            }
        }
    }
}