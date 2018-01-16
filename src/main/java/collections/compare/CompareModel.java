package collections.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import model.Country;
import model.Employee;
import model.EmployeeEx;
import model.PersonEx;

public class CompareModel {
	public static void main(String[] args) {
		System.out.println("*** For Comparable ***");
		doComparable();

		System.out.println("\n*** For Comparator ***");
		doComparator();

		System.out.println("\n*** For Person ***");
		doSortPerson();

		System.out.println("\n*** For Employee ***");
		doSortEmployee();

		System.out.println("\n*** doSortEmployeeEx ***");
		doSortEmployeeEx();

		System.out.println("******************");
	}

	/**
	 * Objects which implement Comparable in java can be used as keys in a SortedMap like TreeMap or SortedSet like
	 * TreeSet without implementing any other interface.
	 */
	private static void doSortEmployeeEx() {
		EmployeeEx indiaCountry = new EmployeeEx(1, "India");
		EmployeeEx chinaCountry = new EmployeeEx(4, "China");
		EmployeeEx nepalCountry = new EmployeeEx(3, "Nepal");
		EmployeeEx bhutanCountry = new EmployeeEx(2, "Bhutan");

		List<EmployeeEx> employees = new ArrayList<EmployeeEx>();
		employees.add(indiaCountry);
		employees.add(chinaCountry);
		employees.add(nepalCountry);
		employees.add(bhutanCountry);

		// EmployeeEx must implements Comparable<EmployeeEx>
		Set<EmployeeEx> sets = new TreeSet<EmployeeEx>(employees);
		for (EmployeeEx emp : sets)
			System.out.println("EmpId: " + emp.getId() + " || " + "EmpName: " + emp.getName());
	}

	// For Comparable
	private static void doComparable() {
		Country indiaCountry = new Country(1, "India");
		Country chinaCountry = new Country(4, "China");
		Country nepalCountry = new Country(3, "Nepal");
		Country bhutanCountry = new Country(2, "Bhutan");

		List<Country> countries = new ArrayList<Country>();
		countries.add(indiaCountry);
		countries.add(chinaCountry);
		countries.add(nepalCountry);
		countries.add(bhutanCountry);

		System.out.println("Before Sort");
		for (Country country : countries)
			System.out.println("Country Id: " + country.getId() + " || " + "Country name: " + country.getName());

		System.out.println("After Sort");
		Collections.sort(countries);
		for (Country country : countries)
			System.out.println("Country Id: " + country.getId() + " || " + "Country name: " + country.getName());
	}

	// For Comparator
	private static void doComparator() {
		Country indiaCountry = new Country(1, "India");
		Country chinaCountry = new Country(4, "China");
		Country nepalCountry = new Country(3, "Nepal");
		Country bhutanCountry = new Country(2, "Bhutan");

		List<Country> countries = new ArrayList<Country>();
		countries.add(indiaCountry);
		countries.add(chinaCountry);
		countries.add(nepalCountry);
		countries.add(bhutanCountry);

		System.out.println("Before Sort by id");
		for (Country country : countries)
			System.out.println("Country Id: " + country.getId() + " || " + "Country name: " + country.getName());

		System.out.println("After Sort by id");
		Collections.sort(countries, new CountryComparator());
		for (Country country : countries)
			System.out.println("Country Id: " + country.getId() + " || " + "Country name: " + country.getName());

		// sort by name
		Collections.sort(countries, new Comparator<Country>() {
			public int compare(Country c1, Country c2) {
				return c1.getName().compareTo(c2.getName());
			}
		});

		System.out.println("After Sort by name");
		for (Country country : countries)
			System.out.println("Country Id: " + country.getId() + " || " + "Country name: " + country.getName());
	}

	// For Person
	private static void doSortPerson() {
		PersonEx indiaCountry = new PersonEx(1, "India");
		PersonEx chinaCountry = new PersonEx(4, "China");
		PersonEx nepalCountry = new PersonEx(3, "Nepal");
		PersonEx bhutanCountry = new PersonEx(2, "Bhutan");

		List<PersonEx> persons = new ArrayList<PersonEx>();
		persons.add(indiaCountry);
		persons.add(chinaCountry);
		persons.add(nepalCountry);
		persons.add(bhutanCountry);

		Iterator<PersonEx> it = persons.iterator();

		System.out.println("*** Before Sort ***");
		while (it.hasNext()) {
			PersonEx p = it.next();
			System.out.println(p.getName());
		}

		// sort by name
		Collections.sort(persons, new Comparator<PersonEx>() {
			public int compare(PersonEx p1, PersonEx p2) {
				return p1.getName().compareTo(p2.getName());
			}
		});

		System.out.println("*** After Sort ***");
		// write after sorted
		it = persons.iterator();
		while (it.hasNext()) {
			PersonEx p = it.next();
			System.out.println(p.getName());
		}
	}

	// For Employee
	private static void doSortEmployee() {
		Employee indiaCountry = new Employee(1, "India");
		Employee chinaCountry = new Employee(4, "China");
		Employee nepalCountry = new Employee(3, "Nepal");
		Employee bhutanCountry = new Employee(2, "Bhutan");

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(indiaCountry);
		employees.add(chinaCountry);
		employees.add(nepalCountry);
		employees.add(bhutanCountry);

		System.out.println("Before Sort by Name");
		for (Employee emp : employees)
			System.out.println("EmpId: " + emp.getId() + " || " + "EmpName: " + emp.getName());

		System.out.println("After Sort by Name");
		Collections.sort(employees, new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		});
		for (Employee emp : employees)
			System.out.println("EmpId: " + emp.getId() + " || " + "EmpName: " + emp.getName());
	}

}
