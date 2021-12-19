package shopingcart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCart();
        for (int i = 1; i < 6; i++) {
            shoppingCart.addItem(new Laptop("LT00" + i,"title" + i,10,"corei" + i));
            Integer resolution = new Integer(i * 1000);
            shoppingCart.addItem(new Screen("S00" + i,"title" + i,10, resolution + "px"));
        }

    }

    @AfterEach
    void tearDown() {
        System.out.printf("\nfinish test case");
    }

//    @Test
//    void testGetBalance(){
//        assertEquals(40,shoppingCart.getBalance());
//    }
//
//    @Test
//    void testAddItem(){
//        shoppingCart.addItem(new Product("newItem",10));
//        assertEquals(5,shoppingCart.getItemCount());
//    }
//
//    @Test
//    void testRemoveIte(){
//        shoppingCart.addItem(new Product("newItem",10));
//        assertEquals(5,shoppingCart.getItemCount());
//    }

    @Test
    void testDeleteItem() throws ProductNotFoundException {
        System.out.printf("\ntestDeleteItem");
        System.out.printf("\nsize" + shoppingCart.getItems().size());
        Product productDelete = new Product("LT001","title1",10);
        shoppingCart.removeItem(productDelete);
        assertEquals(4,shoppingCart.getItemCount());

    }

//    @Test
//    void displayAllProduct(){
//        shoppingCart.displayAllItem();
//    }

//    @Test
//    void findById(){
//        Laptop laptop = (Laptop) shoppingCart.findById("LT001");
//        Screen screen = (Screen) shoppingCart.findById("S001");
//        assertEquals("S001",screen.getId());
//    }


}