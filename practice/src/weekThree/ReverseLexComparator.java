package weekThree;

import java.util.Comparator;

/**
 * Comparator containing a compare method for ordering strings in the 
 * reverse / opposite of lexicographical ordering. 
 * 
 * (Use of this comparator is demonstrated in WarmUp.java.)
 * 
 * @author Erin Parker
 * @version January 25, 2022
 */
public class ReverseLexComparator implements Comparator<String> {
	
	/**
	 * Orders strings in the reverse of lexicographical ordering.
	 * 
	 * @param str1 - the first string
	 * @param str2 - the second string
	 * @return > 0 if str1 comes earlier than str2 lexicographically, < 0 if str2 comes
	 *         earlier, 0 if the strings are the same
	 */
	public int compare(String str1, String str2 ) {
		
		// The strategy is to return the opposite of String's compareTo method,
		// which orders string lexicographically.
		if(str1.compareTo(str2) > 0)
			return -1;
		if(str1.compareTo(str2) < 0)
			return 1;
		return 0;
	}
}