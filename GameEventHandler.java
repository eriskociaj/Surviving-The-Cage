// This class handles game events, specifically listening for when a key is discovered
public class GameEventHandler implements KeyDiscoveryListener {
    @Override
    // This method is called when the key is discovered in the game
    public void onKeyDiscovered() {
        System.out.println("\nCongratulations you were able to escape from the stalker, YOUUU AREE FREEE!");
        System.exit(0); // Terminate the program
    }
}