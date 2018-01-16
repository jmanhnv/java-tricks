/*
 * FILENAME TestLoop.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package sysenv;

import java.util.Arrays;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class TestLoop {
	class Employee {
		private int age;
		private String name;

		/**
		 * <p>
		 * Getter for age.
		 * </p>
		 * 
		 * @return the age
		 */
		public final int getAge() {
			return age;
		}

		/**
		 * <p>
		 * Setting value for age.
		 * </p>
		 * 
		 * @param age
		 *            the age to set
		 */
		public final void setAge(int age) {
			this.age = age;
		}

		/**
		 * <p>
		 * Getter for name.
		 * </p>
		 * 
		 * @return the name
		 */
		public final String getName() {
			return name;
		}

		/**
		 * <p>
		 * Setting value for name.
		 * </p>
		 * 
		 * @param name
		 *            the name to set
		 */
		public final void setName(String name) {
			this.name = name;
		}

	}

	@SuppressWarnings("unused")
	private static final int[] a = new int[] { 1, 2, 3, 1, 1, 1, 4, 2, 2, 5, 1 };

	public static void main(String[] args) {
		test();
		testAssert(5);// 0,3,4,5
		TestLoop obj = new TestLoop();
		Employee e = obj.new Employee();
		e.setAge(29);
		e.setName("XYZ");

		System.out.println("age " + e.getAge());
		System.out.println("name " + e.getName());

		System.out.println("==========" + Integer.valueOf("5"));

		Double x = 1d;
		if (x >= 0) System.out.println("x >= 0");
		else System.out.println("x < 0");
	}

	public static void testAssert(final int n) {
		if (n % 3 == 0) {
			System.out.println("chia het cho 3");
		} else if (n % 3 == 1) {
			System.out.println("chia 3 du 1");
		} else {
			assert n % 3 == 2;
			System.out.println("chia 3 du 2");
		}
	}

	public static boolean compare(final Object thisValue, final Object otherValue) {
		boolean result;
		if (thisValue == null) {
			result = otherValue == null;
			assert otherValue == null || otherValue.equals(null) == false;
		} else {
			result = otherValue != null && thisValue.equals(otherValue);
			assert thisValue.equals(null) == false;
		}
		return result;
	}

	// test some functions
	private static void test() {
		final int[] original = new int[] { 1, 1, 2, 8, 9, 8, 4, 7, 4, 9, 1 };
		System.out.println(Arrays.toString(original));
		quicksort(original);
		System.out.println(Arrays.toString(original));
		final int[] unqiue = new int[original.length];
		int prev = original[0];
		unqiue[0] = prev;
		int count = 1;
		for (int i = 1; i < original.length; ++i) {
			if (original[i] != prev) {
				unqiue[count++] = original[i];
			}
			prev = original[i];
		}
		System.out.println(Arrays.toString(unqiue));
		final int[] compressed = new int[count];
		System.arraycopy(unqiue, 0, compressed, 0, count);
		System.out.println(Arrays.toString(compressed));
	}

	private static void quicksort(final int[] values) {
		if (values.length == 0) return;
		quicksort(values, 0, values.length - 1);
	}

	private static void quicksort(final int[] values, final int low, final int high) {
		int i = low, j = high;
		int pivot = values[low + (high - low) / 2];
		while (i <= j) {
			while (values[i] < pivot) {
				i++;
			}
			while (values[j] > pivot) {
				j--;
			}
			if (i <= j) {
				swap(values, i, j);
				i++;
				j--;
			}
		}
		if (low < j) {
			quicksort(values, low, j);
		}
		if (i < high) {
			quicksort(values, i, high);
		}
	}

	private static void swap(final int[] values, final int i, final int j) {
		final int temp = values[i];
		values[i] = values[j];
		values[j] = temp;
	}

	// sorted data!
	public static int[] distinct(int[] arr) {
		int[] temp = new int[arr.length];

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];

			if (count > 0) if (temp[count - 1] == current) continue;

			temp[count] = current;
			count++;
		}

		int[] whitelist = new int[count];
		System.arraycopy(temp, 0, whitelist, 0, count);

		return whitelist;
	}

	public static int[] removeDuplicates(int[] arr) {
		int end = arr.length;
		for (int i = 0; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				if (arr[i] == arr[j]) {
					int shiftLeft = j;
					for (int k = j + 1; k < end; k++, shiftLeft++) {
						arr[shiftLeft] = arr[k];
					}
					end--;
					j--;
				}
			}
		}

		int[] whitelist = new int[end];
		for (int i = 0; i < end; i++) {
			whitelist[i] = arr[i];
		}
		return whitelist;
	}
}
