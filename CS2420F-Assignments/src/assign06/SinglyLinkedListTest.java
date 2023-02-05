package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {
	
	private SinglyLinkedList<Integer> LinkedListInt;
	private SinglyLinkedList<Integer> LinkedListIntEmpty;
	private SinglyLinkedList<Character> LinkedListChar;
	private SinglyLinkedList<String> LinkedListString;	
	@BeforeEach
	void setUp()
	{
		LinkedListInt = new SinglyLinkedList<Integer>();
		LinkedListIntEmpty = new SinglyLinkedList<Integer>();
		LinkedListInt.insertFirst(1);
		LinkedListInt.insertFirst(2);
		LinkedListInt.insertFirst(3);
		LinkedListInt.insertFirst(4);
		LinkedListInt.insertFirst(5);
		
		LinkedListChar = new SinglyLinkedList<Character>();
		LinkedListChar.insertFirst('a');
		LinkedListChar.insertFirst('b');
		LinkedListChar.insertFirst('c');
		LinkedListChar.insertFirst('d');
		LinkedListChar.insertFirst('e');
		
		LinkedListString = new SinglyLinkedList<String>();
		LinkedListString.insertFirst("word1");
		LinkedListString.insertFirst("word2");
		LinkedListString.insertFirst("word3");
		LinkedListString.insertFirst("word4");
		LinkedListString.insertFirst("word5");
	}
//		************* InsertFirst TESTS *******************
	@Test
	void insertFirstIntTest() {
		LinkedListInt.insertFirst(9);
		assertEquals(9, LinkedListInt.get(0));
	}
	@Test
	void insertFirstCharTest() {
		LinkedListChar.insertFirst('z');
		assertEquals('z', LinkedListChar.get(0));
	}
	@Test
	void insertFirstStringTest() {
		LinkedListString.insertFirst("Brayden");
		assertEquals("Brayden", LinkedListString.get(0));
	}
	@Test
	void insertFirstNullTest() {
		LinkedListInt.clear();
		LinkedListInt.insertFirst(45);
		assertEquals(45, LinkedListInt.get(0));		
	}
	
//	************* Insert TESTS *******************
	@Test
	void insertIntTest() {
		LinkedListInt.insert(1, 9);
		LinkedListInt.insert(2, 10);
		assertEquals(9, LinkedListInt.get(1));
		assertEquals(10, LinkedListInt.get(2));
		assertEquals(4, LinkedListInt.get(3));
		assertEquals(3, LinkedListInt.get(4));
	}
	@Test
	void insertCharTest() {
		LinkedListChar.insert(0, 'z');
		LinkedListChar.insert(1, 'y');
		assertEquals('z', LinkedListChar.get(0));
		assertEquals('y', LinkedListChar.get(1));
		assertEquals('e', LinkedListChar.get(2));
		assertEquals('d', LinkedListChar.get(3));
	}
	@Test
	void insertStringTest() {
		LinkedListString.insert(0, "Brayden");
		LinkedListString.insert(1, "Neal");
		assertEquals("Brayden", LinkedListString.get(0));
		assertEquals("Neal", LinkedListString.get(1));
		assertEquals("word5", LinkedListString.get(2));
		assertEquals("word4", LinkedListString.get(3));
	}
	@Test
	void insertIntZeroIndexTest() {
		LinkedListInt.insert(0, 9);
		assertEquals(9, LinkedListInt.get(0));
		assertEquals(5, LinkedListInt.get(1));
	}
	@Test
	void insertExceptionTest() {
		assertThrows(IndexOutOfBoundsException.class, () -> { LinkedListInt.insert(-1, 1); });	
		assertThrows(IndexOutOfBoundsException.class, () -> { LinkedListInt.insert(6, 1); });		
	}
//	************* getFirst TESTS *******************
	@Test
	void getFirstIntTest() {
		assertEquals(5, LinkedListInt.getFirst());
	}
	@Test
	void getFirstCharTest() {
		assertEquals('e', LinkedListChar.getFirst());
	}
	@Test
	void getFirstStringTest() {
		assertEquals("word5", LinkedListString.getFirst());
	}
	@Test
	void getFirstExceptionTest() {
		LinkedListInt.clear();
		assertThrows(NoSuchElementException.class, () -> { LinkedListInt.getFirst(); });	
	}
//	************* get TESTS *******************
	@Test
	void getIntTest() {
		assertEquals(5, LinkedListInt.get(0));
		assertEquals(4, LinkedListInt.get(1));
		assertEquals(3, LinkedListInt.get(2));
		assertEquals(2, LinkedListInt.get(3));
		assertEquals(1, LinkedListInt.get(4));
	}
	@Test
	void getCharTest() {
		assertEquals('e', LinkedListChar.get(0));
		assertEquals('d', LinkedListChar.get(1));
		assertEquals('c', LinkedListChar.get(2));
		assertEquals('b', LinkedListChar.get(3));
		assertEquals('a', LinkedListChar.get(4));
	}
	@Test
	void getStringTest() {
		assertEquals("word5", LinkedListString.get(0));
		assertEquals("word4", LinkedListString.get(1));
		assertEquals("word3", LinkedListString.get(2));
		assertEquals("word2", LinkedListString.get(3));
		assertEquals("word1", LinkedListString.get(4));
	}
	@Test
	void getExceptionTest() {
		assertThrows(IndexOutOfBoundsException.class, () -> { LinkedListInt.insert(-1, 1); });	
		assertThrows(IndexOutOfBoundsException.class, () -> { LinkedListInt.insert(6, 1); });		
	}
//	************* deleteFirst TESTS *******************
	@Test
	void deleteFirstIntTest() {
		LinkedListInt.deleteFirst();
		assertEquals(4, LinkedListInt.get(0));
		LinkedListInt.deleteFirst();
		assertEquals(3, LinkedListInt.get(0));
	}
	@Test
	void deleteFirstCharTest() {
		LinkedListChar.deleteFirst();
		assertEquals('d', LinkedListChar.get(0));
		LinkedListChar.deleteFirst();
		assertEquals('c', LinkedListChar.get(0));
	}
	@Test
	void deleteFirstStringTest() {
		LinkedListString.deleteFirst();
		assertEquals("word4", LinkedListString.get(0));
		LinkedListString.deleteFirst();
		assertEquals("word3", LinkedListString.get(0));
	}
	@Test
	void deleteFirstExceptionTest() {
		LinkedListInt.clear();
		assertThrows(NoSuchElementException.class, () -> { LinkedListInt.deleteFirst(); });	
	}
//	************* delete TESTS *******************
	@Test
	void deleteIntTest() {
		assertEquals(4, LinkedListInt.get(1));
		LinkedListInt.delete(1);
		assertEquals(3, LinkedListInt.get(1));
	}
	@Test
	void deleteCharTest() {
		assertEquals('d', LinkedListChar.get(1));
		LinkedListChar.delete(1);
		assertEquals('c', LinkedListChar.get(1));
	}
	@Test
	void deleteStringTest() {
		assertEquals("word4", LinkedListString.get(1));
		LinkedListString.delete(1);
		assertEquals("word3", LinkedListString.get(1));
	}
	@Test
	void deleteIntZeroIndexTest() {
		assertEquals(5, LinkedListInt.get(0));
		LinkedListInt.delete(0);
		assertEquals(4, LinkedListInt.get(0));
	}
	@Test
	void deleteExceptionTest() {
		assertThrows(IndexOutOfBoundsException.class, () -> { LinkedListInt.delete(-1); });	
		assertThrows(IndexOutOfBoundsException.class, () -> { LinkedListInt.delete(6); });		
	}
//	************* indexOf TESTS *******************
	@Test
	void indexOfIntTest() {
		assertEquals(0, LinkedListInt.indexOf(5));
		assertEquals(1, LinkedListInt.indexOf(4));
		assertEquals(2, LinkedListInt.indexOf(3));
		assertEquals(3, LinkedListInt.indexOf(2));
		assertEquals(4, LinkedListInt.indexOf(1));
	}
	@Test
	void indexOfNotInListIntTest() {
		assertEquals(-1, LinkedListInt.indexOf(6));
	}
	@Test
	void indexOfCharTest() {
		assertEquals(0, LinkedListChar.indexOf('e'));
		assertEquals(1, LinkedListChar.indexOf('d'));
		assertEquals(2, LinkedListChar.indexOf('c'));
		assertEquals(3, LinkedListChar.indexOf('b'));
		assertEquals(4, LinkedListChar.indexOf('a'));
	}
	@Test
	void indexOfNotInListCharTest() {
		assertEquals(-1, LinkedListChar.indexOf('f'));
	}
	@Test
	void indexOfStringTest() {
		assertEquals(0, LinkedListString.indexOf("word5"));
		assertEquals(1, LinkedListString.indexOf("word4"));
		assertEquals(2, LinkedListString.indexOf("word3"));
		assertEquals(3, LinkedListString.indexOf("word2"));
		assertEquals(4, LinkedListString.indexOf("word1"));
	}
	@Test
	void indexOfNotInListStringTest() {
		assertEquals(-1, LinkedListString.indexOf("word6"));
	}
//	************* size TESTS *******************
	@Test
	void sizeIntTest() {
		assertEquals(5, LinkedListInt.size());
		LinkedListInt.insertFirst(6);
		assertEquals(6, LinkedListInt.size());
		LinkedListInt.deleteFirst();
		assertEquals(5, LinkedListInt.size());
	}
	@Test
	void sizeCharTest() {
		assertEquals(5, LinkedListChar.size());
		LinkedListChar.insertFirst('f');
		assertEquals(6, LinkedListChar.size());
		LinkedListChar.deleteFirst();
		assertEquals(5, LinkedListChar.size());
	}
	@Test
	void sizeStringTest() {
		assertEquals(5, LinkedListString.size());
		LinkedListString.insertFirst("word6");
		assertEquals(6, LinkedListString.size());
		LinkedListString.deleteFirst();
		assertEquals(5, LinkedListString.size());
	}
//	************* isEmpty TESTS *******************
	@Test
	void isEmptyFalseIntTest() {
		assertFalse(LinkedListInt.isEmpty());
	}	
	@Test
	void isEmptyTrueIntTest() {
		LinkedListInt.clear();
		assertTrue(LinkedListInt.isEmpty());
	}
	@Test
	void isEmptyFalseCharTest() {
		assertFalse(LinkedListInt.isEmpty());
	}	
	@Test
	void isEmptyTrueCharTest() {
		LinkedListChar.clear();
		assertTrue(LinkedListChar.isEmpty());
	}
	@Test
	void isEmptyFalseStringTest() {
		assertFalse(LinkedListString.isEmpty());
	}	
	@Test
	void isEmptyTrueStringTest() {
		LinkedListString.clear();
		assertTrue(LinkedListString.isEmpty());
	}
//	************* clear TESTS *******************
	@Test
	void clearIntTest() {
		LinkedListInt.clear();
		assertEquals(0, LinkedListInt.size());
		assertTrue(LinkedListInt.isEmpty());
	}
	@Test
	void clearCharTest() {
		LinkedListChar.clear();
		assertEquals(0, LinkedListChar.size());
		assertTrue(LinkedListChar.isEmpty());
	}
	@Test
	void clearStringTest() {
		LinkedListString.clear();
		assertEquals(0, LinkedListString.size());
		assertTrue(LinkedListString.isEmpty());
	}
//	************* toArray TESTS *******************
//	@Test
//	void toArrayIntTest() {
//		int[] expected = {5, 4, 3, 2, 1};
//		assertEquals(Arrays.toString(expected), LinkedListInt.toArray());
//	}
	
//	************* iterator TESTS *******************
	
//	************* hasNext TESTS *******************

	@Test
	void hasNextTrueIntTest() {
	assertTrue(LinkedListInt.iterator().hasNext());
	}
	@Test
	void hasNextFalseIntTest() {
	LinkedListInt.clear();
	assertFalse(LinkedListInt.iterator().hasNext());
	}
	@Test
	void hasNextTrueCharTest() {
	assertTrue(LinkedListChar.iterator().hasNext());
	}
	@Test
	void hasNextFalseCharTest() {
	LinkedListChar.clear();
	assertFalse(LinkedListChar.iterator().hasNext());
	}
	@Test
	void hasNextTrueStringTest() {
	assertTrue(LinkedListString.iterator().hasNext());
	}
	@Test
	void hasNextFalseStringTest() {
	LinkedListString.clear();
	assertFalse(LinkedListString.iterator().hasNext());
	}
//	************* next TESTS *******************
	@Test
	void nextIntTest() {
		Iterator<Integer> itr = LinkedListInt.iterator();
		itr.next();//iterator on 5
		itr.next();//iterator on 4
		itr.next();//iterator on 3
		assertEquals(2, itr.next());
		assertEquals(1, itr.next());
	}
	@Test
	void nextCharTest() {
		Iterator<Character> itr = LinkedListChar.iterator();
		itr.next();//iterator on e
		itr.next();//iterator on d
		itr.next();//iterator on c
		assertEquals('b', itr.next());
		assertEquals('a', itr.next());
	}
	@Test
	void nextStringTest() {
		Iterator<String> itr = LinkedListString.iterator();
		itr.next();//iterator on word5
		itr.next();//iterator on word4
		itr.next();//iterator on word3
		assertEquals("word2", itr.next());
		assertEquals("word1", itr.next());
	}
	@Test
	void nextExceptionTest() {
		Iterator<Integer> itr = LinkedListIntEmpty.iterator();
		assertThrows(NoSuchElementException.class, () -> { itr.next(); });	
	}
}
