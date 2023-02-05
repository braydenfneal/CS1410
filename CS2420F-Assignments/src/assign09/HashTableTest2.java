package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashTableTest2<K, V>
{
		private HashTableB<String, Integer> map;
		private HashTableB<Integer, String> integerMap;
		private HashTableB<Double, Integer> doubleMap;
		private HashTableB<Boolean, Double> booleanMap;
		private HashTableB<Integer, Boolean> intBoolMap;
		private HashTableB<String, Double> doubleTable;
		private HashTableB<Integer, String> stringjTable;

		
		@BeforeEach
		 void setUp() throws Exception
		{
			map  = new HashTableB<String, Integer>();
			map.put("this", 1);
			map.put("coder", 2);
			map.put("nickel", 3);
			map.put("quarter", 4);
			map.put("hi", 5);
			integerMap = new HashTableB<Integer, String>();
			integerMap.put(1, "apple");
			integerMap.put(2, "book");
			integerMap.put(3, "cat");
			doubleMap = new HashTableB<Double, Integer>();
			doubleMap.put(1.5, 2);
			doubleMap.put(2.5, 3);
			doubleMap.put(3.5, 4);
			booleanMap = new HashTableB<Boolean, Double>();
			booleanMap.put(true, 5.5);
			booleanMap.put(false, 6.5);
			intBoolMap = new HashTableB<Integer, Boolean>();
			intBoolMap.put(1, true);
			intBoolMap.put(2, false);
			intBoolMap.put(3, true);
			
			doubleTable = new HashTableB<String, Double>();
			stringjTable = new HashTableB<Integer, String>();
			doubleTable.put("Boing", 5.5);
			doubleTable.put("Froin", 9.8);
			doubleTable.put("Help", 2.0);
		
			stringjTable.put(1, "One");
			stringjTable.put(2, "Two");
			stringjTable.put(3, "Three");
			stringjTable.put(4, "Four");
			stringjTable.put(5, "Five");
			stringjTable.put(6, "Six");
			stringjTable.put(7, "Seven");
			stringjTable.put(8, "Eight");
			stringjTable.put(9, "Nine");
			stringjTable.put(10, "Ten");
		
		}
		
		
	@Test
	void removeSizeTest() {
		doubleTable.remove("Boing");
		assertEquals(doubleTable.size(), 2);
	}
	
	@Test
	void removeSizeStringTest() {
		stringjTable.remove(1);
		assertEquals(stringjTable.size(), 9);
	}
	
	@Test
	void removeValueTest() {
		assertEquals(doubleTable.remove("Boing"), 5.5);
	}
	
	@Test
	void removeValueStringTest() {
		assertEquals(stringjTable.remove(5), "Five");
	}
	
	@Test
	void removeNullTest() {
		assertNull(doubleTable.remove("Nope"));
	}
	
	@Test
	void removeNullStringTest() {
		assertNull(stringjTable.remove(11));
	}
	
	@Test
	void alternateRemoveSizeTest() {
		doubleTable.remove("Boing");
		assertNull(doubleTable.remove("Boing"));
	}
	
	@Test
	void alternateRemoveSizeStringTest() {
		stringjTable.remove(2);
		assertNull(stringjTable.remove(2));
	}
	
	@Test
	void putTest() {
		doubleTable.put("Bear", 8.0);
		assertTrue(doubleTable.containsKey("Bear"));
		assertEquals(doubleTable.size(), 4);
	}
	
	@Test
	void putStringTest() {
		stringjTable.put(15, "Fifteen");
		assertTrue(stringjTable.containsKey(15));
		assertEquals(stringjTable.size(), 11);
	}
	
	@Test
	void putReplaceTest() {
		doubleTable.put("Boing", 9.5);
		assertEquals(doubleTable.size(), 3);
	}
	
	@Test
	void putReplaceStringTest() {
		stringjTable.put(1, "one");
		assertEquals(stringjTable.size(), 10);
	}
	
	@Test
	void putManyTest() {
		doubleTable.put("1aaaaaa", 8.0);
		doubleTable.put("2aaaaaa", 8.0);
		doubleTable.put("3aaaaaa", 8.0);
		doubleTable.put("4aaaaaa", 8.0);
		doubleTable.put("5aaaaaa", 8.0);
		doubleTable.put("6aaaaaa", 8.0);
		doubleTable.put("7aaaaaa", 8.0);
		doubleTable.put("8aaaaaa", 8.0);
		doubleTable.put("9aaaaaa", 8.0);
		doubleTable.put("10aaaaaa", 8.0);
		doubleTable.put("11aaaaa", 8.0);
		doubleTable.put("12aaaaa", 8.0);
		doubleTable.put("13aaaaa", 8.0);
		doubleTable.put("14aaaaa", 8.0);
		doubleTable.put("15aaaaa", 8.0);
		doubleTable.put("16aaa", 8.0);
		doubleTable.put("17aaaaaaa", 8.0);
		doubleTable.put("18aaaaa", 8.0);
		doubleTable.put("19aaaaa", 8.0);
		doubleTable.put("20aaaaa", 8.0);
		doubleTable.put("21aaaaa", 8.0);
		doubleTable.put("22aaaaa", 8.0);
		doubleTable.put("23aaaaa", 8.0);
		doubleTable.put("24aaaaa", 8.0);
		doubleTable.put("25aaaaa", 8.0);
		
		assertEquals(doubleTable.size(), 28);
	}
	
	@Test
	void putReturnTest() {
		assertNull(doubleTable.put("Bear", 8.9));
	}
	
	@Test
	void putReturnStringTest() {
		assertNull(stringjTable.put(19, "Nineteen"));
	}
	
	@Test
	void putReturnValueTest() {
		assertEquals(doubleTable.put("Boing", 8.9), 5.5);
	}
	
	@Test
	void putReturnValueTestString() {
		assertEquals(stringjTable.put(1, "one"), "One");
	}
	
	@Test
	void isEmptyTrueTest() {
		HashTableB<Double, Double> temp = new HashTableB<Double, Double>();
		assertTrue(temp.isEmpty());
	}
	
	@Test
	void isEmptyFalseTest() {
		assertFalse(doubleTable.isEmpty());
	}
	
	@Test
	void isEmptyFalseStringTest() {
		assertFalse(stringjTable.isEmpty());
	}
	
	@Test
	void getTest() {
		assertEquals(doubleTable.get("Boing"), 5.5);
	}
	
	@Test
	void getStringTest() {
		assertEquals(stringjTable.get(2), "Two");
	}
	
	@Test
	void getNullTest() {
		assertNull(doubleTable.get("Boiasdfng"));
	}
	
	@Test
	void getNullStringTest() {
		assertNull(stringjTable.get(188));
	}
	
	@Test
	void sizeTest() {
		assertEquals(doubleTable.size(), 3);
	}
	
	@Test
	void sizeStringTest() {
		assertEquals(stringjTable.size(), 10);
	}
	
	@Test
	void sizeEmptyTest() {
		HashTableB<Double, Double> temp = new HashTableB<Double, Double>();
		assertEquals(temp.size(), 0);
	}
		
		@Test
		void clearTest()
		{
			map.clear();
			assertEquals(map.size(), 0);
		}
		
		@Test
		void containsKeyTest()
		{
			assertTrue(map.containsKey("coder"));
		}
		
		@Test
		void containsKeyInt()
		{
			assertTrue(integerMap.containsKey(1));
		}
		
		@Test
		void containsKeyDouble()
		{
			assertTrue(doubleMap.containsKey(3.5));
		}

		@Test
		void containsKeyBoolean()
		{
			assertTrue(booleanMap.containsKey(true));
		}
		
		@Test
		void containsKeyint()
		{
			assertTrue(intBoolMap.containsKey(3));
		}
		
		@Test
		void containsValueTest()
		{
			assertTrue(map.containsValue(2));
		}
		
		@Test
		void containsValueTestBoolean()
		{
			assertTrue(intBoolMap.containsValue(true));
		}
		
		@Test
		void seriesTest1()
		{
			MapEntry<String, Integer> checker = new MapEntry<String, Integer>("apple", 3);
			assertEquals(map.entries().size(), 5);
		}
		
		@Test
		void seriesTest()
		{
			MapEntry<String, Integer> checker = new MapEntry<String, Integer>("apple", 3);
			assertEquals(map.entries().size(), 5);
		}
}