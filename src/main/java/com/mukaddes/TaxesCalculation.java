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

	private List<Product> products = new ArrayList<Product>();

	// Keep the input file name
	private String filename = "input.txt";

	double taxSum = 0.00;

	double total = 0.00;

	private static final Logger log4j = LogManager
			.getLogger(TaxesCalculation.class.getName());

	public void inputReader() throws IOException {
		BufferedReader reader;
		File filepath = new File(filename);
		Product pr;
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(
				filepath)));

		String line;
		StringTokenizer st;

		while ((line = reader.readLine()) != null && !line.equals("")) {
			st = new StringTokenizer(line);

			pr = new Product();

			// count
			pr.setCount(Integer.parseInt(st.nextToken()));

			// imported
			if (st.nextToken().equals("imported")) {
				pr.getPs().setImported(true);
			} else {
				pr.getPs().setImported(false);
			}
			// kind
			pr.getPs().setType(st.nextToken());

			// price
			pr.getPs().setPrice(Double.parseDouble(st.nextToken()));

			// name
			pr.getPs().setName(restOfTokens(st));

			log4j.error("---INPUT---");
			log4j.error(pr.getCount() + " " + pr.getPs().getName() + " : "
					+ pr.getPs().getPrice());
			products.add(pr);

		}
		reader.close();

	}

	public void calculate() {

		double tax = 0.0;
		double rate = 10;
		double rateImportedPrroducts = 5;

		log4j.error("---OUTPUT---");

		for (Product product : products) {
			String type = product.getPs().getType();
			if (type.equals("goods")) {
				tax = (product.getPs().getPrice() * rate) / 100;
				product.setTax(tax);
				taxSum += tax;

			}
			if (product.getPs().isImported()) {
				log4j.error("imported olanı buldum");
				tax = (product.getPs().getPrice() * rateImportedPrroducts) / 100;
				product.setTax(product.getTax() + tax);
				taxSum += tax;
				log4j.error("taxSum:" + taxSum + " tax: " + tax + " price: "
						+ product.getPs().getPrice());
			}
			total += product.getPs().getPrice();

		}
	
	}
	public void printResult(){
		
		log4j.debug("-----OUTPUT-----");
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
				bWriter.write(str + "\n");			
			}
			
		
			
			// Total			
		    double finalValue = Math.round( total* 20.0 ) / 20.0;
			String result = String.format("%.2f", finalValue);
			bWriter.write("Total:" + result + "\n");
			
			//Taxsum	
			finalValue = Math.round( taxSum * 20.0 ) / 20.0;
			result = String.format("%.2f", finalValue);
			bWriter.write("Sales Taxes: " + result);
			
			
			bWriter.flush();
			bWriter.close();
		} catch (IOException e) {
			log4j.error(e.getLocalizedMessage());
		}
		
		log4j.error("Sales Taxes: " + taxSum);
		log4j.error("Total:" + total);

	}
	public String restOfTokens(StringTokenizer st) {
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreElements()) {
			String s = (String) st.nextElement();
			sb.append(s);
			sb.append(" ");
		}
		return sb.toString();
	}

}
