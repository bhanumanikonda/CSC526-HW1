/**Name: Bhanu Prakash Manikonda
 * Course: CSC526
 * Assignment: CSC526-HW1
 * Section: A
 */
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class is the list of all purchases that the user currently wants to make
 */
public class ShoppingCart implements Iterable<Purchase>{
    // List is used to stores collection of purchase items
    private static List<Purchase> list=null;
    // this variable used to check the discount of shopping cart or not
    private boolean isDiscount=false;
    // this static method returns the percentage to discount carts that contain enough items 10
    public static int getDiscountPercentage(){
        return 10;
    }
    // this static method returns the minimum quantity where a discount will apply to carts
    public static int getDiscountQuantity(){
        return 10;
    }
    // default constructor
    public ShoppingCart(){}
    // add purchase item to collection of purchase items in the List
    public void add(Purchase purchase){
        if(list==null){
            list=new ArrayList<Purchase>();
        }
        boolean check=false;
        if(list!=null){
            for(Purchase purchasedata : this){
                if(purchasedata.item.name.equalsIgnoreCase(purchase.item.name)){
                    purchasedata.updateQuantity(purchase.quantity);
                    check=true;
                    break;
                }
            }
            if(check==false) {
                list.add(purchase);
            }
        }
    }
    // this method clear the ShoppingCart means delete all the items from ShoppingCart
    public void clearAll(){
        list.clear();
        list=null;
    }
    // get Total price of the ShoppingCart in this calculate discount also if isDiscount is true
    public double getTotal(){
        double total=0.00;
        if(list!=null) {
            for (Purchase purchase : this) {
                total += purchase.getPrice();
            }
        }
        if(this.isDiscount==true) {
            total-=((10*total)/100);
        }
        return total;
    }
    // initially hasDiscount is false means checkbox of the Discount is false
    public boolean hasDiscount(){
        return false;
    }
    // set the discount when discount carts that contain enough items 10 or minimum quantity is 20 where a discount will apply to carts
    public void setDiscount(boolean value){
        if(value==true){
            if (totalQuantity() >= 20 || (list != null && list.size() >= 10)) {
                this.isDiscount = true;
            } else {
                JOptionPane.showMessageDialog(null, "10% off when you buy 10 or more items", "Validaton", JOptionPane.PLAIN_MESSAGE);
            }
        }else{
            this.isDiscount = false;
        }
    }
    // it returns all the purchase items quantity count
    public int totalQuantity(){
        int totalquantity=0;
        if(list!=null) {
            for (Purchase purchase : this) {
                totalquantity += purchase.getQuantity();
            }
        }
        return totalquantity;
    }
    // this method iterates all the purchase items when we display
    public Iterator<Purchase> iterator(){
        return list.iterator();
    }
}
