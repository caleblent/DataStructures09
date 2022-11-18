package thePackage;

public class Shirt extends Apparel {

	/**
	 * All shirts should have a size, in addition to the attributes all apparel have
	 * (color, price, condition). Some may have text on the shirt as well.
	 */
	private String shirtText = "";
	private Size size;

	// array of all sizes to check and see if size exists
	private Size[] sizes = { Size.XL, Size.L, Size.M, Size.S };

	/**
	 * Constructor function for shirt WITHOUT shirt text
	 * 
	 * @param color
	 * @param price
	 * @param condition
	 * @param size
	 */
	public Shirt(String color, double price, Condition condition, Size size) {
		super(color, price, condition);
		this.setSize(size);
		this.setShirtText(color);
	}
	public Shirt(String color, double price, Condition condition, String size) {
		super(color, price, condition);
		this.setSize(size);
		this.setShirtText(color);
	}

	/**
	 * Constructor function for shirt WITH shirt text
	 * 
	 * @param color
	 * @param price
	 * @param condition
	 * @param size
	 * @param shirtText
	 */
	public Shirt(String color, double price, Condition condition, Size size, String shirtText) {
		super(color, price, condition);
		this.setSize(size);
		this.setShirtText(shirtText);
	}
	public Shirt(String color, double price, Condition condition, String size, String shirtText) {
		super(color, price, condition);
		this.setSize(size);
		this.setShirtText(shirtText);
	}

	/**
	 * Fetches the shirt's size
	 * 
	 * @return size (Size)
	 */
	public Size getSize() {
		return this.size;
	}

	/**
	 * Fetches the shirt's size
	 * 
	 * @return size (String)
	 */
	public String getSizeString() {
		return this.size.toString();
	}

	/**
	 * Fetches the shirt's text
	 * 
	 * @return shirtText
	 */
	public String getShirtText() {
		return this.shirtText;
	}

	/**
	 * Sets the shirt's size to the Size value passed to it
	 * 
	 * @param size
	 */
	public void setSize(Size size) throws IllegalArgumentException {
		if (size == null)
			throw new IllegalArgumentException("Size cannot be null");
		for (int i = 0; i < this.sizes.length; i++) {
			if (sizes[i].toString().equals(size.toString())) {
				this.size = size;
				return;
			}
		}
		throw new IllegalArgumentException("Size inputted does not exist");
	}
	
	public void setSize(String size) throws IllegalArgumentException {
		if (size == null)
			throw new IllegalArgumentException("Size cannot be null");
		for (int i = 0; i < this.sizes.length; i++) {
			if (sizes[i].toString().equals(size.toString())) {
				this.size = sizes[i];
				return;
			}
		}
		throw new IllegalArgumentException("Size inputted does not exist");
	}

	/**
	 * Sets the shirt's text to the String value passed to it
	 * 
	 * @param shirtText
	 */
	public void setShirtText(String shirtText) {
		if (shirtText == null)
			this.shirtText = "";
		else
			this.shirtText = shirtText;
	}

	/**
	 * Converts the shirt object into an English readable sentence.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		String str = "";

		str += "This size " + this.size.toString() + " " + this.getColor() + " shirt cost $" + this.getPrice()
				+ " and is in " + this.getCondition() + " condition.";

		if (!this.shirtText.equals("")) {
			str += " It contains the text \"" + this.shirtText + "\".";
		}

		return str;
	}

	/**
	 * Converts the shirt object into what would be its JavaScript Object Notation
	 * (JSON) equivalent.
	 * 
	 * @return String
	 */
	@Override
	public String toStringJSON() {
		String ret = "";
		ret += "Shirt : { \n    ";
		ret += "Color : " + this.getColor() + "\n    ";
		ret += "Price : $" + this.getPrice() + "\n    ";
		ret += "Condition : " + this.getCondition() + "\n    ";
		ret += "Size : " + this.size;
		if (!this.shirtText.equals("")) {
			ret += "\n    Shirt Text : " + this.shirtText;
		}
		ret += "\n}";
		return ret;
	}

	// CONVERSION CHART (Size - Number)
	// XL= 3
	// L = 2
	// M = 1
	// S = 0

	public enum Size {
		XL("XL"), L("L"), M("M"), S("S");

		private final String mCond;

		Size(String cond) {
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
			if (mCond.equals("XL"))
				return 3;
			else if (mCond.equals("L"))
				return 2;
			else if (mCond.equals("M"))
				return 1;
			else if (mCond.equals("S"))
				return 0;
			else // indicates something went wrong
				return -1;
		}

		/**
		 * Accepts an integer from 0 to 3 (inclusive) and returns the Size equivalent
		 * (Refer to conversion chart at top of file)
		 * 
		 * @param num
		 * @return Size (that correlates to the number provided)
		 * @throws IllegalArgumentException
		 */
		public static Size intToSize(int num) throws IllegalArgumentException {
			if (num == 3)
				return Size.XL;
			else if (num == 2)
				return Size.L;
			else if (num == 1)
				return Size.M;
			else if (num == 0)
				return Size.S;
			else
				throw new IllegalArgumentException("Integer supplied must be 0, 1, 2, or 3");
		}
	}
}
