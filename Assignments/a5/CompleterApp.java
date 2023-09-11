package a5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

/**
 * This program acts as a text completion program for cities. This
 * class creates a non-blocking text entry JLabel.
 * 
 * @author Prof. David E. Johnson
 *
 */
public class CompleterApp {

	private JFrame frame;

	/**
	 * Make a window with non-blocking typing. Reads in a file, then
	 * tries to match typed letters with the elements of the file and
	 * displays any match.
	 * 
	 * @param filePathAndName the location of the cities file.
	 * @param searchStyle "binary" or "sequential" to use that style search.
	 * @param makeBig if true, makes the array 2000x bigger.
	 */
	public CompleterApp(String filePathAndName, String searchStyle, boolean makeBig) {
		// No code here should be changed for the assignment!
		String[] cities = null;
		try {
			cities = Completer.readCitiesFile(filePathAndName);
		} catch (FileNotFoundException e) {
			System.out.println("The file " + filePathAndName + " was not found.");
			System.exit(-1);
		}

		// Binary search depends on a sorted array.
		Arrays.sort(cities);
		if (makeBig) {
			String[] bigCities = new String[cities.length*2000];
			int bigIndex = 0;
			for (String city : cities) {
				for (int repeat = 0; repeat < 2000; repeat++) {
					bigCities[bigIndex] = city;
					bigIndex++;
				}
			}
			cities = bigCities;
		}
		// final needed for the keyPressListener
		final String[] sortedText = cities;
		System.out.println("Searching using " + searchStyle);
		System.out.println("Cities array length: " + cities.length);
		// Build up the application window
		frame = new JFrame();
		JPanel main = new JPanel();
		main.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		JLabel textBox = new JLabel("");
		textBox.setForeground(Color.BLACK);
		JLabel suggestion = new JLabel("");
		suggestion.setForeground(Color.GRAY);
		main.add(textBox);
		main.add(suggestion);
		frame.add(main);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 100);

		// Add a key press listener that gets characters one at a time.
		frame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				String typed = textBox.getText();
				// Ignore shift. Can add in more modifiers here.
				if (e.getKeyCode() == KeyEvent.VK_SHIFT) {

				} else {
					// Allow back space to delete characters.
					if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
						if (typed.length() > 0) {
							typed = typed.substring(0, typed.length() - 1);
						}
					} else { // This is the normal case of adding a letter to the text.
						char letter = e.getKeyChar();
						typed = typed + letter;
					}
					
					textBox.setText(typed);
					if (typed.length() > 0) {
						int index = -1;

						// Try the search method based on the style sent in.
							if (searchStyle.equals("binary"))
								index = Completer.binarySearchForKey(sortedText, typed);
							else
								index = Completer.sequentialSearchForKey(sortedText, typed);
						String suggestedText;
						if (index == -1) {
							suggestedText = typed + " No match!";
						} else {
							suggestedText = sortedText[index];
						}
						// Remove the typed text since that is already displayed.
						suggestedText = suggestedText.substring(typed.length());
						suggestion.setText(suggestedText);
					} else {
						suggestion.setText("");
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

	}
	
	public void start() {
		frame.setVisible(true);		
	}
}
