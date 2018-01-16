/*
 * FILENAME Propertiess.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package datatypes;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class Propertiess {

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
		Properties capitals = new Properties();
		Set<Object> states;
		String str;

		capitals.put("Illinois", "Springfield");
		capitals.put("Missouri", "Jefferson City");
		capitals.put("Washington", "Olympia");
		capitals.put("California", "Sacramento");
		capitals.put("Indiana", "Indianapolis");

		// Show all states and capitals in hashtable.
		states = capitals.keySet(); // get set-view of keys
		Iterator<Object> itr = states.iterator();
		while (itr.hasNext()) {
			str = (String) itr.next();
			System.out.println("The capital of " + str + " is " + capitals.getProperty(str) + ".");
		}
		System.out.println();

		// look for state not in list -- specify default
		str = capitals.getProperty("Florida", "Not Found");
		System.out.println("The capital of Florida is " + str + ".");
	}

}
