package algorithms;

public class App {

	public static void main(String[] args) {
		// Taking rows value from the user
		int rows = 9;

		// A.Print Diamond
		DiamondOfStars.diamondOfStars(rows);
		DiamondOfStars.diamondOfNumbers(rows);

		// B.Floyd’s triangle
		FloydsTriangle.floydsTriangle(rows);

		// 1. Hien thi cac so nguyen to trong khoang tu 1-100
		System.out.println("\nDS so nguyen to 1-100: ");
		for (int i = 1; i <= 100; i++) {
			if (Algorithm.isPrimeNumber(i)) {
				// System.out.println(i);
				System.out.printf("%d ", i);
			}
		}

		// 2. Phuong phap Eratosthene
		System.out.println();
		System.out.println("\nEratosthene voi 100 so dau tien: ");
		int n = 100;
		boolean[] isPrime = Algorithm.eratosthene(n);
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				// System.out.println(i);
				System.out.printf("%d ", i);
			}
		}

		// 3. Tim UCLN
		System.out.println();
		System.out.println("\nUCLN(12;15):");
		int a = 12;
		int b = 15;
		System.out.println(Algorithm.gcd(a, b));
		System.out.println(Algorithm.removeRecursionGcd(a, b));

		// 4. Tim BCNN
		System.out.println("\nBCNN(15;6):");
		System.out.println(Algorithm.lcm(15, 6));

		// 5. Tinh Giai thua
		System.out.println("\n14!:");
		System.out.println(Algorithm.factorial(14));
		System.out.println(Algorithm.factorialA(14));
		System.out.println(Algorithm.factorialB(14));

		// Number Pattern Programs In Java.
		rows = 7;
		NumberPatternPrograms.pattern1(rows);
		NumberPatternPrograms.pattern2(rows);
		NumberPatternPrograms.pattern3(rows);
		NumberPatternPrograms.pattern4(rows);
		NumberPatternPrograms.pattern5(rows);
		NumberPatternPrograms.pattern6(rows);
		NumberPatternPrograms.pattern7(rows);
		NumberPatternPrograms.pattern8(rows);
		NumberPatternPrograms.pattern9(rows);
		NumberPatternPrograms.pattern10(rows);
		NumberPatternPrograms.pattern11(rows);
		NumberPatternPrograms.pattern12(rows);
		NumberPatternPrograms.pattern13(rows);
		NumberPatternPrograms.pattern14(rows);
		NumberPatternPrograms.pattern15(rows);
		NumberPatternPrograms.pattern16(rows);
		NumberPatternPrograms.pattern17(rows);

		NumberPatternPrograms.pattern18();
		NumberPatternPrograms.pattern19();
		NumberPatternPrograms.pattern20();

		// Pyramid Of Numbers In Java
		rows = 9;
		PyramidOfNumbers.pattern1(rows);
		PyramidOfNumbers.pattern2(rows);
		PyramidOfNumbers.pattern3(rows);
		PyramidOfNumbers.pattern4(rows);
		PyramidOfNumbers.pattern5(rows);
		PyramidOfNumbers.pattern6(rows);
	}

}
