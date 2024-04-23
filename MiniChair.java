import java.util.Scanner;

public class MiniChair extends GameItem {

    public MiniChair(String name) {
        super(name); // Initialize the MiniChair with a name
    }

    @Override
    public void use() {
        System.out.println("It's sturdy enough to support your weight, but look there is a shelf!.");
    }

    public void interact(Scanner scanner) {
        System.out.println("You're looking at the " + getName() + ". It seems like it could help you reach higher places.");
        System.out.println("1. Use the MiniChair to climb\n2. Ignore the MiniChair");
        System.out.print("What will you do? ");
        int choice = CurrentItem.safeReadInt(scanner); // Use the static method from CurrentItem to safely read the user's choice

        switch (choice) {
            case 1:
                System.out.println("You decide to use the " + getName() + " to climb up.");
                use(); // Use the MiniChair to climb
                showShelfItems(scanner, null);
                break;
                case 2:
                System.out.println("You decide to ignore the " + getName() + " for now.");
                break;
                default:
                System.out.println("That's not a valid option. Let's try this again.");
                interact(scanner); // Recursively call interact to handle the choice again
                break;
        }
    }
private void showShelfItems(Scanner scanner, Inventory inventory) {
    System.out.println("On the shelf, you see a Book, a Pen, and a Vase.");
    System.out.println("Which item would you like to interact with? Please enter the number:");
    System.out.println("1. Book");
    System.out.println("2. Pen");
    System.out.println("3. Vase");

    int choice = CurrentItem.safeReadInt(scanner) - 1;

    switch (choice) {
        case 0: // Book
            CurrentItem currentItemBook = new CurrentItem("Book");
            currentItemBook.interact(scanner); // Delegate interaction to CurrentItem for Book
            break;
        case 1: // Pen
            CurrentItem currentItemPen = new CurrentItem("Pen");
            currentItemPen.interact(scanner); // Delegate interaction to CurrentItem for Pen
            break;
        case 2: // Vase
            CurrentItem currentItemVase = new CurrentItem("Vase");
            currentItemVase.interact(scanner); // Delegate interaction to CurrentItem for Vase
            break;
        default:
            System.out.println("Invalid choice. Please select a valid number.");
            break;
    }
}
}  