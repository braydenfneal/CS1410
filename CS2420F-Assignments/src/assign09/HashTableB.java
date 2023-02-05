package assign09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a hash table
 * @author Zach Lin and Will Dreyer
 * @version April 4, 2021
 * @param <K> The type of the key
 * @param <V> The type of the value
 */
public class HashTableB<K, V> implements Map<K, V> {

	private ArrayList<LinkedList<MapEntry<K, V>>> table;
	private int size;
	private int capacity;
	private int collisions;
	
	public HashTableB() {
		table = new ArrayList<LinkedList<MapEntry<K, V>>>();
		capacity = 20;
		for(int i = 0; i < capacity; i++) {
			table.add(new LinkedList<MapEntry<K, V>>());
		}
		size = 0;
		collisions = 0;
	}
	
	/**
	 * Removes all elements from the hash table. This method
	 * does not change the size of backing array, it simply clears
	 * all of the linked lists in the array.
	 */
	@Override
	public void clear() {
		for(LinkedList<MapEntry<K, V>> list: table) {
			list.clear();
		}
		size = 0;
	}
	
	/**
	 * This method determines whether or not this hash table contains the specified key
	 * @param key - an object of type K that is the key whose presence is being checked for
	 * @return - a boolean representing whether or not the key is present in the table
	 */
	@Override
	public boolean containsKey(K key) {
		int index = Math.abs(key.hashCode()) % table.size();
		LinkedList<MapEntry<K, V>> tempList = table.get(index);
		for(MapEntry<K, V> entry: tempList) {
			if(entry.getKey().equals(key))
				return true;
			//collisions ++;
		}
		return false;
	}

	/**
	 * This method determines whether or not the hash table contains the specified value
	 * @param value - an object of type V that is the value whose presence is being checked for
	 * @return - a boolean representing whether or not the key is present in the hash table
	 */
	@Override
	public boolean containsValue(V value) {
		for(LinkedList<MapEntry<K, V>> list: table) {
			for(MapEntry<K, V> entry: list) {
				if(entry.getValue().equals(value))
					return true;
				collisions ++;
			}
		}
		return false;
	}

	/**
	 * This method generates a list with all of the entries in the hash table. There is no specific order.
	 * @return - a list of all the entries in the hash table
	 */
	@Override
	public List<MapEntry<K, V>> entries() {
		List<MapEntry<K, V>> temp = new ArrayList<MapEntry<K, V>>();
		for(LinkedList<MapEntry<K, V>> list: table) {
			for(MapEntry<K, V> entry: list) {
				temp.add(entry);
			}
		}
		return temp;
	}

	/**
	 * This method gets the value to which the specified key is mapped.
	 * @param key - the key to be searched with
	 * @return - the value to which the key is mapped. If the key is not present
	 * in the table, then null is returned
	 */
	@Override
	public V get(K key) {
		int index = Math.abs(key.hashCode()) % table.size();
		LinkedList<MapEntry<K, V>> tempList = table.get(index);
		for(MapEntry<K, V> entry: tempList) {
			if(entry.getKey().equals(key))
				return entry.getValue();
			//collisions ++;
		}
		return null;
	}

	/**
	 * Determines whether or not the hash table has any elements
	 * @return - a boolean representing whether or not the hash table is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * This method attempts to add the specified key and value pair to the table.
	 * If the key already exists, the value is updated to the specified value. If the key doesn't
	 * exist, then a new entry is added. If the load factor becomes larger than 10, then the backing array
	 * is resized
	 * @param key - the key to be mapped with
	 * @param value - the value to be put into the table
	 * @return - the previous value associated with key, or null is there is no previous value
	 */
	@Override
	public V put(K key, V value) {
		if((double)(size + 1) / table.size() > 10) {
			ArrayList<LinkedList<MapEntry<K, V>>> tempTable = new ArrayList<LinkedList<MapEntry<K, V>>>();
			
			capacity *= 2;
			for(int i = 0; i < capacity; i++) {
				tempTable.add(new LinkedList<MapEntry<K, V>>());
			}
			
			int rehashIndex;
			for(LinkedList<MapEntry<K, V>> list: table) {
				for(MapEntry<K, V> entry: list) {
					rehashIndex = Math.abs(entry.getKey().hashCode()) % tempTable.size();
					tempTable.get(rehashIndex).add(entry);
				}
			}
			
			table = tempTable;
		}

		int index = Math.abs(key.hashCode()) % table.size();
		LinkedList<MapEntry<K, V>> tempList = table.get(index);
		for(MapEntry<K, V> entry: tempList) {
			if(entry.getKey().equals(key)) {
				V temp = entry.getValue();
				entry.setValue(value);
				return temp;
			}
			//collisions ++;
		}
		tempList.add(new MapEntry<K, V>(key, value));
		size++;
		return null;
	}

	/**
	 * This method removes the value associated with the specified key
	 * @param key - the key for the value to be removed
	 * @return - the value of the entry removed, or null if no entry was removed
	 */
	@Override
	public V remove(K key) {
		int index = Math.abs(key.hashCode()) % table.size();
		LinkedList<MapEntry<K, V>> tempList = table.get(index);
		int listIndex = 0;
		for(MapEntry<K, V> entry: tempList) {
			if(entry.getKey().equals(key)) {
				size--;
				return tempList.remove(listIndex).getValue();
			}
			listIndex++;
		}
		return null;
	}

	
	
	
	/**
	 * Determines the number of elements in the hash table
	 * @return - an int value representing the number of elements in the hash table
	 */
	@Override
	public int size() {
		return size;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getCollisions() {
		return collisions;
	}
	
	public void resetCollisions() {
		collisions = 0;
	}

}
