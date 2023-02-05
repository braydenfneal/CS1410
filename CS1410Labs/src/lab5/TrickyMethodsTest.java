package lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TrickyMethodsTest {

	@Test
	void test() {
		assertEquals(1, TrickyMethods.multiplyUntilAboveThreshold(1, 2, 0), "multiplyUntilAboveThreshold(1, 2, 0) failed");
	}
	  @Test
	    void testBasicMath() {
	        assertEquals(2, 2 + 2, "2+2 failed");
	        assertEquals(2, 2 * 2, "2*2 failed");
	    }
	  
}
