package assign05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author William Dreyer and Brayden Neal
 * @version 3/1/21
 * 
 * This is a tester class for the ArrayListSorter class.
 */
class ArrayListSorterTest
{
	private ArrayList<Integer> emptyList, singleList, doubleList, threeList, tenList, duplicateList;
	private ArrayList<String> singleStringList, doubleStringList, tenStringList, duplicateStringList;
	private ArrayList<Character> singleCharList, doubleCharList, tenCharList;
	private ArrayList<Double> singleDoubleList, doubleDoubleList, tenDoubleList;
	private static ArrayList<Integer> twoDesc, threeDesc, tenDesc;
	private static ArrayList<Integer> twoAsc, threeAsc, tenAsc;
	private static ArrayList<Integer> twoPer, tenPer, fiftyPer;
	
	//when debugging put a break point at the beginning of set up
	@BeforeEach
	void setUp() throws Exception
	{
		emptyList= new ArrayList<Integer>();
		duplicateList = new ArrayList<Integer>();
		duplicateList.add(3);
		duplicateList.add(2);
		duplicateList.add(2);
		duplicateList.add(8);
		duplicateStringList = new ArrayList<String>();
		duplicateStringList.add("boing");
		duplicateStringList.add("doing");
		duplicateStringList.add("boing");
		duplicateStringList.add("moing");
		singleList = new ArrayList<Integer>();
		singleList.add(5);
		doubleList = new ArrayList<Integer>();
		doubleList.add(3);
		doubleList.add(5);
		threeList = new ArrayList<Integer>();
		threeList.add(1); threeList.add(2); threeList.add(3);
		tenList = new ArrayList<Integer>();
		tenList.add(2); tenList.add(4); tenList.add(6); tenList.add(8); tenList.add(10); 
		tenList.add(12); tenList.add(14); tenList.add(16); tenList.add(18); tenList.add(20);
		singleStringList = new ArrayList<String>(); singleStringList.add("georgia");
		doubleStringList = new ArrayList<String>(); doubleStringList.add("georgia"); doubleStringList.add("iowa");
		tenStringList = new ArrayList<String>(); tenStringList.add("georgia"); tenStringList.add("iowa"); tenStringList.add("florida"); tenStringList.add("colorado");
		tenStringList.add("oregon"); tenStringList.add("california"); tenStringList.add("minnesota"); tenStringList.add("rhode island"); tenStringList.add("maine"); tenStringList.add("utah");
		singleCharList = new ArrayList<Character>(); singleCharList.add('f');
		doubleCharList = new ArrayList<Character>(); doubleCharList.add('f'); doubleCharList.add('y');
		tenCharList = new ArrayList<Character>(); tenCharList.add('f'); tenCharList.add('y'); tenCharList.add('u'); tenCharList.add('c'); tenCharList.add('s'); 
		tenCharList.add('p'); tenCharList.add('z'); tenCharList.add('l'); tenCharList.add('s'); tenCharList.add('x');
		singleDoubleList = new ArrayList<Double>();
		singleDoubleList.add(5.6);
		doubleDoubleList = new ArrayList<Double>();
		doubleDoubleList.add(3.4);
		doubleDoubleList.add(5.8);
		tenDoubleList = new ArrayList<Double>();
		tenDoubleList.add(2.9); tenDoubleList.add(4.2); tenDoubleList.add(6.9); tenDoubleList.add(8.1); tenDoubleList.add(10.23); 
		tenDoubleList.add(1.2); tenDoubleList.add(14.8); tenDoubleList.add(16.1); tenDoubleList.add(18.71); tenDoubleList.add(20.528);
		
		
		twoDesc = ArrayListSorter.generateDescending(2);
		threeDesc = ArrayListSorter.generateDescending(3);
		tenDesc = ArrayListSorter.generateDescending(10);
		twoAsc= ArrayListSorter.generateAscending(2);
		threeAsc = ArrayListSorter.generateAscending(3);
		tenAsc = ArrayListSorter.generateAscending(10);
		twoPer = ArrayListSorter.generatePermuted(2);
		tenPer = ArrayListSorter.generatePermuted(10);
		fiftyPer = ArrayListSorter.generatePermuted(50);
	}
	
