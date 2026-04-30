package com.e_commerce.project.category.model;

import org.springframework.web.multipart.MultipartFile;

import com.e_commerce.project.items.additems.AddItems;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)	
private int id;	
private String productName;
private String category;
private String fileImage;
private boolean isActive;
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
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}

public String getFileImage() {
	return fileImage;
}
public void setFileImage(String fileImage) {
	this.fileImage = fileImage;
}
public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Product(int id, String productName, String category, String fileImage, MultipartFile image, boolean isActive,
		String description) {
	super();
	this.id = id;
	this.productName = productName;
	this.category = category;
	this.fileImage = fileImage;

	this.isActive = isActive;
	this.description = description;
}



}
