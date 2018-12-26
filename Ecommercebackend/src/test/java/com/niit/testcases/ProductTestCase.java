package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;


public class ProductTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		product = (Product)context.getBean("product");
		
	}
	/*
	@Test
	public void createProductTestCase()
	{
		
		product.setId("PROD1");
		product.setCategory_id("CATG1");
		product.setDescription("Diabetic Medicine");
		product.setName("Glimmy1");
		product.setPrice(210);
		product.setQuantity(1);
		product.setSupplier_id("SUPP1");
		
		boolean flag =  productDAO.saveOrUpdate(product);
		assertEquals("createProductTestCase",true,flag);
		
	}
	@Test
	public void updateProductTestCase()
	{
		product.setId("PROD1");
		product.setName("Glimmy2");
		product.setDescription("Diabetic Medicine");
		product.setCategory_id("CATG1");
		product.setPrice(150);
		product.setSupplier_id("SUPP1");
		product.setQuantity(2);
		boolean flag = productDAO.saveOrUpdate(product);
		assertEquals("update Product TestCase",true,flag);
	}
	@Test
	public void listAllProductTestCase()
	{
		int actualSize = productDAO.list().size();
		assertEquals(2, actualSize);
	} */
}