package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class RandomPhraseGenerator2
{
	private File txt;
	private int numberOfLines;
	private HashMap<String, LinkedList<String>> allWords;
	private static Scanner sc;
	private static String templateSentence;
	private static StringBuilder template;
	
	RandomPhraseGenerator2(File txtFile, int number) throws FileNotFoundException
	{
		setTxt(txtFile);
		setNumberOfLines(number);
		allWords = new HashMap<String, LinkedList<String>>();
		String templateSentence;
		Scanner reader = new Scanner(txtFile);
		allWords = wordsToHashTable(fileToString(this.txt, reader));
	}

	private static String getNext()
	{
		return sc.next();
	}
	
	private static void printSentences(HashMap<String, LinkedList<String>> words, String templateSentenceWords, int numberOfSentences)
	{
		String printable = null;
		for(int i = 0; i < numberOfSentences; i ++)
		{
			printable = generateSentence(words, templateSentenceWords);
			System.out.println(printable);
		}
	}
	
	private static String findWord(HashMap<String, LinkedList<String>> words, String word)
	{
		LinkedList<String> temp = words.get(word);
		int index = (int) (Math.random()*(temp.size()));
		String enter = temp.get(index);
		String finished = "";
		String tempString = "";
		String newWord = "";
		for(int j = 0; j < enter.length(); j ++)
		{
			if(enter.charAt(j) == '<')
			{
			tempString += enter.charAt(j);
			if(enter.charAt(j) == '>')
			{
				tempString += enter.charAt(j);
				newWord = findWord(words, tempString);
			}
			}
			else
			{
				finished += enter.charAt(j);
			}
			finished += newWord;
			
		}
		
		return finished;
	}
	
	private static String generateSentence(HashMap<String, LinkedList<String>> words, String templateSentenceWords)
	{
		String returnSentence = "";
		String word = "";
		String[] stringArray = new String[10];
		for(int p = 0; p < stringArray.length; p ++)
		{
			stringArray[p] = "";
		}
		int indexB = 0;
		for(int i = 0; i < templateSentenceWords.length(); i ++)
		{
			int length = templateSentenceWords.length();
			if(templateSentenceWords.charAt(i) == '<')
			{
				
				char tmp = templateSentenceWords.charAt(i);
				stringArray[indexB] += tmp;
				
			}
			else if(templateSentenceWords.charAt(i) == '>')
				{
					if(templateSentenceWords.charAt(i+1) == '.')
					{
						char tmp = templateSentenceWords.charAt(i);
						stringArray[indexB] += tmp + '.';
						break;
					}
					else
						{
						char tmp = templateSentenceWords.charAt(i);
						stringArray[indexB] += tmp;
						indexB ++;
						}
				}
			else if(templateSentenceWords.charAt(i) != ' ')
			{
				char tmp = templateSentenceWords.charAt(i);
				stringArray[indexB] += tmp;
			}
				
		}
		int realLength = stringArray.length;
		for(int p = stringArray.length - 1; p > 0; p --)
		{
			if(stringArray[p] == "" || stringArray[p] == " ")
				realLength --;
		}
		String[] newStringArray = new String[realLength];
		for(int x = 0; x < newStringArray.length; x ++)
		{
			newStringArray[x] = stringArray[x];
		}

		for(int i1 = 0; i1 < newStringArray.length; i1 ++)
		{
			word = newStringArray[i1];
			LinkedList<String> temp;
			returnSentence += findWord(words, word);
//			if(word.charAt(0) == '<' && word.charAt(word.length() -1) != '.')
//			{
//				temp = words.get(word);
//				int index = (int) (Math.random()*(temp.size()));
//				String enter = temp.get(index);
//				String tempString = "";
//				String newWord = findWord(words, enter);
////				for(int k = 0; k < enter.length(); k ++)
////				{
////					tempString += enter.charAt(k);
////					if(enter.charAt(k) == '>')
////					{
////						newWord += findWord(words, tempString);
//////						for(int i = k + 1; i < enter.length(); i ++)
//////						{
//////							newWord += enter.charAt(i);
//////						}
////					}
////					else
////					{
////						newWord = enter;
////					}
////				}
//				
//				returnSentence += newWord + " ";
//				words.put(word, temp);
//			}
//			if(word.charAt(0) == '<' && word.charAt(word.length() -1) == '.')
//			{
//				String placeholder = word.substring(0, word.length() -1);
//				temp = words.get(placeholder);
//				int index = (int) (Math.random()*(temp.size()));
//				returnSentence += temp.get(index) + ".";
//				words.put(word, temp);
//			}
//			else
//				returnSentence += word + " ";
//		}
		
		
	}
				return returnSentence;

	}
	
	private static String generateTemplateSentence(String txt)
	{
		Scanner scan = new Scanner(txt);
		StringBuilder template = new StringBuilder();
		while(scan.hasNext())
		{
			String tmp = scan.next();
			if(tmp.equals("<start>"))
			{
				while(scan.hasNext())
				{
					String temp = scan.next();
					if(temp.equals("}"))
					{

						break;
					}
					else
					{
						templateSentence += temp + " ";
						template.append(temp);
						template.append(" ");
					}
				}
			}
		}
		scan.close();
		String templateString = template.toString();
		return templateString;
	}
	
	private static HashMap<String, LinkedList<String>> wordsToHashTable(String txt)
	{
		HashMap<String, LinkedList<String>> words = new HashMap<>();
		Scanner scan = new Scanner(txt);
		StringBuilder template = new StringBuilder();
		while(scan.hasNext())
		{
			String tmp = scan.next();
//			if(tmp.equals("<start>"))
//			{
//				while(scan.hasNext())
//				{
//					String temp = scan.next();
//					if(temp.equals("}"))
//					{
//
//						break;
//					}
//					else
//					{
//						templateSentence += temp + " ";
//						template.append(temp);
//					}
//					
//					
//				}
//			}
			if(tmp.equals("<start>"))
			{
				
			}
			else if(tmp.charAt(0) == '<')
			{
				LinkedList<String> tempList = new LinkedList<>();
				String keyword = tmp;
				while(scan.hasNext())
				{
					String temp = scan.next();
					if(temp.equals("}"))
					{
						words.put(tmp, tempList);
						break;
					}
					else
						tempList.add(temp);
				}
			}
			
		}
		
//		for(String word : txt.split("\\s+"))
//		{
//			if(word.charAt(0) == '<')
//			{
//				words.put(word);
//			}
//		}
//		
		scan.close();
		return words;
	}
	
	private static String fileToString(File txt, Scanner reader)
	{
		String allWords = "";
		
		try
		{
			reader = new Scanner(txt);
			sc = new Scanner(txt);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(reader.hasNext()) {
			String temp = reader.next();
			if(temp.equals("<start>"))
			{
				allWords += temp+ "\n";
				//allWords += reader.nextLine();
				while(reader.hasNext())
				{
					String tmp = reader.next();
					if(tmp.equals("}"))
					{
						allWords += "\n}\n";
						break;
					}
					else if(tmp.charAt(tmp.length()-1) == '.')
					{
						allWords += tmp;
						break;
					}
					else
						allWords += tmp + " ";
				}
			}
			else if(temp.equals("{"))
			{
				allWords += "\n";
				allWords += "{";
				allWords += "\n";
			}
			else if(temp.equals("}") && reader.hasNext() != true)
			{
				allWords += "\n}";
			}
			else if(temp.equals("}"))
			{
				allWords += "\n}\n";
			}
			else if(temp.charAt(0) =='<')
			{
				allWords += (temp + "\n");
				while(reader.hasNext())
				{
					String tempy = reader.next();
					if(tempy.equals("}"))
					{
						allWords += "\n}\n";
						break;
					}
					else
					{
						allWords += tempy + reader.nextLine() + "\n";
					}
				}
			}
			else
			{
			allWords += temp + " ";
			}
			
		}
		return allWords;
	}

	private static String readFile(File file, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
    }
	
//	private static int hashValue(String word)
//	{
//		int hash = 0;
//		for(int i = 0; i < word.length(); i ++)
//		{
//			hash += Character.getNumericValue(word.charAt(i));
//		}
//		return hash;
//	}
	

	public int getNumberOfLines()
	{
		return numberOfLines;
	}


	public void setNumberOfLines(int numberOfLines)
	{
		this.numberOfLines = numberOfLines;
	}


	public File getTxt()
	{
		return txt;
	}


	public void setTxt(File txt)
	{
		this.txt = txt;
	}
	
	public static void main(String args[])
	{
		File word = new File("src/comprehensive/txt.g");
		File word2 = new File("src/comprehensive/abc.g");
		Scanner reader = null;
		try
		{
			
			reader = new Scanner(word2);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String words = fileToString(word2, reader);
		HashMap<String, LinkedList<String>> wordMap = new HashMap<String, LinkedList<String>>();
		wordMap = wordsToHashTable(words);
		templateSentence = generateTemplateSentence(words);
		//System.out.println(templateSentence);
//		for(int i = 0; i < 5; i ++)
//		{
//			System.out.println(generateSentence(wordMap, templateSentence));
//		}
		
		ArrayList<Double> times = new ArrayList<Double>();
		File file = new File("poetic_sentence.g");
		int incr = 1000;
		int timesToLoop = 10;
		long stopTime, midpointTime, startTime = System.nanoTime();

		while(System.nanoTime() - startTime < 1000000000) { // empty block
		}

		// Collect running times.
		startTime = System.nanoTime();
		for(int i = 10; i < timesToLoop; i++) {
			//Generate random phrases
			printSentences(wordMap, templateSentence, i);
			}

		midpointTime = System.nanoTime();

		// Capture the cost of running the loop and any other operations done
		// above that are not the essential method call being timed.
		for(int i = 10; i < timesToLoop; i++) {
		}

		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and searching.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - 
					(stopTime - midpointTime)) / (double) timesToLoop;
		System.out.println(averageTime);
//		times.add(averageTime);
//		for(int i = 0; i < times.size(); i ++)
//		{
//			System.out.println(times.get(i) + " " + (i+1)*100);
//		}
	
}
	}
	
