package weekThree;

import java.util.Random;

/**
 * A simple demonstration of how to use the MyArrayList class.
 * 
 * @author	Erin Parker
 * @version January 27, 2022
 */
public class MyArrayListDemo {
	
	public static void main(String[] args) {
		
		MyArrayList<String> courses = new MyArrayList<String>();
		courses.add("CS 1410/1420");
		courses.add("CS 2100");
		courses.add("CS 2420");
		courses.add("CS 3130");
		courses.add("CS 3500");
		courses.add("CS 3505");
		courses.add("CS 3810");
		courses.add("CS 4000");
		courses.add("CS 4150");
		courses.add("CS 4400");
		courses.add("CS 4500");
		System.out.println("There are " + courses.getSize() + " core CS courses.");
		
		Random rng = new Random();
		MyArrayList<Integer> randomNumbers = new MyArrayList<Integer>();
		for(int i = 0; i < 100; i++)
			randomNumbers.add(rng.nextInt());
	}
}