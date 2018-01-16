/*
 * FILENAME TimeTest.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package sysenv;

import java.util.Calendar;
import java.util.GregorianCalendar;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class TimeTest {

	/**
	 * <p>
	 * Add one-sentence summarising the method functionality here; this sentence should only contain one full-stop.
	 * </p>
	 * 
	 * @param args
	 **/
	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); // Jan = 0, not 1
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);

		int hour = calendar.get(Calendar.HOUR); // 12 hour clock
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);

		System.out.println("year = " + year + "\nmonth = " + month + "\ndayOfMonth = " + dayOfMonth + "\ndayOfWeek = "
				+ dayOfWeek + "\nweekOfYear = " + weekOfYear + "\nweekOfMonth = " + weekOfMonth + "\nhour = " + hour
				+ "\nhourOfDay = " + hourOfDay + "\nminute = " + minute + "\nsecond = " + second + "\nmillisecond = "
				+ millisecond);
		//
		calendar.set(Calendar.YEAR, 2009);
		calendar.set(Calendar.MONTH, 11); // 11 = december
		calendar.set(Calendar.DAY_OF_MONTH, 24); // christmas event

		System.out.println("year = " + calendar.get(Calendar.YEAR) + "\nmonth = " + calendar.get(Calendar.MONTH)
				+ "\ndayOfMonth = " + calendar.get(Calendar.DAY_OF_MONTH));

		try {
			float kq = 0;
			kq = 5 / 0;
			System.out.println("kq = " + kq);
		} catch (NullPointerException e) {
			System.err.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		}
	}

}
