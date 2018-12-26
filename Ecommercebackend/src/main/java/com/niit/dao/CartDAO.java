package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDAO {

	
	
public boolean save(Cart cart);
	
	public boolean update(Cart cart);
	
	
	public List<Cart> list(String emailID);
	
	public Cart getCartById(String id);
	
	public boolean delete(String id);
	

	public Cart getCartByName(String name);

}
