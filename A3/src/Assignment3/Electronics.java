package Assignment3;
//Electronics is a subclass of item, overloads calculate price for premium shipping
//and print the fragile attribute
public class Electronics extends Item {

	boolean fragile;
	protected String state;

	public Electronics(String name, double basePrice, int quantity, int weight, boolean fragile, String state) {
		super(name, basePrice, quantity, weight);
		this.fragile = fragile;
		this.state = state;
	}

	public String getType() {
		return "Electronics";
	}

	double calculatePrice() {
		double final_price = basePrice * quantity;
		if (stateTax(state)) {
			final_price = final_price * 1.1;
		}
		double shipping_price = 20 * weight * quantity;
		if (fragile) {
			shipping_price = shipping_price * 1.2;
		}
		final_price = roundCents(final_price + shipping_price);
		return final_price;
	}

	void printItemAttributes() {

		if (fragile) {
			System.out.print(" fragile ");
		} else {
			System.out.print(" non-fragile ");
		}
		System.out.print(" state:" + state);
		System.out.print(" Total price: $" + calculatePrice());
	}

}
