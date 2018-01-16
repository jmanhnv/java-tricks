package model;

import java.math.BigDecimal;
import java.util.Date;

/*
 * FILENAME Stock.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2007 Genix Ventures Pty. Ltd. All rights reserved. This software is the confidential and proprietary information of
 * Genix Ventures ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with Genix Ventures.
 */

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

// http://javarevisited.blogspot.com/2011/10/override-hashcode-in-java-example.html#ixzz33a3Ayn8h
// http://javarevisited.blogspot.com/2011/10/override-hashcode-in-java-example.html v
public class Stock {
	private String symbol;
	private String exchange;
	private long lotSize;
	private int tickSize;
	private boolean isRestricted;
	private Date settlementDate;
	private BigDecimal price;

	public Stock() {
		super();
	}

	public Stock(String symbol, String exchange, long lotSize, int tickSize, boolean isRestricted, Date settlementDate,
			BigDecimal price) {
		this.symbol = symbol;
		this.exchange = exchange;
		this.lotSize = lotSize;
		this.tickSize = tickSize;
		this.isRestricted = isRestricted;
		this.settlementDate = settlementDate;
		this.price = price;
	}

	@Override
	public int hashCode() {
		// HashCodeBuilder builder = new HashCodeBuilder();
		// builder.append(symbol);
		// builder.append(exchange);
		// builder.append(lotSize);
		// builder.append(tickSize);
		// builder.append(isRestricted);
		// builder.append(settlementDate);
		// builder.append(price);
		// return builder.toHashCode();

		final int prime = 31;
		int result = 1;
		result = prime * result + ((exchange == null) ? 0 : exchange.hashCode());
		result = prime * result + (isRestricted ? 1231 : 1237);
		result = prime * result + (int) (lotSize ^ (lotSize >>> 32));
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((settlementDate == null) ? 0 : settlementDate.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + tickSize;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// if (obj instanceof Stock)
		// {
		// EqualsBuilder builder = new EqualsBuilder();
		// Stock other = (Stock) obj;
		// builder.append(this.symbol, other.symbol);
		// builder.append(this.exchange, other.exchange);
		// builder.append(this.lotSize, other.lotSize);
		// builder.append(this.tickSize, other.tickSize);
		// builder.append(this.isRestricted, other.isRestricted);
		// builder.append(this.settlementDate, other.settlementDate);
		// builder.append(this.price, other.price);
		// return builder.isEquals();
		// }
		// return false;

		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) { return false; }
		Stock other = (Stock) obj;

		return this.tickSize == other.tickSize && this.lotSize == other.lotSize
				&& this.isRestricted == other.isRestricted
				&& (this.symbol == other.symbol || (this.symbol != null && this.symbol.equals(other.symbol)))
				&& (this.exchange == other.exchange || (this.exchange != null && this.exchange.equals(other.exchange)))
				&& (this.settlementDate == other.settlementDate
						|| (this.settlementDate != null && this.settlementDate.equals(other.settlementDate)))
				&& (this.price == other.price || (this.price != null && this.price.equals(other.price)));
	}

}
