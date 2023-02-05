package assignment1;

/**
 * This class represents a 2D matrix and simple operations on them.
 * 
 * @author Daniel Kopta and Brayden Neal
 * @version September 2, 2021
 *
 */

public class Matrix {

	// the dimensions of the matrix
	private int numRows;
	private int numColumns;

	// the internal storage for the matrix elements
	private int data[][];

	/**
	 * DO NOT MODIFY THIS METHOD. Constructor for a new Matrix. Automatically
	 * determines dimensions. This is implemented for you.
	 * 
	 * @param d - the raw 2D array containing the initial values for the Matrix.
	 */
	public Matrix(int d[][]) {
		// d.length is the number of 1D arrays in the 2D array
		numRows = d.length;
		if (numRows == 0)
			numColumns = 0;
		else
			numColumns = d[0].length; // d[0] is the first 1D array

		// create a new matrix to hold the data
		data = new int[numRows][numColumns];

		// copy the data over
		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numColumns; j++)
				data[i][j] = d[i][j];
	}

	/**
	 * Determines whether this Matrix is equal to another object.
	 * 
	 * @param o - the other object to compare to, which may not be a Matrix
	 */
	@Override // instruct the compiler that we intend for this method to override the
				// superclass' (Object) version
	public boolean equals(Object o) {
		// make sure the Object we're comparing to is a Matrix
		if (!(o instanceof Matrix))
			return false;

		// if the above was not true, we know it's safe to treat 'o' as a Matrix
		Matrix m = (Matrix) o;

		// For loops to iterate through each value to see if the matrices match
		for (int x = 0; x < numRows; x++) {
			for (int y = 0; y < numColumns; y++) {
				if (data[x][y] != m.data[x][y]) {
					return false;
				}
			}
		}

		/*
		 * Returns true if this Matrix is equal to the input Matrix; returns false
		 * otherwise
		 */
		return true;
	}

	/**
	 * Returns a String representation of this Matrix.
	 */
	@Override // instruct the compiler that we intend for this method to override the
				// superclass' (Object) version
	public String toString() {
		String m = "";

		// Uses For loops to iterate through the values
		for (int x = 0; x < numRows; x++) {
			for (int y = 0; y < numColumns; y++) {
				// if statement to see if a space is needed or not
				if (y == numColumns - 1) {
					m += data[x][y];
				} else {
					m += data[x][y] + " ";
				}
			}
			// Makes sure the end of a row creates a new line
			m += "\n";
		}
		return m;
	}

	/**
	 * Returns a new Matrix that is the result of multiplying this Matrix as the
	 * left hand side by the input matrix as the right hand side.
	 * 
	 * @param m - the Matrix on the right hand side of the multiplication
	 * @return - the result of the multiplication
	 * @throws IllegalArgumentException - if the input Matrix does not have
	 *                                  compatible dimensions for multiplication
	 */
	public Matrix times(Matrix m) throws IllegalArgumentException {
		// Checks if dimensions line up for multiplying
		if (numRows != m.numColumns || numColumns != m.numRows) {
			throw new IllegalArgumentException();
		}
		// Creates 2D array with correct dimensions
		int[][] ans = new int[numRows][m.numColumns];
		Matrix a = new Matrix(ans);
		// For loops iterate through the values and multiply correctly
		for (int x = 0; x < numRows; x++) {
			for (int y = 0; y < m.numColumns; y++) {
				int answer = 0;
				for (int i = 0; i < m.numRows; i++) {
					answer += (this.data[x][i] * m.data[i][y]);
				}
				a.data[x][y] = answer;
			}
		}
		return a;
	}

	/**
	 * Returns a new Matrix that is the result of adding this Matrix as the left
	 * hand side by the input matrix as the right hand side.
	 * 
	 * @param m - the Matrix on the right hand side of the addition
	 * @return - the result of the addition
	 * @throws IllegalArgumentException - if the input Matrix does not have
	 *                                  compatible dimensions for addition
	 */
	public Matrix plus(Matrix m) throws IllegalArgumentException {
		if (numRows != m.numRows || numColumns != m.numColumns) {
			throw new IllegalArgumentException();
		}
		// Creates new empty Matrix to store new added matrices
		Matrix ans = new Matrix(data);
		// For loops to iterate what values are in Matrices and adds them together
		for (int x = 0; x < numRows; x++) {
			for (int y = 0; y < numColumns; y++) {
				ans.data[x][y] = data[x][y] + m.data[x][y];
			}
		}
		return ans;
	}

	/**
	 * Produces the transpose of this matrix.
	 * 
	 * @return - the transpose
	 */
	public Matrix transpose() {
		// Create new Matrix to store transposed matrix
		int[][] ans = new int[numColumns][numRows];
		Matrix m = new Matrix(ans);
		// Two for loops to iterate trough the values and transpose them
		for (int x = 0; x < numRows; x++) {
			for (int y = 0; y < numColumns; y++) {
				m.data[y][x] = this.data[x][y];
			}
		}
		return m;
	}

	/**
	 * DO NOT MODIFY THIS METHOD. Produces a copy of the internal 2D array
	 * representing this matrix. This method is for grading and testing purposes.
	 * 
	 * @return - the copy of the data
	 */
	public int[][] getData() {
		int[][] retVal = new int[data.length][];
		for (int i = 0; i < data.length; i++)
			retVal[i] = data[i].clone();
		return retVal;
	}

}
