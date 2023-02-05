package assignment1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author CS 2420 staff and Brayden Neal
 * @version September 2, 2021
 *
 */
class MatrixTest {

	/* ******equals tests****** */
	@Test
	void testModerateMatricesEqual() {
		Matrix m1 = new Matrix(new int[][] {
			{1, 2, 3},
			{4, 5, 6}
		});

		Matrix m2 = new Matrix(new int[][] {
			{1, 2, 3},
			{4, 5, 6}
		});

		assertTrue(m1.equals(m2));
	}
	
	@Test
	void testModerateMatricesNotEqual() {
		
		Matrix m1 = new Matrix(new int[][] {
			{1, 2, 3},
			{4, 5, 6}
		});

		Matrix m2 = new Matrix(new int[][] {
			{11, 21, 31},
			{41, 5, 61}
		});
		assertFalse(m1.equals(m2));
	}
	
	@Test
	void testModerateMatricesEqualNegative() {
		
		Matrix m1 = new Matrix(new int[][] {
			{-1, -2, -3},
			{-4, -5, -6}
		});

		Matrix m2 = new Matrix(new int[][] {
			{1, 2, 3},
			{4, 5, 6}
		});
		assertFalse(m1.equals(m2));
	}
	/* ******end equals tests****** */


	/* ******toString tests****** */
	@Test
	void testModerateToString() {
		Matrix m = new Matrix(new int[][] {
			{1, 2},
			{3, 4}
		});

		assertEquals("1 2\n3 4\n", m.toString());
	}
	
	@Test
	void testModerateToStringNegatives() {
		Matrix m = new Matrix(new int[][] {
			{-1, -2},
			{-3, -4}
		});
		assertEquals("-1 -2\n-3 -4\n", m.toString());
	}
	
	@Test
	void testModerateToStringDifferentDimension() {
		Matrix m = new Matrix(new int[][] {
			{1, 2, 3, 4},
			{4, 5, 6, 7},
		});
		assertEquals("1 2 3 4\n4 5 6 7\n", m.toString());
	}
			
	/* ******end toString tests****** */



