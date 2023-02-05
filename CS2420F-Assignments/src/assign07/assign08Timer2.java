package assign07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 * This class collects running times for methods of LargestNumberSolver.
 * 
 * @author Erin Parker
 * @version February 9, 2021
 */
public class assign08Timer2 extends BinarySearchTreeBeta {
	
	public static void main(String[] args) {
		Random rng = new Random();

		int timesToLoop = 10;
		List<Integer> randomList = new ArrayList<>();
		List<Integer> sortedList = new ArrayList<>();
		int incr = 1000;
		Random rand = new Random();
		BinarySearchTreeBeta<Integer> randomTree = new BinarySearchTreeBeta<Integer>();
		BinarySearchTreeBeta<Integer> sortedTree = new BinarySearchTreeBeta<Integer>();
		TreeSet<Integer> treeSetList = new TreeSet<>();
		
		int randomIndex = 0;
		int sortedIndex = 0;
		
		
		for(int probSize = 1000; probSize <= 10000; probSize += incr) 
		{
			for(int g = 0; g < probSize; g++)
			{
				int tempA = rand.nextInt(probSize);
				randomList.add(tempA);
				randomTree.add(tempA);
				//treeSetList.add(tempA);
				randomTree.contains(randomList.get(g));
				//treeSetList.contains(randomList.get(g));

			}
//			for(int n = 0; n < probSize; n ++)
//			{
//				sortedList.add(n);
//				sortedTree.add(n);
//			}
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
				
				for(int l = 0; l < randomList.size(); l ++)
			{
				randomTree.contains(randomList.get(l));
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
			//System.out.println("Random Contains " + probSize + "  " + averageTime);
			System.out.println(averageTime);
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			
			
			long stopTimeA, midpointTimeA, startTimeA = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTimeA = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
				for(int b = 0; b < sortedList.size(); b ++)
				{
					sortedTree.contains(sortedList.get(b));
				}
			}

			midpointTimeA = System.nanoTime();

			// Capture the cost of running the loop and any other operations done
			// above that are not the essential method call being timed.
			for(int i = 0; i < timesToLoop; i++) {
			}

			stopTimeA = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and searching.
			// Average it over the number of runs.
			averageTime = ((midpointTimeA - startTimeA) - 
						(stopTimeA - midpointTimeA)) / (double) timesToLoop;
			//System.out.println("Sorted Contains " + probSize + "  " + averageTime);
			//System.out.println(averageTime);
		}
		
	}
}
