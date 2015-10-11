package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReverseWords {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				String[] words = line.split(" ");
				StringBuffer reverse = new StringBuffer();
				for (int i = words.length - 1; i >= 0; i--) {
					reverse.append(words[i]);
					if (i > 0) {
						reverse.append(" ");
					}
				}
				System.out.println(reverse.toString());
			}
		}
		buffer.close();
	}

}
