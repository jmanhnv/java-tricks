package collections.grouping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// http://stackoverflow.com/questions/21678430/group-a-list-of-objects-by-an-attribute-java
public class GroupingStudent {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("1726", "John", "New York"));
		students.add(new Student("4321", "Max", "California"));
		students.add(new Student("2234", "Andrew", "Los Angeles"));
		students.add(new Student("5223", "Michael", "New York"));
		students.add(new Student("7765", "Sam", "California"));
		students.add(new Student("3442", "Mark", "New York"));

		// Code to group students by location
		Map<String, List<Student>> map1 = groupByStud_location_01(students);
		System.out.println("******** Way_01 ******");
		print(map1);

		Map<String, List<Student>> map2 = groupByStud_location_02(students);
		System.out.println("******** Way_02 ******");
		print(map2);
	}

	private static Map<String, List<Student>> groupByStud_location_01(List<Student> students) {
		Map<String, List<Student>> map = new HashMap<String, List<Student>>();
		for (Student student : students) {
			// attribute use to group
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

	private static Map<String, List<Student>> groupByStud_location_02(List<Student> students) {
		Map<String, List<Student>> groupedStudents = new HashMap<String, List<Student>>();
		for (Student student : students) {
			String key = student.stud_id;
			if (groupedStudents.get(key) == null) {
				groupedStudents.put(key, new ArrayList<Student>());
			}
			groupedStudents.get(key).add(student);
		}
		return groupedStudents;
	}

	private static void print(Map<String, List<Student>> grouped) {
		Set<String> keySets = grouped.keySet();
		for (String location : keySets) {
			List<Student> students = grouped.get(location);
			for (Student student : students) {
				System.out.println("ID : " + student.stud_id + "\t" + "Name : " + student.stud_name + "\t"
						+ "Location : " + student.stud_location);
			}
		}
	}
}
