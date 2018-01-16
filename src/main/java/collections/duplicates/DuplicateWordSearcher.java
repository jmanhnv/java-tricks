package collections.duplicates;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateWordSearcher {
	public static void main(final String[] args) {
		String text = "a r b k c d se f g a d f s s f d s ft gh f ws w f v x s g h d h j j k f sd j e wed a d f";
		List<String> list = Arrays.asList(text.split(" "));
		Set<String> uniqueWords = new HashSet<String>(list);
		for (String word : uniqueWords)
			System.out.println(word + ": " + Collections.frequency(list, word));
	}
	// ft: 1
	// f: 7
	// g: 2
	// d: 5
	// e: 1
	// b: 1
	// c: 1
	// a: 3
	// wed: 1
	// sd: 1
	// se: 1
	// j: 3
	// ws: 1
	// k: 2
	// h: 2
	// w: 1
	// v: 1
	// s: 4
	// r: 1
	// gh: 1
	// x: 1
}
