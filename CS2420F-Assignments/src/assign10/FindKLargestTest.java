package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Zach Lin and William Dreyer
 * @version April 15, 2021
 */
class FindKLargestTest {
	
	ArrayList<Integer> intList;
	ArrayList<String> strList;
	

	@BeforeEach
	void setUp() throws Exception {		
		intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);
		intList.add(6);
		intList.add(7);
		intList.add(8);
		intList.add(9);
		
		strList = new ArrayList<String>();
		strList.add("Boing");
		strList.add("Mope");
		strList.add("Vacation");
		strList.add("The");
		strList.add("At");
		

		
	}
	
	@Test
	void testKLargestHeapSort() {
		List<Integer> sorted = FindKLargest.findKLargestHeap(intList, 3);
		assertEquals(sorted.get(0), 9);
		assertEquals(sorted.get(1), 8);
		assertEquals(sorted.get(2), 7);
	}
	
	@Test
	void testKLargestHeapSortComparator() {
		List<Integer> sorted = FindKLargest.findKLargestHeap(intList, 3, (n1, n2) -> {return n2 - n1;});
		assertEquals(sorted.get(0), 1);
		assertEquals(sorted.get(1), 2);
		assertEquals(sorted.get(2), 3);
	}
	
	@Test
	void testKLargestJavaSort() {
		List<Integer> sorted = FindKLargest.findKLargestSort(intList, 3);
		assertEquals(sorted.get(0), 9);
		assertEquals(sorted.get(1), 8);
		assertEquals(sorted.get(2), 7);
	}
	
	@Test
	void testKLargestJavaSortComparator() {
		List<Integer> sorted = FindKLargest.findKLargestSort(intList, 3, (n1, n2) -> {return n2 - n1;});
		assertEquals(sorted.get(0), 1);
		assertEquals(sorted.get(1), 2);
		assertEquals(sorted.get(2), 3);
	}
	
	@Test
	void testKLargestHeapSortString() {
		List<String> sorted = FindKLargest.findKLargestHeap(strList, 3);
		assertTrue(sorted.get(0).equals("Vacation"));
		assertTrue(sorted.get(1).equals("The"));
		assertTrue(sorted.get(2).equals("Mope"));
	}
	
	@Test
	void testKLargestHeapSortComparatorString() {
		List<String> sorted = FindKLargest.findKLargestHeap(strList, 3, (n1, n2) -> {return n1.length() - n2.length();});
		assertTrue(sorted.get(0).equals("Vacation"));
		assertTrue(sorted.get(1).equals("Boing"));
		assertTrue(sorted.get(2).equals("Mope"));
	}
	
	@Test
	void testKLargestJavaSortString() {
		List<String> sorted = FindKLargest.findKLargestSort(strList, 3);
		assertTrue(sorted.get(0).equals("Vacation"));
		assertTrue(sorted.get(1).equals("The"));
		assertTrue(sorted.get(2).equals("Mope"));
	}
	
	@Test
	void testKLargestJavaSortComparatorString() {
		List<String> sorted = FindKLargest.findKLargestSort(strList, 3, (n1, n2) -> {return n1.length() - n2.length();});
		assertTrue(sorted.get(0).equals("Vacation"));
		assertTrue(sorted.get(1).equals("Boing"));
		assertTrue(sorted.get(2).equals("Mope"));
	}

}
