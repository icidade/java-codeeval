package com.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BitPosition {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (line.length() > 0) {
				String [] nums = line.split(",");
				String first = "";
				Boolean igual = false;
				for (int i = 0; i < nums.length; i++) {
					
					if(i==0){
						first = Integer.toBinaryString(Integer.valueOf(nums[i]));
					}else{
						if(Integer.toBinaryString(Integer.valueOf(nums[i])).equalsIgnoreCase(first)){
							igual = true;
						}else{
							igual = false;
							break;
						}
					}
				}
				System.out.println(igual.toString().toLowerCase());
			}
		}
		buffer.close();
	}

}
