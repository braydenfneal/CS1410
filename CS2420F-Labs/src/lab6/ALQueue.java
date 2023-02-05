package lab6;

import java.util.ArrayList;
import java.util.LinkedList;

public class ALQueue <T> implements Queue<T> {
ArrayList<T> al;
	//backing structure is base for your data structure
	public ALQueue()
	{
		al = new ArrayList<T>();
	}
	
	@Override
	public void offer(T element) {
		al.add(element);
		
	}

	@Override
	public T poll() {
	return al.remove(0);
	}

	@Override
	public T peek() {
		return al.get(0);
	}

}
