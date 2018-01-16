package collections.compare;

import java.util.Comparator;

import model.Country;

public class CountryComparator implements Comparator<Country> {
	public int compare(Country c1, Country c2) {
		return (c1.getId() < c2.getId()) ? -1 : (c1.getId() > c2.getId()) ? 1 : 0;
	}

}
