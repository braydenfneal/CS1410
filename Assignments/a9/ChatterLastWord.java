package a9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A subclass of Chatter that finds the last word of
 * an inputed phrase and returns a response that matches with
 * the same word
 * 
 * @author braydenneal
 *
 */
public class ChatterLastWord extends Chatter {
	
	/**
	 * Constructor builds a Chatter object from the super class, with 
     * set greeting, goodbye, and potential response phrases.
	 * 
	 * @param greeting
	 * @param goodbye
	 * @param phrasesPath
	 */
	public ChatterLastWord(String greeting, String goodbye, String phrasesPath) {
		super(greeting, goodbye, phrasesPath);
		}
    
    /**
     * Breaks apart the phrase into words, and returns the last one.
     * Assumes punctuation has been removed.
     * 
     * @param phrase a sentence.
     * @return the last word in the phrase.
     */
	
	private static String lastWord(String phrase) {
        String[] words = phrase.split(" ");
        return words[words.length - 1];
    }
    
    /**
     * Picks a response phrase from phrases by getting the last
     * word in userPhrase and finding the first line in phrases
     * that contains that word.
     * 
     * Provides a default response if no match is found.
     * 
     * @param userPhrase a sentence of lower-case words
     * @return a line from phrases containing the last word in userPhrase
     */
    public String respondToPhrase(String userPhrase) {
        String lastWord = lastWord(userPhrase);
        for (String phrase : phrases) {
            if (phrase.contains(lastWord)) {
                return phrase;
            }
        }
        return "Please tell me more about " + userPhrase;
    }
	public static void main(String[] args) {
		
	}

}
