package model;

import java.util.Comparator;

/*
 * FILENAME Person.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class PersonEx implements Comparator<PersonEx> {
	private int id;
	private String name;

	/**
	 * <p>
	 * Constructor.
	 * </p>
	 * 
	 * @param id
	 * @param name
	 **/
	public PersonEx(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * <p>
	 * Getter for id.
	 * </p>
	 * 
	 * @return the id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * <p>
	 * Setting value for id.
	 * </p>
	 * 
	 * @param id
	 *            the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}

	/**
	 * <p>
	 * Getter for name.
	 * </p>
	 * 
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * <p>
	 * Setting value for name.
	 * </p>
	 * 
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	public int compare(PersonEx left, PersonEx right) {
		return (left.getId() < right.getId()) ? -1 : (left.getId() > right.getId()) ? 1 : 0;
	}

	@Override
	public String toString() {
		return getName();
	}

}
