package weekThree;

/**
 * An incomplete implementation of a dynamic array list, used to 
 * demonstrate the principles of using an array as a backing structure.
 * 
 * @author	Erin Parker
 * @version January 27, 2022
 *
 * @param <Type> - Type of Object contained in this MyArrayList
 */
public class MyArrayList<Type> {
	
	private Type[] array;
	private int size;
	
	/**
	 * Constructs an empty MyArrayList object
	 */
	public MyArrayList() {
		array = createGenericArray(16);
		size = 0;
	}
	
	/**
	 * Helper method for creating a generic array.  Confines the warning 
	 * and its suppression to one location in this class.
	 * 
	 * @param length - length of the array 
	 * @return a generic array of desired length
	 */
	@SuppressWarnings("unchecked")
	private Type[] createGenericArray(int length) {
		// Java does not allow creation of generically-typed arrays 
		// (e.g., new Type[16] does not compile). Type casting is 
		// required, which generates a warning that is safe to suppress.
		return (Type[]) new Object[length];
	}
	
	/**
	 * @return the number of elements in this MyArrayList
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds an element to this MyArrayList
	 * 
	 * @param obj - the element
	 */
	public void add(Type obj) {
		// If the capacity of the backing array will be exceeded, resize 
		// by doubling.
		if(size == array.length) {
			Type[] temp = createGenericArray(size * 2);
			for(int i = 0; i < size; i++)
				temp[i] = array[i];
			array = temp;
		}
		
		array[size] = obj;
		size++;
	}
	
	/* A complete MyArrayList class would include method for 
	   getting items, removing items, searching for items, and
	   more. Such methods are left for the student to add. */
}