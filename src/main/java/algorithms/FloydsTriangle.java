package algorithms;

// http://javaconceptoftheday.com/how-to-print-floyds-triangle-in-java/
public class FloydsTriangle {

	public static void main(String[] args) {
		// Taking noOfRows value from the user
		int noOfRows = 9;

		// Execute
		floydsTriangle(noOfRows);
	}

	private static void floydsTriangle(final int noOfRows) {
		int value = 1;

		System.err.println("Here Is Your Floyd's Triangle");

		for (int i = 1; i <= noOfRows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(value + "\t");

				value++;
			}

			System.out.println();
		}
	}
}
