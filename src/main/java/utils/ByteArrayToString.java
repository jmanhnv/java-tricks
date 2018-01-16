package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

/**
 * Java Program to convert byte array to String. In this example, we have first read an XML file with character encoding
 * "UTF-8" into byte array and then created String from that. When you don't specify a character encoding, Java uses
 * platform's default encoding, which may not be the same if file is a XML document coming from another system, emails,
 * or plain text files fetched from an * HTTP server etc. You must first discover correct character encoding and then
 * use them while converting byte array to String.
 *
 * @author Javin Paul
 */
public class ByteArrayToString {

	public static void main(String args[]) throws IOException {

		System.out.println("Platform Encoding : " + System.getProperty("file.encoding"));

		FileInputStream fis = new FileInputStream(new File("/utils/info.xml"));

		// Using Apache Commons IOUtils to read file into byte array
		byte[] filedata = IOUtils.toByteArray(fis);

		String str = new String(filedata, "UTF-8");
		System.out.println(str);

	}
}
