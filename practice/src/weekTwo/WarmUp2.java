package weekTwo;

import java.util.ArrayList;

/**
 * A class containing code from the warm-up problem, intended for 
 * additional experimentation by students.
 * 
 * @author Erin Parker
 * @version January 20, 2022
 */
public class WarmUp2 {
	
	public static void main(String[] args) {
		// Why can't we write ArrayList<int> primes?
		ArrayList<Integer> primes = new ArrayList<Integer>();  
		primes.add(2);   
		primes.add(3);
		primes.add(5);
		primes.add(7);
		primes.add(11);
		primes.add(13);
		// The value 13 has type int (not Integer).  Why does this work?
	}
}