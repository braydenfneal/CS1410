package a5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

/**
 * This program acts as a text completion program for names of cities.
 * 
 * @author Prof. David E. Johnson
 *
 */
public class Completer {

	/**
	 * Reads in a file of lowercase city names of the following format, a number N
	 * that specifies the number of cities in the file and then the cities, as
	 * follows: N cityNameAndLocation1 cityNameAndLocation2 ... cityNameAndLocationN
	 * 
	 * The method makes a String array with the cityNameAndLocations. If the
	 * filename is not found, an exception throws back to the calling method. (No
	 * code is needed to detect and throw the exception - it just happens).
	 * 
	 * @param filename the file of city names as described above.
	 * @return an array of the city names and locations.
	 * @throws FileNotFoundException
	 */
	public static String[] readCitiesFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		String[] cities = null;
		try {
			Scanner scan = new Scanner(file);
			int textSize = Integer.parseInt(scan.nextLine());
			cities = new String[textSize];
			for (int i = 0; i < textSize; i++) {
				cities[i] = scan.nextLine();
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return cities;
		// Remove this line and replace it with code.
	}

	/**
	 * This is a modified binary search that compares a key String with the Strings
	 * in the cities array.
	 * 
	 * This search does not distinguish between two Strings that have the same first
	 * letters as key. So for a key of "David", "David Johnson" and "David
	 * Letterman" would both count as equal to the key.
	 * 
	 * Assumes cities is sorted in ascending order.
	 * 
	 * @param cities : a sorted array of cities
	 * @param key    : the start of a city.
	 * @return the index where the start of cities matches key, or -1 otherwise.
	 */
	public static int binarySearchForKey(String[] cities, String key) {
		int lo = 0;
		int hi = cities.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (cities[mid].startsWith(key))
				return mid;
			else if (((cities[mid]).substring(0)).compareTo(key) < 0)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return -1;
	}

	/**
	 * This is a modified sequential search that compares a key String with the
	 * Strings in the cities array.
	 * 
	 * This search does not distinguish between two Strings that have the same first
	 * letters as key. So for a key of "David", "David Johnson" and "David
	 * Letterman" would both count as equal to the key.
	 * 
	 * @param cities : an array of cities
	 * @param key    : the start of a city.
	 * @return the index where the start of cities matches key, or -1 otherwise.
	 */
	public static int sequentialSearchForKey(String[] cities, String key) {
		// This method does not need to be modified. Look at the startWith use
		// as a starting point for the binary search code.
		for (int index = 0; index < cities.length; index++) {
			// match any String that has the same beginning as the key
			if (cities[index].startsWith(key))
				return index;
		}
		return -1; // no match was found
	}

	public static void main(String[] args) {
		/*
		 * The CompleterApp reads the cities.txt file using readCitiesFile, sorts the
		 * array and then searches using the search methods from this file.
		 * 
		 * The first argument is the location of the cities file relative to the project
		 * folder.
		 * 
		 * The second argument is "binary" or "sequential" to specify which search
		 * method should be used.
		 * 
		 * The third argument is a boolean flag. If - false: the cities array is used
		 * unchanged - true: each element in the cities array is multiplied to make a
		 * much larger array where the performance of the search matters.
		 */
		boolean makeBig = false;
		CompleterApp app = new CompleterApp("src/a5/cities.txt", "binary", makeBig);
		app.start();
	}
	/*
	 * I first off think that this is a very cool project upon completion. The way
	 * to get to it was cool because we had two different searches involved, I think
	 * I understand binary search better because of the way it searched for each of
	 * the letters, and went off of that.
	 * 
	 */
}
