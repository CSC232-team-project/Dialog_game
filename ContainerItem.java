import java.util.ArrayList;

public class ContainerItem extends Item {
    
    private ArrayList<Item> items;
    
    public ContainerItem(String name, String type, String description){
        super(name, type, description);
        items = new ArrayList<Item>();
    }

    public void addItem(Item itemToAdd){
        items.add(itemToAdd);
    }

    


    
}
