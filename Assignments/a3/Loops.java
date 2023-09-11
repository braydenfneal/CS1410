package a3;

//"CS1410 Assifnment 3: ForLoops-Sound by Brayden Neal"
import java.util.Arrays;

public class Loops {

	/* The array parameter has every element in the original array set to 0.
	 * 
	 * @param elements an integer []
	 * 
	 * @return is all the elements in the array turned to zero
	 * 
	 */
	public static void clearArray(int[] elements) {
		for (int i = 0; i < elements.length; i++) {
			elements[i] = 0;
		}
	}

	/*
	 * The return String should start with a curly brace, {, 
	 * then have all the numbers in the array with a comma and s
	 * pace between numbers, and then end with an end curly brace, }.
	 * 
	 * @param elements an integer[]
	 * @return the elements, starting and ending with a curly brace, "{, }"
	 * 
	 */
	public static String arrayToString(int[] elements) {
		String returnVar = "{";
		for (int index = 0; index < elements.length; index++) {
			if (index == elements.length - 1) {
				returnVar = returnVar + elements[index] + ("}");
			} else {
				returnVar = returnVar + elements[index] + (", ");
			}
		}
		return returnVar;
	}
	
	/*
	 * A boolean value true if the number of even numbers in the array 
	 * is greater than the number of odd numbers and false otherwise.
	 * 
	 * @param elements an integer[]
	 * @return true or false, depending on if there are more even or odd numbers
	 * 
	 */
	public static boolean hasMoreEvenThanOdd(int[] elements) {
		int even = 0;
		int odd = 0;
		for (int items : elements) {
			if (items % 2 == 0) {
				even = even + 1;
			} else {
				odd = odd + 1;
			}
		}
		if (even > odd) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * Returns a new double[] that has its elements in reversed order
	 * from the parameter array.
	 * @param elements a double[]
	 * @return the elements in reverse order
	 */
	public static double[] reverseArray(double[] elements) {
		double[] array44 = new double[elements.length];
		for (int index = 0; index < elements.length; index++) {
			array44[elements.length - index - 1] = elements[0 + index];
		}
		return array44;

	}
	/*
	 *  Returns a new double[] that has as its elements a sliding average 
	 *  of the parameter array elements.
	 *  @param elements a double[]
	 *  @return the average of the first and last elements of the new array, and the average
	 *  of the first two and last elements of the parameter array.
	 */
	public static double[] smoothArray(double[] elements) {
		double[] array55 = new double[elements.length];
		array55[0] = (elements[0] + elements[1]) / 2;
		array55[elements.length - 1] = (elements[elements.length - 1] + elements[elements.length - 2]) / 2;
		for (int index = 1; index < elements.length - 1; index++) {

			array55[index] = (elements[index - 1] + elements[index] + elements[index + 1]) / 3;

		}
		return array55;
	}
	
	public static void main(String[] args) {
		int[] array1 = { 1, 2, 5, 7 };
		int[] array1b = { 2, 8, 3, 6 };
		int[] array1c = { 1, 55};
		
		int[] array2 = { 1, 2 };
		int[] array2b = { 2, 7, 9 };
		int[] array2c = { 5, 10};
		
		int[] array3 = { 2, 4, 5, 9, 11 };
		int[] array3b = { 2, 7, 9 };
		int[] array3c = { 1, 2, 6};
		
		double[] array4 = { 0.1, 0.2, 0.3, 0.5 };
		double[] array4b = { 11.17, 5.5, 6.09 };
		double[] array4c = { 0.2, 4.1 };
		
		double[] array5 = { 0.0, 0.2, 0.7, 0.2 };
		double[] array5b = { 0.2, 0.6, 0.8, 0.4 };
		double[] array5c = { 0.3, 0.12, 0.11, 0.2 };
		
		clearArray(array1);
		clearArray(array1b);
		clearArray(array1c);
		
		arrayToString(array2);
		arrayToString(array2b);
		arrayToString(array2c);

		System.out.println("clearArray(array1) = { 1, 2, 5, 7 } is " + (arrayToString(array1)));
		System.out.println("clearArray(array1b) = { 2, 8, 3, 6 } is " + (arrayToString(array1b)));
		System.out.println("clearArray(array1c) = {1, 55} is " + (arrayToString(array1c)));
		
		System.out.println("arrayToString(array2) = {1, 55} is " + (arrayToString(array2)));
		System.out.println("arrayToString(array2b) = { 2, 7, 9 } is " + (arrayToString(array2b)));
		System.out.println("arrayToString(array2c) = {5, 10} is " + (arrayToString(array2c)));

		System.out.println("hasMoreEvenThanOdd(array3) = { 2, 4, 5, 9, 11 } is " + hasMoreEvenThanOdd(array3));
		System.out.println("hasMoreEvenThanOdd(array3b) = {1, 1} is " + hasMoreEvenThanOdd(array3b));
		System.out.println("hasMoreEvenThanOdd(array3c) = {1, 2, 6} is " + hasMoreEvenThanOdd(array3c));
		
		System.out.println("reverseArray(array4) = { 2, 4, 5, 9, 11 } is " + (Arrays.toString(reverseArray(array4))));
		System.out.println("reverseArray(array4b) = { 11.17, 5.5, 6.09 } is " + (Arrays.toString(reverseArray(array4b))));
		System.out.println("reverseArray(array4c) = { 0.2, 4.1 } is " + (Arrays.toString(reverseArray(array4c))));
		
		System.out.println("smoothArray(array5) = { 0.0, 0.2, 0.7, 0.2 } is " + (Arrays.toString(smoothArray(array5))));
		System.out.println("smoothArray(array5b) = { 0.2, 0.6, 0.8, 0.4 } is " + (Arrays.toString(smoothArray(array5b))));
		System.out.println("smoothArray(array5c) = { 0.3, 0.12, 0.11, 0.2 } is " + (Arrays.toString(smoothArray(array5c))));

	}

}
