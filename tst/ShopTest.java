/**Name: Bhanu Prakash Manikonda
 * Course: CSC526
 * Assignment: CSC526-HW1
 * Section: A
 */
import org.junit.Test;

import static junit.framework.TestCase.assertNotSame;
import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.*;

public class ShopTest {
    @Test
    public void itemNameTest(){
        Item item=new Item("Computer Science pen",3.40);
        assertEquals("Computer Science pen", item.getName());
    }

    @Test
    public void itemPriceTest(){
        Item item=new Item("Computer Science pen",3.40);
        assertEquals("10.20", String.format("%.2f",item.priceFor(3)));
        item=new DiscountedItem("Java Rules! button",0.99,10,5.00);
        assertEquals("7.97", String.format("%.2f",item.priceFor(13)));
    }

    @Test
    public void catalogItemTest(){
        Item item=new Item("Computer Science pen",3.40);
        Item item1=new DiscountedItem("Java Rules! button",0.99,10,5.00);
        Catalog catalog=new Catalog("My Shopping");
        catalog.add(item);
        catalog.add(item1);
        assertNotNull(catalog);
        assertSame(item1,catalog.getItem("Java Rules! button"));
        assertNotSame(item,catalog.getItem("Java Rules! button"));
        assertEquals("My Shopping", catalog.getStoreName());
    }

    @Test
    public void purchaseItemTest(){
        Item item=new Item("Computer Science pen",3.40);
        Purchase purchase=new Purchase(item,5);
        assertEquals(5, purchase.getQuantity());
        item=new DiscountedItem("Java Rules! button",0.99,10,5.00);
        purchase=new Purchase(item,0);
        assertTrue(purchase.isEmpty());
        purchase=new Purchase(item,12);
        assertEquals("6.98", String.format("%.2f",purchase.getPrice()));
        purchase.updateQuantity(14);
        assertEquals("8.96", String.format("%.2f",purchase.getPrice()));
    }

    @Test
    public void shoppingCartTest(){
        ShoppingCart shoppingCart=new ShoppingCart();
        Item item=new Item("Computer Science pen",3.40);
        Purchase purchase=new Purchase(item,5);
        shoppingCart.add(purchase);
        item=new DiscountedItem("Java Rules! button",0.99,10,5.00);
        purchase=new Purchase(item,12);
        shoppingCart.add(purchase);
        assertEquals("23.98", String.format("%.2f",shoppingCart.getTotal()));
        assertFalse(shoppingCart.hasDiscount());
        purchase=new Purchase(item,16);
        shoppingCart.add(purchase);
        shoppingCart.setDiscount(true);
        assertEquals("25.15", String.format("%.2f",shoppingCart.getTotal()));
        assertEquals(21,shoppingCart.totalQuantity());
    }


//    public static void main(String[] args) {
//        Result result = JUnitCore.runClasses(ShopTest.class);
//        System.out.println("Hello how are you !!!");
//        for (Failure failure : result.getFailures()) {
//            System.out.println(failure.toString());
//        }
//        System.out.println(result.wasSuccessful());
//    }
}
