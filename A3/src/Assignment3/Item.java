package Assignment3;

//Item class, objects used by ShoppingCart class
public class Item {
	// Declare variables for this class. T
	protected double basePrice;
	protected double salesTax = 0.1;
	protected String name;
	protected int quantity;
	protected int weight;

	// constructor, must have these variables to create an item
	public Item(String name, double basePrice, int quantity, int weight) {
		this.name = name;
		this.basePrice = basePrice;
		this.quantity = quantity;
		this.weight = weight;
	}

	// Price Calculations are handled within the subclasses, automatically set
	// to 0
	double calculatePrice() {
		double final_price = 0;
		return final_price;
	}

	// used to ensure there are only two decimal places (rounded up)
	double roundCents(double amount) {
		int temp = (int) (amount * 100);
		return (double) ((double) temp / 100);
	}

	// getters and setters for the various attributes

	public String getType() {
		return "Item";
	}

	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	// Print all applicable attributes of this class
	void printItemAttributes() {
		System.out.print("Name " + name);
		System.out.print(" Price $" + basePrice);
		System.out.print(" Quantity " + quantity);
		System.out.print(" Weight " + weight + " lbs ");
	}

	// list of states that have no sales tax
	String[] noTaxStates = new String[] { "TX", "NM", "VA", "AZ", "AK" };

	// returns true if the state has sales tax, false if it doesn't
	boolean stateTax(String state) {
		for (int i = 0; i < noTaxStates.length; i++) {
			if (state.equals(noTaxStates[i])) {
				return false;
			}
		}
		return true;
	}

}
