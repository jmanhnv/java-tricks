/*
 * FILENAME RentCar.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

package reflections;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

public class RentCar {

	private int rate;
	private String type;
	public int price;

	public RentCar(int length) {
		if (length < 455) {
			type = "small";
			rate = 35;
		} else if ((length >= 455) && (length < 495)) {
			type = "mid-sized";
			rate = 45;
		} else if (length >= 495) {
			type = "large";
			rate = 55;
		}
	}

	public int getRate() {
		return rate;
	}

	public String getType() {
		return type;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void computeRentalCost(int numDays) {
		price = numDays * rate;
		System.out.println("The cost of your rental car is " + price + " euros");
	}
}
