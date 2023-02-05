package lab11;

public class Animal {
	private int age;
    private int numLegs;
    
    public Animal(int age) {
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
    
    public void speak() {
        System.out.println("vague animal sounds");
    }
    
    @Override
    public String toString() {
        return age + " year old " + getClass().getSimpleName();
    }
    
	public static void main(String[] args) {
		Animal fish = new Animal(5);
	}

}
