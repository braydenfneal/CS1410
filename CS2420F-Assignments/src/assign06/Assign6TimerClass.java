package assign06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * This class collects running times for methods of LargestNumberSolver.
 * 
 * @author Erin Parker
 * @version February 9, 2021
 */
public class Assign6TimerClass<ListGeneric> extends LinkedListStack<ListGeneric> {
	
	public static void main(String[] args) {
		Random rng = new Random();

		int timesToLoop = 10000;
		
		ArrayList<Integer> intArrayList = new ArrayList<Integer>();
		intArrayList.add(1); intArrayList.add(2); intArrayList.add(3); intArrayList.add(4);
		intArrayList.add(5);
		LinkedList<Integer> intLinkedList = new LinkedList<Integer>();

		
		
		
		int incr = 100;
		for(int probSize = 100; probSize <= 5000; probSize += incr)
		{				
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
				intLinkedList.push(i);
			}

			midpointTime = System.nanoTime();

			// Capture the cost of running the loop and any other operations done
			// above that are not the essential method call being timed.
			for(int i = 0; i < timesToLoop; i++) {
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and searching.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - 
						(stopTime - midpointTime)) / (double) timesToLoop;
			System.out.println(averageTime);
		}
		System.out.println("Push Done");
		for(int probSize = 100; probSize <= 5000; probSize += incr)
		{				
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
				intLinkedList.pop();
			}

			midpointTime = System.nanoTime();

			// Capture the cost of running the loop and any other operations done
			// above that are not the essential method call being timed.
			for(int i = 0; i < timesToLoop; i++) {
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and searching.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - 
						(stopTime - midpointTime)) / (double) timesToLoop;
			System.out.println(averageTime);
		}
		System.out.println("Pop Done");
		for(int probSize = 100; probSize <= 5000; probSize += incr)
		{				
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
				intLinkedList.peek();
			}

			midpointTime = System.nanoTime();

			// Capture the cost of running the loop and any other operations done
			// above that are not the essential method call being timed.
			for(int i = 0; i < timesToLoop; i++) {
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and searching.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - 
						(stopTime - midpointTime)) / (double) timesToLoop;
			System.out.println(averageTime);
		}
		System.out.println("Peek Done");

	}
}