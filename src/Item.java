/**Name: Bhanu Prakash Manikonda
 * Course: CSC526
 * Assignment: CSC526-HW1
 * Section: A
 *
 * This class is a single item that can be purchased
 */
public class Item {
    // this is the public variable to access this variable in any class those are extend this class and it saves the name of the item
    public String name;
    // this is the public variable to access this variable in any class those are extend this class and it saves the price of the item
    public double price;
    // this is default constructor for using subclasses
    public Item(){}
    // this constructor takes the item information and save the data into variables
    public Item(String name,double price){
        this.name=name;
        this.price=price;
    }
    // it returns the name of the item
    public String getName(){
        return this.name;
    }
    // this method calculates the total price of items using quantity of purchase item
    public double priceFor(int quantity){
        return this.price*quantity;
    }
    // this method used to display the fixed item data format given by assignment notes on GUI window
    public String toString(){
        return this.name+", $"+String.format("%.2f",this.price);
    }
}
