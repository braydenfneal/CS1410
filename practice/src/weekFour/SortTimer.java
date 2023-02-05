package weekFour;

import java.util.Arrays;

/**
 * This program collects running times for insertion sort in the best, average,
 * and worst cases.
 * 
 * Notice that best case = sorted array, average case = permuted array, worst
 * case = reverse-sorted array. This is not necessarily the same for all sorting
 * algorithms.
 * 
 * ADVICE: Since the best case of insertion sort is so much faster than the other
 * two cases, it may be better to collect running times for each case separately.
 * Values for N and timesToLoop can be (and should be) larger for the best case 
 * than the average and worst cases.
 * 
 * @author Erin Parker
 * @version February 3, 2022
 */
public class SortTimer {

	public static void main(String[] args) {

		final int NSTART = 10000; 
		final int NSTOP = 100000;
		final int NINCR = 10000;
		
		System.out.println("Insertion sort\nN\tBest\tAverage\tWorst\n");

		for(int N = NSTART; N <= NSTOP; N += NINCR) {
			System.out.print(N + "\t");

			// Build three arrays of N integers, two sorted and one reverse-sorted.
			int[] sortedArr = new int[N];
			int[] permutedArr = new int[N];
			int[] reverseSortedArr = new int[N];
			for(int i = 0; i < N; i++) {
				sortedArr[i] = i + 1;
				permutedArr[i] = i + 1;
				reverseSortedArr[i] = N - i;
			}

			// Randomly permute one of the arrays.
			WarmUp.shuffle(permutedArr);

			System.out.println(getTime(sortedArr)+ "\t" + getTime(permutedArr) + "\t" + 
					getTime(reverseSortedArr));
		}
	}

	private static long getTime(int[] arr) {
				
		final int TIMES_TO_LOOP = 10000;  

		// Let things stabilize
		long startTime = System.nanoTime();
		while(System.nanoTime() - startTime < 1000000000)
			;

		// Time the sort
		startTime = System.nanoTime();
		for(int i = 0; i < TIMES_TO_LOOP; i++) {
			// ATTENTION: Don't sort an already sorted array!
			int[] temp = Arrays.copyOf(arr, arr.length);
			sort(temp);
		}

		long midTime = System.nanoTime();

		// Time the "overhead"
		for(int i = 0; i < TIMES_TO_LOOP; i++) {
			@SuppressWarnings("unused")
			// It is understood that temp is not used and exists only for timing.
			int[] temp = Arrays.copyOf(arr, arr.length); 
		}

		long endTime = System.nanoTime();

		return ((midTime - startTime) - (endTime - midTime)) / TIMES_TO_LOOP;
	}

	/**
	 * Sorts the given array, using the insertion sort algorithm.
	 * (Code is copied from Class Meeting 8 slides.)
	 * 
	 * @param arr
	 */
	public static void sort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int val = arr[i];
			int j;
			for(j = i - 1; j >= 0 && arr[j] > val; j--)
				arr[j + 1] = arr[j];
			arr[j + 1] = val;
		}
	}
}