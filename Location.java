import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Location {

    private String locationName;
    private String locationDescription;
    private ArrayList<Item> itemList;
    private HashMap<String, Location> map;

    public Location(String pName, String pDescription) {
        locationName = pName;
        locationDescription = pDescription;
        itemList = new ArrayList<Item>();
        map = new HashMap<String, Location>();
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
            iter.hasNext();
        }
        return null;
    }

    public Item getItem(int index) {
        if (index < 0 || index > itemList.size()) {
            return null;
        } else {
            return itemList.get(index);
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

    public void connect(String directionName, Location toGo) {
        map.put(directionName, toGo);
    }

    public boolean canMove(String directionName) {
        return map.containsKey(directionName);
    }

    public Location getLocation(String directionName) {
        if (map.containsKey(directionName)) {
            return map.get(directionName);
        } else {
            return null;
        }
    }
}
