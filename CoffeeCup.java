import java.util.InputMismatchException;
import java.util.Scanner;

// CoffeeCup class extending GameItem to inherit its properties and implementing Usable for polymorphism
public class CoffeeCup extends GameItem {

    // Constructor
    public CoffeeCup(String name) {
        super(name);
    }

    // Implement the use method from the Usable interface
    @Override
    public void use() {
        System.out.println("You pick up the " + getName() + ".");
        System.out.println("Do you want to 1. Drink the coffee or 2. Throw the cup? Enter the number:");

        int choice = safeReadInt(); // Call a method to safely read the player's choice

        if (choice == 1) {
            // Drinking the coffee
            System.out.println("Oh no, you started choking!! Wait, is that a nut flavour? You are allergic to them!!");
            System.out.println("You are dead in the cage, good played.");
            System.exit(0); // Ends the game
        } else if (choice == 2) {
            // Throwing the cup
            System.out.println("You throw the cup across the room. It doesn't achieve much, but it felt good.");
        } else {
            System.out.println("Invalid choice. The moment passes, and you put the cup back down.");
        }
    }

    // Static method to safely read an integer from the user input
    private static int safeReadInt() {
        Scanner scanner = new Scanner(System.in);
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