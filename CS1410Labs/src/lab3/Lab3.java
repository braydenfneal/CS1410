package lab3;

public class Lab3 {
	
	/**
	 * TODO: What does this method do?
	 * @param word
	 * @return TBD.
	 */
	public static String mysteryMethod(String word) {
		int x = word.length();
		int y = x / 2; // What test cases might you want to consider here?
		
		String a = word.substring(0, y);
		String b = word.substring(y, x);
		
		// What is the value of a? The value of b?
		
		return b + a;
	}
	
	/**
	 * This code should count the number of 'a' characters in the string.
	 * TODO: Use the debugger to figure out why this isn't currently working.
	 * @param word
	 * @return the number of 'a' characters in word.
	 */
	public static int countAs(String word) {
		int count = 0;
		for (int letterPosition = 0; letterPosition < word.length(); letterPosition++) {
			String oneLetter = word.substring(letterPosition, letterPosition + 1);
			if (oneLetter == "a") {
				count += 1;
			}
			System.out.println("char: '" + oneLetter + "', Count: " + count);
		}
		return count;
	}
	
	/**
	 * Take the average of an array by adding up each value divided by the length.
	 * @param array
	 * @return the average of all elements in the array.
	 */
	public static double arrayAverage(int[] array) {
		double runningAverage = 0.0;
		int n = array.length;
		for (int val : array) {
			double valDividedByLength = val / n;
			// TODO: What is the value of valDividedByLength? Set a break point here
			runningAverage += valDividedByLength;
		}
		return runningAverage;
	}
	
	public static void main(String[] args) {
		// Test the mystery method
		String startWord = "football";
		System.out.println("Mystery method with " + startWord + " is " + mysteryMethod(startWord));
		
		// Test the countAs method
		System.out.println("The 'a' count is: " + countAs("An anaconda"));
		
		// Test the arrayAverage method
		int[] allOnes = {1, 1, 1};
		System.out.println("The average is: " + arrayAverage(allOnes));
	}
}