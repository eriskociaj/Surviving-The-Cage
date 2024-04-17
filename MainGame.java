import java.util.InputMismatchException;
import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Introduction by the captor
        System.out.println("HAHA HA YOU WILL NEVER ESCAPE THIS CAGE. I WILL HAVE YOU LOCKED UP FOREVER!");

        // Roll in the introductions
        System.out.println(
                "A mysterious voice continues, 'But if you're clever enough, maybe there's a way out...'\nWho is this man? You ask yourself. \nWhy are you here? You ask yourself. \nSTOP THE QUESTIONS! YOU NEED TO GET OUT");
        System.out.print("----------------------------------------------------- ");
        System.out.print("\nWhat is your name, prisoner? ");

        String playerName = scanner.nextLine();
        System.out.println("Welcome, " + playerName
                + ". Your journey begins now. \nSo you see yourself inside this cage. \nYou must get out of this cage, immidiately.");

        Player player = new Player();
        player.addToInventory(new Book("A Tale of Two Cities"));
        player.addToInventory(new WaterBottle("Plastic Water Bottle"));
        player.addToInventory(new Pen("Blue Pen"));
        player.addToInventory(new Vase("Ancient Vase"));
        player.addToInventory(new MiniChair("Wooden Mini Chair"));
        player.addToInventory(new CoffeeCup("Cup of Coffee"));

        boolean keyFound = false;
        // Game loop
        boolean gameRunning = true;

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
                    System.out.println("Here are the items that were left to entertain you:");
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
            // Check if the key has been found to declare victory
            if (keyFound) {
                System.out.println("Congratulations! You've found the key and used it to escape the cage. YOU ARE FREEEEE!");
                gameRunning = false; // End the game loop
            }
        }
        scanner.close();
    }

    // Helper method to safely read an integer from the user, preventing crashes
    // from non-integer input
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