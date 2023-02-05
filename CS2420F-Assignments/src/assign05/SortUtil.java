package assignment05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
/**
 * Class for quick and merge sorts
 * Merge sort utilizes insertion sort once a threshold is met
 * @author James Lee and Kyle Curtis
 *
 * @param <T>
 */
public class SortUtil<T> {
	private static Random randomNumber = new Random();

	/**
	 * Holds the threshold for mergesort Default is 1 which doesn't allow mergesort
	 * to use insertionsort at all
	 */
	private static int threshold = 1;

	/**
	 * This selects the position to use for pivot, if it is 0 it uses a random pivot
	 * if 1 use ending pivot point if 2 use middle pivot point By default this is
	 * set to 0 for random pivot
	 */
	private static int pivotType = 0;

	/**
	 * Allows user to change the threshold outside of this class for mergesort
	 * before it starts using insertionsort for its "sub arrays"
	 * 
	 * @param newThreshold
	 */
	public static void changeThreshold(int newThreshold) {
		if(newThreshold <=0 )
			throw new IllegalArgumentException("Cannot have a threshold of 0 or less");
		threshold = newThreshold;
	}

	/**
	 * returns the current threshold value
	 * 
	 * @return
	 */
	public static Integer getThreshold() {
		return threshold;
	}

	/**
	 * This generic method sorts the input array list using an insertion sort and
	 * the input Comparator object. If a null argument is passed, the method should
	 * throw a NullPointerException.
	 * 
	 * @param subArray
	 * @param comparator
	 */

	public static <T> void insertionSort(ArrayList<T> array, int left, int right, Comparator<? super T> comparator) {
		if ((array == null) || (comparator == null))
			throw new NullPointerException("Null argument was passed");

		for (int currentPosition = left + 1; currentPosition < right + 1; currentPosition++) {
			T temp;
			int previousPositions;
			temp = array.get(currentPosition);
			for (previousPositions = currentPosition; previousPositions > left; previousPositions--) {
				if (comparator.compare(temp, array.get(previousPositions - 1)) < 0)
					array.set(previousPositions, array.get(previousPositions - 1));
				else
					break;
			}
			if (currentPosition != previousPositions)
				array.set(previousPositions, temp);

		}
	}

	/**
	 * the recursive mergesort method to be referenced by the driver
	 * Splits the array into divided indexes before it merges them in order
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @param comparator
	 */
	private static <T> void mergesort(ArrayList<T> array, int left, int right, Comparator<? super T> comparator) {

		if (right - left < threshold) {
			insertionSort(array, left, right, comparator);
			return;
		}
		int middle = (right + left) / 2;

		mergesort(array, left, middle, comparator);
		mergesort(array, middle + 1, right, comparator);
		merge(array, left, middle, right, comparator);
	}

	/**
	 * combines two sorted arrayLists with mergesort algorithm
	 * Compares first of left and right before putting in final array
	 * Once one side of the array runs out it puts the rest of the other side in
	 * 
	 * @param array
	 * @param left
	 * @param middle
	 * @param right
	 * @param comparator
	 */
	private static <T> void merge(ArrayList<T> array, int left, int middle, int right,
			Comparator<? super T> comparator) {

		int sizeMerged = right - left + 1; // Calculate size of Merged array
		ArrayList<T> arrayMerged = new ArrayList<T>(sizeMerged);

		int indexLeft = left; // Initialize variables
		int indexRight = middle + 1;

		while ((indexLeft < middle + 1) && (indexRight < right + 1)) {
			if (comparator.compare(array.get(indexLeft), array.get(indexRight)) < 0)
				arrayMerged.add(array.get(indexLeft++));// Take it from the left if left is smaller (depend on compare)
			else
				arrayMerged.add(array.get(indexRight++));// Take it from the right if right is smaller (depend on
															// compare)
		}

		while (indexLeft < middle + 1) // Copy the rest of the array from the left
			arrayMerged.add(array.get(indexLeft++));

		while (indexRight < right + 1) // Copy the rest of the array from the right
			arrayMerged.add(array.get(indexRight++));

		int iter = left;
		for (T item : arrayMerged) {
			array.set(iter++, item);
		}

	}

