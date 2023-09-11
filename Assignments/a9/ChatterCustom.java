package a9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A sub class of Chatter that takes the first word of the inputed
 * phrase and returns a response that matches it.
 * 
 * @author braydenneal
 *
 *
 */
public class ChatterCustom extends Chatter {
	
	/**
	 * Constructor builds a Chatter object from the super class, with 
     * set greeting, goodbye, and potential response phrases.
	 * 
	 * @param greeting a String
	 * @param goodbye a String
	 * @param phrasesPath a String
	 */
	public ChatterCustom(String greeting, String goodbye, String phrasesPath) {
		super(greeting, goodbye, phrasesPath);
	}
	
	/**
	 * Finds the first word in the user inputed phrase
	 * 
	 * @param phrase a String
	 * @return the first word in the input phrase
	 */
	private static String firstWord(String phrase) {
		String[] words = phrase.split(" ");
        return words[0];
    }
	
	public static void main(String[] args) {
		System.out.println(firstWord("BRAYDEN"));
	}
	
}
