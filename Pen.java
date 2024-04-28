import java.util.Scanner;

public class Pen extends GameItem {

    private Scanner scanner;
    
    
    public Pen(String name) {
        super(name);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void use() {
        if (!GameState.chairUsed) {
            System.out.println("\nYou need to use the MiniChair to reach the shelf items first.");
            return;
        }

        System.out.println("\nYou have picked up a Pen. It feels light and might be useful.");
        System.out.println("You hold the Pen in your hand. What do you want to do with it?");
        System.out.println("1. Write a letter");
        System.out.println("2. Throw it away");
        System.out.print("Choose an option (1 or 2): ");
        
        int choice = safeReadInt(scanner);
        
        switch (choice) {
            case 1:
                writeLetter();
                break;
            case 2:
                throwPen();
                break;
            default:
                System.out.println("\nThat's not a valid option. Let's try this again.");
                use(); // Recursively call use to handle the choice again
                break;
        }
    }

    private void writeLetter() {
        System.out.println("\nYou start to write a letter, but then realize you don't know who to write to.");
    }

    private void throwPen() {
        System.out.println("\nYou throw the Pen, but it doesn't achieve much. You pick it back up.");
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