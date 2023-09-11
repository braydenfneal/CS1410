package a11;

import javax.swing.JLabel;
import javax.swing.JPanel;

//Displays a message if you lose the game
public class GameOverPanel extends JPanel {

	static JLabel gameOver = new JLabel("Good Luck!");

	public GameOverPanel() {
		add(gameOver);
	}

	static void updateStatus() {
		gameOver.setText("YOU LOSE");
	}
}
