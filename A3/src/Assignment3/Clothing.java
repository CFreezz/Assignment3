package Assignment3;
//Clothing is a subclass of item, overload calculate price and print
public class Clothing extends Item {


	public Clothing(String name, double basePrice, int quantity, int weight) {
		super(name, basePrice, quantity, weight);

	}

	double calculatePrice() {
		double final_price = basePrice * quantity * 1.1;
		double shipping_price = 20 * weight * quantity;
		final_price = roundCents(final_price + shipping_price);
		return final_price;
	}

	void printItemAttributes() {
		super.printItemAttributes();
		System.out.print(" Price: $" + calculatePrice());
	}

	public String getType() {
		return "Clothing";
	}

}
