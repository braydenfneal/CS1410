package lab14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A top-level panel for playing a game similar to Plants Vs Zombies.
 * 
 * This panel is primarily responsible for coordinating the various
 * aspects of the game, including:
 * - Running the game step-by-step using a timer
 * - Creating and displaying other components that make up the game
 * - Creating new plants and/or zombies, when necessary
 * - Checking for the end of the game
 * 
 * (Not all of the above behavior is provided in the starter code)
 * 
 * @author Travis Martin and David Johnson
 */
@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener {
	private static final int NUM_ROWS = 5;
	private static final int NUM_COLS = 7;
	private static final int GRID_BUFFER_PIXELS = 20;
	private static final int CELL_SIZE = 75;
	private static final int STEP_TIME= 30;
	
	/**
	 * This panel is responsible for displaying plants
	 * and zombies, and for managing their interactions.
	 */
	private ActorDisplay actorDisplay = new ActorDisplay(
	        NUM_COLS * CELL_SIZE + GRID_BUFFER_PIXELS * 2,
	        NUM_ROWS * CELL_SIZE + GRID_BUFFER_PIXELS * 2);

	private Game() {
	    add(actorDisplay);
	    
	    // This layout causes all elements to be stacked vertically
	    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	    
		// The timer calls the actionPerformed method every STEP_TIME milliseconds
		Timer timer = new Timer(STEP_TIME, this);
		timer.start();
		
		// This adds a plant to every row
		// TODO: replace this with your new functionality
		for (int i = 0; i < NUM_ROWS; i++) {
		    addPlant(0, i);
		}
	}

	/**
	 * Executes game logic every time the timer ticks.
	 */
    @Override
    public void actionPerformed(ActionEvent e) {
        actorDisplay.step();
        Random rand = new Random();
        if (rand.nextInt(100) > 98) {
            addZombie(NUM_COLS - 1, rand.nextInt(NUM_ROWS));
        }
    }
	
    /**
     * Adds a plant to the official game grid & display panel.
     */
	private void addPlant(int col, int row) {
	    // The magic numbers below define various hardcoded plant properties
        actorDisplay.addActor(new Plant(
                gridToPixel(col), gridToPixel(row), CELL_SIZE * 4 / 5, 
                "src/lab14/Animal-Icons/frog-icon.png", 150, 5, 1));
	}
	
    /**
     * Adds a zombie to the official game grid & display panel.
     */
	private void addZombie(int col, int row) {
	    // The magic numbers below define various hardcoded zombie properties
        actorDisplay.addActor(new Zombie(
                gridToPixel(col), gridToPixel(row), CELL_SIZE * 4 / 5, 
				"src/lab14/Animal-Icons/chihuahua-icon.png",
				100, 50, -2, 10));
	}
	
	/**
	 * Converts a row or column to its exact pixel location in the grid.
	 */
	private int gridToPixel(int rowOrCol) {
	    return rowOrCol * CELL_SIZE + GRID_BUFFER_PIXELS;
	}
	
	/**
	 * The inverse of gridToPixel
	 */
	private int pixelToGrid(int xOrY) {
	    return (xOrY - GRID_BUFFER_PIXELS) / CELL_SIZE;
	}
	
	/**
	 * Create, start, and run the game.
	 */
	public static void main(String[] args) {
        JFrame app = new JFrame("Plant and Zombie Test");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.add(new Game());
        app.pack();
        app.setVisible(true);
	}
}