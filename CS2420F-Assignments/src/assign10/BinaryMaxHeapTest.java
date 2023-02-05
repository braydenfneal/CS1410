package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Zach Lin and William Dreyer
 * @version April 15, 2021
 */
class BinaryMaxHeapTest {
	
	BinaryMaxHeap<Double> doubleHeap;
	BinaryMaxHeap<Integer> intHeap;
	BinaryMaxHeap<String> strHeap;
	
	

	@BeforeEach
	void setUp() throws Exception {		
		doubleHeap = new BinaryMaxHeap<Double>();
		doubleHeap.add(5.0);
		doubleHeap.add(5.1);
		doubleHeap.add(2.3);
		doubleHeap.add(8.2);
		doubleHeap.add(7.7);
		
		intHeap = new BinaryMaxHeap<Integer>((n1, n2) -> {return Math.abs(n1) - Math.abs(n2);});
		intHeap.add(-5);
		intHeap.add(200);
		intHeap.add(-800);
		intHeap.add(2);
		intHeap.add(13);
		
		strHeap = new BinaryMaxHeap<String>((s1, s2) -> {return s1.length() - s2.length();});
		strHeap.add("aaaaaa");
		strHeap.add("aaaa");
		strHeap.add("aaaaa");
		strHeap.add("aaaaaaaaa");
		strHeap.add("aaaaaaa");
		strHeap.add("aaa");
		strHeap.add("aaaaaaaa");
		strHeap.add("aa");
		strHeap.add("aaaaaaaaaa");
		strHeap.add("a");
	}
	
	@Test
	void testBasicConstructor() {
		BinaryMaxHeap<Integer> temp = new BinaryMaxHeap<Integer>();
		temp.add(5);
		temp.add(-9);
		assertEquals(temp.peek(), 5);
	}
	
	@Test
	void testComparatorConstructor() {
		BinaryMaxHeap<Integer> temp = new BinaryMaxHeap<Integer>((n1, n2) -> {return Math.abs(n1) - Math.abs(n2);});
		temp.add(5);
		temp.add(-9);
		assertEquals(temp.peek(), -9);
	}
	
