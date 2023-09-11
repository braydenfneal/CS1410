package a6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * This class contains methods that when used, calls phrases 
 * from a file to give the chatter bot something to say back
 * when talked to.
 * 
 * @author Brayden Neal
 * 
 */
public class Chatter {
	private String greeting;
	private String goodbye;
	private String[] phrases;

	/*
	 * This constructor method allows others to create
	 * an instance of the object.
	 * 
	 * @param greeting a String
	 * @param goodbye a String
	 * @param phrasesPath a String
	 */
	public Chatter(String greeting, String goodbye, String phrasesPath) {
		this.greeting = greeting;
		this.goodbye = goodbye;
		phrases = loadLinesFromFile(phrasesPath);

	}

	/*
	 * This method takes in the path to a file of phrases and formats
	 * them and stores them in a new array using a scanner
	 * 
	 * @param filePath a String
	 * @return the array of phrases
	 */
	public static String[] loadLinesFromFile(String filePath) {
		File file = new File(filePath);
		String[] phrases = null;
		try {
			Scanner scan = new Scanner(file);
			int textSize = Integer.parseInt(scan.nextLine());
			phrases = new String[textSize];
			for (int i = 0; i < textSize; i++) {
				phrases[i] = scan.nextLine();
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		return phrases;
	}

	/*
	 * This method should return the greeting that was
	 * stored when this particular object was created.
	 * 
	 * @return the greeting that was stored in it
	 */
	public String sayHello() {
		return greeting;

	}

	/*
	 * This method should return the greeting that was
	 * stored when this particular object was created.
	 * 
	 * @return the goodbye that was stored in it
	 */
	public String sayGoodbye() {
		return goodbye;

	}

	/*
	 * This private method finds the last word in a given phrase.
	 * 
	 * @param phrase a String
	 * @return the last word of the phrase
	 */
	private static String lastWord(String phrase) {
		String[] given = phrase.split(" ");
		return given[given.length-1];

	}

	/*
	 * This method is given an input phrase of at 
	 * least one word, and with multiple words 
	 * separated by spaces, tries to return a reasonable response.
	 * 
	 * @param inputPhrase a String
	 * @return a response from phrases.txt or an "if not found" phrase.
	 */
	public String respondToPhrase(String inputPhrase) {
		  for (int i = 0; i < phrases.length; i++) {
			if (phrases[i].contains(lastWord(inputPhrase))) { 
				return phrases[i];
			}
		  }
		  String s = "Please tell me more about " + inputPhrase;
		  return s;
	}
}
