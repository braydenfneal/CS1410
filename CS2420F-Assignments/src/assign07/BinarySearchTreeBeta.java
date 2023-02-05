package assign07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * 
 * @author Erin Parker
 *
 * @param <T>
 */
public class BinarySearchTreeBeta<T extends Comparable<? super T>> implements SortedSet<T> {

	private class BinaryNode<Type> {
		public Type element;
		public BinaryNode<Type> left;
		public BinaryNode<Type> right;
		public BinaryNode<Type> parent;
		
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
	
	public BinarySearchTreeBeta() {
		root = null;
		size = 0;
	}
	
	//Public driver method for add
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

	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	@Override
	public boolean contains(T item) {
		if(root == null) {
			return false;
		}
		return contains(item, root);
	}
	
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

	@Override
	public T first() throws NoSuchElementException {
		if(size == 0) {
			throw new NoSuchElementException("This tree is empty");
		}
		return first(root);
	}
	
	private T first(BinaryNode<T> node) {
		if(node.left == null) {
			return node.element;
		}
		else {
			return first(node.left);
		}
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T last() throws NoSuchElementException {
		if(size == 0) {
			throw new NoSuchElementException("This tree is empty");
		}
		return last(root);
	}
	
	private T last(BinaryNode<T> node) {
		if(node.right == null) {
			return node.element;
		}
		else {
			return last(node.right);
		}
	}

	@Override
	public boolean remove(T item) {
		BinaryNode<T> temp = root;
		
		while(true) {
			int comparison = item.compareTo(temp.element);
			if (comparison == 0) {
				remove(temp);
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

	@Override
	public int size() {
		return size;
	}

	@Override
	public ArrayList<T> toArrayList() {
		//To put elements in order, use inorder traversal
		
		ArrayList<T> order = new ArrayList<T>();
		
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
	 * @param filename
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
