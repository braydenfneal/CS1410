package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayCollectionTest<T> {
	class BinarySearchTestsString implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			int result = 0;
			if (o1.hashCode() > o2.hashCode()) {
				result = 1;
			} else if (o1.hashCode() < o2.hashCode()) {
				result = -1;
			} else {
				result = 0;
			}
			return result;
		}
	}

	class BinarySearchTests implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			int result = 0;

			if (o1 > o2) {
				result = 1;
			} else if (o1 < o2) {
				result = -1;
			} else {
				result = 0;
			}

			return result;
		}
	}

	class CompareTests implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			int result = 0;

			if (o1 > o2) {
				result = 1;
			} else if (o1 < o2) {
				result = -1;
			} else {
				result = 0;
			}

			return result;
		}

	}

	class compareStrings implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			int result = 0;
			if (o1.hashCode() > o2.hashCode()) {
				result = 1;
			} else if (o1.hashCode() < o2.hashCode()) {
				result = -1;
			} else {
				result = 0;
			}
			return result;
		}

	}

	private ArrayCollection<Integer> empty;
	private ArrayCollection<Integer> oneInteger;
	// private ArrayCollectionIterator<Integer> iter;

	@BeforeEach
	void setUp() throws Exception {

		empty = new ArrayCollection<Integer>();
		// make an array collection with > 10 elements
		oneInteger = new ArrayCollection<>();
		oneInteger.add(1);

	}

	@Test
	void testEmptySize() {
		assertEquals(0, empty.size());
		assertTrue(empty.isEmpty());

	}

	@Test
	void testAddOnEmpty() {
		assertTrue((empty.add(1)));
	}

	@Test
	void testAddOnSingle() {
		assertTrue((oneInteger.add(2)));
	}

	@Test
	void testContains() {
		assertTrue(oneInteger.contains(1));
	}

	@Test
	void testAddAndIsEmptyTest() {
		assertTrue((empty.add(1)));
		assertFalse(empty.isEmpty());
	}

	@Test
	void testRemoveContainsAndSize() {
		assertTrue(oneInteger.remove(1));
		assertFalse(oneInteger.contains(1));
		assertEquals(0, oneInteger.size());
	}

	@Test
	void testRemoveOnSingle() {
		assertTrue(oneInteger.remove(1));
	}

	@Test
	void testContainsOnSingle() {
		oneInteger.remove(1);
		assertFalse(oneInteger.contains(1));
	}

	@Test
	void testRemoveEmpty() {
		assertFalse(empty.remove(1));
	}

	@Test
	void testForEmptyRemove() {
		assertThrows(IllegalStateException.class, () -> empty.iterator().remove());
	}

	@Test
	void testForDoubleNext() {
		ArrayCollection<Integer> arr = new ArrayCollection<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		Iterator<Integer> iter = arr.iterator();
		int x = iter.next();
		int y = iter.next();
		assertEquals(1, x);
		assertEquals(2, y);
	}

	@Test
	void testIteratorConstruction() {
		ArrayCollection<Integer> arr = new ArrayCollection<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		Iterator<Integer> iter = arr.iterator();
		int x = iter.next();
		Iterator<Integer> iterB = arr.iterator();
		int y = iterB.next();
		assertEquals(1, x);
		assertEquals(1, y);
	}

	@Test
	void testIteratorConstructionDouble() {
		ArrayCollection<Double> doubleArr = new ArrayCollection<>();
		doubleArr.add(1.0);
		doubleArr.add(2.0);
		doubleArr.add(3.0);
		Iterator<Double> iter = doubleArr.iterator();
		double x = iter.next();
		Iterator<Double> iterB = doubleArr.iterator();
		double y = iterB.next();
		assertEquals(1.0, x);
		assertEquals(1.0, y);
	}

	@Test
	void testIteratorConstructionString() {
		ArrayCollection<String> stringArr = new ArrayCollection<>();
		stringArr.add("book");
		stringArr.add("song");
		stringArr.add("smoke");
		Iterator<String> iter = stringArr.iterator();
		String x = iter.next();
		Iterator<String> iterB = stringArr.iterator();
		iterB.next();
		String y = iterB.next();
		assertEquals("book", x);
		assertEquals("song", y);
	}

	@Test
	void testIteratorConstructionBoolean() {
		ArrayCollection<Boolean> booleanArr = new ArrayCollection<>();
		booleanArr.add(true);
		booleanArr.add(false);
		booleanArr.add(true);
		Iterator<Boolean> iter = booleanArr.iterator();
		boolean x = iter.next();
		Iterator<Boolean> iterB = booleanArr.iterator();
		iterB.next();
		boolean y = iterB.next();
		assertEquals(true, x);
		assertEquals(false, y);
	}

	@Test
	void testContainsStringArrSmall() {
		ArrayCollection<String> stringArr = new ArrayCollection<>();
		stringArr.add("I");
		stringArr.add("love");
		stringArr.add("books");
		assertTrue(stringArr.contains("I"));
		assertFalse(stringArr.contains("words"));
	}

	@Test
	void testContainsStringArrLarge() {
		ArrayCollection<String> stringArr = new ArrayCollection<>();
		stringArr.add("I");
		stringArr.add("love");
		stringArr.add("books");
		stringArr.add("and");
		stringArr.add("action");
		stringArr.add("movies");
		assertTrue(stringArr.contains("movies"));
		assertFalse(stringArr.contains("birds"));
	}

	@Test
	void testContainsDoubleArrSmall() {
		ArrayCollection<Double> doubleArr = new ArrayCollection<>();
		doubleArr.add(1.5);
		doubleArr.add(2.5);
		doubleArr.add(3.5);
		assertTrue(doubleArr.contains(1.5));
		assertFalse(doubleArr.contains(1.6));
	}

	@Test
	void testContainsDoubleArrLarge() {
		ArrayCollection<Double> doubleArr = new ArrayCollection<>();
		doubleArr.add(1.5);
		doubleArr.add(2.5);
		doubleArr.add(3.5);
		doubleArr.add(4.5);
		doubleArr.add(5.5);
		doubleArr.add(6.5);
		assertTrue(doubleArr.contains(6.5));
		assertFalse(doubleArr.contains(1.6));
	}

	@Test
	void testContainsDoubleArrNegative() {
		ArrayCollection<Double> doubleArr = new ArrayCollection<>();
		doubleArr.add(-1.5);
		doubleArr.add(-2.5);
		doubleArr.add(-3.5);
		assertTrue(doubleArr.contains(-1.5));
		assertFalse(doubleArr.contains(-1.6));
	}

	@Test
	void testSortedListStringArr() {
		ArrayCollection<String> strings = new ArrayCollection<>();
		strings.add("william");
		strings.add("jasper");
		strings.add("dreyer");
		Object[] stringSort = new Object[] { "dreyer", "jasper", "william" };
		final compareStrings comparing = new compareStrings();
		ArrayList<String> stringsSorted = strings.toSortedList(comparing);
		Object[] arrStringsSorted = stringsSorted.toArray();
		assertTrue(stringSort[0].equals(arrStringsSorted[0]));
	}

	@Test
	void testRemoveStringArr() {
		ArrayCollection<String> strings = new ArrayCollection<>();
		strings.add("william");
		strings.add("jasper");
		strings.add("dreyer");
		ArrayCollection<String> stringsUnedited = new ArrayCollection<>();
		stringsUnedited.add("william");
		stringsUnedited.add("jasper");
		stringsUnedited.add("dreyer");
		Iterator<String> iter = strings.iterator();
		iter.next();
		iter.remove();
		iter.next();
		iter.remove();
		iter.next();
		iter.remove();
		assertFalse(strings.containsAll(stringsUnedited));
	}

	@Test
	void testRetainStringArr() {
		ArrayCollection<String> strings = new ArrayCollection<>();
		strings.add("william");
		strings.add("jasper");
		strings.add("dreyer");
		ArrayCollection<String> stringsUnedited = new ArrayCollection<>();
		stringsUnedited.add("jasper");
		stringsUnedited.add("william");
		stringsUnedited.add("dreyer");
		assertTrue(strings.retainAll(stringsUnedited));
	}

	@Test
	void testRetainStringArrLarge() {
		ArrayCollection<String> strings = new ArrayCollection<>();
		strings.add("william");
		strings.add("jasper");
		strings.add("dreyer");
		strings.add("Brayden");
		strings.add("Fitzroy");
		strings.add("Neal");
		ArrayCollection<String> stringsUnedited = new ArrayCollection<>();
		stringsUnedited.add("jasper");
		stringsUnedited.add("william");
		stringsUnedited.add("dreyer");
		stringsUnedited.add("Fitzroy");
		stringsUnedited.add("Brayden");
		stringsUnedited.add("Neal");
		assertTrue(strings.retainAll(stringsUnedited));
	}

	@Test
	void testRetainIntegerArr() {
		ArrayCollection<Integer> ints = new ArrayCollection<>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ArrayCollection<Integer> intsUnedited = new ArrayCollection<>();
		intsUnedited.add(3);
		intsUnedited.add(1);
		intsUnedited.add(2);
		assertTrue(ints.retainAll(intsUnedited));
	}

	@Test
	void testRetainIntegerArrLarge() {
		ArrayCollection<Integer> ints = new ArrayCollection<>();
		ints.add(1);
		ints.add(2);
		ints.add(3);
		ints.add(4);
		ints.add(5);
		ints.add(6);
		ArrayCollection<Integer> intsUnedited = new ArrayCollection<>();
		intsUnedited.add(3);
		intsUnedited.add(1);
		intsUnedited.add(2);
		intsUnedited.add(6);
		intsUnedited.add(4);
		intsUnedited.add(5);
		assertTrue(ints.retainAll(intsUnedited));
	}

	@Test
	void testAddAllContainsSmall() {
		ArrayCollection<Integer> example = new ArrayCollection<>();
		example.add(1);
		example.add(2);
		example.add(3);
		example.add(4);
		example.add(5);
		empty.addAll(example);
		assertTrue(empty.contains(5));
	}

	@Test
	void testAddAllContainsLarge() {
		ArrayCollection<Integer> example = new ArrayCollection<>();
		example.add(1);
		example.add(2);
		example.add(3);
		example.add(4);
		example.add(5);
		example.add(6);
		example.add(7);
		example.add(8);
		example.add(9);
		example.add(10);
		empty.addAll(example);
		assertTrue(empty.contains(10));
	}

	@Test
	void testAddAllRemoveAllSmall() {
		ArrayCollection<Integer> example = new ArrayCollection<>();
		example.add(1);
		example.add(2);
		example.add(3);
		example.add(4);
		example.add(5);
		empty.addAll(example);
		empty.removeAll(example);
		assertTrue(empty.isEmpty());
	}

	@Test
	void testAddAllRemoveAllLarge() {
		ArrayCollection<Integer> example = new ArrayCollection<>();
		example.add(1);
		example.add(2);
		example.add(3);
		example.add(4);
		example.add(5);
		example.add(6);
		example.add(7);
		example.add(8);
		example.add(9);
		empty.addAll(example);
		empty.removeAll(example);
		assertTrue(empty.isEmpty());
	}

	@Test
	void testSortedList() {
		ArrayCollection<Integer> sorted = new ArrayCollection<>();
		sorted.add(1);
		sorted.add(2);
		sorted.add(3);
		sorted.add(4);
		sorted.add(5);
		ArrayCollection<Integer> unsorted = new ArrayCollection<>();
		unsorted.add(2);
		unsorted.add(5);
		unsorted.add(4);
		unsorted.add(1);
		unsorted.add(3);
		final CompareTests comparing = new CompareTests();
		Object[] newSorted = unsorted.toSortedList(comparing).toArray();
		// ArrayCollection<Integer> newSortedB = new ArrayCollection<>();
		// newSortedB.addAll(newSorted);
		Object[] sortedArray = sorted.toArray();
		assertTrue(sortedArray[0].equals(newSorted[0]));
		assertTrue(sortedArray[1].equals(newSorted[1]));
		assertTrue(sortedArray[2].equals(newSorted[2]));
		assertTrue(sortedArray[3].equals(newSorted[3]));
		assertTrue(sortedArray[4].equals(newSorted[4]));

	}

	@Test
	void testBinarySearchTrueInt() {
		ArrayList<Integer> sample = new ArrayList<Integer>();
		sample.add(1);
		sample.add(2);
		sample.add(3);
		sample.add(4);
		sample.add(5);
		final BinarySearchTests comparing = new BinarySearchTests();
		assertTrue(SearchUtil.binarySearch(sample, 3, comparing));
	}

	@Test
	void testBinarySearchFalseInt() {
		ArrayList<Integer> sample = new ArrayList<Integer>();
		sample.add(1);
		sample.add(2);
		sample.add(3);
		sample.add(4);
		sample.add(5);
		final BinarySearchTests comparing = new BinarySearchTests();
		assertFalse(SearchUtil.binarySearch(sample, 6, comparing));
	}

	@Test
	void testBinarySearchTrueString() {
		ArrayList<String> sample = new ArrayList<String>();
		sample.add("hotdog");
		sample.add("banana");
		sample.add("cheese");
		sample.add("sauce");
		sample.add("apple");
		final BinarySearchTestsString comparing = new BinarySearchTestsString();
		assertTrue(SearchUtil.binarySearch(sample, "cheese", comparing));
	}

	@Test
	void testBinarySearchFalseString() {
		ArrayList<String> sample = new ArrayList<String>();
		sample.add("hotdog");
		sample.add("banana");
		sample.add("cheese");
		sample.add("sauce");
		sample.add("apple");
		final BinarySearchTestsString comparing = new BinarySearchTestsString();
		assertFalse(SearchUtil.binarySearch(sample, "corn", comparing));
	}
}
