package com.niit.shoppingcart;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.model.Category;



public class CategoryDAOTestCase {
	@Autowired
	static CategoryDAO categoryDAO;

	@Autowired
	static Category category;

	@Autowired
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();

		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAOImpl");

	}

	@Test
	public void saveTestCase() {
		category.setName("electronis");
		category.setDescription("this is electronis");

		Assert.assertEquals("save Test Case", true, categoryDAO.saveorupdate(category));
	}

}