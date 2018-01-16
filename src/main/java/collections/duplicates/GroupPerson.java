package collections.duplicates;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import model.Person;

public class GroupPerson {
	/**
	 * <p>
	 * Add one-sentence summarising the method functionality here; this sentence should only contain one full-stop.
	 * </p>
	 * 
	 * @param args
	 **/
	public static void main(String[] args) {
		List<Person> persons = getPersons();
		Map<Person, Person> map = Maps.newHashMap();
		for (Person p : persons) {
			if (map.containsKey(p)) {
				Person old = map.get(p);
				Double newX = old.getX() + p.getX();
				Double newY = old.getY() + p.getY();
				old.setX(newX);
				old.setY(newY);

				map.put(old, p);
			} else map.put(p, p);
		}
		printMap1(map);
	}

	private static void printMap1(Map<Person, Person> map) {
		for (Map.Entry<Person, Person> entry : map.entrySet())
			System.out.println("Key: " + entry.getKey());
	}

	private static List<Person> getPersons() {
		Person p1 = new Person(1, "Manh", 10D, 10D);
		Person p2 = new Person(1, "Manh", 10D, 10D);
		Person p3 = new Person(2, "Tam", 5D, 5D);
		Person p4 = new Person(3, "Hoai", 0D, 0D);

		List<Person> persons = Lists.newArrayList(p1, p2, p3, p4);
		return persons;
	}
}
