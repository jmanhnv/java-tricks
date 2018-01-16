package algorithms;

// http://javaconceptoftheday.com/how-to-create-pyramid-of-numbers-in-java/
public class PyramidOfNumbers {
	public static void main(String[] args) {
		// Taking noOfRows value from the user
		int noOfRows = 9;

		// Execute
		pattern01(noOfRows);
		pattern02(noOfRows);
		pattern03(noOfRows);
		pattern04(noOfRows);
		pattern05(noOfRows);
		pattern06(noOfRows);
	}

	/**
	 * Pattern 1 : Write java program to create pyramid of numbers like in Pattern1 of the 'PyramidOfNumbers.png'.
	 */
	private static void pattern01(final int noOfRows) {
		// Initializing rowCount with 1

		int rowCount = 1;

		System.err.println("Here Is Your Pyramid of Pattern 1");

		// Implementing the logic

		for (int i = noOfRows; i > 0; i--) {
			// Printing i spaces at the beginning of each row

			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}

			// Printing 'rowCount' value 'rowCount' times at the end of each row

			for (int j = 1; j <= rowCount; j++) {
				System.out.print(rowCount + " ");
			}

			System.out.println();

			// Incrementing the rowCount

			rowCount++;
		}
	}

	/**
	 * Pattern 2 : How to create pyramid of numbers in Java like in Pattern2 of the 'PyramidOfNumbers.png'.
	 */
	private static void pattern02(final int noOfRows) {
		// Initializing rowCount with 1

		int rowCount = 1;

		System.err.println("Here Is Your Pyramid of Pattern 2");

		// Implementing the logic

		for (int i = noOfRows; i > 0; i--) {
			// Printing i spaces at the beginning of each row

			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}

			// Printing 'j' value at the end of each row

			for (int j = 1; j <= rowCount; j++) {
				System.out.print(j + " ");
			}

			System.out.println();

			// Incrementing the rowCount

			rowCount++;
		}
	}

	/**
	 * Pattern 3 : Write a java program to create pyramid of stars(*) like in the Pattern3 of the
	 * 'PyramidOfNumbers.png'.
	 */
	private static void pattern03(final int noOfRows) {
		// Initializing rowCount with 1

		int rowCount = 1;

		System.err.println("Here Is Your Pyramid of Pattern 3");

		// Implementing the logic

		for (int i = noOfRows; i > 0; i--) {
			// Printing i spaces at the beginning of each row

			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}

			// Printing * at the end of each row

			for (int j = 1; j <= rowCount; j++) {
				System.out.print("* ");
			}

			System.out.println();

			// Incrementing the rowCount

			rowCount++;
		}
	}

	/**
	 * Pattern 4 : Write java program to print pyramid of numbers like in the Pattern4 of the 'PyramidOfNumbers.png'.
	 */
	private static void pattern04(final int noOfRows) {
		// Initializing rowCount with 1

		int rowCount = 1;

		System.err.println("Here Is Your Pyramid of Pattern 4");

		// Implementing the logic

		for (int i = noOfRows; i > 0; i--) {
			// Printing i*2 spaces at the beginning of each row

			for (int j = 1; j <= i * 2; j++) {
				System.out.print(" ");
			}

			// Printing j value where j value will be from 1 to rowCount

			for (int j = 1; j <= rowCount; j++) {
				System.out.print(j + " ");
			}

			// Printing j value where j value will be from rowCount-1 to 1

			for (int j = rowCount - 1; j >= 1; j--) {
				System.out.print(j + " ");
			}

			System.out.println();

			// Incrementing the rowCount

			rowCount++;
		}
	}

	/**
	 * Pattern 5 : Write Java program to print reverse pyramid of numbers like in the Pattern5 of the
	 * 'PyramidOfNumbers.png'.
	 */
	private static void pattern05(final int noOfRows) {
		// Initializing rowCount with noOfRows

		int rowCount = noOfRows;

		System.err.println("Here Is Your Pyramid of Pattern 5");

		// Implementing the logic

		for (int i = 0; i < noOfRows; i++) {
			// Printing i*2 spaces at the beginning of each row

			for (int j = 1; j <= i * 2; j++) {
				System.out.print(" ");
			}

			// Printing j where j value will be from 1 to rowCount

			for (int j = 1; j <= rowCount; j++) {
				System.out.print(j + " ");
			}

			// Printing j where j value will be from rowCount-1 to 1

			for (int j = rowCount - 1; j >= 1; j--) {
				System.out.print(j + " ");
			}

			System.out.println();

			// Decrementing the rowCount

			rowCount--;
		}
	}

	/**
	 * Pattern 6 : How do you create pyramid of numbers like in the Pattern6 of the 'PyramidOfNumbers.png'.
	 */
	private static void pattern06(final int noOfRows) {
		System.err.println("Here Is Your Pyramid of Pattern 6");

		// Implementing the logic

		for (int i = noOfRows; i >= 1; i--) {
			// Printing i*2 spaces at the beginning of each row

			for (int j = 1; j <= i * 2; j++) {
				System.out.print(" ");
			}

			// Printing j where j value will be from i to noOfRows

			for (int j = i; j <= noOfRows; j++) {
				System.out.print(j + " ");
			}

			// Printing j where j value will be from noOfRows-1 to i

			for (int j = noOfRows - 1; j >= i; j--) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

}
