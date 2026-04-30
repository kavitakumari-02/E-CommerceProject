package com.e_commerce.project.items.additems;

import com.e_commerce.project.registration.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Cart {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	@ManyToOne
	 private User user;
	@ManyToOne
	 private AddItems addItems;
	 private int quantity;
	 public int getId() {
		 return id;
	 }
	 public void setId(int id) {
		 this.id = id;
	 }
	 public User getUser() {
		 return user;
	 }
	 public void setUser(User user) {
		 this.user = user;
	 }
	 public AddItems getAddItems() {
		 return addItems;
	 }
	 public void setAddItems(AddItems addItems) {
		 this.addItems = addItems;
	 }
	 public int getQuantity() {
		 return quantity;
	 }
	 public void setQuantity(int quantity) {
		 this.quantity = quantity;
	 }
	 public Cart() {
		super();
		// TODO Auto-generated constructor stub
	 }
	 public Cart(int id, User user, AddItems addItems, int quantity) {
		super();
		this.id = id;
		this.user = user;
		this.addItems = addItems;
		this.quantity = quantity;
	 }
	 
}
