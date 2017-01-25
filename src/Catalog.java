/**Name: Bhanu Prakash Manikonda
 * Course: CSC526
 * Assignment: CSC526-HW1
 * Section: A
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class contains the list of products that are saved from mycatalog.txt file.
 */
public class Catalog implements Iterable<Item>{
    // catalog store name save into storeName variable it is a private variable it stores and access with in the class only
    private String storeName;
    // List is used to stores collection of items
    private List<Item> list=null;
    // This is a class constructor and it's a parameter constructor it calls when the class object creates passes the store name that is save into storeName variable
    public Catalog(String storeName){
        this.storeName=storeName;
    }
    // Add method is used to save the item to List of items
    public void add(Item item){
        if(list==null){
            list=new ArrayList<Item>();
        }
        if(list!=null){
            list.add(item);
        }
    }
    // Get the item when pass item name to this method it returns that matched item from the collection of items in the List
    public Item getItem(String name){
        Item item=null;
        for(Item itemdata : this){
            if(itemdata.name.equalsIgnoreCase(name)){
                item=itemdata;
                break;
            }
        }
        return item;
    }
    // It returns the name of the Store
    public String getStoreName(){
        return this.storeName;
    }
    // This method is used to iterate all the items from the List using for each method it takes on(n) times only
    @Override
    public Iterator<Item> iterator(){
        return list.iterator();
    }
}
