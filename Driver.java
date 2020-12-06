import java.util.Scanner;

/**
 * Driver
 */
public class Driver {

    private static Location currLocation;
    private static ContainerItem myInventory;

    public static void main(String[] args) {
        boolean playing = true;

        creatWorld();
        myInventory = new ContainerItem("Backpack", "Container", "Dr.White's old backpack of her childhood");

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
                        System.out.println("Invalid command. Check help command to see the list of available commands");
                    }
                    break;
                case "look":
                    if (userCommandList.length == 1) {
                        System.out.println(currLocation.getName() + " - " + currLocation.getDescription()
                                + " has the following items: \n");
                        for (int i = 0; i < currLocation.numItems(); i++) {
                            System.out.println("+ " + currLocation.getItem(i) + "\n");
                        }
                    } else {
                        System.out.println("Invalid command. Check help command to see the list of available commands");
                    }
                    break;
                case "examine":
                    if (userCommandList.length == 1) {
                        System.out.println("Provide item’s name to examine");
                    } else if (userCommandList.length == 2) {
                        Item examineItem = currLocation.getItem(userCommandList[1]);
                        if (examineItem != null) {
                            System.out.println(examineItem.toString());
                        } else {
                            System.out.println("Cannot find that item");
                        }
                    } else {
                        System.out.println("Invalid command. Check help command to see the list of available commands");
                    }
                    break;
                case "go":
                    if (userCommandList.length == 1) {
                        System.out.println("Provide direction to go");
                    } else if (userCommandList.length == 2) {
                        if (currLocation.canMove(userCommandList[1])) {
                            currLocation = currLocation.getLocation(userCommandList[1]);
                        } else if (!userCommandList[1].equals("east") && !userCommandList[1].equals("west")
                                && !userCommandList[1].equals("south") && !userCommandList[1].equals("north")) {
                            System.out.println("Invalid direction. Choose among: east, west, south, north");
                        } else {
                            System.out.println("No Location in the direction");
                        }
                    } else {
                        System.out.println("Invalid command. Check help command to see the list of available commands");
                    }
                    break;
                case "inventory":
                    if (userCommandList.length == 1) {
                        System.out.println(myInventory.toString());
                    }
                    break;
                case "take":
                    if (userCommandList.length == 1) {
                        System.out.println("Provide item name to take");
                    } else if (userCommandList.length == 2) {
                        if (currLocation.hasItem(userCommandList[1])) {
                            Item temp = currLocation.removeItem(userCommandList[1]);
                            myInventory.addItem(temp);
                        } else {
                            System.out.println(
                                    "Invalid item name. Use \"look\" command to see available items in the location");
                        }
                    } else {
                        System.out.println("No Item found");
                    }
                    break;
                case "drop":
                    if (userCommandList.length == 1) {
                        System.out.println("Provide item name to drop");
                    } else if (userCommandList.length == 2) {
                        if (myInventory.hasItem(userCommandList[1])) {
                            Item temp = myInventory.removeItem(userCommandList[1]);
                            currLocation.addItem(temp);
                        } else {
                            System.out.println(
                                    "Invalid item name. Use \"inventory\" command to see available items in the backpack");
                        }
                    } else {
                        System.out.println("No Item to drop");
                    }
                    break;
                case "put":
                    if (userCommandList.length == 4 && userCommandList[2].equals("in")) {
                        if (currLocation.hasItem(userCommandList[3])
                                && currLocation.getItem(userCommandList[3]) instanceof ContainerItem) {
                            if (myInventory.hasItem(userCommandList[1])) {
                                ContainerItem temp2 = (ContainerItem) currLocation.getItem(userCommandList[3]);
                                temp2.addItem(myInventory.removeItem(userCommandList[1]));
                            } else {
                                System.out.println("Invalid item name, make sure the item is in your inventory");
                            }
                        } else {
                            System.out.println("Invalid Container name");
                        }
                    } else {
                        System.out.println(
                                "Invalid put in command. Follow the format: Put \"item name\" in \"Container Name\"");
                    }
                    break;
                case "help":
                    System.out.println("* quit:                    quit the game.\n"
                            + "* look:                    shows items in current location.\n"
                            + "* examine + \"item name\":   shows description of the itme.\n"
                            + "* go + \"direction\":        go to the location at the direction.\n"
                            + "* inventory:               shows items in the backpack.\n"
                            + "* take + \"item name\":      put item in the location to the backpack.\n"
                            + "* drop + \"item name\":      drop item in the backpack to the location.\n"
                            + "* help:                    shows available commands in the game.\n");
                    break;
                default:
                    System.out.println("Invalid command. Check help command to see the list of available commands");
                    break;
            }
        }
        scan.close();
    }

    public static void creatWorld() {
        Location Peeler = new Location("Peeler", "Peeler: An Art building");
        Location Roy = new Location("Roy", "Roy: A library named after Roy O West");
        Location Julian = new Location("Julian", "Julian: A STEM building built by Julian");
        Location Union = new Location("Union", "Union Building: A common area for students");

        Julian.connect("west", Peeler);
        Peeler.connect("east", Julian);

        Julian.connect("north", Roy);
        Roy.connect("south", Julian);

        Julian.connect("east", Union);
        Union.connect("west", Julian);

        Item Computer = new Item("Computer", "CS", "A computer used with CS lab.");
        Item Book = new Item("Book", "Chemistry", "A book for priciple of chemistry.");
        Item Ruler = new Item("Ruler", "Math", "A thing to measure length is math.");
        Julian.addItem(Computer);
        Julian.addItem(Book);
        Julian.addItem(Ruler);

        Item Picture = new Item("Picture", "studentModel", "A Picture of Vy Hoang in front of the Depauw main gate");
        Peeler.addItem(Picture);
        Item CSTextbook = new Item("CSTextbook", "CS", "A CS textbook used by Chad Byers in this college year");
        Roy.addItem(CSTextbook);
        Item ATM = new Item("ATM", "machine", "A PNC ATM out of order");
        Union.addItem(ATM);

        ContainerItem Chest = new ContainerItem("Chest", "Container", "Secret chest hidden in the Union building");
        Item Necklas = new Item("Necklas", "Jewel", "A old necklas with faded pearls");
        Item Ring = new Item("Ring", "Jewel", "A ring with 18k diamond");
        Item GoldBar = new Item("GoldBar", "Jewel", "A 500g gold bar");
        Chest.addItem(Necklas);
        Chest.addItem(Ring);
        Chest.addItem(GoldBar);
        Union.addItem(Chest);

        ContainerItem Box = new ContainerItem("Box", "Container", "Sealed box with valuable painting");
        Item painting1 = new Item("painting1", "painting", "A picture with a signiture of Vincent Van Gogh");
        Item painting2 = new Item("painting2", "painting", "A drawing of apples by Paul Cezanne");
        Item painting3 = new Item("painting3", "painting", "painting of two Tahitian women by Paul Gauguin");
        Box.addItem(painting1);
        Box.addItem(painting2);
        Box.addItem(painting3);
        Peeler.addItem(Box);

        currLocation = Julian;
    }
}