/**Name: Bhanu Prakash Manikonda
 * Course: CSC526
 * Assignment: CSC526-HW1
 * Section: A
 * * This class is a single item to be purchased in a given quantity
 */
public class Purchase {
    // this is the public variable to access this variable in any class it saves the item information for purchase
    public Item item;
    // this is the public variable to access this variable in any class it saves the quantity information for purchase item quantity
    public int quantity;
    // this constructor takes the item and quantity information and save the data into variables for purchasing
    public Purchase(Item item,int quantity){
        this.item=item;
        this.quantity=quantity;
    }
    // this method calculates the total price of purchase item using quantity of purchase and purchase item price
    public double getPrice(){
        return this.item.priceFor(this.quantity);
    }
    public int getQuantity(){
        return this.quantity;
    }
    // this method returns boolean variable if the purchase qty is zero not added to shopping cart
    public boolean isEmpty(){
        if(this.quantity==0){
            return true;
        }else{
            return false;
        }
    }
    // matches the purchase item information
    public boolean matches(Purchase purchase){
        return true;
    }
    //  this method used to update the quantity of purchase item
    public void updateQuantity(int quantity){
        this.quantity=quantity;
    }
}
