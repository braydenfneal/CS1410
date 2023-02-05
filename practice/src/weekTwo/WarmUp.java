package weekTwo;

/**
 * A class containing code from the warm-up problem, intended for 
 * additional experimentation by students.
 * 
 * @author Erin Parker
 * @version January 18, 2022
 */
public class WarmUp {
	
	public static void main(String[] args) {
	
		int input1 = 3;
		int input2 = 11;
		int result = 0;
	
		char operator = '+';
	
		switch(operator) {
		   case'+':
		   	result = input1 + input2;
	   		break;
		   case('-'):
		   	result = input1 - input2;
	   		break;
		   case('*'):
		   	result = input1 * input2;
	   		break;
		   case('/'):
		   	result = input1 / input2;
	   		break;
		   case('%'):
		   	result = input1 % input2;
	   		break;
	   	default:
	   		System.out.println("The operator character must be +, -, *, /, or %.");
	   		System.exit(1);
		}
		
		System.out.println("The result of " + input1 + " " + operator + " " + input2 + " is " + result);	
	}
}