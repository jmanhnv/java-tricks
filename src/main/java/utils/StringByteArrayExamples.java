package utils;

import java.util.Base64;

public class StringByteArrayExamples {
	public static void main(String[] args) {
		// Convert String to byte[] and byte[] to String using String class
		// Original String
		String string = "howtodoinjava.com";

		// Convert to byte[]
		byte[] bytes = string.getBytes();

		// Convert back to String
		String s = new String(bytes);

		// Check converted string against original String
		System.out.println("Decoded String : " + s);

		// Convert String to byte[] and byte[] to String using Base64 class [Java 8]
		// Original byte[]
		bytes = "howtodoinjava.com".getBytes();

		// Base64 Encoded
		String encoded = Base64.getEncoder().encodeToString(bytes);

		// Base64 Decoded
		byte[] decoded = Base64.getDecoder().decode(encoded);

		// Verify original content
		System.out.println(new String(decoded));
	}
}
