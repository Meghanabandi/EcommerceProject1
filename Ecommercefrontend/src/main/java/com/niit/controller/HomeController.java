package com.niit.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.util.FileUtil;

@Controller
public class HomeController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	
	@Autowired
	private HttpSession httpSession;
	
 private static String imageDirectory = "C:\\Users\\NIIT\\git\\ecommerceproject\\Ecommercefrontend\\src\\main\\webapp\\resources\\images";

	
	@GetMapping("/")
	public ModelAndView home(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("home");
		// we need to fetch all the categories
		// Autowire CategoryDAO and category
		List<Category> categories = categoryDAO.list();
		// add the data to mv
		//mv.addObject("categories", categories);
		httpSession.setAttribute("categories", categories);
		httpSession.setAttribute("imageDirectory", imageDirectory);
		String root =request.getContextPath();
	    String imageFolder =  root + File.separator +"src" + File.separator + 
	    		"main" +File.separator +
	    		"webapp"+File.separator +
	    		"resources"+File.separator;	
	    httpSession.setAttribute("imageFolder", imageFolder);
	    //httpSession.getServletContext().getgetContextPath();
	 
		return mv;

	}

	@GetMapping("/loginHear")
	public ModelAndView login() {

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedLogin", true);
		return mv;

	}
	
	@GetMapping("/logout")
	public ModelAndView logout()
	{
		ModelAndView mv = new ModelAndView("home");
		
		httpSession.invalidate();
		
		mv.addObject("logoutMessage", "You are successfully logged out");
		return mv;
		
	}

	@GetMapping("/register")
	public ModelAndView registration() {

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isUserClickedRegister", true);
		return mv;

	}

}
