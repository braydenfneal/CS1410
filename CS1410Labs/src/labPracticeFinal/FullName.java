package labPracticeFinal;

public class FullName {
    private String first;
    private String last;
    public FullName(String f, String l) {
        setFirst(f);
        setLast(l);
    }

	public String toString() {
        return getFirst() + " " + getLast();
    }

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
}
