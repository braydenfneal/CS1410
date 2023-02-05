package assignmentOne;

/**
 * Aiight so what we got here is what its going to cost yah to go a ways away.
 * あなたはペニスを吸う
 * @author braydenneal
 *
 */
public class DrivingCostCalculator {

	/**
	 * This bad boy has the logic that tells what the cost is going to be bruh
	 * 
	 * @param milesToDrive a double
	 * @param milesPerGallon a double
	 * @param dollarsPerGallon a double
	 * @return the trips exact cost(Most likely a decimal)
	 */
	public static double calculateTripCost(double milesToDrive, double milesPerGallon, double dollarsPerGallon) {
		double cost = milesToDrive * dollarsPerGallon / milesPerGallon;
		return cost;
	}
	
	/**
	 * Here we got the total cost filtered in a readable number and then a print statement saying 
	 * the cost of the trip in a way thats epic.
	 * 
	 * @param carModel a String
	 * @param tripDistance a double
	 * @param tripCost a double
	 */
	public static void reportDrivingCost(String carModel, double tripDistance, double tripCost) {
		String formattedNumber = String.format("%.2f", tripCost);
		System.out.println("For a " + carModel + ", a trip of " + tripDistance + " miles would cost $" + formattedNumber + ".");
	}
	
	public static void main(String[] args) {
		String car1 = "Infiniti";
		String car2 = "Denali";
		String car3 = "Subaru Forester";
		String car4 = "Chair";
		
		int mpg1 = 30;
		int mpg2 = 20;
		int mpg3 = 10;
		int mpg4 = 0;
		
		double dollars = 3.14;
		double dollars1 = 2.0;
		double dollars2 = 0.0;
		
		double miles = 50.5;
		double miles1 = 100.0;
		double miles2 = 0.0;
		
		
		reportDrivingCost(car1, miles, calculateTripCost(miles, mpg1, dollars));
		reportDrivingCost(car2, miles, calculateTripCost(miles, mpg2, dollars));
		reportDrivingCost(car3, miles1, calculateTripCost(miles1, mpg3, dollars1));
		reportDrivingCost(car4, miles2, calculateTripCost(miles2, mpg4, dollars2));
	}

}

