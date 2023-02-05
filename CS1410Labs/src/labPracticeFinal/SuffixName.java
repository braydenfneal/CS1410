package labPracticeFinal;

public class SuffixName extends FullName {

	private String suffix;
	
	public SuffixName(String f, String l, String s) {
		super(f, l);
	}
	@Override
	public String toString() {
        return getFirst() + " " + getLast() + " " + suffix;
    }

}
	public static void main(String[] args) {
		SuffixName Suffix = new SuffixName("Brayden","Neal", "MD");
		System.out.println(Suffix);
}
}
