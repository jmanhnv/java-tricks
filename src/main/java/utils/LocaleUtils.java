package utils;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

import constants.Const;

public final class LocaleUtils implements Const {
	public static Locale getCurrent() {
		Locale locale = LocaleContextHolder.getLocale();
		if (locale == null) return VI_LOCALE;
		return locale;
	}

	public static String getLang() {
		Locale locale = getCurrent();
		return locale.getLanguage() + HYPHEN + locale.getCountry();
	}
}
