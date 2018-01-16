package commons;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class I18n {
	private static ResourceBundle resourceBundle;

	/**
	 * <p>
	 * Resolve a message by a key.
	 * </p>
	 * 
	 * @param key
	 *            the message to look up
	 * @return the resolved message
	 **/
	public static String get(final String key) {
		if (resourceBundle == null) resourceBundle = ResourceBundle.getBundle("i18n.messages");

		return resourceBundle.getString(key);
	}

	/**
	 * <p>
	 * Resolve a message by a key and argument replacements.
	 * </p>
	 * 
	 * @see MessageFormat#format(String, Object...)
	 * @param key
	 *            the message to look up
	 * @param args
	 *            optional message arguments
	 * @return the resolved message
	 **/
	public static String get(final String key, final Object... args) {
		if (key == null) throw new IllegalArgumentException("Message key must not null");

		try {
			String msg = resourceBundle.getString(key.trim()).trim();
			return (args == null || args.length == 0) ? msg : MessageFormat.format(msg, args);
		} catch (MissingResourceException mre) {
			return '!' + key + '!';
		}
	}

	private I18n() {
	}

}
