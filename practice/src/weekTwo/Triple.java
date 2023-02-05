package weekTwo;

/**
 * This generic class represents a collection of three, same-type 
 * items; i.e., a triple.
 * 
 * @author Erin Parker and CS 2420 class
 * @version January 20, 2022
 */
public class Triple<Type> {

	private Type item1;
	private Type item2;
	private Type item3;
	
	/**
	 * Construct a new Triple object from the three input items.
	 * 
	 * @param item1
	 * @param item2
	 * @param item3
	 */
	public Triple(Type item1, Type item2, Type item3) {
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
	}
	
	/**
	 * Getter for the first item of the triple
	 * 
	 * @return the first item
	 */
	public Type getFirstItem() {
		return item1;
	}
	
	/**
	 * Getter for the second item of the triple
	 * 
	 * @return the second item
	 */
	public Type getSecondItem() {
		return item2;
	}

	/**
	 * Getter for the third item of the triple
	 * 
	 * @return the third item
	 */
	public Type getThirdItem() {
		return item3;
	}
	
	/**
	 * Generates a textual representation of this Triple object
	 * 
	 * @return a string representing this Triple object
	 */
	public String toString() {
		return "(" + item1 + ", " + item2 + ", " + item3 + ")";
 	}
	
	/**
	 * Setter for the first item of the triple
	 * (Students filled in)
	 * 
	 * @param the first item
	 */
	public void setFirstItem(Type item1) {
		this.item1 = item1;
	}
}