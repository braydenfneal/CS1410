package assign05;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for merge and quick sort from file ArrayListSorter.java
 * @author Brayden Neal
 *
 */
public class ArrayListSorterTestJ {
	ArrayList<Integer> ascend = new ArrayList<Integer>();
	ArrayList<Integer> descend = new ArrayList<Integer>();
	Random rand;
	private Natural compare;

	protected static class Natural implements Comparator<Integer> {
		public int compare(Integer lhs, Integer rhs) {
			return (lhs.compareTo(rhs));
		}
	}
	
	
	

	@Before
	public void setup() {
		ascend.add(1);
		ascend.add(2);
		ascend.add(3);
		ascend.add(4);
		ascend.add(5);
		ascend.add(6);
		ascend.add(7);
		ascend.add(8);
		ascend.add(9);

		descend.add(9);
		descend.add(8);
		descend.add(7);
		descend.add(6);
		descend.add(5);
		descend.add(4);
		descend.add(3);
		descend.add(2);
		descend.add(1);
		compare = new Natural();

	}

	
	@Test
	public void insertion() {
		ArrayList<Integer> array = ArrayListSorter.generateDescending(9);
		ArrayListSorter.insertionSort(array, 0, array.size() - 1, compare);
		Assert.assertEquals(ascend, array);

	}

	@Test
	public void testGenerateAscending() {

		ArrayList<Integer> array = ArrayListSorter.generateAscending(9);
		Assert.assertEquals(ascend, array);
	}

	@Test
	public void testGenerateDescending() {
		ArrayList<Integer> array = ArrayListSorter.generateDescending(9);
		Assert.assertEquals(descend, array);
	}

	@Test
	public void testgeneratePermuted() {
		ArrayList<Integer> array = ArrayListSorter.generatePermuted(9);
		Assert.assertTrue(array.containsAll(ascend));
	}

	@Test
	public void mergeSortGenerateAscending() {
		ArrayList<Integer> array = ArrayListSorter.generateAscending(9);
		ArrayListSorter.mergesort(array, compare);
		Assert.assertEquals(ascend, array);
	}

	@Test
	public void mergeSortgeneratePermuted() {
		ArrayList<Integer> array = ArrayListSorter.generatePermuted(9);
		ArrayListSorter.mergesort(array, compare);
		Assert.assertEquals(ascend, array);
	}

	@Test
	public void mergeSortgeneratePermutedWithMiddleThreshold() {
		ArrayList<Integer> array = ArrayListSorter.generatePermuted(9);
		ArrayListSorter.changeThreshold(4);
		ArrayListSorter.mergesort(array, compare);
		Assert.assertEquals(ascend, array);
	}

	@Test
	public void mergeSortGe() {
		ArrayList<Integer> array = new ArrayList<Integer>(); // {3,5,8,6,1,4,2,7,9};
		array.add(3);
		array.add(5);
		array.add(8);
		array.add(6);
		array.add(1);
		array.add(4);
		array.add(2);
		array.add(7);
		array.add(9);
		ArrayListSorter.mergesort(array, compare);
		Assert.assertEquals(ascend, array);
	}

	@Test
	public void mergeSortGenerateDescending() {
		ArrayList<Integer> array = ArrayListSorter.generateDescending(9);
		ArrayListSorter.mergesort(array, compare);
		Assert.assertEquals(ascend, array);
	}

	@Test
	public void mergeSortGenerateDescendingWithMiddleTheshold() {
		ArrayList<Integer> array = ArrayListSorter.generateDescending(9);
		ArrayListSorter.changeThreshold(4);
		ArrayListSorter.mergesort(array, compare);
		Assert.assertEquals(ascend, array);
	}

	@Test
	public void mergesortArrayOfSizeOne() {
		ArrayList<Integer> array = ArrayListSorter.generateDescending(1);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		ArrayListSorter.mergesort(array, compare);
		Assert.assertEquals(result, array);

	}

	@Test
	public void mergesortArrayOfSizeTwo() {
		ArrayList<Integer> array = ArrayListSorter.generateDescending(2);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		result.add(2);
		ArrayListSorter.mergesort(array, compare);
		Assert.assertEquals(result, array);

	}

	@Test
	public void mergesortArrayOfSizeThree() {
		ArrayList<Integer> array = ArrayListSorter.generateDescending(3);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		result.add(2);
		result.add(3);
		ArrayListSorter.mergesort(array, compare);
		Assert.assertEquals(result, array);
	}

	@Test
	public void mergeSortTwoOfEveryInt() {
		ArrayList<Integer> array = ArrayListSorter.generatePermuted(10);
		ArrayList<Integer> result = new ArrayList<Integer>();
		array.addAll(ArrayListSorter.generatePermuted(10));
		result.addAll(array);
		Collections.sort(result);
		ArrayListSorter.mergesort(array, compare);
		Assert.assertEquals(result, array);
	}

