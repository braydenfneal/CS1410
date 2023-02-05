package assign07;

/**
 * Demonstrates how to use the BinaryNode class to build and operate on 
 * binary trees.
 * 
 * @author Erin Parker
 * @version October 19, 2020
 */
public class BinaryNodeDemo {

	public static void main(String[] args) {

		// What does this tree look like?
		BinaryNode<String> b = new BinaryNode<String>("Subtract",
				new BinaryNode<String>("Add", 
						new BinaryNode<String>("1"),
						new BinaryNode<String>("Multiply", 
								new BinaryNode<String>("2"), 
								new BinaryNode<String>("3"))),
				new BinaryNode<String>("4"));

		// change as needed to run on your machine
		BinaryNode.generateDotFile("/Users/erinparker/Desktop/tree.txt", b);   

		System.out.println("Size: " + b.size());

		System.out.print("Preorder: ");
		b.printPreorder();
		System.out.println();

		System.out.print("Postorder: ");
		b.printPostorder();
		System.out.println();

		System.out.print("Inorder: ");
		b.printInorder();
		System.out.println();

		System.out.print("Level-order: ");
		b.printLevelorder();
		System.out.println();

		/*
		BinaryNode<String> b2 = b.duplicate();
		b2.rightChild().resetElement("5");

		System.out.print("\nOld expression tree: ");
		b.printInorder();
		System.out.println();

		System.out.print("\nNew expression tree: ");
		b2.printInorder();
		System.out.println();

		BinaryNode<Integer> b3 = new BinaryNode<Integer>(9, 
				new BinaryNode<Integer>(8),
				new BinaryNode<Integer>(29,
						new BinaryNode<Integer>(21, 
								new BinaryNode<Integer>(4), 
								new BinaryNode<Integer>(17)),
						new BinaryNode<Integer>(28)));

		// change as needed to run on your machine
		BinaryNode.generateDotFile("/Users/erinparker/Desktop/tree2.txt", b3);
		System.out.print("\nPreorder: ");
		b3.printPreorder();
		System.out.println();

		System.out.print("Postorder: ");
		b3.printPostorder();
		System.out.println();

		System.out.print("Inorder: ");
		b3.printInorder();
		System.out.println();
		
		System.out.print("Level-order: ");
		b3.printLevelorder();
		System.out.println();  */
	}
}