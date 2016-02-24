package Assignment3;

//Assignment 3 Main Driver
//Jo Le 
//Chris Friesen
//Shopping Cart
// 2/24/2016
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A3Driver {

	static String validOps[] = { "insert", "search", "delete", "update", "print" };
	static String validCategories[] = { "clothing", "electronics", "groceries" };
	static String validStates[] = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN",
			"IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY",
			"NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI",
			"WY" };
	private static int shopCartID = 0;

	public static void main(String[] args) throws FileNotFoundException {
		ShoppingCart myCart = new ShoppingCart(getNewShoppingCartID());
		println("INITIALIZING PROGRAM - Welcome Professor");
		println("This program includes voice controls. Please say out loud \"Hello Sexy\" to enable voice controls.\n");
		if (args.length == 1) {
			Scanner in;
			try { // check if file exists, if yes, continue below
				in = new Scanner(new File(args[0]));
				while (in.hasNextLine()) {
					String line = in.nextLine();
					String splitLine[] = line.split(" ");
					if (!validLine(splitLine)) {// validLine will print out
												// necessary error message
						continue;
					}
					process(splitLine, myCart);
				}
			} catch (FileNotFoundException e) { // file does not exist, handle
												// it
				System.out.println("Can't find file " + args[0] + " make sure it's in the same directory.");
				System.exit(0);
			}
		} else {
			System.out.println(
					"Incorrect number of command line arguments: Expect a single filename on the command line");
		}
	}

	// assumes all input is valid
	public static void process(String[] splitLine, ShoppingCart myCart) {
		String op = splitLine[0];
		if (op.equalsIgnoreCase("insert")) {
			String category = splitLine[1];
			String name = splitLine[2];
			double price = convertDouble(splitLine[3]);
			int quantity = convertInt(splitLine[4]);
			int weight = convertInt(splitLine[5]);
			if (category.equalsIgnoreCase("clothing")) {
				Clothing newThing = new Clothing(name, price, quantity, weight);
				myCart.addItem(newThing);
			} else if (category.equalsIgnoreCase("electronics")) {
				String strFragility = splitLine[6]; // must be F or NF
				String strShipState = splitLine[7]; // must be a valid state
													// abbreviation
				Electronics newThing = new Electronics(name, price, quantity, weight, convertFragile(strFragility),
						strShipState);
				myCart.addItem(newThing);
			} else if (category.equalsIgnoreCase("groceries")) {
				String strPerishable = splitLine[6];
				Grocery newThing = new Grocery(name, price, quantity, weight, convertPerishable(strPerishable));
				myCart.addItem(newThing);
			}
			println("Insert: Successfully added " + splitLine[2]);
		} else if (op.equalsIgnoreCase("delete")) {
			boolean result = myCart.removeItem(splitLine[1]);
			if (result) {
				println("Delete: Successfully deleted " + splitLine[1]);
			} else {
				println("Delete: Failed, " + splitLine[1] + " not in shopping cart");
			}
		} else if (op.equals("search")) {
			int result = myCart.searchItem(splitLine[1]);
			if (result == -1) {
				println("Search: Failed to find " + splitLine[1]);
			} else {
				println("Search: There is/are " + result + " " + splitLine[1]);
			}
		} else if (op.equalsIgnoreCase("update")) {
			boolean result = myCart.updateItem(splitLine[1], convertInt(splitLine[2]));
			if (result) {
				println("Update: Successfully updated " + splitLine[1]);
			} else {
				println("Update: Falied, " + splitLine[1] + " not in shopping cart");
			}
		} else if (op.equalsIgnoreCase("print")) {
			myCart.printItems();
		}
	}

	private static boolean convertPerishable(String perish) {
		if (perish.equalsIgnoreCase("P")) {
			return true;
		}
		return false;
	}

	private static boolean convertFragile(String frag) {
		if (frag.equalsIgnoreCase("F")) {
			return true;
		}
		return false;
	}

	private static int getNewShoppingCartID() {
		shopCartID++;
		return shopCartID - 1;
	}

	// validate the line of the requested operation
	private static boolean validLine(String[] splitLine) {
		if (splitLine.length < 1) {
			System.out.println("Not enough arguments on the transaction line, continuing to next line");
			return false;
		}
		String op = splitLine[0];
		if (!validOperation(op)) {
			System.out.println(op + " is not a valid operation");
			return false;
		}
		if (op.equalsIgnoreCase("insert")) {
			if (!validInsert(splitLine)) {
				System.out.println("Invalid insert operation, continuing to next line");
				return false;
			}
		} else if (op.equalsIgnoreCase("delete") || op.equals("search")) {
			if (!validSearchOrDelete(splitLine)) {
				System.out.println("Invalid " + op + " operation, continuing to next line");
				return false;
			}
		} else if (op.equalsIgnoreCase("update")) {
			if (!validUpdate(splitLine)) {
				System.out.println("Invalid update operation, continuing to next line");
				return false;
			}
		} else if (op.equalsIgnoreCase("print")) {
			if (!validPrint(splitLine)) {
				System.out.println("Invalid print operation, continuing to next line");
				return false;
			}
		}
		return true; // passed all the tests
	}

	// assumes valid operations
	private static boolean validCategory(String op) {
		for (String goodCat : validCategories) {
			if (goodCat.equalsIgnoreCase(op)) {
				return true;
			}
		}
		return false;
	}

	private static boolean validOperation(String op) {
		// check valid operation insert, search, delete, update, and print.
		for (String goodOp : validOps) {
			if (goodOp.equalsIgnoreCase(op)) {
				return true;
			}
		}
		return false;
	}

	// check if state code is valid two-letter state code
	private static boolean validState(String state) {
		for (String goodState : validStates) {
			if (goodState.equalsIgnoreCase(state)) {
				return true;
			}
		}
		return false;
	}

	private static boolean validInsert(String splitLine[]) {
		if (splitLine.length < 2) {
			System.out.println("Insert transaction does not have enough arguments");
			return false;
		}
		String category = splitLine[1];
		if (!validCategory(category)) {
			println("Not a valid category");
			return false;
		}
		if (splitLine.length < 6) {
			println("Not enough arguments");
			return false;
		}
		// check name, price, quantity, weight
		String name = splitLine[2]; // can be whatever
		String strPrice = splitLine[3]; // must be a valid cash number (two
										// decimal points)
		if (!validNumber(strPrice)) { // check valid number
			System.out.print("Invalid Price, ");
			return false;
		}
		if (!validCashNumber(convertDouble(strPrice))) { // check valid cash
															// number
			print("Invalid price, ");
			return false;
		}
		if (convertDouble(strPrice) < 0) {
			print("Invalid price, ");
			return false;
		}
		String strQuantity = splitLine[4]; // must be a valid integer
		if (!validInteger(strQuantity)) {
			print("Invalid quantity, ");
			return false;
		}
		if (convertInt(strQuantity) < 0) {
			print("Invalid quantity, ");
			return false;
		}
		String strWeight = splitLine[5]; // must be a valid decimal
		if (!validInteger(strWeight)) {
			print("Invalid weight, ");
			return false;
		}
		if (convertInt(strWeight) < 0) {
			print("Invalid weight, ");
			return false;
		}

		if (category.equalsIgnoreCase("clothing")) {
			if (splitLine.length != 6) {
				print("Not correct number of arguments for transaction, ");
				return false;
			}
		} else if (category.equalsIgnoreCase("electronics")) {
			if (splitLine.length != 8) {
				print("Not correct number of arguments for transaction, ");
				return false;
			}
			String strFragility = splitLine[6]; // must be F or NF
			if (!validFragility(strFragility)) {
				print("Invalid fragility argument, ");
				return false;
			}
			String strShipState = splitLine[7]; // must be a valid state
												// abbreviation
			if (!validState(strShipState)) {
				print("Invalid ship state argument, ");
				return false;
			}
		} else if (category.equalsIgnoreCase("groceries")) {
			if (splitLine.length != 7) {
				print("Not correct number of arguments for transaction, ");
				return false;
			}
			String strPerishable = splitLine[6];
			if (!validPerishable(strPerishable)) {
				print("Invalid perishable argument, ");
				return false;
			}

		}
		return true;
	}

	private static boolean validFragility(String thing) {
		if (thing.equalsIgnoreCase("F") || thing.equalsIgnoreCase("NF")) {
			return true;
		}
		return false;
	}

	private static boolean validPerishable(String thing) {
		if (thing.equalsIgnoreCase("P") || thing.equalsIgnoreCase("NP")) {
			return true;
		}
		return false;
	}

	private static boolean validUpdate(String splitLine[]) {
		if (splitLine.length != 3) {
			return false;
		}
		if (!validInteger(splitLine[2])) {
			return false;
		}
		if (convertInt(splitLine[2]) < 0) {
			return false;
		}
		return true;
	}

	private static boolean validSearchOrDelete(String splitLine[]) {
		if (splitLine.length != 2) { // assumes there might be an item with a
										// name 555 or something
			return false;
		}
		return true;
	}

	private static boolean validPrint(String splitLine[]) {
		if (splitLine.length != 1) {
			return false;
		}
		return true;
	}

	private static boolean validInteger(String thing) {
		try {
			double convertd = Double.parseDouble(thing);
			if (convertd % 1.0 != 0) {
				return false;
			}
		} catch (Exception e) {
			println("Not a valid integer");
			return false;
		}

		return true;
	}

	private static boolean validDouble(String thing) {
		try {
			double convert = Double.parseDouble(thing);
		} catch (Exception e) {
			println("Not a valid integer");
			return false;
		}
		return true;
	}

	// returns whether or not that number is a valid number, does not care if
	// has decimal points
	private static boolean validNumber(String thing) {
		return validDouble(thing);
	}

	private static boolean validCashNumber(double number) {
		int intNumber = (int) (number * 100);
		if (intNumber == number * 100.0) {
			return true;
		}
		return false;
	}

	private static double convertDouble(String thing) {
		return Double.parseDouble(thing);
	}

	private static int convertInt(String thing) {
		double convertD = 0;
		try {
			convertD = Double.parseDouble(thing);
		} catch (Exception e) {

		}
		return (int) convertD;
	}

	private static void print(String line) {
		System.out.print(line);
	}

	private static void println(String line) {
		System.out.println(line);
	}

}
