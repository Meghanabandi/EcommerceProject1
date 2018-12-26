package com.niit.testcases;

	import static org.junit.Assert.*;

	import org.junit.BeforeClass;
	import org.junit.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Cart;
import com.niit.model.Product;

	

	public class My_CartTestCase {

		@Autowired
		static AnnotationConfigApplicationContext context;

		@Autowired
		Product product;
		
		@Autowired
		ProductDAO productDAO;
		
		@Autowired
		static CartDAO my_CartDAO;
		@Autowired
		static Cart my_Cart;
		
		@BeforeClass
		public static void initialize()
		{
			context = new AnnotationConfigApplicationContext();
			context.scan("com");
			context.refresh();
			
			//get the categoryDAO from context
			my_CartDAO =  (CartDAO) context.getBean("my_CartDAO");
			
			//get the category from context
			my_Cart = (Cart)context.getBean("my_Cart");
			
		}
		
		/*@Test
		public void createCartTestCase() {
			my_Cart.setUser_id("IsaacDV");
			my_Cart.setPrice(210);
			my_Cart.setProduct_name("Glimmy 2");
			
			boolean flag = my_CartDAO.save(my_Cart);
			
			assertEquals("createCartTestCase",true,flag);
		}
		
		@Test
		public void deleteCartTestCase(){
			boolean flag = my_CartDAO.deleteAllProductsInCart("IsaacDV");
			
			assertEquals(true, flag);
		}
		
	*/
	}

