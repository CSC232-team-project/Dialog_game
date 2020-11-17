import java.util.ArrayList;
import java.util.Iterator;

public class ContainerItem extends Item {
    
    private ArrayList<Item> items;
    
    public ContainerItem(String name, String type, String description){
        super(name, type, description);
        items = new ArrayList<Item>();
    }

    public void addItem(Item itemToAdd){
        items.add(itemToAdd);
    }

    public boolean hasItem(String itemSearching){
        Iterator<Item> iter = items.iterator();
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

    public Item getItem(String itemGetting){
        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item nextTo = iter.next();
            String itemName = nextTo.getName();
            if (itemGetting.equalsIgnoreCase(itemName)) {
                return nextTo;
            }
        }
        return null;
    }

    public Item removeItem (String itemRemoving){
       if(!hasItem(itemRemoving)){
           return null;
       }
       else{
           int index = items.indexOf(getItem(itemRemoving));
           return items.remove(index);
       }
    }

    @Override
    public String toString()
    {
        String listOfItem = "";
        for(Item anItem : items)
        {
            listOfItem += "+ " + anItem.getName() + "\n";
        }
        return super.toString() + "\n" + listOfItem;
    }
    
}
