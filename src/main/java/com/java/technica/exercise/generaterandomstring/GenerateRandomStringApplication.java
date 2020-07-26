package com.java.technica.exercise.generaterandomstring;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenerateRandomStringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenerateRandomStringApplication.class, args);
		System.out.println("output -> " + ReverseString.reverseString("K%#&e%6R53&8#4^(v^7*I#@3%n"));
		System.out.println("output -> " + ReverseString.identifyNumber());
//		UpworkJavaExercise upworkJavaExercise = applicationContext.getBean(UpworkJavaExercise.class);
//		upworkJavaExercise.execute();

//		/*
//		 * Reverse a string without affecting special characters 
//		 * Given a string, that contains special character together with alphabets 
//		 * (‘a’ to ‘z’ and ‘A’ 'Z’), reverse the string in a way that special characters are not affected.
//		 *
//		 * Examples:
//		 *
//		 * Input:   str = "a,b$c"
//		 * Output:  str = "c,b$a"
//		 * Note that $ and , are not moved anywhere.  
//		 * Only subsequence "abc" is reversed
//		 * Write the class in such a way it adheres to OOP principles and can be easily shared
//		 * 
//		 * Input:   str = "Ab,c,de!$"

	}

	public static class ReverseString {

		public static String identifyNumber() {
			int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			List<Integer> odd = new ArrayList();
			List<Integer> even = new ArrayList();
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] % 2 == 0) {
					even.add(numbers[i]);
				} else {
					odd.add(numbers[i]);
				}

			}

			return ("odd " + odd.toString()).concat("even " + even.toString());
		}

		public static String reverseString(String input) {
			System.out.println("input -> " + input);
			char[] inputChars = input.toCharArray();
			String filteredInput = input.replaceAll("[^a-zA-Z]", "");
			String reverse = new StringBuilder(new String(filteredInput)).reverse().toString();
			char[] reversedString = reverse.toCharArray();
			int k = 0;
			for (int i = 0; i < inputChars.length; i++) {
				if (checkChar(inputChars[i])) {
					k++;
					continue;
				}
				inputChars[i] = reversedString[i - k];
			}
			return new String(inputChars);

		}

		public static Boolean checkChar(char s) {
			Pattern p = Pattern.compile("[^a-zA-Z]");
			Matcher m = p.matcher(Character.toString(s));
			return m.matches();
		}

	}

}