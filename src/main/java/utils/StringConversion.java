/*
 * FILENAME StringConversion.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package utils;

import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Splitter;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * String class.
 * </p>
 * 
 * @see http://howtodoinjava.com/category/core-java/string-class/
 * @author manhnv
 * @version 1.0
 **/
public final class StringConversion {
	// Start - Convert Hex to ASCII and ASCII to Hex
	// Many times we do need to convert the string values ASCII from/to Hex
	// format. In
	// this small, post I am giving you two small code snippets which you can
	// utilize
	// to convert a string from Hex to ASCII or ASCII to Hex, as you want.
	// Overall conversion logic looks like this:
	// Hex -- Decimal -- ASCII

	/**
	 * <p>
	 * Convert ASCII to Hex. ASCII to Hex Example Code.
	 * </p>
	 * 
	 * <pre>
	 * It is done in following steps:
	 * </pre>
	 * <ul>
	 * <li>1.Convert String to char array</li>
	 * <li>2.Cast it to Integer</li>
	 * <li>3.Use Integer.toHexString() to convert it to Hex</li>
	 * </ul>
	 *
	 * @see http://howtodoinjava.com/2014/06/05/convert-hex-to-ascii-and-ascii- to-hex/
	 * @param asciiValue
	 *            the ascii will be converted
	 * @return hex string based on ascii string
	 **/
	public static String asciiToHex(final String asciiValue) {
		char[] chars = asciiValue.toCharArray();
		StringBuffer hex = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			hex.append(Integer.toHexString((int) chars[i]));
		}
		return hex.toString();
	}

	/**
	 * <p>
	 * Convert Hex to ASCII. Hex to ASCII Example Code.
	 * </p>
	 * 
	 * <pre>
	 * It is done in following steps:
	 * </pre>
	 * <ul>
	 * <li>1.Cut the Hex value in 2 chars groups</li>
	 * <li>2.Convert it to base 16 Integer using Integer.parseInt(hex, 16) and cast to char</li>
	 * <li>3.Append all chars in StringBuilder</li>
	 * </ul>
	 *
	 * @see http://howtodoinjava.com/2014/06/05/convert-hex-to-ascii-and-ascii- to-hex/
	 * @param hexValue
	 *            the hex will be converted
	 * @return ascii string based on hex string
	 **/
	public static String hexToASCII(final String hexValue) {
		StringBuilder output = new StringBuilder("");
		for (int i = 0; i < hexValue.length(); i += 2) {
			String str = hexValue.substring(i, i + 2);
			output.append((char) Integer.parseInt(str, 16));
		}
		return output.toString();
	}

	/**
	 * <p>
	 * Complete Example for Hex to ASCII and ASCII to Hex Conversion.
	 * </p>
	 * 
	 * @param args
	 *            string arguments
	 */
	public static void main(final String[] args) {
		String demoString = "http://howtodoinjava.com";
		// Original String
		System.out.println("Original String: " + demoString);

		String hexEquivalent = asciiToHex(demoString);
		// Hex value of original String
		System.out.println("Hex String: " + hexEquivalent);

		String asciiEquivalent = hexToASCII(hexEquivalent);
		// ASCII value obtained from Hex value
		System.out.println("Ascii String: " + asciiEquivalent);

		// Output:
		// Original String: http://howtodoinjava.com
		// Hex String: 687474703a2f2f686f77746f646f696e6a6176612e636f6d
		// Ascii String: http://howtodoinjava.com
	}

	// End - Convert Hex to ASCII and ASCII to Hex

	// Start - 4 ways to split/tokenize Strings in java
	// Splitting a string and get tokens out of it, is not a very un-common task
	// for
	// java programmers specially working on web layer. In web layer, there are
	// plenty
	// of techniques for arising data from view layer to controller, and
	// unfortunately
	// many times we have to pass data in CSV format only () or separated based
	// on some
	// other separator such $,# or another character.
	// Situation also come arise when we get data from clients in CSV formats
	// and
	// need to parse it before correctly interpretation it. In this post, I m
	// discussing few known and few not so well known ways of splitting the
	// strings.
	// Different String split examples
	// 1) Using legacy StringTokenizer
	// 2) Using recommended String.split()
	// 3) Apache StringUtils.split()
	// 4) Google Guava Splitter example

	/**
	 * <p>
	 * 1) Using legacy StringTokenizer.
	 * </p>
	 * 
	 * <pre>
	 * Example 1 - By default StringTokenizer breaks String on space.
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/06/02/4-ways-to-splittokenize-strings- in-java/
	 **/
	public static void stringTokenizerEx1() {
		// Example 1 - By default StringTokenizer breaks String on space
		String str = "I am sample string and will be tokenized on space";
		StringTokenizer defaultTokenizer = new StringTokenizer(str);
		System.out.println("Total number of tokens found: " + defaultTokenizer.countTokens());
		while (defaultTokenizer.hasMoreTokens())
			System.out.println(defaultTokenizer.nextToken());

		System.out.println("Total number of tokens found: " + defaultTokenizer.countTokens());

		// Output:
		// Total number of tokens found: 10
		// I
		// am
		// sample
		// string
		// and
		// will
		// be
		// tokenized
		// on
		// space
		// Total number of tokens found: 0
	}

	/**
	 * <p>
	 * 1) Using legacy StringTokenizer.
	 * </p>
	 * 
	 * <pre>
	 * Example 2 - StringTokenizer with multiple delimiters.
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/06/02/4-ways-to-splittokenize-strings- in-java/
	 **/
	public static void stringTokenizerEx2() {
		// Example 2 - StringTokenizer with multiple delimiters
		String url = "http://howtodoinjava.com/java-initerview-questions";
		StringTokenizer multiTokenizer = new StringTokenizer(url, "://.-");
		while (multiTokenizer.hasMoreTokens())
			System.out.println(multiTokenizer.nextToken());

		// Output:
		// http
		// howtodoinjava
		// com
		// java
		// initerview
		// questions
	}

	/**
	 * <p>
	 * 2) Using recommended String.split().
	 * </p>
	 * 
	 * @see http://howtodoinjava.com/2014/06/02/4-ways-to-splittokenize-strings- in-java/
	 **/
	public static void stringSplit() {
		String[] tokens = "I,am ,Legend, , oh ,you ?".split(",");
		for (String token : tokens)
			System.out.println(token);

		// Output:
		// I
		// am
		// Legend
		// //Empty token
		// oh //Space in starting
		// you ?
	}

	/**
	 * <p>
	 * 3) Apache StringUtils.split().
	 * </p>
	 * 
	 * @see http://howtodoinjava.com/2014/06/02/4-ways-to-splittokenize-strings- in-java/
	 **/
	public static void apacheSplit() {
		String[] tokens = StringUtils.split("I,am ,Legend, , oh ,you ?", ",");
		for (String token : tokens)
			System.out.println(token);

		// Output:
		// I
		// am
		// Legend
		// //Empty token
		// oh //Space in starting
		// you ?
	}

	/**
	 * <p>
	 * 4) Google Guava Splitter example.
	 * </p>
	 * 
	 * @see http://howtodoinjava.com/2014/06/02/4-ways-to-splittokenize-strings- in-java/
	 **/
	public static void guavaSplit() {
		Splitter splitter = Splitter.on(',').omitEmptyStrings().trimResults();
		Iterable<String> tokens = splitter.split("I,am ,Legend, , oh ,you ?");
		for (String token : tokens)
			System.out.println(token);

		// Output:
		// I
		// am
		// Legend
		// oh
		// you ?
	}

	// End - 4 ways to split/tokenize Strings in java

	// Start - Always use length() instead of equals() to check empty string in
	// java
	// In your day-to-day programming activities, you must be coming across
	// multiple
	// situation where you need to check if a string is empty. There are various
	// ways
	// to do this and some use string1.equals(""). NEVER do this.
	// Best way to check if string is empty or not is to use length() method.
	// This
	// method simply return the count of characters inside char array which
	// constitutes
	// the string. If the count or length is 0; you can safely conclude that
	// string is
	// empty.

	// Analysis:
	// As you can see that length() method is simply a getter method which
	// return the
	// count of characters in array. So it practically does not waste much CPU
	// cycles
	// to compute the length of string. And any String with length 0 is always
	// going to
	// be empty string.
	// Whereas equals() method takes a lot of statements before concluding that
	// string
	// is empty. It does reference check, typecasting if necessary, create
	// temporary
	// arrays and then use while loop also. So, its lot of waste of CPU cycles
	// to
	// verify a simple condition.

	/**
	 * <p>
	 * Check empty string.
	 * </p>
	 * 
	 * @see http://howtodoinjava.com/2013/03/31/always-use-length-instead-of- equals-to-check-empty-string-in-java/
	 * @param str
	 *            string will be checked
	 * @return true if str is empty, false otherwise
	 **/
	public boolean isEmpty1(final String str) {
		return str.equals(""); // NEVER do this
	}

	/**
	 * <p>
	 * Check empty string.
	 * </p>
	 * 
	 * @see http://howtodoinjava.com/2013/03/31/always-use-length-instead-of- equals-to-check-empty-string-in-java/
	 * @param str
	 *            string will be checked
	 * @return true if str is empty, false otherwise
	 **/
	public boolean isEmpty2(final String str) {
		return str.length() == 0; // Correct way to check empty
	}

	// End - Always use length() instead of equals() to check empty string in
	// java

	// Start - String class is supported in switch statement in java 7
	// If you remember the switch statement before java 7, it supported only int
	// and
	// enum types. Now with java 7 release, support for String class has also
	// been
	// added.

	public static class StringSupportedInSwitch {
		public static void main(String[] args) {
			// System.out.println(getExpendedMessage("one"));
			// System.out.println(getExpendedMessage("three"));
			// System.out.println(getExpendedMessage("five"));

			// Output:
			// Token one identified
			// Token one identified
			// No token was identified
		}

		// private static String getExpendedMessage(final String token)
		// {
		// /*
		// * Cannot switch on a value of type String for source level below 1.7.
		// Only convertible int values or enum
		// * variables are permitted.
		// */
		// switch (token)
		// {
		// case ("one"):
		// return "Token one identified";
		//
		// case ("two"):
		// return "Token one identified";
		//
		// case ("three"):
		// return "Token one identified";
		//
		// case ("four"):
		// return "Token one identified";
		//
		// default:
		// return "No token was identified";
		// }
		// }
	}
	// End - String class is supported in switch statement in java 7
}
