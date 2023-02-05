package assign06;

import java.util.NoSuchElementException;
/**
 * Representation of a stack 
 * data structure (backed by a Linked List).
 * 
 * @author braydenneal
 *
 *
 * @param <E> - the type of elements contained in the stack
 */
public class LinkedListStack<E> implements Stack<E> {
	private SinglyLinkedList<E> linkedList;
	
	/**
	 * Default constructor that sets the linked list
	 */
	public LinkedListStack() {
		linkedList = new SinglyLinkedList<E>();
	}
	
	/**
	 * Removes all of the elements from the stack.
	 */
	@Override
	public void clear() {
		linkedList.clear();
	}

	/**
	 * @return true if the stack contains no elements; false, otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	/**
	 * Returns, but does not remove, the element at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public E peek() throws NoSuchElementException {
		return linkedList.getFirst();
	}

	/**
	 * Returns and removes the item at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if the stack is empty
	 */
	@Override
	public E pop() throws NoSuchElementException {
		return linkedList.deleteFirst();
	}

	/**
	 * Adds a given element to the stack, putting it at the top of the stack.
	 * 
	 * @param element - the element to be added
	 */
	@Override
	public void push(E element) {
		linkedList.insertFirst(element);
	}

	/**
	 * @return the number of elements in the stack
	 */
	@Override
	public int size() {
		return linkedList.size();
	}

}
