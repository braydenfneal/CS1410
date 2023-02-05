package assign08;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;


/**
 * 
 * @author Daniel Kopta
 * This Graph class acts as a starting point for your maze path finder.
 * Add to this class as needed.
 */
public class Graph {

	// The graph itself is just a 2D array of nodes
	private Node[][] nodes;
	
	// The node to start the path finding from
	private Node start;
	
	private Node goal;
	
	// The size of the maze
	private int width;
	private int height;
	
	//
	//private int dist[];
	//private Set<Node> settled;
	//private PriorityQueue<Node> pq;
	
	//private int v;
	//List<List<Node>> adj;
	private int length = 0;
	
	private Stack<Node> path;
	private static final int MIN_PATH_LENGTH = 4;
	private ArrayList<Node> checked = new CellsList();
	//checked = new CellsList();
		//Node temp1 = new Node(0, 0);
	//int[] tempArr = new int[10];
	//checked.add(tempArr);
	private Node OriginToken;
	//
	/**
	 * Constructs a maze graph from the given text file.
	 * @param filename - the file containing the maze
	 * @throws Exception
	 */
	public Graph(String filename) throws Exception
	{
		//pq =  new PriorityQueue<Node>();
		
		BufferedReader input;
		input = new BufferedReader(new FileReader(filename));

		if(!input.ready())
		{
			input.close();
			throw new FileNotFoundException();
		}

		// read the maze size from the file
		String[] dimensions = input.readLine().split(" ");
		height = Integer.parseInt(dimensions[0]);
		width = Integer.parseInt(dimensions[1]);

		// instantiate and populate the nodes
		nodes = new Node[height][width];
		for(int i=0; i < height; i++)
		{
			String row = input.readLine().trim();

			for(int j=0; j < row.length(); j++)
				switch(row.charAt(j))
				{
				case 'X':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isWall = true;
					break;
				case ' ':
					nodes[i][j] = new Node(i, j);
					//v ++;
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
	 * Outputs this graph to the specified file.
	 * Use this method after you have found a path to one of the goals.
	 * Before using this method, for the nodes on the path, you will need 
	 * to set their isOnPath value to true. 
	 * 
	 * @param filename - the file to write to
	 */
	public void printGraph(String filename)
	{
		try
		{
			PrintWriter output = new PrintWriter(new FileWriter(filename));
			output.println(height + " " + width);
			for(int i=0; i < height; i++)
			{
				for(int j=0; j < width; j++)
				{
					output.print(this.nodes[i][j]);
				}
				output.println();
			}
			output.close();
		}
		catch(Exception e){e.printStackTrace();}
	}

	public void printGraphToConsole()
	{
		try
		{
			//PrintWriter output = new PrintWriter(new FileWriter(filename));
			System.out.println(height + " " + width);
			for(int i=0; i < height; i++)
			{
				for(int j=0; j < width; j++)
				{
					System.out.print(this.nodes[i][j]);
				}
				System.out.println();
			}
			System.out.close();
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	/**
	 * Traverse the graph with BFS (shortest path to closest goal)
	 * A side-effect of this method should be that the nodes on the path
	 * have had their isOnPath member set to true.
	 * @return - the length of the path
	 */
	public int CalculateShortestPath()
	{
		// TODO: Fill in this method
		return 2;
	}

	
	/**
	 * Traverse the graph with DFS (any path to any goal)
	 * A side-effect of this method should be that the nodes on the path
	 * have had their isOnPath member set to true.
	 * @return - the length of the path
	 */
	public int CalculateAPath()
	{
		// TODO: Fill in this method
		//pq.add(new Node(this.start.x, this.start.y));
		//dist[this.start.x] = 0; 
//		Node temp;
//		CellsList checked = new CellsList();
		this.length = 0;
		int tempX = this.start.x;
		int tempY = this.start.y;

		path = new Stack<>();
		OriginToken = this.start;
		
		boolean found  = findPath(this.start.x, this.start.y);
		if(found == true) {
			for(Node n : this.path)
			{
				n.isOnPath = true;
			}
			return this.path.size();
		} else {
			return 0;
		}
	}
	
	private boolean findPath(int row, int col)
	{
//		if(nodes[row][col] != OriginToken)
//		{
//			return false;
//		}
		Node cell  = this.nodes[row][col];
		if(this.nodes[row][col].isWall == true)
			return false;
		if(checked.contains(cell)) {
			return false;
		}
		CellsList neighbors = getNeighbors(row, col);
		
		if(/** path.size() > MIN_PATH_LENGTH) **/ neighbors.contains(this.goal)) {
			path.add(cell);
			this.nodes[row][col].isOnPath = true;
			//this.length ++;
			return true;
		}
		checked.add(cell);
		if(cell.isStart != true)
			path.add(cell);
		
		for(Node neighbor : neighbors) {
			OriginToken = cell;
			boolean found = findPath(neighbor.x, neighbor.y);
			if(found) {
				this.nodes[row][col].isOnPath = true;
				length ++;
				return true;
			}
		}
		
		this.path.pop();
		return false;
	}

	private CellsList getNeighbors(int row, int col) {
		CellsList neighbors = new CellsList();
//		for (int colNum = col - 1 ; colNum <= (col + 1) ; colNum +=1  ) {
//
//            for (int rowNum = row - 1 ; rowNum <= (row + 1) ; rowNum +=1  ) {
//
//                if(!((colNum == col) && (rowNum == row))) {
//
//                    if(withinGrid (rowNum, colNum )  ) {
//
//                        neighbors.add(this.nodes[rowNum][colNum]);
//                    }
//                }
//            }
//		}

		//up
		if(withinGrid(col, row - 1)==true && this.nodes[row - 1][col].isWall != true)
			neighbors.add(this.nodes[row - 1][col]);
		//down
		if(withinGrid(col, row + 1)==true && this.nodes[row + 1][col].isWall != true)
			neighbors.add(this.nodes[row + 1][col]);
				//left
		if(withinGrid(col - 1, row)==true && this.nodes[row][col-1].isWall != true)
			neighbors.add(this.nodes[row][col - 1]);
		//right
		if(withinGrid(col + 1, row)==true && this.nodes[row][col+1].isWall != true)
			neighbors.add(this.nodes[row][col + 1]);
	return neighbors;
	}

	private boolean withinGrid(int colNum, int rowNum) {
		if((colNum < 0) || (rowNum < 0)) {
			return false;
		}
		if((colNum >= this.width) || (rowNum >= this.height)) {
			return false;
		}
		return true;
	}
	
	class CellsList extends ArrayList<Node> {
		private static final long serialVersionUID = 1L;

		@Override
		public boolean contains(Object o) {
			for(Node a : this) {
				if(a.equals((Node) o)) {
					return true;
				}
			}
				return false;
		}
	}
	
	/**
	 * @author Daniel Kopta
	 * 	A node class to assist in the implementation of the graph.
	 * 	You will need to add additional functionality to this class.
	 */
	private static class Node
	{
		// The node's position in the maze
		private int x, y;
		
		// The type of the node
		private boolean isStart;
		private boolean isGoal;
		private boolean isOnPath;
		private boolean isWall;

		private boolean attempted;
		
		// TODO: You will undoubtedly want to add more members and functionality to this class.
				
		public Node(int _x, int _y)
		{
			isStart = false;
			isGoal = false;
			isOnPath = false;
			x = _x;
			y = _y;
			attempted = false;
		}
		
		
		@Override
		public String toString()
		{
			if(isWall)
				return "X";
			if(isStart)
				return "S";
			if(isGoal)
				return "G";
			if(isOnPath)
				return ".";
			return " ";
		}
	}
	
	public static void main(String[] args)
	{
		Graph test = null;
		try
		{
			test = new Graph("assignment8_files/tinyOpen.txt");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(test.CalculateAPath());
	}
	
}