	/**
	 * This method performs a mergesort on the generic ArrayList given as input.
	 * 
	 * @param array
	 * @param comparator
	 */
	public static <T> void mergesort(ArrayList<T> array, Comparator<? super T> comparator) {
		int size = array.size();
		if (threshold >= size)
			SortUtil.insertionSort(array, 0, size - 1, comparator);
		mergesort(array, 0, size - 1, comparator);
	}

	/**
	 * places pivot in its correct position and puts all items greater than pivot to
	 * the right and all items lower than pivot to the left
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @param comparator
	 * @return
	 */
	private static <T> int partition(ArrayList<T> array, int left, int right, int pivotType,
			Comparator<? super T> comparator) {
		int pivotIndex = left;
		if (pivotType == 0) {
			pivotIndex = left + randomNumber.nextInt(right - left + 1);
		} else if (pivotType == 1) {
			pivotIndex = right;
		} else if (pivotType == 2) {
			
			pivotIndex = (right+left)/2;
		}

		T pivot = array.get(pivotIndex);

		int indexSmaller = left; // index of elements smaller than pivot

		for (int j = left; j <= right; j++) {// Go through the whole array
			if (indexSmaller == pivotIndex) // Skip over the pivot point
				indexSmaller++;
			if (j != pivotIndex) // Do not compare the pivot point
				if (comparator.compare(array.get(j), pivot) <= 0)
					Collections.swap(array, j, indexSmaller++); // Swap the current element to the left of the pivot
		}
		if (pivotIndex < indexSmaller) // If pivot is smaller then decrement the smaller pointer
			indexSmaller--;
		Collections.swap(array, indexSmaller, pivotIndex); // Swap pivot value to the pivot position
		return (indexSmaller);
	}

	/**
	 * recursive fuctional part of quicksort that is called by the driver method
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @param comparator
	 */
	public static <T> void quickSort(ArrayList<T> array, int left, int right, Comparator<? super T> comparator) {
		if (left < right) {
			int currentPosition = partition(array, left, right, pivotType, comparator);
			quickSort(array, left, currentPosition - 1, comparator); // Sort left partition
			quickSort(array, currentPosition + 1, right, comparator); // Sort right partition
		}
	}

	/**
	 * This method performs a quicksort on the generic ArrayList given as input.
	 * 
	 * @param array
	 * @param comparator
	 */
	public static <T> void quicksort(ArrayList<T> array, Comparator<? super T> comparator) {
		quickSort(array, 0, array.size() - 1, comparator);
	}

	/**
	 * chooses a pivot, if pivotType is 0 chooses random pivot, if pivotType is 1
	 * chooses item at the last index, if pivotType is 2 chooses the middle index
	 * value is already defaulted to 0 if a value is not chosen if a value that
	 * isn't 0 1 or 2 it defaults to the left index as pivot
	 * 
	 * @param array
	 * @param pivotType
	 * @return
	 */
	public static <T> void selectPivot(int pivotTypeSelect) {
		pivotType = pivotTypeSelect;
	}

	/**
	 * This method generates and returns an ArrayList of integers 1 to size in
	 * ascending order.
	 * 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateAscending(int size) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int index = 0; index < size;)
			array.add(++index);
		return array;
	}

	/**
	 * This method generates and returns an ArrayList of integers 1 to size in
	 * ascending order.
	 * 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateShuffled(int size) {
		ArrayList<Integer> array = generateAscending(size);
		Collections.shuffle(array);
		return array;
	}

	/**
	 * This method generates and returns an ArrayList of integers 1 to size in
	 * descending order.
	 * 
	 * @param size
	 * @return
	 */
	public static ArrayList<Integer> generateDescending(int size) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int index = size; index > 0;)
			array.add(index--);
		return array;
	}

}
