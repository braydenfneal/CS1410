package a4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class LoopPatternsTest {
	
	@Test
	public void lowestAlphabetically() {
		String[] array = {"cat", "dog", "apple", "fish"};
		String[] array2 = {"pencil", "eraser", "book"};
		String[] array3 = {"bug", "car", "ant"};

		assertEquals(LoopPatterns.lowestAlphabetically(array), "apple");
		assertEquals(LoopPatterns.lowestAlphabetically(array3), "bug");
	}
	
	@Test
	public void findSmallestNumberInTwoArrays() {
	    int[] array1 = { 13, 7, 9 };
	    int[] array1b = { 23, 6, 65 };
	    int[] array2 = {110, 650, 219};
	    int[] array2b = {200, 199, 198};
	    assertEquals(LoopPatterns.findSmallestNumberInTwoArrays(array1, array1b), 6);
	    assertEquals(LoopPatterns.findSmallestNumberInTwoArrays(array2, array2b), 110);
	}
	
	@Test
	public void curveScores() {
		int[] array1 = {45, 85, 90};
		int[] array1b = {55, 95, 100};
		int[] array2 = {22, 60, 70};
		int[] array2b = {52, 90, 100};
	    assertArrayEquals(LoopPatterns.curveScores((array1)), (array1b));
	    assertArrayEquals(LoopPatterns.curveScores(array2), (array2b));
	}
	
	@Test
	public void makeGrey() {
		Picture picture = new Picture("Arches.jpg");
		Picture picture2 = new Picture("grey.png");
		assertEquals(LoopPatterns.makeGrey(picture), picture2);
	}
	
	@Test
	public void makeNegative() {
		Picture picture = new Picture("Arches.jpg");
		Picture picture2 = new Picture("negative.png");
		assertEquals(LoopPatterns.makeNegative(picture), picture2);
	}
	
	@Test
	public void makeBrighter() {
		Picture picture = new Picture("Arches.jpg");
		Picture picture2 = new Picture("brighter.png");
		assertEquals(LoopPatterns.makeBrighter(picture, 2.0), picture2);
	}
	
	@Test
	public void mergeImages() {
		Picture picture = new Picture("Arches.jpg");
		Picture picture2 = new Picture("ArchesCat-1.jpg");
		assertEquals(LoopPatterns.mergeImages(picture, picture2), picture2);
	}
}


