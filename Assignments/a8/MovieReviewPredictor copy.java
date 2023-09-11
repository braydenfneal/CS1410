package a8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class reads in a file of movie reviews. From that it "learns" what words
 * are associated with good reviews and what are associated with poor reviews.
 * It can then predict the score for a new review that contains those words.
 * 
 * @author Profs. David E. Johnson & Travis Martin & Brayden Neal
 *
 */
public class MovieReviewPredictor {

    /**
     * Maps a word to its average score, based on the reviews
     * passed to the constructor of this class.
     */
	private HashMap<String, Double> wordValues;

	/**
	 * Constructs a new MovieReviewPredictor by reading in a file of reviews with
	 * scores and using that to create a mapping between a word and its score. At
	 * the end of the constructor, the wordValue HashMap should be filled in and
	 * ready to be used.
	 * @throws FileNotFoundException 
	 * 
	 */
	public MovieReviewPredictor(String filename) throws FileNotFoundException {
		wordValues = computeWordValues(linesFromFile(filename)); 
	}

	/**
	 * Reads the lines from the file and stores each in an ArrayList. Each line
	 * should be processed as follows:
	 * - the line is set to all lower case
	 * - punctuation is removed by removing all characters that are not a through z
	 *   or 0 through 9
	 *   
	 * The processing above can be achieved with the code:
	 * line = line.toLowerCase().replaceAll("[^a-z0-9 ]", "");
	 * 
	 * If the input file is invalid, this method catches the exception, prints
	 * a warning, and returns an empty list.
	 * 
	 * @param filename the name of the file to read
	 * @return an ArrayList of the lines with punctuation removed and made all
	 *         lowercase.
	 * @throws FileNotFoundException 
	 */
	public static ArrayList<String> linesFromFile(String filename) throws FileNotFoundException {
		ArrayList<String> lines = new ArrayList<>();
		
		File file = new File(filename);
		Scanner s = new Scanner(file);
		while (s.hasNextLine()) {
			String line = s.nextLine().toLowerCase();
			line = line.toLowerCase().replaceAll("[^a-z0-9 ]", "");
			lines.add(line);
		}
		s.close();
		System.out.println(lines);
		return lines;
	}

	/**
	 * Given an ArrayList of review Strings, computes the total score associated with
	 * each word.
	 * 
	 * So, for the input ["1 bad movie", "2 good movie"], this returns:
	 * {"bad": 1, "good": 2, "movie": 3}.
	 * 
	 * @param reviews An ArrayList of lines representing reviews. The first word
	 *                in each line is a score.
	 * @return a HashMap of each word as a key and its total score as the
	 *         value
	 */
	public static HashMap<String, Integer> computeScores(ArrayList<String> reviews) {
		   HashMap<String, Integer> totalScores = new HashMap<>();
		   for (String review : reviews) {
			   String[] words = review.split(" ");
			   int rating = Integer.parseInt(review.substring(0));
				for (String word : words) {
				   if (totalScores.containsKey(word)) {
					   int currentCount = totalScores.get(word);
					   totalScores.put(word, rating + currentCount);
				   } else {
					   totalScores.put(word, rating);
				   }
				}
		   }
		return totalScores;
	}
	
	/**
	 * Given an ArrayList of review Strings, computes the number of times each word
	 * appears.
	 * 
	 * So, for the input ["1 bad movie", "2 good movie"], this returns:
	 * {"bad": 1, "good": 1, "movie": 2}.
	 * 
	 * @param reviews An ArrayList of lines representing reviews. The first word
	 *                in each line is a score.
	 * @return a HashMap of each word as a key and the number of times it
	 *         appears in the reviews as a value
	 */
	public static HashMap<String, Integer> computeCounts(ArrayList<String> reviews) {
	   HashMap<String, Integer> wordCounts = new HashMap<>();
	   for (String review : reviews) {
		   String[] words = review.substring(2).split(" ");
			for (String word : words) {
			   if (wordCounts.containsKey(word)) {
				   int currentCount = wordCounts.get(word);
				   wordCounts.put(word, currentCount + 1);
			   } else {
				   wordCounts.put(word, 1);
			   }
			}
	   }
		return wordCounts;
	}

	/**
	 * Given a list of reviews from the file, this method computes the average score
	 * for each word in the reviews and stores that score in a HashMap where the key
	 * is the word and the value is the average score.
	 * 
	 * To get the average score, this first computes the total score for a word and
	 * the number of times it appears.
	 * 
	 * Further, this only stores the word the HashMap if the score is not
	 * an average word - if the score is less than 1.75 or greater than 2.25.
	 * 
	 * @param reviews An ArrayList of lines representing reviews. The first word in
	 *                each line is a score, and all following words are separated by spaces.
	 * @return a HashMap with non-average words as keys, and the "word value" as values
	 */
	public static HashMap<String, Double> computeWordValues(ArrayList<String> reviews) {
		HashMap<String, Integer> computeWordCount = computeCounts(reviews);
		HashMap<String, Integer> computeWordScores = computeScores(reviews);

		HashMap<String, Double> computeWordValues = new HashMap<>();
		for (String review : reviews) {
			double avgScores =  (computeWordCount.get(review) / computeWordScores.get(review));

			if (avgScores < 1.75 || avgScores > 2.25) {
				computeWordValues.put(review, avgScores);
			}
		}
	    return computeWordValues;
	}

	/**
	 * This method predicts a review score given a review. A review is of the form
	 * "some text all in lower case and no punctuation". The predicted score is the
	 * average wordValue of any non-null word.
	 * 
	 * @param review a String of numbers and lowercase letters.
	 * @return the predicted score, or -1 if the review has no words in wordValue.
	 */
	public double predictScore(String review) {
		double totalScore = 0;
		int wordCount = 0;
		
		String[] arr = review.split(" ");
		
		for (String reviews : arr) {
			if (wordValues.containsKey(reviews)) {
				totalScore += wordValues.get(reviews);
				wordCount++;
			}
			
		}
		return totalScore / wordCount;
	}

	/**
	 * Predict movie reviews by first learning about words in review. (This does not
	 * need to be modified).
	 */
	public static void main(String[] args) throws FileNotFoundException {

		// First write and test your program with the small set of reviews. Then,
		// learn with the big file and try different tests.
//		String learningFilename = "src/a8/MovieReviews.txt";
		String learningFilename = "src/a8/smallReviews.txt";
		// Make an instance of the predictor based on the filename.
		MovieReviewPredictor predictor = new MovieReviewPredictor(learningFilename);
		System.out.println(predictor.wordValues);
		
		// Test the predictor.
		String testFilename = "src/a8/smallReviews.txt";
		// Read the file of test reviews.
		ArrayList<String> lines = linesFromFile(testFilename);

		// Loop over each review. Compare the predicted score with the real score.
		for (String line : lines) {
			String[] words = line.split(" ");
			String noScoreLine = "";
			for (int wordIndex = 1; wordIndex < words.length; wordIndex++)
				noScoreLine += words[wordIndex] + " ";
			String prediction = String.format("%.1f", predictor.predictScore(noScoreLine));
			System.out.print("Predicted: " + prediction + " Actual: ");
			System.out.println(line);
			/*
			 * I think like a lot of the assignments that we have been doing
			 * is that it could be improved by a whole lot. I think as a start
			 * it is good, because it gives a general basis of an average rating
			 * score, so I still think it could be usable.
			 */
		}

	}
}
