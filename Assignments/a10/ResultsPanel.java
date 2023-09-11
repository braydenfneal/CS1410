package a10;

import java.awt.GridLayout;

import javax.swing.*;

/**
 * Displays the results of a the current round of RPS.
 */
@SuppressWarnings("serial")
public class ResultsPanel extends JPanel {
	JLabel userResults = new JLabel("User player move: ");
	JLabel computerResults = new JLabel("Computer player move: ");
	JLabel winnerResults = new JLabel("Winner: ");

	/**
	 * Updates this panel to display the two provided moves plus the winner when the
	 * provided moves are played against each other in a game of Rock Paper
	 * Scissors.
	 * 
	 * @param human    the move of the human player
	 * @param computer the move of the computer player
	 */
	public void updateResults(RPS human, RPS computer) {
		// TODO: Implement this method and the rest of the class
		RPS rock = RPS.ROCK;
		RPS paper = RPS.PAPER;
		RPS scissors = RPS.SCISSORS;

		if (human == rock && computer == scissors) {
			winnerResults.setText("Winner: Human wins!");
		} else if (computer == rock && human == scissors) {
			winnerResults.setText("Winner: Computer :(");
		} else if (human == paper && computer == rock) {
			winnerResults.setText("Winner: Human wins!");
		} else if (computer == paper && human == rock) {
			winnerResults.setText("Winner: Computer :(");
		} else if (human == scissors && computer == paper) {
			winnerResults.setText("Winner: Human wins!");
		} else if (computer == scissors && human == paper) {
			winnerResults.setText("Winner: Computer :(");
		} else {
			winnerResults.setText("Winner: It was a tie");
		}

		userResults.setText("User player move: " + human);
		computerResults.setText("Computer player move: " + computer);

		GridLayout grid = new GridLayout(10, 30, 10, 10);
		setLayout(grid);

		add(userResults);
		add(computerResults);
		add(winnerResults);
	}

	public static void main(String[] args) {
		JFrame testFrame = new JFrame("test results");

		// Code similar to the following can be used to test
		// this panel on its own. You can create a panel
		// and call methods on it without worrying
		// how the other panels interact with it.
		ResultsPanel testPanel = new ResultsPanel();
		testPanel.updateResults(RPS.ROCK, RPS.ROCK);

		testFrame.setContentPane(testPanel);

		testFrame.pack();
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setVisible(true);
	}
}
