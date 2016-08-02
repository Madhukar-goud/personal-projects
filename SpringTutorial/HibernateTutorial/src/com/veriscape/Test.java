package com.veriscape;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args){
		String line = "madhukar@366";
		String pattern = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.matches()) {
			System.out.println("Valid Match");
		} else {
			System.out.println("NO MATCH");
		}
	}

}
