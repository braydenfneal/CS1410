package a9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * An example chatbot class that tries to match the last
 * word in user text to an array of responses.
 *
 * @author Travis Martin
 * @author David E. Johnson
 * @author braydenneal
 *
 */
public abstract class Chatter {
    private String greeting;
    private  String goodbye;
    public  String[] phrases; // the possible chatbot responses.
    
    /**
     * Loads lines from a file with the following format:
     * 	    - the first line is the number of lines to load
     *      - the remaining lines are possible chatbot responses.
     *      
     * If the file is not found, prints an error and returns an 
     * empty String array.
     * 
     * @param filePath the String path to the file
     * @return an array of the lines from the file, excluding the initial number line.
     */
    private static String[] loadLinesFromFile(String filePath) {
        File f = new File(filePath);
        try {
            Scanner input = new Scanner(f);
            String numLinesString = input.nextLine();
            int numLines = Integer.parseInt(numLinesString);
            String[] lines = new String[numLines];
            for (int i = 0; i < lines.length; i++) {
                lines[i] = input.nextLine();
            }
            input.close();
            return lines;
        } catch (FileNotFoundException exception) {
            System.out.println("Could not open the provided file, returning null: " + filePath);
            return new String[0];
        }
    }
    
    /**
     * Gives the single, set greeting phrase.
     *
     * @return the greeting String.
     */
    public String sayHello() {
        return greeting;
    }
    
    /**
     * Gives the single, set goodbye phrase.
     * 
     * @return the goodbye String.
     */
    public String sayGoodbye() {
        return goodbye;
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
    
    /**
     * The constructor builds a Chatter object, with 
     * set greeting, goodbye, and potential response phrases.
     * @param greeting a fixed String greeting
     * @param goodbye a fixed String goodbye
     * @param phrasesPath the filename for a file with possible chatbot responses
     */
    public Chatter(String greeting, String goodbye, String phrasesPath) {
        this.greeting = greeting;
        this.goodbye = goodbye;
        this.phrases = loadLinesFromFile(phrasesPath);
    }
}