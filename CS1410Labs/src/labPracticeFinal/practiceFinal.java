package labPracticeFinal;

public class practiceFinal {
	public static void question1() {
	// count from 1 to 100
	// check if num is divisible my 3 -> print fizz
	//check if divisible by 5 -> print buzz
	//check if divisible by both -> print fizzbuzz
	//print out number if neither
	for (int i = 1; i < 100; i++) {
		if (i % 3 == 0 && i % 5 == 0) {
			System.out.println("FizzBuzz");
		}
		else if (i % 3 == 0) {
			System.out.println("Fizz");
		}
		else if (i % 5 == 0) {
			System.out.println("Buzz");
		}
		else {
			System.out.println(i);
		}	
	}	
	}
	
	public static int question2(String word) {
		//count and return num of time char a shows up in string
		//charAt(index) and length()
		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (letter == 'a') {
				count++;
			}
		}
		return count;
	}
	
	public static int question3(int num1, int num2) {
		// base case
		if (num2 == 0) {
			return 0;
		}
		// recursive step
		return num1 + question3(num1, num2--);
	}
	
	public interface Talk {
		public String speak();
	}
	
	@Override
	public class Cow implements Talk {
		public String speak() {
			System.out.println("Moo");
		}
	}
	
	// have JButton instance variable to quit
	JButton quit;
	
	//in constructor, have action listener for JButton
	quit = new JButton("Quit");
	add(quit);
	quit.addActionListener(this);
	
	//within actionlistener, quit when pressed
	if (e.getSource == quit)
	public static void main(String[] args) {
		
	}

}


