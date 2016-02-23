package Assignment3;

public class Grocery extends Item {

	boolean perishable;
	
	//variables, constructor here	
	public Grocery(String name, double basePrice, int quantity, double weight, boolean perishable) {
		super(name, basePrice, quantity, weight);
		this.perishable = perishable;		
	}
	//override calculatePrice() if necessary; Implement print methods as necessary	
	double calculatePrice(){
		double final_price = basePrice*quantity;
		double shipping_price = 20*weight*quantity;
		final_price = roundCents(final_price + shipping_price);
		return final_price;

	}
	// Only re-implement stuff you cannot get from the superclass (Item)
	
}
