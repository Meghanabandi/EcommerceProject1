package com.niit.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component  //to create singleton instance
@Entity     //to specify its going to map to table
@Table
public class Cart {
	
	
	
	@Id      //to specify that is primary key
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String emailID;
	private String productName;
	private int price;
	private int quantity;
	@Transient   //we are not going to save /persist this data the table
	private int total;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