	//Tests the methods when dealing with empty Array Lists********************************************************
	
	@Test
	void emptyListMerge()
	{
		ArrayListSorter.mergesort(emptyList);
		assertTrue(emptyList.isEmpty());
	}
	
	@Test
	void emptyListQuick()
	{
		ArrayListSorter.quicksort(emptyList);
		assertTrue(emptyList.isEmpty());
	}
	
	@Test
	void checkForInsertionSortEmptyMerge()
	{
		ArrayListSorter.mergesort(emptyList);
		assertEquals(true, ArrayListSorter.checkForInsertionSort());
	}
	
	@Test
	void checkForInsertionSortEmptyQuick()
	{
		ArrayListSorter.quicksort(emptyList);
		assertEquals(true, ArrayListSorter.checkForInsertionSort());
	}
	
	//Tests the sorting methods with lists that contain duplicate elements
	
	@Test
	void duplicateMerge()
	{
		ArrayListSorter.mergesort(duplicateList);
		assertEquals(duplicateList.get(0), 2);
		assertEquals(duplicateList.get(1), 2);
		assertEquals(duplicateList.get(2), 3);
		assertEquals(duplicateList.get(3), 8);
	}
	
	@Test
	void duplicateQuick()
	{
		ArrayListSorter.quicksort(duplicateList);
		assertEquals(duplicateList.get(0), 2);
		assertEquals(duplicateList.get(1), 2);
		assertEquals(duplicateList.get(2), 3);
		assertEquals(duplicateList.get(3), 8);
	}
	@Test
	void duplicateStringMerge()
	{
		ArrayListSorter.mergesort(duplicateStringList);
		assertEquals(duplicateStringList.get(0), "boing");
		assertEquals(duplicateStringList.get(1), "boing");
		assertEquals(duplicateStringList.get(2), "doing");
		assertEquals(duplicateStringList.get(3), "moing");
	}
	
//	@Test
//	void duplicateStringQuick()
//	{
//		ArrayListSorter.quicksort(duplicateStringList);
//		assertEquals(duplicateStringList.get(0), "boing");
//		assertEquals(duplicateStringList.get(1), "doing");
//		assertEquals(duplicateStringList.get(2), "boing");
//		assertEquals(duplicateStringList.get(3), "moing");
//	}
	
	//Tests the methods with single element Array Lists************************************************************
	
	@Test
	void singleListMergeInt()
	{
		ArrayListSorter.mergesort(singleList);
		assertEquals(1, singleList.size());
		assertEquals(5, singleList.get(0));
	}
	
	@Test
	void singleListQuickInt()
	{
		ArrayListSorter.quicksort(singleList);
		assertEquals(1, singleList.size());
		assertEquals(5, singleList.get(0));
	}
	
	@Test
	void singleListMergeString()
	{
		ArrayListSorter.mergesort(singleStringList);
		assertEquals(1, singleStringList.size());
		assertEquals("georgia", singleStringList.get(0));
	}
	
	@Test
	void singleListQuickString()
	{
		ArrayListSorter.quicksort(singleStringList);
		assertEquals(1, singleStringList.size());
		assertEquals("georgia", singleStringList.get(0));
	}
	
	@Test
	void singleListMergeChar()
	{
		ArrayListSorter.mergesort(singleCharList);
		assertEquals(1, singleCharList.size());
		assertEquals('f', singleCharList.get(0));
	}
	
	@Test
	void singleListQuickChar()
	{
		ArrayListSorter.quicksort(singleCharList);
		assertEquals(1, singleCharList.size());
		assertEquals('f', singleCharList.get(0));
	}
	
