package com.dto;

public class Product {
	private String name;
	private String id;
	private int amount;
	
	public Product(String name, String id, int amount) {
		super();
		this.name = name;
		this.id = id;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}	
}
