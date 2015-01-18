package com.mukaddes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
*
* This class writes the receipt information to specified file
* @author Mukaddes
*
*/
public class ReceiptFileWriter implements ReceiptWriter {
	
	private Receipt receipt;
	
	private static final Logger log4j = LogManager
			.getLogger(TaxesCalculation.class.getName());

	@Override
	public boolean write(Receipt r) {
		
		this.receipt = r;
		String str;

		File file = new File("output.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file, false);
			BufferedWriter bWriter = new BufferedWriter(fileWriter);
			bWriter.write("-----OUTPUT----- \n");
			for (Object o : receipt.products) {
				Product pr = (Product)o;
				double price = pr.getPs().getPrice() + pr.getTax();
				str = pr.getCount() + " " + pr.getPs().getName()+ " : " + price;
				bWriter.write(str + "\n");
			}
			
			//Taxsum	
			double finalValue = Math.round( receipt.getTaxSum() * 20.0 ) / 20.0;
			String result = String.format("%.2f", finalValue);
			bWriter.write("Sales Taxes: " + result + "\n");
			
			// Total	
			double total = receipt.getTotal();
			total += receipt.getTaxSum();
		    finalValue = Math.round( total* 20.0 ) / 20.0;
			result = String.format("%.2f", finalValue);
			bWriter.write("Total:" + result );			
			bWriter.flush();
			bWriter.close();
			
		} catch (IOException e) {
			log4j.error(e.getLocalizedMessage());
			return false;
			
		}
		return false;
	}

	


}
