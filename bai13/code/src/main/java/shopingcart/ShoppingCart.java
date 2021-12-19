package shopingcart;

import java.util.*;

public class ShoppingCart<T extends Product> {
	
	private ArrayList<T> items;
	
	public ShoppingCart() {
		items = new ArrayList<T>();
	}
	
	public double getBalance() {
		double balance = 0.00;
		for (Iterator i = items.iterator(); i.hasNext();){
			Product item = (Product)i.next();
			balance += item.getPrice();
		}
		return balance;
	}
	
	public void addItem(T item) {
		items.add(item);
	}
	
	public void removeItem(T item)
			throws ProductNotFoundException {
		if (!items.remove(item)) {
			throw new ProductNotFoundException();}
	}
	
	public int getItemCount() {
		return items.size();
	}
	
	public void empty() {
		items.clear();
	}

	public ArrayList<T> getItems() {
		return items;
	}

	public void displayAllItem(){
		for (T t:items
			 ) {
			System.out.printf("\n" + t.toString());
		}
	}

	public T findById(String id){
		T result = null;
		for (T t:items) {
			if (t.getId().equals(id)){
				result = t;
				break;
			}
		}

		return result;
	}



}

