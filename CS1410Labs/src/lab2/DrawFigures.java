package lab2;

public class DrawFigures {
	public static void drawInvertedV() {
		System.out.println("   /\\");
		System.out.println("  /  \\");
		System.out.println(" /    \\");
	}
	
	public static void drawV() {
		System.out.println(" \\    /");
		System.out.println("  \\  /");
		System.out.println("   \\/");
	}
	
	public static void drawBox(String label) {
		System.out.println("+------+");
		System.out.println("|      |");
		System.out.println("|      |");
		System.out.println("+------+");
		System.out.println("|" + label + "|");
		System.out.println("|      |");
		System.out.println("+------+");
		System.out.println("|      |");
		System.out.println("|      |");
		System.out.println("+------+");
	}
	/**
     * Prints out a diamond, an X, and a rocket.
     */
	public static void main (String[] args)
	{
		drawInvertedV();
		System.out.println();
		drawV();
		drawInvertedV();
		System.out.println();
		drawInvertedV();
		drawBox("      ");
		drawInvertedV();
	}
	
}
