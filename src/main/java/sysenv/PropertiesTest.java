/*
 * FILENAME PropertiesTest.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package sysenv;

import java.io.FileInputStream;
import java.util.Properties;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

// https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
public class PropertiesTest {
	public static void main(String[] args) throws Exception {
		// set up new properties object from file "MyFile.txt"
		FileInputStream propFile = new FileInputStream("MyFile.txt");
		Properties p = new Properties(System.getProperties());
		p.load(propFile);

		// set the system properties
		System.setProperties(p);
		// display new properties
		System.getProperties().list(System.out);
	}

}
