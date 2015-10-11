package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReverseAndAdd {
	static Integer result = null;
	static int counter = 0;

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		int i = 0;
		while ((line = buffer.readLine()) != null && i < 10000) {
			i++;
			line = line.trim();
			Integer input = Integer.valueOf(line);

			if (isPalindrome(input)) {
				System.out.println(counter + " " + result);
			}

		}
		buffer.close();
		System.exit(0);
	}

	public static Integer reverse(Integer number) {
		int result = 0;
		while (number != 0) {
			Integer lastDigit = number % 10;
			result = result * 10 + lastDigit;
			number = number / 10;
		}
		ReverseAndAdd.result = new Integer(result);
		return result;
	}

	public static boolean isPalindrome(Integer number) {
		int reverse = reverse(number);
		counter++;
		if(number + reverse == reverse(number + reverse)){
			return true;
		}else if(counter < 100){
			return isPalindrome(number + reverse);
		}else{
			return false;
		}
	}

}
