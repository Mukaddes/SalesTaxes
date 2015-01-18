package com.mukaddes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestSalesTaxes {
	
	private List<Product> products = new ArrayList<Product>();
	
	String filename;
	
	private static final Logger log4j = LogManager.getLogger("Test");
	
	@Test
	public void test() {
		ShoppingBasketReader basketReader = new ShoppingBasketReader();
		filename = "input.txt";
		
		try {
			products = basketReader.read(filename);
		} catch (IOException e) {
			log4j.error(e.getLocalizedMessage());
		}
		
		TaxesCalculation tc = new TaxesCalculation(products);		
		tc.calculate();
		Receipt receipt = tc.getResults();
		
		ReceiptWriter rcw = new ReceiptConsoleWrite(receipt);
		rcw.write();
		ReceiptWriter rfw = new ReceiptFileWriter(receipt);
		rfw.write();
		
	}
}
