package lec29;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LayoutPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	JButton sayHi;
	JButton quit;
	JLabel output;
	
	public LayoutPanel() {
		super();
		
		sayHi = new JButton("Say Hi");
		quit = new JButton("Quit");
		output = new JLabel("waiting");
		
		GridLayout grid = new GridLayout(1, 3, 10, 10);
		setLayout(grid);
		
		add(sayHi);
		add(output);
		add(quit);
		
		
		sayHi.addActionListener(this);
		quit.addActionListener(this);
	}
	public static void main(String[] args) {
		JFrame app = new JFrame("Layout Test");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		LayoutPanel panel = new LayoutPanel();
		app.setContentPane(panel);
		
		app.pack();
		app.setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sayHi) {
			output.setText("Hi!");
		}
		if (e.getSource() == quit) {
			System.exit(0);
		}
		
	}

}
