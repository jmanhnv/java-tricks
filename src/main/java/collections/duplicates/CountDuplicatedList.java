package collections.duplicates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CountDuplicatedList {

	/**
	 * <p>
	 * Add one-sentence summarising the method functionality here; this sentence should only contain one full-stop.
	 * </p>
	 * 
	 * @since TODO module version when it was introduced
	 * @param args
	 **/
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add("a");
		list.add("a");

		System.out.println("\nExample 1 - Count 'a' with frequency");
		System.out.println("a: " + Collections.frequency(list, "a"));

		System.out.println("\nExample 2 - Count all with frequency");
		Set<String> uniqueSet = new HashSet<String>(list);
		for (String temp : uniqueSet) {
			System.out.println(temp + ": " + Collections.frequency(list, temp));
		}

		System.out.println("\nExample 3 - Count all with Map");
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (String temp : list) {
			Integer count = map.get(temp);
			map.put(temp, (count == null) ? 1 : count + 1);
		}
		printMap(map);

		System.out.println("\nSorted Map");
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(map);
		printMap(treeMap);

	}

	public static void printMap(Map<String, Integer> map) {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}
	}

	// Output
	//
	// Example 1 - Count 'a' with frequency
	// a: 4
	//
	// Example 2 - Count all with frequency
	// d: 1
	// b: 2
	// c: 2
	// a: 4
	//
	// Example 3 - Count all with Map
	// Key: d Value: 1
	// Key: b Value: 2
	// Key: c Value: 2
	// Key: a Value: 4
	//
	// Sorted Map
	// Key: a Value: 4
	// Key: b Value: 2
	// Key: c Value: 2
	// Key: d Value: 1
}
