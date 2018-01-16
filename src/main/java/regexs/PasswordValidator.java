/*
 * FILENAME PasswordValidator.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2009 VietinBank Group. All rights reserved. This software is the confidential and proprietary information of
 * VietinBank Group ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with VietinBank Group.
 */

package regexs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * How to build regex based password validator in java.
 * </p>
 * 
 * <pre>
 * Regular expression used
 * </pre>
 * <ol>
 * ((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})
 * </ol>
 * <p>
 * (?=.*[a-z]) : This matches the presence of at least one lowercase letter. (?=.*d) : This matches the presence of at
 * least one digit i.e. 0-9. (?=.*[@#$%]): This matches the presence of at least one special character. ((?=.*[A-Z]):
 * This matches the presence of at least one capital letter. {6,16} : This limits the length of password from minimum 6
 * letters to maximum 16 letters.
 * </p>
 * 
 * @see http://howtodoinjava.com/2012/12/14/how-to-build-regex-based-password-validator-in-java/
 * @author manhnv
 * @version 1.0
 **/
public class PasswordValidator {
	private static PasswordValidator INSTANCE = new PasswordValidator();
	private static String pattern = null;

	/**
	 * No one can make a direct instance.
	 */
	private PasswordValidator() {
		// do nothing
	}

	/**
	 * Force the user to build a validator using this way only.
	 */
	public static PasswordValidator buildValidator(boolean forceSpecialChar, boolean forceCapitalLetter,
			boolean forceNumber, int minLength, int maxLength) {
		StringBuilder patternBuilder = new StringBuilder("((?=.*[a-z])");

		if (forceSpecialChar) {
			patternBuilder.append("(?=.*[@#$%])");
		}

		if (forceCapitalLetter) {
			patternBuilder.append("(?=.*[A-Z])");
		}

		if (forceNumber) {
			patternBuilder.append("(?=.*d)");
		}

		patternBuilder.append(".{" + minLength + "," + maxLength + "})");
		pattern = patternBuilder.toString();

		return INSTANCE;
	}

	/**
	 * Here we will validate the password.
	 */
	public static boolean validatePassword(final String password) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(password);
		return m.matches();
	}
}
