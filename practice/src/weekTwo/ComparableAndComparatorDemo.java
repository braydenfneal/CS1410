package weekTwo;

import java.util.Arrays;

/**
 * This class contains examples of using Comparable and Comparator to order strings.
 * 
 * RECALL the semantics of Comparable:
 *   If obj1.compareTo(obj2) returns a positive integer, obj1 is "larger" than obj2.
 *   If obj1.compareTo(obj2) returns a negative integer, obj1 is "smaller" than obj2.
 *   If obj1.compareTo(obj2) returns zero, obj1 is "equal" to obj2.
 * Comparator's compare(obj1, obj2) uses the same semantics.
 * 
 * @author Erin Parker
 * @version January 20, 2022
 */
public class ComparableAndComparatorDemo {

	public static void main(String[] args) {
		
		String[] states = new String[] { "Maine", "Alabama", "Utah", "Nevada", 
				"Virginia", "Oregon", "Texas", "Alaska", "Florida", "North Carolina" };
		
		// In what order does this method call arrange the states?
		Arrays.sort(states); 
		
		System.out.println(Arrays.toString(states));
		
		// In what order does this method call arrange the states?
		Arrays.sort(states, (str1, str2) -> str1.length() - str2.length()); 
		
		System.out.println(Arrays.toString(states));
		
		// In what order does this method call arrange the states?
		Arrays.sort(states, (str1, str2) -> str2.length() - str1.length()); 
		
		System.out.println(Arrays.toString(states));

		// This method call uses an instance of OrderByLastLetter (a Comparator)
		// to order the states.  How could we rewrite using the same kind of 
		// shortcut used above?
		Arrays.sort(states, new OrderByLastLetter());
		
		// Lambda-expression version does the same as above.
		//Arrays.sort(states, (str1, str2) -> str1.charAt(str1.length() - 1) - str2.charAt(str2.length() - 1));
		
		System.out.println(Arrays.toString(states));
	}
}