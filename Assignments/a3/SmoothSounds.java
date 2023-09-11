package a3;

import java.util.Arrays;
import java.util.Scanner;

public class SmoothSounds {
	
	public static double[] loadSound() {
		double[] samples = StdAudio.read("asyouwish.wav");
		return samples;
	}
	
	public static void playSound(double[] sound) {
		StdAudio.play(sound);
		playSound(loadSound());
	} 

	public static int getIntFromUser() {
		Scanner input = new Scanner(System.in);
		int userInt = input.nextInt();
		return userInt;
		
	}
	
	public static double[] repeatedlySmooth(double[] array, int n) {
		double[] smoothedArray = array;
		System.out.println(Arrays.toString(smoothedArray));
			for (int i = 0; i < n; i++) {
				smoothedArray = Loops.smoothArray(smoothedArray);
			}
			
		return smoothedArray;
	}
	public static void main(String[] args) {
		double[] array = { 0.0, 0.2, 0.7, 0.2 };
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a non-negative integer and press enter:");
		int userInt = input.nextInt();
		input.close();
		System.out.println("Recieved int: " + userInt);
		System.out.println(Arrays.toString(repeatedlySmooth(array, userInt)));
		loadSound();
		repeatedlySmooth(array, userInt);
		
	}

	}
	

