package utils;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Strings;

public final class JCollections {
	public static final boolean isEmpty(final Collection<?> collects) {
		return !isNotEmpty(collects);
	}

	public static final boolean isNotEmpty(final Collection<?> collects) {
		return (collects != null && !collects.isEmpty());
	}

	public static final boolean contains(final Collection<?> collects, final Object obj) {
		return (isNotEmpty(collects) && collects.contains(obj));
	}

//	public static String listToString(final List<String> strings) {
//		return org.springframework.util.StringUtils.collectionToCommaDelimitedString(strings);
//	}
//
//	public static String listToString(final List<String> strings, final String delim) {
//		if (Strings.isNullOrEmpty(delim)) return listToString(strings);
//
//		return org.springframework.util.StringUtils.collectionToDelimitedString(strings, delim);
//	}
//
//	public static String setToString(final Set<String> strings) {
//		return org.springframework.util.StringUtils.collectionToCommaDelimitedString(strings);
//	}
//
//	public static String setToString(final Set<String> strings, final String delim) {
//		if (Strings.isNullOrEmpty(delim)) return setToString(strings);
//
//		return org.springframework.util.StringUtils.collectionToDelimitedString(strings, delim);
//	}
}
