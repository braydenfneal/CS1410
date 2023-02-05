package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A linked List data structure, that is Singly Linked. It
 * implements a List interface.
 * 
 * @author braydenneal
 *
 * @param <E> - the type of elements contained in the stack
 */
public class SinglyLinkedList<E> implements List<E> {
	
	private Node <E> head;
	private int elementCount;
	
	/**
	 * Default constructor to set the instance variables
	 * to the correct starting point
	 */
	public SinglyLinkedList() {
		head = null;
		elementCount = 0;
	}
	
	/**
	 * 
	 * Node class that creates a new Node with an element
	 * and a pointer to the next node
	 *
	 * @param <E>
	 */
	private static class Node<E> {
		E element;
		Node<E> next;
		
		Node(E data, Node<E> next){
			element = data;
			this.next = next;
		}
		public Node(E data) {
			element = data;
		}
	}
	
	/**
	 * Inserts an element at the beginning of the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @param element - the element to add
	 */
	@Override
	public void insertFirst(E element) {
		if (head == null) {
		head = new Node<E>(element, null);
		elementCount++;
		}
		else {
		Node<E> temp = new Node<E>(element, head);
		head = temp;
		elementCount++;
		}
	}
	
	/**
	 * Inserts an element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index > size())
	 */
	@Override
	public void insert(int index, E element) throws IndexOutOfBoundsException {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
		insertFirst(element);
		
		}
		else {
			int count = 0;
			Node<E> first = head;
			while(count < index - 1) {
				first = first.next;
				count++;
			}
			Node<E> second = first.next;
			Node<E> newNode = new Node<E>(element, second);
			first.next = newNode;
			elementCount++;
		}
	}
	
	/**
	 * Gets the first element in the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public E getFirst() throws NoSuchElementException {
		if (elementCount == 0) {
			throw new NoSuchElementException();
		}
		return head.element;
	}
	
	/**
	 * Gets the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {	
		if(index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> temp = head;
		for (int i = 0; i< index; i++) {
			temp = temp.next;
		}
		return temp.element;
	}
	
	/**
	 * Deletes and returns the first element from the list.
	 * O(1) for a singly-linked list.
	 * 
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	@Override
	public E deleteFirst() throws NoSuchElementException {
		if (elementCount == 0) {
			throw new NoSuchElementException();
		}
		Node<E> temp = head;
		if (head.next == null) {
			elementCount--;
			return head.element;
		}
		else {
			head = head.next;
			elementCount--;
			return temp.element;
		}
		
	}

	/**
	 * Deletes and returns the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 * 
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 */
	@Override
	public E delete(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0) {
			return deleteFirst();
		}
		else {
			Node<E> temp = head;
			for (int i = 0; i < index-1; i++) {
				temp = temp.next;
			}
			Node<E> temp2 = temp.next.next;
			E deleted = temp.next.element;
			temp.next = temp2;
			elementCount--;
			return deleted;
	}
	}
	
	/**
	 * Determines the index of the first occurrence of the specified element in the list, 
	 * or -1 if this list does not contain the element.
	 * O(N) for a singly-linked list.
	 * 
	 * @param element - the element to search for
	 * @return the index of the first occurrence; -1 if the element is not found
	 */
	@Override
	public int indexOf(E element) {
		Node<E> current = head;
		if (current == null) {
			return -1;
		}
		for (int i = 0; i < size(); i++) {
			if (current.element == element) {
				return i;
			}
			current = current.next;
		}
		return -1;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		return elementCount;
	}

	/**
	 * O(1) for a singly-linked list.
	 * 
	 * @return true if this collection contains no elements; false, otherwise
	 */
	@Override
	public boolean isEmpty() {
		if (size() == 0){
		return true;
		}
		return false;
	}

	/**
	 * Removes all of the elements from this list.
	 * O(1) for a singly-linked list.
	 */
	@Override
	public void clear() {
		head = null;
		elementCount = 0;
	}
	
	/**
	 * Generates an array containing all of the elements in this list in proper sequence 
	 * (from first element to last element).
	 * O(N) for a singly-linked list.
	 * 
	 * @return an array containing all of the elements in this list, in order
	 */
	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size()];
		Node<E> temp = head;
		int index = 0;
		while(temp != null) {
			arr[index] = temp.element;
			temp = temp.next;
			index++;
		}
		return arr;
	}
	
	/**
	 * @return an iterator over the elements in this list in proper sequence (from first 
	 * element to last element)
	 */
	@Override
	public Iterator<E> iterator() {
		
		return new SinglyLinkedListIterator();
	}
	
	/**
	 * An iterator that traverses the elements 
	 * from head to tail including the methods, 
	 * hasNext, next, and remove.
	 * 
	 * @author braydenneal
	 */
	private class SinglyLinkedListIterator implements Iterator<E>
	{
		private Node<E> currentNode;
		private Node<E> prevNode;
		private Node<E> beforePrev;
		private boolean removedElement;
		
		/**
		 * Constructor for the iterator to set all of the
		 * instance variables to the correct start.
		 */
		public SinglyLinkedListIterator()
		{
			currentNode = head;
			prevNode = null;
			beforePrev = null;
			removedElement = false;
		}
		
		/**
		 * Checks if the iterator has another Node to
		 * go to
		 */
		public boolean hasNext() {
			return currentNode != null;
		}

		/**
		 * Has the iterator traverse to the next
		 * node.
		 */
		public E next() {
			if (currentNode == null) {
				throw new NoSuchElementException();
			}
			E data = currentNode.element;
			beforePrev = prevNode;
			prevNode = currentNode;
			currentNode = currentNode.next;
			removedElement = false;
			return data;
		}
		/**
		 * Removes whatever we got from the next() method
		 */
		public void remove() {
			Node<E> currentNode = head;
			if(currentNode == null || removedElement)
				throw new java.lang.IllegalStateException();
			if (beforePrev == null) {
				head = currentNode;
				}
			else {
				prevNode.next = currentNode.next;
			}
			elementCount --;
			removedElement = true;	
		} 
	}
}
