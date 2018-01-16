/*
 * FILENAME Validation.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package commons;

import com.google.common.base.Strings;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * Utility class contains Common helper methods.
 * </p>
 * 
 * @author manhnv
 * @version 0.1
 **/
public final class Validation {
	/**
	 * <p>
	 * Check the string value is numeric.
	 * </p>
	 * 
	 * @param str
	 *            the value will be checked
	 * @return true if value as numeric else false
	 */
	public static boolean isNumeric(final String str) {
		if (Strings.isNullOrEmpty(str)) return false;

		return str.matches("[+-]?\\d*(\\.\\d+)?");
	}

	/**
	 * <p>
	 * Default constructor.
	 * </p>
	 */
	private Validation() {
	}
}
