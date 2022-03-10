package shoppingcart;

import java.util.ArrayList;

public class Cart <T>{

    private ArrayList<T> items;
    private int count;

    public Cart() {
        items = new ArrayList<>();
    }

    public void displayAll(){
        for (T t:items) {
            System.out.printf("\n----------------------");
            System.out.print("\n" + t.toString());
        }
    }

    public T addProduct(T t){
        items.add(t);
        count++;
        return t;
    }

    public T deleteProduct(T t){
        if (items.contains(t)){
            items.remove(t);
            count--;
            return t;
        }
        return null;
    }

    public T findById(String id){
        T result = null;
        for (T t:items) {
           if (t instanceof Product){
               if (((Product) t).getId().equals(id)){
                   result = t;
                   break;
               }
           }
        }
        return result;
    }

    private void isEmpty(){
        items.clear();
    }

    public int count() {
        return count;
    }
}
