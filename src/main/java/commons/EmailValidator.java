package commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import constants.Const;

public class EmailValidator implements Const {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\."
			+ "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" + "(\\.[A-Za-z]{2,})$";

	@SuppressWarnings("unused")
	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	// ^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$
	// ^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$

	private static Pattern pattern;
	private static Matcher matcher;

	public EmailValidator() {
	}

	public static boolean isValidEmail_01(final String value, final String pattern_exp) {
		// pattern = Pattern.compile(EMAIL_PATTERN);
		pattern = Pattern.compile(pattern_exp);
		matcher = pattern.matcher(value);
		if (!matcher.matches()) { return false; }
		return true;
	}

	public static void main(String[] args) {
		String email = EMPTY;
		isValidEmail_01(email, EMAIL_PATTERN);
	}
}
