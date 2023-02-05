package lab09;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		
		return o2.compareTo(o1);
	}
}
