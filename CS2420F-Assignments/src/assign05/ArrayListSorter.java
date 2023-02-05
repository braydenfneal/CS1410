	package assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

/**
 * 
 * @author William Dreyer and Brayden Neal
 * @Version 10/04/2021
 *
 *Our purpose of this class is to text several different sorting
 *methods on array lists, along with generation of differing array lists
 */
public class ArrayListSorter
{
	//these are variables that we initialize for use later in the code
	public static boolean insertionSortCheck = false;
	public static int thresholdInt = 1;
	public static int pivotInt;
	
	/**
	 * Allows user to change the threshold outside of this class for mergesort
	 * before it starts using insertionsort for its "sub arrays"
	 * 
	 * @param newThreshold
	 */
	public static void changeThreshold(int newThreshold) {
		if(newThreshold <=0 )
			throw new IllegalArgumentException("Cannot have a threshold of 0 or less");
		thresholdInt = newThreshold;
	}
	
	/**
	 * Because creating a temporary array list would be costly, we made a driver method to run it.
	 * It then calls the helper merge sort method.
	 * @param list - the arraylist we want to be sorted
	 */
	public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list) {
		ArrayList<T> temp = generateArrayList(list.size());
		mergesort(list, 0, list.size() - 1, temp);
	}
	
	/**
	 * This is the private recursive method for merge sort, which calls another merge method.
	 * Our reasoning for doing this is to ensure that all cases of merge sort are met, 
	 * so we allow another merge sort method to be called that takes a middle integer into mind.
	 * @param <T>
	 * @param list - the list we want to sort
	 * @param start - the beginning index of the sublist (inclusive)
	 * @param end - the end index of the sublist (inclusive)
	 * @param temp - a temporary arraylist to hold elements as they are copied over
	 */
	private static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list, int start, int end, ArrayList<T> temp) {
		if(start < end) {
			int mid = (start + end) / 2;
			mergesort(list, start, mid, temp);
			mergesort(list, mid + 1, end, temp);
			if(end - start < thresholdInt) {
				insertionSort(list, start, end);
			}
			else {
				merge(list, start, mid + 1, end, temp);
			}	
		}
	}
	
	/**
	 * This method is a private helper method to merge the sublists in merge sort
	 * @param list - the list to be sorted
	 * @param start - the beginning index of the sublist
	 * @param mid - the middle index of the sublist
	 * @param end - the end index of the sublist
	 * @param temp - a temporary arraylist for copying elements over
	 */
	private static <T extends Comparable<? super T>> void merge(ArrayList<T> list, int start, int mid, int end, ArrayList<T> temp) {
		int leftIndex = start;
		int rightIndex = mid;
		//Copy elements into their sorted order in the temporary list
		for(int i = start; i <= end; i++) {
			if(leftIndex == mid) {
				temp.set(i, list.get(rightIndex));
				rightIndex++;
			}
			else if(rightIndex == end + 1) {
				temp.set(i, list.get(leftIndex));
				leftIndex++;
			}
			else if(list.get(leftIndex).compareTo(list.get(rightIndex)) < 0) {
				temp.set(i, list.get(leftIndex));
				leftIndex++;
			}
			else {
				temp.set(i, list.get(rightIndex));
				rightIndex++;
			}
		}
		
		//Copy sorted elements from temporary list to original list
		for(int i = start; i <= end; i++) {
			list.set(i, temp.get(i));
		}
	}
	
	/**
	 * This method performs insertion sort. It was adapted from our previous code from LargestNumberSolver
	 * @param list - the list to be sorted
	 * @param start - the beginning index of the list
	 * @param end - the end index of the list
	 */
	public static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> list, int start, int end) {
		for(int i = start + 1; i <= end; i++) {
			T val = list.get(i);
			int j;
			for(j = i - 1; j >= start && list.get(j).compareTo(val) > 0; j--)
				list.set(j + 1, list.get(j));
			list.set(j + 1, val);
		}
		insertionSortCheck = true;
	}
	
	
	/**
	 * This method generates an arraylist of the specified size. This code was adapted from the week 5 lecture videos to create a generic ArrayList.
	 * @param n - the size of the list to be generated
	 * @return - the newly generated arraylist
	 */
	private static <T extends Comparable<? super T>> ArrayList<T> generateArrayList(int n) {
		ArrayList<T> temp = new ArrayList<T>();
		for(int i = 0; i < n; i++) {
			temp.add(null);
		}
		return temp;
	}
	
	/**
	 * This is the driver method for quicksort.
	 * @param list - the list to be sorted
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list) {
		quicksort(list, 0, list.size() - 1);
	}
	
	/**
	 * This is the private recursive method for quicksort
	 * @param list - the list to be sorted
	 * @param start - the beginning index of the list
	 * @param end - the ending index of the list
	 */
	public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list, int start, int end) {
		if(start < end) {
			//pivot = randomPivot(list, start, end);
			
			//Since the pivot has been moved to a different place, it must be updated
			pivotInt = partition(list, start, end, medianPivot(list, start, end));
			
			if(pivotInt - 1 - start < thresholdInt) {
				insertionSort(list, start, pivotInt - 1);
			}
			else {
				quicksort(list, start, pivotInt - 1);
			}
			if(end - (pivotInt + 1) < thresholdInt) {
				insertionSort(list, pivotInt + 1, end);
			}
			else {
				quicksort(list, pivotInt + 1, end);
			}
				
		}
	}

	/**
	 * This is a helper method for quicksort that partitions the given list into elements less than and greater than the pivot element
	 * @param list - the list to be sorted
	 * @param start - the beginning index of the list
	 * @param end - the ending index of the list
	 * @param pivot - the index of the pivot
	 * @return - the new index of the pivot element
	 */
	public static <T extends Comparable<? super T>> int partition(ArrayList<T> list, int start, int end, int pivot) {
		T pivotVal = list.get(pivot);
		list.set(pivot, list.get(end));
		list.set(end, pivotVal);
		
		int leftIndex = start;
		int rightIndex = start;
		
		while(rightIndex < end) {
			if(pivotVal.compareTo(list.get(rightIndex)) < 0) {
				rightIndex++;
			}
			else {
				T temp = list.get(rightIndex);
				list.set(rightIndex, list.get(leftIndex));
				list.set(leftIndex, temp);
				rightIndex++;
				leftIndex++;
			}
		}
		
		pivotVal = list.get(end);
		list.set(end, list.get(leftIndex));
		list.set(leftIndex, pivotVal);
		
		return leftIndex;
	}
	
	/**
	 * This method chooses a pivot by the median of 3 strategy. We left this method public so that we could test it easily.
	 * @param list - the list to be sorted
	 * @param start - the beginning index of the list
	 * @param end - the ending index of the list
	 * @return - the index of the chosen pivot
	 */
	public static <T extends Comparable<? super T>> int medianPivot(ArrayList<T> list, int start, int end) {
		int median = (start + end) / 2;
		
		if(list.get(start).compareTo(list.get(median)) <= 0 && list.get(median).compareTo(list.get(end)) <= 0) {
			//Already in order
		}
		else if(list.get(end).compareTo(list.get(median)) <= 0 && list.get(median).compareTo(list.get(start)) <= 0) {
			T temp = list.get(start);
			list.set(start, list.get(end));
			list.set(end, temp);
		}
		else if(list.get(median).compareTo(list.get(start)) <= 0 && list.get(start).compareTo(list.get(end)) <= 0) {
			T temp = list.get(start);
			list.set(start, list.get(median));
			list.set(median, temp);
		}
		else if(list.get(end).compareTo(list.get(start)) <= 0 && list.get(start).compareTo(list.get(median)) <= 0) {
			T temp = list.get(start);
			list.set(start, list.get(end));
			list.set(end, list.get(median));
			list.set(median, temp);
		}
		else if(list.get(start).compareTo(list.get(end)) <= 0 && list.get(end).compareTo(list.get(median)) <= 0) {
			T temp = list.get(start);
			list.set(start, list.get(median));
			list.set(median, temp);
		}
		else {
			T temp = list.get(start);
			list.set(start, list.get(median));
			list.set(median, list.get(end));
			list.set(end, temp);
		}
		
		return median;
	}
	
	/**
	 * This method chooses the first element as the pivot
	 * @param list - the list to be sorted
	 * @param start - the beginning index of the list
	 * @param end - the end index of the list
	 * @return - the index of the pivot
	 */
	public static <T extends Comparable<? super T>> int firstPivot(ArrayList<T> list, int start, int end) {
		return start;
	}
	
	/**
	 * This method chooses a random element as the pivot
	 * @param list - the list to be sorted
	 * @param start - the beginning index of the list
	 * @param end - the end index of the list
	 * @return - the index of the pivot
	 */
	public static <T extends Comparable<? super T>> int randomPivot(ArrayList<T> list, int start, int end) {
		return start + (int)Math.floor(Math.random()*((end + 1) - start));
	}
	
	/**
	 * This returns the variable of Insertion Sort Check in a method.
	 * @return boolean insertionSortCheck
	 */
	public static boolean checkForInsertionSort() {
		return insertionSortCheck;
	}
	
	/**
	 * This method generates a list of ascending integers from 1 to size
	 * @param size - the length of the arraylist
	 * @return - the ascending arraylist
	 */
	public static ArrayList<Integer> generateAscending(int size) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 1; i <= size; i++) {
			temp.add((Integer)i);
		}
		return temp;
	}
	
	/**
	 * This method generates a randomly permuted integers, with the elements being from 1 to size
	 * @param size - the length of the arraylist
	 * @return - the permuted arraylist
	 */
	public static ArrayList<Integer> generatePermuted(int size) {
		ArrayList<Integer> temp = generateAscending(size);
		Collections.shuffle(temp);
		return temp;
	}
	
	/**
	 * This method generates a list of descending integers from size to 1
	 * @param size - the length of the arraylist
	 * @return - the descending arraylist
	 */
	public static ArrayList<Integer> generateDescending(int size) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = size; i >= 1; i--) {
			temp.add((Integer)i);
		}
		return temp;
	}
}
