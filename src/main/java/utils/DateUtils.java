package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DateUtils {
	public String dateFormat = "dd MMM yyyy"; //$NON-NLS-1$
	public String timeFormat = "HH:mm"; //$NON-NLS-1$
	public String dateTimeFormat = "dd MMM yyyy HH:mm"; //$NON-NLS-1$

	public static final int MONTHS_IN_YEAR = 12;
	public static final long SECONDS_PER_MINUTE = 60;
	public static final long MINUTES_PER_HOUR = 60;// 60*1
	public static final int MINUTES_PER_DAY = 1440; // 60*24
	public static final long MILLISECONDS_PER_SECOND = 1000; // 1000
	public static final long MILLISECONDS_PER_MINUTE = 60000; // 60*1000
	public static final long MILLISECONDS_PER_HOUR = 3600000; // 60*60*1000
	public static final long MILLISECONDS_PER_DAY = 86400000; // 24*60*60*1000;

	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String TIME_STAMP_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"; // ISO
																				// 8601

	public static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
	public static final SimpleDateFormat mmyyyyFormater = new SimpleDateFormat("MM/yyyy");
	public static final SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm:ss");
	public static final SimpleDateFormat shortTimeFormatter = new SimpleDateFormat("HH:mm");
	public static final SimpleDateFormat datetimeFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static final SimpleDateFormat datetimeFormatter2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	public static final SimpleDateFormat hourMinuteFormater = new SimpleDateFormat("HH:mm"); // 24
	// hour
	// clock
	// format
	public static final SimpleDateFormat hourMinuteSecondFormatter = new SimpleDateFormat("HHmmss"); // For
	// Timesheet
	// Import
	// Function
	public static final SimpleDateFormat timeStampFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	public static final SimpleDateFormat timeStampFormatter2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	public static final SimpleDateFormat timeStampFormatter3 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat timeStampFormatter4 = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat timeStampFormatter5 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa"); // for
																												// AM,
																												// PM
	public static final SimpleDateFormat timeStampFormatter6 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // For
	// Labor
	// Clocking
	public static final SimpleDateFormat timeStampSequence = new SimpleDateFormat("yyyyMMdd_HHmmss"); // For
	// Labor
	// Clocking
	public static final Date MIN_DATE;
	public static final Date MAX_DATE;

	static {
		Date minDate = null;
		Date maxDate = null;
		try {
			minDate = dateFormatter.parse("01/01/0001");
			maxDate = dateFormatter.parse("31/12/9999");
		} catch (ParseException e) {
		}
		MIN_DATE = minDate;
		MAX_DATE = maxDate;
	}

	/**
	 * <p>
	 * Calculate the days between two date.
	 * </p>
	 * 
	 * @param d1
	 *            first time period
	 * @param d2
	 *            second time period
	 * @return different day(s)
	 */
	public int daysBetween(final Date d1, final Date d2) {
		if (d1 == null || d2 == null) throw new IllegalArgumentException("d1 and d2 cannot be null");

		return (int) ((d2.getTime() - d1.getTime()) / MILLISECONDS_PER_DAY);
	}

	/**
	 * <p>
	 * Count no of days between two date. Date format must be in 'dd/mm/yyyy'.
	 * </p>
	 * 
	 * @param s1
	 *            first date as string
	 * @param d2
	 *            second date as string
	 * @return count day(s)
	 */
	public static long getDayCount(final String s1, final String s2) {
		if (s1 == null || s2 == null) throw new IllegalArgumentException("s1 and s2 cannot be null");

		long diff = -1;
		try {
			Date d1 = dateFormatter.parse(s1);
			Date d2 = dateFormatter.parse(s2);

			/*
			 * time is always 00:00:00 so rounding should help to ignore the missing hour when going from winter to
			 * summer time as well as the extra hour in the other direction
			 */
			diff = Math.round((d2.getTime() - d1.getTime()) / (double) MILLISECONDS_PER_DAY);
		} catch (Exception e) {
			// handle the exception according to your own situation
		}

		return diff;
	}

	public static void identifyLeaveDateCanApply(final Date leave_date_from, final Date join_date,
			final int min_no_of_months_from_join_date) {
		final int monthsBetween = monthsBetweenTwoDate(leave_date_from, join_date);
		if (monthsBetween < min_no_of_months_from_join_date) {
			Calendar defaultJoinCal = Calendar.getInstance();
			defaultJoinCal.setTime(join_date);

			Calendar leaveCal = Calendar.getInstance();
			leaveCal.setTime(leave_date_from);

			Calendar newJoinCal = Calendar.getInstance();
			newJoinCal.setTime(join_date);
			newJoinCal.add(Calendar.MONTH, min_no_of_months_from_join_date);

			if (min_no_of_months_from_join_date == 1) {
				newJoinCal.set(Calendar.DATE, defaultJoinCal.get(Calendar.DAY_OF_MONTH) - 1);
			} else {
				if (isLeapYear(getYear(newJoinCal.getTime()))
						&& getMonth(defaultJoinCal.getTime()) == getMonth(leaveCal.getTime())
						&& getMonth(defaultJoinCal.getTime()) == 1
						&& defaultJoinCal.get(Calendar.DAY_OF_MONTH) == leaveCal.get(Calendar.DAY_OF_MONTH)) {
					// when year is leap year and join month = leave month =
					// February and join day == leave day then leave date can be
					// applied must after the last day of February
					newJoinCal.set(Calendar.DATE, defaultJoinCal.get(Calendar.DAY_OF_MONTH));
				} else {
					// leave date can be applied must after the join day - 1
					newJoinCal.set(Calendar.DATE, defaultJoinCal.get(Calendar.DAY_OF_MONTH) - 1);
				}
			}

			dateAfterXMonths = newJoinCal.getTime();
		}
	}

	private static Date dateAfterXMonths;

	public String getDateAfterXMonths() {
		return format(DateUtils.dateAfterXMonths);
	}

	public static String format(Date date) {
		if (date == null) return "";
		return dateFormatter.format(date);
	}

	/**
	 * <p>
	 * Method use to calculate no of month(s) between two date.
	 * </p>
	 * 
	 * @param date1
	 *            first date period
	 * @param date2
	 *            second date period
	 * @return different month(s)
	 */
	public static int monthsBetweenTwoDate(final Date date1, final Date date2) {
		if (date1 == null || date2 == null) throw new IllegalArgumentException("date1 and date2 cannot be null");

		Calendar firstDate = Calendar.getInstance();
		firstDate.setTime(date1);
		Calendar secondDate = Calendar.getInstance();
		secondDate.setTime(date2);

		int monthsBetween = (firstDate.get(Calendar.YEAR) - secondDate.get(Calendar.YEAR)) * MONTHS_IN_YEAR
				+ (firstDate.get(Calendar.MONTH) - secondDate.get(Calendar.MONTH))
				+ (firstDate.get(Calendar.DAY_OF_MONTH) >= secondDate.get(Calendar.DAY_OF_MONTH) ? 0 : -1);

		return monthsBetween;
	}

	/**
	 * <p>
	 * Method use to calculate no of month(s) between two calendar period.
	 * </p>
	 * 
	 * @param c1
	 *            first calendar period
	 * @param c2
	 *            second calendar period
	 * @return different month(s)
	 */
	public static int monthsBetweenTwoCalendar(final Calendar c1, final Calendar c2) {
		if (c1 == null || c2 == null) throw new IllegalArgumentException("c1 and c2 cannot be null");

		int monthsBetween = (c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR)) * MONTHS_IN_YEAR
				+ (c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH))
				+ (c1.get(Calendar.DAY_OF_MONTH) >= c2.get(Calendar.DAY_OF_MONTH) ? 0 : -1);
		return monthsBetween;
	}

	/**
	 * Determines if the given year is a leap year.
	 * 
	 * @param date
	 *            the given date.
	 * @return <code>true</code> if the given year is a leap year; <code>false</code> otherwise.
	 */
	public static int[] getDateDiffInDDMMYYYY(Date date1, Date date2) {
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

	/**
	 * Determines if the given year is a leap year.
	 * 
	 * @param date
	 *            the given date.
	 * @return <code>true</code> if the given year is a leap year; <code>false</code> otherwise.
	 */
	public static boolean isLeapYear(final Date date) {
		if (date == null) throw new IllegalArgumentException("date cannot be null");

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		int year = c.get(Calendar.YEAR);

		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
	}

	/**
	 * Determines if the given year is a leap year.
	 * 
	 * @param year
	 *            the given year.
	 * @return <code>true</code> if the given year is a leap year; <code>false</code> otherwise.
	 */
	public static boolean isLeapYear(final int year) {
		return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
	}

	/**
	 * Determines if the given year is a leap year.
	 * 
	 * @param date
	 *            the given date.
	 * @return <code>true</code> if the given date is a leap year; <code>false</code> otherwise.
	 * @see {@link GregorianCalendar - GC}
	 */
	public static boolean isLeapYearByGC(final Date date) {
		if (date == null) throw new IllegalArgumentException("date cannot be null");

		GregorianCalendar gc = new GregorianCalendar();
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		return gc.isLeapYear(c.get(Calendar.YEAR));
	}

	/**
	 * Show Year, Month, Day, Hour, Minute, Second, Millisecond of given date.
	 * 
	 * @param date
	 *            the given date.
	 * @return <code>true</code> if the given year is a leap year; <code>false</code> otherwise.
	 */
	public static void viewaYearMonthDayHourMinuteSecondMillisecByDate(final Date date) {
		if (date == null) throw new IllegalArgumentException("date cannot be null");

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int year = cal.get(Calendar.YEAR);
		// Note: zero based! because month from 0 to 11 like Jan to Dec
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int millis = cal.get(Calendar.MILLISECOND);

		System.out.println("Details: \n\tYear = " + year + "\n\tMonth = " + month + "\n\tDay = " + day + "\n\tHour = "
				+ hour + "\n\tMinute = " + minute + "\n\tSecond = " + second + "\n\tMillisecond = " + millis);
	}

	/**
	 * <p>
	 * Calculate the days between to time period. Time period like as <code>System.currentTimeMillis()</code>.
	 * </p>
	 * 
	 * @param t1
	 *            first time period as milliseconds
	 * @param t2
	 *            second time period as milliseconds
	 */
	public static void viewDiffDayHourMinuteSecondByTime(long t1, long t2) {
		int diff = (int) (t2 - t1);

		long diffSeconds = diff / MILLISECONDS_PER_SECOND;
		long diffMinutes = diff / MILLISECONDS_PER_MINUTE;
		long diffHours = diff / MILLISECONDS_PER_HOUR;
		long diffDays = diff / MILLISECONDS_PER_DAY;

		System.out.println("Details: \n\tDiffDays = " + diffDays + "\n\tDiffHours = " + diffHours + "\n\tDiffMinutes = "
				+ diffMinutes + "\n\tDiffSeconds = " + diffSeconds);
	}

	public static Calendar getCalendar(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setMinimalDaysInFirstWeek(7);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);

		calendar.setTime(date);
		return calendar;
	}

	public static Calendar getCalendar() {
		return getCalendar(new Date());
	}

	public static int getDayOfWeek(Date date) {
		return getCalendar(date).get(Calendar.DAY_OF_WEEK);
	}

	public static int getDayOfWeek(Calendar date) {
		return date.get(Calendar.DAY_OF_WEEK);
	}

	public static int getDayOfMonth(Date date) {
		return getCalendar(date).get(Calendar.DAY_OF_MONTH);
	}

	public static int getDayOfYear(Date date) {
		return getCalendar(date).get(Calendar.DAY_OF_YEAR);
	}

	public static int getWeekOfMonth(Date date) {
		return getCalendar(date).get(Calendar.WEEK_OF_MONTH);
	}

	public static int getWeekOfYear(Date date) {
		return getCalendar(date).get(Calendar.WEEK_OF_YEAR);
	}

	public static int getMonth(Date date) {
		return getCalendar(date).get(Calendar.MONTH);
	}

	/**
	 * January = 1
	 */
	public static int getCalendarMonth(Date date) {
		return getCalendar(date).get(Calendar.MONTH) + 1;
	}

	public static int getYear(Date date) {
		return getCalendar(date).get(Calendar.YEAR);
	}

	public static int getSystemDayOfWeek() {
		return getCalendar().get(Calendar.DAY_OF_WEEK);
	}

	public static int getSystemDayOfMonth() {
		return getCalendar().get(Calendar.DAY_OF_MONTH);
	}

	public static int getSystemDayOfYear() {
		return getCalendar().get(Calendar.DAY_OF_YEAR);
	}

	public static int getSystemWeekOfMonth() {
		return getCalendar().get(Calendar.WEEK_OF_MONTH);
	}

	public static int getSystemWeekOfYear() {
		return getCalendar().get(Calendar.WEEK_OF_YEAR);
	}

	public static java.sql.Date getSystemDate() {
		return sqlDate(new Date());
	}

	public Date getCurrentSystemDatetime() {
		return new Date();
	}

	public String getCurrentSystemDateTimeAsString() {
		return datetimeFormatter2.format(this.getCurrentSystemDatetime());
	}

	public String getCurrentSystemTimeStamp() {
		return timeStampFormatter6.format(new Date());
	}

	/**
	 * Intended to be used from facelets
	 */
	public java.sql.Date getCurrentSystemDate() {
		return sqlDate(new Date());
	}

	public static java.sql.Time getSystemTime() {
		return new java.sql.Time(System.currentTimeMillis());
	}

	public static java.sql.Timestamp getSystemDatetime() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}

	public static int getSystemYear() {
		return getCalendar().get(Calendar.YEAR);
	}

	public static int getSystemMonth() {
		return getCalendar().get(Calendar.MONTH);
	}

	public static int getWeekCode(Date date) {
		Calendar calendar = getCalendar(date);
		if (calendar.get(Calendar.WEEK_OF_YEAR) == 52 || calendar.get(Calendar.WEEK_OF_YEAR) == 53) {
			if (calendar.get(Calendar.MONTH) == 0)
				return (calendar.get(Calendar.YEAR) - 1) * 100 + calendar.get(Calendar.WEEK_OF_YEAR);
		} else if (calendar.get(Calendar.WEEK_OF_YEAR) == 1) {
			if (calendar.get(Calendar.MONTH) == 11)
				return (calendar.get(Calendar.YEAR) + 1) * 100 + calendar.get(Calendar.WEEK_OF_YEAR);
		} else if (calendar.get(Calendar.WEEK_OF_YEAR) == 1) {
			if (calendar.get(Calendar.MONTH) == 11)
				return (calendar.get(Calendar.YEAR) + 1) * 100 + calendar.get(Calendar.WEEK_OF_YEAR);
		}
		return calendar.get(Calendar.YEAR) * 100 + calendar.get(Calendar.WEEK_OF_YEAR);
	}

	public static boolean sameWeek(Date date1, Date date2) {
		return getWeekCode(date1) == getWeekCode(date2);
	}

	public static int getSystemWeekCode() {
		return getWeekCode(getCalendar().getTime());
	}

	public static java.sql.Date sqlDate(Date date) {
		if (date == null) return null;

		Calendar calendar = getCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return new java.sql.Date(calendar.getTimeInMillis());
	}
}
