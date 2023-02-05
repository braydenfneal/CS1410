package weekFour;

import java.util.Arrays;
import java.util.Random;

/**
 * A class containing code from the warm-up problem, intended for 
 * additional experimentation by students.
 * 
 * @author Erin Parker
 * @version February 3, 2022
 */
public class WarmUp2 {
	
	public static void shuffle(int[] arr) {
		Random rng = new Random();
		
		for(int i = 0; i < arr.length; i++) {
			int randIndex = rng.nextInt(arr.length);
			int temp = arr[i];
			arr[i] = arr[randIndex];
			arr[randIndex] = temp;
		}
	}
	
	// Should the shuffle method be generic?
	
	public static void main(String[] args) {
		int[] values = new int[1000];
		for(int i = 0; i < values.length; i++)
			values[i] = i + 1;
		
		shuffle(values);
		
		System.out.println(Arrays.toString(values));
	}
}