	/* ******times tests****** */
	@Test
	void testCompatibleTimes() {
		Matrix m1 = new Matrix(new int[][]
				{{1, 2, 3},
				{2, 5, 6}});

		Matrix m2 = new Matrix(new int[][]
				{{4, 5},
				{3, 2},
				{1, 1}});

		// the known correct result of multiplying m1 by m2
		int[][] expected = new int[][]
				{{13, 12},
				{29, 26}};
		
		// the result produced by the times method
		Matrix mulResult = m1.times(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	@Test
	void testCompatibleTimesNegatives() {
		Matrix m1 = new Matrix(new int[][]
				{{-1, -2, -3},
				{-2, -5, -6}});

		Matrix m2 = new Matrix(new int[][]
				{{-4, -5},
				{-3, -2},
				{-1, -1}});

		// the known correct result of multiplying m1 by m2
		int[][] expected = new int[][]
				{{13, 12},
				{29, 26}};
		
		// the result produced by the times method
		Matrix mulResult = m1.times(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	@Test
	void testCompatibleTimesZero() {
		Matrix m1 = new Matrix(new int[][]
				{{1, 2, 3},
				{2, 5, 6}});

		Matrix m2 = new Matrix(new int[][]
				{{0, 0},
				{0, 0},
				{0, 0}});

		// the known correct result of multiplying m1 by m2
		int[][] expected = new int[][]
				{{0, 0},
				{0, 0}};
		
		// the result produced by the times method
		Matrix mulResult = m1.times(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	@Test
	void testIncompatibleTimesRows() {
		Matrix m1 = new Matrix(new int[][]
				{{1, 2, 3},
				{2, 5, 6},
				{7, 8, 9}});

		Matrix m2 = new Matrix(new int[][]
				{{4, 5},
				{3, 2},
				{1, 1}});

		assertThrows(IllegalArgumentException.class, () -> { m1.times(m2); });  
	}
	
	@Test
	void testIncompatibleTimesColumns() {
		Matrix m1 = new Matrix(new int[][]
				{{1, 2, 3},
				{2, 5, 6}});

		Matrix m2 = new Matrix(new int[][]
				{{4, 5, 6},
				{3, 2, 1},
				{1, 1, 1}});

		assertThrows(IllegalArgumentException.class, () -> { m1.times(m2); });  
	}
	/* ******end times tests****** */
	

	/* ******plus tests****** */
	@Test
	public void testIncompatiblePlus() {	
		Matrix m1 = new Matrix(new int[][] {
			{1, 1, 1},
			{1, 1, 1}
		});

		Matrix m2 = new Matrix(new int[][] {
			{2, 2},
			{2, 2}
		});
		
		// This is an example of how to test that an exception is thrown when needed.
		// The odd syntax below is an example of a lambda expression.
		// See Lab 1 for more info.
		assertThrows(IllegalArgumentException.class, () -> { m1.plus(m2); });  
	}
	
	@Test
	void testCompatiblePlusSmall() {
		Matrix m1 = new Matrix(new int[][]
				{{1, 2, 3},
				{2, 5, 6}});

		Matrix m2 = new Matrix(new int[][]
				{{4, 5, 6},
				{3, 2, 1}});

		// the known correct result of adding m1 and m2
		int[][] expected = new int[][]
				{{5, 7, 9},
				{5, 7, 7}};
		
		// the result produced by the plus method
		Matrix mulResult = m1.plus(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	@Test
	void testCompatiblePlusBig() {
		Matrix m1 = new Matrix(new int[][]
				{{1, 2, 3, 4},
				{2, 5, 6, 7},
				{4, 3, 2, 1}});

		Matrix m2 = new Matrix(new int[][]
				{{4, 5, 6, 7},
				{3, 2, 1, 1},
				{6, 5, 4, 1}});

		// the known correct result of adding m1 and m2
		int[][] expected = new int[][]
				{{5, 7, 9, 11},
				{5, 7, 7, 8},
				{10, 8, 6, 2}};
		
		// the result produced by the plus method
		Matrix mulResult = m1.plus(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	@Test
	void testCompatiblePlusNegative() {
		Matrix m1 = new Matrix(new int[][]
				{{-1, -2, -3},
				{-2, -5, -6}});

		Matrix m2 = new Matrix(new int[][]
				{{4, 5, 6},
				{3, 2, 1}});

		// the known correct result of adding m1 and m2
		int[][] expected = new int[][]
				{{3, 3, 3},
				{1, -3, -5}};
		
		// the result produced by the plus method
		Matrix mulResult = m1.plus(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	@Test
	void testCompatiblePlusZero() {
		Matrix m1 = new Matrix(new int[][]
				{{0, 0, 0},
				{0, 0, 0}});

		Matrix m2 = new Matrix(new int[][]
				{{0, 0, 0},
				{0, 0, 0}});

		// the known correct result of adding m1 and m2
		int[][] expected = new int[][]
				{{0, 0, 0},
				{0, 0, 0}};
		
		// the result produced by the plus method
		Matrix mulResult = m1.plus(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	
	/* ******end plus tests****** */
	
	
	
	/* ******transpose tests****** */
	@Test
	public void testSmallTranspose() {
		Matrix m1 = new Matrix(new int[][] {
			{1, 1, 1},
			{1, 1, 1}
		});
		
		int expected[][] = {
				{1, 1},
				{1, 1},
				{1, 1}
		};
		
		Matrix t = m1.transpose();
		int resultArray[][] = t.getData();
		
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	@Test
	public void testBigTranspose() {
		Matrix m1 = new Matrix(new int[][] {
			{1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1}
		});
		
		int expected[][] = {
				{1, 1},
				{1, 1},
				{1, 1},
				{1, 1},
				{1, 1}
		};
		
		Matrix t = m1.transpose();
		int resultArray[][] = t.getData();
		
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	@Test
	public void testSmallTransposeNegative() {
		Matrix m1 = new Matrix(new int[][] {
			{-1, -1, -1},
			{-1, -1, -1}
		});
		
		int expected[][] = {
				{-1, -1},
				{-1, -1},
				{-1, -1}
		};
		
		Matrix t = m1.transpose();
		int resultArray[][] = t.getData();
		
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	/* ******end transpose tests****** */

}
