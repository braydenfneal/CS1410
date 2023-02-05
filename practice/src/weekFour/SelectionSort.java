package weekFour;

import java.util.Comparator;

/**
 * This class contains methods for implementing the selection sort algorithm.
 * 
 * @author Erin Parker & CS 2420 class
 * @version February 1, 2022
 */
public class SelectionSort {

	/**
	 * Code taken from the Class Meeting 7 slides for selection sort.
	 * 
	 * NOT GENERIC, works only for primitive type int.
	 * 
	 * @param arr - the array to be sorted
	 */
	public static void sort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int j, minIndex;
			for(j = i + 1, minIndex = i; j < arr.length; j++)  // What does the comma mean?
				if(arr[j] < arr[minIndex])
					minIndex = j;
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	
	// STUDENTS: Write a generic selection sort method.
	// Option 1 -- Enforce that the generic type is Comparable.
	// Option 2 -- Take a second parameter that is a Comparator.
	
	/**
	 * Orders the elements of the input array into ascending order,
	 * using the selection sort method.
	 * 
	 * GENERIC, works only for any reference type that IS-A Comparable.
	 * 
	 * @param arr - the array to be sorted
	 */
	public static <T extends Comparable<? super T>> void sort(T[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int j, minIndex;
			for(j = i + 1, minIndex = i; j < arr.length; j++)
				if(arr[j].compareTo(arr[minIndex]) < 0)
					minIndex = j;
			T temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	
	/**
	 * Orders the elements of the input array into ascending order,
	 * using the selection sort method.
	 * 
	 * GENERIC, works only for any reference type..
	 * 
	 * @param arr - the array to be sorted
	 * @param cmp - Comparator object that defines how to compare elements
	 */
	public static <T> void sort(T[] arr, Comparator <? super T> cmp) {
		for(int i = 0; i < arr.length - 1; i++) {
			int j, minIndex;
			for(j = i + 1, minIndex = i; j < arr.length; j++)
				if(cmp.compare(arr[j], arr[minIndex]) < 0)
					minIndex = j;
			T temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
		
	// FOLLOWUP QUESTIONS:
	//   * How should you test the new sort methods?
	//   * Does the number of iterations for selection sort depend on the input array?
}