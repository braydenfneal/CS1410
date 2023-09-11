package a7;

/**
 * A more efficient version of the DynamicArray class than the one created in lecture.
 * Represents the dynamic array [data[0], data[1], ..., data[virtualArrayLength-1]]
 * In other words, the first virtualArrayLength elements of data are elements of the 
 * dynamic array. The remainder of data is room to grow.  When data fills 
 * up, we allocate a new array that is twice as long. 
 * 
 * @author Brayden Neal
 */
public class DoublingDynamicArray {

	private String[] data;
	private int virtualArrayLength;

	/**
	 * Creates an empty dynamic array with room to grow. DO NOT MODIFY THIS METHOD
	 */
	public DoublingDynamicArray() {
		data = new String[8];
		virtualArrayLength = 0;
	}

	/**
	 * Returns the number of elements in the dynamic array.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return virtualArrayLength;
	}

	/**
	 * Appends s to the end of the dynamic array at index this.size()
	 * 
	 * @param s a String
	 */
	public void add(String s) {
		add(virtualArrayLength, s);
	}

	/**
	 * Adds a string s to the array at index i. Prior elements are shifted up.
	 * 
	 * @param i the index
	 * @param s a String
	 */
	public void add(int i, String s) {
		if (i < 0 || i > virtualArrayLength) {
			throw new IndexOutOfBoundsException(
					"Index " + i + "is invalid for this array with length " + virtualArrayLength);
		}
		if (virtualArrayLength == data.length) {
			String[] tempArray = new String[data.length * 2];
			for (int index = 0; index < i; index++) {
				tempArray[index] = data[index];
			}
			for (int index = i + 1; index < virtualArrayLength; index++) {
				tempArray[index] = data[index - 1];
			}
			tempArray[i] = s;
			data = tempArray;
			virtualArrayLength++;
		} else {
			for (int j = virtualArrayLength; j > i; j--) {
				data[j] = data[j - 1];
			}
			data[i] = s;
			virtualArrayLength++;
		}
	}

	/**
	 * Removes the element at index i and shifts the elements after i down one to
	 * fill in the gap.
	 * 
	 * @param i the index
	 */
	public void remove(int i) {
		if (i < 0 || i >= virtualArrayLength) {
			throw new IndexOutOfBoundsException(
					"Index " + i + "is invalid for this array with length " + virtualArrayLength);
		}
		for (int j = i; j < virtualArrayLength - 1; j++) {
			data[j] = data[j + 1];
		}
		virtualArrayLength--;
	}

	/**
	 * Returns the element at index i
	 * 
	 * @param i the index
	 * @return the element at index i
	 */
	public String get(int i) {
		if (i < 0 || i >= virtualArrayLength) {
			throw new IndexOutOfBoundsException(
					"Index " + i + "is invalid for this array with length " + virtualArrayLength);
		}
		return data[i];
	}

	/**
	 * Replaces the element at index i with s
	 * 
	 * @param i the index
	 * @param s a String
	 */
	public void set(int i, String s) {
		if (i < 0 || i > virtualArrayLength) {
			throw new IndexOutOfBoundsException(
					"Index " + i + "is invalid for this array with length " + virtualArrayLength);
		}
		data[i] = s;
	}

	/**
	 * Returns a formatted string version of this dynamic array.
	 * 
	 * @return the formatted string
	 */
	public String toString() {
		String result = "[";
		if (size() > 0)
			result += get(0);

		for (int i = 1; i < size(); i++)
			result += ", " + get(i);

		return result + "] backing size: " + data.length;
	}
}