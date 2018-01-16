package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.common.base.Strings;

import constants.Const;

public final class JDates implements Const {
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final SimpleDateFormat dateFormatter = getSimpleDf();

	public static long MIN_IN_MILLIS = 60000;
	public static long HOUR_IN_MILLIS = 3600000;
	public static long DAY_IN_MILLIS = 86400000;
	public static int MINUTE_IN_SECONDS = 60;
	public static int HOUR_IN_MINUTES = 60;
	public static int DAY_IN_MINUTES = 1440;

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

	public static String dateToString(final Date date) {
		if (date == null) return EMPTY;

		return dateFormatter.format(date);
	}

	private static SimpleDateFormat getSimpleDf() {
		return new SimpleDateFormat(DATE_FORMAT);
	}

	public static SimpleDateFormat getSimpleDf(final String pattern) {
		if (Strings.isNullOrEmpty(pattern)) return getSimpleDf();

		return new SimpleDateFormat(pattern);
	}
}
