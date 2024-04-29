import java.util.InputMismatchException;
import java.util.Scanner;

public class Cage {
    private Scanner scanner;
    private Player player;

    public Cage() {
        scanner = new Scanner(System.in);
        startGame();
    }

    public void startGame() {
        // Introduction by the captor
        System.out.println("\n\nHAHA HA YOU WILL NEVER ESCAPE THIS CAGE. I WILL HAVE YOU LOCKED UP FOREVER!");

        // Roll in the introductions
        System.out.println("\nA mysterious voice continues, 'But if you're clever enough, maybe there's a way out...'\nWho is this man? You ask yourself. \nWhy are you here? You ask yourself. \nSTOP THE QUESTIONS! YOU NEED TO GET OUT");
        System.out.print("----------------------------------------------------- ");
        System.out.print("\nWhat is your name, prisoner? ");

        String playerName = scanner.nextLine();
        System.out.println("\nWelcome, " + playerName + ". Your journey begins now. \nSo you see yourself inside this cage. \nYou must get out of this cage, immediately.");

        player = new Player(playerName);
        initializeInventory();

        gameLoop();
    }

    private void initializeInventory() {
        player.addToInventory(new Book("A Tale of Two Cities"));
        player.addToInventory(new WaterBottle("Plastic Water Bottle"));
        player.addToInventory(new Pen("Blue Pen"));
        player.addToInventory(new Vase("Ancient Vase"));
        player.addToInventory(new MiniChair("Wooden Mini Chair"));
        player.addToInventory(new CoffeeCup("Cup of Coffee"));
    }

    private void gameLoop() {
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
                    System.out.println("\nHere are the items in your inventory:");
                    player.showInventory();
                    System.out.println("\nWhich item would you like to use? Please enter the number.");
                    int itemChoice = safeNextInt(scanner) - 1;
                    if (itemChoice >= 0 && itemChoice < player.inventorySize()) {
                        player.useItem(itemChoice);
                    } else {
                        System.out.println("Invalid item choice.");
                    }
                    break;
                case 2:
                    System.out.println("\nInspecting your inventory...");
                    player.showInventory();
                    break;
                case 3:
                    System.out.println("\nQuitting the game already... Well then you are dead, goodbye!");
                    gameRunning = false;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please select a valid option.");
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
                System.out.println("\nThat's not a valid number. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}