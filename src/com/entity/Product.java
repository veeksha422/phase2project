package com.entity;

public class Product {
	private int productId;
	private String productName;
	private String productCategory;
	private String productDescription;
	
	public Product(int productId, String productName, String productCategory, String productDescription) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
	}

	public Product() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		
		return "Product: " + productName + "<br/>" + "Product ID: " + productId + "<br/>" + "Category: " + productCategory + "<br/>" + "Description: " + productDescription;
	}
	
	
}


