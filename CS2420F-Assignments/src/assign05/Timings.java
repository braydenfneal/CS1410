package assign05;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
/**
 * Timing experiments for all graph data
 * @author Brayden N
 *
 */

public class Timings {
	/**
	 * Timing experiments
	 */
	private static final int timesToLoop = 10000;

	/**
	 * Uses merge sort on a random array of N with a threshold of 1
	 * Doesn't use insertion sort at all because of threshold
	 */
	
	@Test
	public void runTimeMergeSortThresholdAtOne() {


	
			Random random = new Random();
			for (int n = 1000; n <= 10000; n += 1000) {
				

				// Do the experiment multiple times, and average out the results
				long totalTime = 0;
				random.setSeed(1234);
				for (int iter = 0; iter <= timesToLoop; iter++) {
						ArrayList<Integer> array = new ArrayList<Integer>();
						for(int index = 0; index < n; index++) {
							array.add(random.nextInt());
					}
				ArrayListSorter.changeThreshold(1);
					// TIME IT!
					long start = System.nanoTime();
					ArrayListSorter.mergesort(array);
					long stop = System.nanoTime();
					totalTime += stop - start;
					
				}
				double averageTime = (totalTime / (double) timesToLoop);
				System.out.println(n + "\t" + averageTime); // write to file.
				
			}		
		System.out.println("SingleDone");

	}

	/**
	 * Timing experiment for mergeSort with threshold of 5 before it starts using insertion sort
	 */
	@Test
	public void runTimeMergeSortThresholdFifteen() {

		Random random = new Random();
		for (int n = 1000; n <= 10000; n += 1000) {
			

			// Do the experiment multiple times, and average out the results
			long totalTime = 0;
			random.setSeed(1234);
			for (int iter = 0; iter <= timesToLoop; iter++) {
					ArrayList<Integer> array = new ArrayList<Integer>();
					for(int index = 0; index < n; index++) {
						array.add(random.nextInt());
				}
			ArrayListSorter.changeThreshold(15);
				// TIME IT!
				long start = System.nanoTime();
				ArrayListSorter.mergesort(array);
				long stop = System.nanoTime();
				totalTime += stop - start;
				
			}
			double averageTime = (totalTime / (double) timesToLoop);
			System.out.println(averageTime); // write to file.
			
		}		
	System.out.println("fifteenDone");
	}
	/**
	 * Timing experiment for mergeSort with threshold of 15 before it starts using insertion sort
	 */
	@Test
	public void runTimeMergeSortThresholdThirty() {

		Random random = new Random();
		for (int n = 1000; n <= 10000; n += 1000) {
			

			// Do the experiment multiple times, and average out the results
			long totalTime = 0;
			random.setSeed(1234);
			for (int iter = 0; iter <= timesToLoop; iter++) {
					ArrayList<Integer> array = new ArrayList<Integer>();
					for(int index = 0; index < n; index++) {
						array.add(random.nextInt());
				}
			ArrayListSorter.changeThreshold(30);
				// TIME IT!
				long start = System.nanoTime();
				ArrayListSorter.mergesort(array);
				long stop = System.nanoTime();
				totalTime += stop - start;
				
			}
			double averageTime = (totalTime / (double) timesToLoop);
			System.out.println(averageTime); // write to file.
			
		}		
	System.out.println("ThirtyDone");
	}
	
	/**
	 * Timing experiment for mergeSort with threshold of 30 before it starts using insertion sort
	 */
	@Test
	public void runTimeMergeSortThresholdFifty() {
		Random random = new Random();
		for (int n = 1000; n <= 10000; n += 1000) {
			

			// Do the experiment multiple times, and average out the results
			long totalTime = 0;
			random.setSeed(1234);
			for (int iter = 0; iter <= timesToLoop; iter++) {
					ArrayList<Integer> array = new ArrayList<Integer>();
					for(int index = 0; index < n; index++) {
						array.add(random.nextInt());
				}
			ArrayListSorter.changeThreshold(50);
				// TIME IT!
				long start = System.nanoTime();
				ArrayListSorter.mergesort(array);
				long stop = System.nanoTime();
				totalTime += stop - start;
				
			}
			double averageTime = (totalTime / (double) timesToLoop);
			System.out.println(averageTime); // write to file.
			
		}		
	System.out.println("fiftyDone");
	}
	
