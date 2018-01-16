/*
 * FILENAME Stacks.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package datatypes;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * Dictionary is an abstract class that represents a key/value storage repository and operates much like Map. Given a
 * key and value, you can store the value in a Dictionary object. Once the value is stored, you can retrieve it by using
 * its key. Thus, like a map, a dictionary can be thought of as a list of key/value pairs. The abstract methods defined
 * by Dictionary are listed below:
 */
public class Stacks {

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
		// SN Methods with Description
		// 1 Enumeration elements( )
		// Returns an enumeration of the values contained in the dictionary.
		// 2 Object get(Object key)
		// Returns the object that contains the value associated with key. If key is not in the dictionary, a null
		// object is returned.
		// 3 boolean isEmpty( )
		// Returns true if the dictionary is empty, and returns false if it contains at least one key.
		// 4 Enumeration keys( )
		// Returns an enumeration of the keys contained in the dictionary.
		// 5 Object put(Object key, Object value)
		// Inserts a key and its value into the dictionary. Returns null if key is not already in the dictionary;
		// returns the previous value associated with key if key is already in the dictionary.
		// 6 Object remove(Object key)
		// Removes key and its value. Returns the value associated with key. If key is not in the dictionary, a null is
		// returned.
		// 7 int size( )
		// Returns the number of entries in the dictionary.

		// The Dictionary class is obsolete. You should implement the Map interface to obtain key/value storage
		// functionality.
	}

}
