package assign04;

import java.util.ArrayList;
import java.util.Random;

public class AnagramCheckerTimedTest {

		public static String randomString(int n) {
			
			Random r = new Random();
			String s = "";
			
			for (int i = 0; i < n ; i++) {
				s += (char)((r.nextInt() % (122-97+1)+97));
			}
			
			return s;
		}
		
		public static String[] randomStringArray(int n) {
			Random r = new Random();
			int value = r.nextInt(99999);
			String[] arr = new String[value];
			for(int x = value-1; x > 0; x--) {
				arr[x] = "";
			}
			return arr;
		}
	
	public static void main(String[] args) {
		for (int n = 1000; n <= 15000; n += 1000) {
			long startTime, midpointTime, stopTime;

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			startTime = System.nanoTime();
			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Now, run the test.

			long timesToLoop = 1000;

			startTime = System.nanoTime();

			for(long i = 0; i < timesToLoop; i++) {
				String s1 = randomString(n);
				String s2 = randomString(n);
				
				String[] arr = randomStringArray(n);
				
				//AnagramChecker.areAnagrams(s1, s2);
				AnagramChecker.getLargestAnagramGroup(arr);
				
			}
				
			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.

			for(long i = 0; i < timesToLoop; i++) { // empty block
				String s1 = randomString(n);
				String s2 = randomString(n);
				String[] arr = randomStringArray(n);
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.

			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;

			System.out.println(n + "\t" + averageTime);
		}
		}
	}
