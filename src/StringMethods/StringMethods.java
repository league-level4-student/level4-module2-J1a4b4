package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		int i1 = s1.length();
		int i2 = s2.length();
		if (i1 > i2) {
			return s1;
		}else if (i1 < i2) {
			return s2;
		}
		return "equal";
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		if (s.contains("underscores")) {
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) == ' ') {
					s = s.substring(0, i) + "_" + s.substring(i + 1, s.length());
				}
			}
		}
		return s;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		char c1 = 0;
		char c2 = 0;
		char c3 = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != ' ') {
				c1 = s1.charAt(i);
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) != ' ') {
				c2 = s2.charAt(i);
			}
		}
		for (int i = 0; i < s3.length(); i++) {
			if (s3.charAt(i) != ' ') {
				c3 = s3.charAt(i);
			}
		}
		String leader = "";
		if (c1 < c2 && c1 < c3) {
			leader = s1;
		}else if (c1 > c2 && c2 < c3) {
			leader = s2;
		}else if (c3 < c1 && c2 > c3) {
			leader = s3;
		}
		boolean found = false;
		int counter = -1;
		while (found == false) {
			counter++;
			if (leader.charAt(counter) != ' ') {
				found = true;
			}
		}
		leader = leader.substring(counter);
		found = false;
		counter = leader.length();
		while (found == false) {
			counter--;
			if (leader.charAt(counter) != ' ') {
				found = true;
			}
		}
		leader = leader.substring(0, counter + 1);
		return leader;
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int counter = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == '1') {
				counter = counter + 1;
			}
		}
		return 0;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int counter = 0;
		for (int i = 0; i < s.length() - substring.length() + 1; i++) {
			if (s.charAt(i) == substring.charAt(0)) {
				
			}
		}
		return counter;
	}

	// Call Utilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		String k = key + "";
		return Utilities.encrypt(s.getBytes(), k.getBytes()[0]);
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		String k = key + "";
		return Utilities.decrypt(s, k.getBytes()[0]);
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		return 0;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		return 0;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		return true;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
