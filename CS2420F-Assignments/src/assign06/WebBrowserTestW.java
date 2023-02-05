package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import assign06.SinglyLinkedList.Node;

	class WebBrowserTestW
{
	
//	private Node head;
	private Stack<URL> backButton;
	private Stack<URL> forwardButton;
	private String aString = "http://abc.com/";
	private String bString = "http://bcd.com/";
	private String cString = "http://cde.com/";
	private String dString = "http://def.com/";
	private String eString = "http://efg.com/";
	private SinglyLinkedList<URL> historyA;
	WebBrowser goodle;
	private URL aURL;
	private URL bURL;
	private URL cURL;
	private URL dURL;
	private URL eURL;
	
	
	@BeforeEach
	void setUp()
	{
		historyA = new SinglyLinkedList<URL>();
		try {
		aURL = new URL(aString);
		bURL = new URL(bString);
		cURL = new URL(cString);
		dURL = new URL(dString);
		eURL = new URL(eString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		historyA.insertFirst(aURL);
		historyA.insertFirst(bURL);
		historyA.insertFirst(cURL);
		historyA.insertFirst(dURL);
		historyA.insertFirst(eURL);
		//WebBrowser goodle = new WebBrowser(historyA);

	}
	
	@Test
	void correctOrderOfURLs()
	{
		int elementCount = historyA.size();
		assertEquals("http://efg.com/", historyA.getFirst().toString());
	}

	
	
	
}
