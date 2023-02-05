package weekThree;

/**
 * A class containing code from the warm-up problem, intended for 
 * additional experimentation by students.
 * 
 * @author Erin Parker
 * @version January 27, 2022
 */
public class WarmUp {
	
	/**
	 * Indicates whether a given array contains a specific item (also given).
	 * 
	 * @param arr - array of elements to be searched
	 * @param item - item to be searched for
	 * @return true if the array contains an element equal to the item, false otherwise
	 */
	public static <T> boolean contains(T[] arr, T item) {
		for(T elt : arr) 
			if(elt.equals(item))
				return true;
		return false;
	}

	public static void main(String[] args) {
		String[] states = new String[] { "Maine", "Alabama", "Utah", "Nevada", 
				"Virginia", "Oregon", "Texas", "Alaska", "Florida", "North Carolina" };

		System.out.println(contains(states, "Utah"));
		System.out.println(contains(states, "utah"));
		
		Integer[] numbers = { 1, 2, -5, 8, -9 };
		System.out.println(contains(numbers, -9));
		System.out.println(contains(numbers, 3));
	}
}