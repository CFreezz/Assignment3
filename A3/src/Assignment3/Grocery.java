package Assignment3;

public class Grocery extends Item {

	boolean perishable;

	// variables, constructor here
	public Grocery(String category, String name, double basePrice, int quantity, double weight, boolean perishable) {
		super(category, name, basePrice, quantity, weight);
		this.perishable = perishable;
		this.category = category;
	}

	// override calculatePrice() if necessary; Implement print methods as
	// necessary
	double calculatePrice() {
		double final_price = basePrice * quantity;
		double shipping_price = 20 * weight * quantity;
		if (perishable) {
			shipping_price = shipping_price * 1.2;
		}
		final_price = roundCents(final_price + shipping_price);
		return final_price;
	}

	// Only re-implement stuff you cannot get from the superclass (Item)
	void printItemAttributes() {
		System.out.print("name: " + name);
		System.out.print(" base price: " + basePrice);
		System.out.print(" quantity: " + quantity);
		System.out.print(" weight: " + weight);
		System.out.print(" perishable:" + perishable);
	}
}
