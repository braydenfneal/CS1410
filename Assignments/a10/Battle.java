package a10;

import java.awt.GridLayout;

import javax.swing.*;

/**
 * This is the main class to create a GUI for playing Rock Paper Scissors (RPS).
 * 
 * This GUI has 3 main functionalities: 1. A panel for toggling the type of
 * computer opponent. The computer opponent is the person who the user of this
 * GUI will be playing against, and different opponents may use different
 * strategies for playing their moves. 2. A panel for displaying the results of
 * each round of RPS. This panel displays the move that the human made, the move
 * that the computer made, and this round's winner. 3. A panel allowing the
 * human user to choose a RPS move. When this move is chosen, the currently
 * selected computer opponent makes its move, and then the results are updated
 * accordingly.
 */
@SuppressWarnings("serial")
public class Battle extends JFrame {
	private OpponentPanel opponentPanel = new OpponentPanel();
	private HumanMovePanel humanMovePanel = new HumanMovePanel(this);
	private ResultsPanel resultsPanel = new ResultsPanel();

	public Battle() {
		super("Battle");
		// TODO: Create & add extra components for the other
		// functionalities of this panel.
		add(humanMovePanel);
		add(resultsPanel);
		add(opponentPanel);
		resultsPanel.updateResults(null, null);

		setLayout(new GridLayout(1, 3, 10, 10));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pack();
	}

	/**
	 * Coordinates between the panels in this object whenever the user takes their
	 * turn. Makes a new move in the RPS game.
	 */
	public void processTurn(RPS humanChoice) {
		// TODO: Implement this method. This should get a computer
		// response and update the results display.

		Opponent opponent = opponentPanel.getOpponent();
		if (humanChoice == RPS.ROCK) {
			resultsPanel.updateResults(RPS.ROCK, opponent.getResponse(humanChoice));

		}
		if (humanChoice == RPS.PAPER) {
			resultsPanel.updateResults(RPS.PAPER, opponent.getResponse(humanChoice));

		}
		if (humanChoice == RPS.SCISSORS) {
			resultsPanel.updateResults(RPS.SCISSORS, opponent.getResponse(humanChoice));

		}
	}

	public static void main(String[] args) {
		Battle b = new Battle();
		b.setVisible(true);
	}
}