	@Test
	void singleListMergeDouble()
	{
		ArrayListSorter.mergesort(singleDoubleList);
		assertEquals(1, singleDoubleList.size());
		assertEquals(5.6, singleDoubleList.get(0));
	}
	
	@Test
	void singleListQuickDouble()
	{
		ArrayListSorter.quicksort(singleDoubleList);
		assertEquals(1, singleDoubleList.size());
		assertEquals(5.6, singleDoubleList.get(0));
	}
	
	//These tests are for lists that have only two elements********************************************************
	
	@Test
	void doubleIntListMerge()
	{
		ArrayListSorter.mergesort(doubleList);
		assertEquals(2, doubleList.size());
		assertEquals(3, doubleList.get(0));
	}
	
	@Test 
	void doubleIntListQuick()
	{
		ArrayListSorter.mergesort(doubleList);
		assertEquals(2, doubleList.size());
		assertEquals(3, doubleList.get(0));
	}
	
	@Test
	void twoNumsAscMerge()
	{
		ArrayListSorter.mergesort(twoAsc);
		assertEquals(twoAsc, ArrayListSorter.generateAscending(2));
	}
	
	@Test
	void twoNumsAscQuick()
	{
		ArrayListSorter.quicksort(twoAsc);
		assertEquals(twoAsc, ArrayListSorter.generateAscending(2));
	}
	
	@Test
	void twoNumsDescMerge()
	{
		ArrayListSorter.mergesort(twoDesc);
		assertEquals(twoDesc, ArrayListSorter.generateAscending(2));
	}
	
	@Test
	void twoNumsDescQuick()
	{
		ArrayListSorter.quicksort(twoDesc);
		assertEquals(twoDesc, ArrayListSorter.generateAscending(2));
	}
	
	@Test
	void twoNumsPerMerge()
	{
		ArrayListSorter.mergesort(twoPer);
		assertEquals(2, twoPer.get(1));
	}
	
	@Test
	void twoNumsPerQuick()
	{
		ArrayListSorter.quicksort(twoPer);
		assertEquals(2, twoPer.get(1));
	}
	
	@Test
	void doubleDoubleListMerge()
	{
		ArrayListSorter.mergesort(doubleDoubleList);
		assertEquals(2, doubleDoubleList.size());
		assertEquals(3.4, doubleDoubleList.get(0));
	}
	
	@Test 
	void doubleDoubleListQuick()
	{
		ArrayListSorter.mergesort(doubleDoubleList);
		assertEquals(2, doubleDoubleList.size());
		assertEquals(3.4, doubleDoubleList.get(0));
	}
	
	@Test
	void doubleStringListMerge()
	{
		ArrayListSorter.mergesort(doubleStringList);
		assertEquals(2, doubleStringList.size());
		assertEquals("iowa", doubleStringList.get(1));
	}
	
	@Test 
	void doubleStringListQuick()
	{
		ArrayListSorter.mergesort(doubleStringList);
		assertEquals(2, doubleStringList.size());
		assertEquals("georgia", doubleStringList.get(0));
	}
	
	@Test
	void doubleCharListMerge()
	{
		ArrayListSorter.mergesort(doubleCharList);
		assertEquals(2, doubleCharList.size());
		assertEquals('y', doubleCharList.get(1));
	}
	
	@Test 
	void doubleCharListQuick()
	{
		ArrayListSorter.mergesort(doubleCharList);
		assertEquals(2, doubleCharList.size());
		assertEquals('f', doubleCharList.get(0));
	}
	
	//These tests are for the unique three item int array lists****************************************************************
	
	@Test
	void multiListMerge()
	{
		ArrayListSorter.mergesort(threeList);
		assertEquals(3, threeList.size());
		assertEquals(1, threeList.get(0));
		assertEquals(3, threeList.get(2));
	}
	