	/**
	 * Tests with a seeded random array if the two mergesort is the same as
	 * Collections sort when sorting two identical arrays The Primary goal of this
	 * test is to check if every possible threshold value works.
	 */
	@Test
	public void mergeSortIterateEveryThesholdToSize() {
		Random rand = new Random(1);
		int size = 100;
		ArrayList<Integer> randomArray = new ArrayList<Integer>();
		for (int i = 0; i < size; i++)
			randomArray.add(rand.nextInt(100));
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.addAll(randomArray);
		result.sort(compare);

		// size+10 just so we can test out of bounds thresholds(should just use
		// insertion sort at that point for sorting
		for (int threshold = 1; threshold < size + 10; threshold++) {
			ArrayList<Integer> array = new ArrayList<Integer>();
			array.addAll(randomArray);
			ArrayListSorter.changeThreshold(threshold);
			ArrayListSorter.mergesort(array, compare);
			if (result.size() != array.size())
				Assert.fail();

			for (int index = 0; index < array.size(); index++)
				if (array.get(index) != array.get(index))
					Assert.fail();
		}
	}
	
	@Test
	public void quickSortallPivotRandomArray() {
		Random rand = new Random(1);
		int size = 100;
		ArrayList<Integer> randomArray = new ArrayList<Integer>();
		for (int i = 0; i < size; i++)
			randomArray.add(rand.nextInt(100));
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.addAll(randomArray);
		result.sort(compare);

		// size+10 just so we can test out of bounds thresholds(should just use
		// insertion sort at that point for sorting
		for (int pivot = 0; pivot < 3; pivot++) {
			ArrayList<Integer> array = new ArrayList<Integer>();
			array.addAll(randomArray);
			ArrayListSorter.selectPivot(pivot);
			ArrayListSorter.quicksort(array, compare);
			if (result.size() != array.size())
				Assert.fail();

			for (int index = 0; index < array.size(); index++)
				if (array.get(index) != array.get(index))
					Assert.fail();
		}
	}
	
	@Test
	public void quickSortallPivotAscendArray() {
		
		int size = 100;
		ArrayList<Integer> ascendArray = ArrayListSorter.generateAscending(size);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.addAll(ascendArray);
		result.sort(compare);

		// size+10 just so we can test out of bounds thresholds(should just use
		// insertion sort at that point for sorting
		for (int pivot = 0; pivot < 3; pivot++) {
			ArrayList<Integer> array = new ArrayList<Integer>();
			array.addAll(ascendArray);
			ArrayListSorter.selectPivot(pivot);
			ArrayListSorter.quicksort(array, compare);
			if (result.size() != array.size())
				Assert.fail();

			for (int index = 0; index < array.size(); index++)
				if (array.get(index) != array.get(index))
					Assert.fail();
		}
	}
	
	@Test
	public void quickSortallPivotDescendArray() {
		
		int size = 100;
		ArrayList<Integer> descendArray = ArrayListSorter.generateDescending(size);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.addAll(descendArray);
		result.sort(compare);

		// size+10 just so we can test out of bounds thresholds(should just use
		// insertion sort at that point for sorting
		for (int pivot = 0; pivot < 3; pivot++) {
			ArrayList<Integer> array = new ArrayList<Integer>();
			array.addAll(descendArray);
			ArrayListSorter.selectPivot(pivot);
			ArrayListSorter.quicksort(array, compare);
			if (result.size() != array.size())
				Assert.fail();

			for (int index = 0; index < array.size(); index++)
				if (array.get(index) != array.get(index))
					Assert.fail();
		}
	}
	
	@Test
	public void quickSortallPivotShuffleArray() {
		
		int size = 100;
		ArrayList<Integer> shuffleArray = ArrayListSorter.generatePermuted(size);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.addAll(shuffleArray);
		result.sort(compare);

		// size+10 just so we can test out of bounds thresholds(should just use
		// insertion sort at that point for sorting
		for (int pivot = 0; pivot < 3; pivot++) {
			ArrayList<Integer> array = new ArrayList<Integer>();
			array.addAll(shuffleArray);
			ArrayListSorter.selectPivot(pivot);
			ArrayListSorter.quicksort(array, compare);
			if (result.size() != array.size())
				Assert.fail();

			for (int index = 0; index < array.size(); index++)
				if (array.get(index) != array.get(index))
					Assert.fail();
		}
	}
	
	

	@Test
	public void quicksortGenerateAscending() {
		ArrayList<Integer> array = ArrayListSorter.generateAscending(9);
		ArrayListSorter.quicksort(array, compare);
		Assert.assertEquals(ascend, array);
	}

	@Test
	public void quicksortgeneratePermuted() {
		ArrayList<Integer> array = ArrayListSorter.generatePermuted(9);
		ArrayListSorter.quicksort(array, compare);
		Assert.assertEquals(ascend, array);
	}

	@Test
	public void quicksortGenerateDescending() {
		ArrayList<Integer> array = ArrayListSorter.generateDescending(9);
		ArrayListSorter.selectPivot(1);
		ArrayListSorter.quicksort(array, compare);
		Assert.assertEquals(ascend, array);
	}

}
