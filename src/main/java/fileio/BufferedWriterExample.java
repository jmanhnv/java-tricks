/*
 * FILENAME BufferedWriterExample.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2009 VSII. All rights reserved. This software is the confidential and proprietary information of VSII
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with VSII.
 */

package fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
 * @see http://howtodoinjava.com/2015/01/21/how-to-write-to-file-in-java-bufferedwriter-example/
 * @author manhnv
 * @version 0.1
 **/
public class BufferedWriterExample {
	public static void main(String[] args) throws IOException {
		createFileUsingBufferedWriterJava6();
		createFileUsingBufferedWriterJava7();
	}

	// 1) Using BufferedWriter without try-with-resources (Before Java 7)
	private static void createFileUsingBufferedWriterJava6() throws IOException {
		try {

			String content = "Hello Learner !! Welcome to howtodoinjava.com.";
			File file = new File("c:/temp/samplefile.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 2) Using BufferedWriter with try-with-resources (Java 7 Onwards)
	private static void createFileUsingBufferedWriterJava7() throws IOException {
		// try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\temp\\testOut.txt")))
		// {
		// String content = "Hello Learner !! Welcome to howtodoinjava.com.";
		// bufferedWriter.write(content);
		// }
		// catch (IOException e)
		// {
		// e.printStackTrace();
		// }
	}
}
