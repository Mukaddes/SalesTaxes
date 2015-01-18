package com.mukaddes;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestSalesTaxes {
	
	private static final Logger log4j = LogManager.getLogger("Test");
	
	@Test
	public void test() {
	    TaxesCalculation tc = new TaxesCalculation();		
		try {
			tc.inputReader();
		} catch (IOException e) {
			log4j.error(e.getLocalizedMessage());
		}
		tc.calculate();
		tc.printResult();
	}

}
