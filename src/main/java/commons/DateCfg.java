/*
 * FILENAME DateCfg.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * A central place for all UI Configurations.
 * </p>
 * <p>
 * NOTE: This class MUST be thread-safe
 * </p>
 * 
 * @author manhnv
 * @version 0.1
 **/
public class DateCfg {
	private static final Logger LOG = LoggerFactory.getLogger(DateCfg.class);

	private static DateCfg instance;

	private String dateFormat = "dd MMM yyyy"; //$NON-NLS-1$
	private String timeFormat = "HH:mm"; //$NON-NLS-1$
	private String dateTimeFormat = "dd MMM yyyy HH:mm"; //$NON-NLS-1$
	private String df = DATE_FORMAT;

	public static long SECONDS_PER_MINUTE = 60;
	public static long MINUTES_PER_HOUR = 60;// 60*1
	public static int MINUTES_PER_DAY = 1440; // 60*24
	public static long MILLISECONDS_PER_MINUTE = 60000; // 60*1000
	public static long MILLISECONDS_PER_HOUR = 3600000; // 60*60*1000
	public static long MILLISECONDS_PER_DAY = 86400000; // 60*60*24*1000;

	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String TIME_STAMP_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
	public static final SimpleDateFormat mmyyyyFormater = new SimpleDateFormat("MM/yyyy");
	public static final SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm:ss");
	public static final SimpleDateFormat shortTimeFormatter = new SimpleDateFormat("HH:mm");
	public static final SimpleDateFormat datetimeFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static final SimpleDateFormat datetimeFormatter2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public static final SimpleDateFormat timeStampFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	public static final SimpleDateFormat timeStampFormatter2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	public static final SimpleDateFormat timeStampFormatter3 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat timeStampFormatter4 = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat timeStampSequence = new SimpleDateFormat("yyyyMMdd_HHmmss");

	private boolean internal = false;
	private Map<String, String> configs = new HashMap<String, String>();

	/**
	 * <p>
	 * Default constructor.
	 * </p>
	 **/
	public DateCfg() {
		if (instance == null || instance.internal) instance = this;
	}

	/**
	 * <p>
	 * This will return a singleton of the configuration set.
	 * </p>
	 *
	 * @return a singleton of the DateCfg.
	 */
	static DateCfg get() {
		if (instance == null) {
			LOG.debug("Creating default instance of DateCfg."); //$NON-NLS-1$
			new DateCfg();
			instance.internal = true;
		}
		return instance;
	}

	/**
	 * <p>
	 * Return configured date format, default to dd MMM yyyy.
	 * </p>
	 *
	 * @return date format as string
	 */
	public static String getDateFormat() {
		return get().dateFormat;
	}

	/**
	 * <p>
	 * Configure the date format to be used across the application.
	 * </p>
	 *
	 * @param newDateFormat
	 *            the new date format to set
	 */
	public void setDateFormat(final String newDateFormat) {
		this.dateFormat = newDateFormat;
	}

	/**
	 * <p>
	 * Return configured time format, default to HH:mm.
	 * </p>
	 *
	 * @return time format
	 */
	public static String getTimeFormat() {
		return get().timeFormat;
	}

	/**
	 * <p>
	 * Configure the time format to be used across the application.
	 * </p>
	 *
	 * @param newTimeFormat
	 *            the new time format to set
	 */
	public void setTimeFormat(final String newTimeFormat) {
		this.timeFormat = newTimeFormat;
	}

	/**
	 * <p>
	 * Return configured date and time format, default to dd MMM yyyy HH:mm.
	 * </p>
	 *
	 * @return date and time format
	 */
	public static String getDateTimeFormat() {
		return get().dateTimeFormat;
	}

	/**
	 * <p>
	 * Configure the date and time format to be used across the application.
	 * </p>
	 *
	 * @param newDateTimeFormat
	 *            the new date and time format to set
	 */
	public void setDateTimeFormat(final String newDateTimeFormat) {
		this.dateTimeFormat = newDateTimeFormat;
	}

	/**
	 * <p>
	 * Configure custom configuration as key-value pair.
	 * </p>
	 *
	 * @param newConfigs
	 *            configuration to set
	 **/
	public void setConfigs(final Map<String, String> newConfigs) {
		this.configs = newConfigs == null ? new HashMap<String, String>() : newConfigs;
	}

	// HELPER METHODS

	/**
	 * <p>
	 * Format the given date value according to current dateFormat.
	 * </p>
	 *
	 * @see #getDateFormat()
	 * @see #setDateFormat(String)
	 * @param date
	 *            the date to be formatted
	 * @return formatted string. Empty string if null date is given.
	 */
	public static String formatDate(final Date date) {
		if (date == null) return ""; //$NON-NLS-1$
		return new SimpleDateFormat(get().dateFormat).format(date);
	}

	/**
	 * <p>
	 * Format the given date value according to current dateFormat.
	 * </p>
	 *
	 * @see #getDateFormat()
	 * @see #setDateFormat(String)
	 * @param date
	 *            the date to be formatted
	 * @return formatted string. Empty string if null date is given.
	 */
	public static String formatDateToString(final Date date) {
		if (date == null) return ""; //$NON-NLS-1$
		return new SimpleDateFormat(get().df).format(date);
	}

