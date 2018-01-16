/*
 * FILENAME Test.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package commons;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class Test {

	public static void main(String[] args) {
		List<Integer> list = Lists.newArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

		System.err.println("Before size - Iterator: " + list.size());
		System.out.println(list);

		Iterator<Integer> its = list.iterator();
		while (its.hasNext()) {
			Integer i = its.next();
			if (i == 3) its.remove();
		}

		System.err.println("After size - Iterator: " + list.size());
		System.out.println(list);

		System.out.println("*********** Enumeration ************");
		Vector<String> days = new Vector<String>();
		days.add("Monday");
		days.add("Tuesday");
		days.add("Wednesday");
		days.add("Thursday");
		days.add("Friday");
		days.add("Saturday");
		days.add("Sunday");

		Enumeration<String> enums = days.elements();
		while (enums.hasMoreElements())
			System.out.println(enums.nextElement());

		System.err.println("*********** Java Collection ************");

		ArrayList<Integer> arrayList = Lists.newArrayList();
		LinkedList<Integer> linkedList = Lists.newLinkedList();
		HashSet<Integer> hashSet = Sets.newHashSet();
		LinkedHashSet<Integer> linkedHashSet = Sets.newLinkedHashSet();
		TreeSet<Integer> treeSet = Sets.newTreeSet();

		Vector<Integer> vector = new Vector<Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		HashMap<Integer, String> hashMap = Maps.newHashMap();
		TreeMap<Integer, String> treeMap = Maps.newTreeMap();
		WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<Integer, String>();
		LinkedHashMap<Integer, String> linkedHashMap = Maps.newLinkedHashMap();
		IdentityHashMap<Integer, String> identityHashMap = new IdentityHashMap<Integer, String>();
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();

		for (int i = 0; i < 10; i++) {
			arrayList.add(randInt(1, 10));
			linkedList.add(randInt(1, 10));
			hashSet.add(randInt(1, 10));
			linkedHashSet.add(randInt(1, 10));
			treeSet.add(randInt(1, 10));

			vector.add(randInt(1, 10));
			stack.add(randInt(1, 10));

			hashMap.put(i, "HashMap " + i);
			treeMap.put(i, "TreeMap " + i);
			weakHashMap.put(i, "WeakHashMap " + i);
			linkedHashMap.put(i, "LinkedHashMap " + i);
			identityHashMap.put(i, "IdentityHashMap " + i);
			hashtable.put(i, "Hashtable " + i);
		}

		System.out.println("ArrayList: " + arrayList);
		System.err.println("***********");
		System.out.println("LinkedList: " + linkedList);
		System.err.println("***********");
		System.out.println("HashSet: " + hashSet);
		System.err.println("***********");
		System.out.println("LinkedHashSet: " + linkedHashSet);
		System.err.println("***********");
		System.out.println("TreeSet: " + treeSet);
		System.err.println("***********");
		System.out.println("Vector: " + vector);
		System.err.println("***********");
		System.out.println("Stack: " + stack);
		System.err.println("***********");

		for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + " -/- " + entry.getValue());
		}
		System.err.println("***********");

		for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " -/- " + entry.getValue());
		}
		System.err.println("***********");

		for (Map.Entry<Integer, String> entry : weakHashMap.entrySet()) {
			System.out.println(entry.getKey() + " -/- " + entry.getValue());
		}
		System.err.println("***********");

		for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
			System.out.println(entry.getKey() + " -/- " + entry.getValue());
		}
		System.err.println("***********");

		for (Map.Entry<Integer, String> entry : identityHashMap.entrySet()) {
			System.out.println(entry.getKey() + " -/- " + entry.getValue());
		}
		System.err.println("***********");

		for (Map.Entry<Integer, String> entry : hashtable.entrySet()) {
			System.out.println(entry.getKey() + " -/- " + entry.getValue());
		}
		System.err.println("***********");

		testProperties();
	}

	private static void testProperties() {
		Properties capitals = new Properties();
		Set<Object> states;
		String str;

		capitals.put("Illinois", "Springfield");
		capitals.put("Missouri", "Jefferson City");
		capitals.put("Washington", "Olympia");
		capitals.put("California", "Sacramento");
		capitals.put("Indiana", "Indianapolis");

		// Show all states and capitals in hashtable.
		states = capitals.keySet(); // get set-view of keys
		Iterator<Object> itr = states.iterator();
		while (itr.hasNext()) {
			str = (String) itr.next();
			System.out.println("The capital of " + str + " is " + capitals.getProperty(str) + ".");
		}

		System.out.println();

		// look for state not in list -- specify default
		str = capitals.getProperty("Florida", "Not Found");
		System.out.println("The capital of Florida is " + str + ".");
	}

	/**
	 * Returns a pseudo-random number between min and max, inclusive. The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min
	 *            Minimum value
	 * @param max
	 *            Maximum value. Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	private static int randInt(int min, int max) {
		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
}

// Enumeration Iterator
// ---------------- ----------------
// hasMoreElement() hasNext()
// nextElement() next()
// N/A remove()

// Iterators differ from enumerations in two ways:
// Iterators allow the caller to remove elements from the underlying collection
// during the iteration with well-defined semantics.
// Method names have been improved.