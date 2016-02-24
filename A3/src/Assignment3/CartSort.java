package Assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//sorting algorithm for the shoppingcart using comparator and collection sort of an arraylist
public class CartSort implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		ArrayList<String> items = new ArrayList<String>();

		items.add(o1.getName().toUpperCase());
		items.add(o2.getName().toUpperCase());

		if (items.get(0).equals(items.get(1))) {
			return 0;
		}

		Collections.sort(items);

		if (items.get(0).equals(o1.getName().toUpperCase())) {
			return -1;
		}
		return 1;
	}

}
