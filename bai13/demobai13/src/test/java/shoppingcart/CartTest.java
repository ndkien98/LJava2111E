package shoppingcart;

import junit.framework.TestCase;

public class CartTest extends TestCase {

    Cart<Product> cart;

    public void setUp() throws Exception {
        super.setUp();
        cart = new Cart<>();
        for (int i = 1; i < 3; i++) {
            cart.addProduct(new Laptop("LT00" + i,100 + i,"coreI" + i));
            cart.addProduct(new Keyboard("K00" + i,98 + i,i + "kg"));
            cart.addProduct(new Screen("SC00" + i,100 + i,(i * 1000) + "px"));
        }
    }

    public void tearDown() throws Exception {
        System.out.printf("\ntest case is finish!");
    }

    public void testFindById() {

    }

    public void testDeleteProduct() {
        Product product = new Product("LT001",100);
        int amountProductBeforeDelete = cart.count();
        cart.deleteProduct(product);
        assertEquals(amountProductBeforeDelete - 1,cart.count());
    }




    public void testAddProduct() {
        cart.addProduct(new Product("PNew",100));
        assertEquals(7,cart.count());
    }


    public void testCount() {


    }
}