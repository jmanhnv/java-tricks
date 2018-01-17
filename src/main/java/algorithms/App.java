package algorithms;

public class App {

	public static void main(String[] args) {
		// Taking noOfRows value from the user
		int noOfRows = 9;

		// Diamond Pattern
		Algorithm.diamondOfStars(noOfRows);
		Algorithm.diamondOfNumbers(noOfRows);

		// Print-floyds-triangle
		Algorithm.floydsTriangle(noOfRows);

		// 1. Hien thi cac so nguyen to trong khoang tu 1-100
		System.out.println("*** DS so nguyen to 1-100 ***");
		for (int i = 1; i <= 100; i++) {
			if (Algorithm.isPrimeNumber(i)) {
				System.out.println(i);
			}
		}

		// 2. Phuong phap Eratosthene
		System.out.println("*** Eratosthene voi 100 so dau tien ***");
		int n = 100;
		boolean[] isPrime = Algorithm.eratosthene(n);
		System.out.println("So nguyen to < " + n);
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				System.out.println(i);
			}
		}

		// 3. Tim UCLN
		System.out.println("*** UCLN(12;15) ***");
		int a = 12;
		int b = 15;
		System.out.println(Algorithm.gcd(a, b));
		System.out.println(Algorithm.removeRecursionGcd(a, b));

		// 4. Tim BCNN
		System.out.println("*** BCNN(15;6) ***");
		System.out.println(Algorithm.lcm(15, 6));

		// 5. Tinh Giai thua
		System.out.println("*** Tinh 14! = ? ***");
		System.out.println(Algorithm.recusion(14));
		System.out.println(Algorithm.removeRecusion(14));

		//
		System.out.println(Algorithm.fact(14));
	}

}
