package com.mukaddes;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class calculates the taxes of given shopping basket and generates a
 * receipt for it
 * 
 * @author Mukaddes
 *
 */
public class TaxesCalculation {

	double taxSum = 0.00;

	double total = 0.00;

	private List<Product> products = new ArrayList<Product>();

	private static final Logger log4j = LogManager
			.getLogger(TaxesCalculation.class.getName());

	public TaxesCalculation(List<Product> pr) {
		this.products = pr;
	}

	public void calculate() {

		double tax = 0.0;
		double rate = 10;
		double rateImportedPrroducts = 5;

		for (Product product : products) {
			String type = product.getPs().getType();
			if (type.equals("goods")) {
				tax = (product.getPs().getPrice() * rate) / 100;
				product.setTax(tax);
				taxSum += tax;

			}
			if (product.getPs().isImported()) {

				tax = (product.getPs().getPrice() * rateImportedPrroducts) / 100;
				product.setTax(product.getTax() + tax);
				taxSum += tax;
				log4j.debug("taxSum:" + taxSum + " tax: " + tax + " price: "
						+ product.getPs().getPrice());
			}

			total += product.getPs().getPrice() * product.getCount();

		}

	}

	public Receipt getResults() {

		Receipt receipt = new Receipt(products);
		receipt.setTaxSum(taxSum);
		receipt.setTotal(total);
		return receipt;
	}

}
