package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglyLinkedListTestW
{
	private ArrayList<Integer> intArrayList;
	private ArrayList<String> stringArrayList;
	private ArrayList<Character> charArrayList;
	private LinkedList<Integer> intLinkedList;
	private SinglyLinkedList<String> stringLinkedList;
	private SinglyLinkedList<Character> charLinkedList;
	private SinglyLinkedList<?> newList;
	
	@BeforeEach
	void setUp()
	{
		intArrayList = new ArrayList<Integer>();
		intArrayList.add(1); intArrayList.add(2); intArrayList.add(3); intArrayList.add(4);
		intArrayList.add(5);
		stringArrayList = new ArrayList<String>();
		stringArrayList.add("apple"); stringArrayList.add("book"); stringArrayList.add("cat"); stringArrayList.add("doorway");
		stringArrayList.add("elephant");
		charArrayList = new ArrayList<Character>();
		charArrayList.add('a'); charArrayList.add('b'); charArrayList.add('c'); charArrayList.add('d'); charArrayList.add('e');
	
		intLinkedList = new LinkedList<Integer>();
		intLinkedList.add(1); intLinkedList.add(2); intLinkedList.add(3); intLinkedList.add(4); intLinkedList.add(5);
		stringLinkedList = new SinglyLinkedList<String>();
		stringLinkedList.insertFirst("apple"); stringLinkedList.insertFirst("book"); stringLinkedList.insertFirst("cow"); stringLinkedList.insertFirst("deer"); stringLinkedList.insertFirst("elephant");
		charLinkedList = new SinglyLinkedList<Character>();
		charLinkedList.insertFirst('a'); charLinkedList.insertFirst('b'); charLinkedList.insertFirst('c'); charLinkedList.insertFirst('d'); charLinkedList.insertFirst('e');
		
		newList = new SinglyLinkedList<Object>();
	}
	
	
	
	@Test
	void checkInsertFirst()
	{
		charLinkedList.insertFirst('p');
		assertEquals('p', charLinkedList.get(0));
	}
	
	@Test
	void checkSinglyLinkedListConstructor()
	{
		assertThrows(IndexOutOfBoundsException.class, () -> { newList.getFirst(); });		
		assertEquals(0, newList.size());
		assertEquals(5, charLinkedList.size());
	}
	
//	@Test
//	void checkGetPrevNode()
//	{
//		assertEquals('e', charLinkedList.getPrevNode(1).data);
//	}
	

	@Test
	void checkGetFirst()
	{
		String element = "book";
		stringLinkedList.insert(0, element);
		assertTrue(stringLinkedList.getFirst().equalsIgnoreCase("book"));
	}
	
	@Test
	void checkGet()
	{
		String element = "alligator";
		stringLinkedList.insert(0,  element);
		assertTrue(stringLinkedList.get(0).equalsIgnoreCase("alligator"));
	}
	
	@Test
	void checkDeleteFirst()
	{
		assertEquals("elephant", stringLinkedList.deleteFirst());
	}
	
	@Test
	void checkDelete()
	{
		stringLinkedList.delete(0);
		assertEquals("deer", stringLinkedList.getFirst());
	}
	
	@Test
	void checkIndexOf()
	{
		int temp = stringLinkedList.indexOf("apple");
		assertEquals(4, temp);
	}
	
}
