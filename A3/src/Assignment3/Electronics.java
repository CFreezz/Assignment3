package Assignment3;

public class Electronics extends Item {

	boolean fragile;
	protected String state;

	public Electronics(String name, double basePrice, int quantity, double weight, boolean fragile, String state) {
		super(name, basePrice, quantity, weight);
		this.fragile = fragile;
		this.state = state;
	}
	
	public String getType(){
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

	// Variables, constructors etc. here.
	void printItemAttributes() {
		System.out.print("name: " + name);
		System.out.print(" base price: " + basePrice);
		System.out.print(" quantity: " + quantity);
		System.out.print(" weight: " + weight);
		System.out.print(" fragile:" + fragile);
		System.out.print(" state:" + state);
	}
	// Implement calculate price/print methods as necessary

}
