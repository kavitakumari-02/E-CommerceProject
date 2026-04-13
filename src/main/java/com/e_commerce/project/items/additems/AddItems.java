package com.e_commerce.project.items.additems;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AddItems {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;	
	private String productName;
	private double price;
	private String category;
	private int quantity;
	private String image;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public AddItems(int id, String productName, double price, String category, int quantity, String image,
			String description) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
	}
	public AddItems() {
		super();
		
	}
	@Override
	public String toString() {
		return "AddItems [id=" + id + ", productName=" + productName + ", price=" + price + ", category=" + category
				+ ", quantity=" + quantity + ", image=" + image + ", description=" + description + "]";
	}
	

}
