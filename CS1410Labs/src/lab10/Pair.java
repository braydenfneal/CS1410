package lab10;

import java.util.ArrayList;


public class Pair<U, V>{
	private U left;
	private V right;
	
	public Pair(U left, V right) {
		this.left = left;
		this.right = right;
	}
	
	public String toString() {
		return "LEFT: " + left + " RIGHT; " + right;
	}
	
	
	public static void main(String[] args) {
		Pair<String, Integer> testPair = new Pair<String, Integer>("David", 10);
		System.out.println(testPair);
		
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("David");
		sList.add("CS1410");
		System.out.println("The index of CS1410 in our arrayList is: " + sList.indexOf("CS1410"));
		sList.remove("David");
		System.out.println(sList);
		System.out.println("The index of CS1410 in our arrayList is: " + sList.indexOf("CS1410"));

		ArrayList<Pair<String, String>> ssList = new ArrayList<Pair<String, String>>();
		Pair<String, String> ss = new Pair<String,String>("David", "J");
		ssList.add(ss);
		ssList.add(new Pair<String, String>("CS", "1410"));
		System.out.println(ssList);
		ssList.remove(ss);
		System.out.println(ssList);
		ssList.remove(new Pair<String,String>("CS", "1410"));
		System.out.println(ssList);
	}
		
	

}
