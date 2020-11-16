import java.util.Scanner;

/**
 * Driver
 */
public class Driver {

    private static Location currLocation;
    private static ContainerItem itemHold;

    public static void main(String[] args) {
        boolean playing = true;
        
        creatWorld();

        Scanner scan = new Scanner(System.in);
        while (playing) {
            System.out.print("Enter command: ");
            String userCommand = scan.nextLine();
            userCommand = userCommand.toLowerCase();

            String[] userCommandList = userCommand.split(" ");
            switch (userCommandList[0]) {
                case "quit":
                    if (userCommandList.length == 1) {
                        playing = false;
                    } else {
                        System.out.println("I don’t know how to do that");
                    }
                    break;
                case "look":
                    if (userCommandList.length == 1) {
                        System.out.println(currLocation.getName() + " - " + currLocation.getDescription()
                                + "has the following items: \n");
                        for (int i = 0; i < currLocation.numItems(); i++) {
                            System.out.println("+ " + currLocation.getItem(i) + "\n");
                        }
                    } else {
                        System.out.println("I don’t know how to do that");
                    }
                    break;
                case "examine":
                    if (userCommandList.length == 2) {
                        Item examineItem = currLocation.getItem(userCommandList[1]);
                        if (examineItem != null) {
                            System.out.println(examineItem.toString());
                        } else {
                            System.out.println("Cannot find that item");
                        }
                    } else {
                        System.out.println("I don’t know how to do that");
                    }
                    break;
                case "go":
                    if (userCommandList.length == 2 && currLocation.canMove(userCommandList[1])) {
                        currLocation = currLocation.getLocation([1]);
                    }
                    else{
                        System.out.println("No Location in the direction");
                    }
                    break;
                case "inventory":
                    if (userCommandList.length == 1) {
                        System.out.println(itemHold.toString());
                    }
                    break;
                case "take":
                    if (userCommandList.length == 2 && currLocation.hasItem(userCommandList[1])) {
                        Item temp = currLocation.removeItem(userCommandList[1]);
                        itemHold.addItem(temp);
                    }
                    else{
                        System.out.println("No Item found");
                    }
                    break;
                case "drop":
                    if (userCommandList.length == 2 && itemHold.hasItem(userCommandList[1])) {
                        Item temp = itemHold.removeItem(userCommandList[1]);
                        currLocation.addItem(temp);
                    }
                    else{
                        System.out.println("No Item to drop");
                    }
                    break;
                case "help":
                    System.out.println("
                    quit: quit the game.\n
                    look: shows items in current location.\n
                    examine + \"item name\": shows description of the itme.\n
                    go + \"direction\": go to the location at the direction.\n
                    inventory: shows items in the backpack.\n
                    take + \"item name\": put item in the location to the backpack.\n
                    drop + \"item name\": drop item in the backpack to the location.\n
                    help: shows available commands in the game.\n
                    ");
                default:
                    System.out.println("I don’t know how to do that");
                    break;
            }
        }
        scan.close();
    }

    public static void creatWorld(){
        peeler = new Location("peeler", "A peeler");
        Roy = new Location("Roy", "a Roy");
        Julian = new Location("Julian", "a STEM building built by Julian");
        Union = new Location("Union", "a Union");

        Julian.connect("West", peeler);
        peeler.connect("East", Julian);

        Julian.connect("North", Roy);
        Roy.connect("South", Julian);

        Julian.connect("East", Union);
        Union.connect("West", Julian);

        Item Computer = new Item("Computer", "CS", "A computer used with CS lab.");
        Item Book = new Item("Book", "Chemistry", "A book for priciple of chemistry.");
        Item Ruler = new Item("Ruler", "Math", "A thing to measure length is math.");
        Julian.addItem(Computer);
        Julian.addItem(Book);
        Julian.addItem(Ruler);

        Item Picture = new Item("Picture", "Art", "A Picture");
        peeler.addItem(Picture);
        Item CSTextbook = new Item("CSTextbook", "CS", "A CS Textbook");
        Roy.addItem(CSTextbook);
        Item ATM = new Item("ATM", "CS", "A ATM");
        Union.addItem(ATM);
        
        currLocation = Julian;
    }
}