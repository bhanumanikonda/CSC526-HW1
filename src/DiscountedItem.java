/**Name: Bhanu Prakash Manikonda
 * Course: CSC526
 * Assignment: CSC526-HW1
 * Section: A
 *
 * This class is a single item with a bulk discount for high-quantity purchases
 */
public class DiscountedItem extends Item{
    // this variable saves bulk quantity to purchase the discounteditem
    private int bulkquantity;
    // this variable saves bulk price for bulk quantity to purchase the discounteditem
    private double bulkprice;
    // This constructor takes DiscountedItem data and saves into variables
    public DiscountedItem(String name,double price,int bulkquantity,double bulkprice){
        super.name=name;
        super.price=price;
        this.bulkquantity=bulkquantity;
        this.bulkprice=bulkprice;
    }
    // this method override because this class extends from item class this method calculate the price by quantity of purchase
    @Override
    public double priceFor(int quantity){
        if(quantity==this.bulkquantity){
            return this.bulkprice;
        }else if(quantity>this.bulkquantity){
            int quotient=quantity/this.bulkquantity;
            int remainder=quantity%this.bulkquantity;
            return (quotient*this.bulkprice)+(remainder*super.price);
        }else{
            return super.price * quantity;
        }
    }
    // this method used to display the fixed item data format given by assignment notes on GUI window
    public String toString(){
        return super.name+", $"+String.format("%.2f",super.price)+" ("+this.bulkquantity+" for $"+this.bulkprice+")";
    }
}
