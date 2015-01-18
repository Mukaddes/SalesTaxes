package com.mukaddes;
/**
 * This class to describe specs of product. There are 4 field,
 *  these are its own property
 * @author Mukaddes
 *
 */

public class ProductSpec {
	
	private boolean imported;
	
	private String type;
	
	private double price;
	
	private String name;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
