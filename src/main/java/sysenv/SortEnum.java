package sysenv;

import java.util.Arrays;
import java.util.Comparator;

import enums.EnumType;

public class SortEnum {

	/**
	 * <p>
	 * Add one-sentence summarising the method functionality here; this sentence should only contain one full-stop.
	 * </p>
	 * 
	 * @param args
	 **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EnumType.ContactType[] titles = EnumType.ContactType.values();
		System.out.println("*** before ***");
		for (EnumType.ContactType contactTitle : titles)
			System.out.println(contactTitle);

		System.out.println("*** after ***");
		// Arrays.sort(titles, new Comparator<ContactTitle>()
		// {
		// @Override
		// public int compare(ContactTitle o1, ContactTitle o2)
		// {
		// return o1.toString().compareTo(o2.toString());
		// }
		// });

		// TODO - or other way like this
		sortAscEnum(titles);
		for (EnumType.ContactType contactTitle : titles)
			System.out.println(contactTitle);
	}

	private static <T extends Enum<? extends Enum<?>>> void sortAscEnum(T[] t) {
		Arrays.sort(t, new Comparator<T>() {
			public int compare(T t1, T t2) {
				return t1.toString().compareTo(t2.toString());
			}
		});
	}

	// *** before ***
	// Dr.
	// Mr.
	// Miss.
	// Ms.
	// Mrs.
	// Prof.
	// *** after ***
	// Dr.
	// Miss.
	// Mr.
	// Mrs.
	// Ms.
	// Prof.
}
