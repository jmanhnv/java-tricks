package algorithms;

/**
 * Number Pattern Programs In Java.
 * 
 * <pre>
 * Java programs to print the numbers or any other symbols in different patterns are one of the frequently asked interview programs mostly for freshers.
 * Because, they test the candidate’s logical ability as well as coding skills which are ‘must have skills’ for any software engineer.
 * In this post, I have collected some of the different number pattern programs in java and have tried to solve them.
 * They can ask you to create number pattern programs like in the below image (NumberPatternPrograms.png).
 * I hope they will be helpful for you guys.
 * </pre>
 * 
 * @author manhnv
 * @see http://javaconceptoftheday.com/number-pattern-programs-in-java/
 */
public class NumberPatternPrograms {
	/**
	 * Pattern 1
	 * 
	 * @param rows
	 */
	public static void pattern1(final int rows) {
		// Pattern 1:
		// 1
		// 1 2
		// 1 2 3
		// 1 2 3 4
		// 1 2 3 4 5
		// 1 2 3 4 5 6
		// 1 2 3 4 5 6 7

		System.out.println("\nHere is your pattern 1....!!!");
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	/**
	 * Pattern 2
	 * 
	 * @param rows
	 */
	public static void pattern2(final int rows) {
		// Pattern 2:
		// 1
		// 2 2
		// 3 3 3
		// 4 4 4 4
		// 5 5 5 5 5
		// 6 6 6 6 6 6
		// 7 7 7 7 7 7 7

		System.out.println("\nHere is your pattern 2....!!!");

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}

			System.out.println();
		}
	}

	/**
	 * Pattern 3
	 * 
	 * @param rows
	 */
	public static void pattern3(final int rows) {
		// Pattern 3:
		// 1
		// 1 2
		// 1 2 3
		// 1 2 3 4
		// 1 2 3 4 5
		// 1 2 3 4 5 6
		// 1 2 3 4 5 6 7
		// 1 2 3 4 5 6
		// 1 2 3 4 5
		// 1 2 3 4
		// 1 2 3
		// 1 2
		// 1

		System.out.println("\nHere is your pattern 3....!!!");

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

	/**
	 * Pattern 4
	 * 
	 * @param rows
	 */
	public static void pattern4(final int rows) {
		// Pattern 4:
		// 1 2 3 4 5 6 7
		// 1 2 3 4 5 6
		// 1 2 3 4 5
		// 1 2 3 4
		// 1 2 3
		// 1 2
		// 1

		System.out.println("\nHere is your pattern 4....!!!");

		for (int i = rows; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	/**
	 * Pattern 5
	 * 
	 * @param rows
	 */
	public static void pattern5(final int rows) {
		// Pattern 5:
		// 7 6 5 4 3 2 1
		// 7 6 5 4 3 2
		// 7 6 5 4 3
		// 7 6 5 4
		// 7 6 5
		// 7 6
		// 7

		System.out.println("\nHere is your pattern 5....!!!");

		for (int i = 1; i <= rows; i++) {
			for (int j = rows; j >= i; j--) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	/**
	 * Pattern 6
	 * 
	 * @param rows
	 */
	public static void pattern6(final int rows) {
		// Pattern 6:
		// 7
		// 7 6
		// 7 6 5
		// 7 6 5 4
		// 7 6 5 4 3
		// 7 6 5 4 3 2
		// 7 6 5 4 3 2 1

		System.out.println("\nHere is your pattern 6....!!!");

		for (int i = rows; i >= 1; i--) {
			for (int j = rows; j >= i; j--) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	/**
	 * Pattern 7
	 * 
	 * @param rows
	 */
	public static void pattern7(final int rows) {
		// Pattern 7:
		// 7 6 5 4 3 2 1
		// 6 5 4 3 2 1
		// 5 4 3 2 1
		// 4 3 2 1
		// 3 2 1
		// 2 1
		// 1

		System.out.println("\nHere is your pattern 7....!!!");

		for (int i = rows; i >= 1; i--) {
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	/**
	 * Pattern 8
	 * 
	 * @param rows
	 */
	public static void pattern8(final int rows) {
		// Pattern 8:
		// 1 2 3 4 5 6 7
		// 1 2 3 4 5 6
		// 1 2 3 4 5
		// 1 2 3 4
		// 1 2 3
		// 1 2
		// 1
		// 1 2
		// 1 2 3
		// 1 2 3 4
		// 1 2 3 4 5
		// 1 2 3 4 5 6
		// 1 2 3 4 5 6 7

		System.out.println("\nHere is your pattern 8....!!!");

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

	/**
	 * Pattern 9
	 * 
	 * @param rows
	 */
	public static void pattern9(final int rows) {
		// Pattern 9:
		// 1
		// 1 2 1
		// 1 2 3 2 1
		// 1 2 3 4 3 2 1
		// 1 2 3 4 5 4 3 2 1
		// 1 2 3 4 5 6 5 4 3 2 1
		// 1 2 3 4 5 6 7 6 5 4 3 2 1

		System.out.println("\nHere is your pattern 9....!!!");

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

	/**
	 * Pattern 10
	 * 
	 * @param rows
	 */
	public static void pattern10(final int rows) {
		// Pattern 10:
		// 1
		// 2 1
		// 3 2 1
		// 4 3 2 1
		// 5 4 3 2 1
		// 6 5 4 3 2 1
		// 7 6 5 4 3 2 1

		System.out.println("\nHere is your pattern 10....!!!");

		for (int i = 1; i <= rows; i++) {
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

	/**
	 * Pattern 11
	 * 
	 * @param rows
	 */
	public static void pattern11(final int rows) {
		// @formatter:off

		// Pattern 11:
		// 1234567
		// 234567
		// 34567
		// 4567
		// 567
		// 67
		// 7
		// 67
		// 567
		// 4567
		// 34567
		// 234567
		// 1234567

		// @formatter:on
		System.out.println("\nHere is your pattern 11....!!!");

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

	/**
	 * Pattern 12
	 * 
	 * @param rows
	 */
	public static void pattern12(final int rows) {
		// @formatter:off
		// Pattern 12:
		// 1 2 3 4 5 6 7
		// 2 3 4 5 6 7
		// 3 4 5 6 7
		// 4 5 6 7
		// 5 6 7
		// 6 7
		// 7
		// 6 7
		// 5 6 7
		// 4 5 6 7
		// 3 4 5 6 7
		// 2 3 4 5 6 7
		// 1 2 3 4 5 6 7

		// @formatter:on
		System.out.println("\nHere is your pattern 12....!!!");

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

	/**
	 * Pattern 13
	 * 
	 * @param rows
	 */
	public static void pattern13(final int rows) {
		// Pattern 13:
		// 1
		// 10
		// 101
		// 1010
		// 10101
		// 101010
		// 1010101

		System.out.println("\nHere is your pattern 13....!!!");

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

	/**
	 * Pattern 14
	 * 
	 * @param rows
	 */
	public static void pattern14(final int rows) {
		// Pattern 14:
		// 1010101
		// 0101010
		// 1010101
		// 0101010
		// 1010101
		// 0101010
		// 1010101

		System.out.println("\nHere is your pattern 14....!!!");

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

	/**
	 * Pattern 15
	 * 
	 * @param rows
	 */
	public static void pattern15(final int rows) {
		// Pattern 15:
		// 1111111
		// 1111122
		// 1111333
		// 1114444
		// 1155555
		// 1666666
		// 7777777

		System.out.println("\nHere is your pattern 15....!!!");

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

	/**
	 * Pattern 16
	 * 
	 * @param rows
	 */
	public static void pattern16(final int rows) {
		// Pattern 16:
		// 0000000
		// 0100000
		// 0020000
		// 0003000
		// 0000400
		// 0000050
		// 0000006

		System.out.println("\nHere is your pattern 16....!!!");

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

	/**
	 * Pattern 17
	 * 
	 * @param rows
	 */
	public static void pattern17(final int rows) {
		// Pattern 17: right with rows = 5
		// 1
		// 2 6
		// 3 7 10
		// 4 8 11 13
		// 5 9 12 14 15

		System.out.println("\nHere is your pattern 17....!!!");

		for (int i = 1; i <= rows; i++) {
			int num = i;

			for (int j = 1; j <= i; j++) {
				System.out.print(num + " ");

				num = num + rows - j;
			}

			System.out.println();
		}
	}

	/**
	 * Pattern 18. Different Pyramid Pattern Programs In Java.
	 * 
	 * @see http://javaconceptoftheday.com/how-to-create-pyramid-of-numbers-in-java/
	 *      {@link PyramidOfNumbers}
	 */
	public static void pattern18() {
		// Pattern 18: Different Pyramid Pattern Programs In Java
		// TODO - refer to PyramidOfNumbers.java
		System.out.println("\nDifferent Pyramid Pattern Programs In Java - PyramidOfNumbers.java");
	}

	/**
	 * Pattern 19. Diamond Pattern Programs In Java.
	 * 
	 * @see http://javaconceptoftheday.com/diamond-pattern-program-in-java/
	 *      {@link DiamondOfStars}
	 */
	public static void pattern19() {
		// Pattern 19: Diamond Pattern Programs In Java
		// TODO - refer to DiamondOfStars.java
		System.out.println("\nDiamond Pattern Programs In Java - DiamondOfStars.java");
	}

	/**
	 * Pattern 20. Floyd’s Triangle In Java.
	 * 
	 * @see http://javaconceptoftheday.com/how-to-print-floyds-triangle-in-java/
	 *      {@link FloydsTriangle}
	 */
	public static void pattern20() {
		// Pattern 20: Floyd’s Triangle In Java
		// TODO - refer to FloydsTriangle.java
		System.out.println("\nFloyd’s Triangle In Java - FloydsTriangle.java");
	}
}
