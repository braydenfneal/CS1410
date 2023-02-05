package assign10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This is a generic class that represents a Binary Max Heap and is backed by a
 * basic array
 * 
 * NOTE: The item with the highest priority is the "maximum" item.
 * 
 * @author Brayden Neal and Alex Ulfich
 * @version
 *
 */
public class BinaryMaxHeap<E> implements PriorityQueue<E> {
	private E heap[];
	private int size;
	private Comparator<? super E> comparator = null;

	/**
	 * If this constructor is used to create an empty binary heap, it is assumed
	 * that the elements are ordered using their natural ordering (i.e., E
	 * implements Comparable<? super E>).
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap() {
		heap = (E[]) new Object[5];
		size = 0;
	}

	/**
	 * If this constructor is used to create an empty binary heap, it is assumed
	 * that the elements are ordered using the provided Comparator object.
	 */
	public BinaryMaxHeap(Comparator<? super E> cmp) {
		this();
		comparator = cmp;
	}

	/**
	 * If this constructor is used, then the binary heap is constructed from the
	 * given list. Also, it is assumed that the elements are ordered using their
	 * natural ordering (i.e., E implements Comparable<? super E>).
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(List<? extends E> list) {
		heap = (E[]) new Object[list.size()];
		size = 0;
		buildHeap(list);
	}

	/**
	 * If this constructor is used, then the binary heap is constructed from the
	 * given list (see RECALL note above). Also, it is assumed that the elements are
	 * ordered using the provided Comparator object.
	 */
	@SuppressWarnings("unchecked")
	public BinaryMaxHeap(List<? extends E> list, Comparator<? super E> cmp) {
		heap = (E[]) new Object[list.size()];
		comparator = cmp;
		size = 0;
		buildHeap(list);
	}

	/**
	 * Adds the given item to this priority queue. O(1) in the average case, O(log
	 * N) in the worst case
	 * 
	 * @param item
	 */
	@Override
	public void add(E item) {
		if (size == heap.length)
			resize();

		heap[size] = item;

		int parentIndex = getParentIndex(size);
		int childIndex = size;

		E parent = heap[parentIndex];

		while (comparison(parent, item) < 0) {
			heap[childIndex] = parent;
			heap[parentIndex] = item;

			childIndex = parentIndex;
			parentIndex = getParentIndex(childIndex);
			parent = heap[parentIndex];
		}

		size++;
	}

	@SuppressWarnings("unchecked")
	private int comparison(E o1, E o2) {
		if (comparator == null) {
			return ((Comparable<? super E>) o1).compareTo(o2);
		}
		return comparator.compare(o1, o2);
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		E tmp[] = (E[]) new Object[heap.length * 2];

		for (int i = 0; i < size; i++)
			tmp[i] = heap[i];

		heap = tmp;
	}

	/**
	 * Returns, but does not remove, the maximum item this priority queue. O(1)
	 * 
	 * @return the maximum item
	 * @throws NoSuchElementException if this priority queue is empty
	 */
	@Override
	public E peek() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("Heap is empty");
		return heap[0];
	}

	/**
	 * Returns and removes the maximum item this priority queue. O(log N)
	 * 
	 * @return the maximum item
	 * @throws NoSuchElementException if this priority queue is empty
	 */
	@Override
	public E extractMax() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("Heap is empty");

		E tmp = heap[0];
		heap[0] = heap[size - 1];
		heap[size - 1] = null;

		percolateDown(0);

		size--;
		return tmp;
	}

	private void percolateDown(int i) {
		int leftChildIndex = getLeftChildIndex(i);
		int rightChildIndex = getRightChildIndex(i);

		E parent = heap[i];
		E leftChild = leftChildIndex < size ? heap[leftChildIndex] : null;
		E rightChild = rightChildIndex < size ? heap[rightChildIndex] : null;
		
		// if rightChild exists, the parent "node" contains left child by default
		if (rightChild != null) {
			if (comparison(leftChild, rightChild) >= 0 && comparison(leftChild, parent) > 0) {
				heap[leftChildIndex] = parent;
				heap[i] = leftChild;
				percolateDown(leftChildIndex);
			} else if (comparison(rightChild, parent) > 0) {
				heap[rightChildIndex] = parent;
				heap[i] = rightChild;
				percolateDown(rightChildIndex);
			}
		} else if (leftChild != null && comparison(leftChild, parent) > 0) {
			heap[leftChildIndex] = parent;
			heap[i] = leftChild;
		}
	}

	/**
	 * Returns the number of items in this priority queue. O(1)
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns true if this priority queue is empty, false otherwise. O(1)
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Empties this priority queue of items. O(1)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void clear() {
		size = 0;
		heap = (E[]) new Object[5];
	}

	private int getParentIndex(int i) {
		return (i - 1) / 2;
	}

	private int getLeftChildIndex(int i) {
		return 2 * i + 1;
	}

	private int getRightChildIndex(int i) {
		return 2 * (i + 1);
	}

	/**
	 * Creates and returns an array of the items in this priority queue, in the same
	 * order they appear in the backing array. O(N)
	 * 
	 * (NOTE: This method is needed for grading purposes. The root item must be
	 * stored at index 0 in the returned array, regardless of whether it is in
	 * stored there in the backing array.)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray() {
		E tmp[] = (E[]) new Object[size];

		for (int i = 0; i < size; i++)
			tmp[i] = heap[i];

		return tmp;
	}

	private void buildHeap(List<? extends E> list) {

		for (E item : list) {
			heap[size] = item;
			size++;
		}

		int startingIndex = getParentIndex(size - 1);

		for (int i = startingIndex; i >= 0; i--)
			percolateDown(i);
	}
}
