package labPracticeFinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class CounterPanel extends JPanel implements ActionListener {
    private int counter = 0;
    /** Adds one to counter when it is clicked. */
    private JButton increment = new JButton("increment counter");
    /** Resets counter to 0 when it is clicked. */
    private JButton reset = new JButton("reset counter");

    public CounterPanel() {
        // SETUP GUI & BUTTONS AS NORMAL
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == increment) {
			counter = counter + 1;
		}
		if (e.getSource() == reset) {
			counter = 0;
		}
	}
}