	@Test
	void multiListMergeEqual()
	{
		ArrayListSorter.mergesort(threeList);
	}
	
	@Test
	void checkForInsertionInMerge()
	{
		ArrayListSorter.mergesort(threeList);
		assertEquals(true, ArrayListSorter.checkForInsertionSort());
	}
	
	@Test
	void checkForInsertionInQuick()
	{
		ArrayListSorter.quicksort(threeList);
		assertTrue(ArrayListSorter.checkForInsertionSort());
	}
	
	@Test
	void threeNumsAscMerge()
	{
		ArrayListSorter.mergesort(threeAsc);
		assertEquals(threeAsc, ArrayListSorter.generateAscending(3));
	}
	
	@Test
	void threeNumsAscQuick()
	{
		ArrayListSorter.quicksort(threeAsc);
		assertEquals(threeAsc, ArrayListSorter.generateAscending(3));
	}
	
	@Test
	void threeNumsDescMerge()
	{
		ArrayListSorter.mergesort(threeDesc);
		assertEquals(threeDesc, ArrayListSorter.generateAscending(3));
	}
	
	@Test
	void threeNumsDescQuick()
	{
		ArrayListSorter.quicksort(threeDesc);
		assertEquals(threeDesc, ArrayListSorter.generateAscending(3));
	}
	
	//These tests are for the larger array lists****************************************************************
	
	@Test
	void tenNumsAscMerge()
	{
		ArrayListSorter.mergesort(tenAsc);
		assertEquals(tenAsc, ArrayListSorter.generateAscending(10));
	}
	
	@Test
	void tenNumsAscQuick()
	{
		ArrayListSorter.quicksort(tenAsc);
		assertEquals(tenAsc, ArrayListSorter.generateAscending(10));
	}
	
	@Test
	void tenNumsDescMerge()
	{
		ArrayListSorter.mergesort(tenDesc);
		assertEquals(tenDesc, ArrayListSorter.generateAscending(10));
	}
	
	@Test
	void tenNumsDescQuick()
	{
		ArrayListSorter.quicksort(tenDesc);
		assertEquals(tenDesc, ArrayListSorter.generateAscending(10));
	}
	
	@Test
	void tenNumsPerMerge()
	{
		ArrayListSorter.mergesort(tenPer);
		assertEquals(tenPer, ArrayListSorter.generateAscending(10));
	}
	
	@Test
	void tenNumsPerQuick()
	{
		ArrayListSorter.quicksort(tenPer);
		assertEquals(tenPer, ArrayListSorter.generateAscending(10));
	}
	
	@Test
	void fiftyNumsPerMerge()
	{
		ArrayListSorter.mergesort(fiftyPer);
		assertEquals(fiftyPer, ArrayListSorter.generateAscending(50));
	}
	
	@Test
	void fiftyNumsPerQuick()
	{
		ArrayListSorter.quicksort(fiftyPer);
		assertEquals(fiftyPer, ArrayListSorter.generateAscending(50));
	}
	
	//These tests are for the generate list methods
	@Test
	void genAsc()
	{
		ArrayList<Integer> test = ArrayListSorter.generateAscending(5);
		assertEquals(test.get(0), 1);
		assertEquals(test.get(1), 2);
		assertEquals(test.get(2), 3);
		assertEquals(test.get(3), 4);
		assertEquals(test.get(4), 5);
	}
	
	@Test
	void genDesc()
	{
		ArrayList<Integer> test = ArrayListSorter.generateDescending(5);
		assertEquals(test.get(0), 5);
		assertEquals(test.get(1), 4);
		assertEquals(test.get(2), 3);
		assertEquals(test.get(3), 2);
		assertEquals(test.get(4), 1);
	}
	
	@Test
	void genPer()
	{
		ArrayList<Integer> test = ArrayListSorter.generatePermuted(1);
		assertEquals(test.get(0), 1);
	}

}
