package weekOne;

import java.awt.Point;
import java.util.Arrays;

/**
 * A program to demonstrate how parameter passing works in Java for 
 * primitive types like int, object reference types, array reference
 * types, and immutable strings.
 * 
 * Note that the methods below are purposely not commented since 
 * students are asked to explain the behaviors.
 * 
 * @author Erin Parker
 * @version January 11, 2022
 */
public class ParamPassingDemo {

	private static void changeIntParam(int num) {
		num = num + 1;
	}

	private static void changePointParam(Point a) {
		a.setLocation(2, 101);
	}
	
	private static void changePointParam2(Point b) {
		b = new Point(91, 131);
		b.setLocation(2, 101);
	}

	private static void changeArrayParam(int[] values) {
		Arrays.sort(values);
	}
	
	private static void changeArrayParam2(int[] data) {
		data = new int[3];
		data[2] = 1000; 
	}

	private static void changeStringParam(String word) {
		word.replaceAll("r", "b");
	}

	public static void main(String[] args) {
		int x = 5;
		System.out.print("PRIMITIVE TYPE: Before method call x is " + x);
		changeIntParam(x);
		System.out.println(", after method call x is " + x);

		Point p = new Point(9, 13);
		System.out.print("\nREFERENCE TYPE: Before method call p.x is " + p.getX());
		//changePointParam(p);
		changePointParam2(p);
		System.out.println(", after method call p.x is " + p.getX());

		int[] arr = { 45, 6, 78, -2 };
		System.out.print("\nREFERENCE TYPE: Before method call arr[2] is " + arr[2]);
		changeArrayParam(arr);
		//changeArrayParam2(arr);
		System.out.println(", after method call arr[2] is " + arr[2]);

		String s = "red";
		System.out.print("\nSTRING TYPE (only exceptional reference type): " + ""
				+ "Before method call s is " + s);
		changeStringParam(s);
		System.out.println(", after method call s is " + s);
	}
}