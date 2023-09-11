package a4;

//"CS1410 Assignment 4: LoopPatterns by Brayden Neal"
import java.awt.Color;
import java.util.Arrays;
import java.util.Scanner;

public class LoopPatterns {
	/*
	 * The parameter contains the String containing the lowest alphabetical word.
	 *  
	 * @param words a String[]
	 * @return the word with lowest alphabetical word
	 */
	public static String lowestAlphabetically(String[] words) {
		String word = words[0];
		for (int i = 1; i < words.length; i++) {
			if (word.compareTo(words[i]) >= 1)
				word = words[i];
		}
		return word;
	}
	/*
	 * The parameter contains smallest integer 
	 * 
	 * @param num1 an int[] and num2 an int[]
	 * @return an int containing the smallest number found in the two arrays.
	 */
	public static int findSmallestNumberInTwoArrays(int[] num1, int[] num2) {
		int ans = num1[0];
		for (int i = 1; i < num1.length; i++) {
			int n = num1[i];
			if (n < ans) {
				ans = n;
			}

		}
		for (int i = 0; i < num2.length; i++) {
			int n = num2[i];
			if (n < ans) {
				ans = n;
			}

		}
		return ans;

	}
	
	/*
	 * Curve highest score up to 100 and add the amount to
	 * other integers 
	 *
	 *@param num an integer[]
	 *@return the highest number in the 
	 * parameter array becomes 100 and all the other numbers 
	 * are moved up by the same amount.
	 */
	public static int[] curveScores(int[] num) {
		int lnum = num[0];
		for (int i = 1; i < num.length; i++) {
			if (num[i] > lnum) {
				lnum = num[i];
			}
		}
		int number = 100 - lnum;
		for (int i = 0; i < num.length; i++) {
			num[i] = num[i] + number;
		}
		return num;
	}
	
	/*
	 * Make image to a greyscale color
	 * 
	 * @param picture a Picture
	 * @return A new Picture object. Each pixel in the 
	 * returned Picture should have a Color that is the 
	 * greyscale equivalent of the corresponding pixel 
	 * (the pixel with the same x and y coordinate) in the source image.
	 */
	public static Picture makeGrey(Picture picture) {
		int width = picture.width();
		int height = picture.height();
		for (int row = 0; row < height; row++)
			for (int col = 0; col < width; col++) {
				Color color = picture.get(col, row);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				int gray = (red + green + blue) / 3;

				Color newColor = new Color(gray, gray, gray);
				picture.set(col, row, newColor);
			}
		
		return picture;
	}

	/*
	 * Colors of picture changed to a photonegative style
	 * 
	 * @param picture a Picture
	 * @return Each pixel in the returned Picture
	 *  should have a color that is a "negative" 
	 *  of the corresponding pixel (the pixel with the 
	 *  same x and y coordinate) in the source image.
	 */
	public static Picture makeNegative(Picture picture) {
		int width = picture.width();
		int height = picture.height();
		for (int row = 0; row < height; row++)
			for (int col = 0; col < width; col++) {
				Color color = picture.get(col, row);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				int negred = 255 - red;
				int neggreen = 255 - green;
				int negblue = 255 - blue;

				Color newColor = new Color(negred, neggreen, negblue);
				picture.set(col, row, newColor);
			}
		
		return picture;
	}
	
	/*
	 * Value in parameter is returned unless over 255. If over 255, then
	 * returns 255
	 * 
	 * @param number an integer
	 * @return n int that is the same as the parameter, except that it is 
	 * 0 if the original value is less than zero and it is 255 if the 
	 * original value is greater than 255.
	 */
	public static int safeColor(int number) {
		if (number <= 255)
			return number;
		else
			return 255;
	}
	/*
	 * Creates the image at a brighter level
	 * 
	 * @param picture a Picture and x a double
	 * @return A new Picture object with the color values 
	 * multiplied by the multiplier. 
	 */
	public static Picture makeBrighter(Picture picture, double x) {
		int width = picture.width();
		int height = picture.height();
		for (int row = 0; row < height; row++)
			for (int col = 0; col <= width; col++) {
				Color color = picture.get(col, row);
				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();
				int redb = safeColor(red * (int) x);
				int greenb = safeColor(green * (int) x);
				int blueb = safeColor(blue * (int) x);

				Color newColor = new Color(redb, greenb, blueb);
				picture.set(col, row, newColor);
			}
	
		return picture;
	}
	/*
	 * Create an image of a cat on top of the arches picture
	 * 
	 * @param picture a Picture and picture2 a Picture
	 * @return A new Picture object with the pictures merged
	 */
	public static Picture mergeImages(Picture picture, Picture picture2) {
		int width = picture2.width();
		int height = picture2.height();
		for (int row = 0; row < height; row++)
			for (int col = 0; col < width; col++) {
				Color color = picture2.get(col, row);
				Color color2 = picture.get(col, row);
				if (color.equals(new Color(0, 255, 0))) {
					picture2.set(col, row, color2);
				}
				
			}
		return picture2;

	}

	public static void main(String[] args) {
		Picture picture = new Picture("Arches.jpg");
		Picture picture2 = new Picture("cat.png");
		
		Picture sourceImage = new Picture("Arches.jpg");
		Scanner input = new Scanner(System.in);
		System.out.println("What effect would you like to apply?\n" +
		        "Valid options (do not include the quotes) are\n" +
		        "\"greyscale\", \"negative\", \"brighter\", \"addcat\":");
		String option = input.next();
		if (option.equals("greyscale")) {
			makeGrey(picture);
		}
		else if (option.equals("negative")) {
			makeNegative(picture);
		}
		else if (option.equals("brighter")) {
			makeBrighter(picture, 2.0);
		}
		else if (option.equals("addcat")) {
			mergeImages(picture, picture2);
		}
		else {
			System.out.println("Please type acceptable values");
		}
		// Check option, and call the appropriate methods with the appropriate parameters accordingly
		// to produce the processed picture

		// Display the processed picture
	}
}
