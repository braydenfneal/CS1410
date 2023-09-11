package a5;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class CompleterTest {

	@Test
	public void readCitiesFileTestCities() throws FileNotFoundException {
		String[] citiesTest = Completer.readCitiesFile("src/a5/cities.txt");
		assertEquals("shanghai, china", citiesTest[0]);
		assertEquals("melbourne, victoria, australia", citiesTest[50]);
	}
	
	@Test
	public void readCitiesFileTestSample() throws FileNotFoundException
	{
		String[] sampleTest = Completer.readCitiesFile("src/a5/sample.txt");
		assertEquals("pineapple", sampleTest[0]);
		assertEquals("banana", sampleTest[3]);
	}
	
	@Test
	public void readCitiesFileTestSampleCityCompare() throws FileNotFoundException {
		String[] sampleTest = Completer.readCitiesFile("src/a5/sample.txt");
		String[] citiesTest = Completer.readCitiesFile("src/a5/cities.txt");
		assertNotEquals(citiesTest[0], sampleTest[0]);
	}

	@Test
	public void binarySearchForKeyInSampletxt() throws FileNotFoundException {
		String[] sampleTest = Completer.readCitiesFile("src/a5/sample.txt");
		int key = Completer.binarySearchForKey(sampleTest, "banana");
		int key1 = Completer.binarySearchForKey(sampleTest, "apple");
		assertEquals(3, key);
		assertEquals(2, key1);
	}
	
	}