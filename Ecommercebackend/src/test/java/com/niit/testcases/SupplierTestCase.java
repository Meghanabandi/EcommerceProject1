package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;


public class SupplierTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static SupplierDAO supplierDAO;
	@Autowired
	static Supplier supplier;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		
		supplier = (Supplier) context.getBean("supplier");

	}

	/*@Test
	public void createSupplierTestCase() {
		supplier.setId("SUPP1");
		supplier.setName("Apollo");
		supplier.setAddress("Lingampally");
		boolean flag = supplierDAO.save(supplier);
		assertEquals("createSupplierTestCase", true, flag);
	}
	@Test
	public void updateSupplierTestCase() {
		supplier.setId("SUPP1");
		supplier.setName("MedPlus+");
		supplier.setAddress("Chandanagar");
		boolean flag = supplierDAO.update(supplier);
		assertEquals("updateSupplierTestCase", true, flag);
	}
	@Test
	public void listAllSupplierTestCase() {
		int actualSize = supplierDAO.list().size();
		assertEquals(6, actualSize);
	}*/

}