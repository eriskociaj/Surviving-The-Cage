import java.util.InputMismatchException;
import java.util.Scanner;

public class Cage {
    // Scanner for reading input from the console
    private Scanner scanner;
    // Player instance to manage player state and inventory
    private Player player;

    // Constructor initializes the game by setting up the scanner and starting the game
    public Cage() {
        scanner = new Scanner(System.in); // Initialize scanner to read from standard input
        startGame(); // Begin the game sequence
    }

    // startGame handles the initial game setup and introduction
    public void startGame() {
        // Introduction message from the captor
        System.out.println("\n\nHAHA HA YOU WILL NEVER ESCAPE THIS CAGE. I WILL HAVE YOU LOCKED UP FOREVER!");

        // Further narrative to set the game's context
        System.out.println("\nA mysterious voice continues, 'But if you're clever enough, maybe there's a way out...'\nWho is this man? You ask yourself. \nWhy are you here? You ask yourself. \nSTOP THE QUESTIONS! YOU NEED TO GET OUT");
        System.out.print("----------------------------------------------------- ");
        System.out.print("\nWhat is your name, prisoner? ");

        // Capture player's name and welcome them
        String playerName = scanner.nextLine();
        System.out.println("\nWelcome, " + playerName + ". Your journey begins now. \nSo you see yourself inside this cage. \nYou must get out of this cage, immediately.");

        // Initialize player with the captured name
        player = new Player(playerName);
        // Populate player's inventory with initial items
        initializeInventory();

        // Enter the main game loop
        gameLoop();
    }

    // initializeInventory adds initial items to the player's inventory
    private void initializeInventory() {
        // Adding a variety of items to the player's inventory for interaction
        player.addToInventory(new Book("A Tale of Two Cities"));
        player.addToInventory(new WaterBottle("Plastic Water Bottle"));
        player.addToInventory(new Pen("Blue Pen"));
        player.addToInventory(new Vase("Ancient Vase"));
        player.addToInventory(new MiniChair("Wooden Mini Chair"));
        player.addToInventory(new CoffeeCup("Cup of Coffee"));
    }

    // gameLoop contains the main game logic, allowing the player to interact with the game
    private void gameLoop() {
        boolean gameRunning = true; // Control variable for the game loop

        while (gameRunning) {
            // Display options for the player
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Use an item");
            System.out.println("2. Check inventory");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            int choice = safeNextInt(scanner); // Safely read the player's choice

            switch (choice) {
                case 1: // Use an item
                    System.out.println("\nHere are the items in your inventory:");
                    player.showInventory();
                    System.out.println("\nWhich item would you like to use? Please enter the number.");
                    int itemChoice = safeNextInt(scanner) - 1; // Adjust for zero-based index
                    if (itemChoice >= 0 && itemChoice < player.inventorySize()) {
                        player.useItem(itemChoice);
                    } else {
                        System.out.println("Invalid item choice.");
                    }
                    break;
                case 2: // Check inventory
                    System.out.println("\nInspecting your inventory...");
                    player.showInventory();
                    break;
                case 3: // Quit the game
                    System.out.println("\nQuitting the game already... Well then you are dead, goodbye!");
                    gameRunning = false; // Exit the loop and end the game
                    System.exit(0); // Terminate the program
                default: // Handle invalid choices
                    System.out.println("\nInvalid choice. Please select a valid option.");
                    break;
            }
        }
        scanner.close(); // Close the scanner when the game ends
    }

    // Utility method to safely read an integer from the scanner, ensuring valid input
    private static int safeNextInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt(); // Attempt to read an integer
            } catch (InputMismatchException e) {
                System.out.println("\nThat's not a valid number. Please enter a number.");
                scanner.next(); // Clear the invalid input before retrying
            }
        }
    }
}