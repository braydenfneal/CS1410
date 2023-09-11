package a8;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class MovieReviewPredictorTest {
	


	/*********** test linesFromFiles ************/

	@Test
	public void testlinesFromFiles() throws FileNotFoundException {
		String expected = "[4 a excellent movie, 0 a bad movie, 3 pretty decent movie]";
		assertEquals(expected, MovieReviewPredictor.linesFromFile("src/a8/smallReviews.txt").toString());
		}
	

	/*********** test computeScores 
	 * @throws FileNotFoundException ************/
	
	@Test
	public void testComputeScores() throws FileNotFoundException  {
		Scanner s = new Scanner(new File("src/a8/smallReviews.txt"));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.next());
		}
		s.close();
		ArrayList<String> arr = list;
		HashMap<String, Integer> testMap = MovieReviewPredictor.computeScores(arr);
		String expected = "{a=4, pretty=3, movie=7, bad=0, excellent=4, decent=3}";
		assertEquals(expected, testMap);
		}

	/*********** test computeCounts ************/
	
	@Test
	public void testComputeCounts()throws FileNotFoundException {
		Scanner s = new Scanner(new File("src/a8/smallReviews.txt"));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.next());
		}
		s.close();
		ArrayList<String> arr = list;
		HashMap<String, Integer> testMap = MovieReviewPredictor.computeCounts(arr);
		String expected = "{a=2, pretty=1, movie=3, bad=1, excellent=1, decent=1}";
		assertEquals(expected, testMap);
		}

	/*********** test computeWordValues ************/
	
	@Test
	public void testComputeWordValues()throws FileNotFoundException {
		Scanner s = new Scanner(new File("src/a8/smallReviews.txt"));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.next());
		}
		s.close();
		ArrayList<String> arr = list;
		HashMap<String, Double> testMap = MovieReviewPredictor.computeWordValues(arr);
		String expected = "{pretty=3.0, movie=2.3333333333333335, bad=0.0, excellent=4.0, decent=3.0}";
		assertEquals(expected, testMap);
		}
	
	/*********** test predictScores ************/
	
	@Test
	public void testPredictScores()throws FileNotFoundException {
		String arr = "4 a excellent movie";
		String expected = "Predicted: 3.2";
		assertEquals(expected, arr);
		}
	}