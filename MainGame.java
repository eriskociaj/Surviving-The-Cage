import java.util.InputMismatchException;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        Player player = new Player();
        player.addToInventory(new Book("A Tale of Two Cities"));
        player.addToInventory(new WaterBottle("Plastic Water Bottle"));
        player.addToInventory(new Pen("Blue Pen"));
        player.addToInventory(new Vase("Ancient Vase"));
        player.addToInventory(new MiniChair("Wooden Mini Chair"));
        player.addToInventory(new CoffeeCup("Cup of Coffee"));

        // Game loop
        boolean gameRunning = true;
        Scanner scanner;
        while (gameRunning) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Use an item");
            System.out.println("2. Check inventory");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            int choice = safeNextInt(scanner);

            switch (choice) {
                case 1:
                    System.out.println("You must see your inventory first.");
                    System.out.println("So inside this cage, you have some items that were left to entertain you:");
                    player.showInventory();
                    System.out.println("Which item do you choose? Please enter the number.");
                    int itemChoice = safeNextInt(scanner) - 1;
                    if (itemChoice >= 0 && itemChoice < player.inventorySize()) {
                        System.out.println("What do you want to do with this item?");
                    } else {
                        System.out.println("Invalid item choice.");
                    }
                    break;
                case 2:
                    player.showInventory();
                    break;
                case 3:
                    System.out.println("Quitting the game. Goodbye!");
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
        scanner.close();
    }

    // Helper method to safely read an integer from the user, preventing crashes from non-integer input
    private static int safeNextInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That's not a valid number. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}