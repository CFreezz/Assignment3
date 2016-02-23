package Assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CartSort implements Comparator<Item> {
	

	@Override
	public int compare(Item o1, Item o2) {
		ArrayList<String> items = new ArrayList<String>();
		// TODO Auto-generated method stub
		items.add(o1.getName().toUpperCase());
		items.add(o2.getName().toUpperCase());
//		System.out.println(items.get(0) + " " + items.get(1));
		if (items.get(0).equals(items.get(1))){
	//		System.out.println(o1.getName() + " " + o2.getName() + " equals 0");	
			return 0;
		}
		
		Collections.sort(items);
//		System.out.println(o1.getName() + " " + o2.getName());
		if (items.get(0).equals(o1.getName().toUpperCase())){
//			System.out.println(o1.getName() + " " + o2.getName() + " equals -1");
			return -1;
		}
//		System.out.println(o1.getName() + " " + o2.getName() + " equals 1");
		return 1;
	}

		
}
