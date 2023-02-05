package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program uses a modified hash table in order to store grammars and generate random phrases
 * @author Brayden Neal & Will Dreyer
 * @version April 30, 2021
 */

public class RandomPhraseGenerator {

	public static void main(String[] args) throws FileNotFoundException {
		int numPhrases = Integer.parseInt(args[1]);
		
		//Populate the hashTable
		NewModifiedHashTableA<String, String> grammar = populateTable(args[0]);
		
		//Generate random phrases
		generatePhrases(grammar, numPhrases);
	}
	
	private static NewModifiedHashTableA<String, String> populateTable(String filename) throws FileNotFoundException {
		String temp;
		String hash;
		
		//This hash table uses single probing and ArrayLists to store the data for the grammar
		NewModifiedHashTableA<String, String> grammar = new NewModifiedHashTableA<String, String>();
		Scanner myScan = new Scanner(new File(filename));
		
		//This section scans the grammar into the hash table
		while(myScan.hasNext()) {
			if(myScan.nextLine().equals("{")) {
				hash = myScan.nextLine();
				temp = myScan.nextLine();
				while(!temp.equals("}")) {
					grammar.put(hash, temp);
					temp = myScan.nextLine();
				}
			}
		}
		myScan.close();
		return grammar;
	}
	
	private static void generatePhrases(NewModifiedHashTableA<String, String> grammar, int numPhrases) {
		String phrase, temp;
		int beginning, end;
		
		//Builds each phrase by looking up keys in the hash table
		for(int i = 0; i < numPhrases; i++) {
			phrase = grammar.get("<start>");
			
			while(phrase.contains("<")) {
				beginning = phrase.indexOf('<');
				end = phrase.indexOf('>');
				if(end == phrase.length() - 1) {
					temp = grammar.get(phrase.substring(beginning));
					phrase = phrase.substring(0, beginning) + temp;
				}
				else {
					temp = grammar.get(phrase.substring(beginning, end + 1));
					phrase = phrase.substring(0, beginning) + temp + phrase.substring(end + 1);
				}
			}
			System.out.println(phrase);
		}
	}
}