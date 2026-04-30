package com.e_commerce.project.registration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
	
@NotEmpty(message="Name must be filled!!")
@Pattern(regexp="^[A-Za-z]*$",message="Name must alphabet")
private String name;

@NotBlank(message="Email must be filled")
@Email(message="Email in must be correct!!")
private String email;

@Pattern(regexp="^[0-9]{10}$",message="phone number must be 10 digits")
@NotBlank(message="PhoneNumber must be filled")
private String phoneNumber;

@Pattern(regexp="^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%&*_-]).{8,}$",message="Character,alphabet,digits must be in the password")
@NotBlank(message="Password must be filed")
private String Password;

@Pattern(regexp="^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%&*_-]).{8,}$",message="Password must be strong")
@NotBlank(message="Password must be filed")
private String confirmPassword;
private String role;


public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int id, String name, String email, String phoneNumber, String password, String confirmPassword,String role) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.Password = password;
	this.confirmPassword = confirmPassword;
	this.role=role;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", Password="
			+ Password + ", confirmPassword=" + confirmPassword + "]";
}


}