	/**
	 * Timing experiment for mergeSort with threshold of 45 before it starts using insertion sort
	 */
	@Test
	public void runTimeMergeSortThresholdSeventy() {
		Random random = new Random();
		for (int n = 1000; n <= 10000; n += 1000) {
			

			// Do the experiment multiple times, and average out the results
			long totalTime = 0;
			random.setSeed(1234);
			for (int iter = 0; iter <= timesToLoop; iter++) {
					ArrayList<Integer> array = new ArrayList<Integer>();
					for(int index = 0; index < n; index++) {
						array.add(random.nextInt());
				}
			ArrayListSorter.changeThreshold(70);
				// TIME IT!
				long start = System.nanoTime();
				ArrayListSorter.mergesort(array);
				long stop = System.nanoTime();
				totalTime += stop - start;
				
			}
			double averageTime = (totalTime / (double) timesToLoop);
			System.out.println(averageTime); // write to file.
			
		}		
	System.out.println("SeventyDone");
	}
	
	/**
	 * Timing experiment for mergeSort with threshold of 60 before it starts using insertion sort
	 */
	@Test
	public void runTimeMergeSortThresholdOneHundred() {
		Random random = new Random();
		for (int n = 1000; n <= 10000; n += 1000) {
			

			// Do the experiment multiple times, and average out the results
			long totalTime = 0;
			random.setSeed(1234);
			for (int iter = 0; iter <= timesToLoop; iter++) {
					ArrayList<Integer> array = new ArrayList<Integer>();
					for(int index = 0; index < n; index++) {
						array.add(random.nextInt());
				}
			ArrayListSorter.changeThreshold(100);
				// TIME IT!
				long start = System.nanoTime();
				ArrayListSorter.mergesort(array);
				long stop = System.nanoTime();
				totalTime += stop - start;
				
			}
			double averageTime = (totalTime / (double) timesToLoop);
			System.out.println(averageTime); // write to file.
			
		}		
	System.out.println("HundredDone");
	}
	
	/**
	 * Timing experiment for quickSort with
	 * a pivot at a random index value of the "subArray"
	 */
	@Test
	public void runTimeQuickSortPivotRandom() {
		Random random = new Random();
		for (int n = 1000; n <= 10000; n += 1000) {
			

			// Do the experiment multiple times, and average out the results
			long totalTime = 0;
			random.setSeed(1234);
				// Do the experiment multiple times, and average out the results
				for (int iter = 0; iter < timesToLoop; iter++) {
						ArrayList<Integer> array = new ArrayList<Integer>();
						for(int index = 0; index < n; index++) {
							array.add(random.nextInt());
					}
				ArrayListSorter.randomPivot(array, 0, array.size() - 1);
					// TIME IT!
					long start = System.nanoTime();
					ArrayListSorter.quicksort(array);
					long stop = System.nanoTime();
					totalTime += stop - start;
					
				}
				double averageTime = (totalTime / (double) timesToLoop);
				System.out.println(averageTime); // write to file.
			}		
		System.out.println("Randompick Done");
	}
	
	
	/**
	 * Timing experiment for quickSort with
	 * a pivot at a right end side index value of the "subArray"
	 */
	@Test
	public void runTimeQuickSortFirstPivot() {
		Random random = new Random();
		for (int n = 1000; n <= 10000; n += 1000) {
			

			// Do the experiment multiple times, and average out the results
			long totalTime = 0;
			random.setSeed(1234);
				// Do the experiment multiple times, and average out the results
				for (int iter = 0; iter < timesToLoop; iter++) {
						ArrayList<Integer> array = new ArrayList<Integer>();
						for(int index = 0; index < n; index++) {
							array.add(random.nextInt());
					}
				ArrayListSorter.firstPivot(array, 0, array.size() - 1);
					// TIME IT!
					long start = System.nanoTime();
					ArrayListSorter.quicksort(array);
					long stop = System.nanoTime();
					totalTime += stop - start;
					
				}
				double averageTime = (totalTime / (double) timesToLoop);
				System.out.println(averageTime); // write to file.
			}		
		System.out.println("Firstpick Done");
	}
	/**
	 * Timing experiment for quickSort with
	 * a pivot at a median of the first, middle and last index values of the "subArray"
	 */
	@Test
	public void runTimeQuickSortPivotMedian() {
		Random random = new Random();
		for (int n = 1000; n <= 10000; n += 1000) {
			

			// Do the experiment multiple times, and average out the results
			long totalTime = 0;
			random.setSeed(1234);
				// Do the experiment multiple times, and average out the results
				for (int iter = 0; iter < timesToLoop; iter++) {
						ArrayList<Integer> array = new ArrayList<Integer>();
						for(int index = 0; index < n; index++) {
							array.add(random.nextInt());
					}
				ArrayListSorter.medianPivot(array, 0, array.size() - 1);
					// TIME IT!
					long start = System.nanoTime();
					ArrayListSorter.quicksort(array);
					long stop = System.nanoTime();
					totalTime += stop - start;
					
				}
				double averageTime = (totalTime / (double) timesToLoop);
				System.out.println(averageTime); // write to file.
			}		
		System.out.println("Medianpick Done");
	}
	
//-------------------------------------------------
	