	/**
	 * <p>
	 * Format the given date value according to current timeFormat.
	 * </p>
	 *
	 * @see #getTimeFormat()
	 * @see #setTimeFormat(String)
	 * @param date
	 *            the date to be formatted
	 * @return formatted string. Empty string if null date is given.
	 */
	public static String formatTime(final Date date) {
		if (date == null) return ""; //$NON-NLS-1$
		return new SimpleDateFormat(get().timeFormat).format(date);
	}

	/**
	 * <p>
	 * Format the given date value according to current dateTimeFormat.
	 * </p>
	 *
	 * @see #getDateTimeFormat()
	 * @see #setDateFormat(String)
	 * @param date
	 *            the date to be formatted
	 * @return formatted string. Empty string if null date is given.
	 */
	public static String formatDateTime(final Date date) {
		if (date == null) return ""; //$NON-NLS-1$
		return new SimpleDateFormat(get().dateTimeFormat).format(date);
	}

	/**
	 * <p>
	 * Retrieve a configurable value using key.
	 * </p>
	 *
	 * @param key
	 *            the lookup key
	 * @return the value if found. Otherwise, null is returned.
	 **/
	public static String getConfig(final String key) {
		if (key == null) return null;
		Calendar.getInstance().getTimeInMillis();
		return get().configs.get(key);
	}

	public static Date convertDateStrToDate(final String dateInString) {
		if (Strings.isNullOrEmpty(dateInString)) return null;

		try {
			return dateFormatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int daysBetween(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	public static long getDayCount(String start, String end) {
		long diff = -1;
		try {
			Date dateStart = dateFormatter.parse(start);
			Date dateEnd = dateFormatter.parse(end);

			// time is always 00:00:00 so rounding should help to ignore the
			// missing hour when going from winter to summer time as well as the
			// extra hour in the other direction
			diff = Math.round((dateEnd.getTime() - dateStart.getTime()) / (double) 86400000);
		} catch (Exception e) {
			// handle the exception according to your own situation
		}
		return diff;
	}

	public static void daysBetween(long t1, long t2) {
		int diff = (int) (t2 - t1);

		long diffSeconds = diff / 1000;
		long diffMinutes = diff / (60 * 1000);
		long diffHours = diff / (60 * 60 * 1000);
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.println("diffSeconds difference = " + diffSeconds);
		System.out.println("diffMinutes difference = " + diffMinutes);
		System.out.println("diffHours difference = " + diffHours);
		System.out.println("diffDays difference = " + diffDays);
	}

	// Now calculate the difference between these two Calendar objects
	public static int monthsBetween(Calendar firstDate, Calendar secondDate) {
		int months = (firstDate.get(Calendar.YEAR) - secondDate.get(Calendar.YEAR)) * 12
				+ (firstDate.get(Calendar.MONTH) - secondDate.get(Calendar.MONTH))
				+ (firstDate.get(Calendar.DAY_OF_MONTH) >= secondDate.get(Calendar.DAY_OF_MONTH) ? 0 : -1);
		System.out.println("Diff is.." + months);
		return months;
	}

	public static int[] getDateDifferenceInDDMMYYYY(Date date1, Date date2) {

		int[] monthDay = { 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Calendar fromDate;
		Calendar toDate;
		int increment = 0;
		int[] ageDiffArr = new int[3];

		int year;
		int month;
		int day;

		Calendar d1 = GregorianCalendar.getInstance();
		d1.setTime(date1);

		Calendar d2 = GregorianCalendar.getInstance();
		d2.setTime(date2);

		if (d1.getTime().getTime() > d2.getTime().getTime()) {
			fromDate = d2;
			toDate = d1;
		} else {
			fromDate = d1;
			toDate = d2;
		}

		if (fromDate.get(Calendar.DAY_OF_MONTH) > toDate.get(Calendar.DAY_OF_MONTH)) {
			increment = monthDay[fromDate.get(Calendar.MONTH)];
		}

		GregorianCalendar cal = new GregorianCalendar();
		boolean isLeapYear = cal.isLeapYear(fromDate.get(Calendar.YEAR));

		if (increment == -1) {
			if (isLeapYear) {
				increment = 29;
			} else {
				increment = 28;
			}
		}

		// DAY CALCULATION
		if (increment != 0) {
			day = (toDate.get(Calendar.DAY_OF_MONTH) + increment) - fromDate.get(Calendar.DAY_OF_MONTH);
			increment = 1;
		} else {
			day = toDate.get(Calendar.DAY_OF_MONTH) - fromDate.get(Calendar.DAY_OF_MONTH);
		}

		// MONTH CALCULATION
		if ((fromDate.get(Calendar.MONTH) + increment) > toDate.get(Calendar.MONTH)) {
			month = (toDate.get(Calendar.MONTH) + 12) - (fromDate.get(Calendar.MONTH) + increment);
			increment = 1;
		} else {
			month = (toDate.get(Calendar.MONTH)) - (fromDate.get(Calendar.MONTH) + increment);
			increment = 0;
		}

		// YEAR CALCULATION
		year = toDate.get(Calendar.YEAR) - (fromDate.get(Calendar.YEAR) + increment);

		ageDiffArr[0] = day;
		ageDiffArr[1] = month;
		ageDiffArr[2] = year;

		return ageDiffArr; // RESULT AS DAY, MONTH AND YEAR in form of Array
	}

	@SuppressWarnings("unused")
	public static boolean isLeapYear(final Date date) {
		if (date == null) return false;

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1; // Note: zero based! because
													// month from 0 to 11
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int millis = cal.get(Calendar.MILLISECOND);

		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
	}
}
