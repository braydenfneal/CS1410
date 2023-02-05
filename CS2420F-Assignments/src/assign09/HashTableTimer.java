package assign09;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class HashTableTimer<K,V> extends HashTableB<K,V>  {
	 
	/**
	 * Generate a random string of 1 to 5 lower-case letters.
	 * 
	 * @param rng - a random number generator
	 * @return a random string
	 */
	private static StudentBadHash generateRandBadStudent(Random rng) {
		// length range: 1 to 5
		String first = null;
		String last = null;
		int uid = 0;
		
		//String arr = new String[rng.nextInt(5) + 1];  
		
		for(int i = 0; i < (rng.nextInt(5) + 1); i++)
			// letter range: 'a' to 'z'
			first += (char)((int)'a' + rng.nextInt(26));  
		for(int i = 0; i < (rng.nextInt(5) + 1); i++)
			// letter range: 'a' to 'z'
			last += (char)((int)'a' + rng.nextInt(26));  
		for(int i = 0; i < (rng.nextInt(5) + 1); i++)
			// letter range: 'a' to 'z'
			uid += 1000000 * rng.nextInt(26) % 9999999;  
		
		return new StudentBadHash(uid, first, last);
	}
	
	private static StudentMediumHash generateRandMediumStudent(Random rng) {
		// length range: 1 to 5
		String first = null;
		String last = null;
		int uid = 0;
		
		//String arr = new String[rng.nextInt(5) + 1];  
		
		for(int i = 0; i < (rng.nextInt(5) + 1); i++)
			// letter range: 'a' to 'z'
			first += (char)((int)'a' + rng.nextInt(26));  
		for(int i = 0; i < (rng.nextInt(5) + 1); i++)
			// letter range: 'a' to 'z'
			last += (char)((int)'a' + rng.nextInt(26));  
		for(int i = 0; i < (rng.nextInt(5) + 1); i++)
			// letter range: 'a' to 'z'
			uid += 1000000 * rng.nextInt(26) % 9999999;  
		
		return new StudentMediumHash(uid, first, last);
	}
	
	private static StudentGoodHash generateRandGoodStudent(Random rng) {
		// length range: 1 to 5
		String first = null;
		String last = null;
		int uid = 0;
		
		//String arr = new String[rng.nextInt(5) + 1];  
		
		for(int i = 0; i < (rng.nextInt(5) + 1); i++)
			// letter range: 'a' to 'z'
			first += (char)((int)'a' + rng.nextInt(26));  
		for(int i = 0; i < (rng.nextInt(5) + 1); i++)
			// letter range: 'a' to 'z'
			last += (char)((int)'a' + rng.nextInt(26));  
		for(int i = 0; i < (rng.nextInt(5) + 1); i++)
			// letter range: 'a' to 'z'
			uid += 1000000 * rng.nextInt(26) % 9999999;  
		
		return new StudentGoodHash(uid, first, last);
	}
	
	
	public static void main(String[] args) {
		
		// perform the experiment by running 100 times
		//final int NUM_RUNS = 100;
		int incr = 10000;
		System.out.println("Results for StudentBadHash hash function (hash table capacity = " + 
					20 + ")");
		for(int problemSize = 10000; problemSize < 100000; problemSize+= incr) {
		// generate random strings
		Random rng = new Random();
		StudentBadHash[] randStudents = new StudentBadHash[problemSize];
		
		for(int k = 0; k < randStudents.length; k++) 
			randStudents[k] = generateRandBadStudent(rng);
		
//		for(StudentBadHash choice : randStudents) {

			// create and populate the hash table
			HashTableB<Integer, StudentBadHash> hashTable = new HashTableB<Integer, StudentBadHash>();
			
			//hashTable.setHashFunction(choice);
			int number = 0;
			for(StudentBadHash s : randStudents)
			{
				hashTable.put(s.hashCode(), s);
				number++;
			}
			
			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();

			// successful hash table searches
			hashTable.resetCollisions();
			for(int i = 0; i < randStudents.length; i++)
				hashTable.containsValue(randStudents[i]);
			
			midpointTime = System.nanoTime();
			
			stopTime = System.nanoTime();

			System.out.println("  Collisions during " + 
					randStudents.length + " successful searches: " + 
					hashTable.getCollisions() +	" (average of " + 
					hashTable.getCollisions() / (double) randStudents.length + 
					" per search)");
			
			double averageTime = ((midpointTime - startTime) - 
						(stopTime - midpointTime)) / (double) 1;
			System.out.println("Time for " + problemSize + " with Bad Random " + averageTime);

			long stopTimeB, midpointTimeB, startTimeB = System.nanoTime();

			
			while(System.nanoTime() - startTimeB < 1000000000) { // empty block
			}
			
			//Collect running times.
			startTimeB = System.nanoTime();
			
			// random and likely unsuccessful hash table searches
			hashTable.resetCollisions();
			for(int i = 0; i < problemSize; i++) {
				hashTable.containsValue(generateRandBadStudent(rng));
			}
			
			midpointTimeB = System.nanoTime();
			
			stopTimeB = System.nanoTime();

			System.out.println("  Collisions during " + randStudents.length + " random searches: " + hashTable.getCollisions() + 
					" (average of " + hashTable.getCollisions() / (double) randStudents.length + " per search)");
		
		averageTime = ((midpointTimeB - startTimeB) - 
						(stopTimeB - midpointTimeB)) / (double) 1;
			System.out.println("Time for " + problemSize + " with Bad Successful " + averageTime);

		}	
	System.out.println("");
	
	//-------------------------------------------------------------
	
	// perform the experiment by running 100 times
		//final int NUM_RUNS = 100;
		incr = 10000;
		System.out.println("Results for StudentMediumHash hash function (hash table capacity = " + 
					20 + ")");
		for(int problemSize = 10000; problemSize < 100000; problemSize+= incr) {
		// generate random strings
		Random rng = new Random();
		StudentMediumHash[] randStudents = new StudentMediumHash[problemSize];
		
		for(int k = 0; k < randStudents.length; k++) 
			randStudents[k] = generateRandMediumStudent(rng);
		
//		for(StudentBadHash choice : randStudents) {

			// create and populate the hash table
			HashTableB<Integer, StudentMediumHash> hashTable = new HashTableB<Integer, StudentMediumHash>();
			
			//hashTable.setHashFunction(choice);
			int number = 0;
			for(StudentMediumHash s : randStudents)
			{
				hashTable.put(s.hashCode(), s);
				number++;
			}
			
			long stopTimeB, midpointTimeB, startTimeB = System.nanoTime();

			
			while(System.nanoTime() - startTimeB < 1000000000) { // empty block
			}

			//Collect running times.
			startTimeB = System.nanoTime();
			
			// successful hash table searches
			hashTable.resetCollisions();
			for(int i = 0; i < randStudents.length; i++)
				hashTable.containsValue(randStudents[i]);
			
			midpointTimeB = System.nanoTime();
			
			stopTimeB = System.nanoTime();

			System.out.println("  Collisions during " + 
					randStudents.length + " successful searches: " + 
					hashTable.getCollisions() +	" (average of " + 
					hashTable.getCollisions() / (double) randStudents.length + 
					" per search)");
			
			double averageTime = ((midpointTimeB - startTimeB) - 
						(stopTimeB - midpointTimeB)) / (double) 1;
			System.out.println("Time for " + problemSize + " with Medium Random " + averageTime);

		long stopTime, midpointTime, startTime = System.nanoTime();

			
			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}
			
			startTime = System.nanoTime();

			// random and likely unsuccessful hash table searches
			hashTable.resetCollisions();
			for(int i = 0; i < problemSize; i++) {
				hashTable.containsValue(generateRandMediumStudent(rng));
			}

			midpointTime = System.nanoTime();
			
			stopTime = System.nanoTime();
			
			System.out.println("  Collisions during " + randStudents.length + " random searches: " + hashTable.getCollisions() + 
					" (average of " + hashTable.getCollisions() / (double) randStudents.length + " per search)");
		
		averageTime = ((midpointTime - startTime) - 
						(stopTime - midpointTime)) / (double) 1;
			System.out.println("Time for " + problemSize + " with Medium Successful " + averageTime);

		
		}	
	System.out.println("");
	
	//------------------------------------------------------
	
	// perform the experiment by running 100 times
		//final int NUM_RUNS = 100;
		incr = 10000;
		System.out.println("Results for StudentGoodHash hash function (hash table capacity = " + 
					20 + ")");
		for(int problemSize = 10000; problemSize < 100000; problemSize+= incr) {
		// generate random strings
		Random rng = new Random();
		StudentGoodHash[] randStudents = new StudentGoodHash[problemSize];
		
		for(int k = 0; k < randStudents.length; k++) 
			randStudents[k] = generateRandGoodStudent(rng);
		
//		for(StudentBadHash choice : randStudents) {

			// create and populate the hash table
			HashTableB<Integer, StudentGoodHash> hashTable = new HashTableB<Integer, StudentGoodHash>();
			
			//hashTable.setHashFunction(choice);
			int number = 0;
			for(StudentGoodHash s : randStudents)
			{
				hashTable.put(s.hashCode(), s);
				number++;
			}
			
			long stopTime, midpointTime, startTime = System.nanoTime();

			
			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			startTime = System.nanoTime();
			
			// successful hash table searches
			hashTable.resetCollisions();
			for(int i = 0; i < randStudents.length; i++)
				hashTable.containsValue(randStudents[i]);
			
			midpointTime = System.nanoTime();
			
			stopTime = System.nanoTime();

			System.out.println("  Collisions during " + 
					randStudents.length + " successful searches: " + 
					hashTable.getCollisions() +	" (average of " + 
					hashTable.getCollisions() / (double) randStudents.length + 
					" per search)");
			
				double averageTime = ((midpointTime - startTime) - 
						(stopTime - midpointTime)) / (double) 1;
			System.out.println("Time for " + problemSize + " with Good Random " + averageTime);

			long stopTime1, midpointTime1, startTime1 = System.nanoTime();

			
			while(System.nanoTime() - startTime1 < 1000000000) { // empty block
			}

			startTime1 = System.nanoTime();
			
			// random and likely unsuccessful hash table searches
			hashTable.resetCollisions();
			for(int i = 0; i < problemSize; i++) {
				hashTable.containsValue(generateRandGoodStudent(rng));
			}

			midpointTime1 = System.nanoTime();
			
			stopTime1 = System.nanoTime();
			
			System.out.println("  Collisions during " + randStudents.length + " random searches: " + hashTable.getCollisions() + 
					" (average of " + hashTable.getCollisions() / (double) randStudents.length + " per search)");
		
			averageTime = ((midpointTime1 - startTime1) - 
						(stopTime1 - midpointTime1)) / (double) 1;
			System.out.println("Time for " + problemSize + " with Good Successful " + averageTime);

		
		}	
	System.out.println("");
	
	
	}
	
		//}
	
}