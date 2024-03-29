package a9;

import java.util.Scanner;

/**
 * A class that manages a single chat session between a user and a chatbot.
 * The chat session can be started by running this class. See the main method
 * for more details.
 * 
 * THIS FILE IS COMPLETE AND WORKING. DO NOT MODIFY IT.
 * 
 * 
 * @author Travis Martin
 * @author David Johnson
 */
public class ChatWithUser {
    
    /**
     * Normalizes an input phrase by making it all lowercase and removing all punctuation.
     * This makes it easier for a chatbot to understand.
     * 
     * @param phrase a String sentence in English
     * @return a normalized version of the input phrase
     */
    private static String makeLowercaseWithoutPunctuation(String phrase) {
        String lowercase = phrase.toLowerCase();
        String noPunctuation = lowercase.replaceAll("[^a-zA-Z ]", "");
        return noPunctuation;
    }

    /**
     * Runs a single chatbot session by creating a Chatter object
     * and then passing it inputs from the user until the user
     * types "stop".
     * 
     * This method also takes care of printing the chatbot responses.
     */
    public static void main(String[] args) {
        // Load a ChatterBot
        Chatter botLast = new ChatterLastWord(
                "Hi, what would you like to talk about?",
                "It was nice chatting with you!",
                "src/a9/phrases.txt");
        Chatter botFull = new ChatterFullMatch(
                "Hi, what would you like to talk about?",
                "It was nice chatting with you!",
                "src/a9/phrases.txt");
        Chatter botCustom = new ChatterCustom(
                "Hi, what would you like to talk about?",
                "It was nice chatting with you!",
                "src/a9/phrases.txt");
        
        // Greet the user and wait for a response
        System.out.println("Chatter: " + botLast.sayHello());
        Scanner userInput = new Scanner(System.in);
        
        // Chat with the user until they say "stop"
        while (true) {
            System.out.print("User: ");
            String userResponse = userInput.nextLine();
            userResponse = makeLowercaseWithoutPunctuation(userResponse);
            if(userResponse.equals("stop"))
                break;
            System.out.println("ChatterLast: " + botLast.respondToPhrase(userResponse));
            System.out.println("ChatterFull: " + botFull.respondToPhrase(userResponse));
            System.out.println("ChatterFirst: " + botCustom.respondToPhrase(userResponse));
        }
        
        // Say goodbye
        System.out.println("Chatter: " + botLast.sayGoodbye());
        userInput.close();
    }
}
