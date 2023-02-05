package assign09;

import java.util.HashMap;
import java.util.Random;

/**
 * Analyzes the number of collisions incurred while doing operations 
 * on a hash table of strings for several different hash functions.  
 * Linear probing is used to resolve collisions.
 * 
 * @author Erin Parker
 * @version October 26, 2020
 */
public class HashTimer<K, V> extends HashTableB<K,V>{

	public static void main(String[] args) {
		
		int incr = 10000;
		for(int probSize = 10000; probSize < 100000; probSize += incr)
		{
		
		// perform the experiment by running 100 times

		// generate random strings
		Random rng = new Random();
		String[] randStrings = new String[probSize];
		
		for(int k = 0; k < randStrings.length; k++) 
			randStrings[k] = generateRandString(rng);
		
		// for every hash function choice: BAD, BETTER, BEST, JAVA ...
//		for(HashTable.HashOption choice : HashTable.HashOption.values()) {

			// create and populate the hash table
			HashMap<Integer, String> strTable = new HashMap<>();
			//strTable.setHashFunction(choice);
			for(String s : randStrings)
				strTable.put(s.hashCode(), s);
			
			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();
			
			// successful hash table searches
			//strTable.resetCollisions();
			for(int i = 0; i < randStrings.length; i++)
				strTable.containsValue(randStrings[i]);
			
			midpointTime = System.nanoTime();
			
			stopTime = System.nanoTime();

//			System.out.println("  Collisions during " + 
//					randStrings.length + " successful searches: " + 
//					strTable.getCollisions() +	" (average of " + 
//					strTable.getCollisions() / (double) randStrings.length + 
//					" per search)");

//			// random and likely unsuccessful hash table searches
//			strTable.resetCollisions();
//			for(int i = 0; i < NUM_RUNS; i++) {
//				strTable.containsValue(generateRandString(rng));
//			}

//			System.out.println("  Collisions during " + randStrings.length + " random searches: " + strTable.getCollisions() + 
//					" (average of " + strTable.getCollisions() / (double) randStrings.length + " per search)\n");
		
		double averageTime = ((midpointTime - startTime) - 
						(stopTime - midpointTime)) / (double) 1;
			System.out.println("Time for " + probSize + " with Bad Random " + averageTime);
		
		}
		System.out.println("");
	
	
	for(int probSize = 10000; probSize < 100000; probSize += incr)
		{
		
		// perform the experiment by running 100 times
//		final int NUM_RUNS = 100;

		// generate random strings
		Random rng = new Random();
		String[] ranStrings = new String[probSize];
		
		for(int k = 0; k < ranStrings.length; k++) 
			ranStrings[k] = generateRandString(rng);
		
		// for every hash function choice: BAD, BETTER, BEST, JAVA ...
//		for(HashTable.HashOption choice : HashTable.HashOption.values()) {

			// create and populate the hash table
			HashMap<Integer, String> ranStrin = new HashMap<>();
			//strTable.setHashFunction(choice);
			for(String s : ranStrings)
				ranStrin.put(s.hashCode(), s);
			
			long stopTimeB, midpointTimeB, startTimeB = System.nanoTime();

			while(System.nanoTime() - startTimeB < 1000000000) { // empty block
			}

			// Collect running times.
			startTimeB = System.nanoTime();

			// successful hash table searches
			//strTable.resetCollisions();
			for(int i = 0; i < ranStrings.length; i++)
				ranStrin.containsValue(ranStrings[i]);
			
			midpointTimeB = System.nanoTime();
			
			stopTimeB = System.nanoTime();

//			System.out.println("  Collisions during " + 
//					randStrings.length + " successful searches: " + 
//					strTable.getCollisions() +	" (average of " + 
//					strTable.getCollisions() / (double) randStrings.length + 
//					" per search)");

//			// random and likely unsuccessful hash table searches
//			strTable.resetCollisions();
//			for(int i = 0; i < NUM_RUNS; i++) {
//				strTable.containsValue(generateRandString(rng));
//			}

//			System.out.println("  Collisions during " + randStrings.length + " random searches: " + strTable.getCollisions() + 
//					" (average of " + strTable.getCollisions() / (double) randStrings.length + " per search)\n");
		
		double averageTimFe = ((midpointTimeB - startTimeB) - 
						(startTimeB - midpointTimeB)) / (double) 1;
			System.out.println("Time for " + probSize + " with Bad Random " + averageTimFe);
		
		
		}
		System.out.println("");
	}
	
	/**
	 * Generate a random string of 1 to 5 lower-case letters.
	 * 
	 * @param rng - a random number generator
	 * @return a random string
	 */
	private static String generateRandString(Random rng) {
		// length range: 1 to 5
		char[] arr = new char[rng.nextInt(5) + 1];  
		
		for(int i = 0; i < arr.length; i++)
			// letter range: 'a' to 'z'
			arr[i] = (char)((int)'a' + rng.nextInt(26));  
		
		return new String(arr);
	}
}