package collections.duplicates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListRetainAll {
	public static void main(String[] args) {
		//// Create two collections:
		// ArrayList al = new ArrayList();
		// LinkedList ll = new LinkedList();
		// ll.add("1");
		// ll.add("2");
		// ll.add("3");
		// ll.add("4");
		// System.out.println("The LinkedList collection before: " + ll);
		// System.out.println("Size of LinkedList :" + ll.size());
		// al.add("1");
		// al.add("2");
		// al.add("3");
		// al.add("4");
		// al.add("5");
		// al.add("6");
		// System.out.println("The ArrayList collection before : " + al);
		// System.out.println("Size of ArrayList :" + al.size());
		//// Delete the elements of ArrayList that are not in LinkedList:
		// boolean b = al.retainAll(ll);
		//// If list get changed return true otherwise false
		// System.out.println("List becomes change :" + b);
		//// Display the collection after:
		// System.out.println("The ArrayList collection after : " + al);
		// System.out.println("Size of ArrayList remains :" + al.size());
		// System.out.println("The LinkedList collection after: " + ll);
		// System.out.println("Size of LinkedList :" + ll.size());

		List<Integer> list1 = new ArrayList<Integer>(Arrays.<Integer>asList(2, 2, 2, 2, 5, 5));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.<Integer>asList(2, 2, 103));
		List<Integer> list3 = new ArrayList<Integer>(Arrays.<Integer>asList(2, 431));
		System.out.println(intersect(list1, intersect(list2, list3)));
	}

	private static <T> Collection<T> intersect(Collection<? extends T> a, Collection<? extends T> b) {
		Collection<T> result = new ArrayList<T>();

		for (T t : a) {
			if (b.remove(t)) result.add(t);
		}

		return result;
	}
}
