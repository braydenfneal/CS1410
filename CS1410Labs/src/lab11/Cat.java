package lab11;

public class Cat extends Animal {
	
	
	public Cat(int age) {
		super(age);
	}
	
	@Override
	public void speak() {
		System.out.println("meow");
	}
	
	public static void main(String[] args) {
	Cat whiskers = new Cat (3);
	whiskers.speak();
	}

}
