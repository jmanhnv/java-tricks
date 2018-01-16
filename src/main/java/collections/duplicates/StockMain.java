package collections.duplicates;

import java.math.BigDecimal;
import java.util.Date;

import model.Stock;

public class StockMain {

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
		Stock s1 = new Stock("6758.T", "Tkyo Stock Exchange", 1000, 10, false, new Date(), BigDecimal.valueOf(2200));
		Stock s2 = new Stock("6758.T", "Tokyo Stock Exchange", 1000, 10, false, new Date(), BigDecimal.valueOf(2200));
		Stock s3 = s1;

		System.out.println("Equals result: " + s1.equals(s2));
		System.out.println("HashCode result: " + (s1.hashCode() == s2.hashCode()));

		System.out.println("Equals result: " + s1.equals(s3));
		System.out.println("HashCode result: " + (s1.hashCode() == s3.hashCode()));
	}

}
