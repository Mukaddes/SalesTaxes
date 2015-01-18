package com.mukaddes;
/**
 * This class holds product specks, product count and total tax for it
 * @author Mukaddes
 *
 */

public class Product {
	
	//This field separates the product specks from product because 
	//product's tax and product's count is not about product.
	private ProductSpec ps;
	
	private int count;
	
	private double tax ;

	public Product(){
		ps = new ProductSpec();
		tax = 0.0;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ProductSpec getPs() {
		return ps;
	}

	public void setPs(ProductSpec ps) {
		this.ps = ps;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	
}
