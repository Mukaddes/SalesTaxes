package com.mukaddes;

import java.util.List;

public class Receipt {
	
	public List products;
	
	private double taxSum;
	
	private double total;
	
	public Receipt(List<Product> pr) {
		products = pr;
	}

	public double getTaxSum() {
		return taxSum;
	}

	public void setTaxSum(double taxSum) {
		this.taxSum = taxSum;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
