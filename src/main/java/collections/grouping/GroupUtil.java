package collections.grouping;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps.EntryTransformer;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;

// http://docs.guava-libraries.googlecode.com/git-history/v10.0.1/javadoc/com/google/common/collect/Multimaps.html#index%28java.lang.Iterable,%20com.google.common.base.Function%29
public final class GroupUtil {

	// http://stackoverflow.com/questions/8463543/grouping-elements-of-a-list-into-sublists-maybe-by-using-guava
	/*
	 * With Java 8, Guava and few helper functions you can implement grouping with custom Comparator
	 */
	// public static <T> Map<T, List<T>> group(List<T> items, Comparator<T>
	// comparator) {
	// ListMultimap<T, T> blocks = LinkedListMultimap.create();
	//
	// if (!ArrayUtils.isNullOrEmpty(items)) {
	// T currentItem = null;
	//
	// for (T item : items) {
	// if (currentItem == null || comparator.compare(currentItem, item) != 0) {
	// currentItem = item;
	// }
	//
	// blocks.put(currentItem, ObjectUtils.clone(item));
	// }
	// }
	//
	// return Multimaps.asMap(blocks);
	// }
	//
	// Comparator<SportExercise> comparator =
	// Comparator.comparingInt(SportExercise::getEstimatedTime)
	// .thenComparingInt(SportExercise::getActiveTime).thenComparingInt(SportExercise::getIntervalCount)
	// .thenComparingLong(SportExercise::getExerciseId);
	// Map<SportExercise, List<SportExercise>> blocks =
	// group(sportWorkout.getTrainingExercises(), comparator);
	// blocks.forEach((key,values)->
	// {
	// System.out.println(key);
	// System.out.println(values);
	// });

	// http://docs.guava-libraries.googlecode.com/git-history/v10.0.1/javadoc/com/google/common/collect/Multimaps.html#index%28java.lang.Iterable,%20com.google.common.base.Function%29
	public static void index() {
		List<String> badGuys = Arrays.asList("Inky", "Blinky", "Pinky", "Pinky", "Clyde");
		Function<String, Integer> stringLengthFunction = new Function<String, Integer>() {
			public Integer apply(String s) {
				return null;
			}
		};
		Multimap<Integer, String> index = Multimaps.index(badGuys, stringLengthFunction);
		System.out.println(index);
	}

	public static void transformEntries() {
		Multimap<String, Integer> multimap = ImmutableMultimap.of("a", 1, "a", 4, "b", 6);
		EntryTransformer<String, Integer, String> transformer = new EntryTransformer<String, Integer, String>() {
			public String transformEntry(String key, Integer value) {
				return key + value;
			}
		};
		Multimap<String, String> transformed = Multimaps.transformEntries(multimap, transformer);
		System.out.println(transformed);
	}

	public static void transformValues() {
		ListMultimap<String, Integer> multimap = ImmutableListMultimap.of("a", 4, "a", 16, "b", 9);
		Function<Integer, Double> sqrt = new Function<Integer, Double>() {
			public Double apply(Integer in) {
				return Math.sqrt((int) in);
			}
		};
		ListMultimap<String, Double> transformed = Multimaps.transformValues(multimap, sqrt);
		System.out.println(transformed);
	}

	public static void transformEntries01() {
		SetMultimap<String, Integer> multimap = ImmutableSetMultimap.of("a", 1, "a", 4, "b", -6);
		EntryTransformer<String, Integer, String> transformer = new EntryTransformer<String, Integer, String>() {
			public String transformEntry(String key, Integer value) {
				return (value >= 0) ? key : "no" + key;
			}
		};
		Multimap<String, String> transformed = Multimaps.transformEntries(multimap, transformer);
		System.out.println(transformed);
	}

	public static void transformValues01() {
		Multimap<String, Integer> multimap = ImmutableSetMultimap.of("a", 2, "b", -3, "b", -3, "a", 4, "c", 6);
		Function<Integer, String> square = new Function<Integer, String>() {
			public String apply(Integer in) {
				return Integer.toString(in * in);
			}
		};
		Multimap<String, String> transformed = Multimaps.transformValues(multimap, square);
		System.out.println(transformed);
	}

	public static void synchronizedMultimap() {
		Multimap<Integer, String> m = Multimaps.synchronizedMultimap(HashMultimap.<Integer, String>create());
		Set<Integer> s = m.keySet(); // Needn't be in synchronized block
		synchronized (m) { // Synchronizing on m, not s!
			Iterator<Integer> i = s.iterator(); // Must be in synchronized block
			while (i.hasNext()) {
				// foo(i.next());
				System.out.println(i.next());
			}
		}
	}
}
