import java.util.Scanner;

/**
 * Driver
 */
public class Driver {

    private static Location currLocation;

    public static void main(String[] args) {
        boolean playing = true;
        currLocation = new Location("Julian", "a STEM building built by Julian");
        Item Pistol = new Item("Computer", "CS", "A computer used with CS lab.");
        Item Knife = new Item("Book", "Chemistry", "A book for priciple of chemistry.");
        Item Beef = new Item("Ruler", "Math", "A thing to measure length is math.");
        currLocation.addItem(Pistol);
        currLocation.addItem(Knife);
        currLocation.addItem(Beef);

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
                default:
                    System.out.println("I don’t know how to do that");
                    break;
            }
        }
        scan.close();
    }
}