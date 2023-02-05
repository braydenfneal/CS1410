package lab12;

import javax.swing.*;

public class SimpleApp {
	public static void main(String[] args) {
		
		// Get a new application window
		JFrame app = new JFrame("Simple App");
		// Let the app quit when the window is closed
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create a new button
		JButton sayHi = new JButton("Say Hi!");	
		// Add the button to the content pane of the app
		app.add(sayHi);
		
		// Size the frame to hold the button
		app.pack();
		// Make the application show up on screen
		app.setVisible(true);
	}

}
