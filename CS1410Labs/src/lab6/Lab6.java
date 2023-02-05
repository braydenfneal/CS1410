package lab6;

import java.util.Arrays;

public class Lab6 {

	public static int raiseNumberToAPower (int num1, int num2) {
		if(num2 == 0)
			return 1;
		
		int rnum = num1;
		for (int i = 1;i < num2; i++ ) {
			//result *= number;
			//4*4*4
			rnum *= num1;
		}
		
		return rnum;
	}
	
	public static double[] addToArray (double[] array1, double[] array2) {
		for(int i = 0; i< array1.length; i++) {
			array1[i] += array2[i];
		}
		
		return array1;
		
	}
	
	public static double[] skipMultiples(int[] values) {
		for (int value:values) {
			if (value%3 != 0 && value%5 != 0) {
				
		}
	}
	public static void main(String[] args) {
	double[] arr1 = {1, 2, 3};
	double[] arr2 = {5, 10, 15};
	System.out.println(Arrays.toString((addToArray(arr1, arr2))));
	
	System.out.println(raiseNumberToAPower(10, 3));
	

	}

}
