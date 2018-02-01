package algorithms;

/**
 * Cac thuat toan co ban.
 * 
 * @author Johny
 *
 */
public final class Algorithm {
	/**
	 * <p>
	 * 1. Kiem tra 1 so nguyen co phai la so nguyen to hay khong.
	 * </p>
	 * 
	 * <pre>
	 * * DN: La so nguyen > 1, chi co hai uoc so la 1 va chinh no.
	 * * VD cac so nguyen to tu 1-100: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.
	 * * Thuat toan: De kiem tra mot so nguyen n co phai la so nguyen to hay khong ta lam nhu sau:
	 * - Neu n < 2 -> n khong phai la so nguyen to
	 * - Kiem tra trong doan tu 2..sqrt(n) xem co uoc cua n khong?
	 * 		+ Neu ton tai thi n khong phai la so nguyen to
	 * 		+ Nguoc lai, n la so nguyen to.
	 * </pre>
	 * 
	 * @param n
	 *            so nguyen can kiem tra
	 * @return true - n la so nguyen to, false - n khong phai la so nguyen to.
	 * @see http://javadevexpress.blogspot.com/2014/01/tong-hop-cac-thuat-toan-co-ban-giai.html
	 * @see http://diendan.congdongcviet.com/threads/t54134::tong-hop-cac-thuat-toan-co-ban.cpp
	 */
	public static boolean isPrimeNumber(final int n) {
		if (n < 2)
			return false;

		int temp = (int) Math.sqrt(n);
		for (int i = 2; i <= temp; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	/**
	 * <p>
	 * 2. Phuong phap sang Eratosthene.
	 * </p>
	 * 
	 * <pre>
	 * * Muc dich: De lap bang cac so nguyen to nho hon hoac bang so n cho truoc.
	 * * Thuat toan:
	 * - Su dung 1 mang bool isPrimeNumber[0..n+1] de luu ket qua.
	 * - Khoi tao tat ca cac so tu 1->n la so nguyen to.
	 * - Xoa so 1 ra khoi mang.
	 * - Lap: Tim 1 so nguyen to dau tien trong mang sau do xoa tat ca cac boi cua no trong mang.
	 * - Qua trinh lap lai ket thuc khi gap so nguyen >= sqrt(n).
	 * - Tat ca cac so con lai chua bi xoa trong mang la so nguyen to.
	 * </pre>
	 * 
	 * @param n
	 *            so nguyen can kiem tra
	 * @return true - mang cac so nguyen to can tim.
	 * @see http://javadevexpress.blogspot.com/2014/01/tong-hop-cac-thuat-toan-co-ban-giai.html
	 * @see http://diendan.congdongcviet.com/threads/t54134::tong-hop-cac-thuat-toan-co-ban.cpp
	 */
	public static boolean[] eratosthene(final int n) {
		// khoi tao mang boolean
		boolean[] isPrime = new boolean[n + 1];

		// Khoi tao tat ca cac so tu 1->n la so nguyen to
		for (int i = 0; i <= n; i++) {
			isPrime[i] = true;
		}

		// So 1 khong phai so nguyen to
		isPrime[1] = false;
		int k = 1;

		// lap cho den khi k <= (int)Math.sqrt(n) sai thi khong lap nua (tham khao vong
		// lap while)
		// hay noi cach khac khi nao k <= can bac 2 cua n thi thuc hien vong lap
		while (k <= (int) Math.sqrt(n)) {
			k++;
			// tim so nguyen to dau tien
			while (!isPrime[k])
				k++;

			// Xoa cac boi cua k khoi danh sach cac so nguyen to
			int j = 2;
			while (k * j <= n) {
				isPrime[k * j] = false;
				j++;
			}
		}

		return isPrime;
	}

	/**
	 * <p>
	 * 3. Tim Uoc so chung lon nhat (UCLN) cua 2 so a va b.
	 * </p>
	 * 
	 * <pre>
	 * * DN: Uoc so chung lon nhat (Greatest Common Divisor) cua 2 so a va b duoc dinh nghia nhu sau:
	 * 		 GCD(a,b)=d <=> d la uoc so lon nhat trong tat ca cac uoc chung cua a va b.
	 * * VD: Uoc so cua 12: U12(1;2;3;4;6;12); Uoc so cua 30: U30(1;2;5;6;10;15;30) => GCD(12;30) = 6
	 * * Thuat toan: Giai thuat Euclid:
	 * - GCD(a,0) = a.
	 * - GCD(a,b) = GCD(b,a mod b).
	 * </pre>
	 * 
	 * @param a
	 * @param b
	 * @return ucln
	 * @see http://javadevexpress.blogspot.com/2014/01/tong-hop-cac-thuat-toan-co-ban-giai.html
	 * @see http://diendan.congdongcviet.com/threads/t54134::tong-hop-cac-thuat-toan-co-ban.cpp
	 */
	public static int gcd(final int a, final int b) {
		// neu b = 0, uoc chung lon nhat chinh la a
		if (b == 0)
			return a;

		// chia lay phan du
		int temp = a % b;
		return gcd(b, temp);
	}

	/**
	 * Tim Uoc so chung lon nhat (UCLN) cua 2 so a va b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @see http://javadevexpress.blogspot.com/2014/01/tong-hop-cac-thuat-toan-co-ban-giai.html
	 * @see http://diendan.congdongcviet.com/threads/t54134::tong-hop-cac-thuat-toan-co-ban.cpp
	 */
	public static int removeRecursionGcd(int a, int b) {
		while (b != 0) {
			// chia lay phan du
			int temp = a % b;
			a = b;
			b = temp;
		}

		return a;
	}

	/**
	 * <p>
	 * 4. Tim Boi so chung nho nhat (BCNN) cua 2 so a va b.
	 * </p>
	 * 
	 * <pre>
	 * * DN: Boi so chung nho nhat (Least Common Multiple) cua 2 so a va b duong dinh nghia:
	 * 		 LCM(a,b) = m <=> m boi chung nho nhat trong tat cac cac boi chung cua a va b.
	 * * VD: B(4) = {0;4;8;12;16;20;24;28;32;...}; B(6) = {0;6;12;18;24;30;36;...} => LCM(4;6) = 12
	 * * Thuat toan: ta co cong thuc: LCM(a,b) = |a*b|/GCD(a,b)
	 * </pre>
	 * 
	 * @param a
	 * @param b
	 * @return bcnn.
	 * @see http://javadevexpress.blogspot.com/2014/01/tong-hop-cac-thuat-toan-co-ban-giai.html
	 * @see http://diendan.congdongcviet.com/threads/t54134::tong-hop-cac-thuat-toan-co-ban.cpp
	 */
	public static int lcm(final int a, final int b) {
		// tri tuyet doi a*b
		int abs = Math.abs(a * b);
		// su dung ham tim UCLN
		return abs / removeRecursionGcd(a, b);
	}

	/**
	 * <p>
	 * 5. Tinh giai thua cua mot so nguyen n.
	 * </p>
	 * Java Factorial Using Recursion Example This Java example shows how to
	 * generate factorial of a given number using recursive function.
	 * 
	 * <pre>
	 * + Giai thua cua 1 so nguyen duong n la tich tat ca cac so nguyen duong nho hon hoac bang n.
	 * </pre>
	 * 
	 * @param n
	 * @return gia thua cua so nguyen duong n.
	 * @see http://javadevexpress.blogspot.com/2014/01/tong-hop-cac-thuat-toan-co-ban-giai.html
	 * @see http://diendan.congdongcviet.com/threads/t54134::tong-hop-cac-thuat-toan-co-ban.cpp
	 */
	public static long factorial(final int n) {
		if (n == 0)
			return 1;

		return n * factorial(n - 1);
	}

	/**
	 * Tinh giai thua so so nguyen n.
	 * 
	 * @param n
	 * @return
	 * @see http://javadevexpress.blogspot.com/2014/01/tong-hop-cac-thuat-toan-co-ban-giai.html
	 * @see http://diendan.congdongcviet.com/threads/t54134::tong-hop-cac-thuat-toan-co-ban.cpp
	 */
	public static long factorialA(final int n) {
		// WAY - 01
		if (n == 0)
			return 1;

		return n * factorial(n - 1);
	}

	/**
	 * Tinh giai thua so so nguyen n.
	 * 
	 * @param n
	 * @return
	 * @see http://javadevexpress.blogspot.com/2014/01/tong-hop-cac-thuat-toan-co-ban-giai.html
	 * @see http://diendan.congdongcviet.com/threads/t54134::tong-hop-cac-thuat-toan-co-ban.cpp
	 */
	public static long factorialB(final int n) {
		// WAY - 02
		long result = 1;
		for (int i = 1; i <= n; i++)
			result *= i;

		return result;
	}
}
