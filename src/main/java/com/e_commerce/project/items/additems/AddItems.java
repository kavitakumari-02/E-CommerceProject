package com.e_commerce.project.items.additems;

import com.e_commerce.project.category.model.Product;
import com.e_commerce.project.registration.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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
	@ManyToOne
	private Product product;
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
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public AddItems(int id, String productName, double price, String category, int quantity, String image,
			String description,Product product) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
		this.image = image;
		this.description = description;
		this.product=product;
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
