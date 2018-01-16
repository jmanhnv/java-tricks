/*
 * FILENAME TestEnumerated.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package sysenv;

import enums.EnumType;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class TestEnumerated {
	/**
	 * <p>
	 * Execute main method.
	 * </p>
	 * 
	 * @param args
	 **/
	public static void main(String[] args) {
		for (EnumType.ContactType params : EnumType.ContactType.values()) {
			System.out.println("ordinal = " + EnumType.ContactType.values()[params.ordinal()]);
			System.out.println(params.ordinal() + ": " + params.toString());
			System.out.println("*** end of " + params.ordinal() + " ***");
		}
	}

}
