import java.util.Scanner;

/**
 * Driver
 */
public class Driver {

    private static Location currLocation;

    public static void main(String[] args) {
        boolean playing = true;
        currLocation = new Location("kitchen");
        Item Pistol = new Item("Pistol", "Weapon", "A six gage pistol loaded");
        Item Knife = new Item("Knife", "Weapon", "A Kife");
        Item Beef = new Item("Beef", "Food", "A Beef");
        currLocation.addItem(Pistol);
        currLocation.addItem(Knife);
        currLocation.addItem(Beef);

        Scanner scan = new Scanner(System.in);
        while (playing) {
            System.out.println("Enter command: ");
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
                            examineItem.toString();
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
    }
}