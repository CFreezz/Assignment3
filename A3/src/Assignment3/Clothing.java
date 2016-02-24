package Assignment3;

public class Clothing extends Item {
	// variables, constructors as necessary

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
		System.out.print( " Price: $" + calculatePrice());
		
//		System.out.print("name: " + name);
//		System.out.print(" base price: " + basePrice);
//		System.out.print(" quantity: " + quantity);
//		System.out.print(" weight: " + weight);
//		System.out.print( "Price: " + calculatePrice() + " $");
	}

	public String getType() {
		return "Clothing";
	}

}
