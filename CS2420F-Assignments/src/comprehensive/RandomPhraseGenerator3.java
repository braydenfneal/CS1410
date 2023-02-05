package comprehensive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class RandomPhraseGenerator3 {

	public static void main(String[] args) throws FileNotFoundException {
		//int numPhrases = Integer.parseInt(args[1]);
		int numPhrases = 2;
		String temp;
		String hash;
		
		HashMap<String, String> grammar = new HashMap<String, String>();
		
		Scanner myScan = new Scanner(new File("src/comprehensive/poetic_sentence.g"));
		
		while(myScan.hasNext()) {
			if(myScan.nextLine().equals("{")) {
				hash = myScan.nextLine();
				//hash is the hash code
				temp = myScan.nextLine();
				while(!temp.equals("}")) {
					
					grammar.put(hash, temp);
					
					temp = myScan.nextLine();
				}
			}
		}
		myScan.close();
		
		//Generate random phrases
		String phrase;
		phrase = grammar.get("<start>");
		
		int beginning, end;
		
		for(int i = 0; i < numPhrases; i++) {
			phrase = grammar.get("<start>");
			
			while(phrase.contains("<")) {
				beginning = phrase.indexOf('<');
				end = phrase.indexOf('>');
				if(end == phrase.length() - 1) {
					temp = grammar.get(phrase.substring(beginning));
					phrase = phrase.substring(0, beginning) + temp;
				}
				else {
					temp = grammar.get(phrase.substring(beginning, end + 1));
					phrase = phrase.substring(0, beginning) + temp + phrase.substring(end + 1);
				}
			}
			
			System.out.println(phrase);
		}
		
		
		String phrase1;
		String[] parts;
		for(int i = 0; i < numPhrases; i++) {
			phrase1 = grammar.get("<start>");
			
			while(phrase1.contains("<")) {
				parts = phrase1.split(" ");
				phrase1 = "";

				for(int j = 0; j < parts.length - 1; j++) {
					if(parts[j].charAt(0) == '<') {
						
						if(parts[j].charAt(parts[j].length() - 1) != '>') {
							String key = parts[j].substring(0, parts[j].length() - 1);
							String end1 = parts[j].substring(parts[j].length() - 1);
							key = grammar.get(key);
							parts[j] = key.concat(end1);
						}
						else {
							parts[j] = grammar.get(parts[j]);
						}
						
					}
					phrase1 = phrase1.concat(parts[j] + " ");
				}
				
				if(parts[parts.length - 1].charAt(0) == '<') {
					if(parts[parts.length - 1].charAt(parts[parts.length - 1].length() - 1) != '>') {
						String key = parts[parts.length - 1].substring(0, parts[parts.length - 1].length() - 1);
						String end1 = parts[parts.length - 1].substring(parts[parts.length - 1].length() - 1);
						key = grammar.get(key);
						parts[parts.length - 1] = key.concat(end1);
					}
					else {
						parts[parts.length - 1] = grammar.get(parts[parts.length - 1]);
					}
				}
				
				phrase1 = phrase1.concat(parts[parts.length - 1]);
			}
			
			System.out.println(phrase1);
		}
		
		
		
	}

}
