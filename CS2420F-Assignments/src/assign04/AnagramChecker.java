package assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author William Dreyer and Brayden Neal
 *
 *         The purpose of this code is to read through a sequence of strings and
 *         print out the largest group of anagrams (words with exact same used
 *         letters). It must output the original words in their entirety in any
 *         order.
 * @param <T>
 */
public class AnagramChecker<T> {
	/**
	 * 
	 * @author wdrey
	 *
	 */
	public static class AnagramComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			if (o1.hashCode() > o2.hashCode())
				return 1;
			if (o1.hashCode() < o2.hashCode())
				return -1;
			else
				return 0;
		}
	}

	static class CompareTests implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			int result = 0;

			if (o1.hashCode() > o2.hashCode()) {
				result = 1;
			} else if (o1.hashCode() < o2.hashCode()) {
				result = -1;
			} else {
				result = 0;
			}

			return result;
		}

	}

	/**
	 * 
	 * @param word
	 * @return a sorted String that is in alphabetical order
	 * 
	 *         The point of this method is to sort the input string into a new
	 *         string with all characters in order. One of the worries is that the
	 *         original string might've been affected, but we worked to ensure that
	 *         didn't happen. It first splits the string into a char Array and then
	 *         uses a non-recursive insertion sort (without a comparator/comparable)
	 *         to sort it. It then places the characters back into a string to
	 *         return.
	 */
	public static String sort(String word) {
		if (word == null)
			throw new NullPointerException("The inputted String is null.");
		// this makes a char array that holds all of the letters
		// of the inputted word, this ensures that
		// the actual word itself won't be changed.
		char[] charArr = word.toLowerCase().toCharArray();
		// this is the insertion sort implementation
		// and uses the array that was made previously
		// it still maintains the supposed big-O behavior
		for (int j = 1; j < charArr.length; j++) {
			char current = charArr[j];
			int i = j - 1;
			while ((i > -1) && (charArr[i] > current)) {
				charArr[i + 1] = charArr[i];
				i--;
			}
			charArr[i + 1] = current;
		}
		StringBuilder ex = new StringBuilder();
		for (int p = 0; p < word.length(); p++)
			ex.append(charArr[p]);
		return ex.toString();
	}

	/**
	 * 
	 * @param <T>
	 * @param wordArr
	 * @param cmp
	 * 
	 *                The point of this insertion sort is to look through an array
	 *                and sort it. It is a generic method, which means we can use it
	 *                both for String and Character arrays, depending on what is
	 *                needed.
	 */
	public static <T> void insertionSort(T[] wordArr, Comparator<? super T> cmp) {
		if (wordArr == null)
			throw new NullPointerException();
		int n = wordArr.length;
		for (int i = 1; i < n; ++i) {
			T key = wordArr[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && cmp.compare(wordArr[j], (T) key) > 0) {
				wordArr[j + 1] = wordArr[j];
				j = j - 1;
			}
			wordArr[j + 1] = key;
		}
	}

	/**
	 * 
	 * @param o1
	 * @param o2
	 * @return a boolean regarding to whether or not the two strings are equal in
	 *         terms of letter placement and value
	 * 
	 *         This only returns true if the strings are EXACTLY the same, and
	 *         doesn't take it consideration spaces or any other flaw in the
	 *         string's format.
	 */
	public static boolean areAnagrams(String o1, String o2) {
		if (o1 == null || o2 == null)
			throw new NullPointerException();
		String o1Sorted = sort(o1);
		String o2Sorted = sort(o2);
		if (o1Sorted.equalsIgnoreCase(o2Sorted))
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param stringArr
	 * @return A string Arr of the largest group of Anagrams. In order to properly
	 *         show off the outputted data in a user-friendly medium, you must look
	 *         through this array and print out each individual input.
	 */
	public static String[] getLargestAnagramGroup(String[] stringArr) {
		if (stringArr == null) {
			throw new NullPointerException();
		}
		// this is a helper class that creates a comparator for use in the insertion
		// sort method
		// although a lambda expression could be used, we figured this would be more
		// straightforward for the time being.
		class compareLargestAnagram implements Comparator<String> {
			// we wanted this to compare the actual values of the words,
			// so it uses the hashcodes of each inputted word.
			@Override
			public int compare(String o1, String o2) {
				int result = 0;
				if (o1.hashCode() > o2.hashCode()) {
					result = 1;
				} else if (o1.hashCode() < o2.hashCode()) {
					result = -1;
				} else {
					result = 0;
				}
				return result;
			}
		}
		// checks to insure that the given string array is valid to be used.
		if (stringArr.length == 0) {
			throw new IllegalArgumentException("Empty Array");
		}
		// initializes a comparator class from above
		compareLargestAnagram cmp = new compareLargestAnagram();
		// although other data storage systems could be used, this linkedHashMap allows
		// us
		// to store data along with its specific anagram value.
		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		// insertionSort(stringArr, cmp);
		Arrays.sort(stringArr, cmp);
		// this works on an already sorted array, which makes the timing faster
		// this for each loop focuses on added words with identical anagrams to
		// a matching position in the Map.
		for (String word : stringArr) {
			String sortedStr = sort(word);
			List<String> anagrams = map.get(sortedStr);
			if (anagrams == null) {
				anagrams = new ArrayList<String>();
			}
			// regardless if a new position is made in the map,
			// it adds the word to the list of anagrams, and then
			// places that list of anagrams into the Map.
			anagrams.add(word);
			map.put(sortedStr, anagrams);
		}
		// this then looks through the entire map set for which anagram has the largest
		// count.
		Set<Entry<String, List<String>>> entrySet = map.entrySet();
		List<String> anagramPrime = new ArrayList<String>();
		// begin at -1 so that only anagrams with a count are eligible.
		int largestAnagramGroup = -1;
		for (Entry<String, List<String>> entry : entrySet) {
			List<String> value = entry.getValue();
			for (int i = 0; i < value.size(); i++) {
				if (areAnagrams(sort(value.get(0)), sort(value.get(i))) == false)
					throw new IllegalArgumentException();
			}
			// like trying to find the largest value in a data storage of ints, this
			// compares
			// the current size value to the other largest one. If the current size is
			// larger than the largest, the value for the largest is reset.
			if (value.size() > largestAnagramGroup) {
				largestAnagramGroup = value.size();
				anagramPrime = value;
			}
		}
		// although it has computed which anagram is the largest (anagramPrime),
		// it must make it eleigible to be returned (in a String[] format).
		// this creates an array off of anagramPrime, with a specific anagramPrime size.
		return anagramPrime.toArray(new String[anagramPrime.size()]);
	}

	/**
	 * 
	 * @param filename
	 * @return String[] containing all words from largest anagram group
	 * 
	 *         This method has essentially the same use as the previous one, but it
	 *         takes in a String for a file's name instead of a direct array.
	 */
	public static String[] getLargestAnagramGroup(String filename) {
		if (filename == null)
			throw new NullPointerException();
		// creates a comparator class for use in this method, most likely won't be used.
		class AnagramComparator implements Comparator<String> {

			@Override
			public int compare(String o1, String o2) {
				int result = 0;
				if (o1.hashCode() > o2.hashCode()) {
					result = 1;
				} else if (o1.hashCode() < o2.hashCode()) {
					result = -1;
				} else {
					result = 0;
				}
				return result;
			}
		}
		AnagramComparator cmp = new AnagramComparator();
		// creates and initalizes a scanner for use with the file.
		// this wraps the file name initializer in a try/catch statement,
		// in the possibility that the file name isn't valid for implementing.
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(new File("src/assign04/" + filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// creates an arraylist that will be used to sort words
		// this arraylist will NOT be put into the insertion sort or sort methods.
		ArrayList<String> wordsToCheck = new ArrayList<String>();
		// runs through file and copies over each individual word
		// this is feasible with consideration of no weird words not seperated by
		// spaces.
		// ARRAYLISTs are better for this operation as it is able to grow easily.
		while (fileReader.hasNext()) {
			wordsToCheck.add(fileReader.next());
		}

		// checks to insure that the given string array is valid to be used.
		if (wordsToCheck.size() == 0) {
			throw new IllegalArgumentException("Empty Array");
		}

		// this creates a new array that is the same size as the previous arraylist
		String[] wordsArray = new String[wordsToCheck.size()];
		// running through all of the elements of the wordsToCheck arraylist,
		// sorts each word before placing them into
		for (int i = 0; i < wordsToCheck.size(); i++) {
			wordsArray[i] = wordsToCheck.get(i);
		}

		return getLargestAnagramGroup(wordsArray);

//			//although other data storage systems could be used, this linkedHashMap allows us
//			//to store data along with its specific anagram value.
//			Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
//			insertionSort(wordsArray, cmp);
//			//this works on an already sorted array, which makes the timing faster
//			//this for each loop focuses on added words with identical anagrams to
//			//a matching position in the Map.
//			for(String word : wordsArray)
//			{
//				String sortedStr = sort(word);
//				List<String> anagrams = map.get(sortedStr);
//				if(anagrams == null) {
//					anagrams = new ArrayList<String>();
//				}
//				//regardless if a new position is made in the map, 
//				//it adds the word to the list of anagrams, and then 
//				//places that list of anagrams into the Map.
//				anagrams.add(word);
//				map.put(sortedStr, anagrams);
//			}
//        //this then looks through the entire map set for which anagram has the largest count.
//        Set<Entry<String, List<String>>> entrySet = map.entrySet();
//        List<String> anagramPrime = new ArrayList<String>();
//        //begin at -1 so that only anagrams with a count are eligible.
//        int largestAnagramGroup = -1;
//        for(Entry<String, List<String>> entry : entrySet) {
//        	List<String> value = entry.getValue();
//        	//like trying to find the largest value in a data storage of ints, this compares
//        	//the current size value to the other largest one. If the current size is 
//        	//larger than the largest, the value for the largest is reset. 
//        	if(value.size() > largestAnagramGroup) {
//        		largestAnagramGroup = value.size();
//        		anagramPrime = value;
//        	}
//        }
//        //although it has computed which anagram is the largest (anagramPrime),
//        //it must make it eleigible to be returned (in a String[] format).
//        //this creates an array off of anagramPrime, with a specific anagramPrime size.
//        return anagramPrime.toArray(new String[anagramPrime.size()]);
	}

	public static void main(String[] args) {
		String fileName = "sample_word_list.txt";
		String[] txt = getLargestAnagramGroup(fileName);
		String[] txt2 = new String[] { "book", "koob", "okob", "how", "words" };
		String[] txt3 = getLargestAnagramGroup(txt2);
		for (int i = 0; i < txt3.length; i++)
			System.out.println(txt3[i]);
//		for(int x = 0; x < txt.length; x ++)
//		{
//			System.out.println(txt[x]);
//		}

	}
}