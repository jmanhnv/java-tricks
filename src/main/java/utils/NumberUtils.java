package utils;

public final class NumberUtils {
	// Anonymous - We DO NOT Forgive. We DO NOT Forget
	// Never give up. Never say die
	public static boolean isEvenNumber(final int i) {
		if ((i & 1) == 0) /* Print Even number */ return true;
		return false;/* Print Odd number */
	}

	public static double nullToZero(Double aNumber) {
		return aNumber == null ? 0 : aNumber;
	}

	public static double nullToZero(Integer aNumber) {
		return aNumber == null ? 0 : aNumber;
	}
}
