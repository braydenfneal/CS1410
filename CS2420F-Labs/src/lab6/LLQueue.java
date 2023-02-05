package lab6;

import java.util.LinkedList;

public class LLQueue<T> implements Queue<T> {

	private LinkedList<T> ll;
	public LLQueue()
	{
		ll = new LinkedList<T>();
	}
	
	@Override
	/**
	 * Implement without using LinkedList's addLast or offer methods
	 */
	public void offer(T element) {
		// TODO:
		ll.add(element);
	}

	@Override
	/**
	 * Implement without using poll, pollFirst, or removeFirst
	 */
	public T poll() {
		return ll.remove(0);
		
	}

	@Override
	/**
	 * Implement without using peek, peekFirst, or getFirst
	 */
	public T peek() {
		return ll.get(0);
	}

}
