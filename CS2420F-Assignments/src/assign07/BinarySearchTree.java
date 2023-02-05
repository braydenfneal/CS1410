package assign07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * 
 * @author Erin Parker & Brayden Neal & William Dreyer
 * @version October 7, 2021
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements SortedSet<T> {

	//Private class to represent the nodes in the tree
	private class BinaryNode<Type> {
		public Type element;
		public BinaryNode<Type> left;
		public BinaryNode<Type> right;
		public BinaryNode<Type> parent;
		
		//Creates a binary node with the specified data and parent
		public BinaryNode(Type element, BinaryNode<Type> parent) {
			this.parent = parent;
			this.element = element;
			this.left = null;
			this.right = null;	
		}
		
		/**
		 * @return a string containing all of the edges in the tree rooted at "this"
		 *         node, in DOT format
		 */
		public String generateDot() {
			String ret = "\tnode" + element + " [label = \"<f0> |<f1> " + element + "|<f2> \"]\n";
			if(left != null)
				ret += "\tnode" + element + ":f0 -> node" + left.element + ":f1\n" + left.generateDot();
			if(right != null)
				ret += "\tnode" + element + ":f2 -> node" + right.element + ":f1\n" + right.generateDot();

			return ret;
		}
	}
	
	private BinaryNode<T> root;
	private int size;
	
	//Default constructor for a BinarySearchTree
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	
	/**
	 * Public driver method for add
	 * Adds the specified item to its place in the binary search tree
	 * @param item - the item to be added
	 * @return a boolean representing if tree was changed
	 */
	@Override
	public boolean add(T item) {
		if(root == null) {
			root = new BinaryNode<T>(item, null);
			size++;
			return true;
		}
		
		return add(item, root);
	}
	
	//Private recursive method for add
	private boolean add(T item, BinaryNode<T> node) {
		if(item.equals(node.element)) {
			return false;
		}
		else if(item.compareTo(node.element) > 0) {
			if(node.right != null) {
				return add(item, node.right);
			}
			else {
				node.right = new BinaryNode<T>(item, node);
				size++;
				return true;
			}
		}
		else {
			if(node.left != null) {
				return add(item, node.left);
			}
			else {
				node.left = new BinaryNode<T>(item, node);
				size++;
				return true;
			}
		}
	}

	@Override
	/**
	 * Adds each of the items in the collection to the tree
	 * @param items - a collection of items to be added to the tree
	 * @return - a boolean representing if the tree was changed
	 */
	public boolean addAll(Collection<? extends T> items) {
		boolean wasModified = false;
		boolean temp;
		for(T item: items) {
			temp = add(item);
			if(temp) {
				wasModified = true;
			}
		}
		return wasModified;
	}

	/**
	 * Clears the tree
	 */
	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * Checks to see if the tree contains the specified item
	 * Driver method for contains
	 * @param item - the item whose presence should be checked for in the tree
	 * @return - a boolean representing if the tree contains the item or not
	 */
	@Override
	public boolean contains(T item) {
		if(root == null) {
			return false;
		}
		return contains(item, root);
	}
	
	//Private recursive method for contains
	private boolean contains(T item, BinaryNode<T> node) {
		if(item.equals(node.element)) {
			return true;
		}
		else if(item.compareTo(node.element) > 0) {
			if(node.right != null) {
				return contains(item, node.right);
			}
			else {
				return false;
			}
		}
		else {
			if(node.left != null) {
				return contains(item, node.left);
			}
			else {
				return false;
			}
		}
	}

	/**
	 * Checks to see if the tree contains all of the items in the collection
	 * @param items - a collection of items whose presences are to be checked in the tree
	 * @return - a boolean representing whether or not the tree contains ALL of the items in the collection
	 */
	@Override
	public boolean containsAll(Collection<? extends T> items) {
		boolean hasAll = true;
		for(T item: items) {
			if(!contains(item)) {
				hasAll = false;
			}
		}
		return hasAll;
	}

	/**
	 * Driver method for first
	 * @return - the first element in the tree
	 */
	@Override
	public T first() throws NoSuchElementException {
		if(size == 0) {
			throw new NoSuchElementException("This tree is empty");
		}
		return first(root);
	}
	
	/**
	 * Private recursive method for first
	 */
	private T first(BinaryNode<T> node) {
		if(node.left == null) {
			return node.element;
		}
		else {
			return first(node.left);
		}
	}

	/**
	 * Returns whether or not this tree is empty
	 * @return - a boolean representing whether or not the tree is empty
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Public driver method for last
	 * @return - the last element in the tree
	 */
	@Override
	public T last() throws NoSuchElementException {
		if(size == 0) {
			throw new NoSuchElementException("This tree is empty");
		}
		return last(root);
	}
	
	/**
	 * Private driver method for last
	 */
	private T last(BinaryNode<T> node) {
		if(node.right == null) {
			return node.element;
		}
		else {
			return last(node.right);
		}
	}

	/**
	 * Removes the specified item from the tree
	 * @param item - the item to be removed from the tree
	 * @return - a boolean representing whether or not the tree changed
	 */
	@Override
	public boolean remove(T item) {
		BinaryNode<T> temp = root;
		
		while(true) {
			if(root == null) {
				return false;
			}
			int comparison = item.compareTo(temp.element);
			if (comparison == 0) {
				remove(temp);
				size--;
				return true;
			} else if(comparison > 0) {
				if (temp.right != null) {
					temp = temp.right;
				} else {
					return false;
				}
			} else {
				if(temp.left != null) {
					temp = temp.left;
				} else {
					return false;
				}
			}
		}
	}
	
	//Private helper method for remove to handle the 3 cases of removing a node
	private void remove(BinaryNode<T> node) {
		//There are no children (leaf node)
		if(node.right == null && node.left == null) {
			//Handle special case where parent doesn't exist (root node)
			if(root.equals(node)) {
				root = null;
				return;
			}
			if(node.equals(node.parent.right)) {
				node.parent.right = null;
			}
			else {
				node.parent.left = null;
			}
		}
		//There is one child
		else if((node.right == null && node.left != null) || (node.right != null && node.left == null)) {
			//Handle case where parent doesn't exist (root node)
			if(root.equals(node)) {
				if(node.right == null) {
					root = node.left;
					return;
				}
				else {
					root = node.right;
					return;
				}
			}
			if(node.right == null) {
				if(node.equals(node.parent.right)) {
					node.parent.right = node.left;
					node.left.parent = node.parent;
				}
				else {
					node.parent.left = node.left;
					node.left.parent = node.parent;
				}
			}
			else {
				if(node.equals(node.parent.right)) {
					node.parent.right = node.right;
					node.right.parent = node.parent;
				}
				else {
					node.parent.left = node.right;
					node.right.parent = node.parent;
				}
			}
		}
		//There are two children
		else {
			BinaryNode<T> successor = node.right;
			while(successor.left != null) {
				successor = successor.left;
			}
			
			//Replace original node with successor
			node.element = successor.element;
			
			//Remove successor node
			if(successor.right != null) {
				if(successor.equals(successor.parent.right)) {
					successor.parent.right = successor.right;
					successor.right.parent = successor.parent;
				}
				else {
					successor.parent.left = successor.right;
					successor.right.parent = successor.parent;
				}
			}
			else {
				if(successor.equals(successor.parent.right)) {
					successor.parent.right = null;
				}
				else {
					successor.parent.left = null;
				}
			}
		}
	}

	/**
	 * Removes all of the items in the collection from the tree
	 * @param items - a collection of items to be removed from the tree
	 * @return - a boolean representing if the tree changed or not
	 */
	@Override
	public boolean removeAll(Collection<? extends T> items) {
		boolean removedAny = false;
		for(T item: items) {
			if(remove(item)) {
				removedAny = true;
			}
		}
		return removedAny;
	}

	/**
	 * Returns the size of the tree
	 * @return - the size of the tree
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns the contents of the tree in the form of an ArrayList
	 * @return - an ArrayList containing all of the elements of the tree, in order
	 */
	@Override
	public ArrayList<T> toArrayList() {
		//To put elements in order, use inorder traversal
		
		ArrayList<T> order = new ArrayList<T>();
		
		if(root == null) {
			return order;
		}
		traverse(root, order);
		
		return order;
	}
	
	//Private helper method to build the ArrayLists
	private void traverse(BinaryNode<T> node, ArrayList<T> list) {
		
		if(node.left != null) {
			traverse(node.left, list);
		}
		list.add(node.element);
		if(node.right != null) {
			traverse(node.right, list);
		}
		return;
	}
	
	/**
	 * Write a DOT representation of this BST to file.
	 * 
	 * @param filename - file name for the DOT representation
	 */
	public void generateDotFile(String filename) {
		try {
			PrintWriter out = new PrintWriter(filename);
			out.println("digraph Tree {\n\tnode [shape=record]\n");

			if(root == null)
				out.println("");
			else
				out.print(root.generateDot());

			out.println("}");
			out.close();
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}

}