	/**
	 * Ascending for merge sort at threshold of 15
	 * uses an ascending list of size
	 */
	@Test
	public void bestMerge() {

		for (int n = 1000; n <= 10000; n += 1000) {
			Random random = new Random();
			
				// Do the experiment multiple times, and average out the results
				long totalTime = 0;
				random.setSeed(1234);
				for (int iter = 0; iter < timesToLoop; iter++) {
						ArrayList<Integer> array = new ArrayList<Integer>();
						array.addAll(ArrayListSorter.generateAscending(n));
				ArrayListSorter.changeThreshold(15);
					// TIME IT!
					long start = System.nanoTime();
					ArrayListSorter.mergesort(array);
					long stop = System.nanoTime();
					totalTime += stop - start;
					
				}
				double averageTime = (totalTime / (double) timesToLoop);
				System.out.println(averageTime);
			}

		
		System.out.println("AscendingDone");
	}
	
	
	/**
	 * Average case for merge sort at threshold of 50
	 * uses an permuted list of size
	 */
	@Test
	public void averageMerge() {
		for (int n = 1000; n <= 10000; n += 1000) {
			Random random = new Random();
			
				// Do the experiment multiple times, and average out the results
				long totalTime = 0;
				random.setSeed(1234);
				for (int iter = 0; iter < timesToLoop; iter++) {
						ArrayList<Integer> array = new ArrayList<Integer>();
						array.addAll(ArrayListSorter.generatePermuted(n));
				ArrayListSorter.changeThreshold(15);
					// TIME IT!
					long start = System.nanoTime();
					ArrayListSorter.mergesort(array);
					long stop = System.nanoTime();
					totalTime += stop - start;
					
				}
				double averageTime = (totalTime / (double) timesToLoop);
				System.out.println(averageTime);
			}

		
		System.out.println("Done");
	}
	
	
	/**
	 * Worst case for merge sort at threshold of 50
	 * uses an descending list of size
	 */
	@Test
	public void worstMerge() {

		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1_000_000_000)
			;

