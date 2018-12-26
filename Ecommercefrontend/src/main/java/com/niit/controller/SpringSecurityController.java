package com.niit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDAO;
import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;



@Controller
public class SpringSecurityController {

	public static Logger log = LoggerFactory.getLogger(SpringSecurityController.class);

	@Autowired
	private HttpSession session;

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private Category category;

	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	private Supplier supplier;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Product product;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private Cart myCart;

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.debug("Starting of the method loginError");
		session.setAttribute("errorLoginMessage", "Invalid Credentials.  Please try again.");
		log.debug("Ending of the method loginError");
		return "redirect:/Login";

	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page");

		log.debug("Ending of the method accessDenied");
		return "Home";

	}

	@RequestMapping(value = "/checkRole", method = RequestMethod.GET)
	public ModelAndView checkRole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("starting of the method validate");
		ModelAndView mv = new ModelAndView("Home");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		mv.addObject("categoryList", categoryDAO.list());
		mv.addObject("category", category);

		mv.addObject("supplierList", supplierDAO.list());
		mv.addObject("supplier", supplier);
		
		mv.addObject("productList", productDAO.list());
		mv.addObject("product", product);
		
		
		String userID = auth.getName();
		session.setAttribute("loggedInUser", userID);
		session.setAttribute("loggedInUserID", userID);

		if (request.isUserInRole("ROLE_ADMIN")) {
			log.debug("You are admin");
			mv.addObject("isAdmin", "true");
			session.setAttribute("role", "ROLE_ADMIN");
			session.setAttribute("isAdmin", true);
			mv.addObject("isUserAtHomePage", "false");

		} else {

			log.debug("You are a customer");
			session.setAttribute("isAdmin", false);
			session.setAttribute("isUserLoggedIn", "true");
			session.setAttribute("myCart", myCart);
			mv.addObject("isAdmin", "false");
			session.setAttribute("role", "ROLE_USER");
			session.setAttribute("isUserLoggedIn", "true");
			session.setAttribute("loggedInUserID",userID);
			String loggedInUserID = (String) session.getAttribute("loggedInUserID");
			int cartSize = cartDAO.list(loggedInUserID).size();
			session.setAttribute("cartSize", cartSize);
			mv.addObject("isUserAtHomePage", "true");
			

		}
		String loggedInUserID = (String) session.getAttribute("loggedInUserID");
		mv.addObject("Username", loggedInUserID);
		log.debug("Ending of the method validate");
		return mv;
	}

	@RequestMapping("/secure_logout")
	public ModelAndView secureLogout() {
		
		session.invalidate();

		ModelAndView mv = new ModelAndView("redirect:/Login");

		

		session.setAttribute("category", category); // domain object names
		session.setAttribute("product", product);
		session.setAttribute("supplier", supplier);

		session.setAttribute("categoryList", categoryDAO.list());

		session.setAttribute("supplierList", supplierDAO.list());

		session.setAttribute("productList", productDAO.list());

		return mv;

	}

}