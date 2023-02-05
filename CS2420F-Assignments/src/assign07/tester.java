package assign07;

import java.util.ArrayList;

public class tester {

	public static void main(String[] args) {
		BinarySearchTreeBeta<Integer> tree = new BinarySearchTreeBeta<Integer>();
		
		System.out.println(tree.add(5));
		System.out.println(tree.add(5));
		tree.add(2);
		tree.add(3);
		tree.add(8);
		
		ArrayList<Integer> boing = new ArrayList<Integer>();
		boing.add(1);
		boing.add(20);
		boing.add(5);
		
		System.out.println(tree.addAll(boing));
		System.out.println(tree.size());
		
		tree.clear();
		tree.add(5);
		tree.add(9);
		System.out.println(tree.size());
		
		boolean containsFive = tree.contains(5);
		System.out.println("Contains 5? " + containsFive);
		boolean containsSeven = tree.contains(7);
		System.out.println("Contains 7? " + containsSeven);
		System.out.println("Contains bad list? " + tree.containsAll(boing));
		ArrayList<Integer> boing2 = new ArrayList<Integer>();
		boing2.add(5);
		boing2.add(9);
		System.out.println("Contains good list? " + tree.containsAll(boing2));
		tree.add(8);
		tree.add(20);
		tree.add(1);
		tree.add(0);
		
		System.out.println("First: " + tree.first());
		System.out.println("Last: " + tree.last());
		
		System.out.println("Empty? " + tree.isEmpty());
		System.out.println("Size: " + tree.size());
		
//		ArrayList<Integer> toRemove = new ArrayList<Integer>();
//		toRemove.add(1);
//		toRemove.add(0);
//		toRemove.add(5);
//		toRemove.add(8);
//		toRemove.add(9);
//		tree.removeAll(toRemove);
//		System.out.println(tree.size());
		
		ArrayList<Integer> list = tree.toArrayList();
		System.out.print("Order: ");
		for(Integer i: list) {
			System.out.print(i + " ");
		}
		
		tree.generateDotFile("test");

	}

}
