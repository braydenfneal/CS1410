package a7;

/**
 *  A set with abstract data structure that can store values without any particular order 
 *  and with no repeated values.
 * 
 * @author Brayden Neal
 *
 */
public class StringSet {
	/**
	 * A backing array to store all the data in this set. If you need a set that can
	 * add items very very quickly, consider using a DoublingDynamicArray instead.
	 */
	DynamicArray data;

	/**
	 * This constructor creates a new empty set.
	 */
	public StringSet() {
		data = new DynamicArray();
	}

	/**
	 * Tests whether the provided element is contained in this set
	 * 
	 * @param e a non-null element to check for containment
	 * @return true if this set contains e, otherwise false
	 * @throws IllegalArgumentException if e is null
	 */
	public void insert(String e) {
		if (e == null)
			throw new IllegalArgumentException("Cannot insert a null element");
		if (!contains(e)) {
			data.add(e);
		}
	}

	/**
	 * Tests whether the provided element is contained in this set
	 * 
	 * @param e a non-null element to check for containment
	 * @return true if this set contains e, otherwise false
	 * @throws IllegalArgumentException if e is null
	 */
	public boolean contains(String e) {
		if (e == null)
			throw new IllegalArgumentException("Cannot call contains with a null element");

		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals(e)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the number of strings in the set
	 * 
	 * @return number of strings in set
	 */
	public int size() {
		return data.size();
	}

	/**
	 * if e is in the set, it removes it, if not, does nothing.
	 * 
	 * @param e a String
	 */
	public void remove(String e) {
		if (e == null) {
			throw new IllegalArgumentException("Cannot call remove with a null element");
		}
		if (contains(e)) {
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).equals(e)) {
					data.remove(i);
				}
			}
		}
	}

	/**
	 * Computes and returns the union of the StringSet that calls this method and
	 * the StringSet argument to the method.
	 * 
	 * @param other a StringSet
	 * @return the union of the two StringSets
	 */
	public StringSet union(StringSet other) {
		if (other == null) {
			throw new IllegalArgumentException("Cannot call union with a null element");
		}
		StringSet s = new StringSet();
		for (int i = 0; i < data.size(); i++) {
			s.insert(data.get(i));
		}
		for (int i = 0; i < other.size(); i++) {
			s.insert(other.data.get(i));
		}
		return s;
	}

	/**
	 * Computes and returns elements contained in both StringSets.
	 * 
	 * @param other a StringSet
	 * @return the intersection from both StringSets
	 */
	public StringSet intersection(StringSet other) {
		if (other == null) {
			throw new IllegalArgumentException("Cannot call intersection with a null element");
		}
		StringSet s = new StringSet();
		for (int i = 0; i < data.size(); i++) {
			if (other.contains(data.get(i))) {
				s.insert(data.get(i));
			}
		}
		return s;
	}

	/**
	 * Returns a formatted version of this set.
	 * 
	 * For example, a set containing "a" and "b" returns the string "{a, b}". An
	 * empty set returns "{}"
	 * 
	 * @return the formatted string
	 */
	public String toString() {
		String setContents = "";
		for (int i = 0; i < data.size(); i++) {
			setContents += data.get(i);
			if (i != data.size() - 1) {
				setContents += ", ";
			}
		}
		return "{" + setContents + "}";
	}
}