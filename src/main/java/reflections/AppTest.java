/*
 * FILENAME AppTest.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package reflections;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class AppTest {
	private int counter;

	public void printIt() {
		System.out.println("printIt() no param");
	}

	public void printItString(String temp) {
		System.out.println("printIt() with param String : " + temp);
	}

	public void printItInt(int temp) {
		System.out.println("printIt() with param int : " + temp);
	}

	public void setCounter(int counter) {
		this.counter = counter;
		System.out.println("setCounter() set counter to : " + counter);
	}

	public void printCounter() {
		System.out.println("printCounter() : " + this.counter);
	}
}
