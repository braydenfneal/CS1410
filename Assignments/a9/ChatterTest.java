package a9;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChatterTest {

	/*********** test ChatterFullMatch ************/
	
	@Test
	private static void testChatterFullMatch(String phrase) {		
		
		
	}


	/*********** test ChatterLastWord ************/
	
	@Test
	private static void testChatterLastWord(String phrase) {		
		assertEquals(ChatterLastWord.lastWord("my name is brayden"), "brayden");
		
	}
	
	/*********** test ChatterCustom ************/
	
	@Test
	private static void testChatterCustom(String phrase) {		
		assertEquals(ChatterCustom.firstWord("my name is brayden"), "my");
		
	}
}
