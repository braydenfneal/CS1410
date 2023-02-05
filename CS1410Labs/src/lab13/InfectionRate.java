package lab13;

import javax.swing.*;

/**
 * Displays toggles for managing the current infection rate.
 */
public class InfectionRate extends JPanel {
    private final static double BASE_RATE = 0.1;
    
    private JToggleButton rave = new JToggleButton("Throw giant rave");
    private JToggleButton virtualClasses = new JToggleButton("Move all classes online");
    private JToggleButton vaccine = new JToggleButton("Distribute an effective vaccine");
    
    public InfectionRate() {
        add(rave);
        add(virtualClasses);
        add(vaccine);
    }
    
    /**
     * Returns the infection rate based on the current selection of
     * toggle buttons. The base rate is 0.1.
     * 
     * - If rave is selected, add 0.1 to the base rate.
     * - If virtualClasses is selected, subtract 0.07 from the base rate.
     * - If vaccine is selected, subtract 0.1 from the base rate.
     */
    public double getInfectionRate() {
    	double infectionRate = BASE_RATE;
    	
    	if (rave.isSelected()) {
    		infectionRate += 0.1;
    	}
    	if (virtualClasses.isSelected()) {
    		infectionRate -= 0.07;
    	}
    	if (vaccine.isSelected());{
    		infectionRate -= 0.1;
    	}
    	return infectionRate;		
    }
    
    /**
     * Displays this panel, for testing purposes only.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("InfectionRate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new InfectionRate());
        frame.pack();
        frame.setVisible(true);
    }
}
