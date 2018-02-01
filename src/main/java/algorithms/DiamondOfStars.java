package algorithms;

/**
 * Diamond Pattern Program In Java.
 * 
 * <pre>
 * Write a java program to print diamond of stars (*) or diamond of numbers like shown in the below image (DiamondPatternProgram.png).
 * </pre>
 * 
 * @author manhnv
 * @see http://javaconceptoftheday.com/diamond-pattern-program-in-java/
 */
public class DiamondOfStars {

	public static void main(String[] args) {
		final int noOfRows = 7;
		pattern1(noOfRows);
		pattern2(noOfRows);
	}

	/**
	 * Java Program To Print Diamond Of Stars(*).
	 * 
	 * @param noOfRows
	 */
	private static void pattern1(final int noOfRows) {
		// Getting midRow of the diamond
		int midRow = (noOfRows) / 2;

		// Initializing row with 1
		int row = 1;

		System.out.println("Here Is Your Diamond:");

		// Printing upper half of the diamond
		for (int i = midRow; i > 0; i--) {
			// Printing i spaces at the beginning of each row
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}

			// Printing j *'s at the end of each row
			for (int j = 1; j <= row; j++) {
				System.out.print("* ");
			}

			System.out.println();

			// Incrementing the row
			row++;
		}

		// Printing lower half of the diamond
		for (int i = 0; i <= midRow; i++) {
			// Printing i spaces at the beginning of each row
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}

			// Printing j *'s at the end of each row
			for (int j = row; j > 0; j--) {
				System.out.print("* ");
			}

			System.out.println();

			// Decrementing the row
			row--;
		}
	}

	/**
	 * Java Program To Print Diamond Of Numbers.
	 * 
	 * @param noOfRows
	 */
	private static void pattern2(final int noOfRows) {
		// Getting midRow of the diamond
		int midRow = noOfRows / 2;

		// Initializing row with 1
		int row = 1;

		System.out.println("Here Is Your Diamond:");

		// Printing upper half of the diamond
		for (int i = midRow; i > 0; i--) {
			// Printing i spaces at the beginning of each row
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}

			// Printing row value j times at the end of each row
			for (int j = 1; j <= row; j++) {
				System.out.print(row + " ");
			}

			System.out.println();

			// Incrementing the row
			row++;
		}

		// Printing lower half of the diamond
		for (int i = 0; i <= midRow; i++) {
			// Printing i spaces at the beginning of each row
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}

			// Printing row value j times at the end of each row
			for (int j = row; j > 0; j--) {
				System.out.print(row + " ");
			}

			System.out.println();

			// Decrementing the row
			row--;
		}
	}
}
