package weekThree;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class contains an example of a generic method.
 * 
 * @author Erin Parker and CS 2420 class
 * @version January 25, 2022
 */
public class GenericMethodDemo {

	/**
	 * Reverses the ordering of items in the given basic array.
	 * RECALL this method from the Week 1.
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
	
	// TO DO -- Create generic version of reverseArray.
	public static <T> void reverseArray(T[] arr) {
		for(int i = 0; i < arr.length / 2; i++) {
			T temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}	
	
	/**
	 * Reverses the ordering of items in the given basic array.
	 * RECALL this method from the Week 1.
	 * 
	 * @param arr - The array to be reversed.
	 */
	/*public static void reverseArrayList(ArrayList<Integer> list) {
		for(int i = 0; i < list.size() / 2; i++) {
			int temp = list.get(i);
			list.set(i, list.get(list.size() - i - 1));
			list.set(list.size() - i - 1, temp);
		}
	}*/
	
	// STUDENTS: Create generic version of reverseArrayList.
	public static <T> void reverseArrayList(ArrayList<T> list) {
		for(int i = 0; i < list.size() / 2; i++) {
			T temp = list.get(i);
			list.set(i, list.get(list.size() - i - 1));
			list.set(list.size() - i - 1, temp);
		}
	}
	
	public static void main(String[] args) {
		
		// STUDENTS: Add code to demonstrate execution of both methods.
		String[] names = new String[] {"Joseph", "Chris", "Kirby", "Sora", "Jaden"};
		reverseArray(names);
		
		System.out.println(Arrays.toString(names));
		
		ArrayList<Color> tones = new ArrayList<Color>();
		tones.add(Color.RED);
		tones.add(Color.BLUE);
		tones.add(Color.GREEN);
		reverseArrayList(tones);
		System.out.println(tones);
	}
}