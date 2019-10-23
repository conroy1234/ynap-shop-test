package com.ynap.shop.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * this class provides som utility methods that assess in extracting total payment
 */
public class ShopUtil {

	/**
	 * this method allows round  to decimal point as and when required
	 */
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * this method is use to remove the pound sign from the price so that calculation can be performed
	 */
	public static String replacing(String value, String current, String replacement) {
		return value.replaceAll(current, replacement);
	}

	/**
	 * this method is use to split the data into comma separated values
	 */
	public static String[] splitter(String value) {
		return value.split(",");
	}

}
