package shoppingcart;

public class main {

    public static void main(String[] args) {


        Cart cart = new Cart<>();
        for (int i = 1; i < 3; i++) {
            cart.addProduct(new Laptop("LT00" + i,100 + i,"coreI" + i));
            cart.addProduct(new Keyboard("K00" + i,98 + i,i + "kg"));
            cart.addProduct(new Screen("SC00" + i,100 + i,(i * 1000) + "px"));
        }
        cart.displayAll();
        System.out.printf("\n number of product is: " + cart.count());

        System.out.printf("\n--------------remove--------------------");
        Laptop productDeleted = (Laptop) cart.deleteProduct(new Laptop("LT00" + 1,100 + 1,"coreI" + 1));
        System.out.print("\n product is deleted: " + productDeleted.toString());
        System.out.printf("\n number of product after delete is: " + cart.count());

    }


}
