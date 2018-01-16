package utils;

// A leap year is a year containing one additional day (366 days a year). It mean that February have 29 days
public class DetermineLeapYearExample {

	public static void main(String[] args) {

		// year we want to check
		int year = 2016;

		// if year is divisible by 4, it is a leap year

		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
			System.out.println("Year " + year + " is a leap year");
		else System.out.println("Year " + year + " is not a leap year");
	}

}
