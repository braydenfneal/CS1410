package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomPhraseGeneratorA {

	public static void main(String[] args) throws FileNotFoundException {
		//int numPhrases = Integer.parseInt(args[1]);
		int numPhrases = 5;
		
		//Populate the hashTable
		//NewModifiedHashTable<String, String> grammar = populateTable(args[0]);
		NewModifiedHashTableA<String, String> grammar = populateTable("src/comprehensive/poetic_sentence.g");
		int incr = 100;
		int timesToLoop = 1000;
		ArrayList<Double> times = new ArrayList<Double>();
		for(int probSize = 100; probSize <= 800; probSize += incr) 
		{
			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			int index = probSize % 100;
			if(probSize == 100)
				grammar = populateTable("src/comprehensive/poetic_sentence.g");
			if(probSize == 200)
				grammar = populateTable("src/comprehensive/poetic_sentence.g");
			if(probSize == 300)
				grammar = populateTable("src/comprehensive/poetic_sentence.g");
			if(probSize == 400)
				grammar = populateTable("src/comprehensive/poetic_sentence.g");
			if(probSize == 500)
				grammar = populateTable("src/comprehensive/poetic_sentence.g");
			if(probSize == 600)
				grammar = populateTable("src/comprehensive/poetic_sentence.g");
			if(probSize == 700)
				grammar = populateTable("src/comprehensive/poetic_sentence.g");
			if(probSize == 800)
				grammar = populateTable("src/comprehensive/poetic_sentence.g");
			
			


			long stopTime, midpointTime, startTime = System.nanoTime();

			while(System.nanoTime() - startTime < 1000000000) { // empty block
			}

			// Collect running times.
			startTime = System.nanoTime();
			for(int i = 0; i < timesToLoop; i++) {
				//Generate random phrases
				generatePhrases(grammar, i);

			}

			midpointTime = System.nanoTime();

			// Capture the cost of running the loop and any other operations done
			// above that are not the essential method call being timed.
			for(int i = 0; i < timesToLoop; i++) {
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and searching.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - 
						(stopTime - midpointTime)) / (double) timesToLoop;
			//System.out.println("Generate Sentences " + probSize + "  " + averageTime);
			times.add(averageTime);
		}
		for(int i = 0; i < times.size(); i ++)
		{
			System.out.println(times.get(i) + " " + (i+1)*100);
		}
		
	}
	
	private static NewModifiedHashTableA<String, String> populateTable(String filename) throws FileNotFoundException {
		String temp;
		String hash;
		NewModifiedHashTableA<String, String> grammar = new NewModifiedHashTableA<String, String>();
		Scanner myScan = new Scanner(new File(filename));
		
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