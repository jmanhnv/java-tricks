/*
 * FILENAME ValidateEncodingApp.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2009 VSII. All rights reserved. This software is the confidential and proprietary information of VSII
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with VSII.
 */

package fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * Validating Files for Unicode/UTF-8 Character Set.
 * </p>
 * <p>
 * Reads bytes from file using a decoder that throws an exception if the bytes cannot be decoded as UTF-8. Can be used
 * to validate a single file or a directory of files with full recursion. Includes a feature to create a file with a
 * non-UTF-8 byte sequence for testing.
 * </p>
 * 
 * @see http://maultech.com/chrislott/blog/20110718_unicode.html
 * @author manhnv
 * @version 0.1
 **/
public class ValidateEncodingApp {
	private final String charsetName;
	private final CharsetDecoder decoder;
	private int filesPassed = 0, filesFailed = 0;

	/**
	 * Obtains a decoder and configures it to blow up on problems.
	 * 
	 * @param charsetName
	 *            Name of character set to use; e.g., UTF-8
	 */
	public ValidateEncodingApp(String charsetName) {
		this.charsetName = charsetName;
		Charset charset = Charset.forName(charsetName);
		decoder = charset.newDecoder();
		decoder.onMalformedInput(CodingErrorAction.REPORT);
		decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
	}

	/**
	 * @return The character set name supplied to the constructor
	 */
	public String getCharsetName() {
		return charsetName;
	}

	/**
	 * @return The number of files that could not be validated for whatever reason.
	 */
	public int getFilesFailed() {
		return filesFailed;
	}

	/**
	 * @return The number of files successfully validated.
	 */
	public int getFilesPassed() {
		return filesPassed;
	}

	/**
	 * Reads and decodes bytes from the specified file, which will find byte sequences that cannot be decoded using the
	 * current system. Traps all exceptions and reports to System.err.
	 * 
	 * @param file
	 * @return True on success, false on IOException or decoding error
	 */
	private boolean validateFile(File file) {
		boolean result = true;
		long total = 0;
		InputStreamReader isr = null;
		char[] buf = new char[65536];
		int chars;
		try {
			isr = new InputStreamReader(new FileInputStream(file), decoder);
			while ((chars = isr.read(buf)) >= 0)
				total += chars;
			++filesPassed;
		} catch (CharacterCodingException ex) {
			++filesFailed;
			System.err.println(
					"Decoding failed near byte " + total + " in file " + file.getPath() + ": " + ex.toString());
			result = false;
		} catch (IOException ex) {
			++filesFailed;
			System.err.println("Failed to read file " + file.getPath() + ": " + ex.toString());
			result = false;
		} finally {
			if (isr != null) try {
				isr.close();
			} catch (IOException ex) {
				System.err.println("Failed to close file: " + ex.toString());
			}
		}
		return result;
	}

	/**
	 * Validates all files in the specified directory. Optionally recurses into subdirectories. Prints message to stdout
	 * when it starts and again when it finishes traversing a directory.
	 * 
	 * @param dir
	 *            Directory to traverse.
	 * @param isRecurse
	 *            If true, will call itself to process subdirectories.
	 * @throws Exception
	 */
	private void validateDirectory(File dir, boolean isRecurse) throws Exception {
		if (!dir.exists() || !dir.isDirectory())
			throw new IllegalArgumentException("Not found or not a directory: " + dir.getPath());
		System.out.println("Entering directory " + dir.getPath());
		File[] contents = dir.listFiles();
		for (File f : contents) {
			if (f.isFile()) validateFile(f);
			else if (f.isDirectory() && isRecurse) validateDirectory(f, isRecurse);
		}
		System.out.println("Leaving directory " + dir.getPath());
	}

	/**
	 * Prints message(s) and exits
	 * 
	 * @param msg
	 */
	private static void usage(String msg) {
		if (msg != null) System.err.println(msg);
		System.err.println("Usage: ValidateEncodingApp -validate (file|dir)");
		System.err.println("       ValidateEncodingApp -create filename");
		System.exit(0);
	}

	public static void main(String[] args) {

		// TODO: extend to accept encoding system name
		// and recurse option as arguments.
		String charsetName = "UTF-8";
		boolean recurse = true;

		if (args.length != 2) usage("Unexpected number of arguments");

		String cmd = args[0];
		File file = new File(args[1]);

		if ("-create".equals(cmd)) {
			if (file.exists()) usage("Will not overwrite existing file: " + file.getPath());

			System.out.println("Creating file with ISO-8859-1 content: " + file.getPath());
			try {
				// The word "dolt" has an o with a diagonal slash thru it.
				// The slash-o is valid in ISO-8859-1 but not in UTF-8.
				final byte[] invalid = "d\u00f8lt".getBytes("iso-8859-1");
				FileOutputStream fis = new FileOutputStream(file);
				fis.write(invalid);
				fis.close();
			} catch (IOException ex) {
				System.err.println("Failed to write file: " + ex.toString());
			}
		} else if ("-validate".equals(cmd)) {
			if (!file.exists()) usage("Not found: " + file.getPath());

			try {
				ValidateEncodingApp validator = new ValidateEncodingApp(charsetName);
				if (file.isFile()) {
					System.out
							.println("Validating decoding of bytes as " + charsetName + " for file " + file.getPath());
					validator.validateFile(file);
				} else {
					System.out.println("Validating decoding of bytes as " + charsetName
							+ " for files in/below directory " + file.getPath());
					validator.validateDirectory(file, recurse);
				}
				System.out.println("Validation success count is " + validator.getFilesPassed());
				System.out.println("Validation failure count is " + validator.getFilesFailed());

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			usage("Unexpected command: " + cmd);
		}

	}
}
