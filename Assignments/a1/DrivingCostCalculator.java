package a1;

// "CS1410 Assignment 1: Driving Cost Calculator by Brayden Neal"
public class DrivingCostCalculator {
	
	// This calculates and returns the cost of the trip given the variables.
	public static double calculateTripCost(double milesToDrive, double milesPerGallon, double dollarsPerGallon) {
		double cost = (milesToDrive * dollarsPerGallon);
		double finalCost = (cost / milesPerGallon);
		return finalCost;
	}

	// This sets up the values to calculate and displays results.
	public static void main(String[] args) {
		String car = "Infiniti";
		String car2 = "Ford Explorer";
		String car3 = "Chevy Silverado";
		String car4 = "Subaru";
		double mpg = 25.0;
		double mpg2 = 20.0;
		double mpg3 = 20.0;
		double mpg4 = 18.0;
		double gas = 2.29;
		double gas2 = 3.12;
		double miles = 1623;
		double miles2 = 100;
		double totalCost = calculateTripCost(miles, mpg, gas);
		double totalCost2 = calculateTripCost(miles, mpg2, gas);
		double totalCost3 = calculateTripCost(miles2, mpg3, gas2);
		double totalCost4 = calculateTripCost(miles2, mpg4, gas2);
		reportDrivingCost(car, miles, totalCost);
		reportDrivingCost(car2, miles, totalCost2);
		reportDrivingCost(car3, miles2, totalCost3);
		reportDrivingCost(car4, miles2, totalCost4);
	}
	
	// This formats the results, explaining the type of car and explaining the cost.
	public static void reportDrivingCost(String carModel, double tripDistance, double tripCost) {
		String formattedNumber = String.format("%.2f", tripCost);
		System.out.println(
				"For a " + carModel + ", a trip of " + tripDistance + " miles would cost $" + formattedNumber + ".");
	}
}