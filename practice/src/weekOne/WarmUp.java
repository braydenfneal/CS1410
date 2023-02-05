package weekOne;

/**
 * A class containing code from the warm-up problem, intended for 
 * additional experimentation by students.
 * 
 * @author Erin Parker
 * @version January 13, 2022
 */
public class WarmUp {

	public static void main(String[] args) {
		String greeting = "Hello!";
		String sameGreeting = "Hello!";
		
		sameGreeting += "!";
		
		if(greeting == sameGreeting) {
			System.out.println("The references (i.e., address) are the same.");
		}
		
		if(greeting.equals(sameGreeting)) {
			System.out.println("The (contents of the) strings are the same.");
		}
	}
}