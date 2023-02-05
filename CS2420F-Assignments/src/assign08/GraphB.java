package assign08;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author Daniel Kopta This Graph class acts as a starting point for your maze
 *         path finder. Add to this class as needed.
 */
public class GraphB {

	// The graph itself is just a 2D array of nodes
	private Node[][] nodes;

	// The node to start the path finding from
	private Node start;
	private Node goal;

	// The size of the maze
	private int width;
	private int height;

	/**
	 * Constructs a maze graph from the given text file.
	 * 
	 * @param filename - the file containing the maze
	 * @throws Exception
	 */
	public GraphB(String filename) throws Exception {
		BufferedReader input;
		input = new BufferedReader(new FileReader(filename));

		if (!input.ready()) {
			input.close();
			throw new FileNotFoundException();
		}

		// read the maze size from the file
		String[] dimensions = input.readLine().split(" ");
		height = Integer.parseInt(dimensions[0]);
		width = Integer.parseInt(dimensions[1]);

		// instantiate and populate the nodes
		nodes = new Node[height][width];
		for (int i = 0; i < height; i++) {
			String row = input.readLine().trim();

			for (int j = 0; j < row.length(); j++)
				switch (row.charAt(j)) {
				case 'X':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isWall = true;
					break;
				case ' ':
					nodes[i][j] = new Node(i, j);
					break;
				case 'S':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isStart = true;
					start = nodes[i][j];
					break;
				case 'G':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isGoal = true;
					goal = nodes[i][j];
					break;
				default:
					throw new IllegalArgumentException("maze contains unknown character: \'" + row.charAt(j) + "\'");
				}
		}
		input.close();
	}

	/**
	 * Outputs this graph to the specified file. Use this method after you have
	 * found a path to one of the goals. Before using this method, for the nodes on
	 * the path, you will need to set their isOnPath value to true.
	 * 
	 * @param filename - the file to write to
	 */
	public void printGraph(String filename) {
		try {
			PrintWriter output = new PrintWriter(new FileWriter(filename));
			output.println(height + " " + width);
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					output.print(nodes[i][j]);
				}
				output.println();
			}
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Traverse the graph with BFS (shortest path to closest goal) A side-effect of
	 * this method should be that the nodes on the path have had their isOnPath
	 * member set to true.
	 * 
	 * @return - the length of the path
	 */
	public int CalculateShortestPath() {
		int length = 0;
		LinkedList<Node> q = new LinkedList<>();
		start.isOnPath = true;
		q.add(start);
		while (!q.isEmpty()) {
			Node current = q.poll();
			if (current == goal) {
				return length;
			}
			//for (Node n : )
			
		}
		
		
		return 0;
	}

	/**
	 * Traverse the graph with DFS (any path to any goal) A side-effect of this
	 * method should be that the nodes on the path have had their isOnPath member
	 * set to true.
	 * 
	 * @return - the length of the path
	 */
	public int CalculateAPath() {
		int length = 0;
		Stack<Node> stack = new Stack<>();
		stack.push(start);
		start.visited = true;
		Node current = start;

		while (!stack.isEmpty()) {

			stack.pop();
			if (current == goal) {
				return length;
			} 
				// up
			else if (!(new Node(current.x-1, current.y)).isWall && !(new Node(current.x-1, current.y)).visited) {
					current = new Node (current.x -1, current.y);
					stack.push(current);
					current.isOnPath = true;
					current.visited = true;
					length += 1;
				}
				// right
			else if (!(new Node(current.x, current.y + 1)).isWall && !(new Node(current.x, current.y + 1)).visited) {
					current = new Node(current.x, current.y + 1);
					stack.pop();
					stack.push(current);
					current.isOnPath = true;
					current.visited = true;
					length += 1;
				}
				// down
			else if (!(new Node(current.x+1, current.y)).isWall && !(new Node(current.x+1, current.y)).visited) {
					current = new Node(current.x + 1, current.y);
					stack.pop();
					stack.push(current);
					current.isOnPath = true;
					current.visited = true;
					length += 1;
				}
				// left
			else if (!(new Node(current.x, current.y - 1)).isWall && !(new Node(current.x, current.y - 1)).visited) {
					current = new Node(current.x, current.y - 1);
					stack.pop();
					stack.push(current);
					current.isOnPath = true;
					current.visited = true;
					length += 1;
				}
			else {
				return length;
			}
		}

		return length;
	}

	/**
	 * @author Daniel Kopta A node class to assist in the implementation of the
	 *         graph. You will need to add additional functionality to this class.
	 */
	private static class Node {

		// The node's position in the maze
		private int x, y;

		// The type of the node
		private boolean isStart;
		private boolean isGoal;
		private boolean isOnPath;
		private boolean isWall;
		private boolean visited;

		// TODO: You will undoubtedly want to add more members and functionality to this
		// class.


		public Node(int _x, int _y) {
			isStart = false;
			isGoal = false;
			isOnPath = false;
			visited = false;
			x = _x;
			y = _y;
		}

		@Override
		public String toString() {
			if (isWall)
				return "X";
			if (isStart)
				return "S";
			if (isGoal)
				return "G";
			if (isOnPath)
				return ".";
			return " ";
		}
	}

}
