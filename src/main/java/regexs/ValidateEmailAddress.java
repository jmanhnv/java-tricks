/*
 * FILENAME ValidateEmailAddress.java FILE LOCATION $Source$ VERSION $Id$
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

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * Java Regex: Validate Email Address.
 * </p>
 * 
 * @see http://howtodoinjava.com/2014/11/11/java-regex-validate-email-address/
 * @author manhnv
 * @version 1.0
 **/
public final class ValidateEmailAddress {
	/**
	 * <p>
	 * Simplest regex to validate emails.
	 * </p>
	 * <strong>Regex: ^(.+)@(.+)$</strong>
	 * 
	 * <pre>
	 * This one is simplest and only cares about '@' symbol. Before and after '@' symbol, there can be any number of
	 * characters. Let's see a quick example to see what I mean.
	 * </pre>
	 */
	public static void validate01() {
		List<String> emails = new ArrayList<String>();
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user1@domain.com");
		emails.add("user.name@domain.com");
		emails.add("user#@domain.co.in");
		emails.add("user@domaincom");

		// Invalid emails
		emails.add("user#domain.com");
		emails.add("@yahoo.com");

		final String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		for (String email : emails) {
			Matcher matcher = pattern.matcher(email);
			System.out.println(email + ": " + matcher.matches());
		}

		// Output:
		// user@domain.com: true
		// user@domain.co.in: true
		// user1@domain.com: true
		// user.name@domain.com: true
		// user#@domain.co.in: true
		// user@domaincom: true
		// user#domain.com: false
		// @yahoo.com: false
	}

	/**
	 * <p>
	 * Adding Restrictions on User Name part.
	 * </p>
	 * <strong>Regex: ^[A-Za-z0-9+_.-]+@(.+)$</strong>
	 * 
	 * <pre>
	 * In this regex, we have added some restriction osn username part of email address.
	 * Restrictions in above regex are:
	 * 1) A-Z characters allowed
	 * 2) a-z characters allowed
	 * 3) 0-9 numbers allowed
	 * 4) Additionally email may contain only dot(.), dash(-) and underscore(_)
	 * 5) Rest all characters are not allowed
	 * </pre>
	 */
	public static void validate02() {
		List<String> emails = new ArrayList<String>();
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user1@domain.com");
		emails.add("user.name@domain.com");
		emails.add("user_name@domain.co.in");
		emails.add("user-name@domain.co.in");
		emails.add("user@domaincom");

		// Invalid emails
		emails.add("@yahoo.com");

		final String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		for (String email : emails) {
			Matcher matcher = pattern.matcher(email);
			System.out.println(email + ": " + matcher.matches());
		}

		// Output:
		// user@domain.com: true
		// user@domain.co.in: true
		// user1@domain.com: true
		// user.name@domain.com: true
		// user_name@domain.co.in: true
		// user-name@domain.co.in: true
		// user@domaincom: true
		// @yahoo.com: false
	}

	/**
	 * <p>
	 * Regex allowing email addresses permitted by RFC 5322.
	 * </p>
	 * <strong>Regex: ^[a-zA-Z0-9_!#$%&'*+/=?'{|}~^.-]+@[a-zA-Z0-9.-]+$</strong>
	 * 
	 * <pre>
	 * This regex example uses all the characters permitted by RFC 5322, which governs the email message format.
	 * Among the permitted characters are some that present a security risk if passed directly from user input
	 * to an SQL statement, such as the single quote (') and the pipe character (|). You should be sure to escape
	 * sensitive characters when inserting the email address into a string passed to another program, in order to
	 * prevent security holes such as SQL injection attacks.
	 * </pre>
	 */
	public static void validate03() {
		List<String> emails = new ArrayList<String>();
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user.name@domain.com");
		emails.add("user?name@domain.co.in");
		emails.add("user'name@domain.co.in");

		// Invalid emails
		emails.add("@yahoo.com");

		final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?'{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		for (String email : emails) {
			Matcher matcher = pattern.matcher(email);
			System.out.println(email + ": " + matcher.matches());
		}

		// Output:
		// user@domain.com: true
		// user@domain.co.in: true
		// user.name@domain.com: true
		// user?name@domain.co.in: true
		// user'name@domain.co.in: true
		// @yahoo.com: false
	}

	/**
	 * <p>
	 * Regex to restrict leading, trailing, or consecutive dots in emails.
	 * </p>
	 * <strong>Regex:
	 * ^[a-zA-Z0-9_!#$%&'*+/=?'{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?'{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0
	 * -9-]+)*$</strong>
	 * 
	 * <pre>
	 * Both the local part and the domain name can contain one or more dots,
	 * but no two dots can appear right next to each other. Furthermore, the first and last characters in
	 * the local part and in the domain name must not be dots:
	 * </pre>
	 */
	public static void validate04() {
		List<String> emails = new ArrayList<String>();
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user.name@domain.com");
		emails.add("user'name@domain.co.in");

		// Invalid emails
		emails.add(".username@yahoo.com");
		emails.add("username@yahoo.com.");
		emails.add("username@yahoo..com");

		final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?'{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?'{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

		Pattern pattern = Pattern.compile(regex);

		for (String email : emails) {
			Matcher matcher = pattern.matcher(email);
			System.out.println(email + ": " + matcher.matches());
		}

		// Output:
		// user@domain.com : true
		// user@domain.co.in : true
		// user.name@domain.com : true
		// user'name@domain.co.in : true
		// .username@yahoo.com : false
		// username@yahoo.com. : false
		// username@yahoo..com : false
	}

	/**
	 * <p>
	 * Recommended : Regex to restrict no. of characters in top level domain.
	 * </p>
	 * <strong>Regex:
	 * ^[\\w!#$%&'*+/=?'{|}~^-]+(?:\\.[\\w!#$%&'*+/=?'{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$</strong>
	 * 
	 * <pre>
	 * Now lets modify the regex such that domain name must include at least one dot, and that the part
	 * of the domain name after the last dot can only consist of letters.
	 * Let's say domain names are like secondlevel.com or thirdlevel.secondlevel.com.
	 * The top-level domain (.com in these examples) must consist of two to six letters only.
	 * </pre>
	 */
	public static void validate05() {
		List<String> emails = new ArrayList<String>();
		emails.add("user@domain.com");
		emails.add("user@domain.co.in");
		emails.add("user.name@domain.com");
		emails.add("user_name@domain.com");
		emails.add("username@yahoo.corporate.in");

		// Invalid emails
		emails.add(".username@yahoo.com");
		emails.add("username@yahoo.com.");
		emails.add("username@yahoo..com");
		emails.add("username@yahoo.c");
		emails.add("username@yahoo.corporate");

		final String regex = "^[\\w!#$%&'*+/=?'{|}~^-]+(?:\\.[\\w!#$%&'*+/=?'{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		for (String email : emails) {
			Matcher matcher = pattern.matcher(email);
			System.out.println(email + ": " + matcher.matches());
		}

		// Output:
		// user@domain.com: true
		// user@domain.co.in: true
		// user.name@domain.com: true
		// user_name@domain.com: true
		// username@yahoo.corporate.in: true
		// .username@yahoo.com: false
		// username@yahoo.com.: false
		// username@yahoo..com: false
		// username@yahoo.c: false
		// username@yahoo.corporate: false
	}

	private ValidateEmailAddress() {
	}
}
