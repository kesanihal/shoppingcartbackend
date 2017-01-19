package com.niit.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

import junit.framework.Assert;

@SuppressWarnings({ "deprecation", "unused" })
public class UserDAOTestCase {

	@Autowired
	 static  UserDAO userDAO;
	
	@Autowired
	 static User user;
	
	@Autowired
	static	AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.scartbackend");
		context.refresh();
		
		user=(User)context.getBean("user");
		userDAO=(UserDAO)context.getBean("userDAOImpl");
		
	}
	
	@Test
	 public void getUserTestCase()
	 {
	user=	userDAO.get("mukesh");
		Assert.assertEquals("User Test Case","mukesh",user.getUsername());
	 } 
	@Test
	public void getAlluserTestCase()
	{
	int size=	userDAO.list().size();
		Assert.assertEquals("Size Of Table",size, size);
	}
	@Test
	public void  getUserTestCase1()
	{
		user=userDAO.get("mukesh");
		Assert.assertNotNull("Get User Test Case",user);
		
	}
@Test
	public void saveTestCase()
	{
	    user.setMobile("8374047404");
		user.setEmail("pothanamukesh@gmail.com");
		user.setPassword("mukesh");
	    user.setRole("Admin");
	    user.setUsername("mukesh");
	    user.setEnabled(true);
		
	Assert.assertEquals("save Test Case",true,userDAO.saveOrUpdate(user));
	}
/*@Test
 public void upadateTestCase()
 {
	    user.setId("nihal");
	    user.setName("nihal");
		user.setMobile("8886366665");
		user.setEmail("nihal.kesa@gmail.com");
		user.setPassword("nihal");
	    user.setUserName("nihal");
		user.setRole("Admin");
		
		
	Assert.assertEquals("Upadte Test Case",true,userDAO.update(user));
 }*/
@Test
public void validateCredentials()
{
	user=userDAO.validate("mukesh","mukesh");
	Assert.assertNotNull("ValidateCredentials",user);
	}
@Test
public void invalidateCredentials()
{
	user=userDAO.validate("mukesh","niit@13");
	Assert.assertNull("INValidateCredentials",user);
	}

}