package lab11;

public class Tiger extends Cat {

	public Tiger(int age) {
		super(age);
	}
	
	@Override
	public void speak() {
		if(getAge() <= 3) {
			super.speak();
		}
		else {
			System.out.println("ROAR!");
		}
	}
	public static void main(String[] args) {
		Tiger simba = new Tiger(15);
		simba.speak();
	}

}
