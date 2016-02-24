package Assignment3;

public class Grocery extends Item {

	boolean perishable;

	// variables, constructor here
	public Grocery(String name, double basePrice, int quantity, int weight, boolean perishable) {
		super(name, basePrice, quantity, weight);
		this.perishable = perishable;
	}
	
	public String getType(){
		return "Groceries";
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
		super.printItemAttributes();
//		System.out.print("name: " + name);
//		System.out.print(" base price: " + basePrice);
//		System.out.print(" quantity: " + quantity);
//		System.out.print(" weight: " + weight);
		if(perishable){
			System.out.print(" perishable ");
		}else{
			System.out.print(" non-perishable ");
		}
		System.out.print( " Total price: $" + calculatePrice());
	}
}
