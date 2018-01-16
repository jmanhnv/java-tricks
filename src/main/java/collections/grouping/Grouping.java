package collections.grouping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// http://stackoverflow.com/questions/21678430/group-a-list-of-objects-by-an-attribute-java
public class Grouping {

	public static void main(String[] args) {
		List<Student> studlist = new ArrayList<Student>();
		studlist.add(new Student("1726", "John", "New York"));
		studlist.add(new Student("4321", "Max", "California"));
		studlist.add(new Student("2234", "Andrew", "Los Angeles"));
		studlist.add(new Student("5223", "Michael", "New York"));
		studlist.add(new Student("7765", "Sam", "California"));
		studlist.add(new Student("3442", "Mark", "New York"));

		// Code to group students by location
		// Output should be Like below
		// ID : 1726 Name : John Location : New York
		// ID : 5223 Name : Michael Location : New York
		// ID : 4321 Name : Max Location : California
		// ID : 7765 Name : Sam Location : California

		for (Student student : studlist) {
			System.out.println("ID: " + student.stud_id + "\t" + "Name: " + student.stud_name + "\t" + "Location: "
					+ student.stud_location);
		}

		System.out.println("-------------------");

		// Group students by location
		Map<String, List<Student>> groupedStudents = groupStudents(studlist);
		print(groupedStudents);
	}

	private static Map<String, List<Student>> groupStudents(List<Student> studlist) {
		Map<String, List<Student>> map = new HashMap<String, List<Student>>();
		for (Student student : studlist) {
			String key = student.stud_location;
			if (map.containsKey(key)) {
				List<Student> list = map.get(key);
				list.add(student);
			} else {
				List<Student> list = new ArrayList<Student>();
				list.add(student);
				map.put(key, list);
			}
		}
		return map;
	}

	private static void print(Map<String, List<Student>> groupedStudents) {
		Set<String> groupedStudentsKeySet = groupedStudents.keySet();
		for (String location : groupedStudentsKeySet) {
			List<Student> stdnts = groupedStudents.get(location);
			for (Student student : stdnts) {
				System.out.println("ID: " + student.stud_id + "\t" + "Name: " + student.stud_name + "\t" + "Location: "
						+ student.stud_location);
			}
		}
	}

	// private static void e() {
	// Map<String, Integer> count = new HashMap<String, Integer>();
	// Iterator<RandomObject> i = r.iterator();
	// while (i.hasNext()) {
	// String key = i.next().getName();
	// if (count.containsKey(key)) {
	// int rr = Integer.valueOf(count.get(key));
	// rr++;
	// count.put(key, rr);
	// } else {
	// count.put(key, 1);
	// }
	// }
	// }
}

class Student {
	String stud_id;
	String stud_name;
	String stud_location;

	Student(String sid, String sname, String slocation) {
		this.stud_id = sid;
		this.stud_name = sname;
		this.stud_location = slocation;
	}
}