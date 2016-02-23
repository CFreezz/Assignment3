package Assignment3;

public class Item {
	// Declare variables for this class. Think about its type: public, protected
	protected double basePrice;
	protected double salesTax = 0.1;
	protected String name;
	protected int quantity;
	protected double weight;
	// or private?
	// You will need a constructor (Why?). Create it here.
	public Item(String name, double basePrice, int quantity, double weight){
		this.name = name;
		this.basePrice = basePrice;
		this.quantity = quantity;
		this.weight = weight;	
	}
	public String getType(){
		return "Item";
	}
	double calculatePrice() {
		double final_price = 0;
		// Insert price calculation here
		return final_price;
	}
	double roundCents(double amount){
		int temp = (int) (amount * 100);
		return (double) (temp/100);
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
		System.out.print("name: " + name );
		System.out.print(" base price: " + basePrice);
		System.out.print(" quantity: " + quantity);
		System.out.print(" weight: " + weight);
	}
	String[] noTaxStates = new String[] {"TX", "NM", "VA", "AZ", "AK" };
	boolean stateTax(String state){
		for(int i=0; i< noTaxStates.length; i++){
			if(state.equals(noTaxStates[i])){
				return false;
			}
		}
		return true;
	}

}
