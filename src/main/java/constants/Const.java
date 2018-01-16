package constants;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * <p>
 * Interface to maintain all the message properties.
 * </p>
 * 
 * @author manhnv
 * @version 1.0
 **/
public interface Const {
	String EMPTY = "";
	String N_A = "N/A";
	String SPACE = " ";
	String COMMA = ",";
	String COLON = ":";
	String DOT = ".";
	String DASH = "-";
	String HYPHEN = "_";
	String SLASH = "/";
	String BREAK_LINE = "\n";
	String SEMICOLON = ";";
	String ASTERISK = "*";
	String QUOTES = "\"";
	String APOSTROPHE = "\'";
	String UTF8 = "UTF-8";

	// Pattern and format
	char EMPTY_CHAR = '\0';
	String NUMERIC_PATTERN = "[+-]?\\d*(\\.\\d+)?";
	String TEMP_DIR = System.getProperty("java.io.tmpdir");
	String CURR_DIR = System.getProperty("user.dir");
	NumberFormat NUMBER_FORMAT = new DecimalFormat("#0.00");

	String YES = "Y";
	String NO = "N";
	String ZERO = "0";
	String ONE = "1";

	String DATE_FORMAT = "dd-MMM-yyyy";
	String DATE_VN_FORMAT = "dd-MM-yyyy";
	String DATE_VN_NEW_FORMAT = "dd/MM/yyyy";
	String DATE_VN_NEW_FROMDB_FORMAT = "yyyy-MM-dd hh:mm:ss";
	String DATE_MONTH_YEAR_FORMAT = "MM-yyyy";

	String LANGUAGE_VN = "vi";
	String COUNTRY_VN = "VN";
	String LANGUAGE_EN = "en";
	String COUNTRY_EN = "EN";
	String LANGUAGE_PARAM = "lang";

	Locale VI_LOCALE = new Locale(LANGUAGE_VN, COUNTRY_VN);
	Locale EN_LOCALE = new Locale(LANGUAGE_EN, COUNTRY_EN);

	@Override
	String toString();
}
