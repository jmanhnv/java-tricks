/*
 * FILENAME BufferedReaderExample.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2009 VSII. All rights reserved. This software is the confidential and proprietary information of VSII
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with VSII.
 */

package fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// import java.nio.charset.StandardCharsets;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.nio.file.StandardOpenOption;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * How to write to file in Java : BufferedWriter Example.
 * </p>
 * <p>
 * Package java.nio.file is coming in Java 7. It's not in Java 6 or before.
 * </p>
 * 
 * @see http://howtodoinjava.com/2015/01/21/how-to-read-file-in-java-bufferedreader-example/
 * @author manhnv
 * @version 0.1
 **/
public class BufferedReaderExample {
	public static void main(String[] args) throws IOException {
		createFileUsingBufferedReaderJava6();
		createFileUsingBufferedReaderJava7();
	}

	// 1) Use BufferedReader without try-with-resources (Before Java 7)
	private static void createFileUsingBufferedReaderJava6() throws IOException {
		BufferedReader bufferedReader = null;
		try {
			String currLine;
			bufferedReader = new BufferedReader(new FileReader("C:\\temp\\testOut.txt"));
			while ((currLine = bufferedReader.readLine()) != null) {
				System.out.println(currLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	// 2) Use BufferedReader with try-with-resources (Java 7 Onwards)
	private static void createFileUsingBufferedReaderJava7() throws IOException {
		// try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\temp\\testOut.txt")))
		// {
		// String currLine;
		// while ((currLine = bufferedReader.readLine()) != null)
		// {
		// System.out.println(currLine);
		// }
		// }
		// catch (IOException e)
		// {
		// e.printStackTrace();
		// }
	}
}
