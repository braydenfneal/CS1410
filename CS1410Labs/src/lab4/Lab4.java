package lab4;

import java.util.Random;

public class Lab4 {
	public static double[] addNoise(double[] samples, double noiseAmount) {
		double[] noisySamples = new double[samples.length];
		Random randomGenerator = new Random();
		

		for (int index = 0; index < noisySamples.length - 1; index++) {
			noisySamples[index] = samples[index] + randomGenerator.nextDouble() * noiseAmount;
		}
		
		return noisySamples;
	}
	
	public static void playSounds(double[][] sounds) {
		for(double[] arr : sounds) {
			StdAudio.play(arr);
		}
		StdAudio.close();
	}


	public static void main(String[] args) {
		double[] samples = StdAudio.read("asyouwish.wav");
//		StdAudio.play(samples);		
//		StdAudio.close();
		
		System.out.println(samples.length);
		
		Random randomGenerator = new Random();
		for (int count = 0; count < 10; count++)
		    System.out.println(randomGenerator.nextDouble());
		double [] noisy = addNoise(samples, 0.2);
		StdAudio.play(noisy);
		StdAudio.close();
		
		double[][] sounds = new double[10][];
		for (int index = 0; index < sounds.length; index++) {
			sounds[index] = addNoise(samples, 0.2 * index);
		}
		
		
	}
}
