/*
 * FILENAME ListEnvsProps.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2009 VSII. All rights reserved. This software is the confidential and proprietary information of VSII
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with VSII.
 */

package sysenv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class ListEnvsProps {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		System.err.println("===== SYSTEM ENV VARIABLES =====");
		printVars(System.getenv());

		System.err.println("===== SYSTEM PROPERTIES =====");
		printVars(new HashMap(System.getProperties()));

		System.err.println("===== OTHER WAYS =====");
		show();
	}

	private static void printVars(Map<String, ?> m) {
		List<String> keys = new ArrayList<String>(m.keySet());
		Collections.sort(keys);

		for (String k : keys)
			System.out.println(k + ": " + m.get(k));
	}

	private static void show() {
		Properties p = System.getProperties();
		Enumeration<Object> keys = p.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String value = (String) p.get(key);
			System.out.println(key + ": " + value);
		}
	}
}
