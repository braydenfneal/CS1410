package a2;

//"CS1410 Assignment 2: Small Methods by Brayden Neal"
public class SmallMethods {

	/*
	 * Returns true if the input parameter is equal to 0 and false otherwise.
	 * 
	 * @param number an integer value
	 * 
	 * @return if parameter is zero
	 */
	public static boolean isZero(int number) {
		boolean answer = number == 0;
		return answer;
	}

	/*
	 * Returns "Zero" if the number is equal to 0 and "Not Zero" otherwise. This
	 * method must call isZero to check if the number is 0 or not.
	 * 
	 * @param number an integer
	 * 
	 * @return if parameter is zero
	 */
	public static String describeNumber(int number) {
		if (number == 0) {
			return ("Zero");
		} else {
			return ("Not Zero");
		}
	}

	/*
	 * Returns "Zero" if the number is equal to 0, "Positive" if the number is
	 * greater than zero, and "Negative" if the number is less than 0. You do not
	 * need to use isZero in this method.
	 * 
	 * @param number an integer
	 * 
	 * @return if parameter is positive or negative
	 */
	public static String classifyNumber(int number) {
		if (number == 0) {
			return ("Zero");
		} else if (number > 0) {
			return ("Positive");
		} else {
			return ("Negative");
		}
	}

	/*
	 * Returns true if the parameter value is evenly divisible by 2 or by 7 and
	 * false otherwise.
	 * 
	 * @param number an integer
	 * 
	 * @return if parameter is divisible by 2 or 7
	 */
	public static boolean isDivisibleByTwoOrSeven(int number) {
		boolean answer = false;
		if (number % 2 == 0 || number % 7 == 0) {
			answer = true;
		}
		return answer;
	}

	/*
	 * Returns the smaller of the two parameters.
	 * 
	 * @param number1 a double, and number2 a double
	 * 
	 * @return the smaller number of the two parameters
	 */
	public static double chooseSmaller(double number1, double number2) {
		if (number1 > number2) {
			return (number2);
		} else {
			return (number1);
		}
	}

	/*
	 * Using the parameter as a starting value, repeatedly double (times 2) this
	 * number until it is larger than (and not equal to) 50.
	 * 
	 * @param number an integer
	 * 
	 * @return the parameter doubled until larger than but not equal to 50
	 */
	public static int firstDoublingPastFifty(int number) {
		if (number <= 0) {
			return (0);
		}
		while (number > 0 && number <= 50) {
			number *= 2;
		}
		return number;
	}

	/*
	 * Add an indefinite article ("a" or "an") and a space to the start of the input
	 * parameter.
	 * 
	 * @param word a string
	 * 
	 * @return is the correct indefinite article to the parameter
	 */
	public static String addIndefiniteArticle(String word) {
		String a = "a";
		String e = "e";
		String i = "i";
		String o = "o";
		String u = "u";
		String article1 = "a ";
		String article2 = "an ";
		if (word.charAt(0) == (a.charAt(0))) {
			return (article2 + word);
		} else if (word.charAt(0) == (e.charAt(0))) {
			return (article2 + word);
		} else if (word.charAt(0) == (i.charAt(0))) {
			return (article2 + word);
		} else if (word.charAt(0) == (o.charAt(0))) {
			return (article2 + word);
		} else if (word.charAt(0) == (u.charAt(0))) {
			return (article2 + word);
		} else {
			return (article1 + word);

		}
	}

	/*
	 * Return a String which contains alternating letters from the input string,
	 * starting by including the first letter and then skipping the next.
	 * 
	 * @param word a string
	 * 
	 * @return the parameter's every other letter
	 */
	public static String skipLetters(String word) {
		int letter = 0;
		String answer = "";
		while (letter <= word.length()) {
			answer = answer + (word.charAt(letter));
			letter = letter + 2;
		}
		return answer;
	}

	/*
	 * Look at all integer numbers from 0 up to but not including the parameter, and
	 * add up the numbers in that sequence that are divisible by 2 or 7.
	 * 
	 * @param number an integer
	 * 
	 * @return the parameter's sum of all numbers divisible by 2 or 7
	 */
	public static int sumDivisibleByTwoOrSeven(int number) {
		int count = 0;
		int sum = 0;
		while (count < number) {
			if (isDivisibleByTwoOrSeven(count)) {
				sum += count;
			}
			count++;
		}
		return sum;
	}

