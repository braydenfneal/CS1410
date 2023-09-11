package a10;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Allows the user to chose a move (rock, paper or scissors).
 * 
 * Whenever a move is chosen, this panel notifies the main Battle
 * object, so that the rest of the round can be simulated based
 * on the chosen move.
 */
@SuppressWarnings("serial")
public class HumanMovePanel extends JPanel implements ActionListener {
    /**
     * Pointer to the battle class that contains this panel, which
     * can be used to notify the battle class when the user plays an
     * action.
     */
    private Battle battle;
    
    JButton rock;
    JButton paper;
    JButton scissors;
    
    
    public HumanMovePanel(Battle battle) {
        // TODO: Implement this method and the rest of this class.
    	super();
        this.battle = battle;
        
        rock = new JButton("ROCK");
        paper = new JButton("PAPER");
        scissors = new JButton("SCISSORS");
        
        GridLayout grid = new GridLayout(1, 3, 10, 10);
		setLayout(grid);
		
		add(rock);
		add(paper);
		add(scissors);
        
        rock.addActionListener(this);
        paper.addActionListener(this);
        scissors.addActionListener(this);

    }
    
    public static void main(String[] args) {
        JFrame testFrame = new JFrame("test results");
        Battle battle = new Battle();
        
        // Code similar to the following can be used to test
        // this panel on its own. You can create a panel
        // and call methods on it without worrying
        // how the other panels interact with it.
        HumanMovePanel testPanel = new HumanMovePanel(battle);
        // Once this panel is shown, you should be able to click
        // on stuff and see results if you add println statements
        // that run on click actions
        testFrame.setContentPane(testPanel);
        testFrame.pack();
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == paper) {
			battle.processTurn(RPS.PAPER);
		}
		if (e.getSource() == rock) {
			battle.processTurn(RPS.ROCK);
		}
		if (e.getSource() == scissors) {
			battle.processTurn(RPS.SCISSORS);
		}
	}
}