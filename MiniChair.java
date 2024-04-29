public class MiniChair extends GameItem {

    public MiniChair(String name) {
        super(name); // Initialize the MiniChair with a name
    }

    @Override
    public void use() {
        System.out.println("\nIt's sturdy enough to support your weight, but look there is a shelf!");
        System.out.println("You are able to select the Book, Pen, or the Vase.. Be careful..");
        GameState.chairUsed = true;
        GameState.useMiniChair(); // This updates the chairUsed flag in GameState
    }

   
        }
    