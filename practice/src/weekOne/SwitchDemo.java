package weekOne;

/**
 * A program to demonstrate how to use a switch statement.
 * 
 * @author Erin Parker
 * @version January 13, 2022
 */
public class SwitchDemo {
	
	public static void main(String[] args) {
				
		char letter = 'b';
		int number = -1;
		
		// This switch statement maps a character to an integer
		// as is done by an alphanumeric telephone keypad.
		
		switch(letter) {
		  case 'a': case 'c': 
	    	  number = 2; 
	    	 break;
//		  case 'b':
//			  number = 1020;
//			  break;
	      case 'd': case 'e': case 'f':
	    	  number = 3;
	    	  break;
	      case 'g': case 'h': case 'i':
	    	  number = 4;
	    	  break;
	      case 'j': case 'k': case 'l':
	    	  number = 5;
	    	  break;
	      case 'm': case 'n': case 'o':
	    	  number = 6;
	    	  break;
	      case 'p': case 'q': case 'r': case 's':
	    	  number = 7;
	    	  break;
	      case 't': case 'u': case 'v':
	    	  number = 8;
	    	  break;
	      case 'w': case 'x': case 'y': case 'z':
	    	  number = 9;
	    	  break;
//	    	default:
//	    		System.out.println("Your letter should be a-z.");
//	    		System.exit(1);
		}

		System.out.println("Letter " + letter + " corresponds to number " + number + ".");
	}
}