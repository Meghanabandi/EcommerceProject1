package com.niit.testcases;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;



public class UserTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");

		user = (User) context.getBean("user");

	}
	
	@Test
	public void createUserTestCase() {
		user.setEmail("ganeshdhikonda@gmail.com");
		user.setId("ganesh");
		user.setName("ganesh dhikonda");
		user.setPassword("ganesh@123");
		user.setCountry("India");
		user.setAddress("Hyderabad");
		user.setRole("ROLE_ADMIN");
		user.setContact("9550945687");
		boolean flag = userDAO.save(user);

		assertEquals("createUserTestCase", true, flag);

	}
	
	/*@Test
	public void updateUserTestCase() {
		user.setEmail("isaacdv84@gmail.com");
		user.setId("IsaacDV");
		user.setName("Isaac Deva Varam");
		user.setPassword("isaac");
		user.setCountry("India");
		user.setAddress("Hyderabad");
		user.setRole("ROLE_USER");
		user.setContact("9490167876");
		boolean flag = userDAO.update(user);
		assertEquals("updateUserTestCase", true, flag);
	}
	@Test
	public void validateUserTestCase() {
		boolean flag = userDAO.validate("IsaacDV", "isaac");
		assertEquals(true, flag);
	}
	@Test
	public void listAllUserTestCase() {
		int actualSize = userDAO.list().size();
		assertEquals(5, actualSize);
	}*/

}