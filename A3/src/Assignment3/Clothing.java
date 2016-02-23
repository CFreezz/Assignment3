package Assignment3;

public class Clothing extends Item {
	// variables, constructors as necessary

	public Clothing(String name, double basePrice, int quantity, double weight) {
		super(name, basePrice, quantity, weight);

	}

	double calculatePrice() {
		double final_price = basePrice * quantity * 1.1;
		double shipping_price = 20 * weight * quantity;
		final_price = roundCents(final_price + shipping_price);
		return final_price;
	}

	public String getType() {
		return "Clothing";
	}

}
