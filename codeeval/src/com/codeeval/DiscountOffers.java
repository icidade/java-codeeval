package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DiscountOffers {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				double ss = 0d;
				String lists[] = line.split(";");
				String consumers[] = lists[0].split(",");
				String products[] = lists[1].split(",");
				int index = 0;
				for (String product : products) {
					if (consumers[index].length() == product.length()) {
						ss = 1.5d;
					}
					if ((countLetters(consumers[index]) % 2) == 0) {
						// even
						ss = countVowels(consumers[index]) * 1.5d;
					} else {
						// odd
						ss = ((consumers[index].replaceAll(" ", "").length()) - countVowels(consumers[index]));
					}

					index++;
					System.out.println(ss);
				}
			}
		}
		buffer.close();
	}

	private static double countVowels(String consumer) {
		double result = 0;
		for (int i = 0; i < consumer.length(); i++) {
			if(compareChars(consumer.substring(i, i+1))){
				result++;
			}
		}
		return result;
	}

	private static boolean compareChars(String substring) {
		String [] compareIndexes = {"a", "e", "i", "o", "u", "y"}; 
		for (String string : compareIndexes) {
			if(substring.equalsIgnoreCase(string)){
				return true;
			}
		}
		return false;
	}

	private static int countLetters(String consumer) {
		return consumer.replaceAll(" ", "").length();
	}

}
