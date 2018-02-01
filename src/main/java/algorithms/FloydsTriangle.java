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

	public static void main(String[] args) {
		// How many rows you want in Floyd's Triangle?
		// 5
		// Floyd's Triangle:
		// 1
		// 2 3
		// 4 5 6
		// 7 8 9 10
		// 11 12 13 14 15

		floyds(5);

		// @formatter:off
		//How it works?
		//		Let noOfRows = 5 and value = 1.
		//
		//		1st iteration :
		//
		//		for i = 1
		//
		//		for j = 1
		//
		//		Print value  –>  Print 1
		//
		//		value++  –>  value = 2
		//
		//		for j = 2
		//
		//		As j > i
		//
		//		break inner for loop
		//
		//		Go To Next Line
		//
		//		After 1st iteration, output will be,
		//
		//		?
		//		1
		//		1
		//		2nd iteration :
		//
		//		for i = 2
		//
		//		for j = 1
		//
		//		Print value  –>  Print 2
		//
		//		value++  –>  value = 3
		//
		//		for j = 2
		//
		//		Print value  –>  Print 3
		//
		//		value++  –>  value = 4
		//
		//		for j = 3
		//
		//		As j > i
		//
		//		break inner for loop
		//
		//		Go To Next Line
		//
		//		After 2nd iteration, output will look like below,
		//
		//		?
		//		1
		//		2
		//		1   
		//		2    3   
		//		3rd iteration :
		//
		//		for i = 3
		//
		//		for j = 1
		//
		//		Print value  –>  Print 4
		//
		//		value++  –>  value = 5
		//
		//		for j = 2
		//
		//		Print value  –>  Print 5
		//
		//		value++  –>  value = 6
		//
		//		for j = 3
		//
		//		Print value  –>  Print 6
		//
		//
		//		 
		//		value++  –>  value = 7
		//
		//		for j = 4
		//
		//		As j > i
		//
		//		break inner for loop
		//
		//		Go To Next Line
		//
		//		After 3rd iteration, output will be,
		//
		//		?
		//		1
		//		2
		//		3
		//		1   
		//		2    3   
		//		4    5    6   
		//		4th iteration :
		//
		//		for i = 4
		//
		//		for j = 1
		//
		//		Print value  –>  Print 7
		//
		//		value++  –>  value = 8
		//
		//		for j = 2
		//
		//		Print value  –>  Print 8
		//
		//		value++  –>  value = 9
		//
		//		for j = 3
		//
		//		Print value  –>  Print 9
		//
		//		value++  –>  value = 10
		//
		//		for j = 4
		//
		//		Print value  –>  Print 10
		//
		//		value++  –>  value = 11
		//
		//		for j = 5
		//
		//		As j > i
		//
		//		break inner for loop
		//
		//		Go To Next Line
		//
		//		After 4th iteration, output will be,
		//
		//		?
		//		1
		//		2
		//		3
		//		4
		//		1   
		//		2    3   
		//		4    5    6   
		//		7    8    9    10   
		//		5th iteration :
		//
		//		for i = 5
		//
		//		for j = 1
		//
		//		Print value  –>  Print 11
		//
		//		value++  –>  value = 12
		//
		//		for j = 2
		//
		//		Print value  –>  Print 12
		//
		//		value++  –>  value = 13
		//
		//		for j = 3
		//
		//		Print value  –>  Print 13
		//
		//		value++  –>  value = 14
		//
		//		for j = 4
		//
		//		Print value  –>  Print 14
		//
		//		value++  –>  value = 15
		//
		//		for j = 5
		//
		//		Print value  –>  Print 15
		//
		//		value++  –>  value = 16
		//
		//		for j = 6
		//
		//		As j > i
		//
		//		break inner for loop
		//
		//		Go To Next Line
		//
		//		After 5th iteration, output will be,
		//
		//		?
		//		1
		//		2
		//		3
		//		4
		//		5
		//		1   
		//		2    3   
		//		4    5    6   
		//		7    8    9    10   
		//		11   12   13   14   15   
		//		6th Iteration :
		//
		//		for i = 6
		//
		//		As i > noOfRows
		//
		//		Break outer for loop
		//
		//		Final Output :
		//
		//		?
		//		1
		//		2
		//		3
		//		4
		//		5
		//		6
		//		7
		//		8
		//		How many rows you want in Floyd's Triangle?
		//		5
		//		Floyd's Triangle : 
		//		1   
		//		2    3   
		//		4    5    6   
		//		7    8    9    10   
		//		11   12   13   14   15    
		// @formatter:on
	}

	private static void floyds(final int noOfRows) {
		int value = 1;

		System.out.println("Floyd's Triangle:");
		for (int i = 1; i <= noOfRows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(value + "\t");

				value++;
			}

			System.out.println();
		}
	}
}
