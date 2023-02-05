package lab13;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Pandemic extends JPanel implements ActionListener{
	private int numInfected = 100;
	private String infectedLabel = "Total number currently infected: ";
	JLabel label = new JLabel(infectedLabel + numInfected);
	InfectionRate infectionRate = new InfectionRate();
	
	public Pandemic() {
		 
		 add(infectionRate);
		 add(label);
		 
		 setLayout(new GridLayout(2, 1));
		 Timer timer = new Timer(300, this);
		 timer.start();
		 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (numInfected >= 60000) {
			label.setText("You lose. The whole University is infected");
		}
		else  if (numInfected <= 0) {
			label.setText("You Win! No more Infections!");
		}
		
		else {
		numInfected += numInfected * infectionRate.getInfectionRate();
		label.setText(infectedLabel + numInfected + "Infection rate: " + infectionRate.getInfectionRate());
		}
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Pandemic");
		Pandemic pandemic = new Pandemic();
		frame.add(pandemic);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	}