	/**
	 * Produces a String starting and ending with the edge character and having the
	 * inner char repeated in-between. The total number of characters in the string
	 * is width. As an example makeLine('+', '-', 8) would return the string
	 * "+------+".
	 * 
	 * NOTE: This method is already completely implemented and must not be modified
	 * for the assignment.
	 * 
	 * @param edge  The character used at the start and end of the returned string.
	 * @param inner The character repeated in-between the edge char.
	 * @param width The total number of characters in the returned string. Width
	 *              must be greater or equal to 2.
	 * @return A string with width characters.
	 */
	public static String makeLine(char edge, char inner, int width) {
		String line = "";
		int currentLocation = 0;
		// Make the middle part of the line first.
		while (currentLocation < width - 2) {
			line = line + inner;
			currentLocation = currentLocation + 1;
		}
		// Add in the start and end character to the line.
		return edge + line + edge;
	}

	/*
	 * Produces the sides of the square
	 * 
	 * @param width an integer
	 * 
	 * @return the width of the sides of the square
	 */
	public static String makeSide(int width) {
		String side = "";
		int currentLocation = 0;
		{
			while (currentLocation < width - 2) {
				side = side + " ";
				currentLocation = currentLocation + 1;
			}
			return ("|" + side + "|");
		}
	}

	/*
	 * Produces the size the square is going to be
	 * 
	 * @param size an integer
	 * 
	 * @return the characters needed to create the square
	 */
	public static String makeSquare(int size) {
		String square = "";
		int currentLocation = 0;
		{
			square = makeLine('+', '-', size) + "\n";
			while (currentLocation < size - 2) {
				square = square + makeSide(size) + "\n";
				currentLocation = currentLocation + 1;
			}
			return square + makeLine('+', '-', size) + "\n";
		}
	}

	public static void main(String[] args) {
		System.out.println("isZero(0) = " + isZero(0));
		System.out.println("isZero(1) = " + isZero(1));
		System.out.println("isZero(-2) = " + isZero(-2));

		System.out.println("describeNumber(0) = " + describeNumber(0));
		System.out.println("describeNumber(1) = " + describeNumber(1));
		System.out.println("describeNumber(-2) = " + describeNumber(-2));

		System.out.println("classifyNumber(0) = " + classifyNumber(0));
		System.out.println("classifyNumber(1) = " + classifyNumber(1));
		System.out.println("classifyNumber(-2) = " + classifyNumber(-2));

		System.out.println("isDivisibleByTwoOrSeven(7) = " + isDivisibleByTwoOrSeven(7));
		System.out.println("isDivisibleByTwoOrSeven(14) = " + isDivisibleByTwoOrSeven(14));
		System.out.println("isDivisibleByTwoOrSeven(2) = " + isDivisibleByTwoOrSeven(2));

		System.out.println("chooseSmaller(1.2, 1.3) = " + chooseSmaller(1.2, 1.3));
		System.out.println("chooseSmaller(11.2, 12.3) = " + chooseSmaller(11.2, 12.3));
		System.out.println("chooseSmaller(6.2, 4.3) = " + chooseSmaller(6.2, 4.3));

		System.out.println("firstDoublingPastFifty(5) = " + firstDoublingPastFifty(5));
		System.out.println("firstDoublingPastFifty(2) = " + firstDoublingPastFifty(2));
		System.out.println("firstDoublingPastFifty(23) = " + firstDoublingPastFifty(23));

		System.out.println("addIndefiniteArticle(\"apple\") = " + addIndefiniteArticle("apple"));
		System.out.println("addIndefiniteArticle(\"pencil\") = " + addIndefiniteArticle("pencil"));
		System.out.println("addIndefiniteArticle(\"umbrella\") = " + addIndefiniteArticle("umbrella"));

		System.out.println("skipLetters(\"David\") = " + skipLetters("David"));
		System.out.println("skipLetters(\"Brayden\") = " + skipLetters("Brayden"));
		System.out.println("skipLetters(\"Trystan\") = " + skipLetters("Trystan"));

		System.out.println("sumDivisibleByTwoOrSeven(8) = " + sumDivisibleByTwoOrSeven(8));
		System.out.println("sumDivisibleByTwoOrSeven(12) = " + sumDivisibleByTwoOrSeven(12));
		System.out.println("sumDivisibleByTwoOrSeven(15) = " + sumDivisibleByTwoOrSeven(15));

		System.out.println("makeSquare(10):\n" + makeSquare(10));
		System.out.println("makeSquare(5):\n" + makeSquare(5));
		System.out.println("makeSquare(1):\n" + makeSquare(1));
	}
}
