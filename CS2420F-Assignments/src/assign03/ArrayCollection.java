package assign03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Daniel Kopta and William Dreyer and Brayden Neal
 * Implements the Collection interface using an array as storage.
 * The array must grow as needed.
 * An ArrayCollection can not contain duplicates.
 * All methods should be implemented as defined by the Java API, unless otherwise specified.
 * 
 * It is your job to fill in the missing implementations and to comment this class. 
 * Every method should have comments (Javadoc-style prefered). 
 * The comments should at least indicate what the method does, 
 * what the arguments mean, and what the returned value is. 
 * It should specify any special cases that the method
 * handles. Any code that is not self-explanatory should be commented.
 *
 * @param <T> - generic type placeholder
 */
public class ArrayCollection<T> implements Collection<T> {

	private T data[]; // Storage for the items in the collection
	private int size; // Keep track of how many items this collection holds

	private int currentCapacity;
	private ArrayCollectionIterator iter;
	// There is no clean way to convert between T and Object, so we suppress the warning.
	@SuppressWarnings("unchecked")  
	public ArrayCollection()
	{
		this.size = 0;
		// We can't instantiate an array of unknown type T, so we must create an Object array, and typecast
		this.data = (T[]) new Object[10]; // Start with an initial capacity of 10
	
		this.currentCapacity = data.length;
		iter = new ArrayCollectionIterator();
		
	}

	/**
	 * This is a helper method specific to ArrayCollection
	 * Doubles the size of the data storage array, retaining its current contents.
	 */
	@SuppressWarnings("unchecked")
	private void grow()
	{
		T temp[] = (T[]) new Object[data.length*2];
		for(int i = 0; i < data.length; i ++)
		{
			temp[i] = data[i];
		}
		data = temp;
	}


	public boolean add(T arg0) {

			if(this.size >= data.length) 
				this.grow();
			for(int i = 0; i < this.data.length; i ++)
			{
				if(arg0.equals(this.data[i])) return false;
				else
					continue;
			}
			this.data[size] = arg0;
			this.size ++;
			return true;
	}

	public boolean addAll(Collection<? extends T> arg0) {
		Iterator<? extends T> iter = arg0.iterator(); 
		boolean isIn = false;
		boolean result = false;
		while(iter.hasNext())
		{
			T temp = iter.next();
			for(T e : data)
			{
				try {
				if(e.equals(temp))
				{
					isIn = true;
				}
				} catch(Exception p) {
					isIn = false;
				}
			}
			if(isIn == false)
			{
				this.add(temp);
				result = true;
				isIn = false;
			}
		}
		return result;
	}

	public void clear() {
		this.size = 0;
	}

	public boolean contains(Object arg0) {
		//Iterator<? super T> iter = this.iterator();
		if(this.size == 0)
			return false;
		
		for(int i = 0; i < this.size; i ++)
		{
			if(data[i].equals(arg0))
			{
				return true;
			}
		}
		return false;
	}

	public boolean containsAll(Collection<?> arg0) {
		//Iterator<?> iter = arg0.iterator();
		boolean result = true;
		int oldSize = size;
		for(Object t : arg0)
		{
			result = this.contains(t);
			if(result == false)
				return false;
		}
		size = oldSize;
		return result;
		
//		while(iter.hasNext())
//		{
//			Object temp = iter.next();
//			for(T item : data)
//			{
//				if(item.equals(temp) != true) return false;
//			}
//		}
//		
//		return true;
	}

	public boolean isEmpty() {
		if(size == 0) 
			return true;
		else 
			return false;
	}

	public Iterator<T> iterator() {
		ArrayCollectionIterator iter = new ArrayCollectionIterator();
		return iter;
	}

	public boolean remove(Object arg0) {
		int correctIndex = 0;
		boolean isIn = false;
//		if(size == 0)
//		{
//			throw new java.lang.IllegalStateException();
//		}
		try {
				for(int i = 0; i < size; i ++)
				{
					//data[i] = data[i + 1];
					if(data[i].equals(arg0))
					{
						correctIndex = i;
						isIn = true;
						break;
					}
				}
				if(isIn == true)
				{
				for(int x = correctIndex; x < size - 1; x ++)
					data[x] = data[x + 1];	
				data[size] = null;
				this.size --;
				return true;
				}
			} catch (Exception e)	{
				throw new IllegalStateException();
			}
		return false;
	}

