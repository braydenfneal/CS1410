package lab9;

public class Fraction {
	// instance variables
	private int numerator;
	private int denominator;
	
	// Construct with a numerator and denominator
	public Fraction(int num, int den) {
		numerator = num;
		denominator = den;
	}

	public Fraction multiply(Fraction otherFraction) {
		int newNumerator = numerator * otherFraction.numerator;
		int newDenominator = denominator * otherFraction.denominator;
		
		Fraction result = new Fraction(newNumerator, newDenominator);
		return result;
	}
	
    // Provide a way to print it
    public String toString() {
        return numerator + "/" + denominator;
    }
    
    public void scale(int scaleFactor){
    	numerator *= scaleFactor;
    }
    
    public void Fraction scaleCopy(int scaleFactor){
    	numerator *= scaleFactor;
    	return this;
    }
	
	public static void main(String[] args) {
		// Test Fraction capabilities
		Fraction num = new Fraction(1,2);
		Fraction num2 = new Fraction(1,4);
        System.out.println(num);
        
		
		Fraction mult = num.multiply(num2);
        System.out.println(mult);
    }

}
