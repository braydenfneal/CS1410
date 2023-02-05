package assign07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class collects running times for methods of LargestNumberSolver.
 * 
 * @author Erin Parker
 * @version February 9, 2021
 */
public class assign08Timer extends BinarySearchTreeBeta {
	
	public static void main(String[] args) {
		Random rng = new Random();

		int timesToLoop = 1000;
		List<Integer> randomList = new ArrayList<>();
		List<Integer> sortedList = new ArrayList<>();
		int incr = 250;
		Random rand = new Random();
		BinarySearchTreeBeta<Integer> randomTree = new BinarySearchTreeBeta<Integer>();
		BinarySearchTreeBeta<Integer> sortedTree = new BinarySearchTreeBeta<Integer>();
		int randomIndex = 0;
		int sortedIndex = 0;
		
		
		for(int probSize = 2500; probSize <= 10000; probSize += incr) 
		{
			for(int i = 0; i < probSize; i ++)
			{
				randomList.add(rand.nextInt(probSize));
			}
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
				
				for(int x = 0; x < randomList.size(); x ++)
				{
					randomTree.add(randomList.get(x));
					
				}
				randomTree.clear();
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
			//System.out.println("RandomList Insert " + probSize + "  " + averageTime);

		}
		
		for(int probSize = 2500; probSize <= 10000; probSize += incr) 
		{
			for(int i = 0; i < probSize; i ++)
			{
				sortedList.add(i);
			}
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
				sortedTree.clear();
				for(int x = 0; x < sortedList.size(); x ++)
				{
					sortedTree.add(sortedList.get(x));
					
				}
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
			//System.out.println("SortedList Insert " + probSize + "  " + averageTime);
			System.out.println(averageTime);

		}
		
	}
}