	@Test
	void testBasicConstructorWithList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(-9);
		BinaryMaxHeap<Integer> temp = new BinaryMaxHeap<Integer>(list);
		assertEquals(temp.peek(), 5);
	}
	
	@Test
	void testComparatorConstructorWithList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(-9);
		BinaryMaxHeap<Integer> temp = new BinaryMaxHeap<Integer>(list, (n1, n2) -> {return Math.abs(n1) - Math.abs(n2);});
		assertEquals(temp.peek(), -9);
	}
	
	@Test
	void testFindMaxDouble() {
		assertEquals(doubleHeap.peek(), 8.2);
		assertEquals(doubleHeap.size(), 5);
	}
	
	@Test
	void testFindMaxInt() {
		assertEquals(intHeap.peek(), -800);
		assertEquals(intHeap.size(), 5);
	}
	
	@Test
	void testFindMaxStr() {
		assertEquals(strHeap.peek(), "aaaaaaaaaa");
		assertEquals(strHeap.size(), 10);
	}
	
	@Test
	void testFindMaxError() {
		BinaryMaxHeap<Double> temp = new BinaryMaxHeap<Double>();
		assertThrows(NoSuchElementException.class, () -> {temp.peek();});
	}
	
	@Test
	void testDeleteMaxDouble() {
		assertEquals(doubleHeap.extractMax(), 8.2);
		assertEquals(doubleHeap.size(), 4);
	}
	
	@Test
	void testDeleteMaxInt() {
		assertEquals(intHeap.extractMax(), -800);
		assertEquals(intHeap.size(), 4);
	}
	
	@Test
	void testDeleteMaxStr() {
		assertEquals(strHeap.extractMax(), "aaaaaaaaaa");
		assertEquals(strHeap.size(), 9);
	}
	
	@Test
	void testDeleteMaxTwiceDouble() {
		assertEquals(doubleHeap.extractMax(), 8.2);
		assertEquals(doubleHeap.extractMax(), 7.7);
		assertEquals(doubleHeap.size(), 3);
	}
	
	@Test
	void testDeleteMaxTwiceInt() {
		assertEquals(intHeap.extractMax(), -800);
		assertEquals(intHeap.extractMax(), 200);
		assertEquals(intHeap.size(), 3);
	}
	
	@Test
	void testDeleteMaxTwiceStr() {
		assertEquals(strHeap.extractMax(), "aaaaaaaaaa");
		assertEquals(strHeap.extractMax(), "aaaaaaaaa");
		assertEquals(strHeap.size(), 8);
	}
	
	@Test
	void testDeleteMaxError() {
		BinaryMaxHeap<Double> temp = new BinaryMaxHeap<Double>();
		assertThrows(NoSuchElementException.class, () -> {temp.extractMax();});
	}
	
	@Test
	void testInsertDouble() {
		doubleHeap.add(10.0);
		assertEquals(doubleHeap.size(), 6);
		assertEquals(doubleHeap.peek(), 10.0);
	}
	
	@Test
	void testInsertInt() {
		intHeap.add(1000);
		assertEquals(intHeap.size(), 6);
		assertEquals(intHeap.peek(), 1000);
	}
	
	@Test
	void testInsertStr() {
		strHeap.add("aaaaaaaaaaa");
		assertEquals(strHeap.size(), 11);
		assertEquals(strHeap.peek(), "aaaaaaaaaaa");
	}
	
	@Test
	void testInsertMultipleDouble() {
		for(double i = 10.0; i < 50; i++) {
			doubleHeap.add(i);
		}
		assertEquals(doubleHeap.size(), 45);
	}
	
	@Test
	void testInsertMultipleInt() {
		for(int i = 10; i < 50; i++) {
			intHeap.add(i);
		}
		assertEquals(intHeap.size(), 45);
	}
	
	
	
	@Test
	void testSizeDouble() {
		assertEquals(doubleHeap.size(), 5);
	}
	
	@Test
	void testSizeInt() {
		assertEquals(intHeap.size(), 5);
	}
	
	@Test
	void testSizeString() {
		assertEquals(strHeap.size(), 10);
	}
	
	@Test
	void testSizeResizingDouble() {
		for(double i = 6.0; i <= 100; i++) {
			doubleHeap.add(i);
		}
		assertEquals(doubleHeap.size(), 100);
	}
	
	@Test
	void testSizeResizingInt() {
		for(int i = 6; i <= 100; i++) {
			intHeap.add(i);
		}
		assertEquals(intHeap.size(), 100);
	}
	
	@Test
	void testSizeResizingStr() {
		for(int i = 6; i <= 100; i++) {
			strHeap.add("a");
		}
		assertEquals(strHeap.size(), 105);
	}
	
	@Test
	void testIsEmptyTrue() {
		BinaryMaxHeap<Double> temp = new BinaryMaxHeap<Double>();
		assertTrue(temp.isEmpty());
	}
	
	@Test
	void testIsEmptyFalseDouble() {
		assertFalse(doubleHeap.isEmpty());
	}
	
	@Test
	void testIsEmptyFalseInt() {
		assertFalse(intHeap.isEmpty());
	}
	
	@Test
	void testIsEmptyFalseStr() {
		assertFalse(strHeap.isEmpty());
	}
	
	@Test
	void testClearDouble() {
		doubleHeap.clear();
		assertTrue(doubleHeap.isEmpty());
	}	
	
	@Test
	void testClearInt() {
		intHeap.clear();
		assertTrue(intHeap.isEmpty());
	}
	
	@Test
	void testClearStr() {
		strHeap.clear();
		assertTrue(strHeap.isEmpty());
	}
	
	@Test
	void testToArray() {
		Object[] ls = intHeap.toArray();
		assertEquals(ls[0], -800);
	}
}	