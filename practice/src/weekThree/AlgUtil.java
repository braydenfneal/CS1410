package weekThree;

import java.util.NoSuchElementException;

/**
 * Implements the findMax and findSmallestDiff algorithms described in 
 * Class Meeting 5.
 * 
 * @author Erin Parker
 * @version January 25, 2022
 */
public class AlgUtil {

	/**
	 * Finds the largest item in an array.
	 * 
	 * GENERIC VERSION -- works for any reference type that implements the
	 * Comparable interface
	 * 
	 * @param arr - the input array
	 * @return the largest object in the input generic array
	 * @throws NoSuchElementException
	 *             if the input array does not contain at least one item
	 */
	public static <T extends Comparable<? super T>> T findMax(T[] arr) {
		if(arr.length == 0)
			throw new NoSuchElementException();

		T max = arr[0];
		for(int i = 1; i < arr.length; i++)
			if(arr[i].compareTo(max) > 0)
				max = arr[i];

		return max;
	}
	
	//public static <T> T findMax(T[] arr, Comparator<? super T> cmp) {


	/**
	 * Finds the smallest absolute difference between two integers in an 
	 * array.
	 * 
	 * NON-GENERIC -- works only for type int
	 * 
	 * @param arr - the input array
	 * @return the smallest difference among integers in the input array
	 * @throws NoSuchElementException
	 *             if the input array does not contain at least two items
	 */
	public static int findSmallestDiff(int[] arr) {
		if(arr.length < 2)
			throw new NoSuchElementException();

		int diff = Math.abs(arr[0] - arr[1]);

		for(int i = 0; i < arr.length; i++)
			for(int j = i + 1; j < arr.length; j++)
				if(Math.abs(arr[i] - arr[j]) < diff)
					diff = Math.abs(arr[i] - arr[j]);

		return diff;
	}
}