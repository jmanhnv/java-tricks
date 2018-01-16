/*
 * FILENAME EnvMap.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package sysenv;

import java.util.Map;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * Class to retrieve environment variable values.
 */
public class EnvMap {
	/**
	 * Without an argument, getenv returns a read-only instance of java.util.Map, where the map keys are the environment
	 * variable names, and the map values are the environment variable values.
	 */
	public static void main(String[] args) {
		final Map<String, String> env = System.getenv();
		for (String envName : env.keySet())
			System.out.format("%s=%s%n", envName, env.get(envName));

		//
		test(args);
	}

	/**
	 * With a String argument, getenv returns the value of the specified variable. If the variable is not defined,
	 * getenv returns null.
	 */
	private static void test(String[] args) {
		for (String env : args) {
			final String value = System.getenv(env);
			if (value != null) System.out.format("%s=%s%n", env, value);
			else System.out.format("%s is" + " not assigned.%n", env);
		}
	}
}
