package algorithms;

// http://javadevexpress.blogspot.com/2014/01/tong-hop-cac-thuat-toan-co-ban-giai.html
// refer: http://diendan.congdongcviet.com/threads/t54134::tong-hop-cac-thuat-toan-co-ban.cpp
public final class Algorithm {
	/**
	 * <p>
	 * 1. Kiểm tra sô�? nguyên tô�?.
	 * </p>
	 * 
	 * <pre>
	 * + �?ịnh nghĩa: Là số nguyên lớn hơn 1, chỉ có 2 ước là 1 và chính nó.
	 * + Các số nguyên tố từ 1-100: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97.
	 * + Thuật toán: �?ể kiểm tra 1 số nguyên n có phải số nguyên tố hay không, ta làm theo các bước:
	 * - Nếu n < 2 thì không phải số nguyên tố.
	 * - Kiểm tra trong đoạn từ 2..sqrt(n) xem có ước của n không, nếu có tồn tại thì n không phải số nguyên tố
	 * - Ngược lại, n là số nguyên tố.
	 * </pre>
	 * 
	 * @param n
	 *            số cần kiểm tra
	 * @return true - nếu là số nguyên tố, false - không phải là số nguyên tố.
	 */
	public static boolean isPrimeNumber(final int n) {
		if (n < 2) return false;

		int temp = (int) Math.sqrt(n);
		for (int i = 2; i <= temp; i++) {
			if (n % i == 0) return false;
		}

		return true;
	}

	/**
	 * <p>
	 * 2. Phương pha�?p sàng Eratosthene.
	 * </p>
	 * 
	 * <pre>
	 * + Mục đích: �?ể lập bảng các số nguyên tố nh�? hơn hoặc bằng 1 số n cho trước.
	 * + Thuật toán: Sử dụng 1 bảng bool isPrimeNumber[0..n+1] để lưu kết quả.
	 * - Khởi tạo: tất cả các số từ 1->n là nguyên tố.
	 * - Xóa số 1 ra kh�?i bảng.
	 * - Lặp: Tìm 1 số nguyên tố đầu tiên trong bảng sau đó xóa tất cả các bội của nó trong bảng.
	 * - Quá trình lặp kết thúc khi gặp số nguyên tố >= sqrt(n).
	 * - Tất cả các số chưa bị xóa trong bảng là số nguyên tố.
	 * </pre>
	 * 
	 * @param n
	 *            số cần kiểm tra
	 * @return true - mảng các số nguyên tố cần tìm.
	 */
	public static boolean[] eratosthene(int n) {
		// tao mang boolean
		boolean[] isPrime = new boolean[n + 1];

		// khởi tạo: các số từ 1->n được coi là nguyên tố.
		for (int i = 0; i <= n; i++) {
			isPrime[i] = true;
		}

		// so 1 khong phai so nguyen to
		isPrime[1] = false;
		int k = 1;

		// lap cho den khi k <= (int)Math.sqrt(n) sai thi khong lap nua (tham
		// khao vong lap while)
		// hay noi cach khac khi nao k <= can bac 2 cua n thi thuc hien vong lap
		while (k <= (int) Math.sqrt(n)) {
			k++;
			// tìm số nguyên tố đầu tiên
			while (!isPrime[k])
				k++;

			// xóa các bội của k kh�?i danh sách các số nguyên tố
			int j = 2;
			while (k * j <= n) {
				isPrime[k * j] = false;
				j++;
			}
		}

		return isPrime;
	}

	// ----------------------------------------> START
	/**
	 * <p>
	 * 3. Tìm ươ�?c sô�? chung lơ�?n nhâ�?t.
	 * </p>
	 * 
	 * <pre>
	 * + �?ịnh nghĩa: Ước số chung lớn nhất (Greatest Common Divisor) của 2 số a và b được định nghĩa như sau: gcd(a,b)=d <=> d là số lớn nhất trong tất cả các ước chung của a và b.
	 * Uoc so cua 12: U12(1;2;3;4;6;12)
	 * Uoc so cua 30: U30(1;2;5;6;10;15;30)
	 * GCD(12;30) = 6
	 * + Thuật toán: Giải thuật Euclid, định nghĩa đệ qui như sau:
	 * - gcd(a,0) = a.
	 * - gcd(a,b) = gcd(b,a mod b).
	 * </pre>
	 * 
	 * @param a
	 * @param b
	 * @return true - nếu là số nguyên tố, false - không phải là số nguyên tố.
	 */
	public static int deQuy_GCD(int a, int b) {
		// neu b = 0, uoc chung lon nhat chinh la a
		if (b == 0) return a;

		// chia lay phan du
		int temp = a % b;
		return deQuy_GCD(b, temp);
	}

