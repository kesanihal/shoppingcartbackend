package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

import junit.framework.Assert;

public class UserDAOTestCase {

	@Autowired
	static UserDAO userDAO;
	
	@Autowired
	static User user;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	//previously we written constructor
	//but in JUnit we need to write a method
	//this method should call automatically when JUnit test case run
	
	@BeforeClass //we can write @BeforeClasses only for the static methods
	
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		user =(User) context.getBean("user");
		
		userDAO=(UserDAO)context.getBean("userDAOImpl");
		
	}
	
	@Test
	public void getUserTestCase(){
		
		user=userDAO.get("niit");
		
		//Assert statements
		
		Assert.assertNotNull("User Test Case",user);
		
		}
	
	@Test
	public void validateCredentials(){
		user=userDAO.validate("niit","niit");
		Assert.assertNotNull("ValidateCredentials",user);
	}
	
	@Test
	public void invalidateCredentials(){
		user=userDAO.validate("niit","niit");
		Assert.assertNull("inValidateCredentials",user);
	}
	
	@Test
	public void getAllUsersTestCase(){
		int size=userDAO.list().size();
		Assert.assertEquals("length check",8,size);
	}
	
	@Test
	public void saveTestCase(){
		
		user.setId("nihal");
		user.setName("");
		user.setContact("");
		user.setMail("");
		user.setPassword("");
		user.setRole("");
		
		Assert.assertEquals("saveTestCase",true,userDAO.save(user));
	}
	
	@Test
	public void updateTestCase(){
		user=new User();
		user.setId("");
		user.setRole("");
		Assert.assertEquals("updateTestCase",true,userDAO.update(user));
		
		
	}
	

}
