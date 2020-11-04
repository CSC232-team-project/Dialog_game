import java.util.ArrayList;
import java.util.Iterator;

public class Location {

    private String locationName;
    private String locationDescription;
    private ArrayList<Item> itemList;

    public Location(String pName, String pDescription) {
        locationName = pName;
        locationDescription = pDescription;
        itemList = new ArrayList<Item>();
    }

    public String getName() {
        return locationName;
    }

    public String getDescription() {
        return locationDescription;
    }

    public void setName(String pName) {
        locationName = pName;
    }

    public void setDescription(String pDescription) {
        locationDescription = pDescription;
    }

    public void addItem(Item itemToAdd) {
        itemList.add(itemToAdd);
    }

    public boolean hasItem(String itemSearching) {
        Iterator<Item> iter = itemList.iterator();
        while (iter.hasNext()) {
            Item nextTo = iter.next();
            String itemName = nextTo.getName();
            if (itemSearching.equalsIgnoreCase(itemName)) {
                return true;
            }
            iter.hasNext();
        }
        return false;
    }

    public Item getItem(String itemGetting) {
        Iterator<Item> iter = itemList.iterator();
        while (iter.hasNext()) {
            Item nextTo = iter.next();
            String itemName = nextTo.getName();
            if (itemGetting.equalsIgnoreCase(itemName)) {
                return nextTo;
            }

        }
        return null;
    }

    public Item getItem(int index) {

        if (index < 0 || index >= itemList.size()) {
            return null;
        } else {
            int position = 0;
            Iterator<Item> iter = itemList.iterator();
            Item temp = iter.next();
            while (position < index && iter.hasNext()) {
                temp = iter.next();
                position++;
            }
            return temp;
        }
    }

    public int numItems() {
        int count = itemList.size();
        return count;
    }

    public Item removeItem(String itemRemoving) {

        if (hasItem(itemRemoving)) {
            Item temp = getItem(itemRemoving);
            int position = itemList.indexOf(getItem(itemRemoving));
            itemList.remove(position);
            return temp;
        } else {
            return null;
        }

    }
}
