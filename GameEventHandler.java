public class GameEventHandler implements KeyDiscoveryListener {
    @Override
    public void onKeyDiscovered() {
        System.out.println("Congratulations you were able to escape from the stalker, YOUUU AREE FREEE!");
        System.exit(0);
    }
}