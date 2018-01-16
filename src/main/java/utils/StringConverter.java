package utils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class StringConverter {
	public static String convertBinaryStringToString(String string) {
		StringBuilder sb = new StringBuilder();
		List<String> blocks = Arrays.asList(string.split(" "));

		for (String block : blocks) {
			int result = convertBlock(block);
			System.out.println(result);
			sb.append(Character.toChars(result));
		}
		return sb.toString();
	}

	private static int convertBlock(String block) {
		int[] mapping = { 128, 64, 32, 16, 8, 4, 2, 1 };
		int sum = 0;
		int blockPosition = block.length() - 1;
		while (blockPosition > 0) {
			if (block.charAt(blockPosition) == '1') sum += mapping[blockPosition];
			blockPosition--;
		}
		return sum;
	}

	// Java8 as follows
	// public static String convertBinaryStringToString1(String string) {
	// int sum = 0;
	// List<String> blocks = Arrays.asList(string.split(" "));
	// List<Integer> numbers = blocks.stream().map(block -> {
	// int[] mapping = { 128, 64, 32, 16, 8, 4, 2, 1 };
	// return IntStream.range(0, block.length()).reduce(0, (o, n) -> {
	// if (block.charAt(n) == '1') o += mapping[n];
	// return o;
	// });
	// }).collect(Collectors.toList());
	// numbers.forEach(System.out::println);
	// StringBuilder result = new StringBuilder();
	// numbers.forEach(x -> {
	// result.append(Character.toChars(x));
	// });
	// return result.toString();
	// }

	public static void main(String[] args) throws UnsupportedEncodingException {
		// Encode
		String asB64 = Base64.getEncoder().encodeToString("some string".getBytes("utf-8"));
		System.out.println(asB64); // Output will be: c29tZSBzdHJpbmc=

		// Decode
		byte[] asBytes = Base64.getDecoder().decode("c29tZSBzdHJpbmc=");
		System.out.println(new String(asBytes, "utf-8")); // And the output is: some string

	}
}
