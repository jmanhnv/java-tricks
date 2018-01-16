package sysenv;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.google.common.base.Strings;

public class LocalesList {

	static public void main(String[] args) {
		// -- Get system environment
		// String[] allTimeZoneIds = TimeZone.getAvailableIDs();
		// Locale[] sLocales = SimpleDateFormat.getAvailableLocales();
		// Locale[] dLocales = DateFormat.getAvailableLocales();
		// Map<String, String> env = System.getenv();

		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		Set<String> set = new TreeSet<String>();
		for (int i = 0; i < locales.length; i++) {
			if (!Strings.isNullOrEmpty(locales[i].getDisplayName()) && !Strings.isNullOrEmpty(locales[i].toString()))
				set.add(locales[i].getDisplayName() + ":" + locales[i].toString());
		}
		Iterator<?> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
