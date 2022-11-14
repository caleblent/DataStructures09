package thePackage;

public abstract class Apparel implements Comparable<Apparel> {

	/**
	 * All pieces of apparel should have a color, price, and condition
	 */
	private String color;
	private double price;
	private Condition condition;

	// array of all conditions to check and see if condition exists
	private Condition[] conditions = { Condition.NEW, Condition.GOOD, Condition.POOR, Condition.TRASHED };

	/**
	 * Constructor function for apparel
	 * 
	 * @param color
	 * @param price
	 * @param condition
	 */
	public Apparel(String color, double price, Condition condition) throws IllegalArgumentException {
		this.setColor(color);
		this.setPrice(price);
		this.setCondition(condition);
	}

	/**
	 * Fetches the apparel's color
	 * 
	 * @return color
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * Fetches the apparel's price
	 * 
	 * @return price
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Fetches the apparel's condition
	 * 
	 * @return condition (Condition)
	 */
	public Condition getCondition() {
		return this.condition;
	}

	/**
	 * Fetches the apparel's condition
	 * 
	 * @return condition (String)
	 */
	public String getConditionString() {
		return this.condition.toString();
	}

	/**
	 * Fetches the apparel's condition
	 * 
	 * @return condition (int)
	 */
	public int getConditionInt() {
		return this.condition.toInt();
	}

	/**
	 * Sets the apparel's color to the String value passed into it
	 * 
	 * @param color
	 */
	public void setColor(String color) throws IllegalArgumentException {
		if (color == null || color.isBlank())
			throw new IllegalArgumentException("Color cannot be null or empty");
		else
			this.color = color;
	}

	/**
	 * Sets the apparel's price to the int value passed into it
	 * 
	 * @param price
	 */
	public void setPrice(double price) throws IllegalArgumentException {
		if (price < 0)
			throw new IllegalArgumentException("Price cannot be negative");
		else
			this.price = price;
	}

	/**
	 * Sets the apparel's condition to the Condition value passed into it
	 * 
	 * @param condition
	 */
	public void setCondition(Condition condition) throws IllegalArgumentException {
		if (condition == null)
			throw new IllegalArgumentException("Condition cannot be null");
		for (int i = 0; i < this.conditions.length; i++) {
			if (conditions[i].toString().equals(condition.toString())) {
				this.condition = condition;
				return;
			}
		}
		throw new IllegalArgumentException("Condition inputted does not exist");
	}

	/**
	 * Converts the apparel object into an English readable sentence.
	 * 
	 * @return String
	 */
	public String toString() {
		String str = "";

		str += "This " + this.getColor() + " apparel cost $" + this.getPrice() + " and is in " + this.getCondition()
				+ " condition.";

		return str;
	}

	/**
	 * Converts the apparel object into what would be its JavaScript Object Notation
	 * (JSON) equivalent.
	 * 
	 * @return String
	 */
	public String toStringJSON() {
		String ret = "";
		ret += "Apparel : { \n    ";
		ret += "Color : " + this.color + "\n    ";
		ret += "Price : $" + this.price + "\n    ";
		ret += "Condition : " + this.condition.toString();
		ret += "\n}";
		return ret;
	}

	/**
	 * Prints the result from toString()
	 */
	public void print() {
		System.out.println(this.toString());
	}

	/**
	 * Prints the result from toStringJSON()
	 */
	public void printJSON() {
		System.out.println(this.toStringJSON());
	}

	/**
	 * 
	 */
	@Override
	public int compareTo(Apparel other) {
		if (this.getCondition().equals(other.getCondition())) {
			// TODO evaluate based on price; low prices before high prices
			return (int) (this.getPrice() - other.getPrice());
		} else {
			// TODO evaluate based on condition
			return this.getConditionInt() - other.getConditionInt();
		}
	}

	// CONVERSION CHART (Condition - Number)
//  NEW = 3
//  GOOD = 2
//  POOR = 1
//  TRASHED = 0

	public enum Condition {
		NEW("new"), GOOD("good"), POOR("poor"), TRASHED("trashed");

		private final String mCond;

		Condition(String cond) {
			mCond = cond;
		}

		public String toString() {
			return mCond;
		}

		/**
		 * Converts the given condition to its numeric equivalent (Refer to conversion
		 * chart at top of file)
		 * 
		 * @param num
		 * @return Condition (that correlates to the number provided)
		 * @throws IllegalArgumentException
		 */
		public int toInt() {
			if (mCond.equals("new"))
				return 3;
			else if (mCond.equals("good"))
				return 2;
			else if (mCond.equals("poor"))
				return 1;
			else if (mCond.equals("trashed"))
				return 0;
			else // indicates something went wrong
				return -1;
		}

		/**
		 * Accepts an integer from 0 to 3 (inclusive) and returns the Condition
		 * equivalent (Refer to conversion chart at top of file)
		 * 
		 * @param num
		 * @return Condition (that correlates to the number provided)
		 * @throws IllegalArgumentException
		 */
		public static Condition intToCondition(int num) throws IllegalArgumentException {
			if (num == 3)
				return Condition.NEW;
			else if (num == 2)
				return Condition.GOOD;
			else if (num == 1)
				return Condition.POOR;
			else if (num == 0)
				return Condition.TRASHED;
			else
				throw new IllegalArgumentException("Integer supplied must be 0, 1, 2, or 3");
		}
	}
}