	public static int khuDeQuy_GCD(int a, int b) {
		while (b != 0) {
			// chia lay phan du
			int temp = a % b;
			a = b;
			b = temp;
		}

		return a;
	}
	// ----------------------------------------< END

	/**
	 * <p>
	 * 4. Tìm bội sô�? chung nhỏ nhâ�?t.
	 * </p>
	 * 
	 * <pre>
	 * + �?ịnh nghĩa: Bội số chung nh�? nhất (Least Common Multiple) của 2 số a và b được định nghĩa LCM(a,b) = m <=> m là số nh�? nhất trong tất cả các bội chung của a và b.
	 * B(4) = {0;4;8;12;16;20;24;28;32;...}
	 * B(6) = {0;6;12;18;24;30;36;...}
	 * => BCNN cua 4 va 6: BC(4;6) = 12 hay LCM(4,6) = 12
	 * + Thuật toán: Ta có công thức: LCM(a,b) = |a*b|/gcd(a,b)
	 * </pre>
	 * 
	 * @param a
	 * @param b
	 * @return bội chung nh�? nhất.
	 */
	public static int LCM(int a, int b) {
		// tri tuyet doi a*b
		int abs = Math.abs(a * b);
		// su dung ham tim UCLN
		return abs / khuDeQuy_GCD(a, b);
	}

	// ----------------------------------------> START
	/**
	 * <p>
	 * 5. Ti�?nh giai thừa.
	 * </p>
	 * 
	 * <pre>
	 * + Giai thừa của 1 số nguyên dương n là tích tất cả các số nguyên dương nh�? hơn hoặc bằng n.
	 * </pre>
	 * 
	 * @param n
	 * @return bội chung nh�? nhất.
	 */
	public static long deQuy_Factorial(int n) {
		if (n == 0) return 1;

		return deQuy_Factorial(n - 1) * n;
	}

	public static long khuDeQuy_Factorial(int n) {
		long result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}

		return result;
	}
	// ----------------------------------------< END

	// ----------------------------------------> CALCULATING FACTORIAL
	public static long factorial(long n) {
		// WAY - 01
		if (n == 0) return 1;

		return n * factorial(n - 1);
	}

	public static int factorial(int n) {
		// WAY - 02: using loop
		int fact = 1;
		for (int i = n; i > 1; i--)
			fact *= i;

		return fact;
	}
	// ----------------------------------------< END

	public static void main(String[] args) {
		// TODO - Testing result
		// 1. Kiểm tra sô�? nguyên tô�?: Tìm các số nguyên tố từ 1-100
		System.err.println("*** Kiểm tra sô�? nguyên tô�? (Tìm các số nguyên tố từ 1-100) ***");
		for (int i = 1; i <= 100; i++) {
			if (isPrimeNumber(i)) {
				System.out.println(i);
			}
		}

		// 2. Phương pha�?p sàng Eratosthene
		System.err.println("*** Phương pha�?p sàng Eratosthene (của 100 số đầu tiên) ***");
		int n = 100;
		boolean[] isPrime = eratosthene(n);
		System.out.println("Các số nguyên tố < " + n);
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				System.out.println(i);
			}
		}

		// 3. Tìm ươ�?c sô�? chung lơ�?n nhâ�?t
		System.err.println("*** Tìm ươ�?c sô�? chung lơ�?n nhâ�?t (12, 15) ***");
		int a = 12;
		int b = 15;
		System.out.println(deQuy_GCD(a, b));
		System.out.println(khuDeQuy_GCD(a, b));

		// 4. Tìm bội sô�? chung nhỏ nhâ�?t
		System.err.println("*** Tìm bội sô�? chung nhỏ nhâ�?t (15, 6) ***");
		System.out.println(LCM(15, 6));

		// 5. Ti�?nh giai thừa
		System.err.println("*** Ti�?nh giai thừa [14] ***");
		System.out.println(deQuy_Factorial(14));
		System.out.println(khuDeQuy_Factorial(14));
	}

}
