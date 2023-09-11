package a11;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
* This panel contains components relating to choosing a plant Actor
* or a special plant actor in the game
* 
* This class contains one button for each type of plant, and when a
* button is clicked then it lets you place the plant wherever
* on the game you want with a click.
*/
public class ChoosePlantPanel extends JPanel implements ActionListener {

	private JRadioButton plant = new JRadioButton("A CS MAJOR");
	private JRadioButton specialPlant = new JRadioButton("No alchohol allowed!");
	private static boolean notSpecial = true;
	
	
	public ChoosePlantPanel() {
		
		// Add this as a listener, so it can receive events
		// when either button is clicked.
		plant.addActionListener(this);
		specialPlant.addActionListener(this);
		
		// Add the two buttons to this panel, one above the other.
		add(plant);
		add(specialPlant);
		setLayout(new GridLayout(2, 1));
		
		// A ButtonGroup ensures that only one button is selected
		// at a time.
		ButtonGroup group = new ButtonGroup();
		plant.setSelected(true);
		group.add(plant);
		group.add(specialPlant);
		
		
	}
	/**
	 * Returns the currently selected plant that the human player should place 
	 * onto the game.
	 */
	public static boolean getPlant() {
		return notSpecial;
	}
	
	/**
	 * Handles events from the JRadioButtons in order to switch the currently
	 * selected plant as appropriate.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == plant) {
			notSpecial = true;
		}
		if (e.getSource() == specialPlant) {
			notSpecial = false;
		}
	}

}
