package algorithms;

/**
 * Diamond Pattern Program In Java.
 * 
 * <pre>
 * Floyd’s triangle is the right angled triangle consists of natural numbers in the following fashion.
 * Shown in the below image (FloydTriangle.png).
 * </pre>
 * 
 * @author manhnv
 * @see http://javaconceptoftheday.com/how-to-print-floyds-triangle-in-java/
 */
public class FloydsTriangle {
	/**
	 * Print-floyds-triangle
	 * 
	 * @param rows
	 * @see http://javaconceptoftheday.com/how-to-print-floyds-triangle-in-java/
	 */
	public static void floydsTriangle(final int rows) {
		// How many rows you want in Floyd's Triangle? 5
		// Floyd's Triangle:
		// 1
		// 2 3
		// 4 5 6
		// 7 8 9 10
		// 11 12 13 14 15

		int value = 1;

		System.out.println("\nHere Is Your Floyd's Triangle");
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(value + "\t");

				value++;
			}

			System.out.println();
		}
	}
}