	public boolean removeAll(Collection<?> arg0) {
		Iterator<?> iter = arg0.iterator();
		boolean result = false;
		while(iter.hasNext())
		{
			Object temp = iter.next();
			for(int i = 0; i < this.size; i ++)
			{
				if(temp.equals(data[i]))
				{
					this.remove(temp);
					result = true;
				}
			}
		}
		return result;
	}

	public boolean retainAll(Collection<?> arg0) {
		ArrayCollectionIterator iterForData = new ArrayCollectionIterator();
		Iterator<?> iterForArg = arg0.iterator();
		T[] tempArray = (T[]) new Object[size];
		int index = 0; 
		boolean result = false;
		while(iterForData.hasNext())
		{
			Object tempForData = iterForData.next();
			while(iterForArg.hasNext())
			{
				Object tempForArg = iterForArg.next();
				if(tempForArg.equals(tempForData))
				{
					tempArray[index] = (T) tempForArg;
					index ++;
					result = false;
				}
				else
					result = true;
			}
		}
		data = tempArray;
		return result;
	}

	public int size() {
		return this.size;
	}

	public Object[] toArray() {
		Object[] returnArray = new Object[size];
		ArrayCollectionIterator iter = new ArrayCollectionIterator();
		int index = 0;
		while(iter.hasNext())
		{
			returnArray[index] = iter.next();
			index ++;
		}
		return returnArray;
	}

	/* 
	 * Don't implement this method (unless you want to).
	 * It must be here to complete the Collection interface.
	 * We will not test this method.
	 */
	public <T> T[] toArray(T[] arg0) {
		return null;
	}

	/**
	 * Sorting method specific to ArrayCollection - not part of the Collection interface.
     	Must implement a selection sort (see Assignment 2 for code).
     	Must not modify this ArrayCollection.
	 * @param cmp - the comparator that defines item ordering
	 * @return - the sorted list
	 */
	public ArrayList<T> toSortedList(Comparator<? super T> cmp)
	{
		ArrayList<T> returnArray = new ArrayList<>();
		for(int i = 0; i < this.size; i ++)
		{
			returnArray.add(data[i]);
		}
		for(int i = 0; i < returnArray.size(); i ++)
		{
			int j, minIndex;
			for(j = i +1, minIndex = i; j < returnArray.size(); j ++)
			{
				if(cmp.compare(returnArray.get(j), returnArray.get(minIndex)) < 0)
					minIndex = j;
			}
			T temp = returnArray.get(i);
			returnArray.set(i, returnArray.get(minIndex));
			returnArray.set(minIndex, temp);
		}
		return returnArray;
	}


	/**
	 * 
	 * @author William Dreyer and Brayden Neal 
	 * Describe your ArrayCollectionIterator class here.
	 *
	 */
	private class ArrayCollectionIterator implements Iterator<T>
	{
		private int currentIndex  = 0;
		//private T[] arr = data;
		private boolean nextCalled = false;
		
		public ArrayCollectionIterator()
		{
			currentIndex = 0;
		}
		
		public boolean hasNext() {
			return currentIndex < size && data[currentIndex] != null;
		}

		public T next() {
			nextCalled = true;
			return data[currentIndex++];
		}

		public void remove() {
//			try {
//				for(int i = currentIndex; i < size - 1; i ++)
//				{
//					data[i] = data[i + 1];
//				}
//				data[size] = null;
//				size --;
//			} catch (Exception e)	{
//				throw new IllegalStateException();
//			}
			
			if(size == 0)
				throw new java.lang.IllegalStateException();
			if(nextCalled == false)
				throw new java.lang.IllegalStateException();
			nextCalled = false;
//			int correctIndex = 0;
//		boolean isIn = false;
//		try {
//				for(int i = 0; i < size; i ++)
//				{
//					//data[i] = data[i + 1];
//					if(data[i].equals(data[currentIndex]))
//					{
//						correctIndex = i;
//						isIn = true;
//						break;
//					}
//				}
//				if(isIn == true)
//				{
//				for(int x = correctIndex; x < size - 1; x ++)
//					data[x] = data[x + 1];	
//				data[size] = null;
//				size --;
//				
//				}
//			} catch (Exception e)	{
//				throw new java.lang.IllegalStateException();
//			}				
			
			ArrayCollection.this.remove(data[currentIndex]);
			
		}
	}
}
