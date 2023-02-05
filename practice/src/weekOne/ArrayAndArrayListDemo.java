package weekOne;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class containing static methods for reversing the elements in arrays and ArrayLists.
 * 
 * Terminology: 
 *    "basic array" = the array in Java created and indexed using []
 *    ArrayList = the Java class that encapsulates and hides a basic array, 
 *                using methods for creation, setting, getting, and more
 * 
 * @author Erin Parker and CS 2420 class
 * @version January 13, 2022
 */
public class ArrayAndArrayListDemo {

	/**
	 * Reverses the ordering of items in the given integer array.
	 * 
	 * @param arr - The array to be reversed.
	 */
	public static void reverseArray(int[] arr) {
		for(int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}

	/**
	 * Reverses the ordering of items in the given integer ArrayList.
	 * 
	 * @param arr - The ArrayList to be reversed.
	 */
	public static void reverseArrayList(ArrayList<Integer> list) {
		for (int i = 0; i < list.size()/2; i++) {
			int temp = list.get(i);
			list.set(i, list.get(list.size()-1-i));
			list.set(list.size()-1-i, temp);
		}
	}
	
	public static void main(String[] args) {
		// Is this a good way to TEST our methods? NO!!!!
		
		int lostArray[] = { 4, 8, 15, 16, 23, 42 };
		System.out.println("Basic array: " + Arrays.toString(lostArray));
		reverseArray(lostArray);
		System.out.println("Basic array, reversed: " + Arrays.toString(lostArray));

		ArrayList<Integer> fibonacciArrayList = new ArrayList<Integer>();
		fibonacciArrayList.add(1);
		fibonacciArrayList.add(1);
		fibonacciArrayList.add(2);
		fibonacciArrayList.add(3);
		fibonacciArrayList.add(5);
		fibonacciArrayList.add(8);
		fibonacciArrayList.add(13);
		fibonacciArrayList.add(21);
		System.out.println("ArrayList: " + fibonacciArrayList);
		reverseArrayList(fibonacciArrayList);
		System.out.println("ArrayList, reversed: " + fibonacciArrayList);
	}
}