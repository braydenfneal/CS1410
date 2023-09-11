package a7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringSetTest {
	/**
	 * Helps to more easily create test StringSets.
	 */
	private StringSet createThreeElementSet(String e1, String e2, String e3) {
		StringSet set = new StringSet();
		set.insert(e1);
		set.insert(e2);
		set.insert(e3);
		return set;
	}

	/**
	 * Checks that all elements of elemsToCheck are contained within set, and fails
	 * if not.
	 */
	private void checkContainsExactly(StringSet set, String[] elemsToCheck, String failureMessage) {
		for (String elem : elemsToCheck)
			assertTrue(set.contains(elem), failureMessage);
		// We also check the size, to make sure that nothing else is contained
		// This test will fail until you have correctly implemented the size() method
		assertEquals(set.size(), elemsToCheck.length, failureMessage);
	}

	/*********** test constructor ************/

	@Test
	public void testConstructorEmpty() {
		StringSet set = new StringSet();
		assertEquals("{}", set.toString(), "Failed constructing empty set -- invalid string representation");
		assertEquals(0, set.size(), "Failed constructing empty set -- invalid size");
	}

	/*********** test insert ************/

	@Test
	public void testInsert() {
		StringSet set = createThreeElementSet("hello", "goodbye", "why");
		String[] expectedElements = { "hello", "goodbye", "why" };
		checkContainsExactly(set, expectedElements, "Failed constructing 3 element set");
	}

	@Test
	public void testInsertDuplicates() {
		StringSet set = createThreeElementSet("hello", "goodbye", "goodbye");
		String[] expectedElements = { "hello", "goodbye" };
		checkContainsExactly(set, expectedElements, "Failed constructing 2 element set with duplicates");
	}

	@Test
	public void testInsertNull() {
		StringSet set = new StringSet();
		try {
			set.insert(null);
			fail("Did not throw exception when calling insert(null)");
		} catch (IllegalArgumentException e) {
			// If we catch an exception, we pass the test
		}
	}

	/*********** test contains ************/

	@Test
	public void testContainsTrue() {
		StringSet set = createThreeElementSet("hello", "goodbye", "why");
		assertTrue(set.contains("hello"), "Failed checking set for an element that it contains");
		assertTrue(set.contains("why"), "Failed checking set for an element that it contains");
	}

	@Test
	public void testContainsFalse() {
		StringSet set = createThreeElementSet("hello", "goodbye", "why");
		assertFalse(set.contains("he"), "Failed checking set for an element that it does not contain");
		assertFalse(set.contains(""), "Failed checking set for an element that it does not contain");
	}

	@Test
	public void testContainsEmptySet() {
		StringSet set = new StringSet();
		assertFalse(set.contains("x"), "Failed checking set for an element that it does not contain");
	}

	@Test
	public void testContainsNull() {
		StringSet set = new StringSet();
		try {
			set.contains(null);
			fail("Did not throw exception when checking contains(null)");
		} catch (IllegalArgumentException e) {
			// If we catch an exception, we pass the test
		}
	}

	/*********** test toString ************/

	@Test
	public void testToStringOneElement() {
		StringSet set = new StringSet();
		set.insert("cat");
		assertEquals("{cat}", set.toString(), "toString({cat}) failed");
	}

	@Test
	public void testToStringTwoElements() {
		StringSet set = new StringSet();
		set.insert("cat");
		set.insert("dog");
		String str = set.toString();
		// Sets are not guaranteed to have a particular ordering, so we must check both
		// orders.
		assertTrue(str.equals("{cat, dog}") || str.equals("{dog, cat}"), "toString({cat, dog}) failed");
	}

	/*********** test size ************/

	@Test
	public void testSize() {
		StringSet set = createThreeElementSet("hello", "goodbye", "why");
		assertEquals(set.size(), 3);
	}

	@Test
	public void testSizeEmpty() {
		StringSet set = new StringSet();
		assertEquals(set.size(), 0);
	}

	@Test
	public void testSizeWhenRemove() {
		StringSet set = createThreeElementSet("hello", "goodbye", "why");
		set.remove("hello");
		set.remove("why");
		assertEquals(set.size(), 1);
	}

	@Test
	public void testSizeWhenInsert() {
		StringSet set = createThreeElementSet("hello", "goodbye", "why");
		set.insert("Brayden");
		set.insert("Neal");
		assertEquals(set.size(), 5);
	}

	/*********** test remove ************/

	// TODO -- fill this in with several test cases for remove
	@Test
	public void testRemove() {
		StringSet set = createThreeElementSet("hello", "goodbye", "why");
		set.remove("why");
		assertEquals(set.toString(), "{hello, goodbye}");
	}

	@Test
	public void testRemoveDuplicates() {
		StringSet set = createThreeElementSet("hello", "goodbye", "goodbye");
		set.remove("goodbye");
		assertEquals(set.toString(), "{hello}");
	}

	@Test
	public void testRemoveNull() {
		StringSet set = new StringSet();
		try {
			set.remove(null);
			fail("Did not throw exception when calling remove(null)");
		} catch (IllegalArgumentException e) {

		}

	}

	/*********** test union ************/

	@Test
	public void testUnion() {
		StringSet set1 = createThreeElementSet("hello", "goodbye", "why");
		StringSet set2 = createThreeElementSet("Brayden", "Ramsey", "Neal");
		StringSet union = set1.union(set2);
		String expectedElements = "{hello, goodbye, why, Brayden, Ramsey, Neal}";
		assertEquals(union.toString(), expectedElements);
	}

	@Test
	public void testUnionEmpty() {
		StringSet set1 = createThreeElementSet("hello", "goodbye", "why");
		StringSet set2 = new StringSet();
		StringSet union = set1.union(set2);
		String expectedElements = "{hello, goodbye, why}";
		assertEquals(union.toString(), expectedElements);
	}

	@Test
	public void testUnionRemove() {
		StringSet set1 = createThreeElementSet("hello", "goodbye", "why");
		StringSet set2 = createThreeElementSet("Brayden", "Ramsey", "Neal");
		set1.remove("hello");
		set1.remove("why");
		StringSet union = set1.union(set2);
		String expectedElements = "{goodbye, Brayden, Ramsey, Neal}";
		assertEquals(union.toString(), expectedElements);
	}

	@Test
	public void testUnionNull() {
		StringSet set = new StringSet();
		try {
			set.union(null);
			fail("Did not throw exception when calling remove(null)");
		} catch (IllegalArgumentException e) {

		}
	}

	/*********** test intersection ************/

	// TODO -- fill this in with several test cases for intersection
	@Test
	public void testIntersection() {
		StringSet set1 = createThreeElementSet("Brayden", "goodbye", "why");
		StringSet set2 = createThreeElementSet("hello", "Brayden", "Neal");
		StringSet intersection = set1.intersection(set2);
		String expectedElements = "{Brayden}";
		assertEquals(intersection.toString(), expectedElements);
	}

	@Test
	public void testIntersectionTwoElements() {
		StringSet set1 = createThreeElementSet("Brayden", "goodbye", "Neal");
		StringSet set2 = createThreeElementSet("Brayden", "hello", "Neal");
		StringSet intersection = set1.intersection(set2);
		String expectedElements = "{Brayden, Neal}";
		assertEquals(intersection.toString(), expectedElements);
	}

	@Test
	public void testIntersectionThreeElements() {
		StringSet set1 = createThreeElementSet("Brayden", "F", "Neal");
		StringSet set2 = createThreeElementSet("Brayden", "F", "Neal");
		StringSet intersection = set1.intersection(set2);
		String expectedElements = "{Brayden, F, Neal}";
		assertEquals(intersection.toString(), expectedElements);
	}

	@Test
	public void testZeroIntersection() {
		StringSet set1 = createThreeElementSet("Brayden", "F", "Neal");
		StringSet set2 = createThreeElementSet("is", "pretty", "cool");
		StringSet intersection = set1.intersection(set2);
		String expectedElements = "{}";
		assertEquals(intersection.toString(), expectedElements);
	}

	@Test
	public void testIntersectionNull() {
		StringSet set = new StringSet();
		try {
			set.intersection(null);
			fail("Did not throw exception when calling remove(null)");
		} catch (IllegalArgumentException e) {

		}
	}
}
