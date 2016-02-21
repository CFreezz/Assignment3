package Assignment3;

import java.util.ArrayList;
import java.util.Collections;

public class ShoppingCart {
	int ID;
	ArrayList<Item> cart = new ArrayList<Item>();

	public ShoppingCart(int ID) {
		this.ID = ID;
	}

	public Item findItem(String name) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getName().equals(name)) {
				return cart.get(i);
			}
		}
		return null;
	}

	public void sort() {
		CartSort sorter = new CartSort();
		Collections.sort(cart, sorter);
	}

	public void addItem(Item thing) {
		Item temp = findItem(thing.getName());
		if (temp == null) {
			cart.add(thing);
		} else {
			temp.setQuantity(thing.getQuantity() + temp.getQuantity());
		}
	}

	public void removeItem(String name) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getName().equals(name)) {
				cart.remove(i);
				return;
			}
		}
	}

	public int searchItem(String name) {
		Item temp = findItem(name);
		if (temp == null) {
			return 0;
		} else {
			return temp.getQuantity();
		}
	}

	public void updateItem(String name, int quantity) {
		Item temp = new Item(name, 0, quantity, 0);
		addItem(temp);
	}

	public void printItems() {
		sort();
		for (Item temp : cart) {
			temp.printItemAttributes();
		}

	}

}
