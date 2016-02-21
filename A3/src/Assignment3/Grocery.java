package Assignment3;

public class Grocery extends Item {

	boolean perishable;
	
	
	public Grocery(String name, double basePrice, int quantity, double weight, boolean perishable) {
		super(name, basePrice, quantity, weight);
		this.perishable = perishable;		
	}
	//variables, constructor here
	
	//override calculatePrice() if necessary; Implement print methods as necessary	
	// Only re-implement stuff you cannot get from the superclass (Item)
	
}
