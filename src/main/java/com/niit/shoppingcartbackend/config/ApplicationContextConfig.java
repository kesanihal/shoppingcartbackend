package com.niit.shoppingcartbackend.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcartbackend.dao.CartDAO;
import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.CheckoutDAO;
import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.daoimpl.CartDAOImpl;
import com.niit.shoppingcartbackend.daoimpl.CategoryDAOImpl;
import com.niit.shoppingcartbackend.daoimpl.CheckoutDAOImpl;
import com.niit.shoppingcartbackend.daoimpl.ProductDAOImpl;
import com.niit.shoppingcartbackend.daoimpl.SupplierDAOImpl;
import com.niit.shoppingcartbackend.daoimpl.UserDAOImpl;
import com.niit.shoppingcartbackend.model.Cart;
import com.niit.shoppingcartbackend.model.Category;
import com.niit.shoppingcartbackend.model.Checkout;
import com.niit.shoppingcartbackend.model.Product;
import com.niit.shoppingcartbackend.model.Supplier;
import com.niit.shoppingcartbackend.model.User;





@Configuration
@ComponentScan("com.niit.shoppingcartbackend")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/niitdb");
		dataSource.setUsername("nihal");
	    dataSource.setPassword("pass");
		System.out.println("Database is connected.....!");
		return dataSource;

	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;
	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
	    sessionBuilder.addAnnotatedClasses(User.class);
	    sessionBuilder.addAnnotatedClasses(Supplier.class);
	    sessionBuilder.addAnnotatedClasses(Product.class);
	    sessionBuilder.addAnnotatedClasses(Category.class);
	    sessionBuilder.addAnnotatedClasses(Cart.class);
	    sessionBuilder.addAnnotatedClasses(Checkout.class);
		System.out.println("Session is crated......!");
		return sessionBuilder.buildSessionFactory();
		
	}
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction");
		return transactionManager;
	}
	
	
	/*@Autowired
	@Bean(name = "SupplierDAO")
	public SupplierDAO getSupplierDao(SessionFactory sessionFactory) {
			return new SupplierDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "CategoryDAO")
	public CategoryDAO getCategoryDao(SessionFactory sessionFactory){
		return  new CategoryDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "ProductDAO")
	public ProductDAO getProductDao(SessionFactory sessionFactory) {
			return new ProductDAOImpl(sessionFactory);
			
	}
	@Autowired
	@Bean(name = "UserDAO")
	public UserDAO getUserDao(SessionFactory sessionFactory){
		return  new UserDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "CartDAO")
	public CartDAO getCartDao(SessionFactory sessionFactory){
		return  new CartDAOImpl(sessionFactory);
	}
	@Autowired
	@Bean(name = "CheckoutDAO")
	public CheckoutDAO getCheckoutDao(SessionFactory sessionFactory){
		return  new CheckoutDAOImpl(sessionFactory);
	}*/
			}