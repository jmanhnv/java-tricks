/*
 * FILENAME SystemEvnJava.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package sysenv;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class SystemEvnJava {

	/**
	 * <p>
	 * Add one-sentence summarising the method functionality here; this sentence should only contain one full-stop.
	 * </p>
	 * <p>
	 * Add detailed HTML description of method here, including the following, where relevant:
	 * <ul>
	 * <li>Description of what the method does and how it is done.</li>
	 * <li>Details on which error conditions may occur.</li>
	 * </ul>
	 * </p>
	 * 
	 * @since TODO module version when it was introduced
	 * @param args
	 **/
	public static void main(String[] args) {
		final String[] allTimeZoneIds = TimeZone.getAvailableIDs();
		System.out.println("*** allTimeZoneIds *** ");
		for (int i = 0; i < allTimeZoneIds.length; i++)
			System.out.println(allTimeZoneIds[i]);
		System.out.println("********************** ");

		final Locale locale1[] = SimpleDateFormat.getAvailableLocales();
		System.out.println("*** Locale for SimpleDateFormat *** ");
		for (int i = 0; i < locale1.length; i++)
			System.out.println(locale1[i]);
		System.out.println("********************** ");

		final Locale locale2[] = DateFormat.getAvailableLocales();
		System.out.println("*** Locale for DateFormat *** ");
		for (int i = 0; i < locale2.length; i++)
			System.out.println(locale2[i]);
		System.out.println("********************** ");

		final Map<String, String> env = System.getenv();
		System.out.println("*** env *** ");
		for (String envName : env.keySet())
			System.out.format("%s=%s%n", envName, env.get(envName));
		System.out.println("********************** ");
	}

}
