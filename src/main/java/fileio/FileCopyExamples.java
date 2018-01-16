/*
 * FILENAME FileCopyExamples.java FILE LOCATION $Source$ VERSION $Id$
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
import java.nio.channels.FileChannel;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * 4 ways to copy files in java. Copying a file from one place to another in java is a common task which you need to do
 * in your application. In this example, I am listing out 4 different ways to copy a file in java. Use one which best
 * fit your need.
 * </p>
 * <p>
 * Package java.nio.file is coming in Java 7. It's not in Java 6 or before.
 * </p>
 * 
 * @see http://howtodoinjava.com/2015/01/21/4-ways-to-copy-files-in-java/
 * @author manhnv
 * @version 0.1
 **/
public class FileCopyExamples {
	public static void main(String[] args) throws IOException {
		fileCopyUsingApacheCommons();
		// fileCopyUsingNIOFilesClass();
		fileCopyUsingNIOChannelClass();
		fileCopyUsingFileStreams();
	}

	// 1) Copy file using apache commons IO
	private static void fileCopyUsingApacheCommons() throws IOException {
		File fileToCopy = new File("c:/temp/testoriginal.txt");
		File newFile = new File("c:/temp/testcopied.txt");

		FileUtils.copyFile(fileToCopy, newFile);

		// OR

		IOUtils.copy(new FileInputStream(fileToCopy), new FileOutputStream(newFile));
	}

	//// 2) Copy file using java.nio.file.Files.copy()
	// private static void fileCopyUsingNIOFilesClass() throws IOException
	// {
	// Path source = Paths.get("c:/temp/testoriginal.txt");
	// Path destination = Paths.get("c:/temp/testcopied.txt");
	//
	// Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
	// }

	// 3) Copy file using java.nio.channels.FileChannel.transferTo()
	private static void fileCopyUsingNIOChannelClass() throws IOException {
		File fileToCopy = new File("c:/temp/testoriginal.txt");
		FileInputStream inputStream = new FileInputStream(fileToCopy);
		FileChannel inChannel = inputStream.getChannel();

		File newFile = new File("c:/temp/testcopied.txt");
		FileOutputStream outputStream = new FileOutputStream(newFile);
		FileChannel outChannel = outputStream.getChannel();

		inChannel.transferTo(0, fileToCopy.length(), outChannel);

		inputStream.close();
		outputStream.close();
	}

	// 4) Copy file using FileStreams
	private static void fileCopyUsingFileStreams() throws IOException {
		File fileToCopy = new File("c:/temp/testoriginal.txt");
		FileInputStream input = new FileInputStream(fileToCopy);

		File newFile = new File("c:/temp/testcopied.txt");
		FileOutputStream output = new FileOutputStream(newFile);

		byte[] buf = new byte[1024];
		int bytesRead;

		while ((bytesRead = input.read(buf)) > 0) {
			output.write(buf, 0, bytesRead);
		}

		input.close();
		output.close();
	}
}