		try (FileWriter fw = new FileWriter(new File("worstMerge.tsv"))) { // open up a file writer so we can
																						// write to file.
			Random random = new Random();
			for (int exp = 2; exp <= 23; exp++) { // This is used as the exponent to calculate the size of the set.
				int size = (int) Math.pow(2, exp);

				

				// Do the experiment multiple times, and average out the results
				long totalTime = 0;
				random.setSeed(1234);
				for (int iter = 0; iter < ITER_COUNT; iter++) {
						ArrayList<Integer> array = new ArrayList<Integer>();
						array.addAll(ArrayListSorter.generateDescending(size));
				ArrayListSorter.changeThreshold(50);
					// TIME IT!
					long start = System.nanoTime();
					ArrayListSorter.mergesort(array, compare);
					long stop = System.nanoTime();
					totalTime += stop - start;
					
				}
				System.out.println(size);
				double averageTime = (totalTime / (double) ITER_COUNT) / 1_000_000;
				fw.write(size + "\t" + averageTime + "\n"); // write to file.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("WorstMergeDone");
	}
	
	
	/**
	 * Best case for merge sort at pivot middle index
	 * uses an ascending list of size
	 */
	@Test
	public void bestQuick() {
	
		
		Random random = new Random();
		for (int n = 1000; n <= 10000; n += 1000) {
		ArrayList<Integer> storeArray = new ArrayList<Integer>();
		storeArray.addAll(ArrayListSorter.generatePermuted(n));

			// Do the experiment multiple times, and average out the results
			long totalTime = 0;
			random.setSeed(1234);
				// Do the experiment multiple times, and average out the results
				for (int iter = 0; iter < timesToLoop; iter++) {
						ArrayList<Integer> array = new ArrayList<Integer>();
						for(int index = 0; index < n; index++) {
							array.add(storeArray.get(index));
					}
				ArrayListSorter.medianPivot(array, 0, array.size() - 1);
					// TIME IT!
					long start = System.nanoTime();
					ArrayListSorter.quicksort(array);
					long stop = System.nanoTime();
					totalTime += stop - start;
					
				}
				double averageTime = (totalTime / (double) timesToLoop);
				System.out.println(averageTime); // write to file.
			}		
		System.out.println("Medianpick Done");
	}
	
	/**
	 * Worst case for merge sort at pivot middle index
	 * uses an descending list of size
	 */
	@Test
	public void worstQuick() {
		ArrayList<Integer> storeArray = new ArrayList<Integer>();
		storeArray.addAll(ArrayListSorter.generateDescending(9000000));
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1_000_000_000);
		try (FileWriter fw = new FileWriter(new File("worstQuick.tsv"))) { // open up a file writer so we can
																						// write to file.
			Random random = new Random();
			for (int exp = 2; exp <= 23; exp++) { // This is used as the exponent to calculate the size of the set.
				int size = (int) Math.pow(2, exp);

				
				ArrayListSorter.selectPivot(2);
				// Do the experiment multiple times, and average out the results
				long totalTime = 0;
				for (int iter = 0; iter < ITER_COUNT; iter++) {
					ArrayList<Integer> array = new ArrayList<Integer>();
					for(int sizeIter = 0; sizeIter < size; sizeIter++) {
						
						array.add(storeArray.get(sizeIter));
					}
					// TIME IT!
					long start = System.nanoTime();
					ArrayListSorter.mergesort(array, compare);
					long stop = System.nanoTime();
					totalTime += stop - start;
					
				}
				System.out.println(size);
				double averageTime = (totalTime / (double) ITER_COUNT) / 1_000_000;
				fw.write(size + "\t" + averageTime + "\n"); // write to file.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("WorstMergeDone");
	}
	
	
	/**
	 * Average case for merge sort at pivot middle index
	 * uses an permuted list of size
	 */
	@Test
	public void averageQuick() {
		ArrayList<Integer> storeArray = new ArrayList<Integer>();
		storeArray.addAll(ArrayListSorter.generateShuffled(9000000));
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1_000_000_000);
		try (FileWriter fw = new FileWriter(new File("averageQuick.tsv"))) { // open up a file writer so we can
																						// write to file.
			Random random = new Random();
			for (int exp = 2; exp <= 23; exp++) { // This is used as the exponent to calculate the size of the set.
				int size = (int) Math.pow(2, exp);

				
				ArrayListSorter.selectPivot(2);
				// Do the experiment multiple times, and average out the results
				long totalTime = 0;
				for (int iter = 0; iter < ITER_COUNT; iter++) {
					ArrayList<Integer> array = new ArrayList<Integer>();
					for(int sizeIter = 0; sizeIter < size; sizeIter++) {
						
						array.add(storeArray.get(sizeIter));
					}
					// TIME IT!
					long start = System.nanoTime();
					ArrayListSorter.mergesort(array, compare);
					long stop = System.nanoTime();
					totalTime += stop - start;
					
				}
				System.out.println(size);
				double averageTime = (totalTime / (double) ITER_COUNT) / 1_000_000;
				fw.write(size + "\t" + averageTime + "\n"); // write to file.
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("WorstMergeDone");
	}
	
	
}
