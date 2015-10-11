package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveCharacters {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			String[] s = line.split(",");
			String phrase = s[0].trim();
			List<String> removeCharsList = new ArrayList<String>();
			for (int i = 0; i < s[1].trim().length(); i++) {
				removeCharsList.add(String.valueOf(s[1].trim().charAt(i)));
			}
			for (Iterator<String> iterator = removeCharsList.iterator(); iterator
					.hasNext();) {
				String string = (String) iterator.next();
				phrase = phrase.replace(string, "");
			}
			System.out.println(phrase);
		}
		buffer.close();
		System.exit(0);
	}

}
