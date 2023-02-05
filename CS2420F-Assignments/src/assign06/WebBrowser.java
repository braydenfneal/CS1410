package assign06;

import java.net.URL;
import java.util.NoSuchElementException;

public class WebBrowser {
	private ArrayStack<URL> back;
	private ArrayStack<URL> forward;
	private URL current;
	
	/**
	 * This constructor creates a new web browser with no 
	 * previously-visited webpages and no webpages to visit next.
	 */
	public WebBrowser() {
		back = new ArrayStack<URL>();
		forward = new ArrayStack<URL>();
		URL current = null;
	}
	/**
	 * This constructor creates a new web browser with a 
	 * preloaded history of visited webpages, given as a list of 
	 * URL (Links to an external site.) objects.  The first webpage 
	 * in the list is the "current" page visited, and the remaining 
	 * webpages are ordered from most recently visited to least 
	 * recently visited.
	 * @param history
	 */
	public WebBrowser(SinglyLinkedList<URL> history) {
		back = new ArrayStack<URL>();
		forward = new ArrayStack<URL>();
		for (int i = history.size()- 1; i >= 0; i--) {
			back.push(history.deleteFirst());
		}
	}
	/**
	 * This method simulates visiting a webpage, given as a URL.  
	 * Note that calling this method should clear the forward stack, 
	 * since there is no URL to visit next. This is just like a forward 
	 * button (right facing arrow) on a real web browser. When you visit 
	 * a link, the right-arrow is cleared.
	 * @param webpage
	 */
	public void visit(URL webpage) {
		forward.clear();
		back.push(webpage);
		current = webpage;
	}
	/**
	 * This method simulates using the back button, 
	 * returning the URL visited.  NoSuchElementException 
	 * (Links to an external site.) is thrown if there is no 
	 * previously-visited URL.
	 * @return the URL visited back
	 * @throws NoSuchElementException
	 */
	public URL back() throws NoSuchElementException{
		if (back.peek() == null) {
			throw new NoSuchElementException();
		}
		forward.push(current);
		current = back.peek();
		back.pop();
		return current;
	}
	/**
	 * This method simulates using the forward button, returning 
	 * the URL visited.  NoSuchElementException is thrown if there 
	 * is no URL to visit next.
	 * @return the URL visited forward
	 * @throws NoSuchElementException
	 */
	public URL forward() throws NoSuchElementException{
		if (forward.peek() == null) {
			throw new NoSuchElementException();
		}
		back.push(current);
		current = forward.peek();
		forward.pop();
		return current;
	}
	/**
	 * This method generates a history of URLs visited, 
	 * as a list of URL objects ordered from most recently 
	 * visited to least recently visited (including the 
	 * "current" page visited), without altering subsequent 
	 * behavior of this web browser. "Forward" links are not included. 
	 * The behavior of the method must be O(N), where N is the number 
	 * of URLs.
	 * @return the list of URL's visited
	 */
	public SinglyLinkedList<URL> history(){
		SinglyLinkedList<URL> temp = new SinglyLinkedList<URL>();
		SinglyLinkedList<URL> list = new SinglyLinkedList<URL>();
		URL url;
		for (int i = 0; i < back.size(); i++) {
			url = back.pop();
			temp.insert(back.size(), url);
			list.insert(i, url);
		}
		System.out.println(back.size());
		for (int i = 0; i < back.size(); i++) {
			back.push(temp.get(i));
		}
		return list;
	}
}
