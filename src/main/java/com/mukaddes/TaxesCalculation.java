package com.mukaddes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaxesCalculation {

	double taxSum = 0.00;

	double total = 0.00;
	
	private List<Product> products = new ArrayList<Product>();

	private static final Logger log4j = LogManager
			.getLogger(TaxesCalculation.class.getName());

	public TaxesCalculation(List<Product> pr){
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
			total += product.getPs().getPrice();

		}
	
	}
	public Receipt getResults( ){
		
		Receipt receipt = new Receipt(products);
		
		receipt.setTaxSum(taxSum);
		receipt.setTotal(total);
		return receipt;
		
		/*
		log4j.debug("-----OUTPUT-----");
		StringBuilder sb = new StringBuilder();
		String str;

		File file = new File("output.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file, false);
			BufferedWriter bWriter = new BufferedWriter(fileWriter);
			bWriter.write("-----OUTPUT----- \n");
			for (Product pr : products) {
				
				double price = pr.getPs().getPrice() + pr.getTax();
				str = pr.getCount() + " " + pr.getPs().getName()+ " : " + price;
				log4j.error(str);
				sb.append(str + "\n");			
			}
			
			//Taxsum	
			double finalValue = Math.round( taxSum * 20.0 ) / 20.0;
			String result = String.format("%.2f", finalValue);
			bWriter.write("Sales Taxes: " + result + "\n");
			
			// Total	
			total += taxSum;
		    finalValue = Math.round( total* 20.0 ) / 20.0;
			result = String.format("%.2f", finalValue);
			bWriter.write("Total:" + result );
			
			
			
			
			bWriter.flush();
			bWriter.close();
		} catch (IOException e) {
			log4j.error(e.getLocalizedMessage());
		}
		
		log4j.error("Sales Taxes: " + taxSum);
		log4j.error("Total:" + total);
		*/
	}

	
}
