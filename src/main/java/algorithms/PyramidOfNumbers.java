package algorithms;

/**
 * How To Create Pyramid Of Numbers In Java?
 * 
 * <pre>
 * This is one of the frequently asked java interview question for freshers.
 * This question tests the candidate’s logical ability as well as the basic understanding of Java language.
 * They can ask you to create pyramid of numbers with different patterns like in the below image (PyramidOfNumbers.png).
 * </pre>
 * 
 * @author manhnv
 * @see http://javaconceptoftheday.com/how-to-create-pyramid-of-numbers-in-java/
 */
public class PyramidOfNumbers {
	/**
	 * Pattern 1: Write java program to create pyramid of numbers like in Pattern1
	 * of the 'PyramidOfNumbers.png'.
	 * 
	 * <pre>
	 * Take the input from the user and assign it to noOfRows. This will be the number of rows he wants in a pyramid.
	 * Define one variable called rowCount and initialize it to 1. This will hold the value of current row count.
	 * At the beginning of each row, we print ‘i’ spaces where ‘i’ will be value from noOfRows to 1.
	 * At the end of each row, we print rowCount value rowCount times. i.e in the first row, 1 will be printed once.
	 * In the second row, 2 will be printed twice and so on. Below is the java code which implements this logic.
	 * </pre>
	 * 
	 * @param noOfRows
	 */
	public static void pattern1(final int noOfRows) {
		// Initializing rowCount with 1

		int rowCount = 1;

		System.out.println("\nHere Is Your Pyramid of Pattern 1");

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
	 * Pattern 2: How to create pyramid of numbers in Java like in Pattern2 of the
	 * 'PyramidOfNumbers.png'.
	 * 
	 * <pre>
	 * In this pattern also, we use same logic but instead of printing rowCount value rowCount times at the end of each row,
	 * we print ‘j’ where j value will be from 1 to rowCount.
	 * </pre>
	 * 
	 * @param noOfRows
	 */
	public static void pattern2(final int noOfRows) {
		// Initializing rowCount with 1

		int rowCount = 1;

		System.out.println("\nHere Is Your Pyramid of Pattern 2");

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
	 * Pattern 3: Write a java program to create pyramid of stars(*) like in the
	 * Pattern3 of the 'PyramidOfNumbers.png'.
	 * 
	 * <pre>
	 * The same logic is used here also. But, instead of printing rowCount or j value at the end of each row, we print star(*).
	 * </pre>
	 * 
	 * @param noOfRows
	 */
	public static void pattern3(final int noOfRows) {
		// Initializing rowCount with 1

		int rowCount = 1;

		System.out.println("\nHere Is Your Pyramid of Pattern 3");

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
	 * Pattern 4: Write java program to print pyramid of numbers like in the
	 * Pattern4 of the 'PyramidOfNumbers.png'.
	 * 
	 * <pre>
	 * In this problem, we print i*2 spaces at the beginning of each row instead of just i spaces.
	 * At the end of each row, we print ‘j’ where j value will be from 1 to rowCount and from rowCount-1 to 1.
	 * </pre>
	 * 
	 * @param noOfRows
	 */
	public static void pattern4(final int noOfRows) {
		// Initializing rowCount with 1

		int rowCount = 1;

		System.out.println("\nHere Is Your Pyramid of Pattern 4");

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
	 * Pattern 5: Write Java program to print reverse pyramid of numbers like in the
	 * Pattern5 of the 'PyramidOfNumbers.png'.
	 * 
	 * <pre>
	 * In this problem, we iterate outer loop in the reverse order i.e from 1 to noOfRows and initialize the rowCount to noOfRows.
	 * </pre>
	 * 
	 * @param noOfRows
	 */
	public static void pattern5(final int noOfRows) {
		// Initializing rowCount with noOfRows

		int rowCount = noOfRows;

		System.out.println("\nHere Is Your Pyramid of Pattern 5");

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
	 * Pattern 6: How do you create pyramid of numbers like in the Pattern6 of the
	 * 'PyramidOfNumbers.png'.
	 * 
	 * <pre>
	 * In this problem, at the end of each row we print ‘j’ where ‘j’ value will be from i to noOfRows and from noOfRows-1 to i.
	 * </pre>
	 * 
	 * @param noOfRows
	 */
	public static void pattern6(final int noOfRows) {
		System.out.println("\nHere Is Your Pyramid of Pattern 6");

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
