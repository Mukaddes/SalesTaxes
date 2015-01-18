package com.mukaddes;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * This class writes the receipt information the standart output.
 * @author Mukaddes
 *
 */

public class ReceiptConsoleWrite implements ReceiptWriter {

	private Receipt receipt;

	private static final Logger log4j = LogManager
			.getLogger(TaxesCalculation.class.getName());


	@Override
	public boolean write(Receipt r) {
		this.receipt = r;
		log4j.info("-----OUTPUT-----");

		String str;

		for (Object o : receipt.products) {
			
			Product pr = (Product)o;			
			double price = pr.getPs().getPrice() + pr.getTax();
			str = pr.getCount() + " " + pr.getPs().getName() + " : " + price;
			log4j.info(str);

		}

		// Taxsum
		double finalValue = Math.round(receipt.getTaxSum() * 20.0) / 20.0;
		String result = String.format("%.2f", finalValue);
		log4j.info("Sales Taxes: " + result);
		// Total
		double total = receipt.getTotal();
		total += receipt.getTaxSum();
		finalValue = Math.round(total * 20.0) / 20.0;
		result = String.format("%.2f", finalValue);		
		log4j.info("Total:" + result);
		
		return true;
	}
}
