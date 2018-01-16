/*
 * FILENAME MakeFileReadOnly.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2009 VSII. All rights reserved. This software is the confidential and proprietary information of VSII
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with VSII.
 */

package fileio;

import java.io.File;
import java.io.IOException;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * How to make a file read only in java.
 * </p>
 * <p>
 * Package java.nio.file is coming in Java 7. It's not in Java 6 or before.
 * </p>
 * 
 * @see http://howtodoinjava.com/2015/01/21/how-to-make-a-file-read-only-in-java/
 * @author manhnv
 * @version 0.1
 **/
public class MakeFileReadOnly {
	// 1) Use java.io.File.setReadOnly() method
	private static void readOnlyFileUsingNativeCommand() throws IOException {
		File readOnlyFile = new File("c:/temp/testReadOnly.txt");

		// Mark it read only
		readOnlyFile.setReadOnly();

		if (readOnlyFile.exists()) {
			readOnlyFile.delete();
		}
		readOnlyFile.createNewFile();
	}

	// 2) Use java.io.File.setWritable(false) method
	private static void readOnlyFileUsingSetWritable() throws IOException {
		File readOnlyFile = new File("c:/temp/testReadOnly.txt");
		if (readOnlyFile.exists()) {
			readOnlyFile.delete();
		}
		readOnlyFile.createNewFile();

		// Mark it read only
		readOnlyFile.setWritable(false);
	}

	// 3) Execute a native command (platform dependent)
	private static void readOnlyFileUsingSetReadOnly() throws IOException {
		File readOnlyFile = new File("c:/temp/testReadOnly.txt");
		// Mark it read only in windows
		Runtime.getRuntime().exec("attrib " + "" + readOnlyFile.getAbsolutePath() + "" + " +R");
	}

	public static void main(String[] args) throws IOException {
		readOnlyFileUsingSetReadOnly();
		readOnlyFileUsingSetWritable();
		readOnlyFileUsingNativeCommand();
	}
}
