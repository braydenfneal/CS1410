package weekFour;

import assign03.SimplePriorityQueue;

/**
 * A class containing code from the warm-up problem, intended for 
 * additional experimentation by students.
 * 
 * @author Erin Parker
 * @version February 1, 2022
 */
public class WarmUp {

	public static void main(String[] args) {
		SimplePriorityQueue<String> myPQ = 
				new SimplePriorityQueue<String>((str1, str2) -> str2.compareTo(str1));
		
		myPQ.insert("cat");
		myPQ.insert("dog");
		myPQ.insert("ant");
		myPQ.insert("bird");
		myPQ.insert("elephant");
		System.out.println(myPQ.findMax());
	}
}