/*
 * FILENAME RegularExpression.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2009 VietinBank Group. All rights reserved. This software is the confidential and proprietary information of
 * VietinBank Group ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with VietinBank Group.
 */

package regexs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <strong>Java Regular Expression Tutorial.</strong>
 * <p>
 * Java has extensive support for Regular Expression functionality through the java.util.regex package. After spending
 * time writing all below examples, I can confirm that regular expression basics are relatively easy to learn but very
 * hard to master.
 * </p>
 * 
 * @see http://howtodoinjava.com/java-regular-expression-tutorials/
 * @author manhnv
 * @version 1.0
 **/
public final class RegularExpression {
	// Regular Expression for Email Address
	public static final String EMAIL_ADDRESS_REG_EXP = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	// Regular Expression for Password Validation
	public static final String PASSWORD_VALIDATION_REG_EXP = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})";
	// Regular Expression for Trademark Symbol
	public static final String TRADEMARK_SYMBOL_REG_EXP = "\u2122";
	// Regular Expression for Any Currency Symbol
	public static final String CURRENCY_SYMBOL_REG_EXP = "\\p{Sc}";
	// Regular Expression for Any Character in "Greek Extended" or Greek script
	public static final String GREEK_EXTENDED_REG_EXP = "\\p{InGreek} and \\p{InGreekExtended}";
	// Regular Expression for North American Phone Numbers
	public static final String NORTH_AMERICAN_PHONE_NUMBERS_REG_EXP = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
	// Regular Expression for International Phone Numbers
	public static final String INTERNATIONAL_PHONE_NUMBERS_REG_EXP = "^\\+(?:[0-9] ?){6,14}[0-9]$";
	// Regular Expression for Date Formats
	public static final String DATE_FORMATS_REG_EXP = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
	// Regular Expression for Social Security Numbers (SSN)
	public static final String SOCIAL_SECURITY_NUMBERS_REG_EXP = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$";
	// Regular Expression for International Standard Book Number (ISBNs)
	public static final String ISBN_REG_EXP = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})"
			+ " [- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$) "
			+ " (?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
	// Regular Expression for US Postal Zip Codes
	public static final String US_POSTAL_ZIP_CODES_REG_EXP = "^[0-9]{5}(?:-[0-9]{4})?$";
	// Regular Expression for Canadian Postal Zip Codes
	public static final String CANADIAN_POSTAL_ZIP_CODES_REG_EXP = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";
	// Regular Expression for U.K. Postal Codes (Postcodes)
	public static final String UK_POSTAL_CODES_REG_EXP = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$";
	// Regular Expression for Credit Card Numbers
	public static final String CREDIT_CARD_NUMBERS_REG_EXP = "^(?:(?4[0-9]{12}(?:[0-9]{3})?)|(?5[1-5][0-9]{14})|(?6(?:011|5[0-9]{2})[0-9]{12})|(?3[47][0-9]{13})"
			+ "|(?3(?:0[0-5]|[68][0-9])?[0-9]{11})|(?(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

	/**
	 * <p>
	 * Match Trademark Symbol.
	 * </p>
	 * 
	 * <pre>
	 * Solution java regex : \u2122
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/11/11/java-regex-match-trademark-symbol/
	 **/
	public static void trademarkSymbol() {
		final String regex = "\u2122";
		final String data1 = "Searching in trademark character ™ is so easy when you know it.";

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(data1);
		while (matcher.find()) {
			System.out.println("Start index: " + matcher.start());
			System.out.println(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
		}
		// Output:
		// Start index: 33 End index: 34 ™
	}

	/**
	 * <p>
	 * Example Code for matching any Currency Symbol using Java Regex.
	 * </p>
	 * 
	 * <pre>
	 * Solution Regex :  \\p{Sc}
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/11/11/java-regex-match-any-currency-symbol/
	 **/
	public static void currencySymbol() {
		final String content = "Let's find the symbols or currencies : $ Dollar, € Euro, ¥ Yen";
		final String regex = "\\p{Sc}";

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(" : " + matcher.group());
		}

		// Output:
		// Start index: 39 End index: 40 : $
		// Start index: 49 End index: 50 : €
		// Start index: 57 End index: 58 : ¥
	}

	/**
	 * <p>
	 * Java Regex : Match Any Character in "Greek Extended" or Greek script.
	 * </p>
	 * 
	 * <pre>
	 * Solution Regex(s) : \\p{InGreek} and \p{InGreekExtended}
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/11/11/java-regex-match-any-character-in-greek-extended-or-greek-script/
	 **/
	public static void greekExtended() {
		// Match any character in Greek script
		final String content = "A math equation might be α + β = λ + γ";
		final String regex = "\\p{InGreek}";

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(" : " + matcher.group());
		}

		// Output:
		// Start index: 25 End index: 26&nbsp; : α
		// Start index: 29 End index: 30&nbsp; : β
		// Start index: 33 End index: 34&nbsp; : λ
		// Start index: 37 End index: 38&nbsp; : γ

		// Match any character in "Greek Extended" unicode block
		final String content1 = "Let's learn some new greek extended characters : ᾲ , ᾨ etc.";
		final String regex1 = "\\p{InGreekExtended}";

		Pattern pattern1 = Pattern.compile(regex1, Pattern.CASE_INSENSITIVE);
		Matcher matcher1 = pattern1.matcher(content1);
		while (matcher1.find()) {
			System.out.print("Start index: " + matcher1.start());
			System.out.print(" End index: " + matcher1.end() + " ");
			System.out.println(" : " + matcher1.group());
		}

		// Output:
		// Start index: 49 End index: 50&nbsp; : ᾲ
		// Start index: 53 End index: 54&nbsp; : ᾨ
	}

	/**
	 * <p>
	 * Java Regex : Validate and Format North American Phone Numbers.
	 * </p>
	 * 
	 * <pre>
	 * Regex : ^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/11/12/java-regex-validate-and-format-north-american-phone-numbers/
	 **/
	public static void northAmericanPhoneNumbers() {
		// Using Regex to Validate North American Phone Numbers
		List<String> phoneNumbers = Lists.newArrayList();
		phoneNumbers.add("1234567890");
		phoneNumbers.add("123-456-7890");
		phoneNumbers.add("123.456.7890");
		phoneNumbers.add("123 456 7890");
		phoneNumbers.add("(123) 456 7890");

		// Invalid phone numbers
		phoneNumbers.add("12345678");
		phoneNumbers.add("12-12-111");

		String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		Pattern pattern = Pattern.compile(regex);
		for (String email : phoneNumbers) {
			Matcher matcher = pattern.matcher(email);
			System.out.println(email + " : " + matcher.matches());
		}

		// Output:
		// 1234567890 : true
		// 123-456-7890 : true
		// 123.456.7890 : true
		// 123 456 7890 : true
		// (123) 456 7890 : true
		// 12345678 : false
		// 12-12-111 : false
		// Using Regex to format North American Phone Numbers
		List<String> phoneNumbers1 = Lists.newArrayList();
		phoneNumbers1.add("1234567890");
		phoneNumbers1.add("123-456-7890");
		phoneNumbers1.add("123.456.7890");
		phoneNumbers1.add("123 456 7890");
		phoneNumbers1.add("(123) 456 7890");

		// Invalid phone numbers
		phoneNumbers1.add("12345678");
		phoneNumbers1.add("12-12-111");

		String regex1 = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		Pattern pattern1 = Pattern.compile(regex1);

		for (String email : phoneNumbers1) {
			Matcher matcher = pattern1.matcher(email);
			// System.out.println(email +" : "+ matcher.matches());
			// If phone number is correct then format it to (123)-456-7890
			if (matcher.matches()) {
				System.out.println(matcher.replaceFirst("($1) $2-$3"));
			}
		}

		// Output:
		// (123) 456-7890
		// (123) 456-7890
		// (123) 456-7890
		// (123) 456-7890
		// (123) 456-7890
	}

	/**
	 * <p>
	 * Java Regex : Validate International Phone Numbers.
	 * </p>
	 * 
	 * <pre>
	 * Regex : ^\+(?:[0-9] ?){6,14}[0-9]$
	 * <ul>
	 * <li>^ # Assert position at the beginning of the string.</li>
	 * <li>\+ # Match a literal "+" character.</li>
	 * <li>(?: # Group but don't capture:</li>
	 * <li>[0-9] # Match a digit.</li>
	 * <li>\\s # Match a space character</li>
	 * <li>? # between zero and one time.</li>
	 * <li>) # End the noncapturing group.</li>
	 * <li>{6,14} # Repeat the group between 6 and 14 times.</li>
	 * <li>[0-9] # Match a digit.</li>
	 * <li>$ # Assert position at the end of the string.</li>
	 * </ul>
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/11/12/java-regex-validate-international-phone-numbers/
	 **/
	public static void internationalPhoneNumbers() {
		// Using Regex to Validate International Phone Numbers
		// Regex : ^\+(?:[0-9] ?){6,14}[0-9]$
		List<String> phoneNumbers = Lists.newArrayList();
		phoneNumbers.add("+1 1234567890123");
		phoneNumbers.add("+12 123456789");
		phoneNumbers.add("+123 123456");

		String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
		Pattern pattern = Pattern.compile(regex);
		for (String email : phoneNumbers) {
			Matcher matcher = pattern.matcher(email);
			System.out.println(email + " : " + matcher.matches());
		}

		// Output:
		// +1 1234567890123 : true
		// +12 123456789 : true
		// +123 123456 : true

		// Validate international phone numbers in EPP format
		// Regex : ^\+[0-9]{1,3}\.[0-9]{4,14}(?:x.+)?$
		List<String> phoneNumbers1 = Lists.newArrayList();
		phoneNumbers1.add("+123.123456x4444");
		phoneNumbers1.add("+12.1234x11");
		phoneNumbers1.add("+1.123456789012x123456789");

		String regex1 = "^\\+[0-9]{1,3}\\.[0-9]{4,14}(?:x.+)?$";
		Pattern pattern1 = Pattern.compile(regex1);
		for (String email : phoneNumbers1) {
			Matcher matcher = pattern1.matcher(email);
			System.out.println(email + " : " + matcher.matches());
		}

		// Output:
		// +123.123456x4444 : true
		// +12.1234x11 : true
		// +1.123456789012x123456789 : true
	}

	/**
	 * <p>
	 * Java Regex : Date Format Validation.
	 * </p>
	 * 
	 * <pre>
	 * Details below
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/11/12/java-regex-date-format-validation/
	 **/
	public static void dateFormatValidation() {
		// 1) Regex to match any of these date formats and allow leading zeros to be omitted
		// Regex : ^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$
		List<String> dates = Lists.newArrayList();
		dates.add("1/1/11");
		dates.add("01/01/11");
		dates.add("01/01/2011");
		dates.add("01/1/2011");
		dates.add("1/11/2011");
		dates.add("1/11/11");
		dates.add("11/1/11");

		String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
		Pattern pattern = Pattern.compile(regex);
		for (String date : dates) {
			Matcher matcher = pattern.matcher(date);
			System.out.println(date + " : " + matcher.matches());
		}

		// Output:
		// 1/1/11 : true
		// 01/01/11 : true
		// 01/01/2011 : true
		// 01/1/2011 : true
		// 1/11/2011 : true
		// 1/11/11 : true
		// 11/1/11 : true

		// 2) Regex to match any of these date formats and require leading zeros
		// Regex : ^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$
		List<String> dates1 = Lists.newArrayList();

		// With leading zeros
		dates1.add("01/01/11");
		dates1.add("01/01/2011");

		// Missing leading zeros
		dates1.add("1/1/11");
		dates1.add("01/1/2011");
		dates1.add("1/11/2011");
		dates1.add("1/11/11");
		dates1.add("11/1/11");

		String regex1 = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$";
		Pattern pattern1 = Pattern.compile(regex1);
		for (String date : dates1) {
			Matcher matcher = pattern1.matcher(date);
			System.out.println(date + " : " + matcher.matches());
		}

		// Output:
		// 01/01/11 : true
		// 01/01/2011 : true
		// 1/1/11 : false
		// 01/1/2011 : false
		// 1/11/2011 : false
		// 1/11/11 : false
		// 11/1/11 : false

		// 3) Regex to match "mm/dd/yyyy" with required leading zeros
		// Regex : ^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$
		List<String> dates11 = Lists.newArrayList();
		// With leading zeros
		dates11.add("01/01/11");
		dates11.add("01/01/2011");
		// Missing leading zeros
		dates11.add("1/1/11");
		dates11.add("01/1/2011");

		String regex11 = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
		Pattern pattern11 = Pattern.compile(regex11);
		for (String date : dates11) {
			Matcher matcher = pattern11.matcher(date);
			System.out.println(date + " : " + matcher.matches());
		}

		// Output:
		// 01/01/11 : false
		// 01/01/2011 : true
		// 1/1/11 : false
		// 01/1/2011 : false

		// 4) Regex to match "dd/mm/yyyy" with required leading zeros
		// Regex : ^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$
		List<String> dates111 = Lists.newArrayList();
		// With leading zeros
		dates111.add("07/13/2011");
		dates111.add("13/07/2011");
		// Missing leading zeros
		dates111.add("1/1/11");
		dates111.add("01/1/2011");

		String regex111 = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
		Pattern pattern111 = Pattern.compile(regex111);
		for (String date : dates111) {
			Matcher matcher = pattern111.matcher(date);
			System.out.println(date + " : " + matcher.matches());
		}

		// Output:
		// 07/13/2011 : false
		// 13/07/2011 : true
		// 1/1/11 : false
		// 01/1/2011 : false
	}

	/**
	 * <p>
	 * Java Regex : Validate Social Security Numbers (SSN).
	 * </p>
	 * 
	 * <pre>
	 * Regex : ^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$
	 * <ul>
	 * <li>^            # Assert position at the beginning of the string.</li>
	 * <li>[0-8]        # Match a digit between 0 and 8.</li>
	 * <li>[0-9]{2}     # Match a digit, exactly two times.</li>
	 * <li>-            # Match a literal "-".</li>
	 * <li>(?!00)       # Assert that "00" cannot be matched here.</li>
	 * <li>[0-9]{2}     # Match a digit, exactly two times.</li>
	 * <li>-            # Match a literal "-".</li>
	 * <li>(?!0000)     # Assert that "0000" cannot be matched here.</li>
	 * <li>[0-9]{4}     # Match a digit, exactly four times.</li>
	 * <li>$            # Assert position at the end of the string.</li>
	 * </ul>
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/11/14/java-regex-validate-social-security-numbers-ssn/
	 **/
	public static void validSSN() {
		List<String> ssns = Lists.newArrayList();

		// Valid SSNs
		ssns.add("123-45-6789");
		ssns.add("856-45-6789");

		// Invalid SSNs
		ssns.add("000-45-6789");
		ssns.add("666-45-6789");
		ssns.add("901-45-6789");
		ssns.add("85-345-6789");
		ssns.add("856-453-6789");
		ssns.add("856-45-67891");
		ssns.add("856-456789");

		String regex = "^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex);
		for (String number : ssns) {
			Matcher matcher = pattern.matcher(number);
			System.out.println(matcher.matches());
		}

		// Output:
		// true
		// true
		// false
		// false
		// false
		// false
		// false
		// false
		// false
	}

	/**
	 * <p>
	 * Java Regex : Validate International Standard Book Number (ISBNs).
	 * </p>
	 * 
	 * <pre>
	 * Regex to Validate ISBNs
	 * <ul>
	 * <li>Regex for ISBN-10 : ^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})
	 * [- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$</li>
	 * <li>Regex for ISBN-13 : ^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)
	 * 97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$</li>
	 * <li>Regex for ISBN-10 or ISBN-13 : ^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})
	 * [- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)
	 * (?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$</li>
	 * </ul>
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/11/17/java-regex-validate-international-standard-book-number-isbns/
	 **/
	public static void validISBN() {
		// Validate ISBN-10 Formats Only
		// Regex for ISBN-10 : ^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[-
		// ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$
		List<String> isbns = new ArrayList<String>();

		// Valid ISBNs
		isbns.add("0-596-52068-9");
		isbns.add("0 512 52068 9");
		isbns.add("ISBN-10 0-596-52068-9");
		isbns.add("ISBN-10: 0-596-52068-9");

		// Invalid ISBNs
		isbns.add("0-5961-52068-9");
		isbns.add("11 5122 52068 9");
		isbns.add("ISBN-13 0-596-52068-9");
		isbns.add("ISBN-10- 0-596-52068-9");

		String regex = "^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";

		Pattern pattern = Pattern.compile(regex);

		for (String isbn : isbns) {
			Matcher matcher = pattern.matcher(isbn);
			System.out.println(matcher.matches());
		}

		// Output:
		// true
		// true
		// true
		// true
		// false
		// false
		// false
		// false

		// Validate ISBN-13 Formats Only
		// Regex for ISBN-13 : ^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][-
		// ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$
		List<String> isbns1 = Lists.newArrayList();

		// Valid ISBNs
		isbns1.add("ISBN 978-0-596-52068-7");
		isbns1.add("ISBN-13: 978-0-596-52068-7");
		isbns1.add("978 0 596 52068 7");
		isbns1.add("9780596520687");

		// Invalid ISBNs
		isbns1.add("ISBN 11978-0-596-52068-7");
		isbns1.add("ISBN-12: 978-0-596-52068-7");
		isbns1.add("978 10 596 52068 7");
		isbns1.add("119780596520687");

		String regex1 = "^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$";
		Pattern pattern1 = Pattern.compile(regex1);
		for (String isbn : isbns1) {
			Matcher matcher = pattern1.matcher(isbn);
			System.out.println(matcher.matches());
		}

		// Output:
		// true
		// true
		// true
		// true
		// false
		// false
		// false
		// false

		// Validate ISBN-10 AND ISBN-13 Formats Both
		// Regex for ISBN-10 or ISBN-13 : ^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[-
		// 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[-
		// ]?[0-9]+[- ]?[0-9X]$
		List<String> isbns11 = Lists.newArrayList();

		// Valid ISBNs
		isbns11.add("ISBN 978-0-596-52068-7");
		isbns11.add("ISBN-13: 978-0-596-52068-7");
		isbns11.add("978 0 596 52068 7");
		isbns11.add("9780596520687");
		isbns11.add("0-596-52068-9");
		isbns11.add("0 512 52068 9");
		isbns11.add("ISBN-10 0-596-52068-9");
		isbns11.add("ISBN-10: 0-596-52068-9");

		// Invalid ISBNs
		isbns11.add("ISBN 11978-0-596-52068-7");
		isbns11.add("ISBN-12: 978-0-596-52068-7");
		isbns11.add("978 10 596 52068 7");
		isbns11.add("119780596520687");
		isbns11.add("0-5961-52068-9");
		isbns11.add("11 5122 52068 9");
		isbns11.add("ISBN-11 0-596-52068-9");
		isbns11.add("ISBN-10- 0-596-52068-9");

		String regex11 = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$";
		Pattern pattern11 = Pattern.compile(regex11);
		for (String isbn : isbns11) {
			Matcher matcher = pattern11.matcher(isbn);
			System.out.println(matcher.matches());
		}

		// Output:
		// true
		// true
		// true
		// true
		// true
		// true
		// true
		// true
		// false
		// false
		// false
		// false
		// false
		// false
		// false
		// false
	}

	/**
	 * <p>
	 * Java Regex : Validate US Postal Zip Codes. Valid US Postal ZIP codes.
	 * </p>
	 * 
	 * <pre>
	 * Regex : ^[0-9]{5}(?:-[0-9]{4})?$
	 * <ul>
	 * <li>^           # Assert position at the beginning of the string.</li>
	 * <li>[0-9]{5}    # Match a digit, exactly five times.</li>
	 * <li>(?:         # Group but don't capture:</li>
	 * <li>-         #   Match a literal "-".</li>
	 * <li>[0-9]{4}  #   Match a digit, exactly four times.</li>
	 * <li>)           # End the non-capturing group.</li>
	 * <li>?         #   Make the group optional.</li>
	 * <li>$           # Assert position at the end of the string.</li>
	 * </ul>
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/11/17/java-regex-validate-us-postal-zip-codes/
	 **/
	public static void usPostalZipCodes() {
		List<String> zips = Lists.newArrayList();

		// Valid ZIP codes
		zips.add("12345");
		zips.add("12345-6789");

		// Invalid ZIP codes
		zips.add("123456");
		zips.add("1234");
		zips.add("12345-678");
		zips.add("12345-67890");

		String regex = "^[0-9]{5}(?:-[0-9]{4})?$";
		Pattern pattern = Pattern.compile(regex);
		for (String zip : zips) {
			Matcher matcher = pattern.matcher(zip);
			System.out.println(matcher.matches());
		}

		// Output:
		// true
		// true
		// false
		// false
		// false
		// false
	}

	/**
	 * <p>
	 * Java Regex : Validate Canadian Postal Zip Codes. Valid Canadian Postal ZIP codes.
	 * </p>
	 * 
	 * <pre>
	 * Regex : ^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/11/17/java-regex-validate-canadian-postal-zip-codes/
	 **/
	public static void canadianPostalZipCodes() {
		List<String> zips = new ArrayList<String>();

		// Valid ZIP codes
		zips.add("K1A 0B1");
		zips.add("B1Z 0B9");

		// Invalid ZIP codes
		zips.add("K1A 0D1");
		zips.add("W1A 0B1");
		zips.add("Z1A 0B1");

		String regex = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";
		Pattern pattern = Pattern.compile(regex);
		for (String zip : zips) {
			Matcher matcher = pattern.matcher(zip);
			System.out.println(matcher.matches());
		}

		// Output:
		// true
		// true
		// false
		// false
	}

	/**
	 * <p>
	 * Java Regex : Validate U.K. Postal Codes (Postcodes). Valid UK Postal codes.
	 * </p>
	 * 
	 * <pre>
	 * Regex: ^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/11/17/java-regex-validate-u-k-postal-codes-postcodes/
	 **/
	public static void ukPostalZipCodes() {
		List<String> zips = new ArrayList<String>();

		// Valid ZIP codes
		zips.add("SW1W 0NY");
		zips.add("PO16 7GZ");
		zips.add("GU16 7HF");
		zips.add("L1 8JQ");

		// Invalid ZIP codes
		zips.add("Z1A 0B1");
		zips.add("A1A 0B11");

		String regex = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$";
		Pattern pattern = Pattern.compile(regex);
		for (String zip : zips) {
			Matcher matcher = pattern.matcher(zip);
			System.out.println(matcher.matches());
		}

		// Output:
		// true
		// true
		// true
		// true
		// false
		// false
	}

	/**
	 * <p>
	 * Java Regex : Validate Credit Card Numbers. Valid Credit Card Numbers Format.
	 * </p>
	 * 
	 * <pre>
	 * Regex : ^(?:(?4[0-9]{12}(?:[0-9]{3})?)|(?5[1-5][0-9]{14})|(?6(?:011|5[0-9]{2})[0-9]{12})|(?3[47][0-9]{13})|(?3(?:0[0-5]|[68][0-9])?[0-9]{11})|(?(?:2131|1800|35[0-9]{3})[0-9]{11}))$
	 * <ul>
	 * <li>Visa : 13 or 16 digits, starting with 4.</li>
	 * <li>MasterCard : 16 digits, starting with 51 through 55.</li>
	 * <li>Discover : 16 digits, starting with 6011 or 65.</li>
	 * <li>American Express : 15 digits, starting with 34 or 37.</li>
	 * <li>Diners Club : 14 digits, starting with 300 through 305, 36, or 38.</li>
	 * <li>JCB : 15 digits, starting with 2131 or 1800, or 16 digits starting with 35.</li>
	 * </ul>
	 * </pre>
	 * 
	 * @see http://howtodoinjava.com/2014/11/18/java-regex-validate-credit-card-numbers/
	 **/
	public static void validateCreditCardNumbers() {
		// Example Code to Validate Credit Card Numbers
		List<String> cards = new ArrayList<String>();

		// Valid Credit Cards
		cards.add("xxxx-xxxx-xxxx-xxxx"); // Masked to avoid any inconvenience unknowingly

		// Invalid Credit Card
		cards.add("xxxx-xxxx-xxxx-xxxx"); // Masked to avoid any inconvenience unknowingly

		String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" + "(?<mastercard>5[1-5][0-9]{14})|"
				+ "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" + "(?<amex>3[47][0-9]{13})|"
				+ "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" + "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

		Pattern pattern = Pattern.compile(regex);
		for (String card : cards) {
			// Strip all hyphens
			card = card.replaceAll("-", "");

			// Match the card
			Matcher matcher = pattern.matcher(card);
			System.out.println(matcher.matches());

			if (matcher.matches()) {
				// If card is valid then verify which group it belong
				// System.out.println(matcher.group("mastercard"));
				System.out.println(matcher.group());
			}
		}

		// Checksum Validation with the Luhn Algorithm
		/**
		 * <p>
		 * Luhn Class is an implementation of the Luhn algorithm that checks validity of a credit card number.
		 * </p>
		 * 
		 * <pre>
		 * https://code.google.com/p/gnuc-credit-card-checker/source/browse/trunk/CCCheckerPro/src/com/gnuc/java/ccc/Luhn.java
		 * </pre>
		 */
		@SuppressWarnings("unused")
		class Luhn {
			/**
			 * <p>
			 * Luhn Class is an implementation of the Luhn algorithm that checks validity of a credit card number.
			 * </p>
			 * 
			 * @author <a href="http://www.chriswareham.demon.co.uk/software/Luhn.java">Chris Wareham</a>
			 * @version Checks whether a string of digits is a valid credit card number according to the Luhn algorithm.
			 *          1. Starting with the second to last digit and moving left, double the value of all the
			 *          alternating digits. For any digits that thus become 10 or more, add their digits together. For
			 *          example, 1111 becomes 2121, while 8763 becomes 7733 (from (1+6)7(1+2)3). 2. Add all these digits
			 *          together. For example, 1111 becomes 2121, then 2+1+2+1 is 6; while 8763 becomes 7733, then
			 *          7+7+3+3 is 20. 3. If the total ends in 0 (put another way, if the total modulus 10 is 0), then
			 *          the number is valid according to the Luhn formula, else it is not valid. So, 1111 is not valid
			 *          (as shown above, it comes out to 6), while 8763 is valid (as shown above, it comes out to 20).
			 * @param ccNumber
			 *            the credit card number to validate.
			 * @return <b>true</b> if the number is valid, <b>false</b> otherwise.
			 */
			public boolean Check(String ccNumber) {
				int sum = 0;
				boolean alternate = false;
				for (int i = ccNumber.length() - 1; i >= 0; i--) {
					int n = Integer.parseInt(ccNumber.substring(i, i + 1));
					if (alternate) {
						n *= 2;
						if (n > 9) {
							n = (n % 10) + 1;
						}
					}
					sum += n;
					alternate = !alternate;
				}
				return (sum % 10 == 0);
			}
		}
	}

	/**
	 * <p>
	 * Private constructor to void check-style violate.
	 * </p>
	 */
	private RegularExpression() {
	}
}
