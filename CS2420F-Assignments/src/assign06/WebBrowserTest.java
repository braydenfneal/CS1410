package assign06;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class WebBrowserTest
{
	
	private String String1 = "http://abc.com/";
	private String String2 = "http://def.com/";
	private String String3 = "http://ghi.com/";
	private String String4 = "http://jkl.com/";
	private String String5 = "http://mno.com/";
	private SinglyLinkedList<URL> myHistory;
	private URL URL1;
	private URL URL2;
	private URL URL3;
	private URL URL4;
	private URL URL5;
	WebBrowser w;
	WebBrowser wb;
	WebBrowser empty;
	SinglyLinkedList<URL> list;
	@BeforeEach
	void setUp()
	{
		myHistory = new SinglyLinkedList<URL>();
		
		try {
			URL1 = new URL(String1);
			URL2 = new URL(String2);	
			URL3 = new URL(String3);
			URL4 = new URL(String4);
			URL5 = new URL(String5);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		myHistory.insert(0, URL1);
		myHistory.insert(1, URL2);
		myHistory.insert(2, URL3);
		myHistory.insert(3, URL4);
		myHistory.insert(4, URL5);
		wb = new WebBrowser(myHistory);
		empty = new WebBrowser();
		w = new WebBrowser();
		w.visit(URL1);
		w.visit(URL2);
		w.visit(URL3);
		w.visit(URL4);
		w.visit(URL5);
	}	
	@Test
	void practiceTest() {
		URL link = null;
		try {
			link = new URL("https://a");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		assertEquals("https://a", link.toString());
	}
	@Test
	void backTest() {
		assertEquals("http://mno.com/", w.back().toString());
		assertEquals("http://jkl.com/", w.back().toString());
		assertEquals("http://ghi.com/", w.back().toString());
		assertEquals("http://def.com/", w.back().toString());
		assertEquals("http://abc.com/", w.back().toString());
	}
	@Test
	void backEmptyTest() {
		assertThrows(NoSuchElementException.class, () -> { empty.back(); });	
	}
	@Test
	void forwardTest() {
		w.back();
		w.back();
		w.back();
		assertEquals("http://jkl.com/", w.forward().toString());
		assertEquals("http://mno.com/", w.forward().toString());
	}
	@Test
	void forwardEmptyTest() {
		assertThrows(NoSuchElementException.class, () -> { empty.forward(); });	
	}
}
