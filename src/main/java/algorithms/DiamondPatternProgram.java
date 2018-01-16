package algorithms;

// http://javaconceptoftheday.com/diamond-pattern-program-in-java/
public class DiamondPatternProgram {

	public static void main(String[] args) {
		// Taking noOfRows value from the user
		int noOfRows = 9;

		// Execute
		diamondOfStars(noOfRows);
		diamondOfNumbers(noOfRows);
	}

	private static void diamondOfNumbers(final int noOfRows) {
		// Getting midRow of the diamond

		int midRow = noOfRows / 2;

		// Initializing row with 1

		int row = 1;

		System.err.println("Here Is Your Diamond Of Numbers");

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

	private static void diamondOfStars(final int noOfRows) {
		// Getting midRow of the diamond

		int midRow = (noOfRows) / 2;

		// Initializing row with 1

		int row = 1;

		System.err.println("Here Is Your Diamond Of Stars(*)");

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

}
