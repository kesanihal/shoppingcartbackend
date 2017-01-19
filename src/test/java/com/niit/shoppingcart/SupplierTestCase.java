package com.niit.shoppingcart;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;



public class SupplierTestCase {
	@Autowired
	 static SupplierDAO supplierDAO;
	@Autowired
	 static Supplier supplier;
	
	@Autowired
	static	AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		
		supplier=(Supplier)context.getBean("supplier");
		supplierDAO=(SupplierDAO)context.getBean("supplierDAOImpl");
		
	}
	
	
@Test
	public void saveTestCase()
	{
		supplier.setName("nihal");
		supplier.setAddress("hyd");
		
	Assert.assertEquals("save Test Case",true,supplierDAO.saveOrUpdate(supplier));
	}

	
		

	}
