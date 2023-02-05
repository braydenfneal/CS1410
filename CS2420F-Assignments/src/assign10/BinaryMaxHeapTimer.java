package assign10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


/**
 * This class collects running times for methods of LargestNumberSolver.
 * 
 * @author Erin Parker
 * @version February 9, 2021
 */
public interface BinaryMaxHeapTimer<E  extends Comparator<? super E>> {
	
//	private void testTimeSortCompator() {
//    System.out.println("Time to find largest sort comparator:");
//    for (int i = 0; i < probSize; i++) {
//        int total = 0;
//        for (int j = 0; j < timeToLoop; j++) {
//            list = (List<Integer>) createList(inputArraySizes[i]);
//            total += doSortComparator();
//        }   
//        System.out.println(inputArraySizes[i] + " " + (total / numRunsToAverage));
//    }
//}
//	
//	private long doSortComparator() {
//    int temp = (int) Math.floor((Math.random() * (100 - 1) + 1));
//    long start = System.nanoTime();
//    Comparator<Integer> intComparator;
//	FindKLargest.findKLargestSort(list, temp, intComparator);
//    long stop = System.nanoTime();
//    long duration = (stop - start);
//    return duration;
//    
//}
	
	
	
	public static void main(String[] args) {
		Random rng = new Random();

		int timesToLoop = 10000;
		int incr = 1000;
		List<Integer> list = new ArrayList<>();
		BinaryMaxHeap<Integer> intHeap = new BinaryMaxHeap<Integer>();
		Comparator<? super Integer> cmp = null;
		Comparator<Integer> myComparator = new Comparator<Integer>() {
    @Override
	public int compare(Integer o1, Integer o2) {
    	if(o1 == null)
    		return 1;
    	if(o2 == null)
    		return -1;
        int result = o2 - o1;
        return result;

    }
};
		FindKLargest find = new FindKLargest();
		
		for(int probSize = 1000; probSize <= 10000; probSize += incr) 
		{
			list.clear();
			int maximum = probSize;
			int minimum = 1;
			for(int i = 0; i < probSize; i ++)
			{
				list.add(rng.nextInt() % (maximum - minimum + 1));
			}
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.

			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
				FindKLargest.findKLargestHeap(list, 500);
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
			System.out.println("findKLargestHeap" + probSize + "  " + averageTime);
			
		}
//		
//		for(int probSize = 1000; probSize <= 10000; probSize += incr) 
//		{
//			list.clear();
//			int maximum = probSize;
//			int minimum = 1;
//			for(int i = 1; i < probSize; i ++)
//			{
//				list.add(i);
//			}
//			// First, spin computing stuff until one second has gone by.
//			// This allows this thread to stabilize.
//
//			long stopTime, midpointTime, startTime = System.nanoTime();
//
//			while(System.nanoTime() - startTime < 1000000000) { // empty block
//			}
//
//			// Collect running times.
//			startTime = System.nanoTime();
//			for(int i = 0; i < timesToLoop; i++) {
//				FindKLargest.findKLargestSort(list, 50, myComparator);
//			}
//
//			midpointTime = System.nanoTime();
//
//			// Capture the cost of running the loop and any other operations done
//			// above that are not the essential method call being timed.
//			for(int i = 0; i < timesToLoop; i++) {
//			}
//
//			stopTime = System.nanoTime();
//
//			// Compute the time, subtract the cost of running the loop
//			// from the cost of running the loop and searching.
//			// Average it over the number of runs.
//			double averageTime = ((midpointTime - startTime) - 
//						(stopTime - midpointTime)) / (double) timesToLoop;
//			System.out.println("findKLargestSort " + probSize + "  " + averageTime);
//			
//		}
//		
	}
}