package commons;

import constants.Const;

public final class MsgFormat implements Const {
	public static String format(final Object... params) {
		if (params == null) return EMPTY;

		String s = System.out.format("", params).toString();
		return s;
	}
}
