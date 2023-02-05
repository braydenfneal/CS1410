package weekTwo;


/**
 * This class demonstrates how to use the generic Triple class.
 * 
 * @author Erin Parker and CS 2420 class
 * @version January 20, 2022
 */
public class TripleDemo {
	
	public static void main(String[] args) {
		// Use the generic class for specific type String.
		Triple<String> greetings = new Triple<String>("Hello", "Hi", "Howdy");
		System.out.println(greetings);
		
		// Use the generic class for specific type Integer.
		Triple<Integer> numbers = new Triple<Integer>(1, 2, 3);
		System.out.println(numbers);
		
		// Use the generic class for specific type Triple.
		// I.e., this triple contains three triples.
		Triple<Triple<Character>> letterTriples = 
				new Triple<Triple<Character>>(new Triple<Character>('a', 'b', 'c'), 
						                        new Triple<Character>('m', 'n', 'o'), 
						                        new Triple<Character>('x', 'y', 'z'));
		System.out.println(letterTriples);
		
		// Students filled in: use the generic class for specific type Shape from meeting03
//		Triple<Shape> shapes = new Triple<Shape>(new Circle(9), new Rectangle(1, 2),
//					new Circle(8));
//		System.out.println(shapes);
	}
}