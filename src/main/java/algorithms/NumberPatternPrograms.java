package algorithms;

// http://javaconceptoftheday.com/number-pattern-programs-in-java/
public class NumberPatternPrograms {
	public static void main(String[] args) {
		// Taking rows value from the user
		int rows = 7;

		// Execute
		pattern01(rows);
		pattern02(rows);
		pattern03(rows);
		pattern04(rows);
		pattern05(rows);
		pattern06(rows);
		pattern07(rows);
		pattern08(rows);
		pattern09(rows);
		pattern10(rows);
		pattern11(rows);
		pattern11(rows);
		pattern12(rows);
		pattern13(rows);
		pattern14(rows);
		pattern15(rows);
		pattern16(rows);
		pattern17(rows);

		/*
		 * Pattern 18 refer to {@link PyramidOfNumbers.java} - Different Pyramid Pattern Programs In Java
		 */
		/*
		 * Pattern 19 refer to {@link DiamondPatternProgram.java} - Diamond Pattern Programs In Java
		 */

		/*
		 * Pattern 20 refer to {@link FloydsTriangle.java} - Floyd’s Triangle In Java
		 */
	}

	private static void pattern01(final int rows) {
		System.err.println("Here is your Pattern 1....!!!");

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	private static void pattern02(final int rows) {
		System.err.println("Here is your Pattern 2....!!!");

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}

			System.out.println();
		}
	}

	private static void pattern03(final int rows) {
		System.err.println("Here is your Pattern 3....!!!");

		// Printing upper half of the pattern

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}

		// Printing lower half of the pattern

		for (int i = rows - 1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	private static void pattern04(final int rows) {
		System.err.println("Here is your Pattern 4....!!!");

		for (int i = rows; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	private static void pattern05(final int rows) {
		System.err.println("Here is your Pattern 5....!!!");

		for (int i = 1; i <= rows; i++) {
			for (int j = rows; j >= i; j--) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	private static void pattern06(final int rows) {
		System.err.println("Here is your Pattern 6....!!!");

		for (int i = rows; i >= 1; i--) {
			for (int j = rows; j >= i; j--) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	private static void pattern07(final int rows) {
		System.err.println("Here is your Pattern 7....!!!");

		for (int i = rows; i >= 1; i--) {
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	private static void pattern08(final int rows) {
		System.err.println("Here is your Pattern 8....!!!");

		// Printing upper half of the pattern

		for (int i = rows; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}

		// Printing lower half of the pattern

		for (int i = 2; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	private static void pattern09(final int rows) {
		System.err.println("Here is your Pattern 9....!!!");

		for (int i = 1; i <= rows; i++) {
			// Printing first half of the row

			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			// Printing second half of the row

			for (int j = i - 1; j >= 1; j--) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	private static void pattern10(final int rows) {
		System.err.println("Here is your Pattern 10....!!!");

		for (int i = 1; i <= rows; i++) {
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	private static void pattern11(final int rows) {
		System.err.println("Here is your Pattern 11....!!!");

		// Printing upper half of the pattern

		for (int i = 1; i <= rows; i++) {
			// Printing i spaces at the beginning of each row

			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}

			// Printing i to rows value at the end of each row

			for (int j = i; j <= rows; j++) {
				System.out.print(j);
			}

			System.out.println();
		}

		// Printing lower half of the pattern

		for (int i = rows - 1; i >= 1; i--) {
			// Printing i spaces at the beginning of each row

			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}

			// Printing i to rows value at the end of each row

			for (int j = i; j <= rows; j++) {
				System.out.print(j);
			}

			System.out.println();
		}
	}

	private static void pattern12(final int rows) {
		System.err.println("Here is your Pattern 12....!!!");

		// Printing upper half of the pattern

		for (int i = 1; i <= rows; i++) {
			// Printing i spaces at the beginning of each row

			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}

			// Printing i to rows value at the end of each row

			for (int j = i; j <= rows; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}

		// Printing lower half of the pattern

		for (int i = rows - 1; i >= 1; i--) {
			// Printing i spaces at the beginning of each row

			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}

			// Printing i to rows value at the end of each row

			for (int j = i; j <= rows; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	private static void pattern13(final int rows) {
		System.err.println("Here is your Pattern 13....!!!");

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				if (j % 2 == 0) {
					System.out.print(0);
				} else {
					System.out.print(1);
				}
			}

			System.out.println();
		}
	}

	private static void pattern14(final int rows) {
		System.err.println("Here is your Pattern 14....!!!");

		for (int i = 1; i <= rows; i++) {
			int num;

			if (i % 2 == 0) {
				num = 0;

				for (int j = 1; j <= rows; j++) {
					System.out.print(num);

					num = (num == 0) ? 1 : 0;
				}
			} else {
				num = 1;

				for (int j = 1; j <= rows; j++) {
					System.out.print(num);

					num = (num == 0) ? 1 : 0;
				}
			}

			System.out.println();
		}
	}

	private static void pattern15(final int rows) {
		System.err.println("Here is your Pattern 15....!!!");

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= rows - i; j++) {
				System.out.print(1);
			}

			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}

			System.out.println();
		}
	}

	private static void pattern16(final int rows) {
		System.err.println("Here is your Pattern 16....!!!");

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				if (i == j) {
					System.out.print(i);
				} else {
					System.out.print(0);
				}
			}

			System.out.println();
		}
	}

	private static void pattern17(final int rows) {
		System.err.println("Here is your Pattern 17....!!!");

		for (int i = 1; i <= rows; i++) {
			int num = i;

			for (int j = 1; j <= i; j++) {
				System.out.print(num + " ");

				num = num + rows - j;
			}

			System.out.println();
		}
	}

}
