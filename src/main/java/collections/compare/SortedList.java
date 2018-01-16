package collections.compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedList {

	/**
	 * <p>
	 * Add one-sentence summarising the method functionality here; this sentence should only contain one full-stop.
	 * </p>
	 * <p>
	 * Add detailed HTML description of method here, including the following, where relevant:
	 * <ul>
	 * <li>Description of what the method does and how it is done.</li>
	 * <li>Details on which error conditions may occur.</li>
	 * </ul>
	 * </p>
	 * 
	 * @since TODO module version when it was introduced
	 * @param args
	 **/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<String> fields = Arrays.asList(new String[] { "None", "Tonn (Tn)", "gram (gm)", "kilogram (kg)",
				"kilolitre (kl)", "litre (ltr)", "meter (m)", "milligram (mg)", "millilitre (ml)", "None", "Tonn (Tn)",
				"gram (gm)", "kilogram (kg)", "kilolitre (kl)", "litre (ltr)", "meter (m)", "milligram (mg)",
				"millilitre (ml)" });
		// Set<String> sets = new TreeSet<String>(fields);
		Collections.sort(fields, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		for (String s : fields)
			System.out.println("+++:" + s);
	}
	// None
	// Tonn (Tn)
	// gram (gm)
	// kilogram (kg)
	// kilolitre (kl)
	// litre (ltr)
	// meter (m)
	// milligram (mg)
	// millilitre (ml)
	// None
	// Tonn (Tn)
	// gram (gm)
	// kilogram (kg)
	// kilolitre (kl)
	// litre (ltr)
	// meter (m)
	// milligram (mg)
	// millilitre (ml)
}
