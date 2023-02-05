package lab11;

public class Dog extends Animal{
	private boolean isGoodDog;
	
	public Dog(int age, boolean isGoodDog) {
		super(age);
		this.isGoodDog = isGoodDog;
	}
	
	@Override
	public String toString() {
		return super.toString() + " is good Dog? " + isGoodDog;
    }
	@Override
	public void speak() {
		if (isGoodDog) {
			System.out.println("ruff ruff");
		}
		else {
			System.out.println("RUFF RUFF");
		}
	}
	
	public static void main(String[] args) {
		Dog spot = new Dog(7, true);
		System.out.println(spot.toString());
		spot.speak();
	}

}
