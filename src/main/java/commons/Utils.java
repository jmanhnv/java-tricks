/*
 * FILENAME Utils.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2005 vietsoftware international Inc. All rights reserved. This software is the confidential and proprietary
 * information of VSII ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with VSII.
 */

package commons;

import java.io.UnsupportedEncodingException;

import com.google.common.base.Strings;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * The class for purpose of {@link Utils}.
 * </p>
 * 
 * @version 1.0
 * @author manhnv
 **/
public class Utils {
	public static String toUtf8(final String unicode) {
		String strUtf8 = "";
		if (Strings.isNullOrEmpty(unicode)) return strUtf8;

		try {
			// Convert from Unicode to UTF-8
			byte[] utf8 = unicode.getBytes("UTF-8");
			// Convert from UTF-8 to Unicode
			strUtf8 = new String(utf8, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// e.printStackTrace();
		}
		return strUtf8;
	}

	public static String convertUniStr(final String s) {
		if (Strings.isNullOrEmpty(s)) return "";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if ((ch >= 0x0020) && (ch <= 0x007e)) // Does the char need to be converted to unicode?
			{
				// No.
				sb.append(ch);
			} else {
				// Yes.
				sb.append("\\"); // standard unicode format.
				String hex = Integer.toHexString(s.charAt(i) & 0xFFFF); // Get hex value of the char.

				for (int j = 0; j < 4 - hex.length(); j++)
					// Prepend zeros because unicode requires 4 digits
					sb.append("0");

				sb.append(hex.toLowerCase()); // standard unicode format.
			}
		}

		return (new String(sb));
	}

	public static String convertNorStr(final String s) {
		if (Strings.isNullOrEmpty(s)) return "";

		String a[] = { "â", "ă", "à", "á", "ạ", "ã", "ả", "ò", "ó", "�?", "�?", "õ", "ơ", "�?", "ớ", "ợ", "ỡ", "ở", "ằ",
				"ắ", "ặ", "ẵ", "ầ", "ấ", "ậ", "ẫ", "ẩ", "ù", "ú", "ụ", "ũ", "ủ", "ư", "ừ", "ứ", "ự", "ữ", "ử", "ê",
				"�?", "ế", "ệ", "ễ", "ể", "ì", "í", "ị", "ĩ", "ỉ", "ô", "ồ", "ố", "ộ", "ỗ", "ổ", "è", "é", "ẹ", "ẽ",
				"ẻ", "ỳ", "ý", "ỵ", "ỹ", "ỷ", "đ", "À", "�?", "Ạ", "Ã", "Ả", "Ò", "Ó", "Ọ", "Ỏ", "Õ", "Ơ", "Ờ", "Ớ",
				"Ợ", "Ỡ", "Ở", "Ằ", "Ắ", "Ặ", "Ẵ", "Ầ", "Ấ", "Ậ", "Ẫ", "Ẩ", "Ù", "Ú", "Ụ", "Ũ", "Ủ", "Ư", "Ừ", "Ứ", "Ự",
				"Ữ", "Ử", "Ê", "Ề", "Ế", "Ệ", "Ễ", "Ể", "Ì", "�?", "Ị", "Ĩ", "Ỉ", "Ô", "Ồ", "�?", "Ộ", "Ỗ", "Ổ", "È",
				"É", "Ẹ", "Ẽ", "Ẻ", "Ỳ", "�?", "Ỵ", "Ỹ", "Ỷ", "�?", "Â" };
		String b[] = { "\\00e2", "\\0103", "\\00e0", "\\00e1", "\\1ea1", "\\00e3", "\\1ea3", "\\00f2", "\\00f3",
				"\\1ecd", "\\1ecf", "\\00f5", "\\01a1", "\\1edd", "\\1edb", "\\1ee3", "\\1ee1", "\\1edf", "\\1eb1",
				"\\1eaf", "\\1eb7", "\\1eb5", "\\1ea7", "\\1ea5", "\\1ead", "\\1eab", "\\1ea9", "\\00f9", "\\00fa",
				"\\1ee5", "\\0169", "\\1ee7", "\\01b0", "\\1eeb", "\\1ee9", "\\1ef1", "\\1eef", "\\1eed", "\\00ea",
				"\\1ec1", "\\1ebf", "\\1ec7", "\\1ec5", "\\1ec3", "\\00ec", "\\00ed", "\\1ecb", "\\0129", "\\1ec9",
				"\\00f4", "\\1ed3", "\\1ed1", "\\1ed9", "\\1ed7", "\\1ed5", "\\00e8", "\\00e9", "\\1eb9", "\\1ebd",
				"\\1ebb", "\\1ef3", "\\00fd", "\\1ef5", "\\1ef9", "\\1ef7", "\\0111", "\\00c0", "\\00c1", "\\1ea0",
				"\\00c3", "\\1ea2", "\\00d2", "\\00d3", "\\1ecc", "\\1ece", "\\00d5", "\\01a0", "\\1edc", "\\1eda",
				"\\1ee2", "\\1ee0", "\\1ede", "\\1eb0", "\\1eae", "\\1eb6", "\\1eb4", "\\1ea6", "\\1ea4", "\\1eac",
				"\\1eaa", "\\1ea8", "\\00d9", "\\00da", "\\1ee4", "\\0168", "\\1ee6", "\\01af", "\\1eea", "\\1ee8",
				"\\1ef0", "\\1eee", "\\1eec", "\\00ca", "\\1ec0", "\\1ebe", "\\1ec6", "\\1ec4", "\\1ec2", "\\00cc",
				"\\00cd", "\\1eca", "\\0128", "\\1ec8", "\\00d4", "\\1ed2", "\\1ed0", "\\1ed8", "\\1ed6", "\\1ed4",
				"\\00c8", "\\00c9", "\\1eb8", "\\1ebc", "\\1eba", "\\1ef2", "\\00dd", "\\1ef4", "\\1ef8", "\\1ef6",
				"\\0110", "\\00C2" };

		String str = s;
		for (int i = 0; i < b.length; i++)
			if (str.indexOf(b[i]) >= 0) str = str.replace(b[i], a[i]);

		return str;
	}

	public static String[] splitTokens(final String s) {
		String delims = "[;_|@]+";
		return s.split(delims);
	}

	public static final String ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.!~*'()";

	public static String encodeURIComponent(final String input) {
		if (Strings.isNullOrEmpty(input)) return "";

		int l = input.length();
		StringBuilder o = new StringBuilder(l * 3);
		try {
			for (int i = 0; i < l; i++) {
				String e = input.substring(i, i + 1);
				if (ALLOWED_CHARS.indexOf(e) == -1) {
					byte[] b = e.getBytes("utf-8");
					o.append(getHex(b));
					continue;
				}
				o.append(e);
			}
			return o.toString();
		} catch (UnsupportedEncodingException e) {
		}

		return input;
	}

	private static String getHex(final byte[] buf) {
		StringBuilder o = new StringBuilder(buf.length * 3);
		for (int i = 0; i < buf.length; i++) {
			int n = (int) buf[i] & 0xff;
			o.append("%");

			if (n < 0x10) o.append("0");

			o.append(Long.toString(n, 16).toUpperCase());
		}

		return o.toString();
	}
}
