package Assignment3;

//Grocery is a subclass of item, overloads calculate price for premium shipping
//and the perishable attribute
public class Grocery extends Item {

	boolean perishable;

	// variables, constructor here
	public Grocery(String name, double basePrice, int quantity, int weight, boolean perishable) {
		super(name, basePrice, quantity, weight);
		this.perishable = perishable;
	}

	public String getType() {
		return "Groceries";
	}

	double calculatePrice() {
		double final_price = basePrice * quantity;
		double shipping_price = 20 * weight * quantity;
		if (perishable) {
			shipping_price = shipping_price * 1.2;
		}
		final_price = roundCents(final_price + shipping_price);
		return final_price;
	}

	void printItemAttributes() {

		if (perishable) {
			System.out.print(" perishable ");
		} else {
			System.out.print(" non-perishable ");
		}
		System.out.print(" Total price: $" + calculatePrice());
	}
}
