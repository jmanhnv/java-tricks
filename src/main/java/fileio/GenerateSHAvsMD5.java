/*
 * FILENAME GenerateSHAvsMD5.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2009 VSII. All rights reserved. This software is the confidential and proprietary information of VSII
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into with VSII.
 */

package fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
 * How to generate SHA or MD5 file checksum hash in java. A checksum hash is an encrypted sequence of characters
 * obtained after applying certain algorithms and manipulations on user provided content. In this post, we will learn to
 * generate the checksum hash for files.
 * </p>
 * <p>
 * Package java.nio.file is coming in Java 7. It's not in Java 6 or before.
 * </p>
 * 
 * @see http://howtodoinjava.com/2015/01/21/how-to-generate-sha-or-md5-file-checksum-hash-in-java/
 * @author manhnv
 * @version 0.1
 **/
public class GenerateSHAvsMD5 {
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		generateMD5checksum();
		generateSHA1checksum();
	}

	private static void generateMD5checksum() throws NoSuchAlgorithmException, IOException {
		// Create checksum for this file
		File file = new File("c:/temp/testOut.txt");
		// Use MD5 algorithm
		MessageDigest md5Digest = MessageDigest.getInstance("MD5");
		// Get the checksum
		String checksum = getFileChecksum(md5Digest, file);
		// see checksum
		System.out.println(checksum);
	}

	private static void generateSHA1checksum() throws NoSuchAlgorithmException, IOException {
		// Create checksum for this file
		File file = new File("c:/temp/testOut.txt");
		// Use SHA-1 algorithm
		MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
		// SHA-1 checksum
		String shaChecksum = getFileChecksum(shaDigest, file);
		// see checksum
		System.out.println(shaChecksum);
	}

	private static String getFileChecksum(MessageDigest digest, File file) throws IOException {
		// Get file input stream for reading the file content
		FileInputStream fis = new FileInputStream(file);

		// Create byte array to read data in chunks
		byte[] byteArray = new byte[1024];
		int bytesCount = 0;

		// Read file data and update in message digest
		while ((bytesCount = fis.read(byteArray)) != -1) {
			digest.update(byteArray, 0, bytesCount);
		}

		// close the stream; We don't need it now.
		fis.close();

		// Get the hash's bytes
		byte[] bytes = digest.digest();

		// This bytes[] has bytes in decimal format;
		// Convert it to hexadecimal format
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}

		// return complete hash
		return sb.toString();
	}
}
