/*
 * FILENAME CreateNewFile.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2009 VSII. All rights reserved. This software is the confidential and proprietary information of VSII
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with VSII.
 */

package fileio;

import java.io.IOException;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * Creating a new file in java is very easy task and most of us are aware of this. Let’s list down 3 different ways to
 * create new file for our beginner friends. Please add more ways in comment section if you are aware of and I will
 * include it in post.
 * </p>
 * <p>
 * Package java.nio.file is coming in Java 7. It's not in Java 6 or before.
 * </p>
 * 
 * @see http://howtodoinjava.com/2015/01/20/how-to-create-a-new-file-in-java/
 * @author manhnv
 * @version 0.1
 **/
public class CreateNewFile {
	public static void main(String[] args) throws IOException {
		// createFileUsingFileClass();
		// createFileUsingFileOutputStreamClass();
		// createFileIn_NIO();
	}

	// private static void createFileUsingFileClass() throws IOException
	// {
	// File file = new File("C://temp//testFile1.txt");
	//
	// //Create the file
	// if (file.createNewFile())
	// {
	// System.out.println("File is created!");
	// }
	// else
	// {
	// System.out.println("File already exists.");
	// }
	//
	// //Write Content
	// FileWriter writer = new FileWriter(file);
	// writer.write("Test data");
	// writer.close();
	// }
	//
	// private static void createFileUsingFileOutputStreamClass() throws IOException
	// {
	// String data = "Test data";
	// FileOutputStream out = new FileOutputStream("C://temp//testFile2.txt");
	// out.write(data.getBytes());
	// out.close();
	// }
	//
	// private static void createFileIn_NIO() throws IOException
	// {
	// String data = "Test data";
	// Files.write(Paths.get("C://temp//testFile3.txt"), data.getBytes());
	//
	// //or
	//
	// List<String> lines = Arrays.asList("1st line", "2nd line");
	// Files.write(Paths.get("file6.txt"), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
	// StandardOpenOption.APPEND);
	// }
}
