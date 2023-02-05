package session1;

import java.util.Scanner;

public class hangman {

	//Print out instructions
	//Create variable w/ word(string)
	//int lives
	//array with guessed letters
	//Console Output
	//Scanner
	//update result
	
	static String correctWord;
	static int lives;
	static char[] guessedLetter;
	static Boolean isGameOver;
	
	public static int removeLife (char c) {
		return 0;
	}
	
	public static String updateWord (char c) {
		
		return "";
	}
	
	public static char[] updatedGuessedLetters(char c) {
		
		return new char[26];
	}
	public static void printRound(String word, int lives, char[] guessed) {
		System.out.println("Word: " + initializeSecret(correctWord));
		System.out.println("Guessed Letters: ");
		System.out.println("Lives: " + lives);
		//Memorize this for tests
		Scanner input = new Scanner(System.in);
		
		String letter = input.next();
		while(letter.length() > 1 || !Character.isAlphabetic(letter.charAt(0))) {
			System.out.println("Ivalid Input. Please try again!");
			letter = input.next();
		}
	
	}
	
	public static String initializeSecret(String secret) {
		String result = "";
		for (int i = 0; i < secret.length(); i++) {
			result = result + "_ _ _ _ _";
		}
		return result;
	}
	public static void main(String[] args) {
//	guessedLetters = new char
	System.out.println("Hangman started\nGuess the secret word one letter at a time\n");
	
	correctWord = "APPLE";
//	printRound(correctWord, lives, guessedLetters);
	System.out.println(initializeSecret(correctWord));
	}

}
