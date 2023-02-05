package lab1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiffUtilTest {

	@Test
	public void testAllSameNum() {
	  int arr[] = new int[] { 3, 3, 3 };
	  assertEquals(0, DiffUtil.findSmallestDiff(arr));
	}
		
	@Test
	public void testNegAndPos() {
	  int arr[] = new int[] { 52, 4, -8, 0, -17 };
	  assertEquals(4, DiffUtil.findSmallestDiff(arr));
	}
	//This is the right way to Test a "Throws"
	@Test
	public void testTooSmallArray() {
	  int arr[] = new int[0];
	  assertThrows(IllegalArgumentException.class, () -> { DiffUtil.findSmallestDiff(arr); });
	}
	@Test
	public void testOnlyNeg() {
		int arr[] = new int[] {-52, -4, -8, -10, -17};
		assertEquals(-48, DiffUtil.findSmallestDiff(arr));
	}
}
