package l31;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class FlipBook extends JPanel implements ActionListener {
	ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
	int currentImageIndex = 0;
	
	public FlipBook(ArrayList<String> paths) {
		try {
			for (String path : paths) {
				BufferedImage image = ImageIO.read(new File(path));
				images.add(image);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		setPreferredSize(new Dimension(images.get(0).getWidth(), images.get(0).getHeight()));
	}
	 
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(images.get(currentImageIndex), 0, 0, null);
		currentImageIndex = (currentImageIndex + 1) % images.size();
		System.out.println("Rapainted");
	}
	//load images into our program
	
	//display images on screen
	
	//Change between different images
	
	//display frame containing the panel
	public static void main (String[] args) {
		JFrame frame = new JFrame("Flipbook");
		ArrayList<String> paths = new ArrayList<String>();
		for (int i = 0; i < 8; i++) {
			paths.add("src/l31/flip" + i + ".jpg");
		}
		FlipBook panel = new FlipBook(paths);
		Timer timer = new Timer(100, panel);
		timer.start();
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

}
