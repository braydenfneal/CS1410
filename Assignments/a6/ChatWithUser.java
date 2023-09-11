package a6;

import java.util.Scanner;

/**
 * A class that manages a single chat session between a user and a chatbot.
 * The chat session can be started by running this class. See the main method
 * for more details.
 * 
 * THIS FILE IS COMPLETE AND WORKING. DO NOT MODIFY IT.
 * 
 * Here is an example of a chat that might result:
 * 
 * Chatter: Hi, what would you like to talk about?
 * User: utah
 * Chatter: Please tell me more about utah
 * User: utah is a nice place to live
 * Chatter: how long have you lived here? 
 * User: ten years
 * Chatter: i'm 26 years old
 * User: stop
 * Chatter: It was nice chatting with you!
 * 
 * @author Travis Martin
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
        Chatter bot = new Chatter(
                "Hi, what would you like to talk about?",
                "It was nice chatting with you!",
                "src/a6/phrases.txt");
        
        // Greet the user and wait for a response
        System.out.println("Chatter: " + bot.sayHello());
        Scanner userInput = new Scanner(System.in);
        
        // Chat with the user until they say "stop"
        while (true) {
            System.out.print("User: ");
            String userResponse = userInput.nextLine();
            userResponse = makeLowercaseWithoutPunctuation(userResponse);
            if(userResponse.equals("stop"))
                break;
            System.out.println("Chatter: " + bot.respondToPhrase(userResponse));
        }
        
        // Say goodbye
        System.out.println("Chatter: " + bot.sayGoodbye());
        userInput.close();
    }
}
