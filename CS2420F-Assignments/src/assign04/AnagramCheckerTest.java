package assign04;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnagramCheckerTest
{
	public static class AnagramComparator implements Comparator<String>
	{
		@Override
		public int compare(String o1, String o2)
		{
			if(o1.hashCode() > o2.hashCode())
				return 1;
			if(o1.hashCode() < o2.hashCode())
				return -1;
			else
				return 0; 
		}
	}
	private String[] empty;
	AnagramComparator cmp;
	@BeforeEach
	void setUp() throws Exception {

		empty = new String[0];
		cmp = new AnagramComparator();
	}

	@Test
	void testLargestAnagramEmptyArray() {

		assertThrows(IllegalArgumentException.class, () -> {
			AnagramChecker.getLargestAnagramGroup(empty);
		});
	}

	@Test
	void testLargestAnagramNoFile() {
		assertThrows(NullPointerException.class, () -> {
			AnagramChecker.getLargestAnagramGroup("noFile.txt");
		});
	}
	
	@Test
	void testLargestAnagramNoAnagrams() {
	String[] arr = new String[]{"will", "Neal", "Will", "Dreyer"};
	String[] resultt = AnagramChecker.getLargestAnagramGroup(arr);
	String[] result = new String[] {"will", "Will"};
	for(int i = 0; i < resultt.length; i ++)
	{
		assertEquals(resultt[i], result[i]);
	}
}
	

	@Test
	void testAreAnagramsTrue() {
		String o1 = "banana";
		String o2 = "ananab";
		assertTrue(AnagramChecker.areAnagrams(o1, o2));
	}

	@Test
	void testAreAnagramsFalse() {
		String o1 = "banana";
		String o2 = "apple";
		assertFalse(AnagramChecker.areAnagrams(o1, o2));
	}

	@Test
	void testAreAnagramsTrueUpperCase() {
		String o1 = "BANaNA";
		String o2 = "AABNNa";
		assertTrue(AnagramChecker.areAnagrams(o1, o2));
	}
	
	@Test
	void testAreAnagramsNullException1() {
		String o1 = "banana";
		String o2 = null;
		assertThrows(NullPointerException.class, () -> {
			AnagramChecker.areAnagrams(o1, o2);
		});
	}
	
	@Test
	void testAreAnagramsNullException2() {
		String o1 = null;
		String o2 = "ananab";
		assertThrows(NullPointerException.class, () -> {
			AnagramChecker.areAnagrams(o1, o2);
		});
	}
	@Test
	void testAreAnagramsNullException3() {
		String o1 = null;
		String o2 = null;
		assertThrows(NullPointerException.class, () -> {
			AnagramChecker.areAnagrams(o1, o2);
		});
	}
	
	@Test
	private void testGetLargestAnagram(){
		String[] arr = new String[]{"lead", "deal", "role"};
		String[] result = new String[]{"lead", "deal"};
		assertEquals(result, AnagramChecker.getLargestAnagramGroup(arr));
	}
	
	@Test
	private void testGetLargestAnagramLarge(){
		String[] arr = new String[]{"lead", "deal", "dale", "role", "lore"};
		String[] result = new String[]{"lead", "deal", "dale"};
		assertEquals(result, AnagramChecker.getLargestAnagramGroup(arr));
	}
	
	@Test
	void testSortMethodLowerCase()
	{
		assertEquals("bkoo", AnagramChecker.sort("book"));
	}
	
	@Test
	void testSortMethodUpperCase()
	{
		assertEquals("BOOk", AnagramChecker.sort("kOOB"));
	}
	
	@Test
	void testSortNullException()
	{
		Exception exception =  assertThrows(NullPointerException.class, () -> { AnagramChecker.sort(null);});
		String expectedMessage = "The inputted String is null.";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void insertionSortTestBasic()
	{
		String[] arr = new String[]{"lead", "deal", "dale", "role", "lore"};
		String[] result = new String[]{"dale", "deal", "lead", "lore", "role"};
		AnagramChecker.insertionSort(arr, cmp);
		for(int i = 0; i < arr.length; i ++)
		{
			assertTrue(result[i].equals(arr[i]));
		}
	}
	
	@Test
	void insertionSortOnNull() {
		String[] arr = new String[]{};
		AnagramChecker.insertionSort(arr, cmp);
		String[] arr2 = new String[] {};
		assertTrue(arr.length == 0 && arr2.length == 0);
	}
	
	@Test
	void insertionSortAlreadySorted() {
		String[] arr = new String[]{"a", "b", "c", "d", "e"};
		AnagramChecker.insertionSort(arr, cmp);
		String[] arr2 = new String[] {"a", "b", "c", "d", "e"};
		for(int i = 0; i < arr.length; i ++)
			assertEquals(arr[i], arr2[i]);
	}
	
	@Test
	void testAreAnagrams() {
		assertTrue(AnagramChecker.areAnagrams("alert", "Later"));
	}
	
	@Test
	void basicSort() {
		assertEquals("FIa", AnagramChecker.sort("IaF"));
	}
	
	
	

}
