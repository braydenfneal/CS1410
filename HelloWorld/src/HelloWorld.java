
public class HelloWorld {

	
	public static void main(String[] args) {
		System.out.println("makeSquare(2):\n" + makeSquare(2));
		System.out.println("makeSquare(5):\n" + makeSquare(5));
		System.out.println("makeSquare(10):\n" + makeSquare(10));
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

	/**
	* Produces a String starting and ending with "|" and having " "
	* repeated in-between. The total number of characters in the string
	* is width. As an example makeEdge(8) would return the string
	* "|      |".
	*
	* @param edge  The set of spaces to be returned at the end of the method.
	* @param width The total number of characters in the returned string. Width
	*              must be greater or equal to 2.
	* @return A string with width characters.
	*/
	public static String makeEdge(int width) {
	String edge = "";
	int currentLocation = 0;
	while (currentLocation < width - 2) {
	edge = edge + " ";
	currentLocation = currentLocation + 1;
	}
	return ("|" + edge + "|");
	}

	/*Returns a string which, when printed out, will
	* be a square shaped like this, but of varying size
	* (note - even though there are the same number of characters
	* side-to-side as up-and-down, the way text is drawn makes this
	* look not like a square. We will consider it a square.):
	*/
	/*
	+-----+
	|     |
	|     |
	|     |
	|     |
	|     |
	+-----+
	*/

	/*The returned string should consist of size
	* lines, each ending with a newline. In addition to the newline, the
	* first and last lines should begin and end with '+' and should contain
	* size-2 '-' symbols. In addition to the newline, the other lines should
	* begin and end with '|' and should contain size-2 spaces.
	* @param size The length and width of the square
	* @return A string that makes the shape of a square.
	*/
	public static String makeSquare(int size) {
	String square = "";
	int currentLocation = 0;
	square = makeLine('+', '-', size) + "\n";
	while (currentLocation < size - 2) {
	square = square + makeEdge(size) + "\n";
	currentLocation = currentLocation + 1;
	}
	return square + makeLine('+', '-', size) + "\n";
	}
}
