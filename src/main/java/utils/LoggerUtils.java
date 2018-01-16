package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggerUtils {
	public static Logger getLogger(final Class<?> clazz) {
		return LoggerFactory.getLogger(clazz);
	}
}
