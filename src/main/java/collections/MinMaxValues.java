package collections;

/*
 * Three ways to find minimum and maximum values in a Java array. Simple array: int[] nums={6,-1,-2,-3,0,1,2,3,4};
 * Arrays.sort(nums); System.out.println("Minimum = " + nums[0]); System.out.println("Maximum = " +
 * nums[nums.length-1]);
 */

import java.util.Arrays;

public class MinMaxValues {
	public static void main(String args[]) {
		int numbers[] = { 1, 5, -9, 12, -3, 89, 18, 23, 4, -6 };
		// Find minimum (lowest) value in array using loop
		System.out.println("Minimum Value <using loop> = " + getMinValue(numbers));
		// Find maximum (largest) value in array using loop
		System.out.println("Maximum Value <using loop> = " + getMaxValue(numbers));

		// Find minimum (lowest) value in array by sorting array
		System.out.println("Minimum Value <by sorting array> = " + minValue(numbers));
		// Find maximum (largest) value in array by sorting array
		System.out.println("Maximum Value <by sorting array> = " + maxValue(numbers));

		// Find minimum (lowest) value in array using recursion
		System.out.println("Minimum Value <using recursion> = " + getMin(numbers, 0, numbers[0]));
		// Find maximum (largest) value in array using recursion
		System.out.println("Maximum Value <using recursion> = " + getMax(numbers, 0, numbers[0]));
	}

	// Find maximum (largest) value in array using loop
	public static int getMaxValue(int[] numbers) {
		int maxValue = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > maxValue) {
				maxValue = numbers[i];
			}
		}
		return maxValue;
	}

	// Find minimum (lowest) value in array using loop
	public static int getMinValue(int[] numbers) {
		int minValue = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < minValue) {
				minValue = numbers[i];
			}
		}
		return minValue;
	}

	// Find minimum (lowest) value in array using array sort
	public static int minValue(int[] numbers) {
		Arrays.sort(numbers);
		return numbers[0];
	}

	// Find maximum (largest) value in array using array sort
	public static int maxValue(int[] numbers) {
		Arrays.sort(numbers);
		return numbers[numbers.length - 1];
	}

	// Find maximum (largest) value in array using recursion
	public static int getMax(int[] numbers, int a, int n) {
		return a >= numbers.length ? n : Math.max(n, getMax(numbers, a + 1, numbers[a] > n ? numbers[a] : n));
	}

	// Find minimum (lowest) value in array using recursion
	private static int getMin(int[] numbers, int a, int n) {
		return a <= numbers.length ? n : Math.min(n, getMin(numbers, a + 1, numbers[a] < n ? numbers[a] : n));
	}
}