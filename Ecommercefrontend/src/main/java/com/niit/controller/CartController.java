package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDAO;
import com.niit.model.Cart;



@Controller
public class CartController {

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private Cart cart;

	@Autowired
	private HttpSession session;

	@PostMapping("/cart/add")
	public ModelAndView addToCart(@RequestParam String productName, @RequestParam int price,
			@RequestParam int quantity) {

		ModelAndView mv = new ModelAndView("home");
		String loggedInUser = (String) session.getAttribute("loggedInUserID");
		if (loggedInUser == null) {
			mv.addObject("error Message", "Please login to add any product to cart");
			return mv;
		}

		cart.setEmailID(loggedInUser);
		cart.setPrice(price);
		cart.setQuantity(quantity);
		if (cartDAO.save(cart)) {
			mv.addObject("success Message", "product added to cart successfully");
		} else {
			mv.addObject("error Message", "could not add the to cart,please try again");
		}
		return mv;
	}

	// to get cart details
	@GetMapping("/mycart/")
	public ModelAndView getMyCartDetails()
	{
		//it will return all the products which are added to cart
		//??
		ModelAndView mv = new ModelAndView("home");
		String loggedInUser = (String) session.getAttribute("loggedInUserID");
		if (loggedInUser == null) {
			mv.addObject("error Message", "Please login to see your cart details ");
			return mv;
		}
		List <Cart> cartList=cartDAO.list(loggedInUser);
		mv.addObject("cartList",cartList);
		return mv;
	}

}