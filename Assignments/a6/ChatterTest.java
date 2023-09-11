package a6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ChatterTest {
	
	String test1 = "Hi, what would you like to talk about?";
	String test2 = "It was nice chatting with you!";
	String test3 = " ";
	Chatter test = new Chatter(test1, test2, test3);
	
	@Test
	public void loadLinesFromFile() {
		String[] phrasesTest = Chatter.loadLinesFromFile("src/a6/phrases.txt");
		assertEquals("it's there", phrasesTest[1]);
		assertEquals("follow me", phrasesTest[391]);
	}
	
	@Test
	public void sayHello() {
		String helloTest = test.sayHello();
		assertEquals("Hi, what would you like to talk about?", helloTest);
	}
	
	@Test
	public void sayGoodbye() {
		String goodbyeTest = test.sayGoodbye();
		assertEquals("It was nice chatting with you!", goodbyeTest);
	}
	
	@Test
	public void respondToPhrase() {
		String respondTest = "Brayden";
		String respondTest2 = "me";
		assertEquals("Please tell me more about Brayden", "Please tell me more about " + respondTest);
		assertEquals("would you ask him to come here?", test.respondToPhrase(respondTest2));
	}
}
